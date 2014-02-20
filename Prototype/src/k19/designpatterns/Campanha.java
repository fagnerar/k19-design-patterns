package k19.designpatterns;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Campanha implements Prototype<Campanha> {
	
	private String nome;
	private Calendar vencimento;
	private Set<String> palavrasChave;
	
	public Campanha(String nome, Calendar vencimento, Set<String> palavrasChave) {
		this.nome = nome;
		this.vencimento = vencimento;
		this.palavrasChave = palavrasChave;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public Set<String> getPalavrasChave() {
		return palavrasChave;
	}
	
	public Campanha clone() {
		String nome = "Nome da campanha: " + this.nome;
		Calendar vencimento = (Calendar) this.vencimento.clone();
		Set<String> palavrasChave = new HashSet<>(this.palavrasChave);
		Campanha campanha = new Campanha(nome, vencimento, palavrasChave);
		
		return campanha;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("-------------");
		sb.append("\n");
		sb.append("Nome da Campanha: ");
		sb.append(this.nome);
		sb.append("\n");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String format = sdf.format(this.vencimento.getTime());
		sb.append("Vencimento: " + format);
		sb.append("\n");
		
		sb.append("Palavras chave: \n" );
		for (String p : palavrasChave) {
			sb.append(" - " + p);
			sb.append("\n");
		}
		
		sb.append("------------");
		sb.append("\n");
		
		return sb.toString();
	}
	
}
