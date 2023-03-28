package app.food.recommend.strategies;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import app.food.models.Restaurant;
import app.food.models.User;

public class TopFewNewRestrntsStrategy implements RecommendStrategy{
	
	private static final int top4 = 4;//top 4 
	
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user) {
		return  restaurants.stream()
				.filter(Objects::nonNull)
				.filter(restaurant ->restaurant.isRecommended())
				.sorted(Comparator.comparing(Restaurant::getOnboardedTime)
		          .thenComparing(Restaurant::getRating).reversed())
				.limit(top4)
				.collect(Collectors.toList());
	}
}
