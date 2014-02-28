package k19.designpatterns;

public class TesteRecibo {

	public static void main(String[] args) {
		
		GeradorDeArquivos geradorDeArquivoTXT = new GeradorDeArquivoTXT();
		
		Documento recibo = new Recibo("k19 Treinamentos", "Fagner Rodrigues", 1000, geradorDeArquivoTXT);
		
		recibo.gerarArquivo();
		
	}

}
