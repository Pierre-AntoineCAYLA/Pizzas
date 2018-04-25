package org.diginamic.Pizza;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.MenuServiceFactory;


public class MenuServiceFactoryTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@org.junit.Test
	public void executeUCTest() {
		MenuServiceFactory aps = new MenuServiceFactory();
		PizzaMemDao pizza = new PizzaMemDao();
		systemInMock.provideLines("1");
		
	}

}
