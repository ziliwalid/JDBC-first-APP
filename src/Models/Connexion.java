package Models;
import java.sql.*;

public class Connexion {
    private static Connection con=null;

    private Connexion() {
                try {
                    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/messageriejava","root","");
                } catch (SQLException e) {
                   e.printStackTrace();
                }
    }

    public static Connection connect(){
        if (con==null){
            new Connexion();
        }
        return con;
    }
    
}
