package pe.am.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import pe.am.spring.dao.ContactDAO;
import pe.am.spring.dao.CtrUsuario;
import pe.am.spring.model.Contact;
import pe.am.spring.service.ContactService;
import pe.am.spring.service.PersonaService;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.am.spring.model.DtoEmpresa;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.am.spring.dao.CtrEmpresa;
import pe.am.spring.dao.CtrPeriodo;
import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.CorreoPersona;
import pe.am.spring.entity.DetalleMenu;
import pe.am.spring.entity.EmailGet;
import pe.am.spring.entity.ModuloMenu;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.RequestMenu;
import pe.am.spring.entity.RptaGenerica;
import pe.am.spring.entity.TBranchOffice;
import pe.am.spring.entity.TBranchOfficeGet;
import pe.am.spring.entity.TBusinessBDFilter;
import pe.am.spring.entity.TBusinessBDFilterGet;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TEmployeeGet;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TProfile;
import pe.am.spring.entity.TProfileGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;
import pe.am.spring.entity.TUserFilterGet;
import pe.am.spring.entity.TUserGet;
import pe.am.spring.entity.TUserPut;
import pe.am.spring.model.DtoPerfil;
import pe.am.spring.model.DtoPeriodo;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.model.Usuario;
import pe.am.spring.rest.AddressPersonRest;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.EmailRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.NaturalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.PhonePersonRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.rest.VentasRest;
import pe.am.spring.rest.EmailPersonRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Security;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private ContactService contactService;

	@Autowired
	private CtrUsuario ctrUsuario;

	@Autowired
	private CtrEmpresa ctrEmpresa;

	@Autowired
	private CtrPeriodo ctrPeriodo;
	
	@Autowired
	private TUserRest tUserRest;
	
	@Autowired
	private BussinesRest bussinesRest;
	
	@Autowired
	EmailRest emailRest;
	
	@Autowired
	PersonRest personRest;
	
	@Autowired
	EmailPersonRest EmailPersonRest;
	
	@Autowired
	TUserRest UserRest;
	
	@Autowired
	LegalPersonRest legalPersonRest;

	@Autowired
	PersonRest PersonRest;	
	@Autowired
	BussinesRest BussinesRest;

	@Autowired
	AddressPersonRest AddressPersonRest;
	@Autowired
	PhonePersonRest PhonePersonRest;
