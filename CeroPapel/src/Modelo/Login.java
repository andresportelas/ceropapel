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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Portela
 */
public class Login {

    ConexionBD co = new ConexionBD();
    Statement st = co.ComnexionBD();
    private String nombre;
    private String apellido;
    private String documento;
    private String numero;
    private String correo;
    private String direccion;
    private String telefono;
    private String usuario;
    private String contraseña;
    private String rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Iterator<Login> validar(String ingreso) {
        ArrayList<Login> user = new ArrayList<>();
        try {
            Connection cone = st.getConnection();
            PreparedStatement sql = cone.prepareStatement("Select * from usu where usuario=?");
            sql.setString(1, ingreso);
             ResultSet rs=sql.executeQuery();
               while(rs.next()){
               Login lo = new Login();
               lo.setNombre(rs.getString("nombreu"));
               lo.setRol(rs.getString("rol"));
               lo.setUsuario(rs.getString("usuario"));
               lo.setNumero(rs.getString("numerou"));
               lo.setContraseña(rs.getString("contraseñau"));
                   System.out.println(lo.getContraseña());
               user.add(lo);
           }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user.iterator();
    }
}
