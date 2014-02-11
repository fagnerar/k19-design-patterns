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

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.bo.HonorarioBO;


@WebServlet("/alterarHonorario")
public class AlterarHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarHonorario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HonorarioBean honoUp = new HonorarioBean();
		
		HttpSession session = request.getSession();
		int cdHonorario = (int)session.getAttribute("cdHono");
		
		honoUp.setCdHonorario(cdHonorario);
		
		String dataStr = request.getParameter("dataHonorario");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date data = sdf.parse(dataStr);
			honoUp.setDataHonorario(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String qtdeHorasStr = request.getParameter("qtdeHoras");
		qtdeHorasStr = qtdeHorasStr.replace(",", ".");
		double qtdeHoras = Double.parseDouble(qtdeHorasStr);
		honoUp.setQtdeHoras(qtdeHoras);
		
		String obs = request.getParameter("observacoes");
		honoUp.setObs(obs);
		
		HonorarioBO honoBO = new HonorarioBO();
		honoBO.alterarHonorario(honoUp);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
