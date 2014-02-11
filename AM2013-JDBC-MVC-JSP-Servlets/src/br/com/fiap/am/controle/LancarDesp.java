package br.com.fiap.am.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.bo.ProcessoBO;
import br.com.fiap.am.bo.TipoDespesaBO;

@WebServlet("/lancarDesp")
public class LancarDesp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LancarDesp() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProc"));
		ProcessoBO procBO = new ProcessoBO();
		ProcessoBean processo = procBO.consultProcCli(nroProcesso);
		
		HttpSession session = request.getSession();
		session.setAttribute("proc", processo);
		
		TipoDespesaBO tipoDespBO = new TipoDespesaBO();
		List<TipoDespesaBean> tipoDespList = tipoDespBO.listarTipoDespesas();
		request.setAttribute("tipoDList", tipoDespList);
		
		request.getRequestDispatcher("lancarDespesa.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
