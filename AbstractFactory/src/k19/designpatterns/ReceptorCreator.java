package k19.designpatterns;

public class ReceptorCreator {
	
	public static final int VISA = 0;
	public static final int MASTERCARD = 1;
	
	public Receptor create(int tipoDeReceptor) {
		if (tipoDeReceptor == 0) {
			return new ReceptorVisa();
		} else if (tipoDeReceptor == 1) {
			return new ReceptorMastercard();
		} else {
			throw new IllegalArgumentException("Tipo de receptor não suportado");
		}
	}

}
