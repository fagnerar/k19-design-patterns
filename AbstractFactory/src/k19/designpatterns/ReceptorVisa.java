package k19.designpatterns;

public class ReceptorVisa implements Receptor {

	@Override
	public String recebe() {
		System.out.println("Recebendo mensagem de VISA:");
		String mensagem = "String da VISA";
		return mensagem;
	}

}
