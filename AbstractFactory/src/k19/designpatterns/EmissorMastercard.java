package k19.designpatterns;

public class EmissorMastercard implements Emissor {
	
	public void envia(String mensagem) {
		System.out.println("Enviando seguinte mensagem para Mastercard:");
		System.out.println(mensagem);
	}
	
}
