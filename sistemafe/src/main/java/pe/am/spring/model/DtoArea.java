/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

import java.util.List;

/**
 *
 * @author alonso
 */
public class DtoArea {
    
    public boolean _Sel;
    public String Cd_Area;
    public String Descrip;
    public boolean Estado;
    public List<DtoAreaXUsu> ListAreaxUsuario;
    public String NCorto;
    public String RucE;

    public DtoArea() {
    }

    public boolean isSel() {
        return _Sel;
    }

    public void setSel(boolean _Sel) {
        this._Sel = _Sel;
    }

    public String getCd_Area() {
        return Cd_Area;
    }

    public void setCd_Area(String Cd_Area) {
        this.Cd_Area = Cd_Area;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public List<DtoAreaXUsu> getListAreaxUsuario() {
        return ListAreaxUsuario;
    }

    public void setListAreaxUsuario(List<DtoAreaXUsu> ListAreaxUsuario) {
        this.ListAreaxUsuario = ListAreaxUsuario;
    }

    public String getNCorto() {
        return NCorto;
    }

    public void setNCorto(String NCorto) {
        this.NCorto = NCorto;
    }

    public String getRucE() {
        return RucE;
    }

    public void setRucE(String RucE) {
        this.RucE = RucE;
    }
    
    
    
}
