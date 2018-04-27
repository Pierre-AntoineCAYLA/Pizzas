package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

public class PizzaDbDao implements IPizzaDao {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaDbDao.class);
	private Connection conn;

	public PizzaDbDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage());
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Pizza> findAllPizzas() {

		PreparedStatement selectAllPizzas;
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		try {
			selectAllPizzas = conn.prepareStatement("SELECT ID, CODE, NAME, PRICE FROM pizza");
			ResultSet resultats = selectAllPizzas.executeQuery();
			while (resultats.next()) {
				Integer id = resultats.getInt("ID");
				String code = resultats.getString("CODE");
				String libelle = resultats.getString("NAME");
				double prix = resultats.getDouble("PRICE");
				Pizza toAdd = new Pizza(id, code, libelle, prix);
				pizzas.add(toAdd);

			}
			resultats.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return pizzas;

	}

	public void saveNewPizza(Pizza pizza) {
		PreparedStatement savePizzas;
		try {
			savePizzas = conn.prepareStatement("INSERT INTO pizza(CODE, NAME, PRICE) VALUES (?,?,?)");
			savePizzas.setString(1, pizza.getCode());
			savePizzas.setString(2, pizza.getLibelle());
			savePizzas.setDouble(3, pizza.getPrix());
			savePizzas.executeUpdate();
			savePizzas.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

	}

	public void updatePizza(String codePizza, Pizza pizza) {
		PreparedStatement upDatePizzas;
		try {
			upDatePizzas = conn.prepareStatement("UPDATE pizza SET CODE=?, NAME=?, PRICE=?  WHERE CODE=?");
			upDatePizzas.setString(1, pizza.getCode());
			upDatePizzas.setString(2, pizza.getLibelle());
			upDatePizzas.setDouble(3, pizza.getPrix());
			upDatePizzas.setString(4, codePizza);
			upDatePizzas.executeUpdate();
			upDatePizzas.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

	}

	public void deletePizza(String codePizza) {
		PreparedStatement deletePizzas;
		try {
			deletePizzas = conn.prepareStatement("DELETE FROM pizza WHERE CODE=?");
			deletePizzas.setString(1, codePizza);
			deletePizzas.executeUpdate();
			deletePizzas.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
	}

	public Pizza findPizzaByCode(String codePizza) {

		Pizza pizza = null;
		try {
			PreparedStatement findPizzas = conn.prepareStatement("SELECT * FROM pizza WHERE CODE=?");
			ResultSet resultats = findPizzas.executeQuery();
			findPizzas.setString(1, codePizza);
			pizza = new Pizza(resultats.getInt("ID"), resultats.getString("NAME"), resultats.getString("CODE"),
					resultats.getDouble("PRICE"));
			findPizzas.executeQuery();
			findPizzas.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return pizza;
	}

	public boolean pizzaExists(String codePizza) {
		boolean exist = false;
		try {
			PreparedStatement existPizzas = conn.prepareStatement("SELECT FROM pizza WHERE CODE=?");
			ResultSet resultats = existPizzas.executeQuery();
			existPizzas.setString(1, codePizza);
			exist = !resultats.wasNull();
			existPizzas.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return exist;

	}
}
