package k19.designpatterns;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GeradorDeArquivoTXT implements GeradorDeArquivos {

	@Override
	public void gera(String conteudo) {
		PrintStream saida;
		try {
			saida = new PrintStream("arquivo.txt");
			saida.println(conteudo);
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
