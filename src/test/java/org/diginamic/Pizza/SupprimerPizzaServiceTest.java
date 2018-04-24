package org.diginamic.Pizza;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.SupprimerPizzaService;

public class SupprimerPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@org.junit.Test
	public void executeUCTest() {
		
		SupprimerPizzaService aps = new SupprimerPizzaService();
		PizzaMemDao pizza = new PizzaMemDao();

		systemInMock.provideLines("FRO");
		aps.executeUC(new Scanner(System.in), pizza);
		assertTrue(pizza.findAllPizzas().size() == 7);
	}
}


