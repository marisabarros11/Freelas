package evento.model;

import java.util.Date;

public class Evento {
    private int idEvento;
    private String titulo;
    private String localizacao;
    private String descricao;
    private Date data;
	
	public Evento() {
		super();
	}
	
	public Evento(String titulo, String localizacao, String descricao, Date data) {
		super();
		this.titulo = titulo;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.data = data;
	}

	public Evento(int idEvento, String titulo, String localizacao, String descricao, Date data) {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.data = data;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
