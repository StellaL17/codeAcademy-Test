package org.test.dbConn;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        UsersDAO dao = new UsersDAOImpl();
        
//        Korisnik user1 = new Korisnik(3, "Aleksandar", "aleksandar1", "123456");
//        
//        dao.insertUsersinDB(user1);
        
        List<Korisnik> allUsers = new ArrayList<Korisnik>();
        allUsers = dao.getAllUsers();
        
//        System.out.println("All users from db: " + allUsers.toString());
        
        Korisnik user2 = new Korisnik();
        
        user2 = dao.getUsersByID(2);
        System.out.println(user2.getName());
        
        Korisnik user3 = new Korisnik(7, "Martin", "martin@gmail.com", "123456");
        System.out.println(dao.insertUserInDBwithPreparedStatement(user3));
    }
}
