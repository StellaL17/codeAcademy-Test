package org.test.dbConn;

import java.util.List;

public interface UsersDAO {
	
	public String insertUsersinDB(Korisnik user); 
	public List<Korisnik> getAllUsers();
	public Korisnik getUsersByID(Integer id);
	
	public String insertUserInDBwithPreparedStatement(Korisnik user);

}
