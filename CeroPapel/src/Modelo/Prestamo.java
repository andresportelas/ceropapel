/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Portela
 */
public class Prestamo {

    ConexionBD con = new ConexionBD();
    Statement st = con.ComnexionBD();   

    private String tipo;
    private String nombree;
    private String apellidoe;
    private String placa;
    private String marca;
    private String modelo;
    private String serial;
    private String descripcion;
    private String fecha;
    private String fechae;
    private String numerod;
    private String responsable;
    private String autoriza;
    private String nombreele;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreele() {
        return nombreele;
    }

    public void setNombreele(String nombreele) {
        this.nombreele = nombreele;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }
    public String getApelldioe(){
        return apellidoe;
    }
    public void setApellidoe(String apellidoe){
         this.apellidoe=apellidoe;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechae() {
        return fechae;
    }

    public void setFechae(String fechae) {
        this.fechae = fechae;
    }

    public String getNumerod() {
        return numerod;
    }

    public void setNumerod(String numerod) {
        this.numerod = numerod;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public void inserta() {
        try {
           Connection cone=con.ComnexionBD().getConnection();
            PreparedStatement sql=cone.prepareStatement("insert into prestamo(placae,numerou,numeroa,estado,fegreso,fingreso) values (?,?,?,?,?,?)");
             sql.setString(1, this.getPlaca());
             sql.setString(2,this.getResponsable());
             sql.setString(3, this.getNombree());
             sql.setString(4, this.getEstado());
             sql.setString(5, this.getFecha());
             sql.setString(6, this.getFechae());
            int retu=sql.executeUpdate();
            if(retu>0){
                JOptionPane.showMessageDialog(null, "se inserto correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "no se inserto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
