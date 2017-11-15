package src;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Funcionario> funcionarios;
	private List<Projeto> projetos;

	public Empresa() {
		funcionarios = new ArrayList<>();
		projetos = new ArrayList<>();
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
		funcionario.setEmpresa(this);
	}

	public void addProjeto(Projeto projeto) {
		projetos.add(projeto);
		projeto.setEmpresa(this);
	}

	public int numFuncionarios() {
		return funcionarios.size();
	}

	public int numProjetos() {
		return projetos.size();
	}

	public boolean possuiFuncionario(Funcionario funcionario) {
		for (Funcionario f : funcionarios) {
			if (f == funcionario) {
				return true;
			}
		}

		return false;
	}
}
