package org.diginamic.Pizza;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.ListerPizzasService;

public class ListerPizzaServiceTest {
	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@org.junit.Test
	public void test() {
		IPizzaDao pizzas = new PizzaMemDao();
		ListerPizzasService listerPizzasService= new ListerPizzasService();
		listerPizzasService.executeUC(new Scanner(System.in), pizzas);
		assertTrue( systemOutRule.getLog().contains("PEP"));
		assertTrue( systemOutRule.getLog().contains("FRO"));
		assertTrue( systemOutRule.getLog().contains("CAN"));
	}

}
