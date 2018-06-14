/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Portela
 */
public class usuario {
    ConexionBD con=new ConexionBD();
    Statement st=con.ComnexionBD();
    private String nombreu;
    private String apellidou;
    private String documentou;
    private String numerou;
    private String direccionu;
    private String telefonou;
    private String correou;
    private String cargou;
    private String usuario;
    private String  contrasena;
    private String rol;

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getApellidou() {
        return apellidou;
    }

    public void setApellidou(String apellidou) {
        this.apellidou = apellidou;
    }

    public String getDocumentou() {
        return documentou;
    }

    public void setDocumentou(String documentou) {
        this.documentou = documentou;
    }

    public String getNumerou() {
        return numerou;
    }

    public void setNumerou(String numerou) {
        this.numerou = numerou;
    }

    public String getDireccionu() {
        return direccionu;
    }

    public void setDireccionu(String direccionu) {
        this.direccionu = direccionu;
    }

    public String getTelefonou() {
        return telefonou;
    }

    public void setTelefonou(String telefonou) {
        this.telefonou = telefonou;
    }

    public String getCorreou() {
        return correou;
    }

    public void setCorreou(String correou) {
        this.correou = correou;
    }

    public String getCargou() {
        return cargou;
    }

    public void setCargou(String cargou) {
        this.cargou = cargou;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
   public void insertarU(){
        try{
            Connection cone=con.ComnexionBD().getConnection();
            PreparedStatement sql=cone.prepareStatement   ("insert into usu (nombreu,apellidou,documentou,numerou,correou,direccionu,telefonou,usuario,contraseñau,rol)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.setString(1,this.getNombreu());
            sql.setString(2,this.getApellidou());
            sql.setString(3, this.getDocumentou());
            sql.setString(4,this.getNumerou());
            sql.setString(5, this.getCorreou());
            sql.setString(6, this.getDireccionu());
            sql.setString(7,this.getTelefonou() );
            sql.setString(8, this.getUsuario());
            sql.setString(9, this.getContrasena());
            sql.setString(10, this.getRol());
            sql.executeUpdate();
            if(sql!=null){
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void buscarU(){
       
       try{
           ResultSet sql=st.executeQuery("select* from usuario");
           while(sql.next()){
               usuario nu=new usuario();
               nu.setNombreu(sql.getString("nombreu"));
               nu.setApellidou(sql.getString("apellidou"));
               nu.setDocumentou(sql.getString("documentou"));
               nu.setNumerou(sql.getString("numerou"));
               nu.setDireccionu(sql.getString("direccionu"));
               nu.setTelefonou(sql.getString("correou"));
               nu.setCargou(sql.getString("cargou"));
               nu.setRol(sql.getString("rol"));
           }
       } catch (SQLException ex) { 
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }
}
