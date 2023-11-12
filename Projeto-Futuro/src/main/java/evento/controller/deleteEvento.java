package evento.controller;

import java.io.IOException;

import evento.dao.DBConnection;
import evento.dao.EventoDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteEvento
 */
public class deleteEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteEvento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			EventoDAOImpl dao = new EventoDAOImpl(DBConnection.getConn());
			
			boolean f = dao.deleteEvento(id);
			if(f) 
			{
                mensagem = "Evento deletado";
			}else
			{
				mensagem = "Erro ao deletar o evento";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("mensagem", mensagem);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	    dispatcher.forward(request, response);
	}


}
