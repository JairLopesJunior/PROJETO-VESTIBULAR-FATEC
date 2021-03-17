package br.com.projetovestibularfatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscricoesCandidatos {

	List<InscricaoCandidato> candidatos = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
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
	
	public boolean whatCurso(int resul){
		return resul == 1 ? true : false;
	}
	
//	public InscricaoCandidato editar(InscricaoCandidato candidato) {
//		System.out.println("Informe o Codigo");
//	}
	
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
			System.out.println("==========================================");
		}else {
			returnElse();
		}
	}
	
	public void pagarBoleto(){
		System.out.println("Informe o numero da sua inscrição:");
		int numero = scan.nextInt();
		InscricaoCandidato candidatoValidado = validarInscricao(numero);
		if(candidatoValidado != null) {
			candidatoValidado.setSituacao(SituacaoInscricao.PAGO);
			System.out.println("==========================================");
			System.out.println("Boleto pago  com Sucesso!!");
			System.out.println("==========================================");
		}else {
			returnElse();
		}
	}
	
	public InscricaoCandidato validarInscricao(int numero) {
		for(InscricaoCandidato c : candidatos) {
			if(numero == c.getNumeroInscricao()) {
				return c;
			}
		};
		return null;
	}
	
	public void returnElse() {
		System.out.println("==========================================");
		System.out.println("Informe um numero de inscrição valido!!");
		System.out.println("==========================================");
	}
	
}
