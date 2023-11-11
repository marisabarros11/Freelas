package lojacat.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lojacat.dao.ProdutoConnection;
import lojacat.dao.ProdutoDao;
import lojacat.dao.ProdutoDaoImpl;
import lojacat.model.Produto;

@MultipartConfig
/**
 * Servlet implementation class cadastrarProdutoController
 */
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarProdutoController() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String mensagem = "";

        try {
            String codigo = request.getParameter("codigo");
            String descricao = request.getParameter("descricao");
            String categoria = request.getParameter("categoria");
            String marca = request.getParameter("marca");
            String valor = request.getParameter("valor");
            String detalhe = request.getParameter("detalhe");
            Part file = request.getPart("nomeImagem");
            String nomeImagem = file.getSubmittedFileName();

            if (codigo != null && !codigo.isEmpty() &&
                descricao != null && !descricao.isEmpty() &&
                categoria != null && !categoria.isEmpty() &&
                detalhe != null && !detalhe.isEmpty() &&
                marca != null && !marca.isEmpty() &&
                valor != null && !valor.isEmpty() &&
                nomeImagem != null && !nomeImagem.isEmpty()) {

                try {
                    valor = valor.replace(",", ".");
                    if (valor.matches("^\\d+\\.\\d{2}$")) {
                        double valorDouble = Double.parseDouble(valor);

                        Produto produto = new Produto(codigo, descricao, categoria, marca, valor, detalhe, nomeImagem);

                        ProdutoDao dao = new ProdutoDaoImpl(ProdutoConnection.conectar());

                        boolean f = dao.cadastrarProduto(produto);

                        if (f) {
                            mensagem = "Produto adicionado";
                            // substituir pelo caminho do projeto no computador, ou do local onde o site será hospedado.
                            String uploadPath ="C:/Users/users/eclipse-workspace/LojaCat/WebContent/img/produtos/"+nomeImagem;
                            FileOutputStream fos = new FileOutputStream(uploadPath);
                            InputStream is = file.getInputStream();

                            byte[] data = new byte[is.available()];
                            is.read(data);
                            fos.write(data);
                            fos.close();
                        } else {
                            mensagem = "Erro ao adicionar o produto";
                        }
                    } else {
                        mensagem = "Erro: O campo 'Valor' deve ser um número decimal válido com duas casas decimais.";
                        request.setAttribute("codigo", codigo);
                        request.setAttribute("descricao", descricao);
                        request.setAttribute("categoria", categoria);
                        request.setAttribute("marca", marca);
                        request.setAttribute("valor", valor);
                        request.setAttribute("detalhe", detalhe);
                        request.setAttribute("nomeImagem", nomeImagem);
                    }
                } catch (NumberFormatException e) {
                    mensagem = "Erro: O campo 'Valor' deve ser um número decimal válido.";
                }
            } else {
                mensagem = "Erro: Preencha todos os campos obrigatórios, incluindo a imagem.";
                request.setAttribute("codigo", codigo);
                request.setAttribute("descricao", descricao);
                request.setAttribute("categoria", categoria);
                request.setAttribute("marca", marca);
                request.setAttribute("valor", valor);
                request.setAttribute("detalhe", detalhe);
                request.setAttribute("nomeImagem", nomeImagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
        dispatcher.forward(request, response);
    }
}
