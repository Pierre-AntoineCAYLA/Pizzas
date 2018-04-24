package org.diginamic.Pizza;

import static org.junit.Assert.*;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;


public class PizzaMemDaoTest {

	@org.junit.Test
	public void updatePizzaTest() {
		PizzaMemDao pizza = new PizzaMemDao();
		Pizza p = new Pizza("BOL", "Bolognaise", 150.00);
		pizza.updatePizza("FRO", p);
		assertTrue(pizza.findAllPizzas().contains(p));
	}

	@org.junit.Test
	public void findAllPizzaTest() {
		PizzaMemDao pizza = new PizzaMemDao();
		assertTrue(pizza.findAllPizzas().size() == 8);
	}

	@org.junit.Test
	public void saveNewPizzaTest() {
		PizzaMemDao pizza = new PizzaMemDao();
		Pizza p = new Pizza("BOL", "Bolognaise", 150.00);
		pizza.saveNewPizza(p);
		assertTrue(pizza.findAllPizzas().contains(p));
	}

	@org.junit.Test
	public void deletePizzaTest() {
		PizzaMemDao pizza = new PizzaMemDao();
		pizza.deletePizza("FRO");
		assertTrue(pizza.findAllPizzas().size() == 7);
	}

}
