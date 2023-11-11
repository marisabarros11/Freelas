package lojacat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lojacat.model.Produto;

public class ProdutoDaoImpl implements ProdutoDao{

	private Connection con;
	
	public ProdutoDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean cadastrarProduto(Produto produto) {
		boolean f = false;
		try {
			String sql = "INSERT INTO produto(codigo,descricao,categoria,marca,preco,detalhe,imagem) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, produto.getCodigo());
			ps.setString(2, produto.getDescricao());
			ps.setString(3, produto.getCategoria());
			ps.setString(4, produto.getMarca());
			ps.setString(5, produto.getPreco());
			ps.setString(6, produto.getDetalhe());
			ps.setString(7, produto.getNomeImagem());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	@Override
	public List<Produto> getAllProduto() {
		
		List<Produto> list = new ArrayList<Produto>();
		Produto produto = null;	
		
		try {
			
			String sql = "SELECT * FROM produto";
			PreparedStatement ps =con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				produto = new Produto();
				produto.setIdProduto(rs.getInt(1));
				produto.setCodigo(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setMarca(rs.getString(5));
				produto.setPreco(rs.getString(6));
				produto.setDetalhe(rs.getString(7));
				produto.setNomeImagem(rs.getString(8));
				list.add(produto);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Produto getProdutoById(int id) {
		Produto produto = null;
		
		try {
			String sql = "SELECT * FROM produto WHERE idProduto=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				produto = new Produto();
				produto.setIdProduto(rs.getInt(1));
				produto.setCodigo(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setMarca(rs.getString(5));
				produto.setPreco(rs.getString(6));
				produto.setDetalhe(rs.getString(7));
				produto.setNomeImagem(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return produto;
	}

	@Override
	public boolean editarProduto(Produto produto) {
		boolean f=false;
		
		try {
			
			String sql = "UPDATE produto SET codigo=?,descricao=?,categoria=?,marca=?,preco=?,detalhe=?,imagem=? WHERE idProduto=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, produto.getCodigo());
			ps.setString(2, produto.getDescricao());
			ps.setString(3, produto.getCategoria());
			ps.setString(4, produto.getMarca());
			ps.setString(5, produto.getPreco());
			ps.setString(6, produto.getDetalhe());
			ps.setString(7, produto.getNomeImagem());
			ps.setInt(8, produto.getIdProduto());
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	@Override
	public boolean deleteProduto(int id) {
		boolean f = false;
		
		try {
			String sql = "DELETE FROM produto WHERE idProduto=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) 
			{
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}		
}
