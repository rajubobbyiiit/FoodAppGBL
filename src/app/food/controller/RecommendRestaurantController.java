package app.food.controller;

import java.util.List;

import app.food.models.Restaurant;
import app.food.recommend.strategies.RecommendStrategy;
import app.food.service.RecommendRestaurantService;

public class RecommendRestaurantController {

	private RecommendRestaurantService recommendRestaurantService;

	public RecommendRestaurantController(RecommendRestaurantService restaurantRecommendationService) {
		this.recommendRestaurantService = restaurantRecommendationService;
	}

	public List<Restaurant> getRecommendationsByUserId(String userId){
		return this.recommendRestaurantService.getRestrantRecommendationsByUserId(userId);
	}

	public void setRestaurantsLimit(int size){
		this.recommendRestaurantService.setRestaurantsLimit(size);
	}

	public void addRecommendationStrategies(List<RecommendStrategy> recommendationStrategies) {
		this.recommendRestaurantService.addRecommendationStrategies(recommendationStrategies);
	}


}
