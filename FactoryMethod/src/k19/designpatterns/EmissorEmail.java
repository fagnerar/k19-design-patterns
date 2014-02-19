package k19.designpatterns;

public class EmissorEmail implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando mensagem por Email:");
		System.out.println(mensagem);
	}
}
