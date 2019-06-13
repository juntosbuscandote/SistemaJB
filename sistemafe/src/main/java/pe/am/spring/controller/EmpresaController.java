/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TAddressPersonPut;
import pe.am.spring.entity.TBusinessGroup;
import pe.am.spring.entity.TBusinessGroupGet;
import pe.am.spring.entity.TAddressPerson;
import pe.am.spring.entity.TAddressPersonGet;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TBussinesPut;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TCountry;
import pe.am.spring.entity.TCountryGet;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmailPersonPut;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TEmployeeGet;
import pe.am.spring.entity.TEmployeePost;
import pe.am.spring.entity.TEmployeePut;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TLegalPersonPut;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TPersonPut;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPhonePersonPut;
import pe.am.spring.entity.TSunat;
import pe.am.spring.entity.TUbigeo;
import pe.am.spring.entity.TUbigeoGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserGet;
import pe.am.spring.entity.TUserPost;
import pe.am.spring.entity.TUserPut;
import pe.am.spring.entity.TPhonePerson;
import pe.am.spring.entity.TPhonePersonGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.AddressPersonRest;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.EmailPersonRest;
import pe.am.spring.rest.EmailRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.NaturalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.PhonePersonRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.service.PersonaService;
import pe.am.spring.rest.CatalogueRest;

import pe.am.spring.entity.Archivo;
import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.CorreoPersona;
import pe.am.spring.entity.EmailGet;
import pe.am.spring.entity.InsertBussines;
import pe.am.spring.entity.InsertRepresentLegal;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Security;
import pe.am.spring.util.Util;

