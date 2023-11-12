package evento.dao;

import evento.model.User;

public interface UserDAO {
	
	public boolean userRegistro(User us);
	
	public User login(String email, String password);
}
