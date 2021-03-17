package br.com.projetovestibularfatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicadores {
	
	Scanner scan = new Scanner(System.in);

	List<Aplicador> aplicadores = new ArrayList<>();
	
	public void save(Aplicador aplicador) {
		System.out.println("Informe seu nome:");
		String nome = scan.next();
		aplicador.setNome(nome);
		
		System.out.println("Informe seu cargo:");
		String cargo = scan.next();
		aplicador.setCargo(cargo);
		aplicadores.add(aplicador);
		aplicadorSalvo();
	}
	
	private void aplicadorSalvo() {
		System.out.println("==========================================");
		System.out.println("Aplicador salvo com Sucesso!!");
		System.out.println("==========================================");
	}
	
	
}
