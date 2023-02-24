package vttp2022.csf.assessment.server.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.kms.model.ListKeyPoliciesRequest;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	@Autowired MongoTemplate mongoTemplate;

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//

	//db.restaurants.distinct("cuisine")
	public List<String> getCuisines() {
		
		DistinctIterable<String> iterable = mongoTemplate
		.getCollection("restaurants").distinct("cuisine", String.class);
		
		List<String> list = new ArrayList<>();
		// MongoCursor<String> cursor = iterable.iterator();
		// while (cursor.hasNext()) {
    	// list.add(cursor.next()); }

		for(String str : iterable) { list.add(str); }

		return list;
 }


		
	

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//  

	// public ??? getRestaurantsByCuisine(???) {
	// 	// Implmementation in here

	// }

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  

	// public Optional<Restaurant> getRestaurant(???) {
	// 	// Implmementation in here
		
	// }

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//

	// public void addComment(Comment comment) {
	// 	// Implmementation in here
		
	// }
	
	// You may add other methods to this class

}
