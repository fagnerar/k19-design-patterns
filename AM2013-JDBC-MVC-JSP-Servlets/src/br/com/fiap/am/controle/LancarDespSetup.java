package br.com.fiap.am.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.bo.DespesaBO;

@WebServlet("/lancarDespSetup")
public class LancarDespSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public LancarDespSetup() {
        super();
      
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DespesaBean despesa = new DespesaBean();
		
		ProcessoBean processo = (ProcessoBean)(request.getSession().getAttribute("proc"));
		
		despesa.setProcesso(processo);
		
		
		TipoDespesaBean tipoDespesa = new TipoDespesaBean();
		String descricao = request.getParameter("despesa");
		tipoDespesa.setDescricao(descricao);
		
		despesa.setTipoDespesa(tipoDespesa);
		
		
		String dataStr = request.getParameter("dataDespesa");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = sdf.parse(dataStr);
			despesa.setDataDespesa(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		String valorStr = request.getParameter("valorDespesa");
		valorStr = valorStr.substring(3);
		valorStr = valorStr.replace(",", ".");
		double valor = Double.parseDouble(valorStr);
		despesa.setValorDespesa(valor);
		
		
		String obs = request.getParameter("observacoes");
		despesa.setObs(obs);
		
		
		DespesaBO despBO = new DespesaBO();
		despBO.incluirDespesa(despesa);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
