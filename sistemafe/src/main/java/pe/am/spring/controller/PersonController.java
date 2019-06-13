package pe.am.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.FilterPersona;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.PersonaIns;
import pe.am.spring.entity.PersonaUpd;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TAddressPerson;
import pe.am.spring.entity.TAddressPersonGet;
import pe.am.spring.entity.TAddressPersonPost;
import pe.am.spring.entity.TAddressPersonPut;
import pe.am.spring.entity.TDni;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmailPersonPost;
import pe.am.spring.entity.TEmailPersonPut;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TLegalPersonPost;
import pe.am.spring.entity.TLegalPersonPut;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TNaturalPersonPost;
import pe.am.spring.entity.TNaturalPersonPut;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPersonPost;
import pe.am.spring.entity.TPersonPut;
import pe.am.spring.entity.TPhonePerson;
import pe.am.spring.entity.TPhonePersonGet;
import pe.am.spring.entity.TPhonePersonPost;
import pe.am.spring.entity.TPhonePersonPut;
import pe.am.spring.entity.TSunat;
import pe.am.spring.entity.TUbigeo;
import pe.am.spring.entity.TUbigeoGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.AddressPersonRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.EmailPersonRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.NaturalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.PhonePersonRest;
import pe.am.spring.rest.SunatRest;
import pe.am.spring.service.PersonaService;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/persona")
public class PersonController {
	protected static Logger logger = Logger.getLogger(PersonController.class);
	
	@Autowired
	PersonRest personrest;

	@Autowired
	NaturalPersonRest naturalPersonRest;
	
	@Autowired
	EmailPersonRest emailPersonRest;
	
	@Autowired
	AddressPersonRest addressPersonRest;
	
	@Autowired
	PhonePersonRest phonePersonRest;
	
	@Autowired
	LegalPersonRest legalPersonRest;
	
	@Autowired
	CatalogueRest catalogueRest;
	
