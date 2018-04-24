package org.diginamic.Pizza;


import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.After;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.AjouterPizzaService;

public class AuRevoirServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@After
	public void executeUCTest() {
		AjouterPizzaService aps = new AjouterPizzaService();
		PizzaMemDao pizza = new PizzaMemDao();
		aps.executeUC(new Scanner(System.in), pizza);
		assertTrue(pizza.findAllPizzas().contains(p));
		
	}
}
