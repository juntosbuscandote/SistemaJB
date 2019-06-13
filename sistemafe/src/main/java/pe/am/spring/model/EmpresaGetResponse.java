/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

import java.util.Date;

/**
 *
 * @author Asesores A&M
 */
public class EmpresaGetResponse {

    String ruc;
    String rSocial;
    Date fecIni;
    String ubigeo;
    String direccion;
    String telef;
    String mdaP;
    String mdaS;
    String cd_Pais;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getrSocial() {
        return rSocial;
    }

    public void setrSocial(String rSocial) {
        this.rSocial = rSocial;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
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

    public String getMdaP() {
        return mdaP;
    }

    public void setMdaP(String mdaP) {
        this.mdaP = mdaP;
    }

    public String getMdaS() {
        return mdaS;
    }

    public void setMdaS(String mdaS) {
        this.mdaS = mdaS;
    }

    public String getCd_Pais() {
        return cd_Pais;
    }

    public void setCd_Pais(String cd_Pais) {
        this.cd_Pais = cd_Pais;
    }

}
