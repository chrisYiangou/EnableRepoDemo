package com.qa.dayfour.main;

import com.qa.dayfour.main.crud.MyArray;

public class Runner {

	
	public static void main(String[] args) {
		
		MyArray myArray = new MyArray();
		
		myArray.addOne(myArray.myArray, 10);
		
		myArray.read();
		myArray.readOne(838);
		
		
	}
}
