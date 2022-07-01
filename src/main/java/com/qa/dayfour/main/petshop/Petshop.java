package com.qa.dayfour.main.petshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.dayfour.main.petshop.models.Snakes;

public class Petshop {

	//This is where the meat of our application will be stored 
	
	//This will act as my psudo Service 
	//Service class is essentially where our business sided logic is stored
	
	//
	
	// DB   Entity<->DAO->Repository<-> Service <-> Controller     <->     FrontEnd
	// ^------------------------^
	
	//Variables 
	
	
	
	DBConfig db = new DBConfig();
	
	Statement stmt = null;
	Connection conn = db.connect();
	
	//Add A Snake to the Petshop
	
	public boolean addSnake(Snakes snake) {
		try {
			String query = "INSERT INTO snakes(snake_name, scale_colour,length) VALUE(?,?,?);";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, snake.getName());
			preStmt.setString(2, snake.getScaleColour());
			preStmt.setFloat(3, snake.getLength());
			preStmt.executeUpdate();
			
			//executeQuery -- This is when I want to pull information from the database
			// It needs to return a ResultSet
			
			
			
			
			//Read or return a query Execute query 
			//If i want to post or update executeUpdate
			
			//ResultSet results = ;
			//String output = "SELECT * FROM snakes;";;
			
			//stmt.executeQuery(output);
			return true;
			
		} catch (Exception e) {
			System.out.println("Didnt work boss" + e);
			return false;
		}
	
	}  
	
	public Snakes getOneSnake(int id) {
		try {
			String query = "SELECT * FROM snakes WHERE id = ?;";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setInt(1, id);
			ResultSet result = preStmt.executeQuery();
			result.next();
			return modelSnake(result);
			
			
			
		} catch (Exception e) {
			System.out.println("Try again please boss");
			return null;
		}
	}
	
	//Using GetOne Snake as a basis - try and create a getAll Snakes
	//work in your groups to figure out a functional way of achieving this.
	//When your done -- try and explain your actions
	
	//Try and create this method yourself
	// Write a comment for each line explaining what you are doing
	
	public List<Snakes> getAllSnakes() {
		try {
			String query = "SELECT * FROM snakes;";
			PreparedStatement preStmt = conn.prepareStatement(query);
			ResultSet result = preStmt.executeQuery();
			List<Snakes> snakes = new ArrayList<>();
			while (result.next()) {
			
				snakes.add(modelSnake(result));
			}
			
			return snakes;
			
		} catch (Exception e) {
			System.out.println("This hasnt worked");
			return null;
			
		}
	}
	
	// Create a get method that returns one entry - the latest entry/earliest entry
	
	// Create Update methods - One and Many
	
	// Create a delete method -- One and DeleteAll();
	
	public Snakes getLastSnake() {
		try {
			String query = "SELECT * FROM snakes ORDER BY id DESC LIMIT 1;";
			PreparedStatement pStmt = conn.prepareStatement(query);
			ResultSet result = pStmt.executeQuery();
			
			result.next();
			return modelSnake(result);
			
			
		} catch (Exception e) {
			System.out.println("Option 1: You lose");
			return null;
		}
	}
	
	//Update - Many or One
	public Snakes updateSnake(int id, Snakes update) {
		
		try {
			String query = "UPDATE snakes SET snake_name = ?, scale_colour = ? , length = ? WHERE id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setString(1, update.getName());
			pStmt.setString(2, update.getScaleColour());
			pStmt.setFloat(3, update.getLength());
			pStmt.setInt(4, id);
			
			int rowsEffected = pStmt.executeUpdate();
			

			return getOneSnake(id);
			
			
			
		} catch (Exception e) {
			System.out.println("Another one" + e);
			return null;
			
		}
		
	}
	
	
	public boolean deleteAllSnakes() {
		try {
			String sql = "DELETE FROM snakes;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
			
			return true;
			
			
		} catch (Exception e) {
			
			System.out.println("Failed" + e);
			return false;
			
		}
	}
	
		
	
	public Snakes modelSnake(ResultSet result) {
		try {
//			result.next();
			int id = result.getInt("id");
			String name = result.getString("snake_name");
			String scaleColour = result.getString("scale_colour");
			float length = result.getFloat("length");
			
			Snakes snake = new Snakes(id, name, scaleColour, length);
			return snake;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	
	
	
}