//
	@Autowired 
	CatalogueRest CataRest;
	@Autowired
	NaturalPersonRest NaturalPersonRest;
	

	@Autowired
	VentasRest ventasRest;
	
	@Autowired
	PersonaService personaService;

	protected static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		String hostUri = Util.getconsultarEmpresas();
		System.out.println(hostUri);		
		System.out.println("-- Registrados en propertie--");
	    List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
	    if (hostUri != null){
	    String[] empre = hostUri.split(";"); 	   
		    for (String empresaConsulta : empre) {
		    	HashMap<String, Object> map = new HashMap<>();
		    	map.put("empresaConsulta", empresaConsulta);	
		    	objLista.add(map);
		    	model.addObject("empresasprueba", empre);
		    }
	    }
	List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");
		return model;
	}
	
	
	@RequestMapping(value = "/crearusuario")
	public ModelAndView crearUsuario(ModelAndView model) throws IOException {
		String hostUri = Util.getconsultarEmpresas();
		System.out.println(hostUri);		
		System.out.println("-- Registrados en propertie--");
	    List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
	    if (hostUri != null){
	    String[] empre = hostUri.split(";"); 	   
		    for (String empresaConsulta : empre) {
		    	HashMap<String, Object> map = new HashMap<>();
		    	map.put("empresaConsulta", empresaConsulta);	
		    	objLista.add(map);
		    	model.addObject("empresasprueba", empre);
		    }
	    }
	List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("Usuario/crearUserHome");
		BeanDS beanDS=Util.getcadenaConexion2();
		model=personaService.cargarPersona(model,beanDS);
		ObjectMapper mapper = new ObjectMapper();
		try {
			/** Lista Perfil **/
			
			TProfileGet filtros = new TProfileGet();
			filtros.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtros.setProfBstate(Constantes.estadoPerfil.HABILITADO.getCode());
			PaginaResultado<TProfile> responses = UserRest.getProfile(filtros,beanDS);
			TProfile pro = new TProfile();
			List<TProfile> lstProf = new ArrayList<>();
			for (Object prof : responses.getResultados()) {
				pro = mapper.convertValue(prof, TProfile.class);
				//quitando el superadmin y el admin
				if(!pro.getProfBident().toString().equals(Constantes.ID_PERSIL_SYS) ) {
					lstProf.add(pro);
				}
				
			}
			model.addObject("listaProfile", lstProf);		
			
			
			TBussinesFilterGet filtroEmpresa=new TBussinesFilterGet();
			filtroEmpresa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TBussinesFilter> rspBussines=BussinesRest.getBussinesFilter(filtroEmpresa,beanDS);
//			PaginaResultado<TUser>rspTUser= UserRest.getUser(filtroUsuario,beanDS);
			TBussinesFilter tBussines =mapper.convertValue(rspBussines.getResultados().get(0), TBussinesFilter.class);
//			model=personaService.cargarPersonaEdit(model,TBussinesFilter.get(),beanDS);
			model.addObject("busibident", tBussines.getBusibident());
//			TBussinesFilter tBussines = new TBussinesFilter();
//			if (rspBussines != null && rspBussines.getCantidad() > 0) {
//				tBussines = mapper.convertValue(rspBussines.getResultados().get(0), TBussinesFilter.class);
//			}
//			model.addObject("busibident", tBussines.getBusibident());
			
			
			logger.info("Listando estado de sucursales");
			TBranchOfficeGet filtrosoffice = new TBranchOfficeGet();
			filtrosoffice.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
//			if (tEmployee != null) {
//				filtrosoffice.setBusiBident(tEmployee.getBusiBident());
//			}
//			filtrosoffice.setOffiBident(new Long(idOffice));
			// filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TBranchOffice> responseLG = BussinesRest.getSucursal(filtrosoffice, beanDS);
			TBranchOffice procataoffice = new TBranchOffice();
			List<TBranchOffice> lstCatDocoffice = new ArrayList<>();
			for (Object catdetoffice : responseLG.getResultados()) {
				procataoffice = mapper.convertValue(catdetoffice, TBranchOffice.class);
				lstCatDocoffice.add(procataoffice);
			}
			model.addObject("lstTBussines", lstCatDocoffice);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoute(ModelAndView model, HttpSession ses) throws IOException {
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		ses.setAttribute(Constantes.SESION_USUARIO, null);
		ses.setAttribute(Constantes.SESION_ROLE, null);
		ses.setAttribute(Constantes.SESION_EMPLEADO, null);
		ses.setAttribute(Constantes.SESION_USUARIO_FILTER, null);
//		model.addObject("empresa", empresa);
		model.setViewName("home");
		return model;
	}
	
	
	
	@RequestMapping(value = "/enviarpassword")
	public ModelAndView mailPassword(ModelAndView model) throws IOException {
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("correoPassword");
		return model;
		
	}
	
	
	
	@RequestMapping(value = "/enviarpass")
	public ModelAndView mailPassword2(ModelAndView model) throws IOException {
		String hostUri = Util.getconsultarEmpresas();
		System.out.println(hostUri);		
		System.out.println("--Registrados en propertie-------");
	    List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
	    if (hostUri != null){
	    String[] empre = hostUri.split(";"); 	   
		    for (String empresaConsulta : empre) {
		    	HashMap<String, Object> map = new HashMap<>();
		    	map.put("empresaConsulta", empresaConsulta);	
		    	objLista.add(map);
		    	model.addObject("empresalista", empre);
		    }
	    }
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
	    model.setViewName("correoPassword");	
		return model;
	}
	
	@RequestMapping(value = "/cambiarpassword/{parameter1}/{parameter2}")
	public ModelAndView changePassword(ModelAndView model,
			@PathVariable String parameter1, RedirectAttributes redirectAttrs
			,@PathVariable String parameter2) throws IOException {
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		
		Date Primeroenllegar= new Date();
		Primeroenllegar.setTime(new Long(parameter2));
		System.out.println("ahora  1 "+Primeroenllegar);
		
		Calendar fechaInicial=Calendar.getInstance();
		fechaInicial.setTime(new Date());
		fechaInicial.setTimeInMillis(new Long(parameter2));
		Date dateIni = fechaInicial.getTime();
		dateIni = DateUtils.addHours(dateIni, 24);
	    long myLong2 = dateIni.getTime();
	    System.out.println("Fecha nueva Date:"+dateIni.getTime());
	    parameter2 = Long.toString(myLong2);
//		parameter1=Security.getSHA256(correo_user);
	    
		Date now= new Date();
//		dateIni = formatter.parse(parameter2);
		Date ahora= new Date();
		ahora.setTime(new Long(parameter2));
		System.out.println("ahora  1 "+ahora);
		System.out.println("cambiarpassword 4 "+now);
		System.out.println("cambiarpassword 4.5 "+dateIni);
		if(dateIni.before(now)) {
			
			model.setViewName("correoPassword");
			
		}else {
		//esta vigente y debe cargar la pagina para mostrar la pantalla de cambiar contraseña

			model.setViewName("cambiarPassword");
			model.addObject("iduser",parameter1);
	}
 
		return model;
	}

	
	@RequestMapping(value = "/ActualizarPass", method = RequestMethod.POST)
	@ResponseBody
	public String ActualizarPass(
		HttpSession ses, HttpServletRequest rq,
		@RequestParam(value = "iduser", required = false) String iduser,
		@RequestParam(value = "user_vpassword", required = false) String user_vpassword
		) {
		ObjectMapper mapper = new ObjectMapper();
	
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		try {
			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA PERSONA       ----------------------------------------------*/
			/*********************************************************************************************************/
			TPersonGet filtro = new TPersonGet();
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			System.out.println("se genera con el hash "+Security.getSHA256(iduser));
			System.out.println("este es el pass "+user_vpassword);
			
			filtro.setPersCperstype("N");
			PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
			TPerson empreJuri= new TPerson();
			if(response!=null && response.getCantidad()>0) {
				empreJuri = mapper.convertValue(response.getResultados().get(0),TPerson.class);
			}


			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA PERSONA NATURAL       -------------------------------------*/
			/*********************************************************************************************************/
			
			 TNaturalPersonGet FiltroNaturalPersonGetRL=new TNaturalPersonGet();
			 FiltroNaturalPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
			 FiltroNaturalPersonGetRL.setNatuBident(empreJuri.getNatuBident());
				PaginaResultado<TNaturalPerson> responseTNaturalPersonRL=NaturalPersonRest.getNaturalPerson(FiltroNaturalPersonGetRL,beanDS);
				TNaturalPerson tNaturalPerson =new TNaturalPerson();
				if(responseTNaturalPersonRL!=null && responseTNaturalPersonRL.getCantidad()>0) {
					tNaturalPerson = mapper.convertValue(responseTNaturalPersonRL.getResultados().get(0), TNaturalPerson.class);
			 }
			/*********************************************************************************************************/
			/*---------------------------       ACTUALIZA USUARIO       ----------------------------------------------*/
			/*********************************************************************************************************/
			
			
			TUserGet FiltroUserPersonGet=new TUserGet();
			FiltroUserPersonGet.setPaginacion(new PaginacionFiltro(1, 1));
			System.out.println("Usuario "+ iduser);
			FiltroUserPersonGet.setUserToken(iduser);
			PaginaResultado<TUser> responseTUserPerson=UserRest.getUser(FiltroUserPersonGet,beanDS);
			TUser tUsePerson =new TUser();
			if(responseTUserPerson!=null && responseTUserPerson.getCantidad()>0) {
				tUsePerson = mapper.convertValue(responseTUserPerson.getResultados().get(0), TUser.class);
			}
			List<TUserPut> lstTUserPersonPut = new ArrayList<TUserPut>();
			TUserPut TUserPerson = new TUserPut();
			BeanUtils.copyProperties(tUsePerson, TUserPerson);
			TUserPerson.setUserTdateUpdate(new Date());	
			TUserPerson.setUserVpassword(Security.generateHash(user_vpassword));
			lstTUserPersonPut.add(TUserPerson);
			System.out.println(TUserPerson);
			
			UserRest.putUser(lstTUserPersonPut,beanDS);		
			System.out.println(lstTUserPersonPut);
			
//			
			JsonObject robject = new JsonObject();
		  	robject.addProperty("msg", "ok");
		     return new Gson().toJson(robject);

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Ocurrio un error");
			JsonObject robject = new JsonObject();
		  	robject.addProperty("msg", "error");
		      return new Gson().toJson(robject);
		}
	
	      
	}

	
	
	
	
	
	
	public static String generarCorreo(String parameter1, String parameter2) {
		String html = "";
		try {
			html = "<!DOCTYPE html>\n" + "<html lang=\"en\">     <head>         <meta charset=\"utf-8\">         \n"
					+ "<body>  \n"
					+ "<div style=\"color: #2e6c80; text-align: center\"><img src=\"http://aymasesoresperu.dyndns.org:8080/files/logo.png\" width=\"286\" height=\"96\"></div>\n"
					+ "\n" + "  <br>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: center;\">¿Has olvidado tu contraseña? </h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: center;\">Mediante este mensaje podras cambiarla, Recuerde que tiene 24 horas de vigencia para el cambio de contraseña</h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: center;\">Para continuar con el proceso haz click en el siguiente botón: </h3>\n"
					+ "  <div style=\"color: #2e6c80; text-align: center\">"
					// es
					+ "<a href=\"http://aymasesoresperu.dyndns.org:8080/SistemaFE/cambiarpassword/" + parameter1 + "/"
					+ parameter2 + "\">"

					+ "<img src=\"http://www.vallenatofm.com/wp-content/uploads/2015/05/boton-ir.png\" ></a>"
					+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html> ";

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return html;
	}
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}

	@RequestMapping(value = "/newInicio", method = RequestMethod.GET)
	public ModelAndView newInicio(ModelAndView model) {
		Contact newContact = new Contact();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdate(contact);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		return model;
	}
	

	@RequestMapping(value = "/enviarcorreopasswordNew", method = RequestMethod.GET)
	public @ResponseBody String  enviarCorreo2(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "correo_user", required = false,defaultValue="") String correo_user,
			 RedirectAttributes redirectAttrs
			
	) {
		System.out.println("===========Inicio-> comprobante/enviarcorreopassword ");
		ObjectMapper mapper = new ObjectMapper();
		ModelAndView model= new ModelAndView();
		String url = "";
		
		JsonObject robject = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			
			String parameter1="";
			String parameter2="";
			Calendar fechaInicial=Calendar.getInstance();
			fechaInicial.setTime(new Date());
			Date dateIni = fechaInicial.getTime();
		    long myLong2 = dateIni.getTime();
		    parameter2 = Long.toString(myLong2);
			
		    
			Date now= new Date();
	
//			TPersonGet filtro = new TPersonGet();
//			filtro.setPaginacion(new PaginacionFiltro(1, 1));
//			filtro.setPersVnumdoc(correo_user);
			TUserGet filtrous = new TUserGet();
			filtrous.setPaginacion(new PaginacionFiltro(1, 1));
			filtrous.setUserVuser(correo_user);
			
			
			PaginaResultado<TUser> response = UserRest.getUser(filtrous,beanDS);
			TUser empreJuri= new TUser();
			if(response!=null && response.getCantidad()>0) {
				empreJuri = mapper.convertValue(response.getResultados().get(0),TUser.class);
			
			parameter1=Security.getSHA256(correo_user);
			TEmailPersonGet FiltroEmailPersonGetEmpresa=new TEmailPersonGet();
			FiltroEmailPersonGetEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroEmailPersonGetEmpresa.setPersBident(empreJuri.getPersBident());
			PaginaResultado<TEmailPerson> responseTEmailPersonEmpresa=EmailPersonRest.getEmailPerson(FiltroEmailPersonGetEmpresa,beanDS);
			TEmailPerson tEmailPerson =new TEmailPerson();
			if(responseTEmailPersonEmpresa!=null && responseTEmailPersonEmpresa.getCantidad()>0) {
				tEmailPerson = mapper.convertValue(responseTEmailPersonEmpresa.getResultados().get(0), TEmailPerson.class);
			}
		System.out.println("Fecha AHORA 5 "+now);
			
			String Correo = tEmailPerson.getMailVemail();
			EmailGet correoRptaSunat = new EmailGet();
            List<CorreoPersona> listaTo = new ArrayList<>();
			listaTo.add(new CorreoPersona(Correo, ""));
			correoRptaSunat.setTo(listaTo);
			correoRptaSunat.setTituloMensaje("Recuperar Contraseña - Juntos Buscandote JB");

			String cuerpoMensaje = "";
			cuerpoMensaje = generarCorreo(parameter1, parameter2);
			correoRptaSunat.setCuerpoMensaje(cuerpoMensaje);
			System.out.println("Fecha nueva Date:"+cuerpoMensaje);
			
			try {
				emailRest.getVoucher(correoRptaSunat,beanDS);
				System.out.println(" nueva envio 1: "+correoRptaSunat);
			
				robject.addProperty("msg", "ok");
				robject.addProperty("cod", "1");
				robject.addProperty("url", url);
			}catch(Exception e) {
				e.printStackTrace();
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Ocurrio un error");
			}		
			
			}else {
				robject.addProperty("msg", "error");
				robject.addProperty("respuesta", "Ocurrio un error, a solucionarlos");
			}
		} catch (Exception e) {
			e.printStackTrace();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Ocurrio un errores que se tienen que solucionar");
			return new Gson().toJson(robject);

		}
		
		return new Gson().toJson(robject);
	}

	
	@RequestMapping(value = "/validLogin4", method = RequestMethod.POST)
	@ResponseBody
	public String validLogin4(@RequestParam("usuario") String usuario, @RequestParam("password") String password,
			@RequestParam("empresa") String empresa,
			HttpServletRequest request, ModelAndView model, HttpSession ses) {

		String url = "";

		//lista q obtendra los acceso del usuario logueado
		List<String> accesoMenu= new ArrayList<>();
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
//			TBusinessBDFilterGet filtroBD = new TBusinessBDFilterGet();
//			filtroBD.setPaginacion(new PaginacionFiltro(1, 1));
////			filtroBD.setPersVnumdoc("88888888888");
//			PaginaResultado<TBusinessBDFilter> responseBD = bussinesRest.getTBusinessBDFilter(filtroBD,beanDS);
//			TBusinessBDFilter businessBD = new TBusinessBDFilter();
//			ObjectMapper mapper2 = new ObjectMapper();
//			if (responseBD != null && responseBD.getCantidad() > 0) {
//				businessBD = mapper2.convertValue(responseBD.getResultados().get(0), TBusinessBDFilter.class);
//				beanDS.setId(Long.toString(businessBD.getBubdBident()));
//		    	beanDS.setUser(businessBD.getBubdVuserbd());
//		    	beanDS.setPass(businessBD.getBubdVpassbd());
//		    	beanDS.setUrl("jdbc:postgresql://aymasesoresperu.dyndns.org:5432/BDERICKSON");
			
			
			
			
			//mtoledo
			ses.setAttribute(Constantes.SESION_USUARIO_DETAIL, beanDS);
			ses.setAttribute(Constantes.SESION_EMPRESA, empresa);
			
			TUserGet usuarioGet = new TUserGet();
			usuarioGet.setUserVuser(usuario);
			usuarioGet.setPaginacion(new PaginacionFiltro(1, 1));
			PaginaResultado<TUser> usuarioList = tUserRest.getUser(usuarioGet,beanDS);
			
			if (usuarioList!=null && usuarioList.getCantidad() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				TUser userGR = mapper.convertValue(usuarioList.getResultados().get(0),
						TUser.class);
				if (Security.validarLogin(userGR.getUserVpassword() , password)) {
					if (userGR.getUserBstate().equals(true)){
						//azevallos CWA-388 - manejo de perfiles
						RequestMenu filtroMenu = new RequestMenu();
						filtroMenu.setIdPerfil(new Long(userGR.getProfBident()));
						RptaGenerica menu = tUserRest.obtenerMenu2(filtroMenu,beanDS);
						if(null!= menu && "1".equals(menu.getCodOper())) {
							String menuJson= menu.getMsjOper();
							JsonObject json = new JsonParser().parse(menuJson).getAsJsonObject();
							
							System.out.println("Menu : "+json);
							logger.info("Menu : "+json);
							System.out.println("Menu : "+json);
							List<ModuloMenu> lModulos= new ArrayList<>();
							JsonArray modulos = json.getAsJsonArray("modulos");
							for(JsonElement mod : modulos) {
								ModuloMenu mBean= new ModuloMenu();
								JsonObject modJson= mod.getAsJsonObject();
								System.out.println("modulo : "+mod);
								mBean.setId(modJson.get("id").isJsonNull()?"":modJson.get("id").getAsString());
								mBean.setLabel(modJson.get("etiqueta").isJsonNull()?"":modJson.get("etiqueta").getAsString());
								mBean.setDescripcion(modJson.get("descripcion").isJsonNull()?"":modJson.get("descripcion").getAsString());
								mBean.setIcono(modJson.get("icono").isJsonNull()?"":modJson.get("icono").getAsString());
								mBean.setEstado(modJson.get("estado").isJsonNull()?"":modJson.get("estado").getAsString());
								
								List<DetalleMenu> cabMenu= new ArrayList<>();
								JsonArray cabA = modJson.getAsJsonArray("cab_menu");
								for(JsonElement cab : cabA) {
									JsonObject cabJson= cab.getAsJsonObject();
									DetalleMenu cabM= new DetalleMenu();
									cabM.setIdMenu(cabJson.get("id_cab_menu").isJsonNull()?"":cabJson.get("id_cab_menu").getAsString());
									cabM.setEtiqueta(cabJson.get("label_cab_menu").isJsonNull()?"":cabJson.get("label_cab_menu").getAsString());
									cabM.setDescripcion(cabJson.get("descr_cab_menu").isJsonNull()?"":cabJson.get("descr_cab_menu").getAsString());
									cabM.setIcono(cabJson.get("icono_cab_menu").isJsonNull()?"":cabJson.get("icono_cab_menu").getAsString());
									cabM.setNroDetMenu(cabJson.get("nrodet_cab_menu").isJsonNull()?"":cabJson.get("nrodet_cab_menu").getAsString());
									cabM.setNroDetPadreMenu(cabJson.get("padre_nrodet_cab_menu").isJsonNull()?"":cabJson.get("padre_nrodet_cab_menu").getAsString());
									cabM.setEstadoMenu(cabJson.get("estado_cab_menu").isJsonNull()?"":cabJson.get("estado_cab_menu").getAsString());
									cabM.setIdModulo(cabJson.get("id_modulo").isJsonNull()?"":cabJson.get("id_modulo").getAsString());
									
									
									List<DetalleMenu> detMenu= new ArrayList<>();
									JsonArray detA = cabJson.get("detalle_menu").isJsonNull()?new JsonArray():cabJson.getAsJsonArray("detalle_menu");
									for(JsonElement det : detA) {
										JsonObject detJson= det.getAsJsonObject();
										DetalleMenu detM= new DetalleMenu();
										detM.setIdMenu(detJson.get("id_detalle_menu").isJsonNull()?"":detJson.get("id_detalle_menu").getAsString());
										detM.setEtiqueta(detJson.get("label_detalle_menu").isJsonNull()?"":detJson.get("label_detalle_menu").getAsString());
										detM.setDescripcion(detJson.get("descr_detalle_menu").isJsonNull()?"":detJson.get("descr_detalle_menu").getAsString());
										detM.setIcono(detJson.get("icono_detalle_menu").isJsonNull()?"":detJson.get("icono_detalle_menu").getAsString());
										detM.setNroDetMenu(detJson.get("nrodet_detalle_menu").isJsonNull()?"":detJson.get("nrodet_detalle_menu").getAsString());
										detM.setNroDetPadreMenu(detJson.get("padre_nrodet_detalle_menu").isJsonNull()?"":detJson.get("padre_nrodet_detalle_menu").getAsString());
										detM.setEstadoMenu(detJson.get("estado_detalle_menu").isJsonNull()?"":detJson.get("estado_detalle_menu").getAsString());
										detM.setIdModulo(detJson.get("id_modulo").isJsonNull()?"":detJson.get("id_modulo").getAsString());
										detM.setUrlMenu(detJson.get("url_detalle_menu").isJsonNull()?"":detJson.get("url_detalle_menu").getAsString());
										detMenu.add(detM);
										
										accesoMenu.add(detJson.get("url_detalle_menu").isJsonNull()?"":detJson.get("url_detalle_menu").getAsString());
									}
									cabM.setDetalleMenu(detMenu);
									cabMenu.add(cabM);
								}
								mBean.setCabMenu(cabMenu);
								lModulos.add(mBean);
							}
							ses.setAttribute(Constantes.MENU_USUARIO,lModulos);
							
							ses.setAttribute(Constantes.MENU_PERMISOS, accesoMenu);
						}else {
							System.out.println("Ocurrio un error al obtener el menu de la persona");
						}
						
					/*mtoledo user filter*/
					TUserFilterGet filtroLP = new TUserFilterGet();
		            filtroLP.setPaginacion(new PaginacionFiltro(1,1));
		            filtroLP.setUserVuser(userGR.getUserVuser());
		            PaginaResultado<TUserFilter> response = tUserRest.getUserFilter(filtroLP,beanDS);
		            TUserFilter vistaUser = mapper.convertValue(response.getResultados().get(0), TUserFilter.class);
		            ses.setAttribute(Constantes.SESION_USUARIO_FILTER, vistaUser);
		            /*mtoledo*/
					ses.setAttribute(Constantes.SESION_USUARIO, userGR);
					ses.setAttribute(Constantes.SESION_ROLE, userGR.getProfBident());
					TEmployeeGet employeeGet=new TEmployeeGet();
					employeeGet.setPaginacion(new PaginacionFiltro(1, 1));
					employeeGet.setPersBident(userGR.getPersBident());
					PaginaResultado<TEmployee> employeeList = bussinesRest.getEmployee(employeeGet,beanDS);
					mapper = new ObjectMapper();
					if(employeeList!=null && employeeList.getCantidad() > 0 && userGR.getUserBstate().equals(true) && userGR.getProfBident().equals(1l) ) {
						TEmployee tEmployee = mapper.convertValue(employeeList.getResultados().get(0), TEmployee.class);
						ses.setAttribute(Constantes.SESION_EMPLEADO, tEmployee);
//						url = "comprobanteelectronico/";
//						jReturn.addProperty("estado", "ok");
					}else {
						ses.setAttribute(Constantes.SESION_EMPLEADO, null);
					}
					url = "usuario/";
					jReturn.addProperty("estado", "ok"); // model.setViewName("/Empresa/Empresa");				
					
				}else {
					jReturn.addProperty("estado", "error");
					jReturn.addProperty("msg", "Usuario Deshabilitado");
//					System.out.println("Pasword incorrecto!"); // model.setViewName("home");
					url = "";
				}
				}else {
					jReturn.addProperty("estado", "error");
					jReturn.addProperty("msg", "Contraseña incorrecta");
					System.out.println("Contraseña incorrecto!"); // model.setViewName("home");
					url = "";
				}

			} else {
				jReturn.addProperty("estado", "error");
				jReturn.addProperty("msg", "El usuario no se encuentra registrado");
				System.out.println("No existe el usuario");
			}
			// model.addAttribute("lUsuario", usuarioList.getResultados());
			
//			} else {
//				jReturn.addProperty("estado", "error");
//				jReturn.addProperty("msg", "Empresa no registrada");
//				System.out.println("Empresa no registrada");
//			}

		} catch (Exception e) {
			jReturn.addProperty("estado", "error");
			jReturn.addProperty("msg", "Ocurrio un error");
			e.printStackTrace();
		}

		// seteando en sesion al usuario

		// redirigiendo a la pantalla por default
		//url = "facturacionelectronica/"; // borrar despues de validar login
		// url="empresa/"; // borrar despues de validar login
		jReturn.addProperty("url", url);
		return new Gson().toJson(jReturn);
	}

	@RequestMapping(value = "/validReg6", method = RequestMethod.POST)
	@ResponseBody
	public String validReg6(@RequestParam("razonsocial") String razonsocial, @RequestParam("ruc") String ruc,
			@RequestParam("direc") String direc, @RequestParam("pais") String pais, @RequestParam("email") String email,
			@RequestParam("pagweb") String pagweb, @RequestParam("telf") String telf, @RequestParam("cel") String cel,
			HttpServletRequest request, ModelAndView model, HttpSession ses) {
		// seteando en sesion al usuario en el aplicativo
		Usuario user = new Usuario();
		user.setRucndoc(ruc);
		String url = "";

		JsonObject jReturn = new JsonObject();
		url = "facturacionelectronica/"; // borrar despues de validar login
		// url="empresa/"; // borrar despues de validar login
		jReturn.addProperty("estado", "ok");
		jReturn.addProperty("url", url);
		return new Gson().toJson(jReturn);
	}

	@RequestMapping(value = "/EnvioSunat", method = RequestMethod.POST)
	@ResponseBody
	public String validReg6(@RequestParam("beans") String beans) {
		System.out.println(beans);
		JsonObject jReturn = new JsonObject();
		jReturn.addProperty("estado", "ok");
		return new Gson().toJson(jReturn);
	}

	@RequestMapping(value = "/CargarEmpresa", method = RequestMethod.GET)
	public ModelAndView CargarEmpresa(HttpServletRequest request, Model model) {
		ModelAndView modelview = new ModelAndView("Empresa");
		try {
			DtoPerfil dtoPerfil = new DtoPerfil();
			dtoPerfil.setNomP("001");
			ArrayList<DtoEmpresa> dtoEmpresa = ctrEmpresa.Gsp_EmpCons(dtoPerfil);
			modelview.addObject("DtoEmpresa", dtoEmpresa);
		} catch (Exception e) {

		}

		return modelview;
	}

	@RequestMapping(value = "/EliminarEjercicio", method = RequestMethod.GET)
	@ResponseBody
	public String eliminarEjercicio(HttpServletRequest request, @RequestParam("rucEmpresa") String rucEmpresa,
			@RequestParam("dEjercicio") String dEjercicio, Model model) {
		JsonObject jReturn;
		jReturn = new JsonObject();

		try {
			DtoPeriodo dtoPeriodo = new DtoPeriodo();
			dtoPeriodo.setEjer(dEjercicio);
			dtoPeriodo.setRucE(rucEmpresa);
			boolean flag = true;
			dtoPeriodo = ctrPeriodo.Ctb_PrdoElim(dtoPeriodo);
			flag = dtoPeriodo.isError_flag();
			if (flag) {
				System.out.println("No se elimino el ejercicio, existe información en este ejercicio.");
				jReturn.addProperty("flag_error", true);
				jReturn.addProperty("msg_error", "No se elimino el ejercicio, existe información en este ejercicio.");
			} else {
				// se elimino correctamente
				jReturn.addProperty("flag_error", false);
			}
		} catch (Exception e) {
			System.out.println("No se elimino el ejercicio, existe información en este ejercicio.");
			jReturn.addProperty("flag_error", true);
			jReturn.addProperty("msg_error", "No se elimino el ejercicio, existe información en este ejercicio.");
		}

		DtoPeriodo periodo = new DtoPeriodo();
		periodo.setRucE("44444444444");
		periodo.setEjer("2017");
		periodo.setP00(true);
		periodo.setP01(true);
		periodo.setP02(true);
		periodo.setP03(true);
		periodo.setP04(true);
		periodo.setP05(true);
		periodo.setP06(true);
		periodo.setP07(true);
		periodo.setP08(true);
		periodo.setP09(true);
		periodo.setP10(true);
		periodo.setP11(true);
		periodo.setP12(true);
		periodo.setP13(true);
		periodo.setP14(true);
		ctrPeriodo.Ctb_PrdoModf(periodo);

		ctrPeriodo.Ctb_PrdoCons(periodo);
		ctrPeriodo.Ctb_PrdoConsUn(periodo);

		return new Gson().toJson(jReturn);
	}

	@RequestMapping(value = "/crearEjercicio", method = RequestMethod.GET)
	@ResponseBody
	public String crearEjercicio(HttpServletRequest request, @RequestParam("rucEmpresa") String rucEmpresa,
			@RequestParam("dEjercicio") String dEjercicio, Model model) {
		JsonObject jReturn;
		jReturn = new JsonObject();

		try {
			DtoPeriodo dtoPeriodo = new DtoPeriodo();
			dtoPeriodo.setEjer(dEjercicio);
			dtoPeriodo.setRucE(rucEmpresa);
			boolean flag = true;
			dtoPeriodo = ctrPeriodo.Ctb_PrdoCrea(dtoPeriodo);
			flag = dtoPeriodo.isError_flag();
			if (flag) {
				System.out.println("No se creo el ejercicio.");
				jReturn.addProperty("flag_error", true);
				jReturn.addProperty("msg_error", "No se creo el ejercicio, existe información en este ejercicio.");
			} else {
				// se elimino correctamente
				jReturn.addProperty("flag_error", false);
				jReturn.addProperty("msg_ok", "Se creó el Ejercicio correctamente.");
			}
		} catch (Exception e) {
			System.out.println("No se creo el ejercicio.");
			jReturn.addProperty("flag_error", true);
			jReturn.addProperty("msg_error", "No se creo el ejercicio.");
		}

		return new Gson().toJson(jReturn);
	}
	
	

}
