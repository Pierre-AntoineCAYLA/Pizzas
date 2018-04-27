package org.diginamic.Pizza;

import fr.pizzeria.dao.PizzaDbDao;
import fr.pizzeria.model.Pizza;

public class App {
	public static void main(String[] args) {
		PizzaDbDao pizzas = new PizzaDbDao();
		Pizza pz = new Pizza(1, "car", "carbonara", 12.0);
		Pizza pz1 = (new Pizza("PEP", "P�p�roni", 12.50));
		Pizza pz2 = (new Pizza("MAR", "Margherita", 14.00));
		Pizza pz3 = (new Pizza("REIN", "La Reine", 11.50));
		Pizza pz4 = (new Pizza("FRO", "La 4 fromages", 12.00));
		Pizza pz5 = (new Pizza("CAN", "La cannibale", 12.50));
		Pizza pz6 = (new Pizza("SAV", "La savoyarde", 13.00));
		Pizza pz7 = (new Pizza("ORI", "L�orientale", 13.50));
		Pizza pz8 = (new Pizza("IND", "L�indienne", 14.00));
		pizzas.saveNewPizza(pz);
		pizzas.saveNewPizza(pz1);
		pizzas.saveNewPizza(pz2);
		pizzas.saveNewPizza(pz3);
		pizzas.saveNewPizza(pz4);
		pizzas.saveNewPizza(pz5);
		pizzas.saveNewPizza(pz6);
		pizzas.saveNewPizza(pz7);
		pizzas.saveNewPizza(pz8);

	}
}
