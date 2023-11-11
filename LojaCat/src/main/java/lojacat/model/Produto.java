package lojacat.model;

public class Produto {
	
	private int idProduto;
	private String codigo;
	private String descricao;
	private String categoria;
	private String marca;
	private String preco;
	private String detalhe;
	private String  nomeImagem;
	
	
	public Produto() {
		
	}

	public Produto(String codigo, String descricao, String categoria, String marca, String preco, String detalhe,
			String nomeImagem) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.marca = marca;
		this.preco = preco;
		this.detalhe = detalhe;
		this.nomeImagem = nomeImagem;
	}


	public Produto(int idProduto, String codigo, String descricao, String categoria, String marca, String preco,
			String detalhe, String nomeImagem) {
		super();
		this.idProduto = idProduto;
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.marca = marca;
		this.preco = preco;
		this.detalhe = detalhe;
		this.nomeImagem = nomeImagem;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", codigo=" + codigo + ", descricao=" + descricao + ", categoria="
				+ categoria + ", marca=" + marca + ", preco=" + preco + ", detalhe=" + detalhe + ", nomeImagem="
				+ nomeImagem + "]";
	}
}
