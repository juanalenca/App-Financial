package br.com.cod3r.app.financial;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.cod3r.app.Calculator;

public class Test {
	
	public static void main(String[] args) {
		
		Calculator calc = ServiceLoader
				.load(Calculator.class)
				.findFirst()
				.get();
		System.out.println(calc.sum(2, 2, 3));
		
		
		try {
			Field fieldId = calc.getClass().getDeclaredFields()[0];
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			fieldId.setAccessible(false);
			System.out.println(calc.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
