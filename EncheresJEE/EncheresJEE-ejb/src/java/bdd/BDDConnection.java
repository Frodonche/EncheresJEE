package bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steve
 */
public class BDDConnection {
    /*private String url = "sql7.freemysqlhosting.net/sql7275157";
    private String username = "sql7275157";
    private String password = "9a9xHIhvuB";*/
    private String url = "jdbc:derby://localhost:1527/encheres";
    private String username = "root";
    private String password = "pass";

    BDDConnection() {}
    
    public static BDDConnection getInstance(){
        BDDConnection instance = new BDDConnection();
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection( url, username, password );
    }
    
    public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
}
