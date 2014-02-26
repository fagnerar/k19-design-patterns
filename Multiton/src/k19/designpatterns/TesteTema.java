package k19.designpatterns;

public class TesteTema {
	
	public static void main(String[] args) {
		
		Tema temaFire = Tema.getInstance(Tema.FIRE);
		System.out.println("Tema: " + temaFire.getNome());
		System.out.println("Cor da fonte " + temaFire.getCorDaFonte());
		System.out.println("Cor do fundo: " + temaFire.getCorDoFundo());
		
		Tema temaFire2 = Tema.getInstance(Tema.FIRE);
		
		System.out.println("Comparando referências...");
		System.out.println(temaFire == temaFire2);
		
	}

}
