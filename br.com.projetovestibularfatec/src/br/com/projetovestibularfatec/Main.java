package br.com.projetovestibularfatec;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InscricoesCandidatos ics = new InscricoesCandidatos();
		int opcao;
		int numeroInscricao = 1;
		
		do{
			System.out.println("============================================");
			System.out.println("PROJETO - VESTIBULAR FATEC");
			System.out.println("============================================");
			System.out.println("1. Realizar Inscrição:");
			System.out.println("2. Editar Inscrição:");
			System.out.println("3. Listar Candidato:");
			System.out.println("4. Pagar boleto da Inscrição:");
			System.out.println("0. SAIR");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				InscricaoCandidato ic = new InscricaoCandidato(numeroInscricao++);
				ics.save(ic);
			}
			
			if(opcao == 2) {
				ics.editar();
			}
			
			if(opcao == 3) {
				ics.listar();
			}	
			
			if(opcao == 4) {
				ics.pagarBoleto();
			}
			
		}while(opcao != 0); {
			
		}
	}

}