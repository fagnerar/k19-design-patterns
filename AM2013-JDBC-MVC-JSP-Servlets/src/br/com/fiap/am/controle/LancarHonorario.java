package br.com.fiap.am.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.bo.ProcessoBO;
import br.com.fiap.am.bo.TipoTarefaBO;

@WebServlet("/lancarHonorario")
public class LancarHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public LancarHonorario() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProc"));
		
		ProcessoBO procBO = new ProcessoBO();
		ProcessoBean proc = procBO.consultProcCli(nroProcesso);
		
		HttpSession session = request.getSession();
		session.setAttribute("proc", proc);
		
		ProcessoBean proc2 = procBO.consultProcAdv(nroProcesso);
		
		request.setAttribute("proc2", proc2);
		
		TipoTarefaBO tipoTarBO = new TipoTarefaBO();
		List<TipoTarefaBean> tipoTarList = tipoTarBO.listarTipoTarefa();
		request.setAttribute("tipoTList", tipoTarList);
		
		HonorarioBean honorario = new HonorarioBean(); //cria um honorario vazio que será usado nos campos
		request.setAttribute("honorario", honorario);
		
		request.getRequestDispatcher("lancarHonorario.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
