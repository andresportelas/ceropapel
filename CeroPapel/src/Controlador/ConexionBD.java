/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Portela
 */
public class ConexionBD {
    
    private String user = "postgres";
    private String pass = "lola";
    private String bd = "ceropapel";
    private String url = "jdbc:postgresql://localhost:5432/ceropapel";

    public Statement ComnexionBD() {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("ya esta conectado " + url);
                st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex);
        }
        return st;
    }
    
    
}
