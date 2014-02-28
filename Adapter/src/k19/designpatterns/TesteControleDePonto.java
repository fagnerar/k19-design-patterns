package k19.designpatterns;

public class TesteControleDePonto {

	public static void main(String[] args) throws InterruptedException {
		
		ControleDePonto cdp = new ControleDePontoAdapter();
		Funcionario f = new Funcionario("Fagner Rodrigues");
		
		cdp.registraEntrada(f);
		
		Thread.sleep(3000);
		
		cdp.registraSaida(f);
		
	}

}
