package lojacat.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginConnection
 */
public class loginConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		
		try {
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
	        String n = request.getParameter("txtName");
	        String p = request.getParameter("txtPwd");

	        PreparedStatement ps = con.prepareStatement("SELECT UNAME FROM LOGIN WHERE UNAME=? AND PASSWORD=?");
	        ps.setString(1, n);
	        ps.setString(2, p);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	
	        	mensagem = "Login efetuado com sucesso";
	            request.getSession().setAttribute("username", n);
	            request.setAttribute("mensagem", mensagem);
	            RequestDispatcher rd = request.getRequestDispatcher("consultarProduto.jsp");
	            rd.forward(request, response);
	            
	        } else {
	        	mensagem = "Usuário ou senha inválidos, tente novamente";
	        	request.setAttribute("mensagem", mensagem);
	        	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            rd.forward(request, response);
	        }

	    } catch (ClassNotFoundException e) {

	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
