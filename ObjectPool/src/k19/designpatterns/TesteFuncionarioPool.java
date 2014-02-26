package k19.designpatterns;

public class TesteFuncionarioPool {
	
	public static void main(String[] args) {
		
		Pool<Funcionario> funcionarioPool = new FuncionarioPool();
		Funcionario f = funcionarioPool.acquire();
		
		while (f != null) {
			System.out.println(f.getNome());
			f = funcionarioPool.acquire();
		}
		
	}

}
