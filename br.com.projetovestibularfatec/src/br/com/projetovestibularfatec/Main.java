package br.com.projetovestibularfatec;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InscricaoCandidato ic = new InscricaoCandidato();

		System.out.println("============================================");
		System.out.println("PROJETO - VESTIBULAR FATEC");
		System.out.println("============================================");
		System.out.println("1. Realizar Inscrição:");
		System.out.println("2. Editar Inscrição:");
		System.out.println("0. SAIR");
		int opcao = scan.nextInt();
		
		do{
			if(opcao == 1) {
				ic.createSubscription();
			}
			
			if(opcao == 2) {
				
			}
			
		}while(opcao == 0); {
			
		}
	}

}
