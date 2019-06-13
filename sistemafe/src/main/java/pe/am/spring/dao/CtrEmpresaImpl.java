/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.dao;

import java.util.ArrayList;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import pe.am.spring.model.DtoEmpresa;
import pe.am.spring.model.DtoPerfil;

/**
 *
 * @author USUARIO
 */
public class CtrEmpresaImpl implements CtrEmpresa{
    private SimpleJdbcCall simpleJdbcCall;
    private JdbcTemplate jdbcTemplate;

    public CtrEmpresaImpl(DataSource dataSource) {
         jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public ArrayList<DtoEmpresa> Gsp_EmpCons(DtoPerfil dtoPerfil) {
        ArrayList<DtoEmpresa> ArrdtoEmpresa = new ArrayList<DtoEmpresa>();
        SqlParameterSource in = new MapSqlParameterSource().addValue("Cd_Prf", dtoPerfil.getNomP());
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Gsp_EmpCons");
            Map<String, Object> out = simpleJdbcCall.execute(in);
        ArrayList<Map> it2=(java.util.ArrayList<Map>) ((java.util.ArrayList) out.get("#result-set-1"));
        for (Map map : it2) {
            DtoEmpresa empresa = new DtoEmpresa();
            empresa.setRuc(map.get("Ruc").toString());
            empresa.setRsocial(map.get("Rsocial").toString());
            empresa.setFecIni(map.get("FecIni").toString());
            empresa.setUbigeo(map.get("Ubigeo").toString());
            empresa.setDireccion(map.get("Direccion")==null?"":map.get("Direccion").toString());
            empresa.setTelef(map.get("Telef")==null?"":map.get("Telef").toString());
            ArrdtoEmpresa.add(empresa);
        }
        return ArrdtoEmpresa;
    }
    
}
