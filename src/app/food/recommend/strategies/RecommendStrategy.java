package app.food.recommend.strategies;

import java.util.List;

import app.food.models.Restaurant;
import app.food.models.User;

public interface RecommendStrategy {

	List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user);

}
