/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.am.spring.entity.Archivo;
import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.CorreoPersona;
import pe.am.spring.entity.EmailGet;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TBusinessBDFilter;
import pe.am.spring.entity.TBusinessBDFilterGet;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TParamBussines;
import pe.am.spring.entity.TParamBussinesGet;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TVoucher;
import pe.am.spring.entity.TVoucherFilter;
import pe.am.spring.entity.TVoucherFilterGet;
import pe.am.spring.entity.TVoucherGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.EmailRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.VoucherRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;



/**
 *
 * @author User
 */
@Controller
@RequestMapping("/comprobanteelectronico")
public class ComprobanteElectronicoController {
	@Autowired
	VoucherRest voucherrest;
	
	@Autowired
	EmailRest emilRest;
	
	@Autowired
	BussinesRest BussinesRest;
	
	@Autowired
	PersonRest personRest;
	
	@Autowired
	LegalPersonRest legalPersonRest;
	
	@Autowired
	CatalogueRest CataRest;

	protected static Logger logger = Logger.getLogger(ComprobanteElectronicoController.class);
	
	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
			if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
				logger.info("Si tiene Acceso a la pagina");
			}else {
				model.setViewName("/Permiso/PermidoDenegado");
				return model;
			}
		}else {
			model.setViewName("/homepost");
			return model;
		}
		
		model.setViewName("/ComprobanteElectronico/ComprobanteElectronico");
		String NombreVentana="Comprobantes Electrónicos";
		model.addObject("NombreVentana", NombreVentana);
		// validar sesion
		
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		System.out.println("uri :" + Util.getHostVoucher());
		// =======

		// properties para microservicio de comprobante
		String util = Util.getHostVoucher();
		System.out.println(util);
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TVoucherGet filtro = new TVoucherGet();
			// filtro.setPaginacion(new PaginacionFiltro(1,1000));
			// PaginaResultado<TVoucher> response = voucherrest.getVoucher(filtro);
			// model.addObject("DtoComprobante", response.getResultados());
			/*********************************************************************************************************/
			/*---------------------------     LISTA TIPO DE COMPROBANTE----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar tipos de comprobantes de catalogue");
			TCatalogueDetGet filtrostipoCPE = new TCatalogueDetGet();
			filtrostipoCPE.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrostipoCPE.setCataBident(new Long(1));
			filtrostipoCPE.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescattipocpe = CataRest.getCatalogueDet(filtrostipoCPE,beanDS);
			TCatalogueDet procatatipocpe = new TCatalogueDet();
			List<TCatalogueDet> lstCatTipocepe= new ArrayList<>();
			for (Object catdetestado : responsescattipocpe.getResultados()) {
				procatatipocpe= mapper.convertValue(catdetestado, TCatalogueDet.class);
				lstCatTipocepe.add(procatatipocpe);
			}
			model.addObject("listaCatDetTipoCPE", lstCatTipocepe);
			/*********************************************************************************************************/
			/*---------------------------     LISTA RESPUESTA DE SUNAT ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar respuesta de sunat catalogue");
			TCatalogueDetGet filtrosrsptasunat = new TCatalogueDetGet();
			filtrosrsptasunat.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosrsptasunat.setCataBident(new Long(43));
			filtrosrsptasunat.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatptasunat = CataRest.getCatalogueDet(filtrosrsptasunat,beanDS);
			TCatalogueDet procatarptasunat = new TCatalogueDet();
			List<TCatalogueDet> lstCatRptasunat= new ArrayList<>();
			for (Object catdetestado : responsescatptasunat.getResultados()) {
				procatarptasunat= mapper.convertValue(catdetestado, TCatalogueDet.class);
				lstCatRptasunat.add(procatarptasunat);
			}
			model.addObject("lstCatRptasunat", lstCatRptasunat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/lista_comprobante", method = RequestMethod.POST)
	@ResponseBody
	public String getlistaComprobante(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmCPEFiltrosTipo", required = false) String frmCPEFiltrosTipo,
			@RequestParam(value = "frmCPEFiltrosNro", required = false) String frmCPEFiltrosNro,
			@RequestParam(value = "frmCPEFiltrosRazSoc", required = false) String frmCPEFiltrosRazSoc,
			@RequestParam(value = "frmCPEFiltrosRUC", required = false) String frmCPEFiltrosRUC,
			@RequestParam(value = "frmCPEFiltrosFecEmision", required = false) String frmCPEFiltrosFecEmision,
			@RequestParam(value = "frmCPEFiltrosMontoTotal", required = false) String frmCPEFiltrosMontoTotal,
			@RequestParam(value = "frmCPEFiltrosResulSunat", required = false) String frmCPEFiltrosResulSunat,
			@RequestParam(value = "frmCPEFiltrosfecIniFecFin", required = false) String frmCPEFiltrosfecIniFecFin,
			@RequestParam(value = "frmCPEFiltrosObs", required = false) String frmCPEFiltrosObs) {
		System.out.println("===========Inicio-> comprobante/lista_comprobante ");
		System.out.println("uri :" + Util.getHostVoucher());
		String sStart = rq.getParameter("draw");

		try {
			
			//obteniendo el usuario logueado
			TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			ObjectMapper mapper = new ObjectMapper();

			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			//filtro de la empresa logueada
			if (tEmployee != null) {
				TBussinesFilterGet filtroLP = new TBussinesFilterGet();
				filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroLP.setBusibident(tEmployee.getBusiBident());
				PaginaResultado<TBussinesFilter> responseLG = BussinesRest.getBussinesFilter(filtroLP,beanDS);
				TBussinesFilter tBussinesFilter = mapper.convertValue(responseLG.getResultados().get(0), TBussinesFilter.class);
				filtro.setEmpreNroDoc(tBussinesFilter.getPersVnumdoc());
			}
			if (user.getProfBident().equals(2l)) {
				filtro.setNumeroCliente(user.getUserVuser());
			}
			if (frmCPEFiltrosTipo != null && !frmCPEFiltrosTipo.isEmpty()) {
				filtro.setTipoDoc(frmCPEFiltrosTipo);//mtoledo 19/01/2018 filtro tipo documento
			}
			if (frmCPEFiltrosNro != null && !frmCPEFiltrosNro.isEmpty()) {
				filtro.setNroDoc(frmCPEFiltrosNro);//mtoledo 19/01/2018 filtro numero de documento
			}
			if (frmCPEFiltrosRazSoc != null && !frmCPEFiltrosRazSoc.isEmpty()) {
				filtro.setNombreCliente(frmCPEFiltrosRazSoc);//mtoledo 19/01/2018 filtro razon social emisor
			}
			if (frmCPEFiltrosRUC != null && !frmCPEFiltrosRUC.isEmpty()) {
				filtro.setNumeroCliente(frmCPEFiltrosRUC);//mtoledo 19/01/2018 filtro numero de documento emisor
			}
			if (frmCPEFiltrosObs != null && !frmCPEFiltrosObs.isEmpty()) {
				filtro.setObs(frmCPEFiltrosObs);//luis 12/10/2018 filtro observacion
			}
			if (frmCPEFiltrosFecEmision != null && !frmCPEFiltrosFecEmision.isEmpty()) {
				// filtro.setVoucVnro(frmComprNro.toUpperCase());
			}
			if (frmCPEFiltrosMontoTotal != null && !frmCPEFiltrosMontoTotal.isEmpty()) {
				 filtro.setTotal(frmCPEFiltrosMontoTotal.toUpperCase());
			}
			if (frmCPEFiltrosResulSunat != null && !frmCPEFiltrosResulSunat.isEmpty()) {
				 filtro.setEstadoSunat(frmCPEFiltrosResulSunat);
			}
			if (frmCPEFiltrosfecIniFecFin != null && !frmCPEFiltrosfecIniFecFin.isEmpty()) {
				 String fechas[] = frmCPEFiltrosfecIniFecFin.split("-");
//				 Date fechaEmisionIni = Util.StringtoDateFrom(fechas[0].trim());
//				 Date fechaEmisionFin = Util.StringtoDateFrom(fechas[1].trim());
				 Date fechaEmisionIni = Util.StringtoDate(fechas[0].trim());
				 Date fechaEmisionFin = Util.StringtoDate(fechas[1].trim());
				 filtro.setFechaEmisionIni(fechaEmisionIni);
				 filtro.setFechaEmisionFin(fechaEmisionFin);
			}
			PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtro,beanDS);
			// .queryParam("idPlan", 1)

			List<TVoucherFilter> LstdoCompr = null;
			if (response.getCantidad() > 0) {
				LstdoCompr = response.getResultados();
			}
			List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
			
			HashMap<String, Object> obj = null;
			if (LstdoCompr != null) {
				for (Object objs : LstdoCompr) {
					TVoucherFilter vistaCompro = mapper.convertValue(objs, TVoucherFilter.class);
					obj = new HashMap<String, Object>();
					obj.put("voucVtypdocvou", ObjectUtils.defaultIfNull(vistaCompro.getTipoDocDescr(), ""));
					obj.put("voucVnro", ObjectUtils.defaultIfNull(vistaCompro.getNroDoc(), ""));
					obj.put("clieVructipo", ObjectUtils.defaultIfNull(vistaCompro.getTipodocCliente(), ""));
					obj.put("clieVrucemisor", ObjectUtils.defaultIfNull(vistaCompro.getNumeroCliente(), ""));
					obj.put("clieRS", ObjectUtils.defaultIfNull(vistaCompro.getNombreCliente(), ""));
					obj.put("obs", ObjectUtils.defaultIfNull(vistaCompro.getObs(), ""));
					obj.put("voucTemitiondate", Util.datetoString(vistaCompro.getFechaEmision()));
					obj.put("voucCcodmoneda", ObjectUtils.defaultIfNull(vistaCompro.getMonedaDescr(), ""));
					obj.put("voucDmonto", ObjectUtils.defaultIfNull(vistaCompro.getTotal(), ""));
					
					//azevallos para mostrar
					String estadoInterno= "";
					if(vistaCompro.getEstadoSistema().equals("1")) {
						estadoInterno="Correcto";
					}else if (vistaCompro.getEstadoSistema().equals("0")) {
						estadoInterno="En Proceso..";
					}else {
						estadoInterno="Ocurrio un Error";
					}
					obj.put("voucVstateSistema",estadoInterno);
					
					obj.put("voucUrlXML", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlPDF", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlCDR", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));

					obj.put("voucVstate", "1");
					// manejando los estados
					obj.put("voucEnvioSunat", vistaCompro.getEstadoSunat() != null ?(vistaCompro.getEstadoSunat().equals("0") ? "1" : "0")
							: "");
					obj.put("voucEstadoSunat",
							vistaCompro.getEstadoSunat() != null
									? (vistaCompro.getEstadoSunat().equals("0") ? "1" : "0")
									: "");

					objLista.add(obj);
				}
			}
			JsonObject robject = new JsonObject();
			Gson gson = new Gson();
			String data = gson.toJson(objLista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			robject.addProperty("draw", sStart);
			robject.addProperty("recordsTotal", response.getCantidad());
			robject.addProperty("recordsFiltered", response.getCantidad());
			robject.add("data", jsonArray);
			return new Gson().toJson(robject);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/buscarcpe/lista_exploradorCPE", method = RequestMethod.POST)
    @ResponseBody
    public String getlistaExploradorCPE(HttpServletRequest rq, HttpSession ses,
    		@RequestParam(value = "frmBuscarCPETipo", required = false) String frmBuscarCPETipo,
			@RequestParam(value = "frmBuscarCPERUC", required = false) String frmBuscarCPERUC,
			@RequestParam(value = "frmBuscarCPESerieNro", required = false) String frmBuscarCPESerieNro,
			@RequestParam(value = "frmBuscarCPEFecEmi", required = false) String frmBuscarCPEFecEmi,
			@RequestParam(value = "frmBuscarCPEMonto", required = false) String frmBuscarCPEMonto,
			@RequestParam(value = "idDS", required = false) String idDS
    ) {
        System.out.println("===========Inicio-> empresa/lista_exploradorCPE ");

        logger.info("Se buscara el comprobante con el DS: "+idDS);
//        try {
//        	BeanDS beanDS=Util.getcadenaConexion(idDS);
//        	if(null!=beanDS) {
//        		
//        	}else {
//        		jReturn.addProperty("estado", "error");
//				jReturn.addProperty("msg", "La empresa "+empresa+" No se encuentra registrada");
//				System.out.println("La empresa "+empresa+" No se encuentra registrada");
//				url = "";
//				jReturn.addProperty("url", url);
//				return new Gson().toJson(jReturn);
//        	}
//        	
//        }catch(Exception e) {
//        	e.printStackTrace();
//        }
        
        String sStart = rq.getParameter("draw");
        if(frmBuscarCPEMonto!=null && !frmBuscarCPEMonto.isEmpty()) {
        	frmBuscarCPEMonto = Util.StrDecStr(frmBuscarCPEMonto);
        }
        
        try {
            String cantidad = rq.getParameter("length");
            BeanDS beanDS=Util.getcadenaConexion2();
            /*********************************************************************************************************/
			/*---------------------------     ACCESO BD -------------------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("ACCESO BD");
			TBusinessBDFilterGet filtroBD = new TBusinessBDFilterGet();
			filtroBD.setPaginacion(new PaginacionFiltro(1, 1));
			filtroBD.setPersVnumdoc(idDS);
			PaginaResultado<TBusinessBDFilter> responseBD = BussinesRest.getTBusinessBDFilter(filtroBD,beanDS);
			TBusinessBDFilter businessBD = new TBusinessBDFilter();
			ObjectMapper mapper2 = new ObjectMapper();
			if (responseBD != null && responseBD.getCantidad() > 0) {
				businessBD = mapper2.convertValue(responseBD.getResultados().get(0), TBusinessBDFilter.class);
				beanDS.setId(Long.toString(businessBD.getBubdBident()));
		    	beanDS.setUser(businessBD.getBubdVuserbd());
		    	beanDS.setPass(businessBD.getBubdVpassbd());
		    	beanDS.setUrl("jdbc:postgresql://"+businessBD.getBubdVipbd()+":"+businessBD.getBubdVportbd()+"/"+businessBD.getBubdVnamebd());
			}
            // NO SE METERA A SESION POR SER UNA URL DE CARACTER PUBLICO!!!!!
            //BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
            String sEcho = rq.getParameter("start");
            int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;
            TVoucherFilterGet filtroLP = new TVoucherFilterGet();
            filtroLP.setPaginacion(new PaginacionFiltro(page,Integer.parseInt(cantidad)));
            boolean filtro=false;
            if(frmBuscarCPETipo!=null && !frmBuscarCPETipo.isEmpty()) {
            	filtroLP.setTipoDoc(frmBuscarCPETipo);
            	filtro=true;
        	}else {
        		filtro=false;
        	}
        	if(frmBuscarCPESerieNro!=null && !frmBuscarCPESerieNro.isEmpty()) {
        		filtroLP.setNroDocEst(frmBuscarCPESerieNro);
        		filtro=true;
        	}else {
        		filtro=false;
        	}
        	if(frmBuscarCPEFecEmi!=null && !frmBuscarCPEFecEmi.isEmpty()) {
        		filtroLP.setFechaEmisionIni(Util.StringtoDateDMA(frmBuscarCPEFecEmi));
        		filtroLP.setFechaEmisionFin(Util.StringtoDateDMA(frmBuscarCPEFecEmi));   
        		filtro=true;
        	}else {
        		filtro=false;
        	}
          	if(frmBuscarCPEMonto!=null && !frmBuscarCPEMonto.isEmpty()) {
          		filtroLP.setTotalEst(frmBuscarCPEMonto);
          		filtro=true;
        	}else {
        		filtro=false;
        	}
          	List<TVoucherFilter> LstdoCompr = null;
          	Long cantidadRespo=0L;
          	if(filtro) {
          		PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtroLP,beanDS);
          		if (response.getCantidad() > 0) {
    				LstdoCompr = response.getResultados();
    				cantidadRespo=response.getCantidad();
    			}
          	}
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> obj = null;
			if (LstdoCompr != null) {
				for (Object objs : LstdoCompr) {
					TVoucherFilter vistaCompro = mapper.convertValue(objs, TVoucherFilter.class);
					obj = new HashMap<String, Object>();
					obj.put("tipoCpe", ObjectUtils.defaultIfNull(vistaCompro.getTipoDocDescr(), ""));
					obj.put("numCpe", ObjectUtils.defaultIfNull(vistaCompro.getNroDoc(), ""));
					obj.put("fechaEmision", Util.datetoString(vistaCompro.getFechaEmision()));
					obj.put("montoTotal", ObjectUtils.defaultIfNull(vistaCompro.getTotal(), ""));
					obj.put("voucUrlXML", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlPDF", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlCDR", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("filtroBd", ObjectUtils.defaultIfNull(idDS, ""));
					objLista.add(obj);
				}
			}
			JsonObject robject = new JsonObject();
			Gson gson = new Gson();
			String data = gson.toJson(objLista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			robject.addProperty("draw", sStart);
			robject.addProperty("recordsTotal", cantidadRespo);
			robject.addProperty("recordsFiltered", cantidadRespo);
			robject.add("data", jsonArray);
			return new Gson().toJson(robject);        
        } catch (HttpClientErrorException e) {
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
	

	/*****************************************************************/
	/*********************Descarga Masiva*****************************/
	/**
	 * @throws ServiceLogicException ***************************************************************/
	
	@RequestMapping(value = "/downloadMasivo", method = RequestMethod.GET)
	public void downloadMasivo(HttpServletResponse response, HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "file", required = true) String fileName,
			@RequestParam(value = "tipo", required = false) String tipoFile,
			@RequestParam(value = "frmCPEFiltrosfecIniFecFin", required = false) String frmCPEFiltrosfecIniFecFin
			) throws IOException, ServiceLogicException {
		ObjectMapper mapper = new ObjectMapper();
//		String cantidad = rq.getParameter("length");
//		String sEcho = rq.getParameter("start");
//		int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

		TVoucherFilterGet filtros = new TVoucherFilterGet();
//		filtros.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
		// buscar las url del voucher
		TVoucherGet filtro = new TVoucherGet();
		TVoucher voucher = new TVoucher();
		filtro.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
//		filtro.setId(new Long(fileName));
		filtro.setVoucBident(new Long(fileName));
//		System.out.println("ver : "+ LstdoCompr);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		if (frmCPEFiltrosfecIniFecFin != null && !frmCPEFiltrosfecIniFecFin.isEmpty()) {
			 String fechas[] = frmCPEFiltrosfecIniFecFin.split("-");
			 Date fechaEmisionIni = Util.StringtoDateFrom(fechas[0].trim());
			 Date fechaEmisionFin = Util.StringtoDateFrom(fechas[1].trim());
			 filtros.setFechaEmisionIni(fechaEmisionIni);
			 filtros.setFechaEmisionFin(fechaEmisionFin);
		}
