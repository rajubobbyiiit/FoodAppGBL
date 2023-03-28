package app.food.controller;

import java.util.List;

import app.food.models.CostBracket;
import app.food.models.Cuisine;
import app.food.models.Restaurant;
import app.food.service.RestaurantService;

public class RestaurantController {
	private RestaurantService restaurantService;


	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	public void addRestaurant(Cuisine cuisine, CostBracket costBracket, float rating, boolean isRecommended){
		this.restaurantService.addRestaurant(cuisine, costBracket, rating, isRecommended);
	}


	public List<Restaurant> getAvailableRestaurants(){
		return this.restaurantService.getAvailableRestaurants();
	}
}
