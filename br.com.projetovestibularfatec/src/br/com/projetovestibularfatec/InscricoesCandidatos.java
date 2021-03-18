package br.com.projetovestibularfatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscricoesCandidatos {

	List<InscricaoCandidato> candidatos = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	int numeroCandidatos = 0;
	
	public void save(InscricaoCandidato inscricaoCandidato) {
		System.out.println("Informe o seu nome:");
		String nome = scan.next();
		inscricaoCandidato.setNome(nome);
		
		System.out.println("Informe o seu CPF:");
		String cpf = scan.next();
		inscricaoCandidato.setCpf(cpf);
		
		System.out.println("Informe o numero do curso: Ex: 1. Sistemas para Internet ou 2. Gestão Empresarial");
		int resul = scan.nextInt();
		boolean cursoEscolhido = whatCurso(resul);
		OpcaoCursos curso = cursoEscolhido ? OpcaoCursos.SISTEMAS_PARA_INTERNET : OpcaoCursos.GESTAO_EMPRESARIAL;
		inscricaoCandidato.setOpcao(curso);
		
		inscricaoCandidato.setSituacao(SituacaoInscricao.EM_DIVIDA);
		candidatos.add(inscricaoCandidato);
		System.out.println("======================================");
		System.out.println("O seu numero de inscrição é:" + inscricaoCandidato.getNumeroInscricao());
		System.out.println("======================================");
	}
	
	private boolean whatCurso(int resul){
		return resul == 1 ? true : false;
	}
	
	public void editar() {
		System.out.println("Informe o numero da sua inscrição:");
		int numero = scan.nextInt();
		InscricaoCandidato candidatoValidado = validarInscricao(numero);
		if(candidatoValidado != null) {
			System.out.println("Novo nome:");
			String nomeEdit = scan.next();
			candidatoValidado.setNome(nomeEdit);
			
			System.out.println("Novo CPF:");
			String cpfEdit = scan.next();
			candidatoValidado.setCpf(cpfEdit);
			
			System.out.println("Nova opção de curso: Ex: 1. Sistemas para Internet ou 2. Gestão Empresarial");
			int cursoEdit = scan.nextInt();
			boolean cursoEscolhido = whatCurso(cursoEdit);
			OpcaoCursos curso = cursoEscolhido ? OpcaoCursos.SISTEMAS_PARA_INTERNET : OpcaoCursos.GESTAO_EMPRESARIAL;
			candidatoValidado.setOpcao(curso);
			returnEdit();
		}else {
			returnElse();
		}
	}
	
	public void listar() {
		System.out.println("Informe o numero da sua inscrição:");
		int numero = scan.nextInt();
		InscricaoCandidato candidatoValidado = validarInscricao(numero);
		if(candidatoValidado != null) {
			System.out.println("==========================================");
			System.out.println("Numero da Inscrição: " + candidatoValidado.getNumeroInscricao());
			System.out.println("Nome: " + candidatoValidado.getNome());
			System.out.println("CPF: " + candidatoValidado.getCpf());
			System.out.println("Curso: " + candidatoValidado.getOpcao());
			System.out.println("Situação do Pagamento: " + candidatoValidado.getSituacao());
			getNumeroSala(candidatoValidado);
			System.out.println("==========================================");
		}else {
			returnElse();
		}
	}
	
	private void getNumeroSala(InscricaoCandidato candidatoValidado) {
		if(candidatoValidado.getNumeroSala() != 0) {
			System.out.println("Numero da Sala: " + candidatoValidado.getNumeroSala());
		}
	}
	
	public void pagarBoleto(){
		System.out.println("Informe o numero da sua inscrição:");
		int numero = scan.nextInt();
		InscricaoCandidato candidatoValidado = validarInscricao(numero);
		if(candidatoValidado != null) {
			candidatoValidado.setSituacao(SituacaoInscricao.PAGO);
			criarSalas();
			System.out.println("==========================================");
			System.out.println("Boleto pago  com Sucesso!!");
			System.out.println("==========================================");
		}else {
			returnElse();
		}
	}
	
	private InscricaoCandidato validarInscricao(int numero) {
		for(InscricaoCandidato c : candidatos) {
			if(numero == c.getNumeroInscricao()) {
				return c;
			}
		};
		return null;
	}
	
	private void returnElse() {
		System.out.println("==========================================");
		System.out.println("Informe um numero de inscrição valido!!");
		System.out.println("==========================================");
	}
	
	private void returnEdit() {
		System.out.println("==========================================");
		System.out.println("Informações editadas com sucesso!!");
		System.out.println("==========================================");
	}
	
	private void criarSalas() {
		for(InscricaoCandidato c : candidatos) {
			if(c != null && c.getSituacao() == SituacaoInscricao.PAGO) {
				numeroCandidatos++;
				if(numeroCandidatos % 30 >= 1) {
					c.setNumeroSala(1);
				}else if(numeroCandidatos % 30 >= 2) {
					c.setNumeroSala(2);
				}else if(numeroCandidatos % 30 >= 3) {
					c.setNumeroSala(3);
				}else if(numeroCandidatos % 30 >= 4) {
					c.setNumeroSala(4);
				}else if(numeroCandidatos % 30 >= 5) {
					c.setNumeroSala(5);
				}
			}
		}
	}
	
}
