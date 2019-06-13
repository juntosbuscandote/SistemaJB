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
import pe.am.spring.model.DtoPeriodo;

/**
 *
 * @author alonso
 */
public class CtrPeriodoImpl implements CtrPeriodo{
    
    private SimpleJdbcCall simpleJdbcCall;
    private JdbcTemplate jdbcTemplate;

    public CtrPeriodoImpl(DataSource dataSource) {
         jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public DtoPeriodo Ctb_PrdoElim(DtoPeriodo bean){
        try{
            
            SqlParameterSource in = new MapSqlParameterSource().addValue("RucE", bean.getRucE())
                    .addValue("Ejer", bean.getEjer());
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Ctb_PrdoElim");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            if(out.get("msj")!=null){
                bean.setError_flag(true);
                bean.setError_msj("Ctb_PrdoElim() " + out.get("msj"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            bean.setError_flag(true);
            bean.setError_msj("Ctb_PrdoElim() " + "Ocurrió un error al eliminar periodo");
        }
        return bean;
    }

    @Override
    public DtoPeriodo Ctb_PrdoCrea(DtoPeriodo bean) {
        try{
            SqlParameterSource in = new MapSqlParameterSource().addValue("RucE", bean.getRucE())
                    .addValue("Ejer", bean.getEjer());
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Ctb_PrdoCrea");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            if(out.get("msj")!=null){
                bean.setError_flag(true);
                bean.setError_msj("Ctb_PrdoCrea() " + out.get("msj"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            bean.setError_flag(true);
            bean.setError_msj("Ctb_PrdoCrea() " + "Ocurrió un error al crear periodo");
        }
        return bean;
    }

    @Override
    public DtoPeriodo Ctb_PrdoModf(DtoPeriodo bean) {
        try{
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("RucE", bean.getRucE())
                    .addValue("Ejer", bean.getEjer())
                    .addValue("P00", bean.isP00())
                    .addValue("P01", bean.isP01())
                    .addValue("P02", bean.isP02())
                    .addValue("P03", bean.isP03())
                    .addValue("P04", bean.isP04())
                    .addValue("P05", bean.isP05())
                    .addValue("P06", bean.isP06())
                    .addValue("P07", bean.isP07())
                    .addValue("P08", bean.isP08())
                    .addValue("P09", bean.isP09())
                    .addValue("P10", bean.isP10())
                    .addValue("P11", bean.isP11())
                    .addValue("P12", bean.isP12())
                    .addValue("P13", bean.isP13())
                    .addValue("P14", bean.isP14());
                    
                    
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Ctb_PrdoMdf");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            if(out.get("msj")!=null  ){
                bean.setError_flag(true);
                bean.setError_msj("Ctb_PrdoModf() " + out.get("msj"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            bean.setError_flag(true);
            bean.setError_msj("Ctb_PrdoModf() " + "Error al modifcar periodo");
        }
        return bean;
    }

    @Override
    public ArrayList<DtoPeriodo> Ctb_PrdoCons(DtoPeriodo bean) {
        ArrayList<DtoPeriodo> listPeriodo = new ArrayList<DtoPeriodo>();
        try{
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("RucE", bean.getRucE());
            
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Ctb_PrdoCons");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            
            if(out.get("msj")!=null ){
                return null;
            }
            
            ArrayList<Map> it2=(java.util.ArrayList<Map>) ((java.util.ArrayList) out.get("#result-set-1"));
            for (Map map : it2) {
                DtoPeriodo periodo = new DtoPeriodo();
                
                //periodo.setRucE(map.get("RucE").toString());
                periodo.setEjer(map.get("Ejer").toString());
                /*periodo.setP00((boolean) map.get("P00"));
                periodo.setP01((boolean) map.get("P01"));
                periodo.setP02((boolean) map.get("P02"));
                periodo.setP03((boolean) map.get("P03"));
                periodo.setP04((boolean) map.get("P04"));
                periodo.setP05((boolean) map.get("P05"));
                periodo.setP06((boolean) map.get("P06"));
                periodo.setP07((boolean) map.get("P07"));
                periodo.setP08((boolean) map.get("P08"));
                periodo.setP09((boolean) map.get("P09"));
                periodo.setP10((boolean) map.get("P10"));
                periodo.setP11((boolean) map.get("P11"));
                periodo.setP12((boolean) map.get("P12"));
                periodo.setP13((boolean) map.get("P13"));
                periodo.setP14((boolean) map.get("P14"));*/
                
                listPeriodo.add(periodo);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            bean.setError_flag(true);
            bean.setError_msj("Ctb_PrdoCons() " + "Error al consultar los periodos");
        }
        return listPeriodo;
    }

    @Override
    public DtoPeriodo Ctb_PrdoConsUn(DtoPeriodo bean) {
        try{
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("RucE", bean.getRucE())
                    .addValue("Ejer", bean.getEjer());
                    
                    
            this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Ctb_PrdoConsUn");
            Map<String, Object> out = simpleJdbcCall.execute(in);
            
            //Map map=(Map) out.get("#result-set-1");
            Map<String, Object> map = (Map) ((java.util.ArrayList) out.get("#result-set-1")).get(0);
             
            if(out.get("msj")!=null ){
                bean.setError_flag(true);
                bean.setError_msj("Ctb_PrdoModf() " + out.get("msj"));
            }else{
                DtoPeriodo periodo = new DtoPeriodo();
                
                periodo.setRucE(map.get("RucE").toString());
                periodo.setEjer(map.get("Ejer").toString());
                periodo.setP00((boolean) map.get("P00"));
                periodo.setP01((boolean) map.get("P01"));
                periodo.setP02((boolean) map.get("P02"));
                periodo.setP03((boolean) map.get("P03"));
                periodo.setP04((boolean) map.get("P04"));
                periodo.setP05((boolean) map.get("P05"));
                periodo.setP06((boolean) map.get("P06"));
                periodo.setP07((boolean) map.get("P07"));
                periodo.setP08((boolean) map.get("P08"));
                periodo.setP09((boolean) map.get("P09"));
                periodo.setP10((boolean) map.get("P10"));
                periodo.setP11((boolean) map.get("P11"));
                periodo.setP12((boolean) map.get("P12"));
                periodo.setP13((boolean) map.get("P13"));
                periodo.setP14((boolean) map.get("P14"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            bean.setError_flag(true);
            bean.setError_msj("Ctb_PrdoModf() " + "Error al modifcar periodo");
        }
        return bean;
    }
    
    
    
    
}
