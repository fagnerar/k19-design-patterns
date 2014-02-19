package k19.designpatterns;

public class EmissorVisa implements Emissor {

	@Override
	public void envia(String mensagem) {
		System.out.println("Enviando seguinte mensagem para VISA:");
		System.out.println(mensagem);
	}

}