import org.springframework.beans.BeanUtils;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	protected static Logger logger = Logger.getLogger(EmpresaController.class);

	@Autowired
	BussinesRest BussinesRest;

	@Autowired
	LegalPersonRest legalPersonRest;

	@Autowired
	PersonRest PersonRest;

	@Autowired
	EmailPersonRest emailPersonRest;

	@Autowired
	AddressPersonRest AddressPersonRest;

	@Autowired
	PhonePersonRest PhonePersonRest;

	@Autowired
	NaturalPersonRest NaturalPersonRest;

	@Autowired
	TUserRest UserRest;

	@Autowired
	CatalogueRest CatalogueRest;

	@Autowired
	EmailRest emailRest;

	@Autowired
	private BussinesRest bussinesRest;

	@Autowired
	private TUserRest tUserRest;

	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		String NombreVentana="Empresa";
		model.addObject("NombreVentana", NombreVentana);
		// validar sesion
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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

		// properties para microservicio de empresa
		String util = Util.getHostEmpresa();
		System.out.println(util);

		model.setViewName("/Empresa/Empresa");
		model=personaService.cargarPersona(model,beanDS);
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TBusinessGet filtro = new TBusinessGet();
			// filtro.setBusiVbusiname(busi_rs);
			// filtro.setBusiVruc(busi_vruc);
			// filtro.setBusiState(estado);
			// filtro.setPaginacion(new PaginacionFiltro(1, 1000));
			// PaginaResultado<TBusiness> response =
			// businessrest.getBusiness(filtro);
			// model.addObject("DtoEmpresa", response.getResultados());
			
			/*********************************************************************************************************/
			/*---------------------------     LISTA ESTADO DE EMPRESAS----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar estado de empresa de catalogue");
			TCatalogueDetGet filtrosestadoempresa = new TCatalogueDetGet();
			filtrosestadoempresa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosestadoempresa.setCataBident(new Long(42));
			filtrosestadoempresa.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatestado = CatalogueRest.getCatalogueDet(filtrosestadoempresa,beanDS);
			TCatalogueDet procataestado = new TCatalogueDet();
			List<TCatalogueDet> lstCatDocEstado= new ArrayList<>();
			for (Object catdetestado : responsescatestado.getResultados()) {
				procataestado= mapper.convertValue(catdetestado, TCatalogueDet.class);
				lstCatDocEstado.add(procataestado);
			}
			model.addObject("listaCatDetEstado", lstCatDocEstado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/lista_empresa", method = RequestMethod.POST)
	@ResponseBody
	public String getlistaEmpresa(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmEmpFiltroRazSocial", required = false) String frmEmpFiltroRazSocial,
			@RequestParam(value = "frmEmpFiltroRuc", required = false) String frmEmpFiltroRuc,
			@RequestParam(value = "frmEmpFiltroEstado", required = false) String frmEmpFiltroEstado) {
		System.out.println("===========Inicio-> empresa/lista_empresa ");

		String sStart = rq.getParameter("draw");
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

		try {

			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TBussinesFilterGet filtroLP = new TBussinesFilterGet();
			filtroLP.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			if (frmEmpFiltroRazSocial != null && !frmEmpFiltroRazSocial.isEmpty()) {
				filtroLP.setLegaBusiname(frmEmpFiltroRazSocial);
			}
			if (frmEmpFiltroRuc != null && !frmEmpFiltroRuc.isEmpty()) {
				filtroLP.setPersVnumdoc(frmEmpFiltroRuc);
			}
			if (frmEmpFiltroEstado != null && !frmEmpFiltroEstado.isEmpty()) {
				filtroLP.setEstado(frmEmpFiltroEstado);
			}

			System.out.println();

			// BussinesRest
			PaginaResultado<TBussinesFilter> responseLG = BussinesRest.getBussinesFilter(filtroLP,beanDS);
			// .queryParam("idPlan", 1)

			List<TBussinesFilter> LstdoEmpreLP = null;
			if (responseLG.getCantidad() > 0) {
				LstdoEmpreLP = responseLG.getResultados();
			}
			List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapperLP = new ObjectMapper();
			HashMap<String, Object> objLP = null;
			if (LstdoEmpreLP != null) {
				for (Object objsLP : LstdoEmpreLP) {
					TBussinesFilter vistaEmpreLP = mapperLP.convertValue(objsLP, TBussinesFilter.class);
					objLP = new HashMap<String, Object>();
					objLP.put("busiVruc", ObjectUtils.defaultIfNull(vistaEmpreLP.getPersVnumdoc(), ""));
					objLP.put("busiVbusiname", ObjectUtils.defaultIfNull(vistaEmpreLP.getLegaBusiname(), ""));
					objLP.put("busiVaddress", ObjectUtils.defaultIfNull(vistaEmpreLP.getAddrVaddress(), ""));
					objLP.put("busiVemail", ObjectUtils.defaultIfNull(vistaEmpreLP.getMailVemail(), ""));
					objLP.put("busiVphone", ObjectUtils.defaultIfNull(vistaEmpreLP.getPhonVphone(), ""));
					objLP.put("busiState", ObjectUtils.defaultIfNull(vistaEmpreLP.getEstado(), ""));
					objListaLP.add(objLP);
				}
				System.out.println(objListaLP.size());
			}

			JsonObject robjectLP = new JsonObject();
			Gson gsonLP = new Gson();
			String dataLP = gsonLP.toJson(objListaLP);
			JsonArray jsonArrayLP = new JsonParser().parse(dataLP).getAsJsonArray();
			robjectLP.addProperty("draw", sStart);
			robjectLP.addProperty("recordsTotal", responseLG.getCantidad());
			robjectLP.addProperty("recordsFiltered", responseLG.getCantidad());
			robjectLP.add("data", jsonArrayLP);
			return new Gson().toJson(robjectLP);

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

	@RequestMapping(value = "/validRuc", method = RequestMethod.POST)
	@ResponseBody
	public String validRuc(@RequestParam("ruc") String ruc, HttpServletRequest request, ModelAndView model,
			HttpSession ses) {
		logger.info("Validar Ruc : " + ruc);
		String url = "";
		JsonObject jReturn = new JsonObject();
		TPerson bTUser = new TPerson();
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		// "0";"EN PROCESO"
		// "1";"PROCESADO CORRECTAMENTE"
		// "2";"OCURRIO UN ERROR"
		try {
			TPersonGet bussGet = new TPersonGet();
			bussGet.setPersVnumdoc(ruc);
			bussGet.setPaginacion(new PaginacionFiltro(1, 1));
			PaginaResultado<TPerson> persList = PersonRest.getPerson(bussGet,beanDS);
			logger.info("Persona a buscar  : " + ruc);
			if (persList.getCantidad() > 0) {
				logger.info("Persona a buscar  : " + persList.getCantidad());
				bTUser = mapper.convertValue(persList.getResultados().get(0), TPerson.class);
				jReturn.addProperty("estado", "0");
				jReturn.addProperty("msg", "Existe una empresa registrada con el mismo RUC");
			} else {
				TSunat tSunat = personaService.consultarsunat(ruc,beanDS);
				if (tSunat != null) {
					// obtener ubigeo
					TUbigeoGet filtroUbigeo = new TUbigeoGet();
					filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroUbigeo.setUbigInei(tSunat.getUbigeo());
					PaginaResultado<TUbigeo> respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
					TUbigeo ubigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
					jReturn.addProperty("idubigeo", ubigeo.getUbigIident());
					jReturn.addProperty("rspsunat", "1");
					jReturn.addProperty("tipoPerson", tSunat.getTipoPersona());
					jReturn.addProperty("razonSocial", tSunat.getNombre());
					jReturn.addProperty("direccion", tSunat.getDireccion().replaceAll("-", "").trim());
					jReturn.addProperty("estadoSunat", tSunat.getEstado());
					jReturn.addProperty("estadoColor",
							tSunat.getEstado().equals("ACTIVO") ? "alert alert-success" : "alert alert-danger");
					jReturn.addProperty("condicionDomicilio", tSunat.getCondicionDomicilio());
					jReturn.addProperty("condicionDomicilioColor",
							tSunat.getCondicionDomicilio().equals("HABIDO") ? "alert alert-success"
									: "alert alert-danger");
				} else {
					jReturn.addProperty("rspsunat", "2");
				}
				jReturn.addProperty("estado", "1");
			}

		} catch (Exception e) {
			jReturn.addProperty("estado", "2");
			jReturn.addProperty("msg", "Se produjo un error interno en los servicios");
			e.printStackTrace();
		}
		// seteando en sesion al usuario
		// redirigiendo a la pantalla por default
		// url = "facturacionelectronica/"; // borrar despues de validar login
		// url="empresa/"; // borrar despues de validar login
		jReturn.addProperty("url", url);
		return new Gson().toJson(jReturn);

	}

	@RequestMapping(value = "/validRepreLegal", method = RequestMethod.POST)
	@ResponseBody
	public String validRepreLegal(@RequestParam("numDoc") String numDoc, @RequestParam("tipoDoc") String tipoDoc,
			HttpServletRequest request, ModelAndView model, HttpSession ses) {
		ObjectMapper mapper = new ObjectMapper();
		TPerson repreLegal = new TPerson();
		TNaturalPerson tNaturalPerson = new TNaturalPerson();
		TEmailPerson tEmailPerson = new TEmailPerson();
		TPhonePerson tPhonePerson = new TPhonePerson();
		TAddressPerson tAddressPerson = new TAddressPerson();
		JsonObject robject = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

		/**
		 * 0:no existe el representante legal 1:existe el representante legal
		 */

		/** -- BUSCA REPRESENTANTE LEGAL - */
		try {
			TPersonGet filtro = new TPersonGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setPersVnumdoc(numDoc);
			filtro.setPersVdoctype(tipoDoc);
			PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
			if (response.getCantidad() > 0) {
				repreLegal = mapper.convertValue(response.getResultados().get(0), TPerson.class);
				/** -- BUSCA DATOS DEL REPRESENTANTE LEGAL - */
				TNaturalPersonGet FiltroNaturalPersonGetRL = new TNaturalPersonGet();
				FiltroNaturalPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
				FiltroNaturalPersonGetRL.setNatuBident(repreLegal.getNatuBident());
				PaginaResultado<TNaturalPerson> responseTNaturalPersonRL = NaturalPersonRest
						.getNaturalPerson(FiltroNaturalPersonGetRL,beanDS);
				tNaturalPerson = mapper.convertValue(responseTNaturalPersonRL.getResultados().get(0),
						TNaturalPerson.class);
				/** -- BUSCA CORREO DEL REPRESENTANTE LEGAL - */
				TEmailPersonGet FiltroEmailPersonGetEmpresa = new TEmailPersonGet();
				FiltroEmailPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
				FiltroEmailPersonGetEmpresa.setPersBident(repreLegal.getPersBident());
				PaginaResultado<TEmailPerson> responseTEmailPersonEmpresa = emailPersonRest
						.getEmailPerson(FiltroEmailPersonGetEmpresa,beanDS);
				tEmailPerson = mapper.convertValue(responseTEmailPersonEmpresa.getResultados().get(0),
						TEmailPerson.class);
				/** -- BUSCA TELEFONO DEL REPRESENTANTE LEGAL - */
				TPhonePersonGet FiltroPhonePersonGetEmpresa = new TPhonePersonGet();
				FiltroPhonePersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
				FiltroPhonePersonGetEmpresa.setPersBident(repreLegal.getPersBident());
				PaginaResultado<TPhonePerson> responseTPhonePersonEmpresa = PhonePersonRest
						.getPhonePerson(FiltroPhonePersonGetEmpresa,beanDS);
				tPhonePerson = mapper.convertValue(responseTPhonePersonEmpresa.getResultados().get(0),
						TPhonePerson.class);
				/** -- BUSCA DIRECCION DEL REPRESENTANTE LEGAL - */
				TAddressPersonGet filtroTAddressPersonGet = new TAddressPersonGet();
				filtroTAddressPersonGet.setPaginacion(new PaginacionFiltro(1, 1));
				filtroTAddressPersonGet.setPersBident(repreLegal.getPersBident());
				PaginaResultado<TAddressPerson> rspTAddressPerson = AddressPersonRest
						.getAddressPerson(filtroTAddressPersonGet,beanDS);
				tAddressPerson = mapper.convertValue(rspTAddressPerson.getResultados().get(0), TAddressPerson.class);
				/** -- RETORNA INFORMACION DEL REPRESENTANTE LEGAL - */
				robject.addProperty("nombre", tNaturalPerson.getNatuVname());
				robject.addProperty("aptPaterno", tNaturalPerson.getNatuVlastnamefather());
				robject.addProperty("aptMaterno", tNaturalPerson.getNatuVlastnamemother());
				robject.addProperty("email", tEmailPerson.getMailVemail());
				robject.addProperty("telefono", tPhonePerson.getPhonVphone());
				robject.addProperty("persBident", repreLegal.getPersBident());
				robject.addProperty("address", tAddressPerson.getAddrVaddress());

				robject.addProperty("naturalVtradename", repreLegal.getPersVtradename());
				robject.addProperty("naturalVtipoPerson", repreLegal.getPersVdomiciled());
				robject.addProperty("naturalVpais", repreLegal.getPersBcodcountry());
				robject.addProperty("naturalVlocalidad", repreLegal.getPersVubigeo());

				robject.addProperty("msg", "1");
			} else {
				if (tipoDoc.equals("6")) {
					TSunat tSunat = personaService.consultarsunat(numDoc,beanDS);
					if (tSunat != null) {
						// obtener ubigeo
						TUbigeoGet filtroUbigeo = new TUbigeoGet();
						filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
						filtroUbigeo.setUbigInei(tSunat.getUbigeo());
						PaginaResultado<TUbigeo> respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
						TUbigeo ubigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
						robject.addProperty("idubigeo", ubigeo.getUbigIident());
						robject.addProperty("rspsunat", "1");
						robject.addProperty("tipoPerson", tSunat.getTipoPersona());
						String nombre = tSunat.getNombre();
						String apetPat = "";
						String apetMat = "";
						apetPat = nombre.substring(0, nombre.indexOf(' '));
						nombre = nombre.substring(nombre.indexOf(' ') + 1, nombre.length());
						apetMat = nombre.substring(0, nombre.indexOf(' '));
						nombre = nombre.substring(nombre.indexOf(' ') + 1, nombre.length());
						robject.addProperty("nombre", nombre);
						robject.addProperty("apetpat", apetPat);
						robject.addProperty("apetmat", apetMat);
						robject.addProperty("direccion", tSunat.getDireccion().replaceAll("-", "").trim());
						robject.addProperty("estadoSunat", tSunat.getEstado());
						robject.addProperty("estadoColor",
								tSunat.getEstado().equals("ACTIVO") ? "alert alert-success" : "alert alert-danger");
						robject.addProperty("condicionDomicilio", tSunat.getCondicionDomicilio());
						robject.addProperty("condicionDomicilioColor",
								tSunat.getCondicionDomicilio().equals("HABIDO") ? "alert alert-success"
										: "alert alert-danger");
					} else {
						robject.addProperty("rspsunat", "2");
					}
				} else {
					robject.addProperty("rspsunat", "3");
				}

				robject.addProperty("msg", "0");
			}
		} catch (ServiceLogicException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Gson().toJson(robject);
	}

	@RequestMapping(value = "/configuraciongeneral")
	public ModelAndView listConfiguracionGeneral(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		String NombreVentana="Configuración Empresa";
		model.addObject("NombreVentana", NombreVentana);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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
		model.addObject("fProcess", "save");
		model.setViewName("/Empresa/ConfiguracionGeneral");
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			
			//azevallos - obteniendo los grupos comerciales
			TBusinessGroupGet filtro = new TBusinessGroupGet();
			filtro.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtro.setBusgrBstate(Constantes.estadoGC.HABILITADO.getCode());
			PaginaResultado<TBusinessGroup> response = new PaginaResultado<>();
			List<TBusinessGroup> lstGrupoCom = new ArrayList<>();
			try {
				response = tUserRest.getGrupoComer(filtro, beanDS);
				if (null!=response && response.getCantidad()>0) {
					mapper = new ObjectMapper();
					for (Object catdet : response.getResultados()) {
						TBusinessGroup procata = mapper.convertValue(catdet, TBusinessGroup.class);
						lstGrupoCom.add(procata);
					}
					model.addObject("lstGrupoCom", lstGrupoCom);
				} else {
					logger.info("No encontro el Grupo Comercial");
				}

			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();

			}
			
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet procata = new TCatalogueDet();
			List<TCatalogueDet> lstCatDoc = new ArrayList<>();
			for (Object catdet : responsescat.getResultados()) {
				procata = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatDoc.add(procata);
			}
			model.addObject("listaCatDet", lstCatDoc);
			// obtener ubigeo
			TUbigeoGet filtroUbigeo = new TUbigeoGet();
			filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
			List<TUbigeo> lstUbigeo = new ArrayList<TUbigeo>();
			for (Object tUbigeo : respUbigeo.getResultados()) {
				TUbigeo ubigeo = mapper.convertValue(tUbigeo, TUbigeo.class);
				lstUbigeo.add(ubigeo);
			}
			model.addObject("lstUbigeo", lstUbigeo);
			// obtener pais
			TCountryGet filtroCountry = new TCountryGet();
			filtroCountry.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCountry.setCounBstate(true);
			PaginaResultado<TCountry> respCountry = CatalogueRest.getCountry(filtroCountry,beanDS);
			List<TCountry> lstCountry = new ArrayList<TCountry>();
			for (Object tCountry : respCountry.getResultados()) {
				TCountry country = mapper.convertValue(tCountry, TCountry.class);
				lstCountry.add(country);
			}
			model.addObject("lstCountry", lstCountry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;

	}

	// INSERTAR EMPRESA LHUAMAND

	@RequestMapping(value = "/InsertarEmpresa", method = RequestMethod.POST)
	@ResponseBody
	public String InsertarEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "pers_vnumdoc", required = false) String pers_vnumdoc,
			@RequestParam(value = "pers_vtradename", required = false) String pers_vtradename,
			@RequestParam(value = "lega_businame", required = false) String lega_businame,
			@RequestParam(value = "mail_vmail", required = false) String mail_vmail,
			@RequestParam(value = "addr_vaddress", required = false) String addr_vaddress,
			@RequestParam(value = "phon_vphone", required = false) String phon_vphone,
			@RequestParam(value = "pers_vdoctype", required = false) String pers_vdoctype,
			@RequestParam(value = "pers_vnumdoc_repleg", required = false) String pers_vnumdoc_repleg,
			@RequestParam(value = "natu_vname", required = false) String natu_vname,
			@RequestParam(value = "natu_vlastnamefather", required = false) String natu_vlastnamefather,
			@RequestParam(value = "natu_vlastnamemother", required = false) String natu_vlastnamemother,
			@RequestParam(value = "mail_vmail_repleg", required = false) String mail_vmail_repleg,
			@RequestParam(value = "pers_bidentUser", required = false) String pers_bidentUser,
			@RequestParam(value = "phon_vphone_repleg", required = false) String phon_vphone_repleg,
			@RequestParam(value = "validRepreLegal", required = false) String validRepreLegal,
			@RequestParam(value = "persBident", required = false) String persBident,
			@RequestParam(value = "addr_vaddress_repleg", required = false) String addr_vaddress_repleg,
			@RequestParam(value = "legal_vpais", required = false) String legal_vpais,
			@RequestParam(value = "legal_vlocalidad", required = false) String legal_vlocalidad,
			@RequestParam(value = "legal_vtipoPerson", required = false) String legal_vtipoPerson,

			@RequestParam(value = "natural_vtradename", required = false) String natural_vtradename,
			@RequestParam(value = "natural_vtipoPerson", required = false) String natural_vtipoPerson,
			@RequestParam(value = "natural_vpais", required = false) String natural_vpais,
			@RequestParam(value = "natural_vlocalidad", required = false) String natural_vlocalidad,
			@RequestParam(value = "legal_vgrupoCom", required = false) String legal_vgrupoCom) {
		JsonObject robject = new JsonObject();
		try {
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			ObjectMapper mapper = new ObjectMapper();
			List<InsertBussines> LstInsertBussines = new ArrayList<InsertBussines>();
			InsertBussines insertBussines = new InsertBussines();
			insertBussines.setPers_vnumdoc(pers_vnumdoc);
			insertBussines.setPers_vtradename(pers_vtradename.toUpperCase());
			insertBussines.setLega_businame(lega_businame.toUpperCase());
			insertBussines.setMail_vmail(mail_vmail);
			insertBussines.setAddr_vaddress(addr_vaddress);
			insertBussines.setPhon_vphone(phon_vphone);
			insertBussines.setPers_vdoctype(pers_vdoctype);
			insertBussines.setPers_vnumdoc_repleg(pers_vnumdoc_repleg);
			insertBussines.setNatu_vname(natu_vname.toUpperCase());
			insertBussines.setNatu_vlastnamefather(natu_vlastnamefather.toUpperCase());
			insertBussines.setNatu_vlastnamemother(natu_vlastnamemother.toUpperCase());
			insertBussines.setMail_vmail_repleg(mail_vmail_repleg);
			insertBussines.setPers_bidentUser(pers_bidentUser);
			insertBussines.setPhon_vphone_repleg(phon_vphone_repleg);
			insertBussines.setValidRepreLegal(validRepreLegal);
			insertBussines.setHashpers_vnumdoc_repleg(Security.generateHash(pers_vnumdoc_repleg));
			insertBussines.setAddr_vaddress_repleg(addr_vaddress_repleg);
			insertBussines.setLegalVlocalidad(legal_vlocalidad);
			insertBussines.setLegalVpais(legal_vpais);
			insertBussines.setLegalVtipoPerson(legal_vtipoPerson);

			insertBussines.setNaturalVtradename(natural_vtradename);
			insertBussines.setNaturalVtipoPerson(natural_vtipoPerson);
			insertBussines.setNaturalVpais(natural_vpais);
			insertBussines.setNaturalVlocalidad(natural_vlocalidad);
			if (persBident != null && !persBident.equals("null")) {
				insertBussines.setPersBident(new Long(persBident));
			}
			
			insertBussines.setGrupoComercial(legal_vgrupoCom);
			
			LstInsertBussines.add(insertBussines);
			LstInsertBussines = PersonRest.postCrearEmpresa(LstInsertBussines,beanDS);
			InsertBussines objInsertBussines = mapper.convertValue(LstInsertBussines.get(0), InsertBussines.class);
			robject.addProperty("user", objInsertBussines.getVuser());
			// azevallos - crear el directorio para los documentos en el sistema
			try {
				File folder = new File(Constantes.RUTA_FILES_SUNAT_EMPRESA_INI + pers_vnumdoc + "/"
						+ Constantes.RUTA_FILES_SUNAT_EMPRESA_FIN);
				if (!folder.exists()) {
					// si no existe crearlo
					folder.mkdirs();
					System.out.println("Se creo la carpeta para la empresa satisfactoriamente");
				} else {
					System.out.println("Ya tiene una carpeta configurada la empresa");
				}

				folder = new File(Constantes.RUTA_FILES_VENTA_EMPRESA_INI + pers_vnumdoc + "/"
						+ Constantes.RUTA_FILES_VENTA_EMPRESA_FIN);
				if (!folder.exists()) {
					// si no existe crearlo
					folder.mkdirs();
					System.out.println("Se creo la carpeta para la empresa satisfactoriamente");
				} else {
					System.out.println("Ya tiene una carpeta configurada la empresa");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception ex) {
			logger.error("Ocurrio un error en InsertarEmpresa");
			ex.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}

		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	@RequestMapping(value = "/enviarcorreo", method = RequestMethod.POST)
	@ResponseBody
	public String enviarCorreo(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "correo_rl", required = false, defaultValue = "") String correo_rl,
			@RequestParam(value = "emp_nombre", required = false) String emp_nombre,
			@RequestParam(value = "user_rl", required = false) String user_rl,
			@RequestParam(value = "contra", required = false) String contra) {
		System.out.println("===========Inicio-> envio credencial nuevo usuario");

		try {
			EmailGet correoRptaSunat = new EmailGet();
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

			List<CorreoPersona> listaTo = new ArrayList<>();
			listaTo.add(new CorreoPersona(correo_rl, ""));

			correoRptaSunat.setTo(listaTo);
			correoRptaSunat.setTituloMensaje("Bienvenido al Sistema de busqueda de personas BuscandoJuntos");
			String cuerpoMensaje = "<!DOCTYPE html>\n"
					+ "<html lang=\"en\">     <head>         <meta charset=\"utf-8\">         \n" + "<body>  \n"
					+ "<div style=\"color: #2e6c80; text-align: center\"><img src=\"http://aymasesoresperu.dyndns.org:8085/files/logo.png\" width=\"286\" height=\"96\"></div>\n"
					+ "\n" + "  <br>\n"
					+ "<h1 style=\"color: #2e6c80; text-align: center;\">Bienvenido a la Familia de Asesores Contables A&M S.A.C</h1>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: left;\">Srs. : <span style=\"color: #5e9ca0;\">"
					+ emp_nombre + "</span>.</h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">Es, para nosotros, muy grato dirigirnos a usted para hacerle llegar nuestro saludo y a la vez comunicarle que su adquisición de nuestro Sistema de Facturación Electrónica A&M ha sido completada de manera exitosa.</h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">A continuación le brindamos sus credenciales de acceso, las cuales están asociadas a los datos del representante legal de su organización, estas credenciales pueden ser usadas a partir de hoy:</h3>\n"
					+ " <h3 style=\"color: #2e6c80; text-align: center;\">"
					+ "Usuario: <span style=\"color: #5e9ca0;\">" + user_rl + "</span><br>\n"
					+ "  Contraseña: <span style=\"color: #5e9ca0;\">" + contra + "</span></h3>\n" + "\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">Quedamos a su disposición, ante cualquier duda y/o consulta sírvase a escribir al siguiente correo: <span style=\"color: #5e9ca0;\">soporte@asesorescontablesaym.com</span></h3>\n"
					+ "<p style=\"color: #2e6c80; text-align: center;\">Para ingresar al sistema haga click en el siguiente botón:</p>\n"
					+ "  <div style=\"color: #2e6c80; text-align: center\">"
					+ "<a href=\"http://aymasesoresperu.dyndns.org:8085/SistemaFE\">"
					+ "<img src=\"http://www.vallenatofm.com/wp-content/uploads/2015/05/boton-ir.png\" ></a>"
					+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html> ";

			correoRptaSunat.setCuerpoMensaje(cuerpoMensaje);

			List<Archivo> files = new ArrayList<>();

			// poner el archivo en la ruta que esta en el util
			Archivo fileXML = new Archivo();
			fileXML.setNombreArchivo(Constantes.archivosWP.CARTABIENVENIDA.getCode());
			fileXML.setContenidoArchivo(
					Util.encode(Util.getRutaWelcomePack() + Constantes.archivosWP.CARTABIENVENIDA.getCode()));
			files.add(fileXML);

			fileXML = new Archivo();
			fileXML.setNombreArchivo(Constantes.archivosWP.MANUALACCESO.getCode());
			fileXML.setContenidoArchivo(
					Util.encode(Util.getRutaWelcomePack() + Constantes.archivosWP.MANUALACCESO.getCode()));
			files.add(fileXML);

			fileXML = new Archivo();
			fileXML.setNombreArchivo(Constantes.archivosWP.MANUALPERFILUSUARIOEMPRESA.getCode());
			fileXML.setContenidoArchivo(Util
					.encode(Util.getRutaWelcomePack() + Constantes.archivosWP.MANUALPERFILUSUARIOEMPRESA.getCode()));
			files.add(fileXML);

			fileXML = new Archivo();
			fileXML.setNombreArchivo(Constantes.archivosWP.MANUALPERFILUSUARIOFINAL.getCode());
			fileXML.setContenidoArchivo(
					Util.encode(Util.getRutaWelcomePack() + Constantes.archivosWP.MANUALPERFILUSUARIOFINAL.getCode()));
			files.add(fileXML);

			correoRptaSunat.setFiles(files);

			try {
				emailRest.getVoucher(correoRptaSunat,beanDS);
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "ok");
				robject.addProperty("cod", "1");
				return new Gson().toJson(robject);
			} catch (Exception e) {
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Ocurrio un error");
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

	// INICIO ACTUALIZA EMPRESA LHUAMAND

	@RequestMapping(value = "/ActualizarEmpresa", method = RequestMethod.POST)
	@ResponseBody
	public String ActualizarEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "pers_vnumdoc", required = false) String pers_vnumdoc,
			@RequestParam(value = "pers_bidentE", required = false) String pers_bidentE,
			@RequestParam(value = "pers_bidentRL", required = false) String pers_bidentRL,
			@RequestParam(value = "lega_bident", required = false) String lega_bident,
			@RequestParam(value = "natu_bident", required = false) String natu_bident,
			@RequestParam(value = "pers_vtradename", required = false) String pers_vtradename,
			@RequestParam(value = "lega_businame", required = false) String lega_businame,
			@RequestParam(value = "mail_vmail", required = false) String mail_vmail,
			@RequestParam(value = "addr_vaddress", required = false) String addr_vaddress,
			@RequestParam(value = "phon_vphone", required = false) String phon_vphone,
			@RequestParam(value = "pers_vdoctype", required = false) String pers_vdoctype,
			@RequestParam(value = "pers_vnumdoc_repleg", required = false) String pers_vnumdoc_repleg,
			@RequestParam(value = "natu_vname", required = false) String natu_vname,
			@RequestParam(value = "natu_vlastnamefather", required = false) String natu_vlastnamefather,
			@RequestParam(value = "natu_vlastnamemother", required = false) String natu_vlastnamemother,
			@RequestParam(value = "mail_vmail_repleg", required = false) String mail_vmail_repleg,
			@RequestParam(value = "phon_vphone_repleg", required = false) String phon_vphone_repleg,
			@RequestParam(value = "pers_bidentUser", required = false) String pers_bidentUser,
			@RequestParam(value = "pers_tregistration_date", required = false) Date pers_tregistration_date,
			@RequestParam(value = "addr_vaddress_repleg", required = false) String addr_vaddress_repleg,
			@RequestParam(value = "legal_vpais", required = false) String legal_vpais,
			@RequestParam(value = "legal_vlocalidad", required = false) String legal_vlocalidad,

			@RequestParam(value = "natural_vtradename", required = false) String natural_vtradename,
			@RequestParam(value = "natural_vtipoPerson", required = false) String natural_vtipoPerson,
			@RequestParam(value = "natural_vpais", required = false) String natural_vpais,
			@RequestParam(value = "natural_vlocalidad", required = false) String natural_vlocalidad,
			@RequestParam(value = "legal_vgrupoCom", required = false) String legal_vgrupoCom) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {

			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA PERSONA       ----------------------------------------------*/
			/*********************************************************************************************************/
			TPersonGet filtro = new TPersonGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setLegaBident(new Long(lega_bident));
			filtro.setPersVnumdoc(pers_vnumdoc);
			filtro.setPersCperstype("L");
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
			TPerson empreJuri = new TPerson();
			if (response != null && response.getCantidad() > 0) {
				empreJuri = mapper.convertValue(response.getResultados().get(0), TPerson.class);
			}
			List<TPersonPut> lstTPersonPut = new ArrayList<TPersonPut>();
			TPersonPut tPersonPut = new TPersonPut();
			BeanUtils.copyProperties(empreJuri, tPersonPut);
			tPersonPut.setPersVtradename(pers_vtradename.toUpperCase());
			tPersonPut.setPersBuserModify(new Long(pers_bidentUser));
			tPersonPut.setPersBcodcountry(new Long(legal_vpais));
			tPersonPut.setPersVubigeo(legal_vlocalidad);
			lstTPersonPut.add(tPersonPut);
			PersonRest.putPerson(lstTPersonPut,beanDS);
			/*********************************************************************************************************/
			/*---------------------------   ACTUALIZA PERSONA JURIDICA   ----------------------------------------------*/
			/*********************************************************************************************************/
			TLegalPersonGet filtroLegalPerson = new TLegalPersonGet();
			filtroLegalPerson.setPaginacion(new PaginacionFiltro(1, 1));
			filtroLegalPerson.setLegaBident(empreJuri.getLegaBident());
			PaginaResultado<TLegalPerson> responseLegalPerson = legalPersonRest.getLegalPerson(filtroLegalPerson,beanDS);
			TLegalPerson tLegalPerson = new TLegalPerson();
			if (responseLegalPerson != null && responseLegalPerson.getCantidad() > 0) {
				tLegalPerson = mapper.convertValue(responseLegalPerson.getResultados().get(0), TLegalPerson.class);
			}
			List<TLegalPersonPut> lstTLegalPersonPut = new ArrayList<TLegalPersonPut>();
			TLegalPersonPut TLegalPerson = new TLegalPersonPut();
			BeanUtils.copyProperties(tLegalPerson, TLegalPerson);
			TLegalPerson.setLegaBusiname(lega_businame.toUpperCase());
			lstTLegalPersonPut.add(TLegalPerson);
			legalPersonRest.putLegalPerson(lstTLegalPersonPut,beanDS);
			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA EMAIL       ----------------------------------------------*/
			/*********************************************************************************************************/
			TEmailPersonGet FiltroEmailPersonGetEmpresa = new TEmailPersonGet();
			FiltroEmailPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroEmailPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TEmailPerson> responseTEmailPersonEmpresa = emailPersonRest
					.getEmailPerson(FiltroEmailPersonGetEmpresa,beanDS);
			TEmailPerson tEmailPerson = new TEmailPerson();
			if (responseTEmailPersonEmpresa != null && responseTEmailPersonEmpresa.getCantidad() > 0) {
				tEmailPerson = mapper.convertValue(responseTEmailPersonEmpresa.getResultados().get(0),
						TEmailPerson.class);
			}
			List<TEmailPersonPut> lstTEmailPersonPut = new ArrayList<TEmailPersonPut>();
			TEmailPersonPut TEmailPerson = new TEmailPersonPut();
			BeanUtils.copyProperties(tEmailPerson, TEmailPerson);
			TEmailPerson.setMailVemail(mail_vmail);
			lstTEmailPersonPut.add(TEmailPerson);
			emailPersonRest.putEmailPerson(lstTEmailPersonPut,beanDS);
			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA ADDRESS       ----------------------------------------------*/
			/*********************************************************************************************************/

			TAddressPersonGet FiltroAddressPersonGetEmpresa = new TAddressPersonGet();
			FiltroAddressPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroAddressPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TAddressPerson> responseTAddressPersonEmpresa = AddressPersonRest
					.getAddressPerson(FiltroAddressPersonGetEmpresa,beanDS);
			TAddressPerson tAddressPerson = new TAddressPerson();
			if (responseTAddressPersonEmpresa != null && responseTAddressPersonEmpresa.getCantidad() > 0) {
				tAddressPerson = mapper.convertValue(responseTAddressPersonEmpresa.getResultados().get(0),
						TAddressPerson.class);
			}

			List<TAddressPersonPut> lstTAddressPersonPut = new ArrayList<TAddressPersonPut>();
			TAddressPersonPut TAddressPerson = new TAddressPersonPut();
			BeanUtils.copyProperties(tAddressPerson, TAddressPerson);
			TAddressPerson.setAddrVaddress(addr_vaddress);
			lstTAddressPersonPut.add(TAddressPerson);
			AddressPersonRest.putAddressPerson(lstTAddressPersonPut,beanDS);
			System.out.println(lstTAddressPersonPut);

			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA PHONE       ----------------------------------------------*/
			/*********************************************************************************************************/

			TPhonePersonGet FiltroPhonePersonGetEmpresa = new TPhonePersonGet();
			FiltroPhonePersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroPhonePersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TPhonePerson> responseTPhonePersonEmpresa = PhonePersonRest
					.getPhonePerson(FiltroPhonePersonGetEmpresa,beanDS);
			TPhonePerson tPhonePerson = new TPhonePerson();
			if (responseTPhonePersonEmpresa != null && responseTPhonePersonEmpresa.getCantidad() > 0) {
				tPhonePerson = mapper.convertValue(responseTPhonePersonEmpresa.getResultados().get(0),
						TPhonePerson.class);
			}

			List<TPhonePersonPut> lstTPhonePersonPut = new ArrayList<TPhonePersonPut>();
			TPhonePersonPut TPhonePerson = new TPhonePersonPut();
			BeanUtils.copyProperties(tPhonePerson, TPhonePerson);
			TPhonePerson.setPhonVphone(phon_vphone);
			lstTPhonePersonPut.add(TPhonePerson);
			PhonePersonRest.putPhonePerson(lstTPhonePersonPut,beanDS);
			System.out.println(lstTPhonePersonPut);

			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA EMPRESA       ----------------------------------------------*/
			/*********************************************************************************************************/

			TBussinesGet FiltroBussinesPersonGetEmpresa = new TBussinesGet();
			FiltroBussinesPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroBussinesPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TBussines> responseTBussinesPersonEmpresa = BussinesRest
					.getBussines(FiltroBussinesPersonGetEmpresa,beanDS);
			TBussines tBussines = new TBussines();
			if (responseTBussinesPersonEmpresa != null && responseTBussinesPersonEmpresa.getCantidad() > 0) {
				tBussines = mapper.convertValue(responseTBussinesPersonEmpresa.getResultados().get(0), TBussines.class);
			}

			List<TBussinesPut> lstTBussinesPut = new ArrayList<TBussinesPut>();
			TBussinesPut TBussines = new TBussinesPut();
			BeanUtils.copyProperties(tBussines, TBussines);
			TBussines.setBusiTdateUpdate(new Date());
			TBussines.setBusiBuserModify(new Long(pers_bidentUser));
			TBussines.setBusgrBident(new Long(legal_vgrupoCom));
			lstTBussinesPut.add(TBussines);
			BussinesRest.putBussines(lstTBussinesPut,beanDS);
			System.out.println(lstTPhonePersonPut);

			/*********************************************************************************************************/
			/*---------------------------      ACTUALIZA REPRESENTANTE LEGAL     ------------------------------------*/
			/*********************************************************************************************************/
			/** Valida si persona existe **/
			TPersonGet filtroPersonRL = new TPersonGet();
			filtroPersonRL.setPaginacion(new PaginacionFiltro(1, 1));
			filtroPersonRL.setPersVdoctype(pers_vdoctype);
			filtroPersonRL.setPersVnumdoc(pers_vnumdoc_repleg);
			PaginaResultado<TPerson> responsePersonRL = PersonRest.getPerson(filtroPersonRL,beanDS);
			TEmployeeGet employeeGet = new TEmployeeGet();
			if (responsePersonRL.getCantidad() > 0) {
				TPerson personRL = mapper.convertValue(responsePersonRL.getResultados().get(0), TPerson.class);
				/** Validar si el RL pertenece a la empresa **/
				employeeGet.setPaginacion(new PaginacionFiltro(1, 1));
				employeeGet.setPersBident(personRL.getPersBident());
				employeeGet.setBusiBident(tBussines.getBusiBident());
				employeeGet.setEmplBstate(true);
				employeeGet.setEmplVposition(Constantes.EMPLOYEE_VPOSITION_RL);
				PaginaResultado<TEmployee> employeeList = bussinesRest.getEmployee(employeeGet,beanDS);
				if (employeeList.getCantidad() == 0) {
					/** Actualizar en la tabla t_employee el estado del RL anterior **/
					employeeGet = new TEmployeeGet();
					employeeGet.setPaginacion(new PaginacionFiltro(1, 1));
					employeeGet.setBusiBident(tBussines.getBusiBident());
					employeeGet.setEmplBstate(true);
					employeeGet.setEmplVposition(Constantes.EMPLOYEE_VPOSITION_RL);
					PaginaResultado<TEmployee> employeeListAnt = bussinesRest.getEmployee(employeeGet,beanDS);
					if (employeeListAnt.getCantidad() > 0) {
						TEmployee tEmployeeAnt = mapper.convertValue(employeeListAnt.getResultados().get(0),TEmployee.class);
						List<TEmployeePut> lsttEmployeePut = new ArrayList<TEmployeePut>();
						TEmployeePut tEmployeePut = new TEmployeePut();
						BeanUtils.copyProperties(tEmployeeAnt, tEmployeePut);
						tEmployeePut.setEmplBstate(false);
						lsttEmployeePut.add(tEmployeePut);
						bussinesRest.putEmployee(lsttEmployeePut,beanDS);
						/** Actualizar en la tabla t_user el estado del RL anterior **/
						TUserGet filtroUser = new TUserGet();
						filtroUser.setPaginacion(new PaginacionFiltro(1, 1));
						filtroUser.setUserVuser(tEmployeeAnt.getUserVuser());
						PaginaResultado<TUser> responseTuser = tUserRest.getUser(filtroUser,beanDS);
						if (responseTuser.getCantidad() > 0) {
							TUser userFilter = mapper.convertValue(responseTuser.getResultados().get(0), TUser.class);
							List<TUserPut> LstUserPost = new ArrayList<TUserPut>();
							TUserPut tUserPut = new TUserPut();
							BeanUtils.copyProperties(userFilter, tUserPut);
							tUserPut.setUserBstate(false);
							tUserPut.setUserTdateUpdate(new Date());
							LstUserPost.add(tUserPut);
							tUserRest.putUser(LstUserPost,beanDS);
						}
					}
					/** Insertar en la tabla t_employee **/
					String usuario = tUserRest.obtenerUsuario(pers_vnumdoc_repleg,null);
					List<TEmployeePost> lstTEmployeePost = new ArrayList<TEmployeePost>();
					TEmployeePost tEmployee = new TEmployeePost();
					tEmployee.setBusiBident(tBussines.getBusiBident());
					tEmployee.setEmplBstate(true);
					tEmployee.setEmplVposition(Constantes.EMPLOYEE_VPOSITION_RL);
					tEmployee.setPersBident(personRL.getPersBident());
					tEmployee.setUserVuser(usuario);
					lstTEmployeePost.add(tEmployee);
					List<TEmployee> lstTEmployee = bussinesRest.postEmployee(lstTEmployeePost,beanDS);
					/** Insertar en la tabla t_user **/
					List<TUserPost> LsttUserPost = new ArrayList<TUserPost>();
					TUserPost tUserPost = new TUserPost();
					tUserPost.setUserVuser(usuario);
					tUserPost.setPersBident(personRL.getPersBident());
					tUserPost.setProfBident(new Long(1));
					tUserPost.setUserBstate(true);
					tUserPost.setUserTdateUpdate(new Date());
					tUserPost.setUserVpassword(Security.generateHash(pers_vnumdoc_repleg));
					LsttUserPost.add(tUserPost);
					List<TUser> lstTUser = tUserRest.postUser(LsttUserPost, null);
				}
			} else {
				/** Actualizar en la tabla t_employee el estado del RL anterior **/
				employeeGet = new TEmployeeGet();
				employeeGet.setPaginacion(new PaginacionFiltro(1, 1));
				employeeGet.setBusiBident(tBussines.getBusiBident());
				employeeGet.setEmplBstate(true);
				employeeGet.setEmplVposition(Constantes.EMPLOYEE_VPOSITION_RL);
				PaginaResultado<TEmployee> employeeListAnt = bussinesRest.getEmployee(employeeGet,beanDS);
				if (employeeListAnt.getCantidad() > 0) {
					TEmployee tEmployeeAnt = mapper.convertValue(employeeListAnt.getResultados().get(0),
							TEmployee.class);
					List<TEmployeePut> lsttEmployeePut = new ArrayList<TEmployeePut>();
					TEmployeePut tEmployeePut = new TEmployeePut();
					BeanUtils.copyProperties(tEmployeeAnt, tEmployeePut);
					tEmployeePut.setEmplBstate(false);
					lsttEmployeePut.add(tEmployeePut);
					bussinesRest.putEmployee(lsttEmployeePut,beanDS);
					/** Actualizar en la tabla t_user el estado del RL anterior **/
					TUserGet filtroUser = new TUserGet();
					filtroUser.setPaginacion(new PaginacionFiltro(1, 1));
					filtroUser.setUserVuser(tEmployeeAnt.getUserVuser());
					PaginaResultado<TUser> responseTuser = tUserRest.getUser(filtroUser,beanDS);
					if (responseTuser.getCantidad() > 0) {
						TUser userFilter = mapper.convertValue(responseTuser.getResultados().get(0), TUser.class);
						List<TUserPut> LstUserPost = new ArrayList<TUserPut>();
						TUserPut tUserPut = new TUserPut();
						BeanUtils.copyProperties(userFilter, tUserPut);
						tUserPut.setUserBstate(false);
						tUserPut.setUserTdateUpdate(new Date());
						LstUserPost.add(tUserPut);
						tUserRest.putUser(LstUserPost,beanDS);
					}
				}
				InsertRepresentLegal insertRepresentLegal = new InsertRepresentLegal();
				insertRepresentLegal.setPers_vdoctype(pers_vdoctype);
				insertRepresentLegal.setPers_vnumdoc_repleg(pers_vnumdoc_repleg);
				insertRepresentLegal.setNatu_vname(natu_vname.toUpperCase());
				insertRepresentLegal.setNatu_vlastnamefather(natu_vlastnamefather.toUpperCase());
				insertRepresentLegal.setNatu_vlastnamemother(natu_vlastnamemother.toUpperCase());
				insertRepresentLegal.setMail_vmail_repleg(mail_vmail_repleg);
				insertRepresentLegal.setPers_bidentUser(pers_bidentUser);
				insertRepresentLegal.setPhon_vphone_repleg(phon_vphone_repleg);
				insertRepresentLegal.setHashpers_vnumdoc_repleg(Security.generateHash(pers_vnumdoc_repleg));
				insertRepresentLegal.setBusiBident(tBussines.getBusiBident());
				insertRepresentLegal.setAddr_vaddress_repleg(addr_vaddress_repleg);
				insertRepresentLegal.setNaturalVtradename(natural_vtradename);
				insertRepresentLegal.setNaturalVtipoPerson(natural_vtipoPerson);
				insertRepresentLegal.setNaturalVpais(natural_vpais);
				insertRepresentLegal.setNaturalVlocalidad(natural_vlocalidad);
				PersonRest.postInsertRepresentanteLegal(insertRepresentLegal,beanDS);
			}

		} catch (Exception ex) {
			// Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null,
			// ex);
			ex.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	@RequestMapping(value = "/EstadoEmpresa", method = RequestMethod.POST)
	@ResponseBody
	public String EstadoEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "pers_vnumdoc", required = true) String pers_vnumdoc,
			@RequestParam(value = "pers_bidentUser", required = false) String pers_bidentUser) {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TPersonGet filtro = new TPersonGet();
			// Se coloca 1,1 por que solo te trae una solo empresa, todo el
			// array de solo 1 empresa.
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			// Se puede ingresar todas las variables que puedas consultar.
			filtro.setPersVnumdoc(pers_vnumdoc);
			filtro.setPersCperstype("L");
			PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
			TPerson empreJuri = new TPerson();
			if (response != null && response.getCantidad() > 0) {
				empreJuri = mapper.convertValue(response.getResultados().get(0), TPerson.class);
			}

			TBussinesGet FiltroBussinesPersonGetEmpresa = new TBussinesGet();
			FiltroBussinesPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroBussinesPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TBussines> responseTBussinesPersonEmpresa = BussinesRest
					.getBussines(FiltroBussinesPersonGetEmpresa,beanDS);
			TBussines tBussines = new TBussines();
			if (responseTBussinesPersonEmpresa != null && responseTBussinesPersonEmpresa.getCantidad() > 0) {
				tBussines = mapper.convertValue(responseTBussinesPersonEmpresa.getResultados().get(0), TBussines.class);
			}

			List<TBussinesPut> lstTBussinesPut = new ArrayList<TBussinesPut>();
			TBussinesPut TBussines = new TBussinesPut();
			BeanUtils.copyProperties(tBussines, TBussines);
			// TPhonePerson.setPersBident(tPerson.getPersBident());
			TBussines.setBusiTdateUpdate(new Date());
			TBussines.setBusiCstate("2");
			TBussines.setBusiBuserModify(new Long(pers_bidentUser));
			lstTBussinesPut.add(TBussines);
			// List<TPhonePerson> lstPhonePerson =
			BussinesRest.putBussines(lstTBussinesPut,beanDS);
			// System.out.println(lstTPhonePersonPut);
			// TPhonePerson tPhonePerson=
			// mapper.convertValue(lstPhonePerson.get(0),TPhonePerson.class);

			TPersonGet filtroUP = new TPersonGet();
			// Se coloca 1,1 por que solo te trae una solo empresa, todo el
			// array de solo 1 empresa.
			filtroUP.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			// Se puede ingresar todas las variables que puedas consultar.
			filtroUP.setLegaBident(empreJuri.getLegaBident());
			filtroUP.setPersCperstype("N");
			PaginaResultado<TPerson> responseUP = PersonRest.getPerson(filtroUP,beanDS);
			TPerson usurEmp = new TPerson();
			if (responseUP != null && responseUP.getCantidad() > 0) {
				usurEmp = mapper.convertValue(responseUP.getResultados().get(0), TPerson.class);
			}
			List<TPerson> lstUP = new ArrayList<TPerson>();
			for (Object catdet : responseUP.getResultados()) {
				usurEmp = mapper.convertValue(catdet, TPerson.class);
				lstUP.add(usurEmp);
				// }
				System.out.println(lstUP);
				System.out.println(lstUP.size());

				TEmployeeGet EmpleFiltr = new TEmployeeGet();
				EmpleFiltr.setPaginacion(new PaginacionFiltro(1, 1));
				EmpleFiltr.setBusiBident(tBussines.getBusiBident());
				EmpleFiltr.setEmplBstate(true);
				PaginaResultado<TEmployee> responseTEmployeePerson = BussinesRest.getEmployee(EmpleFiltr,beanDS);
				TEmployee tEmploye = new TEmployee();
				if (responseTEmployeePerson != null && responseTEmployeePerson.getCantidad() > 0) {
					tEmploye = mapper.convertValue(responseTEmployeePerson.getResultados().get(0), TEmployee.class);
				}

				List<TEmployeePut> lstTEmployeePut = new ArrayList<TEmployeePut>();
				TEmployeePut TEmployee = new TEmployeePut();
				BeanUtils.copyProperties(tEmploye, TEmployee);
				// TEmployee.setBusiBident(tEmploye.getBusiBident());
				TEmployee.setEmplBstate(false);
				TEmployee.setBusiBident(tEmploye.getBusiBident());
				// TEmployee.set(new Long(pers_bidentUser));
				lstTEmployeePut.add(TEmployee);
				BussinesRest.putEmployee(lstTEmployeePut,beanDS);

				TUserGet filtroU = new TUserGet();
				filtroU.setPaginacion(new PaginacionFiltro(1, 1));
				filtroU.setPersBident(tEmploye.getPersBident());
				filtroU.setProfBident(new Long("1"));
				PaginaResultado<TUser> responseU = UserRest.getUser(filtroU,beanDS);
				TUser usuario = new TUser();
				if (responseU != null && responseU.getCantidad() > 0) {
					usuario = mapper.convertValue(responseU.getResultados().get(0), TUser.class);

					List<TUserPut> lstTUserPut = new ArrayList<TUserPut>();
					TUserPut TUser = new TUserPut();
					BeanUtils.copyProperties(usuario, TUser);
					TUser.setUserTdateUpdate(new Date());
					TUser.setUserBstate(false);
					TUser.setUserBuserModify(new Long(pers_bidentUser));
					// TUser.setUserVpassword(user);
					lstTUserPut.add(TUser);
					UserRest.putUser(lstTUserPut,beanDS);
				}

			}

		} catch (Exception ex) {
			// Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null,
			// ex);
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}

	@RequestMapping(value = "/EditarEmpresa", method = RequestMethod.GET)
	public ModelAndView editarLegalPerson(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "ruc", required = true) String ruc) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
			if(Util.validAcceso(ses,"/empresa/")) {
				logger.info("Si tiene Acceso a la pagina");
			}else {
				model.setViewName("/Permiso/PermidoDenegado");
				return model;
			}
		}else {
			model.setViewName("/homepost");
			return model;
		}
		String NombreVentana="Editar Empresa";
		model.addObject("NombreVentana", NombreVentana);
		model.setViewName("/Empresa/ConfiguracionGeneral");
		try {
			
			//azevallos - obteniendo los grupos comerciales
			TBusinessGroupGet filtro2 = new TBusinessGroupGet();
			filtro2.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtro2.setBusgrBstate(Constantes.estadoGC.HABILITADO.getCode());
			PaginaResultado<TBusinessGroup> response2= new PaginaResultado<>();
			List<TBusinessGroup> lstGrupoCom = new ArrayList<>();
			try {
				response2 = tUserRest.getGrupoComer(filtro2, beanDS);
				if (null!=response2 && response2.getCantidad()>0) {
					mapper = new ObjectMapper();
					for (Object catdet : response2.getResultados()) {
						TBusinessGroup procata = mapper.convertValue(catdet, TBusinessGroup.class);
						lstGrupoCom.add(procata);
					}
					model.addObject("lstGrupoCom", lstGrupoCom);
				} else {
					logger.info("No encontro el Grupo Comercial");
				}

			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();

			}
			
			TPerson empresa = new TPerson();
			TPerson repLegal = new TPerson();
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			TLegalPerson legalPerson = new TLegalPerson();
			PaginaResultado<TPerson> response = new PaginaResultado<>();
			try {
				TPersonGet filtro = new TPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el
				// array de solo 1 empresa.
				filtro.setPaginacion(new PaginacionFiltro(1, 1));
				filtro.setPersVnumdoc(ruc);
				filtro.setPersCperstype("L");
				response = PersonRest.getPerson(filtro,beanDS);
				if (!StringUtils.isEmpty(ruc) && response.getCantidad() > 0) {
					mapper = new ObjectMapper();
					empresa = mapper.convertValue(response.getResultados().get(0), TPerson.class);
					model.addObject("empPersBident", empresa.getPersBident());
					model.addObject("empPersBidentLP", empresa.getLegaBident());
					model.addObject("empPersVNumDoc", empresa.getPersVnumdoc());
					model.addObject("empPersVtradename", empresa.getPersVtradename());
					model.addObject("emprVdoctype", empresa.getPersVdoctype());
					model.addObject("emprPais", empresa.getPersBcodcountry());
					model.addObject("emprLocalidad", empresa.getPersVubigeo());
					model.addObject("emprDomici", empresa.getPersVdomiciled());

				} else {
					logger.info("No encontro la empresa");
				}

				// obteniendo nombre de la empresa
				TLegalPersonGet filtroLP = new TLegalPersonGet();
				filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroLP.setLegaBident(empresa.getLegaBident());
				PaginaResultado<TLegalPerson> responseLP = legalPersonRest.getLegalPerson(filtroLP,beanDS);
				if (responseLP != null && response.getCantidad() > 0) {
					mapper = new ObjectMapper();
					legalPerson = mapper.convertValue(responseLP.getResultados().get(0), TLegalPerson.class);
					model.addObject("legalPersLegaBusiname", legalPerson.getLegaBusiname());

				} else {
					logger.info("No encontro la empresa");
				}

				// obteniendo email empresa
				TEmailPersonGet filtroEP = new TEmailPersonGet();
				filtroEP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroEP.setPersBident(empresa.getPersBident());
				PaginaResultado<TEmailPerson> responseEP = emailPersonRest.getEmailPerson(filtroEP,beanDS);
				if (responseEP != null && response.getCantidad() > 0) {
					mapper = new ObjectMapper();
					TEmailPerson emailPerson = mapper.convertValue(responseEP.getResultados().get(0),
							TEmailPerson.class);
					model.addObject("legalPersEmail", emailPerson.getMailVemail());

				} else {
					logger.info("No encontro la empresa");
				}

				// obteniendo direccion empresa
				TAddressPersonGet filtroAP = new TAddressPersonGet();
				filtroAP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroAP.setPersBident(empresa.getPersBident());
				PaginaResultado<TAddressPerson> responseAP = AddressPersonRest.getAddressPerson(filtroAP,beanDS);
				if (responseAP != null && response.getCantidad() > 0) {
					mapper = new ObjectMapper();
					TAddressPerson addressPerson = mapper.convertValue(responseAP.getResultados().get(0),
							TAddressPerson.class);
					model.addObject("legalPersAddress", addressPerson.getAddrVaddress());

				} else {
					logger.info("No encontro la empresa");
				}

				// obteniendo telefono empresa
				TPhonePersonGet filtroPP = new TPhonePersonGet();
				filtroPP.setPaginacion(new PaginacionFiltro(1, 1));
				filtroPP.setPersBident(empresa.getPersBident());
				PaginaResultado<TPhonePerson> responsePP = PhonePersonRest.getPhonePerson(filtroPP,beanDS);
				if (responsePP != null && response.getCantidad() > 0) {
					mapper = new ObjectMapper();
					TPhonePerson phonePerson = mapper.convertValue(responsePP.getResultados().get(0),
							TPhonePerson.class);
					model.addObject("legalPersPhone", phonePerson.getPhonVphone());

				} else {
					logger.info("No encontro la empresa");
				}

				/** buscan al representante legal **/
				TBussinesGet FiltroBussinesGetRL = new TBussinesGet();
				FiltroBussinesGetRL.setPaginacion(new PaginacionFiltro(1, 1));
				FiltroBussinesGetRL.setPersBident(empresa.getPersBident());
				PaginaResultado<TBussines> responseTBussinesPersonEmpresa = BussinesRest
						.getBussines(FiltroBussinesGetRL,beanDS);
				TBussines tBussinesRL = new TBussines();
				if (responseTBussinesPersonEmpresa != null && responseTBussinesPersonEmpresa.getCantidad() > 0) {
					mapper = new ObjectMapper();
					tBussinesRL = mapper.convertValue(responseTBussinesPersonEmpresa.getResultados().get(0),
							TBussines.class);
					model.addObject("emprGC", tBussinesRL.getBusgrBident());
				}
				/** Listar representante legal **/
				TEmployeeGet FiltroEmployeeGetRL = new TEmployeeGet();
				FiltroEmployeeGetRL.setPaginacion(new PaginacionFiltro(1, 1));
				FiltroEmployeeGetRL.setBusiBident(tBussinesRL.getBusiBident());
				FiltroEmployeeGetRL.setEmplVposition(Constantes.EMPLOYEE_VPOSITION_RL);
				FiltroEmployeeGetRL.setEmplBstate(true);
				PaginaResultado<TEmployee> responseTEmployeeRL = BussinesRest.getEmployee(FiltroEmployeeGetRL,beanDS);
				TEmployee tEmployee = new TEmployee();
				if (responseTEmployeeRL != null && responseTEmployeeRL.getCantidad() > 0) {
					mapper = new ObjectMapper();
					tEmployee = mapper.convertValue(responseTEmployeeRL.getResultados().get(0), TEmployee.class);
					/** Listar la persona **/
					TPersonGet filtroN = new TPersonGet();
					filtroN.setPaginacion(new PaginacionFiltro(1, 1));
					filtroN.setPersBident(tEmployee.getPersBident());
					filtroN.setPersCperstype("N");
					response = PersonRest.getPerson(filtroN,beanDS);
					if (response.getCantidad() > 0) {
						mapper = new ObjectMapper();
						repLegal = mapper.convertValue(response.getResultados().get(0), TPerson.class);
						model.addObject("repLegalBident", repLegal.getPersBident());
						model.addObject("repLegalBidentRL", repLegal.getNatuBident());
						model.addObject("repLegalVNumDoc", repLegal.getPersVnumdoc());
						model.addObject("repLegalVTipoDoc", repLegal.getPersVdoctype());

						model.addObject("repPersVtradename", repLegal.getPersVtradename());
						model.addObject("repPais", repLegal.getPersBcodcountry());
						model.addObject("repLocalidad", repLegal.getPersVubigeo());
						model.addObject("repDomici", repLegal.getPersVdomiciled());
					} else {
						logger.info("no encontró persona");
					}
					/** Listar la persona natural **/
					TNaturalPersonGet filtroNP = new TNaturalPersonGet();
					filtroNP.setPaginacion(new PaginacionFiltro(1, 1));
					filtroNP.setNatuBident(repLegal.getNatuBident());
					PaginaResultado<TNaturalPerson> responseNP = NaturalPersonRest.getNaturalPerson(filtroNP,beanDS);
					if (responseNP != null && response.getCantidad() > 0) {
						mapper = new ObjectMapper();
						TNaturalPerson NaturalPerson = mapper.convertValue(responseNP.getResultados().get(0),
								TNaturalPerson.class);
						model.addObject("repLegalName", NaturalPerson.getNatuVname());
						model.addObject("repLegalLastnamefather", NaturalPerson.getNatuVlastnamefather());
						model.addObject("repLegalLastnameMother", NaturalPerson.getNatuVlastnamemother());
						/** Listar el email **/
						TEmailPersonGet filtroNEP = new TEmailPersonGet();
						filtroNEP.setPaginacion(new PaginacionFiltro(1, 1));
						filtroNEP.setPersBident(repLegal.getPersBident());
						PaginaResultado<TEmailPerson> responseNEP = emailPersonRest.getEmailPerson(filtroNEP,beanDS);
						if (responseNEP != null && response.getCantidad() > 0) {
							mapper = new ObjectMapper();
							TEmailPerson emailPerson = mapper.convertValue(responseNEP.getResultados().get(0),
									TEmailPerson.class);
							model.addObject("repLegalEmail", emailPerson.getMailVemail());

						} else {
							logger.info("No encontro el correo electronico");
						}
						/** Listar el telefono **/
						TPhonePersonGet filtroNPP = new TPhonePersonGet();
						filtroNPP.setPaginacion(new PaginacionFiltro(1, 1));
						filtroNPP.setPersBident(repLegal.getPersBident());
						PaginaResultado<TPhonePerson> responseNPP = PhonePersonRest.getPhonePerson(filtroNPP,beanDS);
						if (responseNPP != null && response.getCantidad() > 0) {
							mapper = new ObjectMapper();
							TPhonePerson phonePerson = mapper.convertValue(responseNPP.getResultados().get(0),
									TPhonePerson.class);
							model.addObject("repLegalPhone", phonePerson.getPhonVphone());

						} else {
							logger.info("No encontro el telefono");
						}
						TAddressPersonGet filtroTAddressPersonGet = new TAddressPersonGet();
						filtroTAddressPersonGet.setPaginacion(new PaginacionFiltro(1, 1));
						filtroTAddressPersonGet.setPersBident(repLegal.getPersBident());
						PaginaResultado<TAddressPerson> rspTAddressPerson = AddressPersonRest
								.getAddressPerson(filtroTAddressPersonGet,beanDS);
						if (rspTAddressPerson != null && rspTAddressPerson.getCantidad() > 0) {
							TAddressPerson tAddressPerson = mapper
									.convertValue(rspTAddressPerson.getResultados().get(0), TAddressPerson.class);
							model.addObject("repLegalAddress", tAddressPerson.getAddrVaddress());
						} else {
							logger.info("No encontro el dirección");
						}

					}

				} else {
					logger.info("No encontro datos");
				}
				/** Listar los tipo de documento **/
				filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				filtroscatalogo.setCataBident(new Long(4));
				PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
				TCatalogueDet procata = new TCatalogueDet();
				List<TCatalogueDet> lstCatDoc = new ArrayList<>();
				for (Object catdet : responsescat.getResultados()) {
					procata = mapper.convertValue(catdet, TCatalogueDet.class);
					lstCatDoc.add(procata);
				}
				model.addObject("listaCatDet", lstCatDoc);
				model.addObject("tipDocRP", procata.getCatdVdescription());

				// obtener ubigeo
				TUbigeoGet filtroUbigeo = new TUbigeoGet();
				filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				PaginaResultado<TUbigeo> respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
				List<TUbigeo> lstUbigeo = new ArrayList<TUbigeo>();
				for (Object tUbigeo : respUbigeo.getResultados()) {
					TUbigeo ubigeo = mapper.convertValue(tUbigeo, TUbigeo.class);
					lstUbigeo.add(ubigeo);
				}
				model.addObject("lstUbigeo", lstUbigeo);
				// obtener pais
				TCountryGet filtroCountry = new TCountryGet();
				filtroCountry.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				filtroCountry.setCounBstate(true);
				PaginaResultado<TCountry> respCountry = CatalogueRest.getCountry(filtroCountry,beanDS);
				List<TCountry> lstCountry = new ArrayList<TCountry>();
				for (Object tCountry : respCountry.getResultados()) {
					TCountry country = mapper.convertValue(tCountry, TCountry.class);
					lstCountry.add(country);
				}
				model.addObject("lstCountry", lstCountry);

			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();

			}

		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/detalleemp", method = RequestMethod.POST)
	@ResponseBody
	public String listarEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "ruc", required = true) String ruc) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		try {

			TPersonGet filtro = new TPersonGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setPersVnumdoc(ruc);
			filtro.setPersCperstype("L");
			PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
			TPerson empreJuri = new TPerson();
			if (response != null && response.getCantidad() > 0) {
				empreJuri = mapper.convertValue(response.getResultados().get(0), TPerson.class);
			}

			TLegalPersonGet filtroLegalPerson = new TLegalPersonGet();
			filtroLegalPerson.setPaginacion(new PaginacionFiltro(1, 1));
			filtroLegalPerson.setLegaBident(empreJuri.getLegaBident());
			PaginaResultado<TLegalPerson> responseLegalPerson = legalPersonRest.getLegalPerson(filtroLegalPerson,beanDS);
			TLegalPerson tLegalPerson = new TLegalPerson();
			if (responseLegalPerson != null && responseLegalPerson.getCantidad() > 0) {
				tLegalPerson = mapper.convertValue(responseLegalPerson.getResultados().get(0), TLegalPerson.class);
			}

			TEmailPersonGet FiltroEmailPersonGetEmpresa = new TEmailPersonGet();
			FiltroEmailPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroEmailPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TEmailPerson> responseTEmailPersonEmpresa = emailPersonRest.getEmailPerson(FiltroEmailPersonGetEmpresa,beanDS);
			TEmailPerson tEmailPerson = new TEmailPerson();
			if (responseTEmailPersonEmpresa != null && responseTEmailPersonEmpresa.getCantidad() > 0) {
				tEmailPerson = mapper.convertValue(responseTEmailPersonEmpresa.getResultados().get(0),TEmailPerson.class);
			}

			TAddressPersonGet FiltroAddressPersonGetEmpresa = new TAddressPersonGet();
			FiltroAddressPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroAddressPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TAddressPerson> responseTAddressPersonEmpresa = AddressPersonRest.getAddressPerson(FiltroAddressPersonGetEmpresa,beanDS);
			TAddressPerson tAddressPerson = new TAddressPerson();
			if (responseTAddressPersonEmpresa != null && responseTAddressPersonEmpresa.getCantidad() > 0) {
				tAddressPerson = mapper.convertValue(responseTAddressPersonEmpresa.getResultados().get(0),TAddressPerson.class);
			}

			TPhonePersonGet FiltroPhonePersonGetEmpresa = new TPhonePersonGet();
			FiltroPhonePersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroPhonePersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TPhonePerson> responseTPhonePersonEmpresa = PhonePersonRest.getPhonePerson(FiltroPhonePersonGetEmpresa,beanDS);
			TPhonePerson tPhonePerson = new TPhonePerson();
			if (responseTPhonePersonEmpresa != null && responseTPhonePersonEmpresa.getCantidad() > 0) {
				tPhonePerson = mapper.convertValue(responseTPhonePersonEmpresa.getResultados().get(0),TPhonePerson.class);
			}

			TBussinesGet FiltroBussinesGetRL = new TBussinesGet();
			FiltroBussinesGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroBussinesGetRL.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TBussines> responseTBussinesPersonEmpresa = BussinesRest.getBussines(FiltroBussinesGetRL,beanDS);
			TBussines tBussinesRL = new TBussines();
			if (responseTBussinesPersonEmpresa != null && responseTBussinesPersonEmpresa.getCantidad() > 0) {
				tBussinesRL = mapper.convertValue(responseTBussinesPersonEmpresa.getResultados().get(0),TBussines.class);
			}

			/**
			 * SE BUSCA AL REPRESENTANTE LEGAL
			 */
			TEmployeeGet FiltroEmployeeGetRL = new TEmployeeGet();
			FiltroEmployeeGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroEmployeeGetRL.setBusiBident(tBussinesRL.getBusiBident());
			FiltroEmployeeGetRL.setEmplVposition("REPRESENTANTE LEGAL");
			PaginaResultado<TEmployee> responseTEmployeeRL = BussinesRest.getEmployee(FiltroEmployeeGetRL,beanDS);
			TEmployee tEmployee = new TEmployee();
			if (responseTEmployeeRL != null && responseTEmployeeRL.getCantidad() > 0) {
				tEmployee = mapper.convertValue(responseTEmployeeRL.getResultados().get(0), TEmployee.class);
			}

			filtro = new TPersonGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			filtro.setPersBident(tEmployee.getPersBident());
			filtro.setPersCperstype("N");
			response = PersonRest.getPerson(filtro,beanDS);
			TPerson empreRL = new TPerson();
			if (response != null && response.getCantidad() > 0) {
				empreRL = mapper.convertValue(response.getResultados().get(0), TPerson.class);
			}

			TNaturalPersonGet FiltroNaturalPersonGetRL = new TNaturalPersonGet();
			FiltroNaturalPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroNaturalPersonGetRL.setNatuBident(empreRL.getNatuBident());
			PaginaResultado<TNaturalPerson> responseTNaturalPersonRL = NaturalPersonRest.getNaturalPerson(FiltroNaturalPersonGetRL,beanDS);
			TNaturalPerson tNaturalPerson = new TNaturalPerson();
			if (responseTNaturalPersonRL != null && responseTNaturalPersonRL.getCantidad() > 0) {
				tNaturalPerson = mapper.convertValue(responseTNaturalPersonRL.getResultados().get(0),TNaturalPerson.class);
			}

			TAddressPersonGet FiltroAddressPersonGetRL = new TAddressPersonGet();
			FiltroAddressPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroAddressPersonGetEmpresa.setPersBident(empreRL.getPersBident());
			PaginaResultado<TAddressPerson> responseTAddressPersonRL = AddressPersonRest.getAddressPerson(FiltroAddressPersonGetEmpresa,beanDS);
			TAddressPerson tAddressPersonRL = new TAddressPerson();
			if (responseTAddressPersonRL != null && responseTAddressPersonRL.getCantidad() > 0) {
				tAddressPersonRL = mapper.convertValue(responseTAddressPersonRL.getResultados().get(0),TAddressPerson.class);
			}
			
			TEmailPersonGet FiltroEmailPersonGetRL = new TEmailPersonGet();
			FiltroEmailPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroEmailPersonGetRL.setPersBident(empreRL.getPersBident());
			PaginaResultado<TEmailPerson> responseTEmailPersonRL = emailPersonRest.getEmailPerson(FiltroEmailPersonGetRL,beanDS);
			TEmailPerson tEmailPersonRL = new TEmailPerson();
			if (responseTEmailPersonRL != null && responseTEmailPersonRL.getCantidad() > 0) {
				tEmailPersonRL = mapper.convertValue(responseTEmailPersonRL.getResultados().get(0), TEmailPerson.class);
			}

			TPhonePersonGet FiltroPhonePersonGetRL = new TPhonePersonGet();
			FiltroPhonePersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroPhonePersonGetRL.setPersBident(empreRL.getPersBident());
			PaginaResultado<TPhonePerson> responseTPhonePersonRL = PhonePersonRest.getPhonePerson(FiltroPhonePersonGetRL,beanDS);
			TPhonePerson tPhonePersonRL = new TPhonePerson();
			if (responseTPhonePersonRL != null && responseTPhonePersonRL.getCantidad() > 0) {
				tPhonePersonRL = mapper.convertValue(responseTPhonePersonRL.getResultados().get(0), TPhonePerson.class);
			}
			Gson gson = new Gson();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "ok");
			/**
			 * LLENANDO LA EMPRESA
			 */

			/** obtiene tipo de documento **/
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(4));
			filtroscatalogo.setCatdCident(empreJuri.getPersVdoctype());
			PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet tCatalogueDet = mapper.convertValue(responsescat.getResultados().get(0), TCatalogueDet.class);
			TUbigeoGet filtroUbigeo = new TUbigeoGet();
			PaginaResultado<TUbigeo> respUbigeo=null;
			/** obtiene el localidad **/
			TUbigeo tUbigeo=null;
			if(empreJuri.getPersVubigeo()!=null && !empreJuri.getPersVubigeo().equals("")){
				filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				filtroUbigeo.setUbigIident(new Long(empreJuri.getPersVubigeo()));
				respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
				tUbigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
			}
			/** obtiene el pais **/
			TCountryGet filtroCountry = new TCountryGet();
			filtroCountry.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCountry.setCounBident(empreJuri.getPersBcodcountry().toString());
			filtroCountry.setCounBstate(true);
			PaginaResultado<TCountry> respCountry = CatalogueRest.getCountry(filtroCountry,beanDS);
			TCountry tCountry = mapper.convertValue(respCountry.getResultados().get(0), TCountry.class);
			String tipoPersonDomiciliadoEmpr="";
			if(empreJuri.getPersVdomiciled()!=null) {
				tipoPersonDomiciliadoEmpr=empreJuri.getPersVdomiciled().equals("D")?"Domiciliado":"No Domiciliado";
			}
			
			robject.addProperty("emprVdoctype", tCatalogueDet.getCatdVdescription());
			robject.addProperty("persVnumdoc", empreJuri.getPersVnumdoc());
			robject.addProperty("persVtradename", empreJuri.getPersVtradename());
			robject.addProperty("legalVpais", tCountry.getCounVname());
			robject.addProperty("legalVlocalidad", tUbigeo==null?"":tUbigeo.getUbigDepart()+", "+tUbigeo.getUbigProvinc()+", "+tUbigeo.getUbigDistrit());
			robject.addProperty("legaBusiname", tLegalPerson.getLegaBusiname());
			robject.addProperty("addrVaddress", tAddressPerson.getAddrVaddress());
			robject.addProperty("phonVphone", tPhonePerson.getPhonVphone());
			robject.addProperty("mailVemail", tEmailPerson.getMailVemail());
			robject.addProperty("legalVtipoPerson", tipoPersonDomiciliadoEmpr);

			/**
			 * LLENANDO REPRESENTANTE LEGAL
			 */
			/** obtiene tipo de documento **/
			filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(4));
			filtroscatalogo.setCatdCident(empreRL.getPersVdoctype());
			responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			tCatalogueDet = mapper.convertValue(responsescat.getResultados().get(0), TCatalogueDet.class);
			
			/** obtiene el localidad **/
			if(empreRL.getPersVubigeo()!=null && !empreRL.getPersVubigeo().equals("")){
				filtroUbigeo = new TUbigeoGet();
				filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				filtroUbigeo.setUbigIident(new Long(empreRL.getPersVubigeo()));
				respUbigeo = CatalogueRest.getUbigeo(filtroUbigeo,beanDS);
				tUbigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
			}
			/** obtiene el pais **/
			filtroCountry = new TCountryGet();
			filtroCountry.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCountry.setCounBident(empreRL.getPersBcodcountry().toString());
			filtroCountry.setCounBstate(true);
			respCountry = CatalogueRest.getCountry(filtroCountry,beanDS);
			tCountry = mapper.convertValue(respCountry.getResultados().get(0), TCountry.class);
			String tipoPersonDomiciliadoRl="";
			if(empreRL.getPersVdomiciled()!=null) {
				tipoPersonDomiciliadoRl=empreRL.getPersVdomiciled().equals("D")?"Domiciliado":"No Domiciliado";
			}
			
			robject.addProperty("pers_vdoctype", tCatalogueDet.getCatdVdescription());
			robject.addProperty("persVnumdocRepleg", empreRL.getPersVnumdoc());
			robject.addProperty("natuVname", tNaturalPerson.getNatuVname());
			robject.addProperty("natuVlastnamefather", tNaturalPerson.getNatuVlastnamefather());
			robject.addProperty("natuVlastnamemother", tNaturalPerson.getNatuVlastnamemother());
			robject.addProperty("naturalVtradename", empreRL.getPersVtradename());
			robject.addProperty("naturalVtipoPerson", tipoPersonDomiciliadoRl);
			robject.addProperty("naturalVpais", tCountry.getCounVname());
			robject.addProperty("naturalVlocalidad", tUbigeo==null?"":tUbigeo.getUbigDepart()+", "+tUbigeo.getUbigProvinc()+", "+tUbigeo.getUbigDistrit());
			robject.addProperty("mailVmailRepleg", tEmailPersonRL.getMailVemail());
			robject.addProperty("phonVphoneRepleg", tPhonePersonRL.getPhonVphone());
			robject.addProperty("addrVaddressRepleg", tAddressPersonRL.getAddrVaddress());
			return new Gson().toJson(robject);
		} catch (Exception e) {
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}

}
