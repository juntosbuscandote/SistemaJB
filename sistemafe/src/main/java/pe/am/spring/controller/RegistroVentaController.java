package pe.am.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ListaAnticipo;
import pe.am.spring.entity.ListaDesplegable;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.RegistroVenta;
import pe.am.spring.entity.Response;
import pe.am.spring.entity.RptaOperPDF;
import pe.am.spring.entity.RptaRegistroVenta;
import pe.am.spring.entity.TAddressPerson;
import pe.am.spring.entity.TAddressPersonGet;
import pe.am.spring.entity.TBranchOffice;
import pe.am.spring.entity.TBranchOfficeGet;
import pe.am.spring.entity.TBrand;
import pe.am.spring.entity.TBrandGet;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TClientEndFilterPerson;
import pe.am.spring.entity.TClientEndFilterPersonGet;
import pe.am.spring.entity.TCountry;
import pe.am.spring.entity.TCountryGet;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TEmployeeGet;

import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TNoteCredDeb;
import pe.am.spring.entity.TNoteCredDebPost;
import pe.am.spring.entity.TOfficeUserxSucursal;
import pe.am.spring.entity.TOfficeUserxSucursalGet;
import pe.am.spring.entity.TParamBranchOffice;
import pe.am.spring.entity.TParamBranchOfficeGet;
import pe.am.spring.entity.TParamBussines;
import pe.am.spring.entity.TParamBussinesGet;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;

import pe.am.spring.entity.TSaleDetailPost;
import pe.am.spring.entity.TSales;
import pe.am.spring.entity.TSalesDetailFilter;
import pe.am.spring.entity.TSalesDetailFilterGet;
import pe.am.spring.entity.TSalesFilter;
import pe.am.spring.entity.TSalesFilterGet;
import pe.am.spring.entity.TSalesGet;
import pe.am.spring.entity.TSalesPost;
import pe.am.spring.entity.TSalesPut;
import pe.am.spring.entity.TSalesSearch;
import pe.am.spring.entity.TSalesSearchGet;
import pe.am.spring.entity.TSeries;
import pe.am.spring.entity.TSeriesFilter;
import pe.am.spring.entity.TSeriesFilterGet;
import pe.am.spring.entity.TSeriesGet;
import pe.am.spring.entity.TService;

import pe.am.spring.entity.TUbigeo;
import pe.am.spring.entity.TUbigeoGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;
import pe.am.spring.entity.TUserFilterGet;

import pe.am.spring.entity.TVoucherFilter;
import pe.am.spring.entity.TVoucherFilterGet;
import pe.am.spring.entity.VistaPreviaCab;
import pe.am.spring.entity.VistaPreviaDet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.AddressPersonRest;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.ClientRest;
import pe.am.spring.rest.EmailPersonRest;
import pe.am.spring.rest.EmailRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.NaturalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.PhonePersonRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.rest.VentasRest;
import pe.am.spring.rest.VoucherRest;
import pe.am.spring.service.PersonaService;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/registroventa")
public class RegistroVentaController {
	protected static Logger logger = Logger.getLogger(RegistroVentaController.class);

	@Autowired
	TUserRest UserRest;

	@Autowired
	LegalPersonRest legalPersonRest;
	@Autowired
	VoucherRest voucherrest;
	
	@Autowired
	PersonRest PersonRest;
	@Autowired
	BussinesRest BussinesRest;
	@Autowired
	EmailPersonRest EmailPersonRest;
	@Autowired
	AddressPersonRest AddressPersonRest;
	@Autowired
	PhonePersonRest PhonePersonRest;
	@Autowired
	CatalogueRest CataRest;
	@Autowired
	NaturalPersonRest NaturalPersonRest;

	@Autowired
	EmailRest emailRest;
	
	@Autowired
	VentasRest ventasRest; 
	
	@Autowired
	ClientRest clientendRest;
	

	@Autowired
	PersonaService personaService;
	
	

	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		model.addObject("fProcessVenta", "save");
		model.setViewName("/Venta/RegistroVenta");
		String NombreVentana="Registro de Ventas";
		model.addObject("NombreVentana", NombreVentana);
//	    TBusiness bu s  
		logger.info("Ingresando a registro de ventas");
		// validar sesion
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		Long idRole = null;
		
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
		
		idRole = (Long) ses.getAttribute(Constantes.SESION_ROLE);
		ObjectMapper mapper = new ObjectMapper();
		try {
			/**
			 * mtoledo modales
			 */
			model = personaService.cargarPersona(model,beanDS);
			
			//azevallos inicio
			//validar si pedira el tipo de cambio
			try {
				
			Integer flagTC = (Integer) ses.getAttribute(Constantes.SESION_TIPO_CAMBIO);
				if(null!=flagTC) {
					model.addObject("flagTC", flagTC);
					
					model.addObject("fechaActual", Util.datetoStringGlobal(new Date(), "dd/MM/yyyy"));
					model.addObject("dataVentas", "v");
				}
			}catch(Exception e) {
				
			}
			//azevallos fin
			
			/**
			 * Listar empresa para vendedores
			 * Segun role
			 */
			/** Listar las empresas **/
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			TBussinesFilterGet filtroEmpresa = new TBussinesFilterGet();
			filtroEmpresa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			if (idRole != 3) {	
				filtroEmpresa.setBusibident(bussi.getBusiBident());
			}
			PaginaResultado<TBussinesFilter> rspBussines = BussinesRest.getBussinesFilter(filtroEmpresa,beanDS);
			List<TBussinesFilter> lstTBussines = new ArrayList<TBussinesFilter>();
			for (Object tBussinesObj : rspBussines.getResultados()) {
				TBussinesFilter tBussines = mapper.convertValue(tBussinesObj, TBussinesFilter.class);
				lstTBussines.add(tBussines);
			}
			model.addObject("lstTBussines", lstTBussines);
			
			if (rspBussines != null && rspBussines.getCantidad() > 0) {
				TBussinesFilter tBussinesVP = mapper.convertValue(rspBussines.getResultados().get(0), TBussinesFilter.class);
				model.addObject("direccionEmpresa", tBussinesVP.getAddrVaddress());
				model.addObject("emailEmpresa", tBussinesVP.getMailVemail());
				model.addObject("telefonoEmpresa", tBussinesVP.getPhonVphone());
				model.addObject("nroRucEmpresa", tBussinesVP.getPersVnumdoc());
			}
			TParamBussinesGet filtroS = new TParamBussinesGet();
			filtroS.setPaginacion(new PaginacionFiltro(1, 1));
			filtroS.setPabuBkey("LOGO_EXCEL");
			PaginaResultado<TParamBussines> responseS = BussinesRest.getParamBussines(filtroS,beanDS);
			TParamBussines sunat = new TParamBussines();
			if (responseS != null && responseS.getCantidad() > 0) {
				sunat = mapper.convertValue(responseS.getResultados().get(0), TParamBussines.class);
				model.addObject("imagenLogo", sunat.getPabuBvalue());
			}
			
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO MONEDA ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar monedas de catalogue");
			TCatalogueDetGet filtroscatalogomoneda = new TCatalogueDetGet();
			filtroscatalogomoneda.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogomoneda.setCataBident(new Long(2));
			filtroscatalogomoneda.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatmoneda = CataRest.getCatalogueDet(filtroscatalogomoneda,beanDS);
			TCatalogueDet procatamoneda = new TCatalogueDet();
			List<TCatalogueDet> lstCatDocMoneda = new ArrayList<>();
			for (Object catdetmoneda : responsescatmoneda.getResultados()) {
				procatamoneda = mapper.convertValue(catdetmoneda, TCatalogueDet.class);
				lstCatDocMoneda.add(procatamoneda);
			}
			model.addObject("listaCatDetMoneda", lstCatDocMoneda);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO FORMA DE PAGO------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando forma de pago");
			TCatalogueDetGet filtroscatalogoformadepa = new TCatalogueDetGet();
			filtroscatalogoformadepa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoformadepa.setCataBident(new Long(21));
			PaginaResultado<TCatalogueDet> responsescatformadepa = CataRest.getCatalogueDet(filtroscatalogoformadepa,beanDS);
			TCatalogueDet procataformadepa = new TCatalogueDet();
			List<TCatalogueDet> lstCatDocformadepa = new ArrayList<>();
			for (Object catdetformadepa : responsescatformadepa.getResultados()) {
				procataformadepa = mapper.convertValue(catdetformadepa, TCatalogueDet.class);
				lstCatDocformadepa.add(procataformadepa);
			}
			model.addObject("listaCatDetFormadepa", lstCatDocformadepa);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO  ------------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando documento");
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(1));
			// filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responsescat = CataRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet procata = new TCatalogueDet();
			List<TCatalogueDet> lstCatDoc = new ArrayList<>();
			for (Object catdet : responsescat.getResultados()) {
				procata = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatDoc.add(procata);
			}
			model.addObject("listaCatDetComp", lstCatDoc);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO Cliente ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando clientes");
			TClientEndFilterPersonGet filtroCLP = new TClientEndFilterPersonGet();
			filtroCLP.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCLP.setEstado("1");
			filtroCLP.setPersVdoctype("1");
			//			filtroCLP.setBusiBident(tEmployee.getBusiBident());
			TClientEndFilterPerson prouser = new TClientEndFilterPerson();
			PaginaResultado<TClientEndFilterPerson> response = clientendRest.getClientEndFilterRest(filtroCLP,beanDS);
			List<TClientEndFilterPerson> lstUser = new ArrayList<TClientEndFilterPerson>();
			for (Object catdetuser : response.getResultados()) {
			prouser = mapper.convertValue(catdetuser, TClientEndFilterPerson.class);
			lstUser.add(prouser);
			}
			model.addObject("filtrarClienteNroC", lstUser);			

			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE PERIODO  ------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando periodos");
			TCatalogueDetGet filtroscatalogoperiodos = new TCatalogueDetGet();
			filtroscatalogoperiodos.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoperiodos.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescatperiod = CataRest.getCatalogueDet(filtroscatalogoperiodos,beanDS);
			TCatalogueDet procataperiodo = new TCatalogueDet();
			List<TCatalogueDet> lstCatPeriodo = new ArrayList<>();
			List<ListaDesplegable> lstOpciones = new ArrayList<>();
			
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH)+1;
			
			for (Object catdetperiod : responsescatperiod.getResultados()) {
				procataperiodo = mapper.convertValue(catdetperiod, TCatalogueDet.class);
				
				ListaDesplegable bean= new ListaDesplegable();
				bean.setOpcion(procataperiodo);
				if(month==Integer.parseInt(procataperiodo.getCatdCident())) {
					bean.setEstado(true);
				}else {
					bean.setEstado(false);
				}
				lstOpciones.add(bean);
				
				lstCatPeriodo.add(procataperiodo);
			}
			//model.addObject("listaCatDetPeriod", lstCatPeriodo);
			model.addObject("listaCatDetPeriod", lstOpciones);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE ANIO EJERCICIO  -----------------------------------------*/
			/*********************************************************************************************************/
			
			Date dateAnio= new Date();
			Calendar calAnio = Calendar.getInstance();
			calAnio.setTime(dateAnio);
			
			int year = calAnio.get(Calendar.YEAR);
			int yearPost = year + 5;
			int yearPre = year - 5;
			
			List<ListaDesplegable> lstOpcionesAnio = new ArrayList<>();
			for (int i = yearPost; i >= yearPre; i--) {
				ListaDesplegable bean= new ListaDesplegable();
				String anio = Integer.toString(i);
				bean.setOpcAnio(anio);
				if(i==year) {
					bean.setEstado(true);
				}else {
					bean.setEstado(false);
				}
				lstOpcionesAnio.add(bean);
				
			}
			model.addObject("listaAnio", lstOpcionesAnio);
			
			
			/*********************************************************************************************************/
			/*----------------------------     SERIE Y NRO DEL COMPROBANTE  -----------------------------------------*/
			/*********************************************************************************************************/
			logger.info("serie y nro de comprobante");
			/*Date fechaTC = Util.stringtoDate(Util.datetoString2(new Date()));
			TSeries series=new TSeries();
			TSeriesGet filtroLP = new TSeriesGet();
			filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
			if(null != tEmployee) {
				filtroLP.setBusiBident(tEmployee.getBusiBident());				
			}
			
			List<TSeries> lstSeriesLP = null;
			PaginaResultado<TSeries> responseLG = ventasRest.getSeries(filtroLP);
			if (responseLG.getCantidad() > 0) {
				lstSeriesLP = responseLG.getResultados();
			}
			
			if (null != lstSeriesLP && lstSeriesLP.size()>0) {
				series = mapper.convertValue(lstSeriesLP.get(0), TSeries.class);
				// seteando falg de fecha
				model.addObject("serieComprobante", series.getSeriCdocElectronic());
				model.addObject("nroComprobante", series.getSeriVnumberSeries());
			}*/
			
			
			
			
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE I.A Y T.I.A ------------------------------------------------*/
			/*********************************************************************************************************/
			
			
			logger.info("Listando tipo de indicador afecto");
			TCatalogueDetGet filtroscatalogoindicador = new TCatalogueDetGet();
			filtroscatalogoindicador.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoindicador.setCataBident(new Long(8));

			PaginaResultado<TCatalogueDet> responsescatindicador = CataRest.getCatalogueDet(filtroscatalogoindicador,beanDS);
			TCatalogueDet procataindicador = new TCatalogueDet();
			List<TCatalogueDet> lstCatIndicador = new ArrayList<>();
			for (Object catdetindicador : responsescatindicador.getResultados()) {
				procataindicador = mapper.convertValue(catdetindicador, TCatalogueDet.class);
				lstCatIndicador.add(procataindicador);
			}
			model.addObject("listaCatDetIndicador", lstCatIndicador);
			
			

			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE PAISES	  -----------------------------------------------*/
			/*********************************************************************************************************/
			TCountryGet filtrosPais = new TCountryGet();
			filtrosPais.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TCountry> responsePais = CataRest.getCountry(filtrosPais,beanDS);
			TCountry proPais = new TCountry();
			List<TCountry> lstPais = new ArrayList<>();
			for (Object catPais : responsePais.getResultados()) {
				proPais = mapper.convertValue(catPais, TCountry.class);
				lstPais.add(proPais);
			}
			model.addObject("listaPais", lstPais);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE TIPOS DE DOCUMENTO	  -----------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipDoc = new TCatalogueDetGet();
			filtrosTipDoc.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipDoc.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responseTipDoc = CataRest.getCatalogueDet(filtrosTipDoc,beanDS);
			TCatalogueDet proTipDoc = new TCatalogueDet();
			List<TCatalogueDet> lstCatTipDoc = new ArrayList<>();
			for (Object catdet : responseTipDoc.getResultados()) {
				proTipDoc = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatTipDoc.add(proTipDoc);
			}
			model.addObject("listaCatDet", lstCatTipDoc);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DE DEPARTAMENTO ----------------------------------------------*/
			/*********************************************************************************************************/
			
			TUbigeoGet filtrosUbigeo = new TUbigeoGet();
			filtrosUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> responseUbigeo = CataRest.getUbigeo(filtrosUbigeo,beanDS);
			TUbigeo proUbigeo = new TUbigeo();
			List<TUbigeo> lstUbigeo = new ArrayList<>();
			for (Object catUbigeo : responseUbigeo.getResultados()) {
				proUbigeo = mapper.convertValue(catUbigeo, TUbigeo.class);
				lstUbigeo.add(proUbigeo);
			}
			model.addObject("listUbigeos", lstUbigeo);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE TIPOS DE CPE	  ---------------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipDocCPE = new TCatalogueDetGet();
			filtrosTipDocCPE.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipDocCPE.setCataBident(new Long(1));
			PaginaResultado<TCatalogueDet> responseTipDocCPE = CataRest.getCatalogueDet(filtrosTipDocCPE,beanDS);
			TCatalogueDet proTipDocCPE = new TCatalogueDet();
			List<TCatalogueDet> lstCatTipDocCPE = new ArrayList<>();
			for (Object catdetCompras : responseTipDocCPE.getResultados()) {
				proTipDocCPE = mapper.convertValue(catdetCompras, TCatalogueDet.class);
				lstCatTipDocCPE.add(proTipDocCPE);
			}
			model.addObject("listaCatDetCPE", lstCatTipDocCPE);
			/*********************************************************************************************************/
			/*--------------------------------     MOTIVO NOTA CREDITO	  -------------------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipMotCre = new TCatalogueDetGet();
			filtrosTipMotCre.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipMotCre.setCataBident(new Long(31));
			PaginaResultado<TCatalogueDet> responseMotCre = CataRest.getCatalogueDet(filtrosTipMotCre,beanDS);
			TCatalogueDet proMotCre = new TCatalogueDet();
			List<TCatalogueDet> lstMotCre = new ArrayList<>();
			for (Object catdet : responseMotCre.getResultados()) {
				proMotCre = mapper.convertValue(catdet, TCatalogueDet.class);
				lstMotCre.add(proMotCre);
			}
			model.addObject("listaMotCre", lstMotCre);
			/*********************************************************************************************************/
			/*--------------------------------     MOTIVO NOTA DEBITO	  -------------------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipMotDeb = new TCatalogueDetGet();
			filtrosTipMotDeb.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipMotDeb.setCataBident(new Long(32));
			PaginaResultado<TCatalogueDet> responseMotDeb = CataRest.getCatalogueDet(filtrosTipMotDeb,beanDS);
			TCatalogueDet proMotDeb = new TCatalogueDet();
			List<TCatalogueDet> lstMotDeb = new ArrayList<>();
			for (Object catdet : responseMotDeb.getResultados()) {
				proMotDeb = mapper.convertValue(catdet, TCatalogueDet.class);
				lstMotDeb.add(proMotDeb);
			}
			model.addObject("listaMotDeb", lstMotDeb);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE TIPOS DE DOCUMENTO	  -----------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipDocVentas = new TCatalogueDetGet();
			filtrosTipDocVentas.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipDocVentas.setCataBident(new Long(29));
			PaginaResultado<TCatalogueDet> responseTipDocVentas = CataRest.getCatalogueDet(filtrosTipDocVentas,beanDS);
			TCatalogueDet proTipDocVentas = new TCatalogueDet();
			List<TCatalogueDet> lstCatTipDocVentas = new ArrayList<>();
			for (Object catdetVentas : responseTipDocVentas.getResultados()) {
				proTipDocVentas = mapper.convertValue(catdetVentas, TCatalogueDet.class);
				lstCatTipDocVentas.add(proTipDocVentas);
			}
			model.addObject("listaCatDetVentas", lstCatTipDocVentas);
		
			/*********************************************************************************************************/
			/*---------------------------     LISTA SUCURSALES POR USUARIO ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando estado de sucursales por usuario");
			TOfficeUserxSucursalGet filtrosofficexuser = new TOfficeUserxSucursalGet();
			filtrosofficexuser.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosofficexuser.setUserVuser(user.getUserVuser());			
			PaginaResultado<TOfficeUserxSucursal> responseOffiUser = BussinesRest.getOfficeUserxSucursal(filtrosofficexuser, beanDS);
			TOfficeUserxSucursal procataofficeuser = new TOfficeUserxSucursal();
			List<TOfficeUserxSucursal> lstCatDocofficeuser = new ArrayList<>();
			for (Object catdetofficeuser : responseOffiUser.getResultados()) {
				procataofficeuser = mapper.convertValue(catdetofficeuser, TOfficeUserxSucursal.class);
				lstCatDocofficeuser.add(procataofficeuser);
			}

			model.addObject("listaSucursal", lstCatDocofficeuser);
			/*
			 * mtoledo 07/03/2019 CWA-591
			 */
			/*********************************************************************************************************/
			/*---------------------------     LISTAR TIPO OPERACION  ------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando tipo operacion");
			TCatalogueDetGet filtroOperacion = new TCatalogueDetGet();
			filtroOperacion.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroOperacion.setCataBident(new Long(62));
			PaginaResultado<TCatalogueDet> responseTipoOperacion = CataRest.getCatalogueDet(filtroOperacion,beanDS);
			List<TCatalogueDet> lstTipoOperacion = new ArrayList<>();
			lstTipoOperacion = Arrays.asList(mapper.convertValue(responseTipoOperacion.getResultados(), TCatalogueDet[].class));
			model.addObject("listaOperacion", lstTipoOperacion);
			
			/*
			 * mtoledo 10/03/2019 CWA-591
			 */
			//Se cambio a autocompletable Luis S. clase "listarClases"
			/*********************************************************************************************************/
			/*---------------------------     LISTAR CODIGO SUNAT ------------------------------------------------*/
			/*********************************************************************************************************/
