package evento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import evento.model.Evento;

public class EventoDAOImpl implements EventoDAO{

	private Connection conn;
	
	public EventoDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addEvento(Evento evento) {
		boolean f = false;
		try {
			String sql = "INSERT INTO evento (titulo, localizacao, descricao, data) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, evento.getTitulo());
			ps.setString(2, evento.getLocalizacao());
			ps.setString(3, evento.getDescricao());
			// Converte a data e os horários para os tipos apropriados
            ps.setDate(4, new Date(evento.getData().getTime()));
			int i = ps.executeUpdate();
			
			if (i==1) 
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}


	@Override
	public List<Evento> getAllEventos() {
		
		List<Evento> list = new ArrayList<Evento>();
		
		Evento evento = null;
		
		try {
			String sql = "SELECT * FROM evento";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				evento = new Evento();
				evento.setIdEvento(rs.getInt(1));
				evento.setTitulo(rs.getString(2));
				evento.setLocalizacao(rs.getString(3));
				evento.setDescricao(rs.getString(4));
				evento.setData(rs.getDate(5));
				list.add(evento);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean deleteEvento(int id) {
		boolean f = false;
		
		try {	
			String sql = "DELETE FROM evento WHERE idEvento=?";
			PreparedStatement ps = conn.prepareStatement(sql);
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
