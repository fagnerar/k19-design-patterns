package k19.designpatterns;

public class TesteEmissores {

	public static void main(String[] args) {
		
		EmissorCreator creator = new EmissorCreator();
		
		Emissor emSMS = creator.create(EmissorCreator.SMS);
		emSMS.envia("Esta � a minha mensagem");
		
		Emissor emEmail = creator.create(EmissorCreator.EMAIL);
		emEmail.envia("Esta � a minha mensagem");
		
		Emissor emJMS = creator.create(EmissorCreator.JMS);
		emJMS.envia("Esta � a minha mensagem");
		
	}

}