//		System.out.println("ver : "+ LstdoCompr);
		PaginaResultado<TVoucherFilter> responsevoucher = voucherrest.getVoucherFilter(filtros,beanDS);            // voucherrest.getVoucherFilter(filtro);
//		List<TCatalogueDet> lstCatDoc = new ArrayList<>();
		List<TVoucherFilter> LstdoCompr = new ArrayList<>();
		if (responsevoucher.getCantidad() > 0) {
			LstdoCompr = responsevoucher.getResultados();
		} 
//		List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> obj = null;
		System.out.println("ver : "+ LstdoCompr);
		if (LstdoCompr != null) {
//			responsescat.getResultados() 
			for (Object objs : responsevoucher.getResultados() ) {
				filtros = mapper.convertValue(objs,TVoucherFilterGet.class);
				LstdoCompr.add(filtros);
				
				System.out.println("ver : "+ LstdoCompr);
		String urlFile = "";
		switch (tipoFile) {
		case "1":
			// xml
			urlFile = voucher.getVoucUrlXml();
			break;
		case "2":
			// pdf
			urlFile = voucher.getVoucUrlPdf();
			break;
		case "3":
			// cdr
			urlFile = voucher.getVoucUrlCdr();
			break;
		default:
			break;
		}

		// fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.toString());
		try {
		File file = new File(urlFile);
		InputStream is = new FileInputStream(urlFile);

		// MIME type of the file
		response.setContentType("application/octet-stream");
		// Response header
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		// Read from the file and write into the response
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		}catch(Exception e) {
			
		}
	}
		}
	}
