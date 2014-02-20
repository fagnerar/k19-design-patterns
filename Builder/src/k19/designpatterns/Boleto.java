package k19.designpatterns;

import java.util.Calendar;

public interface Boleto {
	
	String getSacado();
	String getCedente();
	double getValor();
	Calendar getVencimento();
	int getNossoNumero();
	String toString();

}
