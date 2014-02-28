package k19.designpatterns;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Recibo implements Documento {
	
	private String emissor;
	private String favorecido;
	private double valor;
	private GeradorDeArquivos geradorDeArquivo;
	
	public Recibo(String emissor, String favorecido, double valor, GeradorDeArquivos geradorDeArquivo) {
		super();
		this.emissor = emissor;
		this.favorecido = favorecido;
		this.valor = valor;
		this.geradorDeArquivo = geradorDeArquivo;
	}
	
	public void gerarArquivo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Recibo: ");
		sb.append("\n");
		sb.append("Empresa: " + this.emissor);
		sb.append("\n");
		sb.append("Cliente: " + this.favorecido);
		sb.append("\n");
		sb.append("Valor: " + this.valor);
		sb.append("\n");
		this.geradorDeArquivo.gera(sb.toString());
		
	}

}
