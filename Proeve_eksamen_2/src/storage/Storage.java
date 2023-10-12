package storage;

import model.Pizza;

import java.util.ArrayList;

public class Storage {
	private static final ArrayList<Pizza> pizzas = new ArrayList<>();

	public static ArrayList<Pizza> getPizzas() {
		return new ArrayList<>(pizzas);
	}

	public static void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
}
