package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by batman on 24/05/2016.
 */
public class DAO {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    String url="jdbc:postgresql://localhost:5432/devweb";
    String usuario="joao";
    String senha= "postgres";

    protected void open()throws Exception{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, usuario, senha);
    }

    protected void close()throws Exception{
        con.close();
    }
}
