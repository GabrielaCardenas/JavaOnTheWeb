package com.gaby.calculadora2;

public class Calculator2Test {

	public static void main(String[] args) {
		Calculator2 var = new Calculator2();
		var.performOperation(10.5);
		var.performOperation('+');
		var.performOperation(5.2);
		var.performOperation('*');
		var.performOperation(10);
		var.performOperation('+');
		var.performOperation(5.2);
		var.performOperation('*');
		var.performOperation(2);
		var.performOperation('=');
		
		System.out.println(var.getResult());

	}

}
