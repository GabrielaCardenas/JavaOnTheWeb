package com.gaby.calculadora2;

import java.util.ArrayList;

public class Calculator2 implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double result;
	private double var;
	ArrayList<Double> num = new ArrayList<>();
	ArrayList<Character> op = new ArrayList<>();
	
	public Calculator2() {}
	
	public void performOperation(double x) {
		num.add(x);
	}
	
	public void performOperation(char y) {
		op.add(y);
		
		if(num.size() >= 2 && y == '=') {
			while(op.size() > 1) {
				for(int i=0; i<op.size(); i++) {
				
					if(op.get(i) == '*') {
						var = num.get(i) * num.get(i+1);
						num.set(i, var);
						num.remove(i+1);
						op.remove(i);
					}
					if(op.get(i) == '/') {
						var = num.get(i) / num.get(i+1);
						num.set(i, var);
						num.remove(i+1);
						op.remove(i);
					}	
				}
			
				for(int j=0; j<op.size(); j++) {
				
					if(op.get(j) == '+') {
						var = num.get(j) + num.get(j+1);
						num.set(j, var);
						num.remove(j+1);
						op.remove(j);
					}
					if(op.get(j) == '-') {
						var = num.get(j) - num.get(j+1);
						num.set(j, var);
						num.remove(j+1);
						op.remove(j);
					}
				}
			}
			this.result = num.get(0);
		}
	}
	public double getResult() {
		return this.result;
	}
}
