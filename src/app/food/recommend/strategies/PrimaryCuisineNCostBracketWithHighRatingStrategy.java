package app.food.recommend.strategies;

import java.util.List;

import app.food.models.Restaurant;
import app.food.models.User;
import app.food.recommend.util.RecommendStrategyUtil;

public class PrimaryCuisineNCostBracketWithHighRatingStrategy implements RecommendStrategy{
	
	private static final float rating = 4;
	
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user){
		return  RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getPrimaryCuisine(),user.getPrimaryCostBracket(),rating);
	}
}
