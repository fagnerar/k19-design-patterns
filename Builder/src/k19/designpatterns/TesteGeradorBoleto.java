package k19.designpatterns;

public class TesteGeradorBoleto {

	public static void main(String[] args) {
		
		BoletoBuilder bBuilder = new BBBoletoBuilder();
		
		GeradorDeBoleto gdb = new GeradorDeBoleto(bBuilder);
		
		Boleto boleto = gdb.geraBoleto();
		
		System.out.println(boleto);
		
	}

}
