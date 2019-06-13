/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

/**
 *
 * @author alonso
 */
public class DtoAreaXUsu {
    
    public String Cd_Area ;
    public boolean Conf ;
    public String Descrip ;
    public int Dias ;
    //public DataTable DtArea ;
    public boolean Estado ;
    public String NCorto ;
    public String NomComp ;
    public String NomUsu ;
    public DtoCierreProceso ObjCierreProcesoxPeriodo ;
    public String RucE;
    public boolean Seleccion ;

    public DtoAreaXUsu() {
    }

    public String getCd_Area() {
        return Cd_Area;
    }

    public void setCd_Area(String Cd_Area) {
        this.Cd_Area = Cd_Area;
    }

    public boolean isConf() {
        return Conf;
    }

    public void setConf(boolean Conf) {
        this.Conf = Conf;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public int getDias() {
        return Dias;
    }

    public void setDias(int Dias) {
        this.Dias = Dias;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getNCorto() {
        return NCorto;
    }

    public void setNCorto(String NCorto) {
        this.NCorto = NCorto;
    }

    public String getNomComp() {
        return NomComp;
    }

    public void setNomComp(String NomComp) {
        this.NomComp = NomComp;
    }

    public String getNomUsu() {
        return NomUsu;
    }

    public void setNomUsu(String NomUsu) {
        this.NomUsu = NomUsu;
    }

    public DtoCierreProceso getObjCierreProcesoxPeriodo() {
        return ObjCierreProcesoxPeriodo;
    }

    public void setObjCierreProcesoxPeriodo(DtoCierreProceso ObjCierreProcesoxPeriodo) {
        this.ObjCierreProcesoxPeriodo = ObjCierreProcesoxPeriodo;
    }

    public String getRucE() {
        return RucE;
    }

    public void setRucE(String RucE) {
        this.RucE = RucE;
    }

    public boolean isSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(boolean Seleccion) {
        this.Seleccion = Seleccion;
    }
    
    
    
}
