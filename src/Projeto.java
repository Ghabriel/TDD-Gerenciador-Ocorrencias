package src;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	private Empresa empresa;
	private List<Ocorrencia> ocorrencias;

	public Projeto() {
		ocorrencias = new ArrayList<>();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void addOcorrencia(Ocorrencia ocorrencia) throws Exception {
		if (!empresa.possuiFuncionario(ocorrencia.getResponsavel())) {
			throw new Exception("Funcionário não pertence à empresa");
		}

		ocorrencia.setProjeto(this);
		ocorrencia.getResponsavel().addOcorrencia(ocorrencia);
		ocorrencias.add(ocorrencia);
	}

	public void addOcorrencias(List<Ocorrencia> ocorrencias) throws Exception {
		for (Ocorrencia ocorrencia : ocorrencias) {
			addOcorrencia(ocorrencia);
		}
	}
	
	public int numOcorrencias() {
		return ocorrencias.size();
	}
}
