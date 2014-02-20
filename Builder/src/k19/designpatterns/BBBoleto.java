package k19.designpatterns;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BBBoleto implements Boleto {
	
	private String sacado;
	private String cedente;
	private double valor;
	private Calendar vencimento;
	private int nossoNumero;
	
	public BBBoleto(String sacado, String cedente, double valor,
			Calendar vencimento, int nossoNumero) {
		this.sacado = sacado;
		this.cedente = cedente;
		this.valor = valor;
		this.vencimento = vencimento;
		this.nossoNumero = nossoNumero;
	}

	public String getSacado() {
		return sacado;
	}

	public String getCedente() {
		return cedente;
	}

	public double getValor() {
		return valor;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public int getNossoNumero() {
		return nossoNumero;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Boleto BB");
		sb.append("\n");
		
		sb.append("Sacado: " + this.sacado);
		sb.append("\n");
		
		sb.append("Cedente: " + this.cedente);
		sb.append("\n");
		
		sb.append("Valor: " + this.valor);
		sb.append("\n");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String format = sdf.format(this.vencimento.getTime());
		sb.append("Vencimento: " + format);
		sb.append("\n");
		
		sb.append("Nosso número: " + this.nossoNumero);
		sb.append("\n");
		
		return sb.toString();
		
	}

}
