package k19.designpatterns;

import java.util.HashMap;
import java.util.Map;

public class Configuracao {
	
	private Map<String, String> propriedades;
	private static Configuracao instance;
	
	private Configuracao() {
		this.propriedades = new HashMap<>();
		this.propriedades.put("time-zone", "America/Sao_Paulo");
		this.propriedades.put("currency_code", "BRL");
	}
	
	public static Configuracao getInstance() {
		if(Configuracao.instance == null) {
			Configuracao.instance = new Configuracao();
		}
		return Configuracao.instance;
	}
	
	public String getPropriedade(String nomeDaPropriedade) {
		return this.propriedades.get(nomeDaPropriedade);
	}
}
