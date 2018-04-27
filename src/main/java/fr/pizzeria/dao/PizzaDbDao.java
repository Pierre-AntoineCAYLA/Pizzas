package fr.pizzeria.dao;

import java.sql.*;
import java.util.List;
import javax.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import fr.pizzeria.model.Pizza;

public class PizzaDbDao implements IPizzaDao {

	{
		try{
	Class.forName("com.mysql.jdbc.Driver");
	catch(Exception e){
	Connection myConnection = DriverManager.getConnection(« jdbc:mysql://localhost:3306/pizza?useSSL=false», «root», «»);
	ResultSet resultats = statement.executeQuery("SELECT * FROM pizza");
	while (resultats.next()){}
		}
		
		return null;
	for(
	Pizza pizza:dao.findAllPizzas())
	{
		PreparedStatement insertPizza = conn.prepareStatement("INSERT INTO pizza(PRIX, NAME, PRICE) VALUES (?,?,?)");
		Statement statement = connection.createStatement();

		insertPizza.setDouble(1, pizza.getPrix());

		insertPizza.setString(2, pizza.getLibelle());

		insertPizza.setString(3, pizza.getCode());

		insertPizza.executeUpdate();

		System.out.println(pizza.getLibelle() + " inséré");
	}
	ResultSet resultats = selectPizzaSt.executeQuery();
}

	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
}