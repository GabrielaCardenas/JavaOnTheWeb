package com.gabriela.web.models;

public class Cat extends Animal implements Pet {

	// Enviar parámetros de entrada a métodos Setter
	public Cat(String name, String breed, int weight) {
		setName(name);
		setBreed(breed);
		setWeight(weight);
	}

	public String ShowAffection() {
		return "Your " + getBreed() + " cat, " + getName() + ", looked at you with some affection. You think." ;
	}
}
