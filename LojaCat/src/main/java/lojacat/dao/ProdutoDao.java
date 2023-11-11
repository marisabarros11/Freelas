package lojacat.dao;

import java.util.List;

import lojacat.model.Produto;

public interface ProdutoDao {

	public boolean cadastrarProduto(Produto produto);
	
	public List<Produto> getAllProduto();
	
	public Produto getProdutoById(int id);
	
	public boolean editarProduto(Produto produto);
	
	public boolean deleteProduto(int id);
}
