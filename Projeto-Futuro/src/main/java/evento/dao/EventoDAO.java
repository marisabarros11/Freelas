package evento.dao;

import java.util.List;

import evento.model.Evento;

public interface EventoDAO {
	
	public boolean addEvento(Evento evento);
	
	public List<Evento> getAllEventos();
	
	public boolean deleteEvento(int id);
}
