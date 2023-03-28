package app.food.recommend.strategies;

import java.util.List;

import app.food.models.Restaurant;
import app.food.models.User;
import app.food.recommend.util.RecommendStrategyUtil;

public class SecondaryCuisineNPrimaryCostBracketWithLowRatingStrategy implements RecommendStrategy{
	private static final float rating = 4.5F;
	
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user) {
		List<Restaurant> restrnts= RecommendStrategyUtil.filterByCuisineCostLowRating(
				restaurants,user.getSecondaryCuisine1(),user.getPrimaryCostBracket(),rating);
		restrnts.addAll(RecommendStrategyUtil.filterByCuisineCostLowRating(
				restaurants,user.getSecondaryCuisine2(),user.getPrimaryCostBracket(),rating));
		return restrnts;
	}
}
