package app.food.recommend.strategies;

import java.util.List;

import app.food.models.Restaurant;
import app.food.models.User;
import app.food.recommend.util.RecommendStrategyUtil;

public class PrimaryCuisineNSecondaryCostBracketWithLowRatingStrategy implements RecommendStrategy{
	private static final float rating = 4.5F;
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user) {
		List<Restaurant> restrnts= RecommendStrategyUtil.filterByCuisineCostLowRating(
				restaurants,user.getPrimaryCuisine(),user.getSecondaryCostBracket1(),rating);
		restrnts.addAll(RecommendStrategyUtil.filterByCuisineCostLowRating(
				restaurants,user.getPrimaryCuisine(),user.getSecondaryCostBracket2(),rating));
		return restrnts;
	}
}
