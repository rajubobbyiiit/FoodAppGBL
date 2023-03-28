package app.food.recommend.strategies;

import java.util.List;
import java.util.Objects;

import app.food.models.Restaurant;
import app.food.models.User;
import app.food.recommend.util.RecommendStrategyUtil;

public class FeaturedRecommendRestaurantsStrategy implements RecommendStrategy {
	
	/*
	 * Featured restaurants of primary cuisine and primary cost bracket. If none,
	 * then all featured restaurants of primary cuisine, secondary cost and
	 * secondary cuisine, primary cost
	 */
	
	@Override
	public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, User user) {
		//primary cuisine and primary cost bracket -- also greater than zero rating means not considering rating
		List<Restaurant> restrnts= 
				RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getPrimaryCuisine(),user.getPrimaryCostBracket(),0);
		if(restrnts==null || restrnts.isEmpty()) {
			//below --> primary cuisine, secondary cost
			restrnts=RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getPrimaryCuisine(),user.getSecondaryCostBracket1(),0);
			restrnts.addAll(RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getPrimaryCuisine(),user.getSecondaryCostBracket2(),0));
			//below --> secondary cost and secondary cuisine, primary cost
			restrnts.addAll(RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getSecondaryCuisine1(),user.getPrimaryCostBracket(),0));
			restrnts.addAll(RecommendStrategyUtil.filterByCuisineCostHightRating(restaurants,user.getSecondaryCuisine2(),user.getPrimaryCostBracket(),0));
		}
		return restrnts;

	}
}
