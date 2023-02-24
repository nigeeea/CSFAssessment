package vttp2022.csf.assessment.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp2022.csf.assessment.server.services.RestaurantService;

@RestController
@RequestMapping(path = "/api")
public class RestaurantRestController {

    @Autowired
    private RestaurantService restaurantSvc;


    @GetMapping(path = "/cuisines")
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



    
}
