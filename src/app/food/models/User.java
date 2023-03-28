package app.food.models;

import java.util.TreeMap;
import java.util.UUID;

public class User {
	private String id;
	private String name;
	private TreeMap<Cuisine, Integer> cuisineTracking;
	private TreeMap<CostBracket, Integer> costTracking;
	private Cuisine primaryCuisine;
	private Cuisine secondaryCuisine1;
	private Cuisine secondaryCuisine2;
	private CostBracket primaryCostBracket;
	private CostBracket secondaryCostBracket1;
	private CostBracket secondaryCostBracket2;

	public User() {
		id = UUID.randomUUID().toString();
		cuisineTracking = new TreeMap<>();
		costTracking = new TreeMap<>();
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void updateCostPrefrnce(CostBracket costBracket){
		if((costTracking.get(costBracket))==null)
			costTracking.put(costBracket, 1);
		else 
			costTracking.replace(costBracket, costTracking.get(costBracket)+1);
		
		int currentValue=costTracking.get(costBracket); 
		int primaryCostValue= primaryCostBracket==null?0:costTracking.get(primaryCostBracket);
		int secondaryCost1Value= secondaryCostBracket1 ==null?0:costTracking.get(secondaryCostBracket1);
		if(primaryCostBracket ==null || currentValue > costTracking.get(primaryCostBracket)){
			CostBracket temp = secondaryCostBracket1;
			secondaryCostBracket1 = primaryCostBracket;
			primaryCostBracket = costBracket;
			secondaryCostBracket2 = temp;
		}else if(primaryCostValue > currentValue && (secondaryCostBracket1 ==null || (currentValue > secondaryCost1Value))){
			CostBracket temp = secondaryCostBracket1;
			secondaryCostBracket1 = costBracket;
			secondaryCostBracket2 = temp;
		}else if(secondaryCost1Value > currentValue && (secondaryCostBracket2 ==null || currentValue > costTracking.get(secondaryCostBracket2))){
			secondaryCostBracket2 = costBracket;
		}
	}

	public void updateCuisinePrefrnce(Cuisine cuisine){
		if((cuisineTracking.get(cuisine))==null)
			cuisineTracking.put(cuisine, 1);
		else 
			cuisineTracking.replace(cuisine, cuisineTracking.get(cuisine)+1);
		
		int currentValue=cuisineTracking.get(cuisine);
		int primaryCuisineValue= primaryCuisine==null?0:cuisineTracking.get(primaryCuisine);
		int secondaryCuisine1Value= secondaryCuisine1==null?0:cuisineTracking.get(secondaryCuisine1);
		if (primaryCuisine == null ||  currentValue> cuisineTracking.get(primaryCuisine)){
			Cuisine temp = secondaryCuisine1;
			secondaryCuisine1 = primaryCuisine;
			primaryCuisine = cuisine;
			secondaryCuisine2 = temp;
		}
		else if (currentValue < primaryCuisineValue && (secondaryCuisine1 == null ||  currentValue > secondaryCuisine1Value)){
			Cuisine temp = secondaryCuisine1;
			secondaryCuisine1=cuisine;
			secondaryCuisine2 = temp;
		}
		else if (currentValue < secondaryCuisine1Value && (secondaryCuisine2 == null ||  currentValue> cuisineTracking.get(secondaryCuisine2))){
			secondaryCuisine2=cuisine;
		}
	}

	public Cuisine getPrimaryCuisine(){
		return primaryCuisine;
	}
	public Cuisine getSecondaryCuisine1(){
		return secondaryCuisine1;
	}
	public Cuisine getSecondaryCuisine2(){
		return secondaryCuisine2;
	}

	public CostBracket getPrimaryCostBracket(){
		return primaryCostBracket;
	}

	public CostBracket getSecondaryCostBracket1(){
		return secondaryCostBracket1;
	}
	
	public CostBracket getSecondaryCostBracket2(){
		return secondaryCostBracket2;
	}
}
