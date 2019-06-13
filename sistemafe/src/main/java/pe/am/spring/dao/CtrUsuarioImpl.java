/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.sql.DataSource;
import pe.am.spring.dao.CtrUsuario;
import pe.am.spring.model.ClassResultPV;
import pe.am.spring.model.DtoB;
import pe.am.spring.model.DtoUsuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author alonso
 */
public class CtrUsuarioImpl implements CtrUsuario {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    public CtrUsuarioImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public DtoUsuario Seg_UsuConsUn(DtoUsuario bean) {
        DtoUsuario dtoUsuario = bean;
        try {
            //sqlParameterArray[0] = new SqlParameter("@NomUsu", SqlDbType.NVarChar, 10);
            //sqlParameterArray[0].Value = (object) dtoUsuario.NomUsu;
            //sqlParameterArray[1] = new SqlParameter("@msj", SqlDbType.VarChar, 100);
            //sqlParameterArray[1].Direction = ParameterDirection.Output;
            //DataSet dataSet = SqlHelper.ExecuteDataset(this.objCn, CommandType.StoredProcedure, "Seg_UsuConsUn", sqlParameterArray);
            //DataTable dataTable = dataSet.Tables.Count >= 1 ? dataSet.Tables[0] : (DataTable) null;
//            if (sqlParameterArray[1].Value.ToString() != "") {
            //retorno un mensaje de error
//                dtoUsuario.LugarError = this.ToString("Gsp_UsuConsUn()");
//                dtoUsuario.ErrorMsj = Convert.ToString(sqlParameterArray[1].Value).Trim();
//                return dtoUsuario;
//            } else if (dataTable != null) {
            SqlParameterSource in = new MapSqlParameterSource().addValue("NomUsu", bean.NomUsu);
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Seg_UsuConsUn");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            Map<String, Object> it2 = (Map) ((java.util.ArrayList) out.get("#result-set-1")).get(0);
            /*Iterator<Entry<String, Object>> it = out.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
		        String key = (String) entry.getKey();
		        Object value = (Object) entry.getValue();
                        
		        System.out.println("Key: "+key);
		        System.out.println("Value: "+value);
		    }*/

            System.out.println(out.get(0));
            if (out.size() > 1) {
                bean.setNomComp((String) it2.get("NomComp"));
                bean.setCd_Trab((String) it2.get("Cd_Trab"));
                bean.setCd_Prf((String) it2.get("Cd_Prf"));
                bean.setEstado((it2.get("Estado").equals("1")) ? true : false);
                bean.setIB_TipCamCrear((it2.get("IB_TipCamCrear").equals("1")) ? true : false);
                bean.setIB_TipCamMdf((it2.get("IB_TipCamMdf").equals("1")) ? true : false);
                bean.setIB_TipCamElim((it2.get("IB_TipCamElim").equals("1")) ? true : false);
                bean.setCorreo1((String) it2.get("correo1"));
                bean.setCargo((String) it2.get("Cargo"));
                bean.setNumero((String) it2.get("Numero"));
                bean.setToken((String) it2.get("Token"));
                bean.setIB_VerAuditoria((it2.get("Estado").equals("1")) ? true : false);
                bean.setFoto((byte[]) it2.get("Foto"));
                bean.setFirma((byte[]) it2.get("Firma"));
                bean.setHashByte((byte[]) it2.get("HashByte"));
                bean.setIB_BuscarActAuto((it2.get("Estado").equals("1")) ? true : false);
                bean.setTiempoInactividad((Integer) it2.get("TiempoInactividad"));
                bean.setNivel((String) it2.get("Nivel"));
            }

//                if (dataTable.Rows.Count > 0) {
//                    dtoUsuario.TiempoInactividad = dataRow["TiempoInactividad"] == DBNull.Value ? 0 : Convert.ToInt32(dataRow["TiempoInactividad"]);
//                    dtoUsuario.Nivel = dataRow["Nivel"] == DBNull.Value ? string.Empty : Convert.ToString(dataRow["Nivel"]);
//                }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al consultar Usuario " + dtoUsuario.NomUsu + ".");
        }
        return dtoUsuario;
    }

    @Override
    public DtoUsuario Seg_UsuLogin(DtoUsuario dtoUsuario) {
        try {
            SqlParameterSource in = new MapSqlParameterSource().addValue("NomUsu", dtoUsuario.NomUsu);
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Seg_UsuLogin3");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            if(out.get("msj")!=null){
                dtoUsuario.error_flag=true;
                dtoUsuario.error_msj="Seg_UsuLogin() " + out.get("msj");
            }else{
                if(out.get("OldPass")!=null){
                    dtoUsuario.OldPass=(String) out.get("OldPass");
                }
                if(out.get("HashByte")!=null){
                    dtoUsuario.HashByte=(byte[]) out.get("HashByte");
                }
            }
            out.toString();
        } catch (Exception e) {
            dtoUsuario.error_flag = true;
            dtoUsuario.error_msj="Error al iniciar sesion "+e.toString();
            e.printStackTrace();
        }
        return dtoUsuario;
    }

}