//			TCatalogueDetGet filtroscatClase = new TCatalogueDetGet();
//			filtroscatClase.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
//			filtroscatClase.setCataBident(new Long(50));
//			filtroscatClase.setCatdVkey2(Constantes.flagItem.PRODUCTO.getCode());
//			PaginaResultado<TCatalogueDet> responsescatClase = CataRest.getCatalogueDet(filtroscatClase,beanDS);
//			List<TCatalogueDet> lstCodigoSunat = new ArrayList<>();
//			lstCodigoSunat = Arrays.asList(mapper.convertValue(responsescatClase.getResultados(), TCatalogueDet[].class));
//			model.addObject("lstCodigoSunat", lstCodigoSunat);
			
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
		}
		return model;
	}

	/*********************************************************************************************************/
	/*---------------------------------       LISTA PROVINCIA ---------------------------------------------*/
	/*********************************************************************************************************/
	@RequestMapping(value = "/listarProvincia", method = RequestMethod.POST)
	@ResponseBody
	public String listarProvicia(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codIa", required = true) String codIa) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		JsonObject robject = new JsonObject();
		try {	
//			logger.info("Listando tipo de tipo indicador afecto");
			TUbigeoGet filtroscatalogoindicadortipo = new TUbigeoGet();
			filtroscatalogoindicadortipo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> responsescatindicadortipo = CataRest.getUbigeo(filtroscatalogoindicadortipo,beanDS);
			TUbigeo procataindicadortipo = new TUbigeo();
			List<TUbigeo> lstCatIndicadortipo = new ArrayList<>();
			JsonArray aReturn = new JsonArray();
			for (Object catdetindicadortipo : responsescatindicadortipo.getResultados()) {
				procataindicadortipo = mapper.convertValue(catdetindicadortipo, TUbigeo.class);
				JsonObject jReturn = new JsonObject();
				jReturn.addProperty("id", procataindicadortipo.getUbigIident());
				jReturn.addProperty("des", procataindicadortipo.getUbigProvinc());
				aReturn.add(jReturn);
			}
			robject.add("toption", aReturn);	
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
//			logger.error(errors.toString());
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
	
	
	/*********************************************************************************************************/
	/*---------------------------------       LISTA DISTRITO   ---------------------------------------------*/
	/*********************************************************************************************************/
	@RequestMapping(value = "/listarDistrito", method = RequestMethod.POST)
	@ResponseBody
	public String listarDistrito(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codIa", required = true) String codIa) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		JsonObject robject = new JsonObject();
		try {	
//			logger.info("Listando tipo de tipo indicador afecto");
			TUbigeoGet filtroscatalogoindicadortipo = new TUbigeoGet();
			filtroscatalogoindicadortipo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> responsescatindicadortipo = CataRest.getUbigeo(filtroscatalogoindicadortipo,beanDS);
			TUbigeo procataindicadortipo = new TUbigeo();
			List<TUbigeo> lstCatIndicadortipo = new ArrayList<>();
			JsonArray aReturn = new JsonArray();
			for (Object catdetindicadortipo : responsescatindicadortipo.getResultados()) {
				procataindicadortipo = mapper.convertValue(catdetindicadortipo, TUbigeo.class);
				JsonObject jReturn = new JsonObject();
				jReturn.addProperty("id", procataindicadortipo.getUbigIident());
				jReturn.addProperty("des", procataindicadortipo.getUbigDistrit());
				aReturn.add(jReturn);

			}
			robject.add("toption", aReturn);	
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
//			logger.error(errors.toString());
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
	
	@RequestMapping(value = "/lista_Cotizacion", method = RequestMethod.POST)
	@ResponseBody
	public String getFiltroDocumentos(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmUserFiltroCodigoComercial", required = false) String frmUserFiltroCodigoComercial
	// ,
	// @RequestParam(value = "frmUserFiltroNombre", required = false) String
	// frmUserFiltroNombre
	// ,
	// @RequestParam(value = "frmUserFiltroMarca", required = false) String
	// frmUserFiltroMarca
	// ,@RequestParam(value = "frmUserFiltroEmpresa", required = false) String
	// frmUserFiltroEmpresa,
	// @RequestParam(value = "frmUserFiltroEstado", required = false) String
	// frmUserFiltroEstado
	) {
		System.out.println("===========Inicio-> cotizacion/lista_Cotizacion ");

		String sStart = rq.getParameter("draw");
		ObjectMapper mapper = new ObjectMapper();

		try {
//			TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			// String cantidad = rq.getParameter("length");
			// String sEcho = rq.getParameter("start");
			// int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TUserFilterGet filtroLP = new TUserFilterGet();
			// filtroLP.setPaginacion(new
			// PaginacionFiltro(page,Integer.parseInt(cantidad)));
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			if (bussi != null) {
				filtroLP.setBusiBident(bussi.getBusiBident());
			}
			// if(frmUserFiltroCodigoComercial!=null &&
			// !frmUserFiltroCodigoComercial.isEmpty()) {
			// filtroLP.setUserVuser(frmUserFiltroCodigoComercial);
			// }
			// if(frmUserFiltroNombre!=null && !frmUserFiltroNombre.isEmpty()) {
			// filtroLP.setNombres(frmUserFiltroNombre);
			// }
			if (frmUserFiltroCodigoComercial != null && !frmUserFiltroCodigoComercial.isEmpty()) {
				filtroLP.setProfbident(new Long(frmUserFiltroCodigoComercial));
			}
			// if(frmUserFiltroEmpresa!=null && !frmUserFiltroEmpresa.isEmpty()) {
			// filtroLP.setLegaBusiname(frmUserFiltroEmpresa);
			// }
			// if(frmUserFiltroEstado!=null && !frmUserFiltroEstado.isEmpty()) {
			// Boolean estado= frmUserFiltroEstado.equals("1")?true:false;
			// filtroLP.setEstadoUsu(estado);
			// }
			// UserRest
			PaginaResultado<TUserFilter> response = UserRest.getUserFilter(filtroLP,beanDS);
			// .queryParam("idPlan", 1)

			List<TUserFilter> LstdoUser = null;
			if (response.getCantidad() > 0) {
				LstdoUser = response.getResultados();
			}
			List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
//			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Object> obj = null;
			if (LstdoUser != null) {
				for (Object objs : LstdoUser) {
					TUserFilter vistaUser = mapper.convertValue(objs, TUserFilter.class);
					// TUserFilter vistaEmploye = mapper.convertValue(objs, TUserFilter.class);
					obj = new HashMap<String, Object>();
					// obj.put("userVuser",ObjectUtils.defaultIfNull(vistaUser.getUserVuser(), ""));
					obj.put("userNumdoc", ObjectUtils.defaultIfNull(vistaUser.getNombres(), ""));// aqui debe ir el
																									// nombre
																									// concatenado
					// obj.put("userVdescription",ObjectUtils.defaultIfNull(vistaUser.getProfVdescription(),
					// ""));
					// obj.put("userTregistrationDate",
					// ObjectUtils.defaultIfNull(vistaUser.getUserTregistrationDate(), ""));
					// obj.put("userBusiname",ObjectUtils.defaultIfNull(vistaUser.getLegaBusiname(),
					// ""));
					// obj.put("userState",ObjectUtils.defaultIfNull (vistaUser.getEstado(), ""));
					// obj.put("employeeState",ObjectUtils.defaultIfNull (vistaUser.getEstado(),
					// ""));

					objLista.add(obj);
				}
			}
			JsonObject robject = new JsonObject();
			Gson gson = new Gson();
			String data = gson.toJson(objLista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			robject.addProperty("msg", "ok");
			robject.addProperty("draw", sStart);
			robject.addProperty("recordsTotal", response.getCantidad());
			robject.addProperty("recordsFiltered", response.getCantidad());
			// data = gson.toJson(tLegalPerson);
			robject.addProperty("usuarioPer_legal", data);
			robject.add("data", jsonArray);
			robject.addProperty("objLista", data);
			// Gson gson = new Gson();
			// String data = gson.toJson(usuario);
			// JsonObject robject = new JsonObject();
			// robject.addProperty("msg", "ok");
			// robject.addProperty("usuario", data);

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

	@RequestMapping(value = "/exploradorcoti")
	public ModelAndView listExploradorCotizacion(ModelAndView model, HttpSession ses) throws IOException {
		model.setViewName("/Venta/ExploradorCotizacion");
		String NombreVentana="Explorador Cotización";
		model.addObject("NombreVentana", NombreVentana);
		// validar sesion
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (user == null) {
			model.setViewName("/homepost");
			return model;
		}
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}


	
	/*********************************************************************************************************/
	/*---------------------------------       LISTA I.A Y T.I.A      ---------------------------------------------*/
	/*********************************************************************************************************/
	@RequestMapping(value = "/listartia", method = RequestMethod.POST)
	@ResponseBody
	public String listartia(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codIa", required = true) String codIa) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		JsonObject robject = new JsonObject();
		try {	
			logger.info("Listando tipo de tipo indicador afecto");
			TCatalogueDetGet filtroscatalogoindicadortipo = new TCatalogueDetGet();
			filtroscatalogoindicadortipo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoindicadortipo.setCataBident(new Long(23));
			filtroscatalogoindicadortipo.setCatdVrelation(codIa);
			PaginaResultado<TCatalogueDet> responsescatindicadortipo = CataRest.getCatalogueDet(filtroscatalogoindicadortipo,beanDS);
			TCatalogueDet procataindicadortipo = new TCatalogueDet();
			List<TCatalogueDet> lstCatIndicadortipo = new ArrayList<>();
			JsonArray aReturn = new JsonArray();
			for (Object catdetindicadortipo : responsescatindicadortipo.getResultados()) {
				procataindicadortipo = mapper.convertValue(catdetindicadortipo, TCatalogueDet.class);
				JsonObject jReturn = new JsonObject();
				jReturn.addProperty("id", procataindicadortipo.getCatdCident());
				jReturn.addProperty("des", procataindicadortipo.getCatdVdescription());
				aReturn.add(jReturn);
			}
			robject.add("toption", aReturn);	
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
	
	
	
	/*********************************************************************************************************/
	/*---------------------------------       LISTA NUMERO DE ORDEN POR  SERIE    --------------------------------------------*/
	/*********************************************************************************************************/
	
	@RequestMapping(value = "/listarSerienro", method = RequestMethod.POST)
	@ResponseBody
	public String listarSerienro(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codSerie", required = true) String codSerie) {
 		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);		
 		TSeriesFilter serieLP=new TSeriesFilter();
		try {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TSeriesFilterGet filtroV = new TSeriesFilterGet();
			filtroV.setPaginacion(new PaginacionFiltro(1, 1));
			filtroV.setSeriBident(new Long(codSerie));
			filtroV.setSeriCstate("1");
			PaginaResultado<TSeriesFilter> responseV = ventasRest.getSeriesFilter(filtroV,beanDS);
			List<TSeriesFilter> LstdoSeriLP = null;
			if (responseV.getCantidad() > 0) {
				LstdoSeriLP = responseV.getResultados();
			}
			List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapperLP = new ObjectMapper();
			HashMap<String, Object> objLP = null;

			if (LstdoSeriLP != null) {
				for (Object objsLP : LstdoSeriLP) {
					serieLP = mapperLP.convertValue(objsLP, TSeriesFilter.class);
					int serieSuma = Integer.parseInt(serieLP.getSeriVnumberSeries());
					int serienro = serieSuma+1;
					objLP = new HashMap<String, Object>();
					objLP.put("numeroSerie", ObjectUtils.defaultIfNull(serienro, ""));			
					objListaLP.add(objLP);
				}				
				System.out.println(objListaLP.size());
			}
			Gson gson = new Gson();
			String data = gson.toJson(objLP);
			System.out.println(data);
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "ok");
			robject.addProperty("Campos_Nro", data);
			return new Gson().toJson(robject);

		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}
	
	/*********************************************************************************************************/
	/*---------------------------------       LISTA SERIE    --------------------------------------------*/
	/*********************************************************************************************************/
	@RequestMapping(value = "/listarSerie", method = RequestMethod.POST)
	@ResponseBody
	public String listarSerie(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codSer", required = true) String codSer,
			@RequestParam(value = "codDoc", required = true) String codDoc){
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		JsonObject robject = new JsonObject();
		try {			
			logger.info("Listando almacen por serie");
			TSeriesFilterGet filtrosSerie = new TSeriesFilterGet();
			filtrosSerie.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosSerie.setOffiBident(new Long(codSer));
			filtrosSerie.setSeriVtypeDoc(codDoc);
			PaginaResultado<TSeriesFilter> responsesSeries = ventasRest.getSeriesFilter(filtrosSerie,beanDS);
			TSeriesFilter Series = new TSeriesFilter();
			List<TSeriesFilter> lstSeries = new ArrayList<>();
			JsonArray aReturn1 = new JsonArray();
			for (Object catdetSERIE : responsesSeries.getResultados()) {
				Series = mapper.convertValue(catdetSERIE, TSeriesFilter.class);
			if(Series.getSeriCstate()==null || Series.getSeriCstate().equals("1")  ){
				JsonObject jReturn = new JsonObject();
				int serieSuma = Integer.parseInt(Series.getSeriVnumberSeries());
				int serienro = serieSuma+1;
				jReturn.addProperty("id", Series.getSeriBident());
				jReturn.addProperty("des", Series.getSeriCdocElectronic());
				jReturn.addProperty("serie", Series.getSeriCdocElectronic());
				jReturn.addProperty("numDoc", serienro);
				aReturn1.add(jReturn);
				}
			}
			robject.add("toption", aReturn1);	
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
	
	 
	     
 	@RequestMapping(value = "/consultaSerieNro", method = RequestMethod.POST)
	@ResponseBody
	public String consultaSerieNro(HttpSession ses, HttpServletRequest rq,

			@RequestParam(value = "idTipoDoc", required = true) String idTipoDoc,
			@RequestParam(value = "sucur", required = true) String sucur) throws IOException {
		
		TSeries serie=new TSeries();
		ObjectMapper mapperLP = new ObjectMapper();
		try {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			TSeriesFilterGet filtroLP = new TSeriesFilterGet();
			filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
			filtroLP.setSeriVtypeDoc(idTipoDoc);
			filtroLP.setOffiBident(new Long(sucur));
			TSeriesGet filtroLP1 = new TSeriesGet();
			filtroLP1.setPaginacion(new PaginacionFiltro(1, 1));
			filtroLP1.setSeriVtypeDoc(idTipoDoc);

//			TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapperLP.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			
			if(null!=bussi) {
				filtroLP.setBusiBident(bussi.getBusiBident());
			}
			logger.info("Consultando la serie y el nro de comprobante para la empresa id: "+bussi.getBusiBident());

			PaginaResultado<TSeries> responseLG = ventasRest.getNextSeries(filtroLP1,beanDS);

			List<TSeries> LstdoEmpreLP = null;
			if (responseLG.getCantidad() > 0 || responseLG.getCantidad() == null ) {
				LstdoEmpreLP = responseLG.getResultados();
			}
			
			JsonObject robject = new JsonObject();
			
			
			if ( null != LstdoEmpreLP && LstdoEmpreLP.size()>0) {
				serie = mapperLP.convertValue(LstdoEmpreLP.get(0), TSeries.class);
				
				
				robject.addProperty("msg", "ok");
				robject.addProperty("serie", serie.getSeriCdocElectronic());
				robject.addProperty("nro", Integer.parseInt(serie.getSeriVnumberSeries())+1);
			}else{
				robject.addProperty("msg", "error");
			}
			
			return new Gson().toJson(robject);

		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}
	    
 	
 	
 	@RequestMapping(value = "/InsertarRegistroVenta", method = RequestMethod.POST)
	@ResponseBody
	public String insertarRegistroVenta(HttpSession ses, HttpServletRequest rq,
			 @RequestBody String json) throws IOException {
		
		JsonObject robject = new JsonObject();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
//		TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		String razonSocial = null,ubigeo=null,nombreComercial=null,direcEmpresa=null,rucEmpresa=null,tipoDocEmpr=null;
		String depart="",distrito="",provincia="";
		ObjectMapper mapper = new ObjectMapper();
		try {

			JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
			
			RegistroVenta venta = new RegistroVenta();
			
			TSalesPost sales = new TSalesPost();
			TSalesGet saleverificar= new TSalesGet();
			/*******Desde el campo********/
			String nrodocumento=jsonObj.get("nroComprobante").getAsString();
			String sredocumento=jsonObj.get("Serie").getAsString();
			String tipoComprobante=jsonObj.get("tipoComprobante").getAsString();
			
			System.out.println(jsonObj.get("SerieID").getAsLong()+"/"+jsonObj.get("sucursal").getAsLong()+"/"+jsonObj.get("tipoComprobante").getAsString());
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			
			TSeriesFilterGet filtroSerieID= new TSeriesFilterGet();
			filtroSerieID.setPaginacion(new PaginacionFiltro(1,1));
			filtroSerieID.setSeriBident(jsonObj.get("SerieID").getAsLong());

			PaginaResultado<TSeriesFilter> responseUser = ventasRest.getSeriesFilter(filtroSerieID,beanDS);

			List<TSeriesFilter> LstdoSerie = null;
			if (responseUser.getCantidad() > 0 || responseUser.getCantidad() == null ) {
				LstdoSerie = responseUser.getResultados();
			}
			
			TSeriesFilter serie = null;
			if ( null != LstdoSerie && LstdoSerie.size()>0) {
				serie = mapper.convertValue(LstdoSerie.get(0), TSeriesFilter.class);
			}
//			
			TSeriesFilterGet filtroSerie= new TSeriesFilterGet();
			filtroSerie.setPaginacion(new PaginacionFiltro(1,1));
			filtroSerie.setOffiBident(serie.getOffiBident());
			filtroSerie.setSeriCdocElectronic(serie.getSeriCdocElectronic());
			filtroSerie.setSeriVtypeDoc(serie.getSeriVtypeDoc());
			List<TSeriesFilter> rptaSerie= ventasRest.generarSerieyNro(filtroSerie,beanDS);
			String serieCompr="",nroCompr="";
			if(null!=rptaSerie && rptaSerie.size()>0){
				
				TSeriesFilter beanS=mapper.convertValue(rptaSerie.get(0), TSeriesFilter.class);
				serieCompr = beanS.getSeriCdocElectronic();
				nroCompr = beanS.getSeriVnumberSeries();				
			}

			Long idCliente = new Long(jsonObj.get("idCliente").getAsString());
			
			sales.setClieBident(idCliente); 
			
			
			Long idEmployee = new Long(jsonObj.get("idVendedor").getAsString());
			sales.setEmplBident(idEmployee);		
			
			sales.setCoinBident(jsonObj.get("moneda").getAsString());
				 
			sales.setOfficeBident(jsonObj.get("sucursal").getAsString());
			
			sales.setSaleVexercise(jsonObj.get("ejercicio").getAsString());
			sales.setRepoBident(new Long(jsonObj.get("almacen").getAsString()));
			sales.setSaleVoperationRegisterNumber(jsonObj.get("codRegVenta").getAsString());
			System.out.println("Fecha de front "+jsonObj.get("fechaMovimiento").getAsString());
			sales.setSaleBdocAdvance("");//ARREGLAR DESPUES
			Long nrodias = new Long(jsonObj.get("dias").getAsString());
			sales.setSaleBnumberDay(nrodias);
			sales.setSaleBnumberDocClie(jsonObj.get("nroDocCliente").getAsString());			// cambiar por data real 
			sales.setSaleBnumberDocSeller(jsonObj.get("nroDocVendedor").getAsString());			// cambiar por data real 
			sales.setSaleBuserCreate(Long.toString(user.getPersBident()));
			sales.setSaleBuserModify(Long.toString(user.getPersBident()));
			sales.setSaleCstatePurchaseorder(Constantes.ESTADO_VENTA.VENTA.getCode());
			sales.setSaleTdateExpiry(Util.StringtoDateDMA(jsonObj.get("fechaVencimiento").getAsString()));
			sales.setSaleTdateUpdate(null);
			sales.setSaleTmovementDate(Util.datetoString8(jsonObj.get("fechaMovimiento").getAsString()));
			sales.setSaleTpaymentDate(Util.StringtoDateDMA(jsonObj.get("fechaMovimientopago").getAsString()));
			sales.setSaleTregistrationDate(new Date());
			sales.setSaleVaddressClient(jsonObj.get("direccionCliente").getAsString());
			sales.setSaleVaffair(jsonObj.get("observacion").getAsString());
			sales.setSaleVbusinameClient(jsonObj.get("nombreCliente").getAsString());
			sales.setSaleVbusinameSeller(jsonObj.get("nombreVendedor").getAsString());
			sales.setSaleVindicatorAfecto(jsonObj.get("indicador").getAsString());
//			sales.setSaleVnumberVoucher(jsonObj.get("nroComprobante").getAsString());
			sales.setSaleVnumberVoucher(nroCompr);
			sales.setSaleVperiod(jsonObj.get("periodo").getAsString());
			//nota cred/deb
			if(null!=tipoComprobante && !tipoComprobante.equals("")) {
				if(tipoComprobante.equals("07")) {
					sales.setSaleTdocRefereceDate(Util.StringtoDateDMA(jsonObj.get("fecDocReferencia").getAsString()));
					sales.setSaleVcodTipReferece(jsonObj.get("tipCompReferencia").getAsString());
					sales.setSaleVserieDocReferece(jsonObj.get("serCompReferencia").getAsString());
					sales.setSaleVnumDocReferece(jsonObj.get("nroCompReferencia").getAsString());
					sales.setSaleBcodMotivoNotaCredito(jsonObj.get("codMotivoCre").getAsString());
					sales.setSaleVaffair(jsonObj.get("observacionNota").getAsString());
				} else if(tipoComprobante.equals("08")) {
					sales.setSaleTdocRefereceDate(Util.StringtoDateDMA(jsonObj.get("fecDocReferencia").getAsString()));
					sales.setSaleVcodTipReferece(jsonObj.get("tipCompReferencia").getAsString());
					sales.setSaleVserieDocReferece(jsonObj.get("serCompReferencia").getAsString());
					sales.setSaleVnumDocReferece(jsonObj.get("nroCompReferencia").getAsString());
					sales.setSaleBcodMotivoNotaDebito(jsonObj.get("codMotivoDeb").getAsString());
					sales.setSaleVaffair(jsonObj.get("observacionNota").getAsString());
				} else {
					sales.setSaleVaffair(jsonObj.get("observacion").getAsString());
					//mtoledo 09/03/2019 CWA-591
					if(tipoComprobante.equals("01") || tipoComprobante.equals("03")) {
						sales.setSaleTypeOperation(jsonObj.get("tipoOperacion").getAsString());
						if(sales.getSaleTypeOperation().equals("2")){
							sales.setSaleTypeAnticipo(jsonObj.get("tipoAnticipo").getAsString());
							if(sales.getSaleTypeAnticipo().equals("1")){
								sales.setSaleTotalAnticipo(jsonObj.get("total").getAsBigDecimal());	
								sales.setSaleTotalDisponibleAnticipo(jsonObj.get("total").getAsBigDecimal());
							}else if(sales.getSaleTypeAnticipo().equals("2")){
								JsonArray arrayAnticipo = jsonObj.get("arrayAnticipos").getAsJsonArray();
								List<ListaAnticipo> listaAnticipo =new ArrayList<ListaAnticipo>();
								for (JsonElement jsonElement : arrayAnticipo) {
									ListaAnticipo lstAnticipo=new ListaAnticipo();
									lstAnticipo.setIdsale(jsonElement.getAsJsonObject().get("idCPE").getAsLong());
									lstAnticipo.setSerie(jsonElement.getAsJsonObject().get("serie").getAsString());
									lstAnticipo.setNumero(jsonElement.getAsJsonObject().get("numero").getAsString());
									lstAnticipo.setSaldoDisponible(jsonElement.getAsJsonObject().get("montopendiente").getAsBigDecimal());
									lstAnticipo.setSaldoUtilizado(jsonElement.getAsJsonObject().get("montoutilizar").getAsBigDecimal());
									
									BigDecimal montoSinIGV = jsonElement.getAsJsonObject().get("montoutilizar").getAsBigDecimal().divide(new BigDecimal(1.18), 2, RoundingMode.CEILING);
									lstAnticipo.setSaldoSinIGVUtil(montoSinIGV);
									lstAnticipo.setIgvMontoUtil(lstAnticipo.getSaldoUtilizado().subtract(lstAnticipo.getSaldoSinIGVUtil()));
									
									listaAnticipo.add(lstAnticipo);
								}
								venta.setListaAnticipo(listaAnticipo);
							}
						}
						
					}
				}
			}
			
            if(jsonObj.get("ventaTituloGratuito").getAsString().equals("true")) {
				sales.setSaleVsaleTitleFree("1");
			}else {
				sales.setSaleVsaleTitleFree("0");
			}
//			sales.setSaleVserieVoucher(jsonObj.get("Serie").getAsString());
			sales.setSaleVserieVoucher(serieCompr);
			
			
			sales.setSaleVtypeDocClie(jsonObj.get("tipoDocCliente").getAsString());
			sales.setSaleVtypeDocSeller(jsonObj.get("tipoDocVendedor").getAsString());	 
			if("null".equals(jsonObj.get("tipoIndicador"))) {
				sales.setSaleVtypeIndicatorAfecto(jsonObj.get("tipoIndicador").getAsString());
			}
			
			sales.setSaleVtypeVoucher(jsonObj.get("tipoComprobante").getAsString());
			

			sales.setWaypayBident(jsonObj.get("formaPago").getAsString());
			
			Long idBusiBident=null;
			

			String nombreVendedor=jsonObj.get("nombreVendedor").getAsString();
			String nroDocVendedor = jsonObj.get("nroDocVendedor").getAsString();
			String tipoDocVendedor= jsonObj.get("tipoDocVendedor").getAsString();
			String idVendedor = jsonObj.get("idVendedor").getAsString();
			
			//obtener la empresa del vendedor
			
			
			try {
				
				TPerson person = null;
				TBussines empresa= null;
				TLegalPerson legalPerson = null;
				
				TEmployeeGet employeeGet=new TEmployeeGet(); 
				employeeGet.setPaginacion(new PaginacionFiltro(1, 1));
				employeeGet.setEmplBident(new Long(idVendedor));
				PaginaResultado<TEmployee> employeeList = BussinesRest.getEmployee(employeeGet,beanDS);
				if(employeeList!=null && employeeList.getCantidad() > 0 ) {
//					TEmployee tEmployees = mapper.convertValue(employeeList.getResultados().get(0), TEmployee.class);
					
					logger.info("Buscando Empresa id: "+bussi.getBusiBident());
					TBussinesGet filtro = new TBussinesGet();
					filtro.setPaginacion(new PaginacionFiltro(1, 1));
					filtro.setBusiBident(bussi.getBusiBident());
					PaginaResultado<TBussines> lEmpresa = BussinesRest.getBussines(filtro,beanDS);
					
					if(null!= lEmpresa && lEmpresa.getCantidad()>0 ) {
						empresa= mapper.convertValue(lEmpresa.getResultados().get(0), TBussines.class);
						idBusiBident=empresa.getBusiBident();
					}
					
					logger.info("Buscando Persona id: "+bussi.getPersBident());
					TPersonGet filtroP = new TPersonGet();
					filtroP.setPaginacion(new PaginacionFiltro(1, 1));
					filtroP.setPersBident(empresa.getPersBident());
					PaginaResultado<TPerson> lPerson = PersonRest.getPerson(filtroP,beanDS);
					
					if(null!= lPerson && lPerson.getCantidad()>0 ) {
						person= mapper.convertValue(lPerson.getResultados().get(0), TPerson.class);
					}
					
					logger.info("Buscando Persona Legal id: "+bussi.getPersBident());
					TLegalPersonGet filtroLP = new TLegalPersonGet();
					filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
					filtroLP.setLegaBident(person.getLegaBident());
					PaginaResultado<TLegalPerson> lLegalPerson = legalPersonRest.getLegalPerson(filtroLP,beanDS);
					
					if(null!= lLegalPerson && lLegalPerson.getCantidad()>0 ) {
						legalPerson= mapper.convertValue(lLegalPerson.getResultados().get(0), TLegalPerson.class);
					}
					
					TAddressPersonGet filtroTAddressPersonGet=new TAddressPersonGet();
					filtroTAddressPersonGet.setPaginacion(new PaginacionFiltro(1, 1));
					filtroTAddressPersonGet.setPersBident(person.getPersBident());
					PaginaResultado<TAddressPerson> rspTAddressPerson= AddressPersonRest.getAddressPerson(filtroTAddressPersonGet,beanDS);
					TAddressPerson tAddressPerson=new TAddressPerson();
					tAddressPerson = mapper.convertValue(rspTAddressPerson.getResultados().get(0),TAddressPerson.class);
					direcEmpresa= tAddressPerson.getAddrVaddress();
					
					razonSocial = legalPerson.getLegaBusiname();
					nombreComercial = person.getPersVtradename();
					rucEmpresa = person.getPersVnumdoc();
					tipoDocEmpr = person.getPersVdoctype();
					
				}else {
					
				}
				
			}catch(Exception e) {
				logger.error("Ocurrio un error al buscar la empresa");
			}
			
			sales.setBusiBident(idBusiBident);
			
			//datos del comprobante 
			venta.setTipoDoc(jsonObj.get("tipoComprobante").getAsString());
			venta.setFechaEmision(jsonObj.get("fechaMovimiento").getAsString());
			venta.setIdRegVenta(jsonObj.get("codRegVenta").getAsString());

			
			venta.setSerieDoc(serieCompr);
			venta.setNroDoc(nroCompr);
			
			
			if(null!=tipoComprobante && !tipoComprobante.equals("")) {
				if(tipoComprobante.equals("07")) {
					venta.setFecDocReferencia(jsonObj.get("fecDocReferencia").getAsString());
					venta.setTipCompReferencia(jsonObj.get("tipCompReferencia").getAsString());
					venta.setSerCompReferencia(jsonObj.get("serCompReferencia").getAsString());
					venta.setNroCompReferencia(jsonObj.get("nroCompReferencia").getAsString());
					venta.setCodMotivoCre(jsonObj.get("codMotivoCre").getAsString());
					venta.setObs(jsonObj.get("observacionNota").getAsString());
				} else if(tipoComprobante.equals("08")) {
					venta.setFecDocReferencia(jsonObj.get("fecDocReferencia").getAsString());
					venta.setTipCompReferencia(jsonObj.get("tipCompReferencia").getAsString());
					venta.setSerCompReferencia(jsonObj.get("serCompReferencia").getAsString());
					venta.setNroCompReferencia(jsonObj.get("nroCompReferencia").getAsString());
					venta.setCodMotivoDeb(jsonObj.get("codMotivoDeb").getAsString());
					venta.setObs(jsonObj.get("observacionNota").getAsString());
				} else {
					venta.setObs(jsonObj.get("observacion").getAsString());
				}
			}
			
		
			
		
			venta.setFechaVencDoc(jsonObj.get("fechaVencimiento").getAsString());
			venta.setMonedaDoc(jsonObj.get("moneda").getAsString());
			venta.setEjercicio(jsonObj.get("ejercicio").getAsString());
			venta.setIdAlmacen(jsonObj.get("almacen").getAsString());
//			venta.setSaleVguide(jsonObj.get("guia").getAsString());
//			venta.setSaleVorderpurchase(jsonObj.get("ordencompra").getAsString());
			
			
			String tipoCambio = jsonObj.get("tipoCambio").isJsonNull() ? "":jsonObj.get("tipoCambio").getAsString();
			if(jsonObj.get("moneda").getAsString().equals(Constantes.CATAMONEDA.SOLES.getCode())) {
				//tipoCambio=null;
				sales.setSaleTexchangeRate(tipoCambio);
				sales.setTypeBident(jsonObj.get("tipoCambioBident").getAsLong());
			}else {			
				sales.setSaleTexchangeRate(tipoCambio);
			}
			venta.setTipoCambioDoc(tipoCambio);			
			venta.setNombreCliente(jsonObj.get("nombreCliente").getAsString());
			venta.setEmailCliente(jsonObj.get("emailCliente").getAsString());
			venta.setDireccionCliente(jsonObj.get("direccionCliente").getAsString());
			venta.setNroDocCliente(jsonObj.get("nroDocCliente").getAsString());
			venta.setTipoDocCliente(jsonObj.get("tipoDocCliente").getAsString());			
			
			
			
			venta.setRazonsocialEmpr(razonSocial);
			venta.setUbigeoEmpr(ubigeo);
			venta.setNombrecomercialEmpr(nombreComercial);
			venta.setDireccionEmpr(direcEmpresa);
			venta.setProvinciaEmpr(provincia);
			venta.setDepartamentoEmpr(depart);
			venta.setDistritoEmpr(distrito);
			venta.setPaisEmpr("PE");
			venta.setNrorucEmpr(rucEmpresa);
			venta.setTipodocEmpr(tipoDocEmpr);
			venta.setIdMetodoPago(jsonObj.get("formaPago").getAsString());
			
			
			sales.setSaleVtypeIndicatorAfecto(jsonObj.get("tipoIndicador").getAsString());
			logger.info("Se procedera a calculaar los montos para enviar!!!");
			String tipoIA=jsonObj.get("indicador").getAsString();
			String tipoTIA=jsonObj.get("indicador").getAsString();
			
			try {
				String gravada=Constantes.indicador_ia.GRAVADA.getCode();
				String exonerada=Constantes.indicador_ia.EXONERADO.getCode();
				String inafecta=Constantes.indicador_ia.INAFECTO.getCode();
				String exportacion=Constantes.indicador_ia.EXPORTACION.getCode();
				String gratuitas=Constantes.indicador_ia.GRATUITAS.getCode();
				
				if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_OPERACION_ONEROSA.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PREMIO.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_DONACION.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PUBLICIDAD.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_BONIFICACIONES.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposExonerada.EXONERADA_OPERACION_ONEROSA.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_BONIFICACION.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PREMIO.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
					
				}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PUBLICIDAD.getCode())) {
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//llenando los campos del importe
			venta.setPorcIgvDoc("0.18");
			venta.setPorcIscDoc(null);
			venta.setMontoDctoGlobalDoc(jsonObj.get("impDescTot").getAsString());
			venta.setMontoTotalDctoDoc(jsonObj.get("impDescTot").getAsString());
			venta.setMontoTotalAnticipoDoc( jsonObj.get("impAnticipoTot").getAsString() );
			venta.setMontoTotalGravadaDoc(jsonObj.get("gravada").getAsString());
			venta.setMontoTotalInafectaDoc(jsonObj.get("inafecto").getAsString());
			venta.setMontoTotalExoneradaDoc(jsonObj.get("exonerada").getAsString());
			venta.setMontoTotalIgvDoc(jsonObj.get("igv").getAsString());
			venta.setMontoTotalGratuitaDoc(jsonObj.get("gratuita").getAsString());
			venta.setMontoTotalOtrosCargosDoc("0.00");
			venta.setMontoTotalOtrosTrib(jsonObj.get("gratuita").getAsString());
			venta.setMontoTotalDoc(jsonObj.get("total").getAsString());
			venta.setMontoIscDoc("0.00");
			System.out.println("moneda "+venta.getMonedaDoc());
			
			venta.setInafecto(jsonObj.get("inafecto").getAsString());
			venta.setGravada(jsonObj.get("gravada").getAsString());
			venta.setExonerada(jsonObj.get("exonerada").getAsString());
			venta.setExportacion(jsonObj.get("exportacion").getAsString());
			venta.setGratuita(jsonObj.get("gratuita").getAsString());
			venta.setNeto(jsonObj.get("neto").getAsString());
			venta.setIgv(jsonObj.get("igv").getAsString());
			venta.setImporteDescuento(jsonObj.get("impDescTot").getAsString());//agregar nuevo campo en filtros
			venta.setTotal(jsonObj.get("total").getAsString());
			venta.setConversion(jsonObj.get("conversion").getAsString());
			
			
//Tabla Venta Insert de Resultados
			
			sales.setSaleDunaffected(jsonObj.get("inafecto").getAsBigDecimal());
			sales.setSaleDtaxedBim(jsonObj.get("gravada").getAsBigDecimal());
			sales.setSaleDexonerated(jsonObj.get("exonerada").getAsBigDecimal());
			sales.setSaleDexport(jsonObj.get("exportacion").getAsBigDecimal());
            sales.setSaleDfreeAmount(jsonObj.get("gratuita").getAsBigDecimal());
            sales.setSaleDvaluetotal(jsonObj.get("valortotal").getAsBigDecimal());
            sales.setSaleDnet(jsonObj.get("neto").getAsBigDecimal());
            sales.setSaleDigv(jsonObj.get("igv").getAsBigDecimal());
            sales.setSaleDtotal(jsonObj.get("total").getAsBigDecimal());
            sales.setSaleDconversion(jsonObj.get("conversion").getAsBigDecimal());
            sales.setSaleDdiscount(jsonObj.get("impDescTot").getAsBigDecimal());
            sales.setSaleCstate(Constantes.flagVentaEstado.ACTIVO.getCode());
            sales.setSaleVtotalAmountLetters(jsonObj.get("totalletras").getAsString());
            System.out.println("guia "+jsonObj.get("guia").getAsString());
            System.out.println("orden compra "+jsonObj.get("ordencompra").getAsString());
            sales.setSaleVguide(jsonObj.get("guia").getAsString());
			sales.setSaleVorderpurchase(jsonObj.get("ordencompra").getAsString());
			sales.setSale_destination(null);
			sales.setSale_state_cash("1");
			sales.setSale_saldo_pending(jsonObj.get("total").getAsBigDecimal());
            String url= venta.getNrorucEmpr() +"-" + venta.getTipoDoc()+"-" + venta.getSerieDoc() +"-"+venta.getNroDoc();
            sales.setSaleUrlPdf(url+".pdf");
			venta.setSales(sales);
			
			JsonArray arrayDetalleVenta = jsonObj.get("arrayRegistros").getAsJsonArray();
			List<TSaleDetailPost> salesDatail = new ArrayList<>();
			String validaIngresoInventory = "";
			for (JsonElement jsonElement : arrayDetalleVenta) {
				TSaleDetailPost salesPost = new TSaleDetailPost();
//				System.out.println(jsonElement.getAsJsonObject().get("numero"));
//				Long nroprodserv = (jsonElement.getAsJsonObject().get("numero").equals("null")?null:jsonElement.getAsJsonObject().get("numero").getAsLong());
				Long nroprodserv = (jsonElement.getAsJsonObject().get("numero").isJsonNull()?null:jsonElement.getAsJsonObject().get("numero").getAsLong());
				String UndMed = jsonElement.getAsJsonObject().get("UnidadMedida").getAsString();
				String nomcortoprod =jsonElement.getAsJsonObject().get("nomcorto").getAsString();
				String Descripcionprodserv=jsonElement.getAsJsonObject().get("Descripcion").getAsString();
            if(UndMed!=null && UndMed.equals("ZZ")) {
//            	salesPost.setServBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
            	salesPost.setServBident(jsonElement.getAsJsonObject().get("codigo").isJsonNull()?null:jsonElement.getAsJsonObject().get("codigo").getAsLong());
            	
            	salesPost.setSdetVshortnameServ(nomcortoprod);
            	salesPost.setSdetVdescriptionServ(Descripcionprodserv);
            	validaIngresoInventory="0";
            }else {
//            	salesPost.setProdBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
            	salesPost.setProdBident(jsonElement.getAsJsonObject().get("codigo").isJsonNull()?null:jsonElement.getAsJsonObject().get("codigo").getAsLong());
            	
            	salesPost.setSdetVshortnameProd(nomcortoprod);
            	salesPost.setSdetVdescriptionProd(Descripcionprodserv);
            	validaIngresoInventory="1";
            }
            	salesPost.setSdetBnumber(nroprodserv);	
            	salesPost.setSdetVclassSunat(jsonElement.getAsJsonObject().get("claseSunat").getAsString());
				salesPost.setSdetVshortnameBrand(jsonElement.getAsJsonObject().get("nombrecortomarca").getAsString());
				salesPost.setSdetVdescriptionBrand(jsonElement.getAsJsonObject().get("nombredescripcionmarca").getAsString());
				salesPost.setSdetVnameBrand(jsonElement.getAsJsonObject().get("nombremarca").getAsString());
				salesPost.setSdetVcommercialCode(jsonElement.getAsJsonObject().get("codigoComercial").isJsonNull()?null:jsonElement.getAsJsonObject().get("codigoComercial").getAsString());
				salesPost.setSdetVconcept(jsonElement.getAsJsonObject().get("concepto").getAsString());
				salesPost.setSdetBmainPrice(jsonElement.getAsJsonObject().get("esprecioprincipal").getAsBoolean());
				salesPost.setSdetBigvIncludesPrice(jsonElement.getAsJsonObject().get("incluyeIgv").getAsBoolean());
				salesPost.setSdetVcode(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
				salesPost.setSdetVdescriptionCoinPrice(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
				salesPost.setSdetVdescriptionPrice(jsonElement.getAsJsonObject().get("preciodescripcionproducto").getAsString());
				salesPost.setSdetVmeassureUnity(jsonElement.getAsJsonObject().get("UnidadMedida").getAsString());
				salesPost.setSdetDquantity(new BigDecimal(jsonElement.getAsJsonObject().get("cantidad").getAsString()));
				salesPost.setSdetDunitValue(new BigDecimal(jsonElement.getAsJsonObject().get("valorUnitario").getAsString()));
				salesPost.setSdetDigvUnit(new BigDecimal(jsonElement.getAsJsonObject().get("igvUnitario").getAsString()));
				salesPost.setSdetDpriceUnit(new BigDecimal(jsonElement.getAsJsonObject().get("precioUnitario").getAsString()));
				salesPost.setSdetDvalueSale(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
				salesPost.setSdetDsaleValuePrice(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
				salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("precDescripMoneda").getAsString());
				salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
				try {
					BigDecimal porcDcto = new BigDecimal(jsonElement.getAsJsonObject().get("porcentaDesc").getAsString());
					salesPost.setSdetDdescPorcentage(porcDcto);
				}catch(Exception e) {
					logger.error("Revisar los campos de porcentaje de dcto");
					salesPost.setSdetDdescPorcentage(new BigDecimal("0.00"));
				}
				
				salesPost.setSdetDdescImport(new BigDecimal(jsonElement.getAsJsonObject().get("importeDesc").getAsString()));
				salesPost.setSdetDtaxBase(new BigDecimal(jsonElement.getAsJsonObject().get("baseImporte").getAsString()));
				salesPost.setSdetBincludeIgv(true);
				salesPost.setSdetDigv(new BigDecimal(jsonElement.getAsJsonObject().get("igv").getAsString()));
				salesPost.setSdetDgrossTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalBruto").getAsString()));
				salesPost.setSdetDnetTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalNeto").getAsString()));
				salesPost.setSdetVaffectionIndicator(jsonElement.getAsJsonObject().get("indicadorAfecto").getAsString());
				salesPost.setSdetVtypeAffectionIndicator(jsonElement.getAsJsonObject().get("tipoIndicadorAfecto").getAsString());
				salesPost.setSdetVobservation(jsonElement.getAsJsonObject().get("observacion").getAsString());
				salesPost.setSdetNdiscountValuePric(new BigDecimal(jsonElement.getAsJsonObject().get("precValorVentaDscto").getAsString()));
				salesPost.setSdetNigvdescuPric(new BigDecimal(jsonElement.getAsJsonObject().get("precIgvVentaDscto").getAsString()));
				salesPost.setSdetNdiscountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
				salesPost.setSdetDdiscountAmountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
				salesPost.setSdetTregistrationDate(new Date());
				salesPost.setSdetTdateUpdate(new Date());//Cambiara en el Update de Ventas
				salesPost.setSdetBuserModify(new Long(user.getPersBident()));//Cambiara para el Update de Ventas
				salesPost.setSdetBuserCreate(new Long(user.getPersBident()));
				salesPost.setStoreBident(jsonElement.getAsJsonObject().get("codigoAlmacen").isJsonNull()?null:jsonElement.getAsJsonObject().get("codigoAlmacen").getAsLong());
				
				if(null!=tipoComprobante && !tipoComprobante.equals("")) {
					if(tipoComprobante.equals("07") || tipoComprobante.equals("08")) {
						salesPost.setSdetCflagNote(Constantes.flagNotaEstado.ACTIVO.getCode());
					} else {
						salesPost.setSdetCflagNote(Constantes.flagNotaEstado.INACTIVO.getCode());
					}
				}
				
				try {						
					salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("tipoMonedaOrigen").getAsString());
					salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
				}catch(Exception e) {
					logger.error("Ocurrio un error, al tipo moneda origen y/o destino");
				}
				try {
					salesPost.setSdetDamountExchangeSales(new BigDecimal(jsonElement.getAsJsonObject().get("tipoCambioVenta").getAsString()));
					salesPost.setSdetDcurrencyConversion(new BigDecimal(jsonElement.getAsJsonObject().get("tipoConversion").getAsString()));
				}catch(Exception e) {
					salesPost.setSdetDamountExchangeSales(new BigDecimal("0.00"));
					salesPost.setSdetDcurrencyConversion(new BigDecimal("0.00"));
				}
				//salesPost.setSdetDtotalDiscount(new BigDecimal(jsonElement.getAsJsonObject().get("").getAsString()));//agregar monto total de descuento
				salesPost.setSdetDtotalDiscount(new BigDecimal("0.00"));//agregar monto total de descuento
				salesDatail.add(salesPost);
			}
			
			venta.setSalesDatail(salesDatail);
			
			
			
			List<RegistroVenta> registroVenta= new ArrayList<>();
			registroVenta.add(venta);
			
			Gson gson = new Gson();
			String data = gson.toJson(registroVenta);
			System.out.println("ver json_: "+data);
			
			List<RptaRegistroVenta> registroVenta2=ventasRest.guardarVenta(registroVenta,beanDS);
			
			RptaRegistroVenta rpta= mapper.convertValue(registroVenta2.get(0), RptaRegistroVenta.class) ;
			
			if(null!=tipoComprobante && !tipoComprobante.equals("")) {
				if(tipoComprobante.equals("07") || tipoComprobante.equals("08")) {
					List<TNoteCredDebPost> lstTNoteCredDebPost = new ArrayList<TNoteCredDebPost>();
					TNoteCredDebPost note = new TNoteCredDebPost();
				     Long idVentaRef = new Long(jsonObj.get("idVentaRef").getAsString());
				     note.settBvoucOrigin(idVentaRef);
				     note.settBvoucDestiny(rpta.getIdVenta());
				     note.settCtypePurchaseSale(Constantes.tipoRegistro.VENTA.getCode());
				     lstTNoteCredDebPost.add(note);
					 List<TNoteCredDeb> lstTNoteCredDeb = ventasRest.postTNoteCredDeb(lstTNoteCredDebPost,beanDS);
					 TNoteCredDeb tNoteCredDeb= mapper.convertValue(lstTNoteCredDebPost.get(0),TNoteCredDebPost.class);
				}
			}
			
			TCatalogueDetGet filtrosTipDoc = new TCatalogueDetGet();
			filtrosTipDoc.setPaginacion(new PaginacionFiltro(1, 1));
			filtrosTipDoc.setCataBident(new Long(1));
			String tipCPE = jsonObj.get("tipoComprobante").getAsString();
			filtrosTipDoc.setCatdCident(tipCPE);
			TCatalogueDet infoCPE = new TCatalogueDet();
			PaginaResultado<TCatalogueDet> responseTipDoc = CataRest.getCatalogueDet(filtrosTipDoc,beanDS);
			if (responseTipDoc != null && responseTipDoc.getCantidad() > 0) {
				infoCPE = mapper.convertValue(responseTipDoc.getResultados().get(0), TCatalogueDet.class);
			}
			
			for (JsonElement jsonElement2 : arrayDetalleVenta) {
				String tipoVenta = jsonElement2.getAsJsonObject().get("tipoRegistro").getAsString();
				if (tipoVenta.equals("s")) {
					System.out.println("tipo servicio");
				} else {

					String codigo_nota_valida = jsonObj.get("codMotivoCre").getAsString();
					String period = jsonObj.get("periodo").getAsString();
					int periodoInt = Integer.parseInt(period);
					if (periodoInt < 10) {
						period = "0" + period;
					}

					if (!tipoComprobante.equals("08")) { // NOTA DE DEBITO
						if (validaIngresoInventory.equals("1")) {// ES PRODUCTO
							if (codigo_nota_valida.equals("04") || codigo_nota_valida.equals("05")) {
								System.out.println("ES UNA NOTA CON DESCUENTO");//
							} else {
								
							}
						}
					}
				}
			}
			//inicio crear el pdf
			// se movio al micro!!!!!!! 
			//fin crear el pdf
			try {
				List<RegistroVenta> lstAux= new ArrayList<>();
				RegistroVenta aux=venta;
				aux.getSales().setSaleBident(rpta.getIdVenta());
				List<RptaOperPDF>rPDFs = ventasRest.generarPDFs(registroVenta,beanDS);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			/*TVoucherFilterGet filtro = new TVoucherFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(1,1));
			filtro.setNroDoc(rpta.getSerieCPE()+"-"+rpta.getNroCPE());
			PaginaResultado<TVoucherFilter> response = voucherrest.getVoucherFilter(filtro,beanDS);
			
			TVoucherFilter vistaCompro= new TVoucherFilter();
			if(response!=null && response.getCantidad()>0) {
				vistaCompro = mapper.convertValue(response.getResultados().get(0),TVoucherFilter.class);
			}*/
			
			robject.addProperty("msg", "ok");
			robject.addProperty("nroC", rpta.getNroCPE());
			robject.addProperty("serieC", rpta.getSerieCPE());
			robject.addProperty("voucEstadoSunat",
					rpta.getCodRptaSunat() != null
							? rpta.getCodRptaSunat()
							: "");
			
			
			if(rpta.getCodRptaSunat() != null && !Constantes.RPTA_PROCESO_SUNAT.OK_SUNAT.getCode().equals(rpta.getCodRptaSunat())) {
				robject.addProperty("msg", "errorS");
				//traer el mensaje de error
				String msjErrorSunat="";
				String codeError=rpta.getCodRptaSunat();
				System.out.println("Codigo de Error: "+codeError);
				logger.info("Codigo de Error: "+codeError);
				if(codeError.equals("-1")) {
					codeError="X";
					msjErrorSunat="Fallo la Conexion con Sunat";
				}else {
					try {
						TCatalogueDetGet cataErrorSunat = new TCatalogueDetGet();
						cataErrorSunat.setPaginacion(new PaginacionFiltro(1, 1));
						cataErrorSunat.setCataBident(new Long(54));
						cataErrorSunat.setCatdCident(codeError.trim());
						cataErrorSunat.setCatdBstate(true);
						PaginaResultado<TCatalogueDet> responsescatmoneda = CataRest.getCatalogueDet(cataErrorSunat,beanDS);
						TCatalogueDet procatamoneda = new TCatalogueDet();
						for (Object catdetmoneda : responsescatmoneda.getResultados()) {
							procatamoneda = mapper.convertValue(catdetmoneda, TCatalogueDet.class);
							msjErrorSunat=procatamoneda.getCatdVdescription();
						}
					}catch(Exception e) {
						
					}
				}
				
				robject.addProperty("msgErrorSunat", codeError+" : "+(msjErrorSunat.equals("")?"Revisar Venta":msjErrorSunat));
			}
			
			robject.addProperty("idVenta", rpta.getIdVenta());
//			}
			return new Gson().toJson(robject);
			
		} catch (Exception e) {
			e.printStackTrace();
			robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}

 	@RequestMapping(value = "/exploradorventa")
	public ModelAndView listContactGrillaventa(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		model.setViewName("/Venta/VistaExploradorVenta");
		String NombreVentana="Explorador de Ventas";
		model.addObject("NombreVentana", NombreVentana);
		// validar sesion
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
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			 ObjectMapper mapper = new ObjectMapper();
			/*********************************************************************************************************/
			/*---------------------------     LISTA SUCURSALES POR USUARIO ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando estado de sucursales por usuario");
			TOfficeUserxSucursalGet filtrosofficexuser = new TOfficeUserxSucursalGet();
			filtrosofficexuser.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosofficexuser.setUserVuser(user.getUserVuser());			
			PaginaResultado<TOfficeUserxSucursal> responseOffiUser = BussinesRest.getOfficeUserxSucursal(filtrosofficexuser, beanDS);
			TOfficeUserxSucursal procataofficeuser = new TOfficeUserxSucursal();
			List<TOfficeUserxSucursal> lstCatDocofficeuser = new ArrayList<>();
			for (Object catdetofficeuser : responseOffiUser.getResultados()) {
				procataofficeuser = mapper.convertValue(catdetofficeuser, TOfficeUserxSucursal.class);
				lstCatDocofficeuser.add(procataofficeuser);
			}

			model.addObject("listaSucursal", lstCatDocofficeuser);
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
			/*---------------------------     LISTA PERIODO----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar periodo de catalogue");
			TCatalogueDetGet filtroscataPeri= new TCatalogueDetGet();
			filtroscataPeri.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscataPeri.setCataBident(new Long(19));
			filtroscataPeri.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatperiodo = CataRest.getCatalogueDet(filtroscataPeri,beanDS);
			TCatalogueDet procataperiodo = new TCatalogueDet();
			List<TCatalogueDet> lstCatPeriodo = new ArrayList<>();
			for (Object catdetperiodo : responsescatperiodo.getResultados()) {
				procataperiodo = mapper.convertValue(catdetperiodo, TCatalogueDet.class);
				lstCatPeriodo.add(procataperiodo);
			}
			model.addObject("lstCatPeriodo", lstCatPeriodo);
			/*********************************************************************************************************/
			/*---------------------------     LISTA ESTADO DE VENTA----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar estado de venta catalogue");
			TCatalogueDetGet filtroscaestadotventa= new TCatalogueDetGet();
			filtroscaestadotventa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscaestadotventa.setCataBident(new Long(26));
			filtroscaestadotventa.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatestadoventa = CataRest.getCatalogueDet(filtroscaestadotventa,beanDS);
			TCatalogueDet procataestadoventa = new TCatalogueDet();
			List<TCatalogueDet> lstCatEstadoVenta = new ArrayList<>();
			for (Object catdetestadoventa : responsescatestadoventa.getResultados()) {
				procataestadoventa = mapper.convertValue(catdetestadoventa, TCatalogueDet.class);
				lstCatEstadoVenta.add(procataestadoventa);
			}
			model.addObject("lstCatEstadoVenta", lstCatEstadoVenta);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
 	
 	@RequestMapping(value = "/lista_ventas", method = RequestMethod.POST)
    @ResponseBody
    public String getlistaVentas(HttpServletRequest rq, HttpSession ses,
   		@RequestParam(value = "frmCPFiltrosTipo", required = false) String frmCPFiltrosTipo,
   		@RequestParam(value = "frmCPEFiltrosNro", required = false) String frmCPEFiltrosNro,
		@RequestParam(value = "frmCPEFiltrosRUC", required = false) String frmCPEFiltrosRUC,
		@RequestParam(value = "frmCPEFiltrosRazSoc", required = false) String frmCPEFiltrosRazSoc,
		@RequestParam(value = "frmCPEFiltrosMontoTotal", required = false) String frmCPEFiltrosMontoTotal,
		@RequestParam(value = "listaCatDetPeriod", required = false) String listaCatDetPeriod,
		@RequestParam(value = "frmCPEFiltrosfecIniFecFinexplorador", required = false) String frmCPEFiltrosfecIniFecFinexplorador,
		@RequestParam(value = "frmCPEFiltrosSre", required = false) String frmCPEFiltrosSre,
		@RequestParam(value = "listaAnulado", required = false) String listaAnulado,
		@RequestParam(value = "listaMoneda", required = false) String listaMoneda
    		) {
        System.out.println("===========Inicio-> RegistroVentas/lista_ventas ");

        String sStart = rq.getParameter("draw");
        ObjectMapper mapper = new ObjectMapper();
        try {
        	BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
        	
        	TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
//        	TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
            String cantidad = rq.getParameter("length");  
            String sEcho = rq.getParameter("start");
            int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

           System.out.println("sale "+user.getUserVuser());
            TSalesFilterGet filtroLP = new TSalesFilterGet();
            filtroLP.setPaginacion(new PaginacionFiltro(page,Integer.parseInt(cantidad)));
            filtroLP.setUser_vuser(user.getUserVuser());
			
//            if(tEmployee!=null) {  
//            	filtroLP.setBusiBident(tEmployee.getBusiBident());
//            }
            if(frmCPFiltrosTipo!=null && !frmCPFiltrosTipo.isEmpty()) {
        	filtroLP.setVtipdocvoucher(frmCPFiltrosTipo);
            }
            if(frmCPEFiltrosNro!=null && !frmCPEFiltrosNro.isEmpty()) {
            filtroLP.setVnumbervoucher(frmCPEFiltrosNro);
            }
            if(frmCPEFiltrosRUC!=null && !frmCPEFiltrosRUC.isEmpty()) {
                filtroLP.setBnumber_doc_clie(frmCPEFiltrosRUC);
                }
            if(frmCPEFiltrosRazSoc!=null && !frmCPEFiltrosRazSoc.isEmpty()) {
                filtroLP.setVbusiname_clie(frmCPEFiltrosRazSoc);
                }
//            if(frmCPEFiltrosMontoTotal!=null && !frmCPEFiltrosMontoTotal.isEmpty()) {
//                filtroLP.setDresult_total(new BigDecimal(frmCPEFiltrosMontoTotal));
//                }
            
            if(listaCatDetPeriod!=null && !listaCatDetPeriod.isEmpty()) {
                filtroLP.setVperiod(listaCatDetPeriod);
                }
            if(frmCPEFiltrosSre!=null && !frmCPEFiltrosSre.isEmpty()) {
                filtroLP.setVserievoucher(frmCPEFiltrosSre);
                }
            if(listaAnulado!=null && !listaAnulado.isEmpty()) {
            	filtroLP.setSaleCstate(listaAnulado);
                }
            if(listaMoneda!=null && !listaMoneda.isEmpty()) {
                filtroLP.setVname_coin(listaMoneda);
                }
            
            if (frmCPEFiltrosfecIniFecFinexplorador != null && !frmCPEFiltrosfecIniFecFinexplorador.isEmpty()) {
				 String fechas[] = frmCPEFiltrosfecIniFecFinexplorador.split("-");
				 Date fechaEmisionIni = Util.StringtoDateFrom(fechas[0].trim());
				 Date fechaEmisionFin = Util.StringtoDateFrom(fechas[1].trim());
				 filtroLP.setFechaEmisionIni(fechaEmisionIni);
				 filtroLP.setFechaEmisionFin(fechaEmisionFin);
			}    
            
	            PaginaResultado<TSalesFilter> response = ventasRest.getSaleFilter(filtroLP,beanDS);

	            List<TSalesFilter> LstdoUser = null;
            if(response.getCantidad()>0){
            	LstdoUser = response.getResultados();
            }
            List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
            HashMap<String, Object> obj = null;

            if(LstdoUser!=null){
            for (Object objs: LstdoUser) {
            	TSalesFilter vistaUser = mapper.convertValue(objs, TSalesFilter.class);
            	obj = new HashMap<String, Object>();
            	obj.put("vcodReg",ObjectUtils.defaultIfNull(vistaUser.getCodigo_vregistro(), ""));
                obj.put("vperiod",ObjectUtils.defaultIfNull(vistaUser.getVperiod(), ""));
                obj.put("sdetTmovementDate",ObjectUtils.defaultIfNull(Util.datetoString5(vistaUser.getSdetTmovementDate()), ""));
                obj.put("vtipdocvoucher",ObjectUtils.defaultIfNull(vistaUser.getVtipdocvoucher(), ""));
                obj.put("vOfficePlace",ObjectUtils.defaultIfNull(vistaUser.getvOfficePlace(), ""));
                obj.put("vserievoucher",ObjectUtils.defaultIfNull(vistaUser.getVserievoucher(), ""));
                obj.put("vnumbervoucher",ObjectUtils.defaultIfNull(vistaUser.getVnumbervoucher(), ""));
                obj.put("vtype_doc_clie",ObjectUtils.defaultIfNull(vistaUser.getVtype_doc_clie(), ""));
                obj.put("bnumber_doc_clie",ObjectUtils.defaultIfNull(vistaUser.getBnumber_doc_clie(), ""));
                obj.put("vbusiname_clie",ObjectUtils.defaultIfNull(vistaUser.getVbusiname_clie(), ""));
                obj.put("vtype_doc_seller",ObjectUtils.defaultIfNull(vistaUser.getVtype_doc_seller(), ""));
                obj.put("bnumber_doc_seller",ObjectUtils.defaultIfNull(vistaUser.getBnumber_doc_seller(), ""));
                obj.put("vbusiname_seller",ObjectUtils.defaultIfNull(vistaUser.getVbusiname_seller(), ""));
                obj.put("sdetTregistrationDate",ObjectUtils.defaultIfNull(vistaUser.getSdetTregistrationDate(), ""));
                obj.put("vwaypay_name",ObjectUtils.defaultIfNull(vistaUser.getVwaypay_name(), ""));
                obj.put("sdetTexpiryDate",ObjectUtils.defaultIfNull(vistaUser.getSdetTexpiryDate(), ""));
                obj.put("sdetTPaymentDate",ObjectUtils.defaultIfNull(vistaUser.getSdetPaymentDate(), ""));
                obj.put("vname_coin",ObjectUtils.defaultIfNull(vistaUser.getVname_coin(), ""));
                obj.put("dexchange_rate",ObjectUtils.defaultIfNull(vistaUser.getDexchange_rate(), ""));
                obj.put("dresult_grav",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_grav()), ""));
                obj.put("dresult_inf",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_inf()), ""));
                obj.put("dresult_exo",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_exo()), ""));
                obj.put("dresult_exporta",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_exporta()), ""));
                obj.put("dresult_neto",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_neto()), ""));
                obj.put("dresult_igv",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_igv()), ""));
                obj.put("dresult_discountglobal", ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_discountglobal()), ""));
                obj.put("dresult_total",ObjectUtils.defaultIfNull(Util.formatMoney(vistaUser.getDresult_total()), ""));
                obj.put("sale_tdoc_referece_date",ObjectUtils.defaultIfNull(vistaUser.getSaleTdocRefereceDate(), ""));
                obj.put("sale_vcod_tip_referece",ObjectUtils.defaultIfNull(vistaUser.getSaleVcodTipReferece(), ""));
                obj.put("sale_vserie_doc_referece",ObjectUtils.defaultIfNull(vistaUser.getSaleVserieDocReferece(), ""));
                obj.put("sale_vnum_doc_referece",ObjectUtils.defaultIfNull(vistaUser.getSaleVnumDocReferece(), ""));
                obj.put("dresult_affair",ObjectUtils.defaultIfNull(vistaUser.getDresult_affair(), ""));
                obj.put("dresult_titlegratuito",ObjectUtils.defaultIfNull(vistaUser.getDresult_titlegratuito(), ""));
                obj.put("busiBident",ObjectUtils.defaultIfNull(vistaUser.getBusiBident(), ""));
                obj.put("SaleVguide",ObjectUtils.defaultIfNull(vistaUser.getSaleVguide(), ""));
                obj.put("SaleVorderpurchase",ObjectUtils.defaultIfNull(vistaUser.getSaleVorderpurchase(), ""));
                obj.put("saleCstate",ObjectUtils.defaultIfNull(vistaUser.getSaleCstate(), ""));
                obj.put("clieBident",ObjectUtils.defaultIfNull(vistaUser.getClieBident(), ""));
                obj.put("persBident",ObjectUtils.defaultIfNull(vistaUser.getPersBident(), ""));
                obj.put("saleBident",ObjectUtils.defaultIfNull(vistaUser.getSaleBident(), ""));
                obj.put("voucPdf",ObjectUtils.defaultIfNull(vistaUser.getSale_url_pdf(), ""));
                obj.put("voucEnvioSunat", ObjectUtils.defaultIfNull(vistaUser.getVouc_estado_cdr(), ""));
                obj.put("voucEstadoSunat",
                		vistaUser.getVouc_estado_cdr() != null
								? (vistaUser.getVouc_estado_cdr().equals("0") ? "1" : "0")
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
        }catch (HttpClientErrorException e) {
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
 	
	
	@RequestMapping(value = "/MostrarDetalle", method = RequestMethod.POST)
	@ResponseBody
	public String MostrarDetalle( HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codDet", required = true) String codDet) throws IOException {
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		ObjectMapper mapper = new ObjectMapper();
	    String sStart = rq.getParameter("draw");
		System.out.println("===========Inicio-> registroventa/MostrarDetalle ");
		
		String idVar = "";
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		try {
	
			System.out.println("Codigo de Salida "+codDet);
			if(null==codDet || "".equals(codDet)) {
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "inserta");
				return new Gson().toJson(robject);
			}else {
				System.out.println("Codigo de Salida1 "+codDet);
				TSalesFilterGet filtroD = new TSalesFilterGet();
				filtroD.setPaginacion(new PaginacionFiltro(1, 1));
			filtroD.setSaleBident(new Long(codDet)); 
			System.out.println("Codigo de Salida "+codDet);
			PaginaResultado<TSalesFilter> responseService = ventasRest.getSaleFilter(filtroD,beanDS);
			TSalesFilter salesfilter = new TSalesFilter();
			if (responseService != null && responseService.getCantidad() > 0) {
				salesfilter = mapper.convertValue(responseService.getResultados().get(0), TSalesFilter.class);
			}	
				/*********************************************************************************************************/
				/*----------------------------------------   LISTA DETALLE  ----------------------------------------------*/
				/*********************************************************************************************************/
				
//				List<HashMap<String, Object>> objListaDetalle = new ArrayList<HashMap<String, Object>>();
				TSalesDetailFilterGet filtroLP = new TSalesDetailFilterGet();
				filtroLP.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				filtroLP.setSaleBident(salesfilter.getSaleBident());
				PaginaResultado<TSalesDetailFilter> response = ventasRest.getSaleDetalleFilter(filtroLP,beanDS);
				List<TSalesDetailFilter> LstdoPrice = null;
				if (response.getCantidad() > 0) {
					LstdoPrice = response.getResultados();
				}
				List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
				mapper = new ObjectMapper();
				HashMap<String, Object> obj = null;
			    
				if (LstdoPrice != null) {
					
					for (Object objs : LstdoPrice) {
						TSalesDetailFilter vistaUser = mapper.convertValue(objs, TSalesDetailFilter.class);
	
						obj = new HashMap<String, Object>();
						obj.put("sel", "");
						obj.put("numero",ObjectUtils.defaultIfNull(vistaUser.getSdetBnumber(), ""));
						if (null!=vistaUser.getProdBident() && !Long.toString(vistaUser.getProdBident()).equals("")) {
							obj.put("codigo",ObjectUtils.defaultIfNull(vistaUser.getProdBident(), ""));
						} else {
							obj.put("codigo",ObjectUtils.defaultIfNull(vistaUser.getServBident(), ""));
						}
						obj.put("claseSunat",ObjectUtils.defaultIfNull(vistaUser.getSdetVclassSunat(), ""));
						obj.put("codigoAlmacen",ObjectUtils.defaultIfNull(vistaUser.getStoreBident(), ""));
		                obj.put("codigoComercial",ObjectUtils.defaultIfNull(vistaUser.getSdetvcommercialcode(), ""));
		                obj.put("nomcorto",ObjectUtils.defaultIfNull(vistaUser.getSdetvshortnameprod_serv(), ""));
		                obj.put("Descripcion",ObjectUtils.defaultIfNull(vistaUser.getSdetvdescripprod_serv(), ""));
		                obj.put("concepto",ObjectUtils.defaultIfNull(vistaUser.getSdetvconcept(), ""));
		                obj.put("UnidadMedida",ObjectUtils.defaultIfNull(vistaUser.getSdetvvmeassure_unity(), ""));
		                obj.put("cantidad",ObjectUtils.defaultIfNull(vistaUser.getSdetdquantity(), ""));
		                obj.put("incluyeIgv",ObjectUtils.defaultIfNull(vistaUser.getSdetBincludeIgv(), ""));
		                obj.put("valorUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesunit(), ""));
		                obj.put("igvUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdigvunit(), ""));
		                obj.put("precioUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdpriceunit(), ""));
		                obj.put("valorVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesale(), ""));
		                obj.put("igvVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesale(), ""));
		                obj.put("porcentaDesc",ObjectUtils.defaultIfNull(vistaUser.getSdetddescporcentage(), ""));
		                obj.put("importeDesc",ObjectUtils.defaultIfNull(vistaUser.getSdetddescimport(), ""));
		                obj.put("precValorVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountvaluepric(), ""));
		                obj.put("precIgvVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdnigvdescupric(), ""));
		                obj.put("precPrecioVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric(), ""));
		                obj.put("baseImporte",ObjectUtils.defaultIfNull(vistaUser.getSdetdtaxbase(), ""));
		                obj.put("igv",ObjectUtils.defaultIfNull(vistaUser.getSdetdigv(), ""));
		                obj.put("igvVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric().subtract(vistaUser.getSdetdiscountvaluepric()), ""));
		                obj.put("precioVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric(), ""));
		                obj.put("totalBruto",ObjectUtils.defaultIfNull(vistaUser.getSdetdgroostotal(), ""));
		                obj.put("totalNeto",ObjectUtils.defaultIfNull(vistaUser.getSdetdnettotal(), ""));
		                obj.put("indicadorAfecto",ObjectUtils.defaultIfNull(vistaUser.getSdetvaffindicator(), ""));
		                obj.put("tipoIndicadorAfecto",ObjectUtils.defaultIfNull(vistaUser.getSdetvtipaffecindicator(), ""));
		                obj.put("precDescripMoneda", ObjectUtils.defaultIfNull(vistaUser.getSdetvcoinorigin(), ""));
		                obj.put("tipoMonedaDestino",ObjectUtils.defaultIfNull(vistaUser.getSdetvcoincurrency(), ""));
		                obj.put("tipoCambioVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdmountexchange(), ""));
		                obj.put("tipoConversion",ObjectUtils.defaultIfNull(vistaUser.getSdetdcurrencyconvers(), ""));
		                obj.put("transferencia",ObjectUtils.defaultIfNull(vistaUser.getSdetVfreeTransfer(), ""));
		                obj.put("observacion",ObjectUtils.defaultIfNull(vistaUser.getSdetVobservation(), ""));
		                obj.put("saleBident",ObjectUtils.defaultIfNull(vistaUser.getSaleBident(), ""));
		                obj.put("detailBident",ObjectUtils.defaultIfNull(vistaUser.getDetailBident(), ""));
		                obj.put("prodBident",ObjectUtils.defaultIfNull(vistaUser.getProdBident(),vistaUser.getServBident()));
		                obj.put("preciodescripcionproducto",ObjectUtils.defaultIfNull("", ""));
		                obj.put("esprecioprincipal",ObjectUtils.defaultIfNull("", ""));
		                obj.put("nombremarca",ObjectUtils.defaultIfNull("", ""));
		                obj.put("nombrecortomarca",ObjectUtils.defaultIfNull("", ""));
		                obj.put("nombredescripcionmarca",ObjectUtils.defaultIfNull("", ""));
		                obj.put("preciodescripcion",ObjectUtils.defaultIfNull("", ""));
		                obj.put("tipoRegistro","");
		                obj.put("precioInicial",ObjectUtils.defaultIfNull(vistaUser.getSdetdpriceunit(), ""));
		                if (vistaUser.getSdetdpriceunit() !=  new BigDecimal(0)) {
		                	obj.put("precioDescuento", true);
						} else {
							obj.put("precioDescuento", false);
						}

						objLista.add(obj);
						idVar = (vistaUser.getSdetBnumber()).toString();
						System.out.println("ultimo nro"+idVar);
						System.out.println("lista "+objLista);
					}
				}

				
				Gson gson = new Gson();
				String data = gson.toJson(objLista);
				JsonObject robject = new JsonObject();
				JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
				robject.addProperty("msg", "ok");
				robject.addProperty("lista", data);
				robject.addProperty("draw", sStart);
		        robject.addProperty("recordsTotal", response.getCantidad());
		        robject.addProperty("recordsFiltered", response.getCantidad());
		        robject.add("data", jsonArray);
		        robject.add("datadetalle", jsonArray);

				return new Gson().toJson(robject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return null;
		}

	}


	@RequestMapping(value = "/EditarVenta", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView EditarVenta(ModelAndView model,
			HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "codDet", required = true) String codDet
			) throws IOException {
		
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
//		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		if(user==null) {model.setViewName("/homepost"); return model;}
		String NombreVentana="Editar Venta";
		model.addObject("NombreVentana", NombreVentana);
        System.out.println("===========Inicio-> Editar Venta ");
        model.setViewName("/Venta/RegistroVenta");
		try {
			
			model.addObject("dataVentas", "v");
			
			
			ObjectMapper mapper = new ObjectMapper();
			
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			
		    TSalesGet filtroV = new TSalesGet();
			filtroV.setPaginacion(new PaginacionFiltro(1, 1));
			filtroV.setSaleBident(new Long(codDet));
			filtroV.setSaleCstate("0");
			PaginaResultado<TSales> responseV = ventasRest.getSale(filtroV,beanDS);
			TSales saleditar= new TSales();
			if(responseV!=null && responseV.getCantidad()>0) {
				saleditar = mapper.convertValue(responseV.getResultados().get(0), TSales.class);
				model.addObject("VentaSerie", saleditar.getSaleVserieVoucher());
				model.addObject("VentaNroDoc", saleditar.getSaleVnumberVoucher());
				model.addObject("RazCliente", saleditar.getSaleVbusinameClient());
				model.addObject("DireccionCliente", saleditar.getSaleVaddressClient());
				model.addObject("RazVendedor", saleditar.getSaleVbusinameSeller());
				model.addObject("ObsCabecera", saleditar.getSaleVaffair());
				model.addObject("ResultadoINF", saleditar.getSaleDunaffected());
				model.addObject("ResultadoEXONERADO", saleditar.getSaleDexonerated());
				model.addObject("ResultadoGRATUITA", saleditar.getSaleDfreeAmount());
				model.addObject("ResultadoBIM", saleditar.getSaleDtaxedBim());
				model.addObject("ResultadoEXPORTACION", saleditar.getSaleDexport());
				model.addObject("ResultadoValorNeto", saleditar.getSaleDvaluetotal());
				model.addObject("ResultadoNETO", saleditar.getSaleDnet());
				model.addObject("ResultadoIGV", saleditar.getSaleDigv());
				model.addObject("ResultadoDSCTO", saleditar.getSaleDdiscount());
				model.addObject("ResultadoTOTAL", saleditar.getSaleDtotal());
				model.addObject("ResultadoCONVERS", saleditar.getSaleDconversion());
				model.addObject("ResultadoSON", saleditar.getSaleVtotalAmountLetters());
				model.addObject("idcodVenta", saleditar.getSaleBident());
				model.addObject("fechaderegistro", Util.datetoString(saleditar.getSaleTregistrationDate()));
				model.addObject("fechademovimiento", Util.datetoString4(saleditar.getSaleTmovementDate()));
				model.addObject("fechadevencimiento", Util.datetoString4(saleditar.getSaleTdateExpiry()));
				model.addObject("fechadepago", Util.datetoString(saleditar.getSaleTpaymentDate()));
				model.addObject("editar",saleditar.getSaleBident());
				model.addObject("cliente", saleditar.getClieBident());	
				model.addObject("vendedor", saleditar.getEmplBident());	
				model.addObject("formadepago", saleditar.getWaypayBident());	
				model.addObject("tipCambio", saleditar.getSaleTexchangeRate());	
				model.addObject("tipCambioident", saleditar.getTypeBident());	
				model.addObject("periodo", saleditar.getSaleVperiod());	
				model.addObject("sucursal", saleditar.getOfficeBident());	
				model.addObject("tipdoc", saleditar.getSaleVtypeVoucher());	
				model.addObject("moneda", saleditar.getCoinBident());	
				model.addObject("indicador", saleditar.getSaleVindicatorAfecto());	
				model.addObject("indicadortipo", saleditar.getSaleVtypeIndicatorAfecto());	
				model.addObject("pdf", saleditar.getSaleUrlPdf());	
			}
			
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO MONEDA ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar monedas de catalogue");
			TCatalogueDetGet filtroscatalogomoneda = new TCatalogueDetGet();
			filtroscatalogomoneda.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogomoneda.setCataBident(new Long(2));
			PaginaResultado<TCatalogueDet> responsescatmoneda = CataRest.getCatalogueDet(filtroscatalogomoneda,beanDS);
			TCatalogueDet procatamoneda = new TCatalogueDet();
			List<TCatalogueDet> lstCatDocMoneda = new ArrayList<>();
			for (Object catdetmoneda : responsescatmoneda.getResultados()) {
				procatamoneda = mapper.convertValue(catdetmoneda, TCatalogueDet.class);
				lstCatDocMoneda.add(procatamoneda);
			}
			model.addObject("listaCatDetMoneda", lstCatDocMoneda);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO FORMA DE PAGO------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando forma de pago");
			TCatalogueDetGet filtroscatalogoformadepa = new TCatalogueDetGet();
			filtroscatalogoformadepa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoformadepa.setCataBident(new Long(21));
			PaginaResultado<TCatalogueDet> responsescatformadepa = CataRest.getCatalogueDet(filtroscatalogoformadepa,beanDS);
			TCatalogueDet procataformadepa = new TCatalogueDet();
			List<TCatalogueDet> lstCatDocformadepa = new ArrayList<>();
			for (Object catdetformadepa : responsescatformadepa.getResultados()) {
				procataformadepa = mapper.convertValue(catdetformadepa, TCatalogueDet.class);
				lstCatDocformadepa.add(procataformadepa);
			}
			model.addObject("listaCatDetFormadepa", lstCatDocformadepa);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO SUCURSAL ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando sucursales");
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(1));
			// filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responsescat = CataRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet procata = new TCatalogueDet();
			List<TCatalogueDet> lstCatDoc = new ArrayList<>();
			for (Object catdet : responsescat.getResultados()) {
				procata = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatDoc.add(procata);
			}
			model.addObject("listaCatDetComp", lstCatDoc);
 			/*********************************************************************************************************/
			/*---------------------------     LISTA DOCUMENTO Cliente ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando clientes");
			TClientEndFilterPersonGet filtroCLP = new TClientEndFilterPersonGet();
			filtroCLP.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCLP.setEstado("1");
			filtroCLP.setPersVdoctype("1");
//			filtroCLP.setBusiBident(tEmployee.getBusiBident());
			TClientEndFilterPerson prouser = new TClientEndFilterPerson();
			PaginaResultado<TClientEndFilterPerson> response = clientendRest.getClientEndFilterRest(filtroCLP,beanDS);
			List<TClientEndFilterPerson> lstUser = new ArrayList<TClientEndFilterPerson>();
			for (Object catdetuser : response.getResultados()) {
				prouser = mapper.convertValue(catdetuser, TClientEndFilterPerson.class);
				lstUser.add(prouser);
			}
			model.addObject("filtrarClienteNroC", lstUser);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE PERIODO  ------------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listando periodos");
			TCatalogueDetGet filtroscatalogoperiodos = new TCatalogueDetGet();
			filtroscatalogoperiodos.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoperiodos.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescatperiod = CataRest.getCatalogueDet(filtroscatalogoperiodos,beanDS);
			TCatalogueDet procataperiodo = new TCatalogueDet();
			List<TCatalogueDet> lstCatPeriodo = new ArrayList<>();
			List<ListaDesplegable> lstOpciones = new ArrayList<>();
			
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH)+1;
			
			for (Object catdetperiod : responsescatperiod.getResultados()) {
				procataperiodo = mapper.convertValue(catdetperiod, TCatalogueDet.class);
				
				ListaDesplegable bean= new ListaDesplegable();
				bean.setOpcion(procataperiodo);
				if(month==Integer.parseInt(procataperiodo.getCatdCident())) {
					bean.setEstado(true);
				}else {
					bean.setEstado(false);
				}
				lstOpciones.add(bean);
				
				lstCatPeriodo.add(procataperiodo);
			}
			//model.addObject("listaCatDetPeriod", lstCatPeriodo);
			model.addObject("listaCatDetPeriod", lstOpciones);
						
			
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE I.A Y T.I.A ------------------------------------------------*/
			/*********************************************************************************************************/
			
			
			logger.info("Listando tipo de indicador afecto");
			TCatalogueDetGet filtroscatalogoindicador = new TCatalogueDetGet();
			filtroscatalogoindicador.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoindicador.setCataBident(new Long(8));

			PaginaResultado<TCatalogueDet> responsescatindicador = CataRest.getCatalogueDet(filtroscatalogoindicador,beanDS);
			TCatalogueDet procataindicador = new TCatalogueDet();
			List<TCatalogueDet> lstCatIndicador = new ArrayList<>();
			for (Object catdetindicador : responsescatindicador.getResultados()) {
				procataindicador = mapper.convertValue(catdetindicador, TCatalogueDet.class);
				lstCatIndicador.add(procataindicador);
			}
			model.addObject("listaCatDetIndicador", lstCatIndicador);


			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE PAISES	  -----------------------------------------------*/
			/*********************************************************************************************************/
			TCountryGet filtrosPais = new TCountryGet();
			filtrosPais.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TCountry> responsePais = CataRest.getCountry(filtrosPais,beanDS);
			TCountry proPais = new TCountry();
			List<TCountry> lstPais = new ArrayList<>();
			for (Object catPais : responsePais.getResultados()) {
				proPais = mapper.convertValue(catPais, TCountry.class);
				lstPais.add(proPais);
			}
			model.addObject("listaPais", lstPais);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE TIPOS DE DOCUMENTO	  -----------------------------------*/
			/*********************************************************************************************************/
			TCatalogueDetGet filtrosTipDoc = new TCatalogueDetGet();
			filtrosTipDoc.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosTipDoc.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responseTipDoc = CataRest.getCatalogueDet(filtrosTipDoc,beanDS);
			TCatalogueDet proTipDoc = new TCatalogueDet();
			List<TCatalogueDet> lstCatTipDoc = new ArrayList<>();
			for (Object catdet : responseTipDoc.getResultados()) {
				proTipDoc = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatTipDoc.add(proTipDoc);
			}
			model.addObject("listaCatDet", lstCatTipDoc);
			/*********************************************************************************************************/
			/*---------------------------     LISTA DE DEPARTAMENTO ----------------------------------------------*/
			/*********************************************************************************************************/
			
			TUbigeoGet filtrosUbigeo = new TUbigeoGet();
			filtrosUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> responseUbigeo = CataRest.getUbigeo(filtrosUbigeo,beanDS);
			TUbigeo proUbigeo = new TUbigeo();
			List<TUbigeo> lstUbigeo = new ArrayList<>();
			for (Object catUbigeo : responseUbigeo.getResultados()) {
				proUbigeo = mapper.convertValue(catUbigeo, TUbigeo.class);
				lstUbigeo.add(proUbigeo);
			}
			model.addObject("listUbigeos", lstUbigeo);
			/*********************************************************************************************************/
			/*--------------------------------     LISTA DE ANIO EJERCICIO  -----------------------------------------*/
			/*********************************************************************************************************/
			
			Date dateAnio= new Date();
			Calendar calAnio = Calendar.getInstance();
			calAnio.setTime(dateAnio);
			
			int year = calAnio.get(Calendar.YEAR);
			int yearPost = year + 5;
			int yearPre = year - 5;
			
			List<ListaDesplegable> lstOpcionesAnio = new ArrayList<>();
			for (int i = yearPost; i >= yearPre; i--) {
				ListaDesplegable bean= new ListaDesplegable();
				String anio = Integer.toString(i);
				bean.setOpcAnio(anio);
				if(i==year) {
					bean.setEstado(true);
				}else {
					bean.setEstado(false);
				}
				lstOpcionesAnio.add(bean);
				
			}
			model.addObject("listaAnio", lstOpcionesAnio);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	    @RequestMapping(value = "/ActualizarVenta", method = RequestMethod.POST)
	    @ResponseBody
	    public String ActualizarVenta(HttpSession ses, HttpServletRequest rq,  			
			@RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
//		TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		String razonSocial = null,ubigeo=null,nombreComercial=null,direcEmpresa=null,rucEmpresa=null,tipoDocEmpr=null;
		try {
			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA VENTA       --------------------------------------------*/
			/*********************************************************************************************************/
			
			System.out.println("entro");
			
			JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
			Long codigoVenta=jsonObj.get("idVenta").getAsLong();
			TSalesFilterGet filtro = new TSalesFilterGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setSaleBident(codigoVenta);
			System.out.println("este "+codigoVenta); 
			PaginaResultado<TSalesFilter> responseServicio = ventasRest.getSaleFilter(filtro,beanDS);
			TSalesFilter servicio = new TSalesFilter();
			if (responseServicio != null && responseServicio.getCantidad() > 0) {
				servicio = mapper.convertValue(responseServicio.getResultados().get(0), TSalesFilter.class);
			}
			List<TSalesPut> lstTServicePut = new ArrayList<TSalesPut>();
			TSalesPut TServicesput = new TSalesPut();
			BeanUtils.copyProperties(servicio, TServicesput);
			Long idEmployee = new Long(jsonObj.get("idVendedor").getAsString());
			TServicesput.setEmplBident(idEmployee);	
			TServicesput.setCoinBident(jsonObj.get("moneda").getAsString());
			TServicesput.setSaleVperiod(jsonObj.get("periodo").getAsString());
			TServicesput.setOfficeBident(jsonObj.get("sucursal").getAsString());
			Long nrodias = new Long(jsonObj.get("dias").getAsString());
			TServicesput.setSaleBnumberDay(nrodias);
			TServicesput.setSaleBnumberDocClie(jsonObj.get("nroDocCliente").getAsString());			// cambiar por data real 
			TServicesput.setSaleBnumberDocSeller(jsonObj.get("nroDocVendedor").getAsString());			// cambiar por data real 
			TServicesput.setSaleBuserModify(user.getUserVuser());
			TServicesput.setSaleVserieVoucher(jsonObj.get("Serie").getAsString());
			TServicesput.setSaleVnumberVoucher(jsonObj.get("nroComprobante").getAsString());
		    TServicesput.setSaleTregistrationDate(Util.datetoString6(jsonObj.get("fechareg").getAsString()));
			TServicesput.setSaleTdateUpdate(new Date());
			TServicesput.setSaleBdocAdvance("");
			TServicesput.setSaleTdateExpiry(Util.datetoString6(jsonObj.get("fechavenc").getAsString()));
			TServicesput.setSaleTmovementDate(Util.datetoString6(jsonObj.get("fechamov").getAsString()));
			TServicesput.setSaleTpaymentDate(Util.datetoString6(jsonObj.get("fechapago").getAsString()));		
			TServicesput.setSaleVaddressClient(jsonObj.get("direccionCliente").getAsString());
			TServicesput.setSaleVaffair(jsonObj.get("observacion").getAsString());
			TServicesput.setClieBident(new Long(jsonObj.get("idCliente").getAsString()));
			TServicesput.setSaleVbusinameClient(jsonObj.get("nombreCliente").getAsString());
			TServicesput.setSaleVbusinameSeller(jsonObj.get("nombreVendedor").getAsString());
			TServicesput.setSaleVindicatorAfecto(jsonObj.get("indicador").getAsString());
			if(jsonObj.get("ventaTituloGratuito").getAsString().equals("true")) {
				TServicesput.setSaleVsaleTitleFree("1");
		}else {
			TServicesput.setSaleVsaleTitleFree("0");
		}	
		
		
			TServicesput.setSaleVtypeDocClie(jsonObj.get("tipoDocCliente").getAsString());
			TServicesput.setSaleVtypeDocSeller(jsonObj.get("tipoDocVendedor").getAsString());	 
		if("null".equals(jsonObj.get("tipoIndicador"))) {
			TServicesput.setSaleVtypeIndicatorAfecto(jsonObj.get("tipoIndicador").getAsString());
		}
		
		TServicesput.setSaleVtypeVoucher(jsonObj.get("tipoComprobante").getAsString());
		String tipoCambio = jsonObj.get("tipoCambio").isJsonNull() ? "":jsonObj.get("tipoCambio").getAsString();
			TServicesput.setTypeBident(jsonObj.get("tipoCambioBident").getAsLong());
	
			TServicesput.setSaleTexchangeRate(tipoCambio);

		TServicesput.setWaypayBident(jsonObj.get("formaPago").getAsString());
		

		//mtoledo
		//cliente
		String nombreVendedor=jsonObj.get("nombreVendedor").getAsString();
		String nroDocVendedor = jsonObj.get("nroDocVendedor").getAsString();
		String tipoDocVendedor= jsonObj.get("tipoDocVendedor").getAsString();
		String idVendedor = jsonObj.get("idVendedor").getAsString();
		
//		TServicesput.setEmplBident(tEmployee.getBusiBident());
		
		//obtener la empresa del vendedor		
		logger.info("Se procedera a calcular los montos para enviar!!!");
		String tipoIA=jsonObj.get("indicador").getAsString();
		String tipoTIA=jsonObj.get("indicador").getAsString();
		
		try {
			String gravada=Constantes.indicador_ia.GRAVADA.getCode();
			String exonerada=Constantes.indicador_ia.EXONERADO.getCode();
			String inafecta=Constantes.indicador_ia.INAFECTO.getCode();
			String exportacion=Constantes.indicador_ia.EXPORTACION.getCode();
			String gratuitas=Constantes.indicador_ia.GRATUITAS.getCode();
			
			if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_OPERACION_ONEROSA.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PREMIO.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_DONACION.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PUBLICIDAD.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_BONIFICACIONES.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposExonerada.EXONERADA_OPERACION_ONEROSA.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_BONIFICACION.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PREMIO.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
				
			}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PUBLICIDAD.getCode())) {
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//llenando los campos del importe		
//Tabla Venta Insert de Resultados
		TServicesput.setSaleDunaffected(jsonObj.get("inafecto").getAsBigDecimal());
		TServicesput.setSaleDtaxedBim(jsonObj.get("gravada").getAsBigDecimal());
		TServicesput.setSaleDexonerated(jsonObj.get("exonerada").getAsBigDecimal());
		TServicesput.setSaleDexport(jsonObj.get("exportacion").getAsBigDecimal());
		TServicesput.setSaleDfreeAmount(jsonObj.get("ventaGratuita").getAsBigDecimal());
		TServicesput.setSaleDvaluetotal(jsonObj.get("valortotal").getAsBigDecimal());
		TServicesput.setSaleDnet(jsonObj.get("neto").getAsBigDecimal());
        TServicesput.setSaleDigv(jsonObj.get("igv").getAsBigDecimal());
        TServicesput.setSaleDtotal(jsonObj.get("total").getAsBigDecimal());
        TServicesput.setSaleDconversion(jsonObj.get("conversion").getAsBigDecimal());
        TServicesput.setSaleDdiscount(jsonObj.get("impDescTot").getAsBigDecimal());
        TServicesput.setSaleCstate(Constantes.flagVentaEstado.ACTIVO.getCode());
//        TServicesput.setSaleVoperationRegisterNumber("");//ARREGLAR DESPUES
        TServicesput.setSaleVtotalAmountLetters(jsonObj.get("totalletras").getAsString());
        TServicesput.setSaleUrlPdf(jsonObj.get("pdf1").getAsString());
			
        lstTServicePut.add(TServicesput);
			ventasRest.putSales(lstTServicePut,beanDS);

			/*********************************************************************************************************/
			/*-----------------------------       ACTUALIZA PRECIO       --------------------------------------------*/
			/*********************************************************************************************************/
//			JsonArray arrayDetalleVenta = jsonObj.get("arrayRegistros").getAsJsonArray();
//			TSalesDetailFilterGet salesdetail = new TSalesDetailFilterGet();
//			salesdetail.setSaleBident(new Long(filtro.getSaleBident()));
//			List<TSaleDetailPost> salesDatail = new ArrayList<>();
//			System.out.println("moneda3");
//			for (JsonElement jsonElement : arrayDetalleVenta) {
//				System.out.println("moneda4");
//				TSaleDetailPost salesPost = new TSaleDetailPost();
//				Long nroprodserv = new Long(jsonElement.getAsJsonObject().get("numero").getAsString());
//				String UndMed = jsonElement.getAsJsonObject().get("UnidadMedida").getAsString();
//				System.out.println("moneda4.5 "+ UndMed);
//				String nomcortoprod =jsonElement.getAsJsonObject().get("nomcorto").getAsString();
//				System.out.println("moneda4.6 "+ nomcortoprod);
//				String Descripcionprodserv=jsonElement.getAsJsonObject().get("Descripcion").getAsString();
//				System.out.println("moneda4.7 "+ Descripcionprodserv);
//				System.out.println("moneda5");
//				if(UndMed!=null && UndMed.equals("ZZ")) {
//					System.out.println("moneda5.5");
//            	salesPost.setServBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
//            	salesPost.setSdetVshortnameServ(nomcortoprod);
//            	salesPost.setSdetVdescriptionServ(Descripcionprodserv);
//            }else {
//            	System.out.println("moneda6.1");
//            	salesPost.setProdBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
//            	System.out.println("moneda6.2");
//            	salesPost.setSdetVshortnameProd(nomcortoprod);
//            	System.out.println("moneda6.3");
//            	salesPost.setSdetVdescriptionProd(Descripcionprodserv);
//            	System.out.println("moneda6.5");
//            }
//				System.out.println("moneda6");
//				salesPost.setSdetBnumber(nroprodserv);
//				salesPost.setSdetVshortnameBrand(jsonElement.getAsJsonObject().get("nombrecortomarca").getAsString());
//				salesPost.setSdetVdescriptionBrand(jsonElement.getAsJsonObject().get("nombredescripcionmarca").getAsString());
//				salesPost.setSdetVnameBrand(jsonElement.getAsJsonObject().get("nombremarca").getAsString());
//				salesPost.setSdetVcommercialCode(jsonElement.getAsJsonObject().get("codigoComercial").getAsString());
//				salesPost.setSdetVconcept(jsonElement.getAsJsonObject().get("concepto").getAsString());
//				salesPost.setSdetBmainPrice(jsonElement.getAsJsonObject().get("esprecioprincipal").getAsBoolean());
//				salesPost.setSdetBigvIncludesPrice(jsonElement.getAsJsonObject().get("incluyeIgv").getAsBoolean());
//				salesPost.setSdetVcode(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
//				salesPost.setSdetVdescriptionCoinPrice(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
//				salesPost.setSdetVdescriptionPrice(jsonElement.getAsJsonObject().get("preciodescripcionproducto").getAsString());
//				salesPost.setSdetVmeassureUnity(jsonElement.getAsJsonObject().get("UnidadMedida").getAsString());
//				salesPost.setSdetDquantity(new BigDecimal(jsonElement.getAsJsonObject().get("cantidad").getAsString()));
//				salesPost.setSdetDunitValue(new BigDecimal(jsonElement.getAsJsonObject().get("valorUnitario").getAsString()));
//				salesPost.setSdetDigvUnit(new BigDecimal(jsonElement.getAsJsonObject().get("igvUnitario").getAsString()));
//				salesPost.setSdetDpriceUnit(new BigDecimal(jsonElement.getAsJsonObject().get("precioUnitario").getAsString()));
//				salesPost.setSdetDvalueSale(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
//				salesPost.setSdetDsaleValuePrice(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
//				salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("precDescripMoneda").getAsString());
//				salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
//				System.out.println("moneda7");
//				try {
//					BigDecimal porcDcto = new BigDecimal(jsonElement.getAsJsonObject().get("porcentaDesc").getAsString());
//					salesPost.setSdetDdescPorcentage(porcDcto);
//				}catch(Exception e) {
//					logger.error("Revisar los campos de porcentaje de dcto");
//					salesPost.setSdetDdescPorcentage(new BigDecimal("0.00"));
//				}
//				System.out.println("moneda8");
//				
//				salesPost.setSdetDdescImport(new BigDecimal(jsonElement.getAsJsonObject().get("importeDesc").getAsString()));
//				salesPost.setSdetDtaxBase(new BigDecimal(jsonElement.getAsJsonObject().get("baseImporte").getAsString()));
//				salesPost.setSdetBincludeIgv(true);
//				salesPost.setSdetDigv(new BigDecimal(jsonElement.getAsJsonObject().get("igv").getAsString()));
//				salesPost.setSdetDgrossTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalBruto").getAsString()));
//				salesPost.setSdetDnetTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalNeto").getAsString()));
//				salesPost.setSdetVaffectionIndicator(jsonElement.getAsJsonObject().get("indicadorAfecto").getAsString());
//				salesPost.setSdetVtypeAffectionIndicator(jsonElement.getAsJsonObject().get("tipoIndicadorAfecto").getAsString());
//				salesPost.setSdetVobservation(jsonElement.getAsJsonObject().get("observacion").getAsString());
//				salesPost.setSdetNdiscountValuePric(new BigDecimal(jsonElement.getAsJsonObject().get("precValorVentaDscto").getAsString()));
//				salesPost.setSdetNigvdescuPric(new BigDecimal(jsonElement.getAsJsonObject().get("precIgvVentaDscto").getAsString()));
//				salesPost.setSdetNdiscountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
//				salesPost.setSdetDdiscountAmountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
//				salesPost.setSdetTdateUpdate(new Date());//Cambiara en el Update de Ventas
//				salesPost.setSdetBuserModify(new Long(user.getPersBident()));//Cambiara para el Update de Ventas
//				System.out.println("moneda9");
//				try {
//					salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("tipoMonedaOrigen").getAsString());
//					salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
//				}catch(Exception e) {
//					logger.error("Ocurrio un error, al tipo moneda origen y/o destino");
//				}
//				try {
//					salesPost.setSdetDamountExchangeSales(new BigDecimal(jsonElement.getAsJsonObject().get("tipoCambioVenta").getAsString()));
//					salesPost.setSdetDcurrencyConversion(new BigDecimal(jsonElement.getAsJsonObject().get("tipoConversion").getAsString()));
//				}catch(Exception e) {
//					salesPost.setSdetDamountExchangeSales(new BigDecimal("0.00"));
//					salesPost.setSdetDcurrencyConversion(new BigDecimal("0.00"));
//				}
//				//salesPost.setSdetDtotalDiscount(new BigDecimal(jsonElement.getAsJsonObject().get("").getAsString()));//agregar monto total de descuento
//				salesPost.setSdetDtotalDiscount(new BigDecimal("0.00"));//agregar monto total de descuento
//				salesDatail.add(salesPost);
//				System.out.println("moneda 8");
//			}
		} catch (Exception ex) {
//			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	
	
	    public HashMap<String, Object> InsertGrillaIA(String indicadorAfecto, String monedaOrigen, String monedaDestino,
				String listaTipCambio, String cantidad, BigDecimal porcDescuento, BigDecimal valorUnitario, Boolean descuento) {

			HashMap<String, Object> obj = new HashMap<String, Object>();
			try {
				DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
				simbolos.setDecimalSeparator('.');
				DecimalFormat df = new DecimalFormat("#.##", simbolos);
				BigDecimal valorunitario;
				BigDecimal preciounitario;
				BigDecimal dsctoPorc;
				BigDecimal dsctoTotal;
				BigDecimal valorVtaTotalDscto;
				BigDecimal igvVtaTotalDscto;
				BigDecimal precioVtaTotalDscto;
				BigDecimal valorVenta;
				BigDecimal igvVenta;
				BigDecimal precioVenta;
				BigDecimal igvunitario;
				if (indicadorAfecto.equals("10")) {
					if (monedaOrigen.equals(monedaDestino)) {
						valorunitario = valorUnitario;
					} else {
						if (monedaOrigen.equals("1")) {
							valorunitario = valorUnitario.divide(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						} else {
							valorunitario = valorUnitario.multiply(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						}
					}					
					igvunitario = valorunitario.multiply(new BigDecimal(0.18));
					preciounitario = valorunitario.add(igvunitario);
					if (descuento == true) {
						dsctoPorc = porcDescuento.divide(new BigDecimal(100));
					} else {
						dsctoPorc = new BigDecimal(0);
					}
					dsctoTotal = valorunitario.multiply(new BigDecimal(cantidad)).multiply(dsctoPorc);
					valorVtaTotalDscto = valorunitario.multiply(new BigDecimal(cantidad)).subtract(dsctoTotal);
					igvVtaTotalDscto = valorVtaTotalDscto.multiply(new BigDecimal(0.18));
					precioVtaTotalDscto = valorVtaTotalDscto.add(igvVtaTotalDscto);					

					// VALORES A RETORNAR DE LA FUNCION
					obj.put("valorUnitario", df.format(valorunitario));
					obj.put("igvUnitario", df.format(igvunitario));
					obj.put("precioUnitario", df.format(preciounitario));
					obj.put("valorVenta", df.format(valorunitario.multiply(new BigDecimal(cantidad))));
					obj.put("igvVenta", df.format(igvunitario.multiply(new BigDecimal(cantidad))));
					obj.put("precioVenta", df.format(preciounitario.multiply(new BigDecimal(cantidad))));
					obj.put("porcentaDesc", df.format(ObjectUtils.defaultIfNull(porcDescuento, "0")));
					obj.put("importeDesc", df.format(dsctoTotal));
					obj.put("precValorVentaDscto", df.format(valorVtaTotalDscto));
					obj.put("precIgvVentaDscto", df.format(igvVtaTotalDscto));
					obj.put("precPrecioVentaDscto", df.format(precioVtaTotalDscto));
					obj.put("baseImporte", df.format(valorVtaTotalDscto));
					obj.put("igv", df.format(igvVtaTotalDscto));
					obj.put("totalBruto", df.format(precioVtaTotalDscto));
					obj.put("totalNeto", df.format(precioVtaTotalDscto));

				} else if (indicadorAfecto.equals("50")) {

					if (monedaOrigen.equals(monedaDestino)) {
						valorunitario = valorUnitario;
					} else {
						if (monedaOrigen.equals("1")) {
							valorunitario = valorUnitario.divide(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						} else {
							valorunitario = valorUnitario.multiply(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						}
					}

					igvunitario = valorunitario.multiply(new BigDecimal(0.18));
					preciounitario = valorunitario.add(igvunitario);
					valorVenta = valorunitario.multiply(new BigDecimal(cantidad));
					igvVenta = igvunitario.multiply(new BigDecimal(cantidad));
					precioVenta = preciounitario.multiply(new BigDecimal(cantidad));
					
					// VALORES A RETORNAR DE LA FUNCION
					obj.put("valorUnitario", df.format(valorunitario));
					obj.put("igvUnitario", df.format(igvunitario));
					obj.put("precioUnitario", df.format(preciounitario));
					obj.put("valorVenta", df.format(valorVenta));
					obj.put("igvVenta", df.format(igvVenta));
					obj.put("precioVenta", df.format(precioVenta));
					obj.put("porcentaDesc", "0");
					obj.put("importeDesc", "0");
					obj.put("precValorVentaDscto", valorVenta);
					obj.put("precIgvVentaDscto", igvVenta);
					obj.put("precPrecioVentaDscto", precioVenta);
					obj.put("baseImporte", df.format(valorVenta));
					obj.put("igv", df.format(igvVenta));
					obj.put("totalBruto", "0");
					obj.put("totalNeto", "0");

				} else {

					// exportacion, inafecta, exonerado

					if (monedaOrigen.equals(monedaDestino)) {
						valorunitario = valorUnitario;
					} else {
						if (monedaOrigen.equals("1")) {
							valorunitario = valorUnitario.divide(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						} else {
							valorunitario = valorUnitario.multiply(new BigDecimal(listaTipCambio), MathContext.DECIMAL128);
						}
					}
					
					if (descuento == true) {
						dsctoPorc = porcDescuento.divide(new BigDecimal(100));
					} else {
						dsctoPorc = new BigDecimal(0);
					}
					dsctoTotal = valorunitario.multiply(new BigDecimal(cantidad)).multiply(dsctoPorc);
					valorVtaTotalDscto = valorunitario.multiply(new BigDecimal(cantidad)).subtract(dsctoTotal);
					
					// VALORES A RETORNAR DE LA FUNCION
					obj.put("valorUnitario", df.format(valorunitario));
					obj.put("igvUnitario", "0");
					obj.put("precioUnitario", df.format(valorunitario));
					obj.put("valorVenta", df.format(valorunitario.multiply(new BigDecimal(cantidad))));
					obj.put("igvVenta", "0");
					obj.put("precioVenta", df.format(valorunitario.multiply(new BigDecimal(cantidad))));
					obj.put("porcentaDesc", df.format(ObjectUtils.defaultIfNull(porcDescuento, "0")));
					obj.put("importeDesc", df.format(dsctoTotal));
					obj.put("precValorVentaDscto", df.format(valorVtaTotalDscto));
					obj.put("precIgvVentaDscto", "0");
					obj.put("precPrecioVentaDscto", df.format(valorVtaTotalDscto));
					obj.put("baseImporte", df.format(valorVtaTotalDscto));
					obj.put("igv", "0");
					obj.put("totalBruto", df.format(valorVtaTotalDscto));
					obj.put("totalNeto", df.format(valorVtaTotalDscto));

				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return obj;

		}
	
	    
		
		@RequestMapping(value = "/verPDF", method = RequestMethod.GET)
		public void verPDF(HttpSession ses,HttpServletResponse response, @RequestParam(value = "idVenta", required = true) String idVenta) throws IOException {

			TSalesFilterGet filtro = new TSalesFilterGet();
			TSalesFilter voucher = new TSalesFilter();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setSaleBident(new Long(idVenta));
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			try {
				PaginaResultado<TSalesFilter> resultado = ventasRest.getSaleFilter(filtro,beanDS);
				if (resultado != null && resultado.getCantidad() > 0) {
					ObjectMapper mapper = new ObjectMapper();
					voucher = mapper.convertValue(resultado.getResultados().get(0), TSalesFilter.class);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String urlFile = voucher.getSale_url_pdf();
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
			        
			}catch(Exception e) {
				
			}
		}
		

		@RequestMapping(value = "/reloadClient", method = RequestMethod.POST)
		@ResponseBody
		public String reloadClient(HttpSession ses, HttpServletRequest rq,String idPerson,String tipoDoc1) {
			ObjectMapper mapper = new ObjectMapper();
			JsonObject robject = new JsonObject();
			try {
				logger.info("Listando clientes");
				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				TClientEndFilterPersonGet filtroCLP = new TClientEndFilterPersonGet();
				filtroCLP.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));;
				if (tipoDoc1.equals("01")){
					filtroCLP.setPersVdoctype("1");
				}
				filtroCLP.setEstado("1");
				TClientEndFilterPerson prouser = new TClientEndFilterPerson();
				PaginaResultado<TClientEndFilterPerson> response = clientendRest.getClientEndFilterRest(filtroCLP,beanDS);
				JsonArray aReturn = new JsonArray();
				String client="";
				for (Object catdetuser : response.getResultados()) {
					prouser = mapper.convertValue(catdetuser, TClientEndFilterPerson.class);
					JsonObject jReturn = new JsonObject();
					if(prouser.getPersBident().toString().equals(idPerson)){
						client=prouser.getClieBident().toString();
					}
					jReturn.addProperty("bident", prouser.getClieBident());
					jReturn.addProperty("persVnumdoc", prouser.getPers_vnumdoc());
					jReturn.addProperty("persVdoctype", prouser.getPersVdoctype());
					jReturn.addProperty("nombre", prouser.getNombre());
					jReturn.addProperty("mailVmail", prouser.getMailVmail());
					jReturn.addProperty("direccionUbigeoPais", prouser.getDireccionUbigeoPais());
					jReturn.addProperty("persVnumdocDes", prouser.getPers_vnumdoc());
					jReturn.addProperty("nombres", prouser.getNombre());
					
					aReturn.add(jReturn);
				}
				robject.addProperty("idCliente", client);
				robject.add("toption", aReturn);	
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				robject.addProperty("msg", "error");
				return new Gson().toJson(robject);
			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
				
		@RequestMapping(value = "/lista_ventabuscarfacturaboleta", method = RequestMethod.POST)
	    @ResponseBody
	    public String getlistaVentabuscarCPE(HttpServletRequest rq, HttpSession ses,
	    		@RequestParam(value = "listaComprobantefacbol", required = false) String listaComprobantefacbol,
		   		@RequestParam(value = "fechaMovVentafacbol", required = false) String fechaMovVentafacbol,
				@RequestParam(value = "serieVentafacbol", required = false) String serieVentafacbol,
				@RequestParam(value = "nroCompVentafacbol", required = false) String nroCompVentafacbol,
				@RequestParam(value = "clienteVentafacbol", required = false) String clienteVentafacbol
	    		) {
	        System.out.println("===========Inicio-> RegistroVentas/lista_facturasBoletas");

	        String sStart = rq.getParameter("draw");
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	        	TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
	        	BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
	        	TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
	        	TSalesSearchGet filtroLP = new TSalesSearchGet();
	            filtroLP.setPaginacion(new PaginacionFiltro(1,Integer.MAX_VALUE));
	            filtroLP.setUser_vuser(user.getUserVuser());
	            filtroLP.setVouc_estado_cdr(Constantes.RPTA_SUNAT.ACEPTADO.getCode());
	            filtroLP.setSaleCstate(Constantes.flagVentaEstado.ACTIVO.getCode());
//	            if(tEmployee!=null) {  
//	            	filtroLP.setBusiBident(tEmployee.getBusiBident());
//	            }
	            if(listaComprobantefacbol!=null && !listaComprobantefacbol.isEmpty()) {
		        	filtroLP.setVtipdocvoucher(listaComprobantefacbol);
		        }
	            if(serieVentafacbol!=null && !serieVentafacbol.isEmpty()) {
		        	filtroLP.setVserievoucher(serieVentafacbol);
		        }
		        if(nroCompVentafacbol!=null && !nroCompVentafacbol.isEmpty()) {
		            filtroLP.setVnumbervoucher(nroCompVentafacbol);
		        }
		        if(clienteVentafacbol!=null && !clienteVentafacbol.isEmpty()) {
		            filtroLP.setBnumber_doc_clie(clienteVentafacbol);
		        }
		        if(fechaMovVentafacbol!=null && !fechaMovVentafacbol.isEmpty()) {
		            filtroLP.setSdetTmovementDate(Util.StringtoDateDMA(fechaMovVentafacbol));
		        }            
		        PaginaResultado<TSalesSearch> response = ventasRest.getSearchSale(filtroLP,beanDS);

	            List<TSalesSearch> LstdoUser = null;
	            if(response.getCantidad()>0){
	            	LstdoUser = response.getResultados();
	            }
	            List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
	            HashMap<String, Object> obj = null;
	            if(LstdoUser!=null){
	            for (Object objs: LstdoUser) {
	            	TSalesFilter vistaUser = mapper.convertValue(objs, TSalesFilter.class);
	            	if (vistaUser.getVtipdocvoucher().equals("FAC")){
	                obj = new HashMap<String, Object>();
	                obj.put("vperiod",ObjectUtils.defaultIfNull(vistaUser.getVperiod(), ""));
	                obj.put("sdetTmovementDate",ObjectUtils.defaultIfNull(vistaUser.getSdetTmovementDate(), ""));
	                obj.put("vtipdocvoucher",ObjectUtils.defaultIfNull(vistaUser.getVtipdocvoucher(), ""));
	                obj.put("vOfficePlace",ObjectUtils.defaultIfNull(vistaUser.getvOfficePlace(), ""));
	                obj.put("vserievoucher",ObjectUtils.defaultIfNull(vistaUser.getVserievoucher(), ""));
	                obj.put("vnumbervoucher",ObjectUtils.defaultIfNull(vistaUser.getVnumbervoucher(), ""));
	                obj.put("vtype_doc_clie",ObjectUtils.defaultIfNull(vistaUser.getVtype_doc_clie(), ""));
	                obj.put("bnumber_doc_clie",ObjectUtils.defaultIfNull(vistaUser.getBnumber_doc_clie(), ""));
	                obj.put("vbusiname_clie",ObjectUtils.defaultIfNull(vistaUser.getVbusiname_clie(), ""));
	                obj.put("vtype_doc_seller",ObjectUtils.defaultIfNull(vistaUser.getVtype_doc_seller(), ""));
	                obj.put("bnumber_doc_seller",ObjectUtils.defaultIfNull(vistaUser.getBnumber_doc_seller(), ""));
	                obj.put("vbusiname_seller",ObjectUtils.defaultIfNull(vistaUser.getVbusiname_seller(), ""));
	                obj.put("sdetTregistrationDate",ObjectUtils.defaultIfNull(vistaUser.getSdetTregistrationDate(), ""));
	                obj.put("vwaypay_name",ObjectUtils.defaultIfNull(vistaUser.getVwaypay_name(), ""));
	                obj.put("sdetTexpiryDate",ObjectUtils.defaultIfNull(vistaUser.getSdetTexpiryDate(), ""));
	                obj.put("sdetTPaymentDate",ObjectUtils.defaultIfNull(vistaUser.getSdetPaymentDate(), ""));
	                obj.put("vname_coin",ObjectUtils.defaultIfNull(vistaUser.getVname_coin(), ""));
	                obj.put("dexchange_rate",ObjectUtils.defaultIfNull(vistaUser.getDexchange_rate(), ""));
	                obj.put("dresult_grav",ObjectUtils.defaultIfNull(vistaUser.getDresult_grav(), ""));
	                obj.put("dresult_inf",ObjectUtils.defaultIfNull(vistaUser.getDresult_inf(), ""));
	                obj.put("dresult_exo",ObjectUtils.defaultIfNull(vistaUser.getDresult_exo(), ""));
	                obj.put("dresult_exporta",ObjectUtils.defaultIfNull(vistaUser.getDresult_exporta(), ""));
	                obj.put("dresult_neto",ObjectUtils.defaultIfNull(vistaUser.getDresult_neto(), ""));
	                obj.put("dresult_igv",ObjectUtils.defaultIfNull(vistaUser.getDresult_igv(), ""));
	                obj.put("dresult_discountglobal", ObjectUtils.defaultIfNull(vistaUser.getDresult_discountglobal(), ""));
	                obj.put("dresult_total",ObjectUtils.defaultIfNull(vistaUser.getDresult_total(), ""));
	                obj.put("dresult_affair",ObjectUtils.defaultIfNull(vistaUser.getDresult_affair(), ""));
	                obj.put("dresult_titlegratuito",ObjectUtils.defaultIfNull(vistaUser.getDresult_titlegratuito(), ""));
	                obj.put("busiBident",ObjectUtils.defaultIfNull(vistaUser.getBusiBident(), ""));
	                obj.put("saleCstate",ObjectUtils.defaultIfNull(vistaUser.getSaleCstate(), ""));
	                obj.put("clieBident",ObjectUtils.defaultIfNull(vistaUser.getClieBident(), ""));
	                obj.put("persBident",ObjectUtils.defaultIfNull(vistaUser.getPersBident(), ""));
	                obj.put("saleBident",ObjectUtils.defaultIfNull(vistaUser.getSaleBident(), ""));
	                obj.put("voucPdf",ObjectUtils.defaultIfNull(vistaUser.getSale_url_pdf(), ""));
	                obj.put("voucEnvioSunat", ObjectUtils.defaultIfNull(vistaUser.getVouc_estado_cdr(), ""));
	               objLista.add(obj);
	            }
	            }
	            }
	            System.out.println("estado de comprobante:" +objLista);
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
		
		@RequestMapping(value = "/detalleNCND", method = RequestMethod.POST)
		@ResponseBody
		public String detalleNCND(HttpSession ses, HttpServletRequest rq,
				@RequestParam(value = "codDet", required = true) String codDet) {

	 		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
			
	 		TSales vistaEmpreLP=new TSales();
			try {

				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				TSalesGet filtroV = new TSalesGet();
				filtroV.setPaginacion(new PaginacionFiltro(1, 1));
				filtroV.setSaleBident(new Long(codDet));
				filtroV.setSaleCstate("0");
				PaginaResultado<TSales> responseV = ventasRest.getSale(filtroV,beanDS);
				List<TSales> LstdoEmpreLP = null;
				if (responseV.getCantidad() > 0) {
					LstdoEmpreLP = responseV.getResultados();
				}
				List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
				ObjectMapper mapperLP = new ObjectMapper();
				HashMap<String, Object> objLP = null;
				if (LstdoEmpreLP != null) {
					for (Object objsLP : LstdoEmpreLP) {
						vistaEmpreLP = mapperLP.convertValue(objsLP, TSales.class);
						//seteando falg de fecha
//						Date fechaTC = Util.stringtoDate(Util.datetoString2(new Date()));
//						Date fechaReg = Util.stringtoDate(Util.datetoString2(vistaEmpreLP.getTypeTdateUpdate()));
						objLP = new HashMap<String, Object>();
						objLP.put("VentaSerie", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVserieVoucher(), ""));
						objLP.put("VentaNroDoc", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVnumberVoucher(), ""));
						objLP.put("RazCliente", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVbusinameClient(), ""));
						objLP.put("DireccionCliente", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVaddressClient(), ""));
						objLP.put("RazVendedor", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVbusinameSeller(), ""));
						objLP.put("ObsCabecera", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVaffair(), ""));
						objLP.put("ResultadoINF", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDunaffected(), ""));
						objLP.put("ResultadoEXONERADO", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDexonerated(), ""));
						objLP.put("ResultadoGRATUITA", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDfreeAmount(), ""));
						objLP.put("ResultadoBIM", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDtaxedBim(), ""));
						objLP.put("ResultadoEXPORTACION", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDexport(), ""));
						objLP.put("ResultadoValorNeto", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDvaluetotal(), ""));
						objLP.put("ResultadoNETO", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDnet(), ""));
						objLP.put("ResultadoIGV", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDigv(), ""));
						objLP.put("ResultadoDSCTO", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDdiscount(), ""));
						objLP.put("ResultadoTOTAL", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDtotal(), ""));
						objLP.put("ResultadoCONVERS", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleDconversion(), ""));
						objLP.put("ResultadoSON", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVtotalAmountLetters(), ""));
						objLP.put("idcodVenta", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleBident(), ""));
						objLP.put("fechaderegistro", ObjectUtils.defaultIfNull(Util.datetoString(vistaEmpreLP.getSaleTregistrationDate()), ""));
						objLP.put("fechademovimiento", ObjectUtils.defaultIfNull(Util.datetoString4(vistaEmpreLP.getSaleTmovementDate()), ""));
						objLP.put("fechadevencimiento", ObjectUtils.defaultIfNull(Util.datetoString(vistaEmpreLP.getSaleTdateExpiry()), ""));
						objLP.put("fechadepago", ObjectUtils.defaultIfNull(Util.datetoString(vistaEmpreLP.getSaleTpaymentDate()),""));
						objLP.put("editar",ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleBident(), ""));
						objLP.put("cliente", ObjectUtils.defaultIfNull(vistaEmpreLP.getClieBident(), ""));	
						objLP.put("vendedor", ObjectUtils.defaultIfNull(vistaEmpreLP.getEmplBident(), ""));	
						objLP.put("formadepago", ObjectUtils.defaultIfNull(vistaEmpreLP.getWaypayBident(), ""));	
						objLP.put("tipCambio", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleTexchangeRate(), ""));	
						objLP.put("tipCambioident", ObjectUtils.defaultIfNull(vistaEmpreLP.getTypeBident(), ""));	
						objLP.put("periodo", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVperiod(), ""));	
						objLP.put("sucursal", ObjectUtils.defaultIfNull(vistaEmpreLP.getOfficeBident(), ""));	
						objLP.put("tipdoc", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVtypeVoucher(), ""));	
						objLP.put("moneda", ObjectUtils.defaultIfNull(vistaEmpreLP.getCoinBident(), ""));	
						objLP.put("indicador", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVindicatorAfecto(), ""));	
						objLP.put("indicadortipo", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleVtypeIndicatorAfecto(), ""));	
						objLP.put("pdf", ObjectUtils.defaultIfNull(vistaEmpreLP.getSaleUrlPdf(), ""));
						objListaLP.add(objLP);
					}
					
					System.out.println(objListaLP.size());
				}

				Gson gson = new Gson();
				String data = gson.toJson(objLP);
				System.out.println(data);
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "ok");
				robject.addProperty("Campos_NC_ND", data);
//				System.out.println(robject);
				
				return new Gson().toJson(robject);

			} catch (Exception e) {
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);

			}

		}
		
		@RequestMapping(value = "/detVentaIndividual", method = RequestMethod.POST)
		@ResponseBody
		public String detVentaIndividual(HttpSession ses, HttpServletRequest rq,
				@RequestParam(value = "codDet", required = true) String codDet) {

	 		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
	 		TSalesDetailFilter vistaUser=new TSalesDetailFilter();
			List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();

			try {

				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				String fechas[] = codDet.split(",");
				
				for (int i = 0; i < fechas.length; i++) {
					String codDetalle = fechas[i].trim();
					TSalesDetailFilterGet detalle = new TSalesDetailFilterGet();
					detalle.setPaginacion(new PaginacionFiltro(1, 1));
					detalle.setDetailBident(new Long(codDetalle));
					PaginaResultado<TSalesDetailFilter> responseDet = ventasRest.getSaleDetalleFilter(detalle,beanDS);
					List<TSalesDetailFilter> LstdoDet = null;
					if (responseDet.getCantidad() > 0) {
						LstdoDet = responseDet.getResultados();
					}
					
					ObjectMapper mapperLP = new ObjectMapper();
					HashMap<String, Object> objLP = null;
					if (LstdoDet != null) {
						for (Object objsLP : LstdoDet) {
							vistaUser = mapperLP.convertValue(objsLP, TSalesDetailFilter.class);

							objLP = new HashMap<String, Object>();
							objLP.put("sel", "");
							objLP.put("numero",ObjectUtils.defaultIfNull(vistaUser.getSdetBnumber(), ""));
							if (null!=vistaUser.getProdBident() && !Long.toString(vistaUser.getProdBident()).equals("")) {
								objLP.put("codigo",ObjectUtils.defaultIfNull(vistaUser.getProdBident(), ""));
							} else {
								objLP.put("codigo",ObjectUtils.defaultIfNull(vistaUser.getServBident(), ""));
							}
							objLP.put("codigoAlmacen",ObjectUtils.defaultIfNull(vistaUser.getStoreBident(), ""));
							objLP.put("codigoComercial",ObjectUtils.defaultIfNull(vistaUser.getSdetvcommercialcode(), ""));
							objLP.put("nomcorto",ObjectUtils.defaultIfNull(vistaUser.getSdetvshortnameprod_serv(), ""));
							objLP.put("Descripcion",ObjectUtils.defaultIfNull(vistaUser.getSdetvdescripprod_serv(), ""));
							objLP.put("concepto",ObjectUtils.defaultIfNull(vistaUser.getSdetvconcept(), ""));
							objLP.put("UnidadMedida",ObjectUtils.defaultIfNull(vistaUser.getSdetvvmeassure_unity(), ""));
							objLP.put("cantidad",ObjectUtils.defaultIfNull(vistaUser.getSdetdquantity(), ""));
							objLP.put("incluyeIgv",ObjectUtils.defaultIfNull(vistaUser.getSdetBincludeIgv(), ""));
			                objLP.put("valorUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesunit(), ""));
			                objLP.put("igvUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdigvunit(), ""));
			                objLP.put("precioUnitario",ObjectUtils.defaultIfNull(vistaUser.getSdetdpriceunit(), ""));
			                objLP.put("valorVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesale(), ""));
			                objLP.put("igvVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdvaluesale(), ""));
			                objLP.put("porcentaDesc",ObjectUtils.defaultIfNull(vistaUser.getSdetddescporcentage(), ""));
			                objLP.put("importeDesc",ObjectUtils.defaultIfNull(vistaUser.getSdetddescimport(), ""));
			                objLP.put("precValorVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountvaluepric(), ""));
			                objLP.put("precIgvVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdnigvdescupric(), ""));
			                objLP.put("precPrecioVentaDscto",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric(), ""));
			                objLP.put("baseImporte",ObjectUtils.defaultIfNull(vistaUser.getSdetdtaxbase(), ""));
			                objLP.put("igv",ObjectUtils.defaultIfNull(vistaUser.getSdetdigv(), ""));
			                objLP.put("igvVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric().subtract(vistaUser.getSdetdiscountvaluepric()), ""));
			                objLP.put("precioVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdiscountpric(), ""));
			                objLP.put("totalBruto",ObjectUtils.defaultIfNull(vistaUser.getSdetdgroostotal(), ""));
			                objLP.put("totalNeto",ObjectUtils.defaultIfNull(vistaUser.getSdetdnettotal(), ""));
			                objLP.put("indicadorAfecto",ObjectUtils.defaultIfNull(vistaUser.getSdetvaffindicator(), ""));
			                objLP.put("tipoIndicadorAfecto",ObjectUtils.defaultIfNull(vistaUser.getSdetvtipaffecindicator(), ""));
			                objLP.put("precDescripMoneda", ObjectUtils.defaultIfNull(vistaUser.getSdetvcoinorigin(), ""));
			                objLP.put("tipoMonedaDestino",ObjectUtils.defaultIfNull(vistaUser.getSdetvcoincurrency(), ""));
			                objLP.put("tipoCambioVenta",ObjectUtils.defaultIfNull(vistaUser.getSdetdmountexchange(), ""));
			                objLP.put("tipoConversion",ObjectUtils.defaultIfNull(vistaUser.getSdetdcurrencyconvers(), ""));
			                objLP.put("transferencia",ObjectUtils.defaultIfNull(vistaUser.getSdetVfreeTransfer(), ""));
			                objLP.put("observacion",ObjectUtils.defaultIfNull(vistaUser.getSdetVobservation(), ""));
			                objLP.put("saleBident",ObjectUtils.defaultIfNull(vistaUser.getSaleBident(), ""));
			                objLP.put("detailBident",ObjectUtils.defaultIfNull(vistaUser.getDetailBident(), ""));
			                objLP.put("prodBident",ObjectUtils.defaultIfNull(vistaUser.getProdBident(), ""));
			                objLP.put("preciodescripcionproducto",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("esprecioprincipal",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("nombremarca",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("nombrecortomarca",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("nombredescripcionmarca",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("preciodescripcion",ObjectUtils.defaultIfNull("", ""));
			                objLP.put("tipoRegistro","");
			                objLP.put("precioInicial",ObjectUtils.defaultIfNull(vistaUser.getSdetdpriceunit(), ""));
			                objLP.put("claseSunat",ObjectUtils.defaultIfNull(vistaUser.getSdetVclassSunat(), ""));

							
							objListaLP.add(objLP);
						}
					
				
					
					System.out.println(objListaLP.size());
				}
				}
					

				Gson gson = new Gson();
				String data = gson.toJson(objListaLP);
				JsonObject robject = new JsonObject();
				JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
				robject.addProperty("msg", "ok");
				robject.addProperty("lista", data);
		        robject.add("data", jsonArray);
		        robject.add("datadetalle", jsonArray);
				
				return new Gson().toJson(robject);

			} catch (Exception e) {
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);

			}

		}
		
		@RequestMapping(value = "/consultaCodRegistro", method = RequestMethod.POST)
		@ResponseBody
		public String consultaCodRegistro(HttpSession ses, HttpServletRequest rq,

				@RequestParam(value = "tipo", required = true) String tipo,
				@RequestParam(value = "sucursal", required = true) String sucursal,
				@RequestParam(value = "ejercicio", required = true) String ejercicio,
				@RequestParam(value = "periodo", required = true) String periodo) throws IOException {
			
	 		TCatalogueDet CatDetReg = new TCatalogueDet();
	 		TBranchOffice SucurReg = new TBranchOffice();
	 		TParamBranchOffice ParamSuc = new TParamBranchOffice();
	 		ObjectMapper mapperLP = new ObjectMapper();
			try {
				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
				
				TCatalogueDetGet filtroCatDetReg = new TCatalogueDetGet();
				filtroCatDetReg.setPaginacion(new PaginacionFiltro(1, 1));
				filtroCatDetReg.setCataBident(new Long(35));
				filtroCatDetReg.setCatdCident(tipo);
				PaginaResultado<TCatalogueDet> responseCatDetReg = CataRest.getCatalogueDet(filtroCatDetReg,beanDS);
				List<TCatalogueDet> LstdoCatDetReg = null;
				if (responseCatDetReg.getCantidad() > 0) {
					LstdoCatDetReg = responseCatDetReg.getResultados();
					CatDetReg = mapperLP.convertValue(LstdoCatDetReg.get(0), TCatalogueDet.class);
				}
				
				TBranchOfficeGet filtroSucursal = new TBranchOfficeGet();
				filtroSucursal.setPaginacion(new PaginacionFiltro(1, 1));
				filtroSucursal.setOffiBident(new Long(sucursal));
				PaginaResultado<TBranchOffice> responseSucursal = BussinesRest.getSucursal(filtroSucursal,beanDS);
				List<TBranchOffice> LstdoSucursal = null;
				if (responseSucursal.getCantidad() > 0) {
					LstdoSucursal = responseSucursal.getResultados();
					SucurReg = mapperLP.convertValue(LstdoSucursal.get(0), TBranchOffice.class);
				}
				
				int periodoInt = Integer.parseInt(periodo);
				if (periodoInt<10) {
					periodo = "0"+periodo;
				}
				String key1 = ejercicio+periodo;
				TParamBranchOfficeGet filtroParamSuc = new TParamBranchOfficeGet();
				filtroParamSuc.setPaginacion(new PaginacionFiltro(1, 1));
				filtroParamSuc.setOffiBident(new Long(sucursal));
				filtroParamSuc.setPaofBkey1(key1);
				filtroParamSuc.setPaofBkey2(tipo);
				PaginaResultado<TParamBranchOffice> responseParamSuc = BussinesRest.getParamBranchOffice(filtroParamSuc,beanDS);
				List<TParamBranchOffice> LstdoParamSuc = null;
				if (responseParamSuc.getCantidad() > 0) {
					LstdoParamSuc = responseParamSuc.getResultados();
					ParamSuc = mapperLP.convertValue(LstdoParamSuc.get(0), TParamBranchOffice.class);
				}
				
				String CodCatDet = CatDetReg.getCatdVshortname();
				String SucCode = SucurReg.getOffiVcode();
				String mesAnio = ParamSuc.getPaofBkey1();
				
				String secCodReg = ParamSuc.getPaofBvalue().toString();
				
				JsonObject robject = new JsonObject();
				
				//VT-RV-PR2018-08-0001
				
				String CodRegistro = CodCatDet+SucCode+mesAnio;
				
				if ( null != CodRegistro && !CodRegistro.equals("")) {
					int parse_numero = Integer.parseInt(secCodReg)+1;		
					String padded = "000000".substring(String.valueOf(parse_numero).length()) + String.valueOf(parse_numero);
					CodRegistro=CodRegistro+padded;				
					robject.addProperty("msg", "ok");
					robject.addProperty("CodRegistro", CodRegistro);
				}else{
					robject.addProperty("msg", "error");
				}
				
				return new Gson().toJson(robject);

			} catch (Exception e) {
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);

			}

		}
		
		@RequestMapping(value = "/vistaPrevia", method = RequestMethod.POST)
		@ResponseBody
		public String vistaPrevia(HttpSession ses, HttpServletRequest rq, 
				@RequestBody String json) throws IOException {
			
			JsonObject robject = new JsonObject();
			TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
//			TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			String razonSocial = null,ubigeo=null,nombreComercial=null,direcEmpresa=null,rucEmpresa=null,tipoDocEmpr=null;
			String depart="",distrito="",provincia="";
			ObjectMapper mapper = new ObjectMapper();

			try {
				
				JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
				VistaPreviaCab sales = new VistaPreviaCab();
				String tipoComprobante=jsonObj.get("tipoComprobante").getAsString();
				
				Long idCliente = new Long(jsonObj.get("idCliente").getAsString());
				
				sales.setClieBident(idCliente); 
				
				
				Long idEmployee = new Long(jsonObj.get("idVendedor").getAsString());
				sales.setEmplBident(idEmployee);		
				
				sales.setCoinBident(jsonObj.get("moneda").getAsString());
					 
				sales.setOfficeBident(jsonObj.get("sucursal").getAsString());
				
				sales.setSaleVexercise(jsonObj.get("ejercicio").getAsString());
				sales.setRepoBident(new Long(jsonObj.get("almacen").getAsString()));
				sales.setSaleVoperationRegisterNumber(jsonObj.get("codRegVenta").getAsString());
				System.out.println("Fecha de front "+jsonObj.get("fechaMovimiento").getAsString());
				sales.setSaleBdocAdvance("");//ARREGLAR DESPUES
				Long nrodias = new Long(jsonObj.get("dias").getAsString());
				sales.setSaleBnumberDay(nrodias);
				sales.setSaleBnumberDocClie(jsonObj.get("nroDocCliente").getAsString());			// cambiar por data real 
				sales.setSaleBnumberDocSeller(jsonObj.get("nroDocVendedor").getAsString());			// cambiar por data real 
				sales.setSaleBuserCreate(Long.toString(user.getPersBident()));
				sales.setSaleBuserModify(Long.toString(user.getPersBident()));
				sales.setSaleCstatePurchaseorder(Constantes.ESTADO_VENTA.VENTA.getCode());
				sales.setSaleTdateExpiry(Util.StringtoDateDMA(jsonObj.get("fechaVencimiento").getAsString()));
				sales.setSaleTdateUpdate(null);
				sales.setSaleTmovementDate(Util.datetoString8(jsonObj.get("fechaMovimiento").getAsString()));
				sales.setSaleTpaymentDate(Util.StringtoDateDMA(jsonObj.get("fechaMovimientopago").getAsString()));
				sales.setSaleTregistrationDate(new Date());
				sales.setSaleVaddressClient(jsonObj.get("direccionCliente").getAsString());
				sales.setSaleVaffair(jsonObj.get("observacion").getAsString());
				sales.setSaleVbusinameClient(jsonObj.get("nombreCliente").getAsString());
				sales.setSaleVbusinameSeller(jsonObj.get("nombreVendedor").getAsString());
				sales.setSaleVindicatorAfecto(jsonObj.get("indicador").getAsString());
				sales.setSaleVnumberVoucher(jsonObj.get("nroComprobante").getAsString());
//				sales.setSaleVnumberVoucher(nroCompr);
				sales.setSaleVperiod(jsonObj.get("periodo").getAsString());
				//nota cred/deb
				if(null!=tipoComprobante && !tipoComprobante.equals("")) {
					if(tipoComprobante.equals("07")) {
						sales.setSaleTdocRefereceDate(Util.StringtoDateDMA(jsonObj.get("fecDocReferencia").getAsString()));
						sales.setSaleVcodTipReferece(jsonObj.get("tipCompReferencia").getAsString());
						sales.setSaleVserieDocReferece(jsonObj.get("serCompReferencia").getAsString());
						sales.setSaleVnumDocReferece(jsonObj.get("nroCompReferencia").getAsString());
						sales.setSaleBcodMotivoNotaCredito(jsonObj.get("codMotivoCre").getAsString());
						sales.setSaleVaffair(jsonObj.get("observacionNota").getAsString());
					} else if(tipoComprobante.equals("08")) {
						sales.setSaleTdocRefereceDate(Util.StringtoDateDMA(jsonObj.get("fecDocReferencia").getAsString()));
						sales.setSaleVcodTipReferece(jsonObj.get("tipCompReferencia").getAsString());
						sales.setSaleVserieDocReferece(jsonObj.get("serCompReferencia").getAsString());
						sales.setSaleVnumDocReferece(jsonObj.get("nroCompReferencia").getAsString());
						sales.setSaleBcodMotivoNotaDebito(jsonObj.get("codMotivoDeb").getAsString());
						sales.setSaleVaffair(jsonObj.get("observacionNota").getAsString());
					} else {
						sales.setSaleVaffair(jsonObj.get("observacion").getAsString());
					}
				}
				
	            if(jsonObj.get("ventaTituloGratuito").getAsString().equals("true")) {
					sales.setSaleVsaleTitleFree("1");
				}else {
					sales.setSaleVsaleTitleFree("0");
				}
				sales.setSaleVserieVoucher(jsonObj.get("Serie").getAsString());
//				sales.setSaleVserieVoucher(serieCompr);
				
				
				sales.setSaleVtypeDocClie(jsonObj.get("tipoDocCliente").getAsString());
				sales.setSaleVtypeDocSeller(jsonObj.get("tipoDocVendedor").getAsString());	 
				if("null".equals(jsonObj.get("tipoIndicador"))) {
					sales.setSaleVtypeIndicatorAfecto(jsonObj.get("tipoIndicador").getAsString());
				}
				
				sales.setSaleVtypeVoucher(jsonObj.get("tipoComprobante").getAsString());
				
//				if(jsonObj.get("idTipoCambio").getAsString().trim().length()>0) {
//					sales.setTypeBident(new Long(jsonObj.get("idTipoCambio").getAsString()));
//				}
				
				
//				sales.setSaleTexchangeRate(jsonObj.get("montoTipoCambio").getAsString());
				
				sales.setWaypayBident(jsonObj.get("formaPago").getAsString());
				
				sales.setSaleVtypeIndicatorAfecto(jsonObj.get("tipoIndicador").getAsString());
				logger.info("Se procedera a calculaar los montos para enviar!!!");
				String tipoIA=jsonObj.get("indicador").getAsString();
				String tipoTIA=jsonObj.get("indicador").getAsString();
				
				try {
					String gravada=Constantes.indicador_ia.GRAVADA.getCode();
					String exonerada=Constantes.indicador_ia.EXONERADO.getCode();
					String inafecta=Constantes.indicador_ia.INAFECTO.getCode();
					String exportacion=Constantes.indicador_ia.EXPORTACION.getCode();
					String gratuitas=Constantes.indicador_ia.GRATUITAS.getCode();
					
					if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_OPERACION_ONEROSA.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PREMIO.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_DONACION.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_PUBLICIDAD.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_BONIFICACIONES.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposGravada.GRAVADA_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposExonerada.EXONERADA_OPERACION_ONEROSA.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_BONIFICACION.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PREMIO.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_OPERACION_ONEROSA.getCode())) {
						
					}else if(tipoTIA.trim().equals(Constantes.tiposInafecto.INAFECTO_RETIRO_POR_PUBLICIDAD.getCode())) {
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				sales.setSaleDunaffected(jsonObj.get("inafecto").getAsBigDecimal());
				sales.setSaleDtaxedBim(jsonObj.get("gravada").getAsBigDecimal());
				sales.setSaleDexonerated(jsonObj.get("exonerada").getAsBigDecimal());
				sales.setSaleDexport(jsonObj.get("exportacion").getAsBigDecimal());
	            sales.setSaleDfreeAmount(jsonObj.get("gratuita").getAsBigDecimal());
	            sales.setSaleDvaluetotal(jsonObj.get("valortotal").getAsBigDecimal());
	            sales.setSaleDnet(jsonObj.get("neto").getAsBigDecimal());
	            sales.setSaleDigv(jsonObj.get("igv").getAsBigDecimal());
	            sales.setSaleDtotal(jsonObj.get("total").getAsBigDecimal());
	            sales.setSaleDconversion(jsonObj.get("conversion").getAsBigDecimal());
	            sales.setSaleDdiscount(jsonObj.get("impDescTot").getAsBigDecimal());
	            sales.setSaleCstate(Constantes.flagVentaEstado.ACTIVO.getCode());
	            sales.setSaleVtotalAmountLetters(jsonObj.get("totalletras").getAsString());
	            System.out.println("guia "+jsonObj.get("guia").getAsString());
	            System.out.println("orden compra "+jsonObj.get("ordencompra").getAsString());
	            sales.setSaleVguide(jsonObj.get("guia").getAsString());
				sales.setSaleVorderpurchase(jsonObj.get("ordencompra").getAsString());
//	            String url= venta.getNrorucEmpr() +"-" + venta.getTipoDoc()+"-" + venta.getSerieDoc() +"-"+venta.getNroDoc();
//	            sales.setSaleUrlPdf(url+".pdf");
	            
	            JsonArray arrayDetalleVenta = jsonObj.get("arrayRegistros").getAsJsonArray();
				List<VistaPreviaDet> salesDatail = new ArrayList<>();
				String validaIngresoInventory = "";
				for (JsonElement jsonElement : arrayDetalleVenta) {
					VistaPreviaDet salesPost = new VistaPreviaDet();
					Long nroprodserv = new Long(jsonElement.getAsJsonObject().get("numero").getAsString());
					String UndMed = jsonElement.getAsJsonObject().get("UnidadMedida").getAsString();
					String nomcortoprod =jsonElement.getAsJsonObject().get("nomcorto").getAsString();
					String Descripcionprodserv=jsonElement.getAsJsonObject().get("Descripcion").getAsString();
	            if(UndMed!=null && UndMed.equals("ZZ")) {
	            	salesPost.setServBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
	            	salesPost.setSdetVshortnameServ(nomcortoprod);
	            	salesPost.setSdetVdescriptionServ(Descripcionprodserv);
	            	validaIngresoInventory="0";
	            }else {
	            	salesPost.setProdBident(jsonElement.getAsJsonObject().get("codigo").getAsLong());
	            	salesPost.setSdetVshortnameProd(nomcortoprod);
	            	salesPost.setSdetVdescriptionProd(Descripcionprodserv);
	            	validaIngresoInventory="1";
	            }
	            	salesPost.setSdetBnumber(nroprodserv);	
	            	salesPost.setSdetVclassSunat(jsonElement.getAsJsonObject().get("claseSunat").getAsString());
					salesPost.setSdetVshortnameBrand(jsonElement.getAsJsonObject().get("nombrecortomarca").getAsString());
					salesPost.setSdetVdescriptionBrand(jsonElement.getAsJsonObject().get("nombredescripcionmarca").getAsString());
					salesPost.setSdetVnameBrand(jsonElement.getAsJsonObject().get("nombremarca").getAsString());
					salesPost.setSdetVcommercialCode(jsonElement.getAsJsonObject().get("codigoComercial").getAsString());
					salesPost.setSdetVconcept(jsonElement.getAsJsonObject().get("concepto").getAsString());
					salesPost.setSdetBmainPrice(jsonElement.getAsJsonObject().get("esprecioprincipal").getAsBoolean());
					salesPost.setSdetBigvIncludesPrice(jsonElement.getAsJsonObject().get("incluyeIgv").getAsBoolean());
					salesPost.setSdetVcode(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
					salesPost.setSdetVdescriptionCoinPrice(jsonElement.getAsJsonObject().get("preciodescripcion").getAsString());
					salesPost.setSdetVdescriptionPrice(jsonElement.getAsJsonObject().get("preciodescripcionproducto").getAsString());
					salesPost.setSdetVmeassureUnity(jsonElement.getAsJsonObject().get("UnidadMedida").getAsString());
					salesPost.setSdetDquantity(new BigDecimal(jsonElement.getAsJsonObject().get("cantidad").getAsString()));
					salesPost.setSdetDunitValue(new BigDecimal(jsonElement.getAsJsonObject().get("valorUnitario").getAsString()));
					salesPost.setSdetDigvUnit(new BigDecimal(jsonElement.getAsJsonObject().get("igvUnitario").getAsString()));
					salesPost.setSdetDpriceUnit(new BigDecimal(jsonElement.getAsJsonObject().get("precioUnitario").getAsString()));
					salesPost.setSdetDvalueSale(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
					salesPost.setSdetDsaleValuePrice(new BigDecimal(jsonElement.getAsJsonObject().get("valorVenta").getAsString()));
					salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("precDescripMoneda").getAsString());
					salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
					try {
						BigDecimal porcDcto = new BigDecimal(jsonElement.getAsJsonObject().get("porcentaDesc").getAsString());
						salesPost.setSdetDdescPorcentage(porcDcto);
					}catch(Exception e) {
						logger.error("Revisar los campos de porcentaje de dcto");
						salesPost.setSdetDdescPorcentage(new BigDecimal("0.00"));
					}
					
					salesPost.setSdetDdescImport(new BigDecimal(jsonElement.getAsJsonObject().get("importeDesc").getAsString()));
					salesPost.setSdetDtaxBase(new BigDecimal(jsonElement.getAsJsonObject().get("baseImporte").getAsString()));
					salesPost.setSdetBincludeIgv(true);
					salesPost.setSdetDigv(new BigDecimal(jsonElement.getAsJsonObject().get("igv").getAsString()));
					salesPost.setSdetDgrossTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalBruto").getAsString()));
					salesPost.setSdetDnetTotal(new BigDecimal(jsonElement.getAsJsonObject().get("totalNeto").getAsString()));
					salesPost.setSdetVaffectionIndicator(jsonElement.getAsJsonObject().get("indicadorAfecto").getAsString());
					salesPost.setSdetVtypeAffectionIndicator(jsonElement.getAsJsonObject().get("tipoIndicadorAfecto").getAsString());
					salesPost.setSdetVobservation(jsonElement.getAsJsonObject().get("observacion").getAsString());
					salesPost.setSdetNdiscountValuePric(new BigDecimal(jsonElement.getAsJsonObject().get("precValorVentaDscto").getAsString()));
					salesPost.setSdetNigvdescuPric(new BigDecimal(jsonElement.getAsJsonObject().get("precIgvVentaDscto").getAsString()));
					salesPost.setSdetNdiscountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
					salesPost.setSdetDdiscountAmountPrice(new BigDecimal(jsonElement.getAsJsonObject().get("precPrecioVentaDscto").getAsString()));
					salesPost.setSdetTregistrationDate(new Date());
					salesPost.setSdetTdateUpdate(new Date());//Cambiara en el Update de Ventas
					salesPost.setSdetBuserModify(new Long(user.getPersBident()));//Cambiara para el Update de Ventas
					salesPost.setSdetBuserCreate(new Long(user.getPersBident()));
					salesPost.setStoreBident(new Long(jsonElement.getAsJsonObject().get("codigoAlmacen").getAsString()));
					
					if(null!=tipoComprobante && !tipoComprobante.equals("")) {
						if(tipoComprobante.equals("07") || tipoComprobante.equals("08")) {
							salesPost.setSdetCflagNote(Constantes.flagNotaEstado.ACTIVO.getCode());
						} else {
							salesPost.setSdetCflagNote(Constantes.flagNotaEstado.INACTIVO.getCode());
						}
					}
					
					try {						
						salesPost.setSdetVtypeCoinOrigin(jsonElement.getAsJsonObject().get("tipoMonedaOrigen").getAsString());
						salesPost.setSdetVtypeCoinCurrency(jsonElement.getAsJsonObject().get("tipoMonedaDestino").getAsString());
					}catch(Exception e) {
						logger.error("Ocurrio un error, al tipo moneda origen y/o destino");
					}
					try {
						salesPost.setSdetDamountExchangeSales(new BigDecimal(jsonElement.getAsJsonObject().get("tipoCambioVenta").getAsString()));
						salesPost.setSdetDcurrencyConversion(new BigDecimal(jsonElement.getAsJsonObject().get("tipoConversion").getAsString()));
					}catch(Exception e) {
						salesPost.setSdetDamountExchangeSales(new BigDecimal("0.00"));
						salesPost.setSdetDcurrencyConversion(new BigDecimal("0.00"));
					}
					//salesPost.setSdetDtotalDiscount(new BigDecimal(jsonElement.getAsJsonObject().get("").getAsString()));//agregar monto total de descuento
					salesPost.setSdetDtotalDiscount(new BigDecimal("0.00"));//agregar monto total de descuento
					salesDatail.add(salesPost);
				}
				
				sales.setDetalle(salesDatail);
				
				Gson gson = new Gson();
				String data = gson.toJson(sales);
				System.out.println("ver json_: "+data);
				
				robject.addProperty("msg", "ok");
//				robject.addProperty("nroC", rpta.getNroDoc());
//				robject.addProperty("serieC", rpta.getSerieDoc());
//				robject.addProperty("voucEstadoSunat",
//						vistaCompro.getEstadoSunat() != null
//								? (vistaCompro.getEstadoSunat().equals("0") ? "1" : "0")
//								: "");
//				
//				robject.addProperty("idVenta", rpta.getSales().getSaleBident());
////				}
				return new Gson().toJson(robject);

			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);

			}

		}
		@RequestMapping(value = "/calcularAnticipo", method = RequestMethod.POST)
		@ResponseBody
		public String calcularAnticipo(HttpSession ses, HttpServletRequest rq, 
				@RequestParam String monto,@RequestParam String indicadorAfecto) throws IOException {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			BigDecimal valorprecio;
			BigDecimal igvunitario;
			BigDecimal igvVtaTotalDscto;
			BigDecimal precioVtaTotalDscto;
			BigDecimal valorVenta;
			BigDecimal igvVenta;
			BigDecimal precioVenta;
			DecimalFormat df = new DecimalFormat("#.##", simbolos);			
			JsonObject robject = new JsonObject();
			logger.info("Monto de anticipos "+monto);
			BigDecimal montoTotal= new BigDecimal(monto).multiply(new BigDecimal(1.00));
			try {
				HashMap<String, Object> obj = new HashMap<String, Object>();
				if (!indicadorAfecto.equals("") && indicadorAfecto.equals("10")) {
					obj.put("precioUnitario", df.format(montoTotal));
					valorprecio = montoTotal.divide(new BigDecimal(1.18), 5, RoundingMode.CEILING);
					obj.put("valorUnitario", df.format(valorprecio));	
					igvunitario = montoTotal.subtract(valorprecio);
					obj.put("igvUnitario", df.format(igvunitario));					
					obj.put("valorVenta", df.format(valorprecio.multiply(new BigDecimal(1))));
					obj.put("igvVenta", df.format(igvunitario.multiply(new BigDecimal(1))));
					obj.put("precioVenta", df.format(montoTotal.multiply(new BigDecimal(1))));
					obj.put("porcentaDesc", df.format(ObjectUtils.defaultIfNull(0.00, new BigDecimal(0.00))));
					obj.put("importeDesc", "0.00");
					obj.put("precValorVentaDscto", df.format(0.00));
					obj.put("precIgvVentaDscto", df.format(0.00));
					obj.put("precPrecioVentaDscto", df.format(0.00));
					obj.put("baseImporte", df.format(valorprecio));
					igvVtaTotalDscto = valorprecio.multiply(new BigDecimal(0.18));
					obj.put("igv", df.format(igvVtaTotalDscto));
					precioVtaTotalDscto = valorprecio.add(igvVtaTotalDscto);
					obj.put("totalBruto", df.format(precioVtaTotalDscto));
					obj.put("totalNeto", df.format(precioVtaTotalDscto));
					obj.put("preciodescripcion", "Anticipo");
					obj.put("preciodescripcionproducto", "PrecioEditado");
					obj.put("preciodescripcion","0");
					obj.put("esprecioprincipal",false);
				} else if (!indicadorAfecto.equals("") && indicadorAfecto.equals("50")) {
					obj.put("precioUnitario", df.format(montoTotal));
					valorprecio = montoTotal.divide(new BigDecimal(1.18), 5, RoundingMode.CEILING);
					obj.put("valorUnitario", df.format(valorprecio));	
					igvunitario = montoTotal.subtract(valorprecio);
					obj.put("igvUnitario", df.format(igvunitario));
					valorVenta = montoTotal.multiply(new BigDecimal(0.00));
					obj.put("valorVenta", df.format(valorVenta));
					igvVenta = igvunitario.multiply(new BigDecimal(0.00));
					obj.put("igvVenta", df.format(igvVenta));
					precioVenta = valorprecio.multiply(new BigDecimal(0.00));
					obj.put("precioVenta", df.format(precioVenta));
					obj.put("porcentaDesc", df.format(0.00));
					obj.put("importeDesc", df.format(0.00));
					obj.put("precValorVentaDscto", valorVenta);
					obj.put("precIgvVentaDscto", igvVenta);
					obj.put("precPrecioVentaDscto", precioVenta);
					obj.put("baseImporte", df.format(valorVenta));
					obj.put("igv", df.format(igvVenta));
					obj.put("totalBruto", df.format(0.00));
					obj.put("totalNeto", df.format(0.00));
					obj.put("preciodescripcionproducto", "PrecioEditado");
					obj.put("preciodescripcion","0");
					obj.put("esprecioprincipal",false);
				} else {
					obj.put("valorUnitario", df.format(montoTotal));
					obj.put("igvUnitario", df.format(0.00));
					obj.put("precioUnitario", df.format(montoTotal));
					obj.put("valorVenta", df.format(montoTotal.multiply(new BigDecimal(0.00))));
					obj.put("igvVenta", df.format(0.00));
					obj.put("precioVenta", df.format(montoTotal.multiply(new BigDecimal(0.00))));
					obj.put("porcentaDesc", df.format(0.00));
					obj.put("importeDesc", df.format(0.00));
					obj.put("precValorVentaDscto", df.format(0.00));
					obj.put("precIgvVentaDscto", df.format(0.00));
					obj.put("precPrecioVentaDscto", df.format(0.00));
					obj.put("baseImporte", df.format(montoTotal));
					obj.put("igv", df.format(0.00));
					obj.put("totalBruto", df.format(montoTotal));
					obj.put("totalNeto", df.format(montoTotal));
					obj.put("preciodescripcionproducto", "PrecioEditado");
					obj.put("preciodescripcion","0");
					obj.put("esprecioprincipal",false);
				}
				Gson gson = new Gson();
				String data = gson.toJson(obj);
				JsonElement jsonArray = new JsonParser().parse(data);
				robject.add("datos", jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);

			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
		
		@RequestMapping(value = "/obtenerAnticipos", method = RequestMethod.POST)
		@ResponseBody
		public String obtenerAnticipos(HttpSession ses, HttpServletRequest rq, 
				@RequestParam String tipoCPE,
				@RequestParam(value = "idSale", required = false) String idSale
				 ) throws IOException {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TSalesGet filtro =new TSalesGet();
			JsonObject robject = new JsonObject();
			try {
				ObjectMapper mapper = new ObjectMapper();
				filtro.setSaleVtypeVoucher(tipoCPE);
				filtro.setSaleTypeOperation("2");
				filtro.setSaleTypeAnticipo("1");
				if(idSale!=null) {
					if(idSale.equals("")) {
						robject.addProperty("msg", "vacio");
						return new Gson().toJson(robject);
					}
					filtro.setSaleBident(new Long(idSale));
				}
				filtro.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				PaginaResultado<TSales> rspTsales=ventasRest.getSale(filtro, beanDS);
				List<TSales> lstTsales = new ArrayList<TSales>();
				lstTsales = Arrays.asList(mapper.convertValue(rspTsales.getResultados(), TSales[].class));
				HashMap<String, Object> objLP = null;
				List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
				for (TSales tSales : lstTsales) {
					if(tSales.getSaleTotalDisponibleAnticipo().compareTo(BigDecimal.ZERO)>0) {
						objLP = new HashMap<String, Object>();
						objLP.put("saleBident", tSales.getSaleBident().toString());
						objLP.put("saleVserieVoucher", tSales.getSaleVserieVoucher());
						objLP.put("saleVnumberVoucher", tSales.getSaleVnumberVoucher());
						objLP.put("saleTregistrationDate", Util.datetoString5(tSales.getSaleTregistrationDate()));
						objLP.put("saleTotalAnticipo", tSales.getSaleTotalAnticipo());
						objLP.put("saleTotalDisponibleAnticipo", tSales.getSaleTotalDisponibleAnticipo());
						objListaLP.add(objLP);
					}
				}
				Gson gson = new Gson();
				String data = gson.toJson(objListaLP);
				JsonElement jsonArray = new JsonParser().parse(data);
				robject.add("toption", jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);
			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
		
		@RequestMapping(value = "/obtenerAnticiposGrilla", method = RequestMethod.POST)
		@ResponseBody
		public String obtenerAnticiposGrilla(HttpSession ses, HttpServletRequest rq, 
				@RequestParam(value = "idSale", required = true) String idSale,
				@RequestParam(value = "tipoCPE", required = true) String tipoCPE,
				@RequestParam(value = "montoUtilizar", required = true) String montoUtilizar
				 ) throws IOException {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TSalesGet filtro =new TSalesGet();
			JsonObject robject = new JsonObject();
			try {
				ObjectMapper mapper = new ObjectMapper();
				filtro.setSaleBident(new Long(idSale));
				filtro.setPaginacion(new PaginacionFiltro(1, 1));
				PaginaResultado<TSales> rspTsales=ventasRest.getSale(filtro, beanDS);
				List<TSales> lstTsales = new ArrayList<TSales>();
				lstTsales = Arrays.asList(mapper.convertValue(rspTsales.getResultados(), TSales[].class));
				HashMap<String, Object> objLP = null;
				List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
				for (TSales tSales : lstTsales) {
					if(tSales.getSaleTotalDisponibleAnticipo().compareTo(BigDecimal.ZERO)>0) {
						objLP = new HashMap<String, Object>();
						objLP.put("idCPE", tSales.getSaleBident().toString());
						objLP.put("tipoCPE", tipoCPE);
						objLP.put("serie", tSales.getSaleVserieVoucher());
						objLP.put("numero", tSales.getSaleVnumberVoucher());
						objLP.put("fecha", Util.datetoString5(tSales.getSaleTregistrationDate()));
						objLP.put("valor", tSales.getSaleDvaluetotal());
						objLP.put("igv", tSales.getSaleDigv());
						objLP.put("total", tSales.getSaleTotalAnticipo());
						objLP.put("montoutilizar", montoUtilizar);
						objLP.put("montopendiente", tSales.getSaleTotalDisponibleAnticipo().subtract(new BigDecimal(montoUtilizar)));
						objListaLP.add(objLP);
					}
				}
				Gson gson = new Gson();
				String data = gson.toJson(objListaLP);
				JsonElement jsonArray = new JsonParser().parse(data);
				robject.add("datos", jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Error al Conectar con el microservicio");
				return new Gson().toJson(robject);
			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
		
		@RequestMapping(value = "/calcularSaldoDisponible", method = RequestMethod.POST)
		@ResponseBody
		public String calcularSaldoDisponible(HttpSession ses, HttpServletRequest rq, 
				@RequestParam(value = "saldoDisponible", required = true) String saldoDisponible,
				@RequestParam(value = "saldoUtilizar", required = true) String saldoUtilizar
				 ) throws IOException {
			JsonObject robject = new JsonObject();
			try {
				BigDecimal resultado=new BigDecimal(saldoDisponible).subtract(new BigDecimal(saldoUtilizar));
				if(new BigDecimal(saldoUtilizar).compareTo(new BigDecimal(saldoDisponible))== 1){
					robject.addProperty("msg", "error");
					robject.addProperty("respuesta", "<label class='text-danger'>ALERTA : <br> El monto utilizar es mayor que el monto disponible</label>");
					return new Gson().toJson(robject);
				}
				robject.addProperty("resultado", Util.formatoMoneda(resultado));
			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "<label class='text-danger'>ALERTA : <br> Error al realizar el calculo</label>");
				return new Gson().toJson(robject);
			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
		
		@RequestMapping(value = "/restarMontoTotalAnticipo", method = RequestMethod.POST)
		@ResponseBody
		public String restarMontoTotalAnticipo(HttpSession ses, HttpServletRequest rq, 
				@RequestParam(value = "montoAnticipo", required = true) String montoAnticipo,
				@RequestParam(value = "montoTotal", required = true) String montoTotal
				 ) throws IOException {
			JsonObject robject = new JsonObject();
			try {
						
				BigDecimal resultado=new BigDecimal(montoTotal).subtract(new BigDecimal(montoAnticipo));
				if(new BigDecimal(montoAnticipo).compareTo(new BigDecimal(montoTotal))== 1){
					robject.addProperty("msg", "error");
					robject.addProperty("respuesta", "<label class='text-danger'>ALERTA : <br> El monto Anticipo es mayor que el monto total</label>");
					return new Gson().toJson(robject);
				}
				robject.addProperty("resultado", Util.formatoMoneda(resultado));
			} catch (Exception e) {
				e.printStackTrace();
				robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "<label class='text-danger'>ALERTA : <br> Error al realizar el calculo</label>");
				return new Gson().toJson(robject);
			}
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		}
		
}
