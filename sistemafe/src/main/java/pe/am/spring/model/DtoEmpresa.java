/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

/**
 *
 * @author USUARIO
 */
public class DtoEmpresa {
    public String ruc;
    public String rsocial;
    public String fecIni;
    public String ubigeo;
    public String direccion;
    public String telef;
    public boolean error_flag=false;
    public String error_msj=null;
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public boolean isError_flag() {
        return error_flag;
    }

    public void setError_flag(boolean error_flag) {
        this.error_flag = error_flag;
    }

    public String getError_msj() {
        return error_msj;
    }

    public void setError_msj(String error_msj) {
        this.error_msj = error_msj;
    }
    
}
