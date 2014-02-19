package k19.designpatterns;

public class EmissorJMS implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando mensagem por JMS:");
		System.out.println(mensagem);
	}
}
