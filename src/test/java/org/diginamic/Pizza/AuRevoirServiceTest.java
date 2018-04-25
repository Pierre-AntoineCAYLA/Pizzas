package org.diginamic.Pizza;


import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.AuRevoirService;

public class AuRevoirServiceTest {
	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@org.junit.Test
	public void executeUCTest() {
		AuRevoirService auRevoirService= new AuRevoirService();
		IPizzaDao pizzas = new PizzaMemDao();			
		auRevoirService.executeUC(new Scanner(System.in), pizzas);
		assertTrue( systemOutRule.getLog().equals("Au revoir\r\n"));
		
	}
}
