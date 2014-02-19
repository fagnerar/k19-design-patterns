package k19.designpatterns;

public class TesteVisaComunicadorFactory {

	public static void main(String[] args) {
		
		VisaComunicadorFactory vcFactory = new VisaComunicadorFactory();
		
		String transacao = "Valor=560;Senha=123";
		Emissor emissor = vcFactory.createEmissor();
		emissor.envia(transacao);
		
		Receptor receptor = vcFactory.createReceptor();
		String mensagem = receptor.recebe();
		System.out.println(mensagem);
		
	}

}
