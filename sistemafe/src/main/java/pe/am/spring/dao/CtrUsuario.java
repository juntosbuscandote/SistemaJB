/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.dao;

import pe.am.spring.model.ClassResultPV;
import pe.am.spring.model.DtoB;
import pe.am.spring.model.DtoUsuario;

/**
 *
 * @author alonso
 */
public interface CtrUsuario {
    
//    public ClassResultPV CC_x_Usuario_Crea(DtoCCSubSub dto);
//    public ClassResultPV CC_x_Usuario_Crea_Total(DtoUsuario dto);
//    public ClassResultPV CC_x_Usuario_Elimina(DtoCCostos dto);
//    public ClassResultPV CCxUsuario_Cons_Usuario(DtoUsuario dto);
//    public ClassResultPV CCxUsuario_Cons_Usuario_Total(DtoUsuario dto);
//    public List<DtoCCostos> Conf_CC_x_Usuario(DtoUsuario dto);
//    public List<DtoCCSub> Conf_SC_x_Usuario(DtoCCostos dto);
//    public List<DtoCCSubSub> Conf_SS_x_Usuario(DtoCCSubSub dto);
//    public ClassResultPV EnviarInformacion(DtoUsuario oUsuario);
//    public List<DtoUsuario> ObtieneUsuariosDeEmpresa(string RucE);
//    public ClassResultPV Seg_CambPass(DtoB dtoBase);
//    public ClassResultPV Seg_UsuCons();
//    public ClassResultPV Seg_UsuConsHabilitados();
    public DtoUsuario Seg_UsuConsUn(DtoUsuario bean);
//    public ClassResultPV Seg_UsuConsxNivel(DtoB dtoBase);
//    public ClassResultPV Seg_UsuConsxNivel_SinPadre(DtoUsuario dto);
//    public ClassResultPV Seg_UsuCrea(DtoB dtoBase);
//    public ClassResultPV Seg_UsuCreaxNivel(DtoB dtoBase);
//    public ClassResultPV Seg_UsuElim(DtoB dtoBase);
    public DtoUsuario Seg_UsuLogin(DtoUsuario dtoUsuario);
    
//    public ClassResultPV Seg_UsuModf(DtoB dtoBase);
//    public ClassResultPV Seg_UsuModfCfg(DtoB dtoBase);
//    public ClassResultPV Seg_UsuModfNivel(DtoB dtoBase);
//    public ClassResultPV Usuario_VerAuditoria(DtoB dtoBase);
//    public bool Vta_UsuarioTieneXVendedorAsociado(DtoB dtoB);
}
