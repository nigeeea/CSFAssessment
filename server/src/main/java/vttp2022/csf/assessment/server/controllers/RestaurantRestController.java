package vttp2022.csf.assessment.server.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

@RestController
@RequestMapping(path = "/api")
public class RestaurantRestController {

    @Autowired
    private RestaurantService restaurantSvc;


    @GetMapping(path = "/getcuisines")
    public ResponseEntity<String> getCuisines(){

        List<String> cuisinesList = restaurantSvc.getCuisines();
       
        //create a jsonarray to store each string in the list
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for(String cuisine: cuisinesList){
            cuisine = cuisine.replaceAll("/", "_");
            arrayBuilder.add(cuisine);
        }

        JsonArray cuisineArray = arrayBuilder.build();

        return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cuisineArray.toString());
    }

    @GetMapping(path = "/getRestaurantsByCuisine")
    public ResponseEntity<String> getRestaurantsByCuisine(
        @RequestParam String cuisine
        ){

            List<Restaurant> restList = restaurantSvc.getRestaurantsByCuisine(cuisine);

            List<String> newList = new ArrayList<>();

            

            for(Restaurant r: restList){
                newList.add(r.getName().replaceAll("/", "_"));
            }

            //sort the list
            Collections.sort(newList);

            //convert newList into json array
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for(String name: newList){
                arrayBuilder.add(name);
            }

            JsonArray response = arrayBuilder.build();

            return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(response.toString());
        }

        @GetMapping(path = "/getRestaurantDetailsByRestaurantName")
        public ResponseEntity<String> getRestaurantDetailsByRestaurantName(
            @RequestParam String restaurantName
        ){

            Optional<Restaurant> opt = restaurantSvc.getRestaurantDetailsByRestaurantName(restaurantName);

            if(opt.isEmpty()){
                JsonObjectBuilder objBuilder = Json.createObjectBuilder();

                JsonObject error = objBuilder.add("Restaurant not found", restaurantName).build();
			                        
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
					                .body(error.toString());
            }
            else{

                //get the value from the opt
                Restaurant r = opt.get();
                
                //create a json and dump the info inside
                JsonObjectBuilder objBuilder = Json.createObjectBuilder();

                JsonObject response = objBuilder.add("name", r.getName())
                                            .add("cuisine", r.getCuisine())
                                            .add("id",r.getRestaurantId())
                                            .add("address", r.getAddress())
                                            .build();



            return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(response.toString());
            }


        }

        @PostMapping(path = "/postComment")
        public ResponseEntity<String> postComment(
            @RequestParam String name,
            @RequestParam int rating,
            @RequestParam String restaurantId,
            @RequestParam String text
        ){

           //turn the params into a json to simulate receiving a json
            JsonObject pseudoObject = Json.createObjectBuilder()
                                            .add("name", name)
                                            .add("rating",rating)
                                            .add("restaurantId",restaurantId)
                                            .add("text", text)
                                            .build();

           //turn json into a comment object to pass to service and repo
            Comment c = Comment.fromJsonToComment(pseudoObject);

            try {
                restaurantSvc.addComment(c);

                JsonObject response = Json.createObjectBuilder().add("message", "Comment posted").build();

                return ResponseEntity.status(201)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(response.toString());

            } catch (Exception e) {

                JsonObject response = Json.createObjectBuilder().add("error",e.toString()).build();

                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(response.toString());

            }

        }


    
}
