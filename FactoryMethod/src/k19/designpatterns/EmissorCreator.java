package k19.designpatterns;

public class EmissorCreator {
	
	public static final int SMS = 0;
	public static final int EMAIL = 1;
	public static final int JMS = 2;
	
	public Emissor create(int tipoDeEmissor) {
		if (tipoDeEmissor == SMS) {
			return new EmissorSMS();
		} else if (tipoDeEmissor == EMAIL) {
			return new EmissorEmail();
		} else if (tipoDeEmissor == JMS) {
			return new EmissorJMS();
		} else {
			throw new IllegalArgumentException("Tipo de emissor não suportado");
		}
	}

}
