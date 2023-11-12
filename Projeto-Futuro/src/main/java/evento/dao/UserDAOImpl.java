package evento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import evento.model.User;

public class UserDAOImpl implements UserDAO{
	
	private Connection conn;
	
	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegistro(User us) {
		boolean f = false;
		
		try {
			String sql = "INSERT INTO usuarios (nome,email,telefone,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getNome());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getTelefone());
			ps.setString(4, us.getPassword());
			
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

	@Override
	public User login(String email, String password) {
		User us = null;
		
		try {
			String sql = "SELECT * FROM usuarios where email=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next())
			{
				us = new User();
				us.setId(rs.getInt(1));
				us.setNome(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setTelefone(rs.getString(4));
				us.setPassword(rs.getString(5));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return us;
	}
	
	
}
