package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Item {
	private String itemId;
	private String name;
	private double rating;
	private String address;
	private Set<String> categories;
	private String imageUrl;
	private String url;
	private double distance;
	
	public Item(ItemBuilder builder) {
		this.itemId = builder.itemId;
		this.name = builder.name;
		this.rating = builder.rating;
		this.address = builder.address;
		this.categories = builder.categories;
		this.imageUrl = builder.imageUrl;
		this.url = builder.url;
		this.distance = builder.distance;
		
	}
	// using constructor? too much fields, order may go wrong.
	// builder pattern: if an object has too many fields, may consider using pattern. 
	// if users add more fields to the object, they do not need to modify the existing constructor if there are any(not recommended)
	// they will add the fields and the related methods.
	// constructor may only have two parameters or three parameters. users get confused about which constructor to use
	
	public String getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getAddress() {
		return address;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public double getDistance() {
		return distance;
	}
	

	
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		try {
			object.put("item_id", itemId);
			object.put("name", name);
			object.put("rating", rating);
			object.put("address", address);
			object.put("categories", new JSONArray(categories)); 
			object.put("image_url", imageUrl);
			object.put("url", url);
			object.put("distance", distance);
		} catch (JSONException e) { // catch detailed exception
			e.printStackTrace();
		}
		return object;
	}



	// static nested class
	// cannot access variables from class Item
	// static nested class can only access the static variables from the outer class and thus we need to copy all the fields;
	// cannot change after build. no setters provided (NEEDS: do not want users to change after it is created. 
	// so no setters. we do not want user a and user b see different information after change. features based on needs)
	
	// inner class is "public class ItemBuilder"
	// instantiate an inner class has to call outer class first
	public static class ItemBuilder {
		private String itemId;
		private String name;
		private double rating; 
		private String address;
		private Set<String> categories;
		private String imageUrl;
		private String url;
		private double distance;
		
		public ItemBuilder setItemId(String itemId) {
			this.itemId = itemId;
			return this;
		}
		public ItemBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public ItemBuilder setRating(double rating) {
			this.rating = rating;
			return this;
		}
		public ItemBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		public ItemBuilder setCategories(Set<String> categories) {
			this.categories = categories;
			return this;
		}
		public ItemBuilder setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}
		public ItemBuilder setUrl(String url) {
			this.url = url;
			return this;
		}
		public ItemBuilder setDistance(double distance) {
			this.distance = distance;
			return this;
		}
		
		public Item build() {
			return new Item(this);
		}
		
		
	}
	
	public static void main(String[] args) {
		ItemBuilder builder = new ItemBuilder();
		Item item = builder.setImageUrl("").setAddress("").build();
	}
}
