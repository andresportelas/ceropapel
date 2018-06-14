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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Portela
 */
public class Inventario {

    ConexionBD con = new ConexionBD();
    Statement st = con.ComnexionBD();

    private String nombreE;
    private String placa;
    private String marca;
    private String modelo;
    private String serial;
    private String cantidad;
    private String fechas;
    private String fechaE;
    private String descripcion;

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void insertarI() {
        try {
            Connection cone = con.ComnexionBD().getConnection();
            PreparedStatement sql = cone.prepareStatement("insert into inventario (tipoe,marcae,modelo,seriale,placae,descripcione,cantidade,fingreso,fsalida) values(?,?,?,?,?,?,?,?,?)");
            sql.setString(1, this.getNombreE());
            sql.setString(2, this.getPlaca());
            sql.setString(3, this.getMarca());
            sql.setString(4, this.getModelo());
            sql.setString(5, this.getSerial());
            sql.setString(6, this.getCantidad());
            sql.setString(7, this.getFechaE());
            sql.setString(8, this.getFechas());
            sql.setString(9, this.getDescripcion());
            sql.executeUpdate();
            if (sql != null) {
                JOptionPane.showMessageDialog(null, "se inserto");
            } else {
                JOptionPane.showMessageDialog(null, "no se inserto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Iterator<Inventario> buscar() {
        try {
            Connection c = con.ComnexionBD().getConnection();
            PreparedStatement sql = c.prepareStatement("select * from inventario ");
            ResultSet rs=sql.executeQuery();
            while(rs.next()){
            Inventario in=new Inventario();
            in.setNombreE(rs.getString("tipo"));
            in.setPlaca(rs.getString("marcae"));
        } 
        }
            catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
