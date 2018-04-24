package org.diginamic.Pizza;

import static org.junit.Assert.*;

import java.util.Scanner;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.services.AjouterPizzaService;

public class AjouterPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@org.junit.Test
	public void executeUCTest() {
		AjouterPizzaService aps = new AjouterPizzaService();
		PizzaMemDao pizza = new PizzaMemDao();

		systemInMock.provideLines("BOL", "Bolognaise", "150,00");
		Pizza p = new Pizza("BOL", "Bolognaise", 150.00);
		aps.executeUC(new Scanner(System.in), pizza);
		assertTrue(pizza.findAllPizzas().contains(p));
	}
}
