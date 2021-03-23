package br.com.projetovestibularfatec;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InscricoesCandidatos ics = new InscricoesCandidatos();
		Aplicadores aplicadores = new Aplicadores();
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
			System.out.println("5. Cadastrar aplicadores das provas:");
			System.out.println("6. Verificar numero de salas necessárias para o vestibular:");
			System.out.println("7. Verificar lista dos candidatos por salas: OBS: Somente os Efetivados");
			System.out.println("8. Relação de Candidatos por vagas:");
			System.out.println("9. Gravar dados em arquivo TXT (INSCRICOES.TXT).");
			System.out.println("10. Ler dados do arquivo TXT. (INSCRICOES.TXT)");
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
			
			if(opcao == 5) {
				Aplicador aplicador = new Aplicador();
				aplicadores.save(aplicador);
			}
			
			if(opcao == 6) {
				ics.numeroSala();
			}
			
			if(opcao == 7) {
				ics.listaCandidatosSala();
			}
			
			if(opcao == 8) {
				ics.relacaoCandidato();
			}
			
			if(opcao == 9) {
				ics.gravarInscricoesTxt();
			}
			
			if(opcao == 10) {
				ics.letInscricoesTxt();
			}
			
		}while(opcao != 0); {
			
		}
	}

}
