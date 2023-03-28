package app.food.recommend.strategies;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import app.food.models.Restaurant;
import app.food.models.User;

public class NoFilterAllRestarntsStrategy implements RecommendStrategy{
	
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants,User user) {
		return  restaurants.stream()
				.filter(Objects::nonNull)
				.filter(restaurant -> restaurant.isRecommended())
				.collect(Collectors.toList());
	}
}
