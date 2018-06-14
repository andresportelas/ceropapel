/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import java.io.FileInputStream;
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
public class Aprendiz {

    ConexionBD st = new ConexionBD();
    Statement dc = st.ComnexionBD();

  private String nombrea;
  private String apellidoa;
  private String documentoa;
  private String numeroa;
  private String correoa;
  private String telefonoa;
  private String programaformacion;
  private String fechainicio;
  private String fechafin;
  private String ficha;
  private String jornada;
  private String elemento;
  private String marca;
  private String modelo;
  private String seial;
  private String descripcion;
  private Byte imagena;

    public String getNombrea() {
        return nombrea;
    }

    public void setNombrea(String nombrea) {
        this.nombrea = nombrea;
    }

    public String getApellidoa() {
        return apellidoa;
    }

    public void setApellidoa(String apellidoa) {
        this.apellidoa = apellidoa;
    }

    public String getDocumentoa() {
        return documentoa;
    }

    public void setDocumentoa(String documentoa) {
        this.documentoa = documentoa;
    }

    public String getNumeroa() {
        return numeroa;
    }

    public void setNumeroa(String numeroa) {
        this.numeroa = numeroa;
    }

    public String getCorreoa() {
        return correoa;
    }

    public void setCorreoa(String correoa) {
        this.correoa = correoa;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getProgramaformacion() {
        return programaformacion;
    }

    public void setProgramaformacion(String programaformacion) {
        this.programaformacion = programaformacion;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
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

    public String getSeial() {
        return seial;
    }

    public void setSeial(String seial) {
        this.seial = seial;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte getImagena() {
        return imagena;
    }

    public void setImagena(Byte imagena) {
        this.imagena = imagena;
    }
  
    public void insertar(FileInputStream fis,int longitudBytes){
        
        try{
            Connection cone=st.ComnexionBD().getConnection();
            PreparedStatement sql=cone.prepareStatement("insert into aprendiz (nombrea,apellidoa,documentoa,numeroa,correoa,telefonoa,programforma,finicio,ffin,ficha,jornada,elementa,marca,modelo,serial,descripcion,imagena)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, this.getNombrea());
            sql.setString(2,this.getApellidoa());
            sql.setString(3, this.getDocumentoa());
            sql.setString(4,this.getNumeroa());
            sql.setString(5,this.getCorreoa());
            sql.setString(6,this.getTelefonoa());
            sql.setString(7,this.getProgramaformacion());
            sql.setString(8,this.getFechainicio());
            sql.setString(9,this.getFechafin());
            sql.setString(10,this.getFicha());
            sql.setString(11,this.getJornada());
            sql.setString(12,this.getElemento());
            sql.setString(13,this.getMarca());
            sql.setString(14,this.getModelo());
            sql.setString(15, this.getSeial());
            sql.setString(16, this.getDescripcion());
            sql.setBinaryStream(17,fis,longitudBytes);
            sql.executeUpdate();
            
            if(sql!=null){
                JOptionPane.showMessageDialog(null, "se inserto correcta mente");
            }else{
                JOptionPane.showMessageDialog(null, "no se inserto correctamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aprendiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Iterator<Aprendiz>  buscarApre(String ndocu){
        ArrayList<Aprendiz> estu=new ArrayList<>();
        try{
            Connection con=st.ComnexionBD().getConnection();
            PreparedStatement sql=con.prepareStatement("select ida, nombrea, apellidoa, documentoa, correoa, telefonoa, programforma, finicio, ffin, ficha, jornada, elementa, marca, modelo, serial, descripcion from aprendiz where numeroa=?");
            sql.setString(1, this.getNumeroa());
            ResultSet rs=sql.executeQuery();
            while(rs.next()){
                Aprendiz ta=new Aprendiz();
                ta.setNombrea(rs.getString("nombrea"));
                ta.setApellidoa(rs.getString("apellidoa"));
                ta.setDocumentoa(rs.getString("documentoa"));
                ta.setCorreoa(rs.getString("correoa"));
                ta.setTelefonoa(rs.getString("telefonoa"));
                ta.setProgramaformacion(rs.getString("programforma"));
                ta.setFechainicio(rs.getNString("finicio"));
                ta.setFechafin(rs.getString("ffin"));
                ta.setFicha(rs.getString("ficha"));
                ta.setJornada(rs.getString("jornada"));
                ta.setElemento(rs.getString("elementa"));
                ta.setMarca(rs.getString("marca"));
                ta.setModelo(rs.getString("modelo"));
                ta.setSeial(rs.getString("serial"));
                ta.setDescripcion(rs.getString("descripcion"));
                estu.add(ta);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Aprendiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estu.iterator();
    }
}
