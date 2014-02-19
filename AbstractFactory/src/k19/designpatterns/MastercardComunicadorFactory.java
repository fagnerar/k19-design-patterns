package k19.designpatterns;

public class MastercardComunicadorFactory {
	
	private EmissorCreator emissorCreator = new EmissorCreator();
	private ReceptorCreator receptorCreator = new ReceptorCreator();
	
	public Emissor createEmissor() {
		return emissorCreator.create(EmissorCreator.MASTERCARD);
	}
	
	public Receptor createReceptor() {
		return receptorCreator.create(ReceptorCreator.MASTERCARD);
	}

}
