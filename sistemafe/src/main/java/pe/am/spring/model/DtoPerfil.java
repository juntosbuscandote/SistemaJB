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
public class DtoPerfil {
    private String cd_Prf;
    private String rucE;
    private String descrip;
    private String nomP;
    private boolean estado;
    private String cd_MN;
    private boolean iB_TPermisos;
    private String _nomUsu;

    public String getCd_Prf() {
        return cd_Prf;
    }

    public void setCd_Prf(String cd_Prf) {
        this.cd_Prf = cd_Prf;
    }

    public String getRucE() {
        return rucE;
    }

    public void setRucE(String rucE) {
        this.rucE = rucE;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCd_MN() {
        return cd_MN;
    }

    public void setCd_MN(String cd_MN) {
        this.cd_MN = cd_MN;
    }

    public boolean isiB_TPermisos() {
        return iB_TPermisos;
    }

    public void setiB_TPermisos(boolean iB_TPermisos) {
        this.iB_TPermisos = iB_TPermisos;
    }

    public String getNomUsu() {
        return _nomUsu;
    }

    public void setNomUsu(String _nomUsu) {
        this._nomUsu = _nomUsu;
    }
    
}
