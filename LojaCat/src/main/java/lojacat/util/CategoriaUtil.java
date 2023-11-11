package lojacat.util;

import lojacat.dao.ProdutoConnection;
import lojacat.dao.ProdutoDao;
import lojacat.dao.ProdutoDaoImpl;
import lojacat.model.Produto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoriaUtil {

    private static final Map<String, String> categoriasParaPaginas = new HashMap<>();

    static {
        categoriasParaPaginas.put("Madeira", "madeira.jsp");
        categoriasParaPaginas.put("Pelúcia", "pelucia.jsp");
        categoriasParaPaginas.put("Plástico", "plastico.jsp");
        // Adicione mais categorias conforme necessário
    }

    public static String obterPaginaCategoria(String categoria) {
        return categoriasParaPaginas.get(categoria);
    }

    public static List<Produto> getProdutosPorCategoria(String categoria) {
    	ProdutoDao dao = new ProdutoDaoImpl(ProdutoConnection.conectar());
        List<Produto> produtos = dao.getAllProduto();

        List<Produto> produtosDaCategoria = produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .collect(Collectors.toList());

        return produtosDaCategoria;
    }
}
