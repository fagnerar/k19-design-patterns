package k19.designpatterns;

import java.util.Calendar;

public class GeradorDeBoleto {
	
	private BoletoBuilder bBuilder;
	
	public GeradorDeBoleto(BoletoBuilder bBuilder) {
		this.bBuilder = bBuilder;
	}
	
	public Boleto geraBoleto() {
		this.bBuilder.buildSacado("Fagner Rodrigues");
		
		this.bBuilder.buildCedente("k19 Treinamentos");
		
		this.bBuilder.buildValor(100.54);
		
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		this.bBuilder.buildVencimento(vencimento);
		
		this.bBuilder.buildNossoNumero(134679);
		
		Boleto boleto = bBuilder.getBoleto();
		
		return boleto;
	}
}
