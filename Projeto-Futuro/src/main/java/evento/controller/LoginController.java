package evento.controller;

import java.io.IOException;
import java.sql.Connection;

import evento.dao.DBConnection;
import evento.dao.UserDAOImpl;
import evento.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensagem = "";
		
		try {
			
			UserDAOImpl dao = new UserDAOImpl(DBConnection.getConn());
			
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			if("admin@gmail.com".equals(email) && "admin".equals(senha)){
				
				User us = new User();
				mensagem = "Login realizado com sucesso";

				session.setAttribute("mensagem", us);
				request.setAttribute("mensagem", mensagem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		        dispatcher.forward(request, response);
				
			}else {
				
				User us = dao.login(email, senha);
				if(us!=null)
				{	mensagem = "Login realizado com sucesso";
					session.setAttribute("mensagem", us);
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher("consultarEvento.jsp");
			        dispatcher.forward(request, response);
				}else {
					mensagem = "E-mail ou senha inválidos, tente novamente";
					session.setAttribute("mensagem", mensagem);
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			        dispatcher.forward(request, response);
				}
		        
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
