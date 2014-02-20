package k19.designpatterns;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestePrototype {

	public static void main(String[] args) {
		
		String nome = "K19";
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		
		Set<String> palavrasChave = new HashSet<>();
		palavrasChave.add("curso");
		palavrasChave.add("java");
		palavrasChave.add("k19");
		
		Campanha campanha = new Campanha(nome, vencimento, palavrasChave);
		
		Campanha c2 = campanha.clone();
		
		System.out.println(c2);
		
	}

}
