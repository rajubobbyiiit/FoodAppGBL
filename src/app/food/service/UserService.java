package app.food.service;

import java.util.HashMap;
import java.util.Map;

import app.food.models.CostBracket;
import app.food.models.Cuisine;
import app.food.models.User;

public class UserService {
	Map<String, User> users;

	public UserService() {
		this.users = new HashMap<>();
	}

	public String addUser(){
		User user = new User();
		users.put(user.getId(), user);
		return user.getId();
	}

	public User getUserById(String userId){
		return users.get(userId);
	}

	public void updateUserPrefrncsForCuisineNCost(String userId, Cuisine cuisine, CostBracket costBracket){
		User user = users.get(userId);
		user.updateCostPrefrnce(costBracket);
		user.updateCuisinePrefrnce(cuisine);
	}
}
