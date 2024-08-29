package br.com.cod3r.app.financial;

import java.lang.reflect.Field;

import br.com.cod3r.app.calculation.Calculator;
import br.com.cod3r.app.calculation.internal.ArithmericOperations;

public class Test {
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		System.out.println(calc.sum(2, 2, 3));
		
		ArithmericOperations ao = new ArithmericOperations();
		System.out.println(ao.sum(4, 5, 6));
		
		
		try {
			Field fieldId = Calculator.class.getDeclaredFields()[0];
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			fieldId.setAccessible(false);
			System.out.println(calc.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
