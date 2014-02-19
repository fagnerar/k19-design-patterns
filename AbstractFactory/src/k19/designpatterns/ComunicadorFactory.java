package k19.designpatterns;

public interface ComunicadorFactory {
	
	Emissor createEmissor();
	Receptor createReceptor();

}
