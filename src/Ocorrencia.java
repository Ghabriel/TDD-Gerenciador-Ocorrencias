package src;

public class Ocorrencia {
	private static int proximaChave = 1;
	private int chave;
	private String resumo;
	private Funcionario responsavel;
	private TipoOcorrencia tipo;
	private Prioridade prioridade;
	private boolean aberta;
	private Projeto projeto;

	public Ocorrencia(Funcionario responsavel, TipoOcorrencia tipo,
			Prioridade prioridade, String resumo) {
		this.chave = proximaChave++;
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.resumo = resumo;
		aberta = true;
	}

	public int getChave() {
		return chave;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public void setResponsavel(Funcionario responsavel) throws Exception {
		if (!aberta) {
			throw new Exception("Responsável inalterável após conclusão");
		}
		
		if (projeto != null) {
			this.responsavel.removerOcorrencia(this);
			responsavel.addOcorrencia(this);
		}

		this.responsavel = responsavel;
	}
	
	public Funcionario getResponsavel() {
		return responsavel;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}
	
	public void setPrioridade(Prioridade prioridade) throws Exception {
		if (!aberta) {
			throw new Exception("Prioridade inalterável após conclusão");
		}

		this.prioridade = prioridade;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void fechar() {
		aberta = false;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