	@Autowired
	PersonaService personaService;
	
	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model,HttpSession ses,HttpServletRequest rq) throws IOException {
		String util = Util.getHostPerson();
		System.out.println(util);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
//			if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
//				logger.info("Si tiene Acceso a la pagina");
//			}else {
//				model.setViewName("/Permiso/PermidoDenegado");
//				return model;
//			}
		}else {
			model.setViewName("/homepost");
			return model;
		}
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
//		model.setViewName("/Cliente/Cliente");
		try {
			TPersonGet filtro = new TPersonGet();
			filtro.setPersVtradename("pers_vtradename");
			filtro.setPersVdoctype("pers_vdoctype");
			filtro.setPersVnumdoc("pers_vnumdoc");
			filtro.setPersCperstype("pers_cperstype");
			filtro.setPersVubigeo("pers_vubigeo");
			filtro.setPersTregistrationDate(new Date());
			filtro.setPersTdateUpdate(new Date());
			filtro.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TPerson> response = personrest.getPerson(filtro,beanDS);
			model.addObject("DtoPerson", response.getResultados());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/persona")
	public ModelAndView persona(ModelAndView model) throws IOException {
		String util = Util.getHostPerson();
		System.out.println(util);
		model.setViewName("/Persona/modalPersona");
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value = "/validaPersona", method = RequestMethod.POST)
	@ResponseBody
	public String listartia(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "tipdoc", required = true) String tipdoc,
			@RequestParam(value = "numerodoc", required = true) String numerodoc,
			@RequestParam(value = "tipoperson", required = true) String tipoperson) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		if (beanDS == null) {
			beanDS=Util.getcadenaConexion2();
		}
		JsonObject robject = new JsonObject();
		// consultar sunat
		try {
			FilterPersona filtro=new FilterPersona();
			filtro.setTipodoc(tipdoc);
			filtro.setNumdoc(numerodoc);
			//filtro.setTipopersona(tipoperson);
			try {
				  String hostUri = Util.getconsultarDni();
		           // Se abre la conexión.
		           URL url = new URL(hostUri+numerodoc);
		           URLConnection conexion = url.openConnection();
		           conexion.connect();
		           System.out.println("se revisa datos de conexion"+ conexion);
		           
		           // Lectura
		           InputStream is = conexion.getInputStream();
		           BufferedReader br = new BufferedReader(new InputStreamReader(is));
		           char[] buffer = new char[1000];
		           int leido;
		           while ((leido = br.read(buffer)) > 0) {
		              String DniPersona = new String(buffer, 0, leido);
		              System.out.println("persona consultado en Reniec:"+DniPersona );
		              String[] DniPersonas= DniPersona.split("\\|");
		              String Nombre = DniPersonas[2];
		              String ApePaterno = DniPersonas[0];
		              String ApeMaterno = DniPersonas[1];
		              String Estado = "consultado en RENIEC";
						robject.addProperty("nombre", Nombre);
						robject.addProperty("apetpat", ApePaterno);
						robject.addProperty("apetmat", ApeMaterno);
						robject.addProperty("msgrespr", DniPersona);
						robject.addProperty("estadoColor", Estado.equals("consultado en RENIEC")?"alert alert-success":"alert alert-danger");
						robject.addProperty("condicionDomicilioColor", Estado.equals("HABIDO")?"alert alert-success":"alert alert-danger");
					
		           }
		        } catch (MalformedURLException e) {
		           // TODO Auto-generated catch block
		           e.printStackTrace();
		        } catch (IOException e) {
		           // TODO Auto-generated catch block
		           e.printStackTrace();
		        }
			PaginaResultado<FilterPersona> lstFilterPersona= personrest.getPerson(filtro,beanDS);
			if(lstFilterPersona.getCantidad()>0){
				FilterPersona filterPersona=mapper.convertValue(lstFilterPersona.getResultados().get(0), FilterPersona.class);
				robject.addProperty("idtipodoc", filterPersona.getIdtipodoc());
				robject.addProperty("numdoc", filterPersona.getNumdoc());
				robject.addProperty("nombre", filterPersona.getNombre());
				robject.addProperty("apetpat", filterPersona.getApetpat());
				robject.addProperty("apetmat", filterPersona.getApetmat());
				robject.addProperty("email", filterPersona.getEmail());
				robject.addProperty("telefono", filterPersona.getTelefono());
				robject.addProperty("idpais",filterPersona.getIdpais().toString());
				robject.addProperty("idubigeo", filterPersona.getIdubigeo());
				robject.addProperty("direccion", filterPersona.getDireccion());
				robject.addProperty("tipoPerson", filterPersona.getTipopersona());
				robject.addProperty("nombreComercial", filterPersona.getNomcomercial());
				robject.addProperty("razonSocial", filterPersona.getRazonsocial());
				robject.addProperty("domiciled", filterPersona.getDomiciled());
				robject.addProperty("msgresp", "1");
			}else{
				if(tipdoc.equals("6")) {
					TSunat tSunat=personaService.consultarsunat(numerodoc,beanDS);
					if(tSunat!=null) {
						if(tSunat.getTipoPersona().equals("N")) {
							String nombre=tSunat.getNombre();
							String apetPat="";
							String apetMat="";
							apetPat=nombre.substring (0,nombre.indexOf(' '));
							nombre=nombre.substring (nombre.indexOf(' ')+1,nombre.length());
							apetMat=nombre.substring (0,nombre.indexOf(' '));
							nombre=nombre.substring (nombre.indexOf(' ')+1,nombre.length());
							robject.addProperty("nombre", nombre);
							robject.addProperty("apetpat", apetPat);
							robject.addProperty("apetmat", apetMat);
						}else if(tSunat.getTipoPersona().equals("L")){
							robject.addProperty("razonSocial", tSunat.getNombre());
						} 
						// obtener ubigeo
						TUbigeoGet filtroUbigeo = new TUbigeoGet();
						filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
						filtroUbigeo.setUbigInei(tSunat.getUbigeo());
						PaginaResultado<TUbigeo> respUbigeo = catalogueRest.getUbigeo(filtroUbigeo,beanDS);
						TUbigeo ubigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
						robject.addProperty("direccion", tSunat.getDireccion().replaceAll("-", "").trim());
						robject.addProperty("idubigeo", ubigeo.getUbigIident());
						robject.addProperty("msgresp", "3");
						robject.addProperty("tipoPerson", tSunat.getTipoPersona());
						robject.addProperty("estado", tSunat.getEstado());
						robject.addProperty("estadoColor", tSunat.getEstado().equals("ACTIVO")?"alert alert-success":"alert alert-danger");
						robject.addProperty("condicionDomicilio", tSunat.getCondicionDomicilio());
						robject.addProperty("condicionDomicilioColor", tSunat.getCondicionDomicilio().equals("HABIDO")?"alert alert-success":"alert alert-danger");
					}else{
						robject.addProperty("msgresp", "2");	
					}
				}else if(tipdoc.equals("1")) {
					TDni tDni=personaService.consultarDni(numerodoc,beanDS);
					if(tDni!=null) {
							String nombre=tDni.getNombre();
							String apetPat="";
							String apetMat="";
							apetPat=nombre.substring (0,nombre.indexOf(' '));
							nombre=nombre.substring (nombre.indexOf(' ')+1,nombre.length());
							apetMat=nombre.substring (0,nombre.indexOf(' '));
							nombre=nombre.substring (nombre.indexOf(' ')+1,nombre.length());
							robject.addProperty("nombre", nombre);
							robject.addProperty("apetpat", apetPat);
							robject.addProperty("apetmat", apetMat);
						// obtener ubigeo
						TUbigeoGet filtroUbigeo = new TUbigeoGet();
						filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
						filtroUbigeo.setUbigInei(tDni.getUbigeo());
						PaginaResultado<TUbigeo> respUbigeo = catalogueRest.getUbigeo(filtroUbigeo,beanDS);
						TUbigeo ubigeo = mapper.convertValue(respUbigeo.getResultados().get(0), TUbigeo.class);
						robject.addProperty("direccion", tDni.getDireccion().replaceAll("-", "").trim());
						robject.addProperty("idubigeo", ubigeo.getUbigIident());
						robject.addProperty("msgresp", "4");
						robject.addProperty("tipoPerson", "N");
						robject.addProperty("estado", tDni.getEstado());
						robject.addProperty("estadoColor", tDni.getEstado().equals("ACTIVO")?"alert alert-success":"alert alert-danger");
						robject.addProperty("condicionDomicilio", tDni.getCondicionDomicilio());
						robject.addProperty("condicionDomicilioColor", tDni.getCondicionDomicilio().equals("HABIDO")?"alert alert-success":"alert alert-danger");
					}else{
						robject.addProperty("msgresp", "2");	
					}
				}
				else {
					robject.addProperty("msgresp", "2");
				}
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
	
	
	
	@RequestMapping(value = "/administrarPersona", method = RequestMethod.POST)
	@ResponseBody
	public String administrarPersona(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "tipoDoc", required = true) String tipoDoc,
			@RequestParam(value = "numdoc", required = true) String numdoc,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "apetpat", required = true) String apetpat,
			@RequestParam(value = "apetMat", required = true) String apetMat,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "telefono", required = true) String telefono,
			@RequestParam(value = "idpais", required = true) String idpais,
			@RequestParam(value = "idlocalidad", required = true) String idlocalidad,
			@RequestParam(value = "direccion", required = true) String direccion,
			@RequestParam(value = "razonsocial", required = true) String razonsocial,
			@RequestParam(value = "nombrecomercial", required = true) String nombrecomercial,
			@RequestParam(value = "tipoPerson", required = true) String tipoPerson,
			@RequestParam(value = "proceso", required = true) String proce,
			@RequestParam(value = "domiciled", required = true) String domiciled
			){
		ObjectMapper mapper = new ObjectMapper();
		JsonObject robject = new JsonObject();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		String pJsonData="";
		try {
			System.out.println("aqui inserta");
			Gson gson2 = new Gson();
			if(proce.equals("I")){
			/** Insertar Persona  **/
				TNaturalPersonPost tNaturalPerson=null;
				TLegalPersonPost tLegalPerson=null;
				if(tipoPerson.equals("N")){
					tNaturalPerson=new TNaturalPersonPost();
					tNaturalPerson.setNatuVname(nombre.toUpperCase());
					tNaturalPerson.setNatuVlastnamefather(apetpat.toUpperCase());
					tNaturalPerson.setNatuVlastnamemother(apetMat.toUpperCase());
				}else if(tipoPerson.equals("L")){
					tLegalPerson=new TLegalPersonPost();
					tLegalPerson.setLegaBusiname(razonsocial.toUpperCase());
				}
				TPersonPost tPerson=new TPersonPost();
				tPerson.setPersVdoctype(tipoDoc);
				tPerson.setPersVnumdoc(numdoc);
				tPerson.setPersCperstype(tipoPerson);
				tPerson.setPersVtradename(nombrecomercial);
				tPerson.setPersBcodcountry(new Long(idpais));
				tPerson.setPersVubigeo(idlocalidad);
				tPerson.setPersTregistrationDate(new Date());
				tPerson.setPersBuserModify(user.getPersBident());//corregir el bd debe ser  getUserVuser en la tabla esta como bigint
				tPerson.setPersVdomiciled(domiciled);
				List<TEmailPersonPost> lstTEmailPerson=new ArrayList<TEmailPersonPost>();
				TEmailPersonPost tEmailPerson=new TEmailPersonPost();
				tEmailPerson.setMailBstate(true);
				tEmailPerson.setMailVemail(email);
				tEmailPerson.setMailVmain("P");
				lstTEmailPerson.add(tEmailPerson);
				List<TAddressPersonPost> lstTAddressPerson=new ArrayList<TAddressPersonPost>();
				TAddressPersonPost tTAddressPerson=new TAddressPersonPost();
				tTAddressPerson.setAddrVaddress(direccion);
				tTAddressPerson.setAddrVmain("P");
				tTAddressPerson.setAddrBstate(true);
				lstTAddressPerson.add(tTAddressPerson);
				List<TPhonePersonPost> lstTPhonePerson=new ArrayList<TPhonePersonPost>();
				TPhonePersonPost tPhonePerson=new TPhonePersonPost();
				tPhonePerson.setPhonVphone(telefono);
				tPhonePerson.setPhonVmain("P");
				tPhonePerson.setPhonBstate(true);
				lstTPhonePerson.add(tPhonePerson);
				logger.info(" Insertando persona");
				PersonaIns personaIns=new PersonaIns();
				personaIns.settNaturalPerson(tNaturalPerson);
				personaIns.settLegalPerson(tLegalPerson);
				personaIns.settPerson(tPerson);
				personaIns.settEmailPersonLista(lstTEmailPerson);
				personaIns.settAddressPersonLista(lstTAddressPerson);
				personaIns.settPhonePersonLista(lstTPhonePerson);
				pJsonData = gson2.toJson(personaIns);
				logger.info("Data para Insertar Persona: "+pJsonData);
				List<PersonaIns> lstPersonaIns=new ArrayList<PersonaIns>();
				lstPersonaIns.add(personaIns);
				lstPersonaIns=personrest.postInsertPersona(lstPersonaIns,beanDS);
				personaIns=mapper.convertValue(lstPersonaIns.get(0),PersonaIns.class);
				pJsonData = gson2.toJson(personaIns.gettPerson());
				logger.info("rsp del servicio: "+pJsonData);
				robject.addProperty("msg", "ok");
				robject.addProperty("info", pJsonData);
			}else if(proce.equals("M")){
				TNaturalPersonPut tNaturalPersonPut=null;
				TLegalPersonPut tLegalPersonPut=new TLegalPersonPut();
				TPersonPut tPersonPut=new TPersonPut();
				TEmailPersonPut TEmailPersonPut=new TEmailPersonPut();
				TAddressPersonPut tAddressPersonPut=new TAddressPersonPut();
				TPhonePersonPut tPhonePersonPut=new TPhonePersonPut();
				PersonaUpd personaUpd=new PersonaUpd();
				
			/** Actualizar Persona  **/
				//buscar en la t_person
				TPersonGet filtroPerson=new TPersonGet();
				filtroPerson.setPaginacion(new PaginacionFiltro(1, 1));
				filtroPerson.setPersVnumdoc(numdoc);
				PaginaResultado<TPerson> rspPerson=personrest.getPerson(filtroPerson,beanDS);
				TPerson tPersonGet=mapper.convertValue(rspPerson.getResultados().get(0),TPerson.class);
				BeanUtils.copyProperties(tPersonGet, tPersonPut);
				tPersonPut.setPersTdateUpdate(new Date());
				tPersonPut.setPersVubigeo(idlocalidad);
				tPersonPut.setPersBcodcountry(new Long(idpais));
				//buscar en la t_person_email
				TEmailPersonGet filtroEmail=new TEmailPersonGet();
				filtroEmail.setPaginacion(new PaginacionFiltro(1, 1));
				filtroEmail.setPersBident(tPersonGet.getPersBident());
				PaginaResultado<TEmailPerson> rspEmailPerson=emailPersonRest.getEmailPerson(filtroEmail,beanDS);
				TEmailPerson tEmailPersonGet=mapper.convertValue(rspEmailPerson.getResultados().get(0),TEmailPerson.class);
				BeanUtils.copyProperties(tEmailPersonGet, TEmailPersonPut);
				TEmailPersonPut.setMailVemail(email);
				//buscar en la t_person_address
				TAddressPersonGet filtroAddres=new TAddressPersonGet();
				filtroAddres.setPaginacion(new PaginacionFiltro(1, 1));
				filtroAddres.setPersBident(tPersonGet.getPersBident());
				PaginaResultado<TAddressPerson> rspAddressPerson=addressPersonRest.getAddressPerson(filtroAddres,beanDS);
				TAddressPerson tAddressPersonGet=mapper.convertValue(rspAddressPerson.getResultados().get(0),TAddressPerson.class);
				BeanUtils.copyProperties(tAddressPersonGet, tAddressPersonPut);
				tAddressPersonPut.setAddrVaddress(direccion);
				//buscar en la t_person_phone
				TPhonePersonGet filtroPhone=new TPhonePersonGet();
				filtroPhone.setPaginacion(new PaginacionFiltro(1, 1));
				filtroPhone.setPersBident(tPersonGet.getPersBident());
				PaginaResultado<TPhonePerson> rspPhonePerson= phonePersonRest.getPhonePerson(filtroPhone,beanDS);
				TPhonePerson tPhonePersonGet=mapper.convertValue(rspPhonePerson.getResultados().get(0),TPhonePerson.class);
				BeanUtils.copyProperties(tPhonePersonGet, tPhonePersonPut);
				tPhonePersonPut.setPhonVphone(telefono);
				//buscar en la t_person
				if(tipoPerson.equals("N")){
					//buscar en la t_person_natural
					tNaturalPersonPut=new TNaturalPersonPut();
					TNaturalPersonGet filtroNatPerson=new TNaturalPersonGet();
					filtroNatPerson.setPaginacion(new PaginacionFiltro(1, 1));
					filtroNatPerson.setNatuBident(tPersonGet.getNatuBident());
					PaginaResultado<TNaturalPerson> rspPersonNatural=naturalPersonRest.getNaturalPerson(filtroNatPerson,beanDS);
					TNaturalPerson tNaturalPersonGet=mapper.convertValue(rspPersonNatural.getResultados().get(0),TNaturalPerson.class);
					BeanUtils.copyProperties(tNaturalPersonGet, tNaturalPersonPut);
				}else if(tipoPerson.equals("L")){
					//buscar en la t_person_legal
					TLegalPersonGet filtroPersonLegal=new TLegalPersonGet();
					filtroPersonLegal.setPaginacion(new PaginacionFiltro(1, 1));
					filtroPersonLegal.setLegaBident(tPersonGet.getLegaBident());
					PaginaResultado<TLegalPerson> rspPersonLegal=legalPersonRest.getLegalPerson(filtroPersonLegal,beanDS);
					TLegalPerson tLegalPersonGet=mapper.convertValue(rspPersonLegal.getResultados().get(0),TLegalPerson.class);
					BeanUtils.copyProperties(tLegalPersonGet, tLegalPersonPut);
				}
				//creando el objeto para actualizar la persona
				personaUpd.settPersonPut(tPersonPut);
				personaUpd.settNaturalPersonPut(tNaturalPersonPut);
				personaUpd.settLegalPersonPut(tLegalPersonPut);
				personaUpd.setTEmailPersonPutLista(TEmailPersonPut);
				personaUpd.settPhonePersonLista(tPhonePersonPut);
				personaUpd.settAddressPersonLista(tAddressPersonPut);
				List<PersonaUpd> LstPersonaUpd=new ArrayList<PersonaUpd>();
				LstPersonaUpd.add(personaUpd);
				pJsonData = gson2.toJson(LstPersonaUpd.get(0).gettPersonPut());
				logger.info("Data para actualizar Persona: "+pJsonData);
				personrest.postUpdatePersona(LstPersonaUpd,beanDS);
				robject.addProperty("msg", "ok");
				robject.addProperty("info", pJsonData);
				
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("objperson", pJsonData);
		return new Gson().toJson(robject);
		
	}
}
