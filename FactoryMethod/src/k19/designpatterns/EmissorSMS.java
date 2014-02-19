package k19.designpatterns;

public class EmissorSMS implements Emissor {

	@Override
	public void envia(String mensagem) {
		System.out.println("Enviando mensagem por SMS:");
		System.out.println(mensagem);
	}
	
}
