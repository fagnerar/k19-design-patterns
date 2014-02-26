package k19.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioPool implements Pool<Funcionario>{
	
	private List<Funcionario> funcionarios;
	
	public FuncionarioPool() {
		this.funcionarios = new ArrayList<>();
		this.funcionarios.add(new Funcionario("Fagner Rodrigues"));
		this.funcionarios.add(new Funcionario("Marcelo Martins"));
		this.funcionarios.add(new Funcionario("Jonas Hirata"));
	}

	@Override
	public Funcionario acquire() {
		
		if (this.funcionarios.size() > 0) {
			return this.funcionarios.remove(0);
		} else {
			return null;
		}
		
	}

	@Override
	public void release(Funcionario funcionario) {
		
		this.funcionarios.add(funcionario);
		
	}

}
