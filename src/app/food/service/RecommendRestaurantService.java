package app.food.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import app.food.models.Restaurant;
import app.food.models.User;
import app.food.recommend.strategies.RecommendStrategy;

public class RecommendRestaurantService {
	
	private int limit;
	private List<RecommendStrategy> strategies;
	private RestaurantService restaurantService;
	private UserService userService;

	public RecommendRestaurantService(RestaurantService restaurantService, UserService userService) {
		limit = 0;
		strategies = new ArrayList<>();
		this.restaurantService = restaurantService;
		this.userService = userService;
	}


	public void addRecommendationStrategies(List<RecommendStrategy> recommendationStrategies) {
		this.strategies.addAll(recommendationStrategies);
	}


	public void setRestaurantsLimit(int limit) {
		this.limit = limit;
	}


	public List<Restaurant> getRestrantRecommendationsByUserId(String userId){
		User user = userService.getUserById(userId);
		List<Restaurant> restaurants = restaurantService.getAvailableRestaurants();
		Set<Restaurant> restaurantRecommendations = new LinkedHashSet<>();
		for (RecommendStrategy recommendationStrategy : strategies){
			if (restaurantRecommendations.size() > limit){
				return restaurantRecommendations.stream().collect(Collectors.toList());
			}
			List<Restaurant> recommendedRestaurants = recommendationStrategy.recommendRestaurants(restaurants, user);
			restaurantRecommendations.addAll(recommendedRestaurants);
		}
		return  restaurantRecommendations.stream().limit(limit).collect(Collectors.toList());
	}
}
