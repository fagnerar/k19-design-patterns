package k19.designpatterns;

public class ReceptorMastercard implements Receptor {
	
	public String recebe() {
		System.out.println("Recebendo mensagem Mastercard");
		String mensagem = "String do Mastercard";
		return mensagem;
	}
	
}
