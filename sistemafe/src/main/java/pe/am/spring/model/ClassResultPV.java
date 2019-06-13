/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alonso
 */
public class ClassResultPV {

    public String AlertaMsj;
    public String Detalle;
    //DS tenia dataset
    public HashMap DS;
    //DT tenia DataTable
    public HashMap DT;
    public DtoB Entidad;
    public String ErrorEx;
    public String ErrorMsj;
    public boolean HuboAlerta;
    public boolean HuboError;
    public List<DtoB> List;
    public String LugarError;
    public String Resultado;

    public List<Object> ConvertToGenericList;

    public ClassResultPV() {
    }

    public String getAlertaMsj() {
        return AlertaMsj;
    }

    public void setAlertaMsj(String AlertaMsj) {
        this.AlertaMsj = AlertaMsj;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public HashMap getDS() {
        return DS;
    }

    public void setDS(HashMap DS) {
        this.DS = DS;
    }

    public HashMap getDT() {
        return DT;
    }

    public void setDT(HashMap DT) {
        this.DT = DT;
    }

    public DtoB getEntidad() {
        return Entidad;
    }

    public void setEntidad(DtoB Entidad) {
        this.Entidad = Entidad;
    }

    public String getErrorEx() {
        return ErrorEx;
    }

    public void setErrorEx(String ErrorEx) {
        this.ErrorEx = ErrorEx;
    }

    public String getErrorMsj() {
        return ErrorMsj;
    }

    public void setErrorMsj(String ErrorMsj) {
        this.ErrorMsj = ErrorMsj;
    }

    public boolean isHuboAlerta() {
        return HuboAlerta;
    }

    public void setHuboAlerta(boolean HuboAlerta) {
        this.HuboAlerta = HuboAlerta;
    }

    public boolean isHuboError() {
        return HuboError;
    }

    public void setHuboError(boolean HuboError) {
        this.HuboError = HuboError;
    }

    public List<DtoB> getList() {
        return List;
    }

    public void setList(List<DtoB> List) {
        this.List = List;
    }

    public String getLugarError() {
        return LugarError;
    }

    public void setLugarError(String LugarError) {
        this.LugarError = LugarError;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public List<Object> getConvertToGenericList() {
        return ConvertToGenericList;
    }

    public void setConvertToGenericList(List<Object> ConvertToGenericList) {
        this.ConvertToGenericList = ConvertToGenericList;
    }

}
