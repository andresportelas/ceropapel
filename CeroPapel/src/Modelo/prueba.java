/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andres Portela
 */
public class prueba {
    
    
    private String nombrea;
    private String apellidoa;
    private String tipodocumentoa;

    public prueba(String nombrea, String apellidoa, String tipodocumentoa) {
        this.nombrea = nombrea;
        this.apellidoa = apellidoa;
        this.tipodocumentoa = tipodocumentoa;
    }

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

    public String getTipodocumentoa() {
        return tipodocumentoa;
    }

    public void setTipodocumentoa(String tipodocumentoa) {
        this.tipodocumentoa = tipodocumentoa;
    }
    
    
    
}
