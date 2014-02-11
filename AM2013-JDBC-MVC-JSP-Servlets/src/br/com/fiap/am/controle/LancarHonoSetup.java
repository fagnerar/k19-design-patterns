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

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.bo.HonorarioBO;


@WebServlet("/lancarHonoSetup")
public class LancarHonoSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LancarHonoSetup() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HonorarioBean honorario = new HonorarioBean();
		TipoTarefaBean tipoTarefa = new TipoTarefaBean();
		
		ProcessoBean processo = (ProcessoBean)(request.getSession().getAttribute("proc"));
		honorario.setProcesso(processo);
		
		String descricao = request.getParameter("tipoTar");
		tipoTarefa.setDescricao(descricao);
		honorario.setTipoTarefa(tipoTarefa);
		
		String dataStr = request.getParameter("dataHonorario");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = sdf.parse(dataStr);
			honorario.setDataHonorario(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String qtdeHoraStr = request.getParameter("qtdeHoras");
		qtdeHoraStr = qtdeHoraStr.replace(",", ".");
		double qtdeHoras = Double.parseDouble(qtdeHoraStr);
		honorario.setQtdeHoras(qtdeHoras);
		
		String obs = request.getParameter("observacoes");
		honorario.setObs(obs);
		
		HonorarioBO honoBO = new HonorarioBO();
		honoBO.incluirHonorario(honorario);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
