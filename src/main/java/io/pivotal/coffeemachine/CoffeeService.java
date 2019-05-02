package io.pivotal.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeService {

	private Inventory inventory;

	public CoffeeService(Inventory inventory) {
		this.inventory = inventory;
	}
	
	private Map<String, Drink> recipes = new HashMap<String, Drink>();
	private Map<String, Double> menu = new HashMap<String, Double>();

	/**
	 * Returns the menu for this coffee machine.
	 *
	 * @return a map of drink name to drink cost
	 */
	public Map<String, Double> getMenu() {
		for (Map.Entry<String, Drink> recipe : getRecipes().entrySet()) {
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
		Map<String, Drink> allRecipes = getRecipes();
		Drink drink = allRecipes.get(name);
		for (Map.Entry<String, Integer> ingredient : drink.getIngredients().entrySet()) {
			inventory.deduct(ingredient.getKey(), ingredient.getValue());
		}
		return drink;
	}

	/** Get the recipes for Coffee, Cappuccino and Caffe Mocha.
	 * 
	 * @return a map containing all the drinks and their ingredients.
	 */
	public Map<String, Drink> getRecipes() {
		recipes.put("coffee", coffeeRecipe());
		recipes.put("caffe mocha", caffeMochaRecipe());
		recipes.put("cappuccino", cappuccinoRecipe());
		return recipes;
	}

	/** Make coffee recipe 
	 * 
	 * @return coffee drink
	 */
	public Drink coffeeRecipe() {
		Drink coffee = new Drink();
		Map<String, Integer> ingredients = new HashMap<String, Integer>();
		ingredients.put("coffee", 2);
		ingredients.put("sugar", 1);
		coffee.setName("coffee");
		coffee.setCost(2.75);
		coffee.setIngredients(ingredients);
		return coffee;
	}

	/** Make caffe mocha recipe
	 * 
	 * @return caffe mocha drink
	 */
	public Drink caffeMochaRecipe() {
		Drink caffeMocha = new Drink();
		Map<String, Integer> ingredients = new HashMap<String, Integer>();
		ingredients.put("coffee", 1);
		ingredients.put("sugar", 1);
		ingredients.put("cream", 1);
		caffeMocha.setName("caffe mocha");
		caffeMocha.setCost(3.90);
		caffeMocha.setIngredients(ingredients);
		return caffeMocha;
	}

	/** Make Cappuccino recipe
	 * 
	 * @return cappuccino drink
	 */
	public Drink cappuccinoRecipe() {
		Drink cappuccino = new Drink();
		Map<String, Integer> ingredients = new HashMap<String, Integer>();
		ingredients.put("coffee", 2);
		ingredients.put("sugar", 1);
		ingredients.put("cream", 1);
		cappuccino.setName("cappuccino");
		cappuccino.setCost(2.90);
		cappuccino.setIngredients(ingredients);
		return cappuccino;
	}
	
	/** Adds a new drink to the menu
	 * @param drink drink object containing the new drink details
	 */
	public void addDrink(Drink drink) {
		Map<String, Double> menu = getMenu();
		menu.put(drink.getName(), drink.getCost());
	}

}
