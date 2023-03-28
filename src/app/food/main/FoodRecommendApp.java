package app.food.main;
import java.util.ArrayList;
import java.util.List;

import app.food.controller.CartController;
import app.food.controller.RecommendRestaurantController;
import app.food.controller.RestaurantController;
import app.food.controller.UserController;
import app.food.models.CostBracket;
import app.food.models.Cuisine;
import app.food.models.Restaurant;
import app.food.recommend.strategies.FeaturedRecommendRestaurantsStrategy;
import app.food.recommend.strategies.NoFilterAllRestarntsStrategy;
import app.food.recommend.strategies.PrimaryCuisineAndCostBracketWithLowRatingStrategy;
import app.food.recommend.strategies.PrimaryCuisineNCostBracketWithHighRatingStrategy;
import app.food.recommend.strategies.PrimaryCuisineNSecondaryCostBracketWithHighRatingStrategy;
import app.food.recommend.strategies.PrimaryCuisineNSecondaryCostBracketWithLowRatingStrategy;
import app.food.recommend.strategies.RecommendStrategy;
import app.food.recommend.strategies.SecondaryCuisineNPrimaryCostBracketWithHighRatingStrategy;
import app.food.recommend.strategies.SecondaryCuisineNPrimaryCostBracketWithLowRatingStrategy;
import app.food.recommend.strategies.TopFewNewRestrntsStrategy;
import app.food.service.CartService;
import app.food.service.RecommendRestaurantService;
import app.food.service.RestaurantService;
import app.food.service.UserService;


public class FoodRecommendApp {
	public static void main(String[] args) throws InterruptedException {
		
		//create and add a user
		UserService userService = new UserService();
		UserController userController = new UserController(userService);
		String userId = userController.addUser();

		//add some restaurants
		RestaurantService restaurantService = new RestaurantService();
		RestaurantController restaurantController = new RestaurantController(restaurantService);
		addRestaurantsToFoodApp(restaurantController);
		List<Restaurant> allAvailableRestaurants = restaurantController.getAvailableRestaurants();


		//User orders on each restaurant
		CartService cartService = new CartService(userService, restaurantService);
		CartController orderController = new CartController(cartService);
		for (Restaurant restaurant : allAvailableRestaurants){
			orderController.addToCart(userId, restaurant.getId());
		}

		//recommend restaurants to the user
		RecommendRestaurantService restaurantRecommendationService = new RecommendRestaurantService(restaurantService, userService);
		RecommendRestaurantController restaurantRecommendationController = new RecommendRestaurantController(restaurantRecommendationService);
		restaurantRecommendationController.setRestaurantsLimit(10);
		List<RecommendStrategy> restaurantRecommendationStrategyList = updateOurRecommendStrategies();

		restaurantRecommendationController.addRecommendationStrategies(restaurantRecommendationStrategyList);

		List<Restaurant> recommendations = restaurantRecommendationController.getRecommendationsByUserId(userId);
		for (Restaurant recommendation : recommendations){
			System.out.println("output recommendations: "+ recommendation);
		}
	}

	private static List<RecommendStrategy> updateOurRecommendStrategies() {
		List<RecommendStrategy> stategies = new ArrayList<>();
		stategies.add(new FeaturedRecommendRestaurantsStrategy());
		stategies.add(new PrimaryCuisineNCostBracketWithHighRatingStrategy());
		stategies.add(new PrimaryCuisineNSecondaryCostBracketWithHighRatingStrategy());
		stategies.add(new SecondaryCuisineNPrimaryCostBracketWithHighRatingStrategy());
		stategies.add(new TopFewNewRestrntsStrategy());
		stategies.add(new PrimaryCuisineAndCostBracketWithLowRatingStrategy());
		stategies.add(new PrimaryCuisineNSecondaryCostBracketWithLowRatingStrategy());
		stategies.add(new SecondaryCuisineNPrimaryCostBracketWithLowRatingStrategy());
		stategies.add(new NoFilterAllRestarntsStrategy());
		return stategies;
	}
	

	private static void addRestaurantsToFoodApp(RestaurantController restaurantController) throws InterruptedException {
		restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, CostBracket.MEDIOCRE, 5, true);
		restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, CostBracket.CHEAP, 5, true);
		restaurantController.addRestaurant(Cuisine.CHINESE, CostBracket.COSTLY, 3, true);
		restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, CostBracket.MEDIOCRE, 5, true);
		restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, CostBracket.CHEAP, 5, true);
		restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, CostBracket.COSTLY, 3, true);
		restaurantController.addRestaurant(Cuisine.CHINESE, CostBracket.COSTLY, 5, true);
		restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, CostBracket.CHEAP, 5, true);
		restaurantController.addRestaurant(Cuisine.CHINESE, CostBracket.MEDIOCRE, 3, true);
		restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, CostBracket.COSTLY, 5, true);
		restaurantController.addRestaurant(Cuisine.CHINESE, CostBracket.CHEAP, 5, true);
		restaurantController.addRestaurant(Cuisine.CHINESE, CostBracket.COSTLY, 3, false);
		
	}


	
}
