package k19.designpatterns;

public class TestaCaminho {
	
	public static void main(String[] args) {
		
		Trecho trecho1 = new TrechoAndando("Vá até o cruzamento da Av. Rebouças com a Av. Brigadeiro Faria Lima", 500);
		Trecho techo2 = new TrechoCarro("Vá até o cruzamento da Av. Brigadeiro Faria Lima com a Av. Cidade Jardim", 1500);
		Trecho trecho3 = new TrechoCarro("Vire a direita na Marginal Pinheiros", 500);
		
		Caminho caminho1 = new Caminho();
		caminho1.adiciona(trecho1);
		caminho1.adiciona(techo2);
		
		System.out.println("Caminho 1: ");
		caminho1.imprime();
		
		Caminho caminho2 = new Caminho();
		caminho2.adiciona(caminho1);
		caminho2.adiciona(trecho3);
		System.out.println("---------------------");
		System.out.println("Caminho 2: ");
		caminho2.imprime();
		
	}

}
