package com.gabriela.web.models;

public class Dog extends Animal implements Pet {
	
	// Enviar parámetros de entrada a métodos Setter
	public Dog(String name, String breed, int weight) {
		setName(name);
		setBreed(breed);
		setWeight(weight);
	}

	public String ShowAffection() {
		if(getWeight() < 30 ) {
			return "You created a " + getBreed() + ". " + getName() + " hopped into your lap and cuddle you!";
		}
		else {
			return "You created a " + getBreed() + ". " + getName() + " curled up next to you";
		}
	}
}
