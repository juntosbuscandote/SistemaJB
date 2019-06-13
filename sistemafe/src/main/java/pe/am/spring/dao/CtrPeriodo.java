/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.dao;

import java.util.ArrayList;
import pe.am.spring.model.DtoPeriodo;

/**
 *
 * @author alonso
 */
public interface CtrPeriodo {
    
    public DtoPeriodo Ctb_PrdoElim(DtoPeriodo bean);
    public DtoPeriodo Ctb_PrdoCrea(DtoPeriodo bean);
    public DtoPeriodo Ctb_PrdoModf(DtoPeriodo bean);
    
    public ArrayList<DtoPeriodo> Ctb_PrdoCons(DtoPeriodo bean);
    
    public DtoPeriodo Ctb_PrdoConsUn(DtoPeriodo bean);
    
    
}
