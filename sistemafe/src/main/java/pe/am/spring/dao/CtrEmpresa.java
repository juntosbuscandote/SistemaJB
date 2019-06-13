/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.dao;

import java.util.ArrayList;
import pe.am.spring.model.DtoEmpresa;
import pe.am.spring.model.DtoPerfil;

/**
 *
 * @author USUARIO
 */
public interface CtrEmpresa {
    public ArrayList<DtoEmpresa> Gsp_EmpCons(DtoPerfil dtoPerfil);
}
