package br.com.fiap.am.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.bo.HonorarioBO;

@WebServlet("/excluirHonorario")
public class ExcluirHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExcluirHonorario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HonorarioBO honoBO = new HonorarioBO();
		
		int cdHonorario = Integer.parseInt(request.getParameter("cdHono"));
		
		honoBO.excluirHonorario(cdHonorario);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
