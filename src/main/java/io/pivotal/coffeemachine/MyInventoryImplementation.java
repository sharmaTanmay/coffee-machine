package io.pivotal.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class MyInventoryImplementation implements Inventory{
	
	private Map<String, Integer> ingredients =  new HashMap<String, Integer>();
	
	  int coffee = 10; 
	  int cream = 10; 
	  int sugar = 10; 
	

	public Map<String, Integer> getIngredients() {
		// TODO Auto-generated method stub
		ingredients.put("coffee", coffee);
		ingredients.put("cream", cream);
		ingredients.put("sugar", sugar);
		return ingredients;
	}

	public void deduct(String name, Integer amount) {
		// TODO Auto-generated method stub
		if(name.equalsIgnoreCase("coffee")) {
			coffee= coffee-amount;
		}
		if(name.equalsIgnoreCase("cream")) {
			cream= cream-amount;
		}
		if(name.equalsIgnoreCase("sugar")) {
			sugar= sugar-amount;
		}
		
		
	}

}
