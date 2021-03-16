package br.com.projetovestibularfatec;

public class InscricaoCandidato {

	private int numeroInscricao;
	private String nome;
	private String cpf;
	private OpcaoCursos opcao;
	private SituacaoInscricao situacao;
	
	public InscricaoCandidato(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao++;
	}
	
	public int getNumeroInscricao() {
		return numeroInscricao;
	}
	public void setNumeroInscricao(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public OpcaoCursos getOpcao() {
		return opcao;
	}
	public void setOpcao(OpcaoCursos opcao) {
		this.opcao = opcao;
	}
	public SituacaoInscricao getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoInscricao situacao) {
		this.situacao = situacao;
	}

}
