package br.com.fiap.am.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.bo.DespesaBO;


@WebServlet("/excluirDespesa")
public class ExcluirDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirDespesa() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DespesaBO despBO = new DespesaBO();
		
		int cdDespesa = Integer.parseInt(request.getParameter("cdDesp"));
		
		despBO.excluirDespesa(cdDespesa);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
