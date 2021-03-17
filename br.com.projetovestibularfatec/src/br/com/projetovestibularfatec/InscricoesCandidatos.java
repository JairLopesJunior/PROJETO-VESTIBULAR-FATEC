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
	}
	
	public boolean whatCurso(int resul){
		return resul == 1 ? true : false;
	}
	
}
