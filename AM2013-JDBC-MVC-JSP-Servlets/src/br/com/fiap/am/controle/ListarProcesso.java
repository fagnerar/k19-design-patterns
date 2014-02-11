package br.com.fiap.am.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bo.ProcessoBO;

@WebServlet("/listaProcessos")
public class ListarProcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListarProcesso() {
        super();
        }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProcessoBO procBO = new ProcessoBO();
		
		List<ProcessoBean> procList = null;
		
		procList = procBO.listarProcessos();
		
		request.setAttribute("procList", procList);
		
		request.getRequestDispatcher("listarProcessos.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
