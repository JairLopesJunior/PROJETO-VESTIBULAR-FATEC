package br.com.projetovestibularfatec;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InscricoesCandidatos ics = new InscricoesCandidatos();
		InscricaoCandidato ic = new InscricaoCandidato(0);

		System.out.println("============================================");
		System.out.println("PROJETO - VESTIBULAR FATEC");
		System.out.println("============================================");
		System.out.println("1. Realizar Inscrição:");
		System.out.println("2. Editar Inscrição:");
		System.out.println("3. Pagar boleto da Inscrição:");
		System.out.println("0. SAIR");
		int opcao = scan.nextInt();
		
		do{
			if(opcao == 1) {
				ics.save(ic);
			}
			
			if(opcao == 2) {
				
			}
			
		}while(opcao == 0); {
			
		}
	}

}
