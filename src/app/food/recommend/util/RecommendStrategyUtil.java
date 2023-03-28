package app.food.recommend.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import app.food.models.CostBracket;
import app.food.models.Cuisine;
import app.food.models.Restaurant;

public class RecommendStrategyUtil {
	public static List<Restaurant> filterByCuisineCostLowRating(List<Restaurant> restaurants, Cuisine cuisine, CostBracket costBracket, float rating) {
		if(cuisine!=null &&restaurants!=null && !restaurants.isEmpty( ) && costBracket!=null ) 	
		return  restaurants.stream()
				.filter(Objects::nonNull)
				.filter(restaurant -> restaurant.isRecommended()&&restaurant.getCuisine().equals(cuisine) 
						&& restaurant.getCostBracket().equals(costBracket) 
						&& restaurant.getRating() < rating )
		          .collect(Collectors.toList());
		return new ArrayList<>();
	}
	
	public static List<Restaurant> filterByCuisineCostHightRating(List<Restaurant> restaurants, Cuisine cuisine, CostBracket costBracket, float rating) {
		
		if(cuisine!=null &&restaurants!=null && !restaurants.isEmpty( ) && costBracket!=null ) 
			return  restaurants.stream()
				.filter(Objects::nonNull)
				.filter(restaurant -> restaurant.isRecommended()&& restaurant.getCuisine().equals(cuisine) 
						&& restaurant.getCostBracket().equals(costBracket) 
						&& restaurant.getRating() >= rating )
				.collect(Collectors.toList());
		return new ArrayList<>();
	}
}

