package k19.designpatterns;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControleDePontoNovo {
	
	public void registra(Funcionario f, boolean entrada) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m:s");
		String format = sdf.format(calendar.getTime());
		
		if (entrada == true)
			System.out.println("Entrada: " + f.getNome() + " às " + format);
		else
			System.out.println("Saída: " + f.getNome() + " às " + format);
	}
	
}
