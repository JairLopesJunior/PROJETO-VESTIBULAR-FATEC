package br.com.projetovestibularfatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscricoesCandidatos {

	List<InscricaoCandidato> candidatos = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	int numeroCandidatos = 0;
	int contar = 0;
	
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
		if(candidatoValidado != null && !candidatoValidado.getSituacao().equals(SituacaoInscricao.PAGO)) {
			candidatoValidado.setSituacao(SituacaoInscricao.PAGO);
			criarSalas();
			System.out.println("==========================================");
			System.out.println("Boleto pago com Sucesso!!");
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
			if(c != null && c.getSituacao().equals(SituacaoInscricao.PAGO)) {
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
	
	public void numeroSala(){
		candidatos.stream().forEach(c -> {
			if(c.getSituacao().equals(SituacaoInscricao.PAGO)) {
				contar++;
			}
		});
		if(contar > 0 && contar <= 30) {
			System.out.println("Numero de salas: " + 1);
		}else if(contar > 29) {
			System.out.println("Numero de salas: " + 2);
		}else if(contar > 59) {
			System.out.println("Numero de salas: " + 3);
		}else if(contar > 89) {
			System.out.println("Numero de salas: " + 4);
		}else if(contar > 119) {
			System.out.println("Numero de salas: " + 5);
		}else {
			System.out.println("============================================================");
			System.out.println("Numero de candidatos insuficiente para ocupar uma sala!!");
			System.out.println("============================================================");
		}
	}
	
	public void listaCandidatosSala(){
		System.out.println("Informe o numero da sala:");
		int numSala = scan.nextInt();
		if(numSala >= 1 || numSala <= 5) {
			for(InscricaoCandidato c : candidatos) {
				if(c.getSituacao().equals(SituacaoInscricao.PAGO) && c.getNumeroSala() == numSala) {
					System.out.println("============Nomes dos Candidatos============");
					System.out.println("Nome: " + c.getNome());
					System.out.println("==========================================");
				}else {
					System.out.println("============================================================");
					System.out.println("Nenhum candidato confirmado para este vestibular!!");
					System.out.println("============================================================");
				}
			}
		}else {
			System.out.println("============================================================");
			System.out.println("Numero de sala incorreto, por favor informe um numero valido!!");
			System.out.println("============================================================");
		}
	}
	
	public void relacaoCandidato(){
		System.out.println("Escolha uma opção: 1. Todas as inscrições ou 2. Somente as inscrições efetivadas");
		int opcao = scan.nextInt();
		if(opcao == 1) {
			System.out.println("Informe o numero do Curso: Ex: 1. SISTEMAS_PARA_INTERNET ou 2. GESTAO_EMPRESARIAL");
			int curso = scan.nextInt();
			if(curso == 1) {
				System.out.println("============================================================");
				Long numeroDeCandidatos = candidatos
						.stream()
						.filter(c -> 
							c.getOpcao().equals(OpcaoCursos.SISTEMAS_PARA_INTERNET))
						.count();
				System.out.println("O numero da relação de candidatos por vagas é: " + (numeroDeCandidatos.doubleValue() / 40));
				System.out.println("============================================================");
			}else if(curso == 2) {
				System.out.println("============================================================");
				Long numeroDeCandidatos = candidatos
						.stream()
						.filter(c -> 
							c.getOpcao().equals(OpcaoCursos.GESTAO_EMPRESARIAL))
						.count();
				System.out.println("O numero da relação de candidatos por vagas é: " + (numeroDeCandidatos.doubleValue() / 40));
				System.out.println("============================================================");
			}else {
				System.out.println("============================================================");
				System.out.println("Numero incorreto, por favor informe novamente!!");
				System.out.println("============================================================");
			}
		}else if(opcao == 2){
			System.out.println("Informe o numero do Curso: Ex: 1. SISTEMAS_PARA_INTERNET ou 2. GESTAO_EMPRESARIAL");
			int curso = scan.nextInt();
			if(curso == 1) {
				System.out.println("============================================================");
				Long numeroDeCandidatos = candidatos
						.stream()
						.filter(c -> 
							c.getOpcao().equals(OpcaoCursos.SISTEMAS_PARA_INTERNET) && c.getSituacao().equals(SituacaoInscricao.PAGO))
						.count();
				System.out.println("O numero da relação de candidatos por vagas é: " + (numeroDeCandidatos.doubleValue() / 40));
				System.out.println("============================================================");
			}else if(curso == 2) {
				System.out.println("============================================================");
				Long numeroDeCandidatos = candidatos
						.stream()
						.filter(c -> 
							c.getOpcao().equals(OpcaoCursos.GESTAO_EMPRESARIAL) && c.getSituacao().equals(SituacaoInscricao.PAGO))
						.count();
				System.out.println("O numero da relação de candidatos por vagas é: " + (numeroDeCandidatos.doubleValue() / 40));
				System.out.println("============================================================");
			}else {
				System.out.println("============================================================");
				System.out.println("Numero incorreto, por favor informe novamente!!");
				System.out.println("============================================================");
			}
		}		
	}
	
	// Gravar todos os Candidatos inscritos em um arquivo TXT com nome INSCRICOES.txt
	public void gravarInscricoesTxt(){
		File arquivo = new File("INSCRICOES.txt");
		try {
			
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter escreverNoArquivo = new FileWriter(arquivo.getAbsoluteFile());
			BufferedWriter gravarArquivo = new BufferedWriter(escreverNoArquivo);
			int i = 1;
			
			if(candidatos.isEmpty()) {
				System.out.println("============================================================");
				System.out.println("Não existe dados para serem gravados!!");
				System.out.println("============================================================");
			}else {
				for(InscricaoCandidato iC : candidatos) {
					gravarArquivo.write("============================================================");
					gravarArquivo.newLine();
					gravarArquivo.write("Candidato numero " + i++);
					gravarArquivo.newLine();
					gravarArquivo.write("Nome: " + iC.getNome());
					gravarArquivo.newLine();
					gravarArquivo.write("CPF: " + iC.getCpf());
					gravarArquivo.newLine();
					gravarArquivo.write("Numero da Inscrição: " + iC.getNumeroInscricao());
					gravarArquivo.newLine();
					gravarArquivo.write("Opção de Curso: " + iC.getOpcao().name());
					gravarArquivo.newLine();
					gravarArquivo.write("Situação: " + iC.getSituacao().name());
					gravarArquivo.newLine();
				}
				
				gravarArquivo.close();
				System.out.println("============================================================");
				System.out.println("Arquivo INSCRICOES.txt criado/gravado com sucesso!!");
				System.out.println("============================================================");
			}			
		}catch(Exception e) {
			e.fillInStackTrace();
		}
	}
	
	public void letInscricoesTxt() {
		try {
			File a = new File("INSCRICOES.txt");
			FileReader percorrerArquivo = new FileReader(a);
			BufferedReader lerArquivo = new BufferedReader(percorrerArquivo);
			if(!candidatos.isEmpty()) {
				System.out.println("============================================================");
				System.out.println("LISTA DE CANDIDATOS ENCONTRADOS");
				System.out.print("============================================================");
				while(lerArquivo.ready()) {
					String linha = lerArquivo.readLine();
					System.out.println(linha);
				 }  
				 lerArquivo.close();
			}else {
				System.out.println("============================================================");
				System.out.println("Nenhum dado encontrado para leitura!!");
				System.out.println("============================================================");
			}
	
		}catch(Exception e) {
			
		}
	}

}