//	

	
	
	@RequestMapping(value = "/obtenerPDFMasivo", method = RequestMethod.GET)
	@ResponseBody
	public void getlistaComprobantePDF(HttpServletResponse response,HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmCPEFiltrosTipo", required = false) String frmCPEFiltrosTipo,
			@RequestParam(value = "frmCPEFiltrosNro", required = false) String frmCPEFiltrosNro,
			@RequestParam(value = "frmCPEFiltrosRazSoc", required = false) String frmCPEFiltrosRazSoc,
			@RequestParam(value = "frmCPEFiltrosRUC", required = false) String frmCPEFiltrosRUC,
			@RequestParam(value = "frmCPEFiltrosFecEmision", required = false) String frmCPEFiltrosFecEmision,
			@RequestParam(value = "frmCPEFiltrosMontoTotal", required = false) String frmCPEFiltrosMontoTotal,
			@RequestParam(value = "frmCPEFiltrosResulSunat", required = false) String frmCPEFiltrosResulSunat,
			@RequestParam(value = "frmCPEFiltrosfecIniFecFin", required = false) String frmCPEFiltrosfecIniFecFin) {
		System.out.println("===========Inicio-> comprobante/lista_comprobante ");
		System.out.println("uri :" + Util.getHostVoucher());

		try {
			
			//obteniendo el usuario logueado
//			TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			ObjectMapper mapper = new ObjectMapper();
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			if(null==user) {
				return;
			}
			String cantidad = "1000";
			String sEcho = "1";
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			//filtro de la empresa logueada
			if (bussi != null) {
				TBussinesFilterGet filtroLP = new TBussinesFilterGet();
				filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroLP.setBusibident(bussi.getBusiBident());
				PaginaResultado<TBussinesFilter> responseLG = BussinesRest.getBussinesFilter(filtroLP,beanDS);
				TBussinesFilter tBussinesFilter = mapper.convertValue(responseLG.getResultados().get(0), TBussinesFilter.class);
				filtro.setEmpreNroDoc(tBussinesFilter.getPersVnumdoc());
			}
			if (user.getProfBident().equals(2l)) {
				filtro.setNumeroCliente(user.getUserVuser());
			}
			if (frmCPEFiltrosTipo != null && !frmCPEFiltrosTipo.isEmpty()) {
				filtro.setTipoDoc(frmCPEFiltrosTipo);//mtoledo 19/01/2018 filtro tipo documento
			}
			if (frmCPEFiltrosNro != null && !frmCPEFiltrosNro.isEmpty()) {
				filtro.setNroDoc(frmCPEFiltrosNro);//mtoledo 19/01/2018 filtro numero de documento
			}
			if (frmCPEFiltrosRazSoc != null && !frmCPEFiltrosRazSoc.isEmpty()) {
				filtro.setEmprRS(frmCPEFiltrosRazSoc);//mtoledo 19/01/2018 filtro razon social emisor
			}
			if (frmCPEFiltrosRUC != null && !frmCPEFiltrosRUC.isEmpty()) {
				filtro.setEmpreNroDoc(frmCPEFiltrosRUC);//mtoledo 19/01/2018 filtro numero de documento emisor
			}
			if (frmCPEFiltrosFecEmision != null && !frmCPEFiltrosFecEmision.isEmpty()) {
				// filtro.setVoucVnro(frmComprNro.toUpperCase());
			}
			if (frmCPEFiltrosMontoTotal != null && !frmCPEFiltrosMontoTotal.isEmpty()) {
				 filtro.setTotal(frmCPEFiltrosMontoTotal.toUpperCase());
			}
			if (frmCPEFiltrosResulSunat != null && !frmCPEFiltrosResulSunat.isEmpty()) {
				 filtro.setEstadoSunat(frmCPEFiltrosResulSunat);
			}
			if (frmCPEFiltrosfecIniFecFin != null && !frmCPEFiltrosfecIniFecFin.isEmpty()) {
				 String fechas[] = frmCPEFiltrosfecIniFecFin.split("-");
				 Date fechaEmisionIni = Util.StringtoDate(fechas[0].trim());
				 Date fechaEmisionFin = Util.StringtoDate(fechas[1].trim());
				 filtro.setFechaEmisionIni(fechaEmisionIni);
				 filtro.setFechaEmisionFin(fechaEmisionFin);
			}  
			PaginaResultado<TVoucherFilter> response2 = voucherrest.getVoucherFilter(filtro,beanDS);

			List<TVoucherFilter> LstdoCompr = null;
			if (response2.getCantidad() > 0) {
				LstdoCompr = response2.getResultados();
			}
			long mil=new Date().getTime();
			if (LstdoCompr != null) {
				//files de los pdf 
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(Util.getRutaMasiva()+"recibos"+mil+".zip"));
				for (Object objs : LstdoCompr) {
					TVoucherFilter vistaCompro = mapper.convertValue(objs, TVoucherFilter.class);
					//generando el zip para los pdf de solo los aprobados
					if(null!= vistaCompro.getEstadoSunat() && vistaCompro.getEstadoSunat().equals("0") && null!=vistaCompro.getUrlPDF() ) {
						try {
						out.putNextEntry(new ZipEntry(vistaCompro.getEmpreNroDoc()+"-"+vistaCompro.getTipoDoc()+"-"+vistaCompro.getNroDoc()+".pdf")); 
						FileInputStream in = new FileInputStream(vistaCompro.getUrlPDF());
						
						 byte[] b = new byte[1024];
					        int count;

					        while ((count = in.read(b)) > 0) {
					            out.write(b, 0, count);
					        }
					        in.close();
						}catch(Exception e) {
							
						}
					}else {
						
					}
					
				}
				
				out.close();
				
			}
			
			try {
				File file = new File(Util.getRutaMasiva()+"recibos"+mil+".zip");
				InputStream is = new FileInputStream(Util.getRutaMasiva()+"recibos"+mil+".zip");

				// MIME type of the file
				response.setContentType("application/octet-stream");
				// Response header
				response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
				// Read from the file and write into the response
				OutputStream os = response.getOutputStream();
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
				os.close();
				is.close();
				}catch(Exception e) {
					
				}
			
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
			e.printStackTrace();
			//return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			//return null;
		}
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response,HttpSession ses, @RequestParam(value = "file", required = true) String fileName,
			@RequestParam(value = "tipo", required = false) String tipoFile) throws IOException {

		// buscar las url del voucher
		TVoucherGet filtro = new TVoucherGet();
		TVoucher voucher = new TVoucher();
		filtro.setPaginacion(new PaginacionFiltro(1, 1));
		filtro.setVoucBident(new Long(fileName));
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			PaginaResultado<TVoucher> resultado = voucherrest.getVoucherFilter(filtro,beanDS);
			if (resultado != null && resultado.getCantidad() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				voucher = mapper.convertValue(resultado.getResultados().get(0), TVoucher.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String urlFile = "";
		switch (tipoFile) {
		case "1":
			// xml
			urlFile = voucher.getVoucUrlXml();
			break;
		case "2":
			// pdf
			urlFile = voucher.getVoucUrlPdf();
			break;
		case "3":
			// cdr
			urlFile = voucher.getVoucUrlCdr();
			break;

		default:
			break;
		}

		// fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.toString());
		try {
		File file = new File(urlFile);
		InputStream is = new FileInputStream(urlFile);

		// MIME type of the file
		response.setContentType("application/octet-stream");
		// Response header
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		// Read from the file and write into the response
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		}catch(Exception e) {
			
		}
	}
	
	
	@RequestMapping(value = "/downloadExterno", method = RequestMethod.GET)
	public void downloadExterno(HttpServletResponse response,HttpSession ses, 
			@RequestParam(value = "file", required = true) String fileName,
			@RequestParam(value = "tipo", required = false) String tipoFile,
			@RequestParam(value = "idDS", required = false) String idDS) throws IOException {

		// buscar las url del voucher
		TVoucherGet filtro = new TVoucherGet();
		TVoucher voucher = new TVoucher();
		filtro.setPaginacion(new PaginacionFiltro(1, 1));
		filtro.setVoucBident(new Long(fileName));
		//BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
//		BeanDS beanDS=Util.getcadenaConexion(idDS);
		BeanDS beanDS=Util.getcadenaConexion2();
		try {
            /*********************************************************************************************************/
			/*---------------------------     ACCESO BD -------------------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("ACCESO BD");
			TBusinessBDFilterGet filtroBD = new TBusinessBDFilterGet();
			filtroBD.setPaginacion(new PaginacionFiltro(1, 1));
			filtroBD.setPersVnumdoc(idDS);
			PaginaResultado<TBusinessBDFilter> responseBD = BussinesRest.getTBusinessBDFilter(filtroBD,beanDS);
			TBusinessBDFilter businessBD = new TBusinessBDFilter();
			ObjectMapper mapper2 = new ObjectMapper();
			if (responseBD != null && responseBD.getCantidad() > 0) {
				businessBD = mapper2.convertValue(responseBD.getResultados().get(0), TBusinessBDFilter.class);
				beanDS.setId(Long.toString(businessBD.getBubdBident()));
		    	beanDS.setUser(businessBD.getBubdVuserbd());
		    	beanDS.setPass(businessBD.getBubdVpassbd());
		    	beanDS.setUrl("jdbc:postgresql://"+businessBD.getBubdVipbd()+":"+businessBD.getBubdVportbd()+"/"+businessBD.getBubdVnamebd());
			}
			PaginaResultado<TVoucher> resultado = voucherrest.getVoucherFilter(filtro,beanDS);
			if (resultado != null && resultado.getCantidad() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				voucher = mapper.convertValue(resultado.getResultados().get(0), TVoucher.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String urlFile = "";
		switch (tipoFile) {
		case "1":
			// xml
			urlFile = voucher.getVoucUrlXml();
			break;
		case "2":
			// pdf
			urlFile = voucher.getVoucUrlPdf();
			break;
		case "3":
			// cdr
			urlFile = voucher.getVoucUrlCdr();
			break;

		default:
			break;
		}

		// fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.toString());
		try {
		File file = new File(urlFile);
		InputStream is = new FileInputStream(urlFile);

		// MIME type of the file
		response.setContentType("application/octet-stream");
		// Response header
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		// Read from the file and write into the response
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		}catch(Exception e) {
			
		}
	}
	
	
	@RequestMapping(value = "/verPDF", method = RequestMethod.GET)
	public void verPDF(HttpServletResponse response,HttpSession ses, @RequestParam(value = "file", required = true) String fileName,
			@RequestParam(value = "tipo", required = false) String tipoFile) throws IOException {

		// buscar las url del voucher
		TVoucherGet filtro = new TVoucherGet();
		TVoucher voucher = new TVoucher();
		filtro.setPaginacion(new PaginacionFiltro(1, 1));
		filtro.setVoucBident(new Long(fileName));
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			PaginaResultado<TVoucher> resultado = voucherrest.getVoucherFilter(filtro,beanDS);
			if (resultado != null && resultado.getCantidad() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				voucher = mapper.convertValue(resultado.getResultados().get(0), TVoucher.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String urlFile = "";
		switch (tipoFile) {
		case "1":
			// xml
			urlFile = voucher.getVoucUrlXml();
			break;
		case "2":
			// pdf
			urlFile = voucher.getVoucUrlPdf();
			break;
		case "3":
			// cdr
			urlFile = voucher.getVoucUrlCdr();
			break;

		default:
			break;
		}

		// fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.toString());
		try {
			File outPutFile=new File(urlFile);
			
			 byte[] byteArray = new byte[(int)outPutFile.length()];
			    byteArray = FileUtils.readFileToByteArray(outPutFile);  
			    
			 byte[] documentInBytes = byteArray;         
		        response.setHeader("Content-Disposition", "inline; filename=\"report.pdf\"");
		        response.setDateHeader("Expires", -1);
		        response.setContentType("application/pdf");
		        response.setContentLength(documentInBytes.length);
		        response.getOutputStream().write(documentInBytes);
		        
			//stream = response.getOutputStream();
			/*response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=\"" +  outPutFile.getName() + "\"");
			response.setContentLength((int) outPutFile.length());*/
		}catch(Exception e) {
			
		}
	}
	
//	@RequestMapping(value = "/buscarcpe")
//	public ModelAndView listContactBuscarCPE(ModelAndView model) throws IOException {
//		model.setViewName("/ComprobanteElectronico/BuscarCPE"); // "/Empresa/Empresa" Cliente/Cliente
//		try {
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return model;
//	}

	
	@RequestMapping(value = "/buscarcpe")
	public ModelAndView listContactBuscarCPE(ModelAndView model) throws IOException {
		model.setViewName("/ComprobanteElectronico/BuscarCPE"); // "/Empresa/Empresa" Cliente/Cliente
		try {
			String hostUri = Util.getconsultarEmpresas();
			 List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
			    if (hostUri != null){
			    String[] empre = hostUri.split(";"); 	   
				    for (String empresaConsulta : empre) {
				    	HashMap<String, Object> map = new HashMap<>();
				    	map.put("empresaConsulta", empresaConsulta);	
				    	objLista.add(map);
				    }
				    model.addObject("empresasprueba", objLista);
			    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value = "/reenviar", method = RequestMethod.POST)
	@ResponseBody
	public String reenviarCorreo(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "correo", required = false,defaultValue="") String correo
	) {
		System.out.println("===========Inicio-> comprobante/reenviar ");

		try {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setId(new Long(id));
			PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtro,beanDS);

			TVoucherGet filtroV = new TVoucherGet();
			filtroV.setPaginacion(new PaginacionFiltro(1, 1));
			filtroV.setVoucBident(new Long(id));
			PaginaResultado<TVoucher> responseV = voucherrest.getVoucher(filtroV,beanDS);
			// .queryParam("idPlan", 1)
			TVoucher voucher = new TVoucher();

			ObjectMapper mapper = new ObjectMapper();
			if (responseV.getCantidad() > 0) {
				voucher = mapper.convertValue(responseV.getResultados().get(0), TVoucher.class);
			} else {
				voucher = null;
			}

			if (response.getCantidad() > 0) {
				TVoucherFilter vistaCompro = mapper.convertValue(response.getResultados().get(0), TVoucherFilter.class);

				String clienteNombre = vistaCompro.getNombreCliente(); 
				String fechaEmision = Util.datetoString2(vistaCompro.getFechaEmision());
				String tipoDocElec = vistaCompro.getTipoDocDescr();
				String nroDoc = vistaCompro.getNroDoc();
				String total = vistaCompro.getTotal();
				String nroRucEmisor=vistaCompro.getEmpreNroDoc();

				//obtener el busi_bident
				TPersonGet personGet = new TPersonGet();
				personGet.setPersVdoctype(Integer.parseInt(vistaCompro.getEmprTipoDocDescr())+"");
				personGet.setPersVnumdoc(vistaCompro.getEmpreNroDoc());
				personGet.setPaginacion(new PaginacionFiltro(1, 1));
				PaginaResultado<TPerson> resulPerson=new PaginaResultado<>();
				try{
					resulPerson=personRest.getPerson(personGet,beanDS);
				}catch(Exception e){
					e.printStackTrace();
				}
				mapper = new ObjectMapper();
				TPerson personaEmpresa=new TPerson();
				if(resulPerson!=null && resulPerson.getCantidad()>0){
					personaEmpresa = mapper.convertValue(resulPerson.getResultados().get(0), TPerson.class);
				}
				
				TLegalPerson legalPerson = null;
				
				TLegalPersonGet filtroLP = new TLegalPersonGet();
				filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroLP.setLegaBident(personaEmpresa.getLegaBident());
				PaginaResultado<TLegalPerson> lLegalPerson = legalPersonRest.getLegalPerson(filtroLP,beanDS);
				
				if(null!= lLegalPerson && lLegalPerson.getCantidad()>0 ) {
					legalPerson= mapper.convertValue(lLegalPerson.getResultados().get(0), TLegalPerson.class);
				}
				
				
				if (voucher != null) {
					EmailGet correoRptaSunat = new EmailGet();
					List<CorreoPersona> listaTo = new ArrayList<>();

					if (!StringUtils.isEmpty(voucher.getVoucClieCorreoCpe0())) {
						listaTo.add(new CorreoPersona(voucher.getVoucClieCorreoCpe0(), ""));
					}
					if (!StringUtils.isEmpty(voucher.getVoucClieCorreoCpe1())) {
						listaTo.add(new CorreoPersona(voucher.getVoucClieCorreoCpe1(), ""));
					}
					if (!StringUtils.isEmpty(voucher.getVoucClieCorreoCpe2())) {
						listaTo.add(new CorreoPersona(voucher.getVoucClieCorreoCpe2(), ""));
					}
					if (!StringUtils.isEmpty(correo)) {
						listaTo.add(new CorreoPersona(correo, ""));
					}
					correoRptaSunat.setTo(listaTo);
					correoRptaSunat.setTituloMensaje("Comprobante Electrónico");

					String cuerpoMensaje = "";

					TParamBussinesGet email= new TParamBussinesGet();
					email.setPaginacion(new PaginacionFiltro(1, 1));
					email.setPabuBkey("correo.cliente");
					try{
						PaginaResultado<TParamBussines> responseE = BussinesRest.getParamBussines(email,beanDS);
						TParamBussines cor = new TParamBussines();
						if (responseE != null && null!=responseE.getCantidad() && responseE.getCantidad() > 0) {
							cor = mapper.convertValue(responseE.getResultados().get(0), TParamBussines.class);
							cuerpoMensaje = Util.generarBodyCorreo(clienteNombre, fechaEmision, legalPerson.getLegaBusiname(),nroRucEmisor, tipoDocElec, nroDoc,
									total,cor.getPabuBvalue());
						}
					}catch(Exception e){
						logger.error("Ocurrio un error al obtener el correo a enviar al cliente");
					}
					
					
					
					correoRptaSunat.setCuerpoMensaje(cuerpoMensaje);

					List<Archivo> files = new ArrayList<>();
					Archivo fileXML = new Archivo();
					fileXML.setNombreArchivo(vistaCompro.getEmpreNroDoc() + "-"+vistaCompro.getTipoDoc()+"-" + vistaCompro.getNroDoc() + ".xml");
					fileXML.setContenidoArchivo(Util.encode(Util.getRutaInicial() + "/" + vistaCompro.getEmpreNroDoc() + "/docGenerados/"
							+ vistaCompro.getEmpreNroDoc() + "-"+vistaCompro.getTipoDoc()+"-" + vistaCompro.getNroDoc() + ".xml"));
					files.add(fileXML);
					fileXML=new Archivo();
					fileXML.setNombreArchivo(vistaCompro.getEmpreNroDoc() + "-"+vistaCompro.getTipoDoc()+"-" + vistaCompro.getNroDoc() + ".pdf");
					fileXML.setContenidoArchivo(Util.encode(Util.getRutaInicial() + "/" + vistaCompro.getEmpreNroDoc() + "/docGenerados/"
							+ vistaCompro.getEmpreNroDoc() + "-"+vistaCompro.getTipoDoc()+"-" + vistaCompro.getNroDoc() + ".pdf"));
					files.add(fileXML);
					correoRptaSunat.setFiles(files);
					/*
					 * test branch 
					 * */
					try { 
						emilRest.getVoucher(correoRptaSunat,beanDS);
					}catch(Exception e) {
						e.printStackTrace();
						JsonObject robject = new JsonObject();
						robject.addProperty("msg", "error");
						robject.addProperty("respuesta", "Ocurrio un error");
						return new Gson().toJson(robject);
					}

				} else {
					JsonObject robject = new JsonObject();
					robject.addProperty("cod", "2");
					robject.addProperty("msg", "No se encontro el registro del voucher");
					return new Gson().toJson(robject);
				}

				Gson gson = new Gson();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "ok");
				robject.addProperty("cod", "1");
				return new Gson().toJson(robject);
			} else {
				JsonObject robject = new JsonObject();
				robject.addProperty("cod", "2");
				robject.addProperty("msg", "No se encontro el registro del voucher");
				return new Gson().toJson(robject);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Ocurrio un error");
			return new Gson().toJson(robject);

		}

	}
	
	@RequestMapping(value = "/detallecpenuevo", method = RequestMethod.POST)
	@ResponseBody
	public String listarComprobantesss(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "id", required = true) String id) throws IOException {
		try {

			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setId(new Long(id));
			PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtro,beanDS);
			// .queryParam("idPlan", 1)

			ObjectMapper mapper = new ObjectMapper();
			if (response.getCantidad() > 0) {
				TVoucherFilter vistaCompro = mapper.convertValue(response.getResultados().get(0), TVoucherFilter.class);
				Gson gson = new Gson();
				String data = gson.toJson(vistaCompro);
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "ok");
				robject.addProperty("respuesta", data);
				
				
				//robject.addProperty("respuesta", data);
				
				//obtener los demas atributos
				TVoucher voucher = new TVoucher();
				try {
					TVoucherGet filtroVoucher = new TVoucherGet();
					filtroVoucher.setPaginacion(new PaginacionFiltro(1, 1));
					filtroVoucher.setVoucBident(new Long(id));
					PaginaResultado<TVoucher> responseV = voucherrest.getVoucher(filtroVoucher,beanDS);
					
					if(responseV!=null && responseV.getCantidad()>0) {
						voucher = mapper.convertValue(responseV.getResultados().get(0), TVoucher.class);
					}
					data = gson.toJson(voucher);
					robject.addProperty("respuesta2", data);
					
					robject.addProperty("estadoSystem", (vistaCompro.getEstadoSistema().equals("1") ? "Correcto" : "Ocurrio un Error"));
					String envioSunat=vistaCompro.getEstadoSunat() != null ? vistaCompro.getEstadoSunat() : "";
					if(envioSunat.trim().length()>0){
						envioSunat= 	"SI ";
                    } else {
                    	envioSunat= 	"NO";
                    }
					robject.addProperty("enviadoSunat", envioSunat);
					
					String estadoSunat=vistaCompro.getEstadoSunat() != null
							? (vistaCompro.getEstadoSunat().equals("0") ? "1" : "0")
							: "";
							
					if(estadoSunat.equals("1")){
						estadoSunat= 	"ACEPTADO ";
		                    } else if(estadoSunat.trim().length()==0){
		                    	estadoSunat= 	"-";
		                    }else {
		                    	estadoSunat= 	"RECHAZADO";    	
		                }
					
					robject.addProperty("estadoSunat", estadoSunat);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
				return new Gson().toJson(robject);
			} else {
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "vacio");
				return new Gson().toJson(robject);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}
	}

	@RequestMapping(value = "/ver_cliente", method = RequestMethod.POST)
	@ResponseBody
	public String getCliente(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "tipoDoc", required = false) String frmComprNro,
			@RequestParam(value = "nroDoc", required = false) String frmComprCPE) {
		System.out.println("===========Inicio-> comprobante/lista_comprobante ");
		System.out.println("uri :" + Util.getHostVoucher());
		String sStart = rq.getParameter("draw");

		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		try {

			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			if (frmComprNro != null && !frmComprNro.isEmpty()) {
				// filtro.setVoucVnro(frmComprNro.toUpperCase());
			}
			if (frmComprCPE != null && !frmComprCPE.isEmpty()) {
				// filtro.setVoucVtypdocvou(frmComprCPE.toUpperCase());
			}
			PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtro,beanDS);
			// .queryParam("idPlan", 1)

			List<TVoucherFilter> LstdoCompr = null;
			if (response.getCantidad() > 0) {
				LstdoCompr = response.getResultados();
			}
			List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Object> obj = null;
			if (LstdoCompr != null) {
				for (Object objs : LstdoCompr) {
					TVoucherFilter vistaCompro = mapper.convertValue(objs, TVoucherFilter.class);
					obj = new HashMap<String, Object>();
					// obj.put("voucBcod",ObjectUtils.defaultIfNull(vistaCompro.getVoucBcod(),""));
					obj.put("voucVtypdocvou", ObjectUtils.defaultIfNull(vistaCompro.getTipoDocDescr(), ""));
					// obj.put("voucVserie",ObjectUtils.defaultIfNull(vistaCompro.getVoucVserie(),""));
					obj.put("voucVnro", ObjectUtils.defaultIfNull(vistaCompro.getNroDoc(), ""));
					obj.put("clieVructipo", ObjectUtils.defaultIfNull(vistaCompro.getEmprTipoDoc(), ""));
					obj.put("clieVrucemisor", ObjectUtils.defaultIfNull(vistaCompro.getEmpreNroDoc(), ""));
					obj.put("clieRS", ObjectUtils.defaultIfNull(vistaCompro.getEmprRS(), ""));
					obj.put("voucTemitiondate", Util.datetoString(vistaCompro.getFechaEmision()));
					obj.put("voucCcodmoneda", ObjectUtils.defaultIfNull(vistaCompro.getMonedaDescr(), ""));
					obj.put("voucDmonto", ObjectUtils.defaultIfNull(vistaCompro.getTotal(), ""));
					obj.put("voucVstateSistema",
							(vistaCompro.getEstadoSistema().equals("1") ? "Correcto" : "Ocurrio un Error"));

					/*
					 * obj.put("voucUrlXML",
					 * ObjectUtils.defaultIfNull(vistaCompro.getVoucUrlXml(),""));
					 * obj.put("voucUrlPDF",
					 * ObjectUtils.defaultIfNull(vistaCompro.getVoucUrlPdf(),""));
					 * obj.put("voucUrlCDR",
					 * ObjectUtils.defaultIfNull(vistaCompro.getVoucUrlCdr(),""));
					 */
					obj.put("voucUrlXML", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlPDF", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));
					obj.put("voucUrlCDR", ObjectUtils.defaultIfNull(vistaCompro.getId(), ""));

					obj.put("voucVstate", "1");
					// manejabndo los estados
					obj.put("voucEnvioSunat", vistaCompro.getEstadoSunat() != null ? vistaCompro.getEstadoSunat() : "");
					obj.put("voucEstadoSunat",
							vistaCompro.getEstadoSunat() != null
									? (vistaCompro.getEstadoSunat().equals("0") ? "1" : "0")
									: "");

					objLista.add(obj);
				}
			}
			JsonObject robject = new JsonObject();
			Gson gson = new Gson();
			String data = gson.toJson(objLista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			robject.addProperty("draw", sStart);
			robject.addProperty("recordsTotal", response.getCantidad());
			robject.addProperty("recordsFiltered", response.getCantidad());
			robject.add("data", jsonArray);
			return new Gson().toJson(robject);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/buscarcpe/validEmpresa", method = RequestMethod.POST)
	@ResponseBody
	public String validEmpresa(HttpServletRequest request, HttpSession ses,
			@RequestParam("empresa") String empresa) {

		String url = "";
		JsonObject jReturn = new JsonObject();

		try {
			BeanDS beanDS=Util.getcadenaConexion2();
			if(beanDS==null || beanDS.equals("")){
				jReturn.addProperty("estado", "error");
				jReturn.addProperty("msg", "La empresa "+empresa+" No se encuentra registrada");
				System.out.println("La empresa "+empresa+" No se encuentra registrada");
				url = "";
				jReturn.addProperty("url", url);
				return new Gson().toJson(jReturn);
			}
			
			/*********************************************************************************************************/
			/*---------------------------     ACCESO BD -------------------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("ACCESO BD");
			TBusinessBDFilterGet filtroBD = new TBusinessBDFilterGet();
			filtroBD.setPaginacion(new PaginacionFiltro(1, 1));
			filtroBD.setPersVnumdoc(empresa);
			PaginaResultado<TBusinessBDFilter> responseBD = BussinesRest.getTBusinessBDFilter(filtroBD,beanDS);
			TBusinessBDFilter businessBD = new TBusinessBDFilter();
			ObjectMapper mapper2 = new ObjectMapper();
			if (responseBD != null && responseBD.getCantidad() > 0) {
				businessBD = mapper2.convertValue(responseBD.getResultados().get(0), TBusinessBDFilter.class);
				beanDS.setId(Long.toString(businessBD.getBubdBident()));
		    	beanDS.setUser(businessBD.getBubdVuserbd());
		    	beanDS.setPass(businessBD.getBubdVpassbd());
		    	beanDS.setUrl("jdbc:postgresql://"+businessBD.getBubdVipbd()+":"+businessBD.getBubdVportbd()+"/"+businessBD.getBubdVnamebd());
			
			
			} else {
				jReturn.addProperty("estado", "error");
				jReturn.addProperty("msg", "Empresa no registrada");
				System.out.println("Empresa no registrada");
				return new Gson().toJson(jReturn);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jReturn.addProperty("estado", "error");
			jReturn.addProperty("msg", "Ocurrio un error");
			return new Gson().toJson(jReturn);
		}
		jReturn.addProperty("estado", "ok");
		return new Gson().toJson(jReturn);
	}
			
			
}
