package evento.controller;

import java.io.IOException;

import evento.dao.DBConnection;
import evento.dao.UserDAOImpl;
import evento.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroController
 */
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensagem = "";
		
		try {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			String senha = request.getParameter("senha");
			
			//System.out.println(nome+" "+email+" "+telefone+" "+senha);
			
			User us = new User();
			us.setNome(nome);
			us.setEmail(email);
			us.setTelefone(telefone);
			us.setPassword(senha);
			
			UserDAOImpl dao = new UserDAOImpl(DBConnection.getConn());
			boolean f = dao.userRegistro(us);
			
			if(f)
			{
				mensagem = "Usuário Registrado com sucesso";

			}else {
				mensagem = "Erro ao registrar Usuário";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}

}
