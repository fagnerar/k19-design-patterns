package k19.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Caminho implements Trecho {
	
	private List<Trecho> trechos;
	
	public Caminho() {
		this.trechos = new ArrayList<>();
	}
	
	public void adiciona(Trecho trecho) {
		trechos.add(trecho);
	}
	
	public void remove(Trecho trecho) {
		trechos.remove(trecho);
	}
	
	@Override
	public void imprime() {
		for (Trecho t : trechos) {
			t.imprime();
		}
	}

}
