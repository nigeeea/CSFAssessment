package vttp2022.csf.assessment.server.models;

import jakarta.json.JsonObject;

// Do not modify this class
public class Comment {
	private String name;
	private int rating;
	private String restaurantId;
	private String text;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return this.rating;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}


	//from json to comment
	public static Comment fromJsonToComment(JsonObject pseudoObject){
		Comment c = new Comment();

		c.setName(pseudoObject.getString("name"));
		c.setRating(pseudoObject.getInt("rating"));
		c.setRestaurantId(pseudoObject.getString("restaurantId"));
		c.setText(pseudoObject.getString("text"));

		return c;
	}
}
