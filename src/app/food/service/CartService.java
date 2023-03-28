package app.food.service;

import app.food.models.Restaurant;

public class CartService {
	private UserService userService;
	private RestaurantService restaurantService;


	public CartService(UserService userService, RestaurantService restaurantService) {
		this.userService = userService;
		this.restaurantService = restaurantService;
	}


	public void order(String userId, String restaurantId){
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		userService.updateUserPrefrncsForCuisineNCost(userId, restaurant.getCuisine(), restaurant.getCostBracket());
	}
}
