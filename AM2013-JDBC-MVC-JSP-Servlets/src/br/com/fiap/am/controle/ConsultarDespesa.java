package br.com.fiap.am.controle;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.bo.DespesaBO;
import br.com.fiap.am.bo.TipoDespesaBO;

@WebServlet("/consultarDespesa")
public class ConsultarDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ConsultarDespesa() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cdDespesa = Integer.parseInt(request.getParameter("cdDesp"));
		HttpSession session = request.getSession();
		session.setAttribute("cdDesp", cdDespesa);
		
		DespesaBO despBO = new DespesaBO();
		DespesaBean despesa = despBO.consultarDespesa(cdDespesa);
		request.setAttribute("despesa", despesa);
		
		DecimalFormat df = new DecimalFormat("#.00");
	    String vlDesp = df.format(despesa.getValorDespesa());
	    request.setAttribute("vlDesp", vlDesp);
		
		TipoDespesaBO tipoDespBO = new TipoDespesaBO();
		List<TipoDespesaBean> tipoDespList = tipoDespBO.listarTipoDespesas();
		request.setAttribute("tipoDList", tipoDespList);
		
		request.getRequestDispatcher("editarDespesa.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
