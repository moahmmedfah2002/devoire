package ma.ensa.connexion;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Data
public class Connexion {
    public Connection con;
    public Connexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/devoir1","root","");


    }
}