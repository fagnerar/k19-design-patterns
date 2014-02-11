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

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.bo.HonorarioBO;
import br.com.fiap.am.bo.ProcessoBO;
import br.com.fiap.am.bo.TipoTarefaBO;


@WebServlet("/consultarHonorario")
public class ConsultarHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConsultarHonorario() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cdHonorario = Integer.parseInt(request.getParameter("cdHono"));
		
		ProcessoBean processo = (ProcessoBean)request.getSession().getAttribute("proc");
		int nroProcesso = processo.getNroProcesso();
		
		HonorarioBO honoBO = new HonorarioBO();
		HonorarioBean honorario = honoBO.consultarHonorario(cdHonorario);
		
		DecimalFormat df = new DecimalFormat("#.00");
	    String qtdeHStr = df.format(honorario.getQtdeHoras());
	    
	    request.setAttribute("qtdeH", qtdeHStr);
	    
	    
		ProcessoBO procBO = new ProcessoBO();
		ProcessoBean procAdv = procBO.consultProcAdv(nroProcesso);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("proc", processo);
		session.setAttribute("cdHono", cdHonorario);
		
		TipoTarefaBO tipoTBO = new TipoTarefaBO();
		List<TipoTarefaBean> tipoTList = tipoTBO.listarTipoTarefa();
		
		request.setAttribute("tipoTList", tipoTList);
		request.setAttribute("honor", honorario);
		request.setAttribute("proc2", procAdv);
		
		request.getRequestDispatcher("editarHonorario.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
