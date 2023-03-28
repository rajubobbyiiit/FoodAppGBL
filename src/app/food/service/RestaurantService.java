package app.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.food.models.CostBracket;
import app.food.models.Cuisine;
import app.food.models.Restaurant;

public class RestaurantService {
	private Map<String, Restaurant> restaurants;

	public RestaurantService() {
		this.restaurants = new HashMap<>();
	}

	public void addRestaurant(Cuisine cuisine, CostBracket costBracket, float rating, boolean isRecommended){
		Restaurant restaurant = new Restaurant(cuisine, costBracket, rating, isRecommended);
		restaurants.put(restaurant.getId(), restaurant);
	}

	public Restaurant getRestaurantById(String id){
		return restaurants.get(id);
	}

	public List<Restaurant> getAvailableRestaurants() {
		return restaurants.values().stream().collect(Collectors.toList());
	}
}
