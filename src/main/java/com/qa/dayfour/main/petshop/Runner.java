package com.qa.dayfour.main.petshop;

import com.qa.dayfour.main.petshop.models.Snakes;

public class Runner {

	// Petshop - to use a db that will store Pets
	// Create
	// Read
	// Update
	// Delete

	public static void main(String[] args) {

		Snakes snake = new Snakes("Charlie", "Red", 10);

		Petshop ps = new Petshop();
//
//		System.out.println(ps.addSnake(snake));
//
//		System.out.println(ps.getOneSnake(2));
//
//		System.out.println(ps.getAllSnakes());
//		
//		System.out.println(ps.getLastSnake());
//		
	//	System.out.println(ps.deleteAllSnakes());
		
		Snakes snakey = new Snakes("Bob", "Purple", 12);
		
		System.out.println(ps.updateSnake(19, snakey));

	}

}
