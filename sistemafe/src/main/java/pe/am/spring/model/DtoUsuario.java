/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author alonso
 */
public class DtoUsuario {


    public String Cargo;
    public String Cd_Area;
    public String Cd_Prf;
    public String Cd_Trab;
    public String Cd_Vdr;
    public boolean Check;
    public String correo1;
    public String Descrip;
    public boolean Estado;
    public Timestamp FecMdf;
    public Timestamp FecReg;
    public byte[] Firma;
    public byte[] Foto;
    public byte[] HashByte;
    public boolean IB_BuscarActAuto;
    public boolean IB_TipCamCrear;
    public boolean IB_TipCamElim;
    public boolean IB_TipCamMdf;
    public boolean IB_VerAuditoria;
    public List<DtoArea> LdtoArea;
    public List<DtoAreaXUsu> LdtoAreasXUsu;
    public List<DtoCCostos> LstCC;
    public String NCorto;
    public String Nivel;
    public String Nombre;
    public String NomComp;
    public String NomUsu;
    public String NomUsuCrea;
    public String Numero;
    public String OldPass;
    public String Pass;
    public String RucE;
    public boolean Seleccion;
    public Integer TiempoInactividad;
    public String Token;
    public String Usu_CodPerfil;
    public String UsuCrea;
    public String UsuMdf;

    public boolean error_flag=false;
    public String error_msj=null;
    
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getCd_Area() {
        return Cd_Area;
    }

    public void setCd_Area(String Cd_Area) {
        this.Cd_Area = Cd_Area;
    }

    public String getCd_Prf() {
        return Cd_Prf;
    }

    public void setCd_Prf(String Cd_Prf) {
        this.Cd_Prf = Cd_Prf;
    }

    public String getCd_Trab() {
        return Cd_Trab;
    }

    public void setCd_Trab(String Cd_Trab) {
        this.Cd_Trab = Cd_Trab;
    }

    public String getCd_Vdr() {
        return Cd_Vdr;
    }

    public void setCd_Vdr(String Cd_Vdr) {
        this.Cd_Vdr = Cd_Vdr;
    }

    public boolean isCheck() {
        return Check;
    }

    public void setCheck(boolean Check) {
        this.Check = Check;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
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

    public Timestamp getFecMdf() {
        return FecMdf;
    }

    public void setFecMdf(Timestamp FecMdf) {
        this.FecMdf = FecMdf;
    }

    public Timestamp getFecReg() {
        return FecReg;
    }

    public void setFecReg(Timestamp FecReg) {
        this.FecReg = FecReg;
    }

    public byte[] getFirma() {
        return Firma;
    }

    public void setFirma(byte[] Firma) {
        this.Firma = Firma;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public byte[] getHashByte() {
        return HashByte;
    }

    public void setHashByte(byte[] HashByte) {
        this.HashByte = HashByte;
    }

    public boolean isIB_BuscarActAuto() {
        return IB_BuscarActAuto;
    }

    public void setIB_BuscarActAuto(boolean IB_BuscarActAuto) {
        this.IB_BuscarActAuto = IB_BuscarActAuto;
    }

    public boolean isIB_TipCamCrear() {
        return IB_TipCamCrear;
    }

    public void setIB_TipCamCrear(boolean IB_TipCamCrear) {
        this.IB_TipCamCrear = IB_TipCamCrear;
    }

    public boolean isIB_TipCamElim() {
        return IB_TipCamElim;
    }

    public void setIB_TipCamElim(boolean IB_TipCamElim) {
        this.IB_TipCamElim = IB_TipCamElim;
    }

    public boolean isIB_TipCamMdf() {
        return IB_TipCamMdf;
    }

    public void setIB_TipCamMdf(boolean IB_TipCamMdf) {
        this.IB_TipCamMdf = IB_TipCamMdf;
    }

    public boolean isIB_VerAuditoria() {
        return IB_VerAuditoria;
    }

    public void setIB_VerAuditoria(boolean IB_VerAuditoria) {
        this.IB_VerAuditoria = IB_VerAuditoria;
    }

    public List<DtoArea> getLdtoArea() {
        return LdtoArea;
    }

    public void setLdtoArea(List<DtoArea> LdtoArea) {
        this.LdtoArea = LdtoArea;
    }

    public List<DtoAreaXUsu> getLdtoAreasXUsu() {
        return LdtoAreasXUsu;
    }

    public void setLdtoAreasXUsu(List<DtoAreaXUsu> LdtoAreasXUsu) {
        this.LdtoAreasXUsu = LdtoAreasXUsu;
    }

    public List<DtoCCostos> getLstCC() {
        return LstCC;
    }

    public void setLstCC(List<DtoCCostos> LstCC) {
        this.LstCC = LstCC;
    }

    public String getNCorto() {
        return NCorto;
    }

    public void setNCorto(String NCorto) {
        this.NCorto = NCorto;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public String getNomUsuCrea() {
        return NomUsuCrea;
    }

    public void setNomUsuCrea(String NomUsuCrea) {
        this.NomUsuCrea = NomUsuCrea;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getOldPass() {
        return OldPass;
    }

    public void setOldPass(String OldPass) {
        this.OldPass = OldPass;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
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

    public int getTiempoInactividad() {
        return TiempoInactividad;
    }

    public void setTiempoInactividad(Integer TiempoInactividad) {
        this.TiempoInactividad = TiempoInactividad;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getUsu_CodPerfil() {
        return Usu_CodPerfil;
    }

    public void setUsu_CodPerfil(String Usu_CodPerfil) {
        this.Usu_CodPerfil = Usu_CodPerfil;
    }

    public String getUsuCrea() {
        return UsuCrea;
    }

    public void setUsuCrea(String UsuCrea) {
        this.UsuCrea = UsuCrea;
    }

    public String getUsuMdf() {
        return UsuMdf;
    }

    public void setUsuMdf(String UsuMdf) {
        this.UsuMdf = UsuMdf;
    }

    
    
}
