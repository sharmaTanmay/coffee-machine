package io.pivotal.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeService {

	private Inventory inventory;
	private Map<String, Drink> recipes = new HashMap<String, Drink>();
	private Map<String, Double> menu = new HashMap<String, Double>();

	public CoffeeService(Inventory inventory) {
		this();
		this.inventory = inventory;
	}

	/**
	 * Constructor to load all the recipes
	 * 
	 */
	public CoffeeService() {
		Map<String, Integer> coffeeIngredients = new HashMap<String, Integer>();
		coffeeIngredients.put("coffee", 2);
		coffeeIngredients.put("sugar", 1);
		Map<String, Integer> caffeMochaIngredients = new HashMap<String, Integer>();
		caffeMochaIngredients.put("coffee", 1);
		caffeMochaIngredients.put("sugar", 1);
		caffeMochaIngredients.put("cream", 1);
		Map<String, Integer> cappuccinoIngredients = new HashMap<String, Integer>();
		cappuccinoIngredients.put("coffee", 2);
		cappuccinoIngredients.put("sugar", 1);
		cappuccinoIngredients.put("cream", 1);
		recipes.put("coffee", makeDrinkRecipe("coffee", 2.75, coffeeIngredients));
		recipes.put("caffe mocha", makeDrinkRecipe("caffe mocha", 3.90, caffeMochaIngredients));
		recipes.put("cappuccino", makeDrinkRecipe("cappuccino", 2.90, cappuccinoIngredients));

	}

	/**
	 * Returns the menu for this coffee machine.
	 *
	 * @return a map of drink name to drink cost
	 */
	public Map<String, Double> getMenu() {
		for (Map.Entry<String, Drink> recipe : recipes.entrySet()) {
			menu.put(recipe.getKey(), recipe.getValue().getCost());
		}
		return menu;
	}

	/**
	 * Make a drink using the given name. Ingredients for the drink are deducted
	 * from the inventory.
	 *
	 * @param name the name of the drink
	 */
	public Drink makeDrink(String name) {
		Drink drink = recipes.get(name);
		for (Map.Entry<String, Integer> ingredient : drink.getIngredients().entrySet()) {
			inventory.deduct(ingredient.getKey(), ingredient.getValue());
		}
		return drink;
	}

	/**
	 * Making recipes for coffee, cappuccino and caffe mocha
	 * 
	 * @param drinkName   name of the drink
	 * @param drinkCost   cost of the drink
	 * @param ingredients ingredients of the drink
	 * 
	 * @return drink with its recipe
	 */
	public Drink makeDrinkRecipe(String drinkName, Double drinkCost, Map<String, Integer> ingredients) {
		Drink drink = new Drink();
		drink.setName(drinkName);
		drink.setCost(drinkCost);
		drink.setIngredients(ingredients);
		return drink;
	}

	/**
	 * Adds a new drink to the menu
	 * 
	 * @param drink drink object containing the new drink details
	 */
	public void addDrink(Drink drink) {
		Map<String, Double> menu = getMenu();
		menu.put(drink.getName(), drink.getCost());
	}

}
