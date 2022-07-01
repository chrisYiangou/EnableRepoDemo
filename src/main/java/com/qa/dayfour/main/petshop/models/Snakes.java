package com.qa.dayfour.main.petshop.models;

import java.util.Objects;

public class Snakes implements Pet {
	
	//
	int id;
	String name;
	String scaleColour;
	float length;
	

	//Posting data into the database --
	public Snakes(String name, String scaleColour, float length) {
		super();
		this.name = name;
		this.scaleColour = scaleColour;
		this.length = length;
	}


	//Pulling data out of the DB --- I shall be using this constructor
	public Snakes(int id, String name, String scaleColour, float length) {
		super();
		this.id = id;
		this.name = name;
		this.scaleColour = scaleColour;
		this.length = length;
	}

	@Override
	public void eatHomework() {
		System.out.println("Gulp");
	}

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getScaleColour() {
		return scaleColour;
	}



	public void setScaleColour(String scaleColour) {
		this.scaleColour = scaleColour;
	}



	public float getLength() {
		return length;
	}



	public void setLength(float length) {
		this.length = length;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, length, name, scaleColour);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snakes other = (Snakes) obj;
		return id == other.id && Float.floatToIntBits(length) == Float.floatToIntBits(other.length)
				&& Objects.equals(name, other.name) && Objects.equals(scaleColour, other.scaleColour);
	}


	@Override
	public String toString() {
		return "Snakes [id=" + id + ", name=" + name + ", scaleColour=" + scaleColour + ", length=" + length + "]";
	}

	



}
