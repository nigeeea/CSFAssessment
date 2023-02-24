package vttp2022.csf.assessment.server.models;

import org.bson.Document;

// Do not modify this class
public class Restaurant {
	
	private String restaurantId;
	private String name;
	private String cuisine;
	private String address;
	private LatLng coordinates;
	private String mapUrl;

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return this.cuisine;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setCoordinates(LatLng coordinates) {
		this.coordinates = coordinates;
	}
	public LatLng getCoordinates() {
		return this.coordinates;
	}

	public void setMapURL(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getMapURL() {
		return this.mapUrl;
	}


	//method to turn Document into Restaurant object
	public static Restaurant docToRestaurant(Document d){
		Restaurant r = new Restaurant();
		
		r.setCuisine(d.getString("cuisine"));
		r.setName(d.getString("name"));
		r.setRestaurantId(d.getString("restaurant_id"));
		r.setAddress(
			d.get("address").toString()
		);

		// Document doc = d.get("address");
		//r.setAddress(d.getString("address"));

		return r;
	}
}
