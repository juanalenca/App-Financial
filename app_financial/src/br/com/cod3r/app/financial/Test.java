package br.com.cod3r.app.financial;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.cod3r.app.Calculator;

public class Test {
	
	public static void main(String[] args) {
		
		// Carrega a primeira implementação disponível da interface "Calculator" através do ServiceLoader.
		Calculator calc = ServiceLoader
				.load(Calculator.class)
				.findFirst()
				.get();
		
		// Chama o método "sum" da implementação carregada e imprime o resultado.
		// Neste caso, está somando os números 2, 2 e 3.
		System.out.println(calc.sum(2, 2, 3));
		
		try {
			// Acessa o primeiro campo declarado na classe da implementação de "Calculator" usando reflexão.
			// É esperado que seja um campo privado.
			Field fieldId = calc.getClass().getDeclaredFields()[0];
			
			// Torna o campo acessível para que se possa modificá-lo, mesmo sendo privado.
			fieldId.setAccessible(true);
			
			// Define o valor do campo (presumivelmente um identificador) como "def".
			fieldId.set(calc, "def");
			
			// Fecha novamente o acesso ao campo.
			fieldId.setAccessible(false);
			
			// Imprime o valor do campo "id" após a modificação. O método "getId" deve estar implementado em "Calculator".
			System.out.println(calc.getId());
		} catch (Exception e) {
			// Captura e imprime qualquer exceção que ocorra durante a reflexão, como acessos a campos inexistentes
			// ou violações de segurança.
			e.printStackTrace();
		}
			
	}

}
