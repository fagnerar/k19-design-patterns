package br.com.fiap.am.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bo.DespesaBO;
import br.com.fiap.am.bo.ProcessoBO;


@WebServlet("/listarDespesa")
public class ListarDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListarDespesa() {
        super();
    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProc"));
		
		ProcessoBO procBO = new ProcessoBO();
		ProcessoBean processo = procBO.consultProcCli(nroProcesso);
		
		
		DespesaBO despBO = new DespesaBO();
		List<DespesaBean> despList = null;
		
		despList = despBO.listarDespesas(nroProcesso);
		
		HttpSession session = request.getSession();
		session.setAttribute("proc", processo);
		
		request.setAttribute("despList", despList);
		
		request.getRequestDispatcher("listarDespesas.jsp").forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
