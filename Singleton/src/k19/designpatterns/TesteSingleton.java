package k19.designpatterns;

public class TesteSingleton {
	
	public static void main(String[] args) {
		
		Configuracao c = Configuracao.getInstance();
		System.out.println(c.getPropriedade("time-zone"));
		System.out.println(c.getPropriedade("currency_code"));
		
	}

}
