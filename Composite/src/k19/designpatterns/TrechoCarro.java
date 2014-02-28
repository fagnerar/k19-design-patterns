package k19.designpatterns;

public class TrechoCarro implements Trecho {
	
	private String direcao;
	private double distancia;
	
	public TrechoCarro(String direcao, double distancia) {
		super();
		this.direcao = direcao;
		this.distancia = distancia;
	}

	@Override
	public void imprime() {
		System.out.println("Vá de carro:");
		System.out.println(this.direcao);
		System.out.println("A distância percorrida será de: " + this.distancia + " metros.");
	}

}
