package src;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private Empresa empresa;
	private List<Ocorrencia> ocorrencias;

	public Funcionario() {
		ocorrencias = new ArrayList<>();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void terminarOcorrencia(Ocorrencia ocorrencia) throws Exception {
		if (!ocorrencia.isAberta()) {
			throw new Exception("Ocorrência já foi fechada");
		}

		if (!possuiOcorrencia(ocorrencia)) {
			throw new Exception("Ocorrência não pertence a este funcionário");
		}

		ocorrencia.fechar();
		ocorrencias.remove(ocorrencia);
	}

	public void removerOcorrencia(Ocorrencia ocorrencia) throws Exception {
		if (!possuiOcorrencia(ocorrencia)) {
			throw new Exception("Ocorrência não pertence a este funcionário");
		}

		ocorrencias.remove(ocorrencia);
	}

	public int numOcorrencias() {
		return ocorrencias.size();
	}

	void addOcorrencia(Ocorrencia ocorrencia) throws Exception {
		if (ocorrencias.size() == 10) {
			throw new Exception("Limite de 10 ocorrências");
		}

		ocorrencias.add(ocorrencia);
	}

	private boolean possuiOcorrencia(Ocorrencia ocorrencia) {
		for (Ocorrencia o : ocorrencias) {
			if (o == ocorrencia) {
				return true;
			}
		}

		return false;
	}
}
