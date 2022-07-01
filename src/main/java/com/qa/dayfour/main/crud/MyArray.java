package com.qa.dayfour.main.crud;

import java.util.Arrays;

public class MyArray {

	public int[] myArray = { 1, 2, 3, 4, 5, 3, 5, 6, 87 };

	public int[] addOne(int[] myArray, int newEntry) {
		int[] newArray = new int[myArray.length + 1];

		for (int i = 0; i < myArray.length; i++) {
			newArray[i] = myArray[i];
		}

		newArray[myArray.length] = newEntry;

		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}

		return newArray;
	}

	// Read One or Many
	public String read() {

		String output = " { ";

		for (int i = 0; i < myArray.length; i++) {
			output += myArray[i] + " ";
		}
		output += "}";
		
		System.out.println(output);
		return output;

	}
	
	//Index 
	public int readOne(int index) {
		try {
		System.out.println(myArray[index]);
		return myArray[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You done messed up" + e.getStackTrace());
			return 0;
		}
	}
	
	//Update -- 
	public int[] updateArray(int[] newArray, int index, int update) {
		
		newArray[index] = update;
		
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		
		return newArray;
		
	}
	
	//Delete
	
	public int[] deleteOne(int[] myArray, int index) {
		
		for (int i = 0; i < myArray.length; i++) {
			if (i == index) {
				int[] copy = new int[myArray.length - 1];
				System.arraycopy(myArray, 0, copy, 0, i);
				System.arraycopy(myArray, i + 1, copy, i, myArray.length -i - 1);
				return copy;
			}
		}
		return myArray;
	}

}
