package lojacat.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lojacat.dao.ProdutoConnection;
import lojacat.dao.ProdutoDaoImpl;

/**
 * Servlet implementation class deleteProdutoController
 */
public class deleteProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProdutoDaoImpl dao = new ProdutoDaoImpl(ProdutoConnection.conectar());
			boolean f = dao.deleteProduto(id);
			if(f) 
			{
                mensagem = "Produto deletado";
			}else
			{
				mensagem = "Erro ao deletar o produto";
			}
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("mensagem", mensagem);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
	    dispatcher.forward(request, response);
	}

}
