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
import javax.servlet.http.HttpSession;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.bo.DespesaBO;


@WebServlet("/alterarDespesa")
public class AlterarDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public AlterarDespesa() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DespesaBean despBean = new DespesaBean();
		DespesaBO despBO = new DespesaBO();
		
		
		String dataStr = request.getParameter("dataDespesa");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date data = sdf.parse(dataStr);
			despBean.setDataDespesa(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String valorStr = request.getParameter("valorDespesa");
		valorStr = valorStr.substring(3);
		valorStr = valorStr.replace(",", ".");
		double valor = Double.parseDouble(valorStr);
		
		HttpSession session = request.getSession();
		int cdDesp = (int)session.getAttribute("cdDesp");
		
		despBean.setCdDespesa(cdDesp);
		despBean.setValorDespesa(valor);
		String obs = request.getParameter("observacoes");
		despBean.setObs(obs);
		
		despBO.alterarDepesa(despBean);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
