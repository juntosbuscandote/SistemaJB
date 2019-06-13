package pe.am.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.am.spring.entity.Archivo;
import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.CorreoPersona;
import pe.am.spring.entity.EmailGet;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TBranchOffice;
import pe.am.spring.entity.TBranchOfficeGet;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TEmployeeGet;
import pe.am.spring.entity.TEmployeePost;
import pe.am.spring.entity.TEmployeePut;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TOfficeUserPost;
import pe.am.spring.entity.TOfficeUserxSucursal;
import pe.am.spring.entity.TOfficeUserxSucursalGet;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPhonePerson;
import pe.am.spring.entity.TPhonePersonGet;
import pe.am.spring.entity.TProfile;
import pe.am.spring.entity.TProfileGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;
import pe.am.spring.entity.TUserFilterGet;
import pe.am.spring.entity.TUserGet;
import pe.am.spring.entity.TUserPost;
import pe.am.spring.entity.TUserPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.AddressPersonRest;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.EmailPersonRest;
import pe.am.spring.rest.EmailRest;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.NaturalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.PhonePersonRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.service.PersonaService;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Security;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	protected static Logger logger = Logger.getLogger(UsuarioController.class);
	@Autowired
	TUserRest UserRest;

	@Autowired
	LegalPersonRest legalPersonRest;

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
	PersonaService personaService;
	

	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		
		model.setViewName("/Usuario/Usuario");
//		model.setViewName("/Persona/ConfiguracionPersona");
		// validar sesion
		String NombreVentana="Usuarios";
		model.addObject("NombreVentana", NombreVentana);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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
		model=personaService.cargarPersona(model,beanDS);
		ObjectMapper mapper = new ObjectMapper();
		try {
			/*********************************************************************************************************/
			/*---------------------------     LISTA PERFIL----------------------------------------------*/
			/*********************************************************************************************************/
	
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
			/*********************************************************************************************************/
			/*---------------------------     LISTA ESTADO DE USUARIO ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar estado de usuarios de catalogue");
			TCatalogueDetGet filtrosestadousuario = new TCatalogueDetGet();
			filtrosestadousuario.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosestadousuario.setCataBident(new Long(41));
			filtrosestadousuario.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatestado = CataRest.getCatalogueDet(filtrosestadousuario,beanDS);
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

	@RequestMapping(value = "/administrarusuario")
	public @ResponseBody ModelAndView listAdministrarUsuario(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		Long idRole=null;
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
		model.setViewName("/Usuario/AdministrarUsuario");
		String NombreVentana="Configuracion Usuario";
		model.addObject("NombreVentana", NombreVentana);
		/** Cargando la data de persona **/
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

	@RequestMapping(value = "/lista_usuario", method = RequestMethod.POST)
	@ResponseBody
	public String getlistaUsuario(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmUserFiltroUsuario", required = false) String frmUserFiltroUsuario,
			@RequestParam(value = "frmUserFiltroNombre", required = false) String frmUserFiltroNombre,
		@RequestParam(value = "frmUserFiltroPerfil", required = true) String frmUserFiltroPerfil,
			@RequestParam(value = "frmUserFiltroEmpresa", required = false) String frmUserFiltroEmpresa,
			@RequestParam(value = "frmUserFiltroEstado", required = false) String frmUserFiltroEstado) {
		System.out.println("===========Inicio-> usuario/lista_usuario ");

		String sStart = rq.getParameter("draw");
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
//			TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;
			TBussinesGet bu = new TBussinesGet();
			bu.setPaginacion(new PaginacionFiltro(1,1));
			PaginaResultado<TBussines> respons = BussinesRest.getBussines(bu, beanDS);
			TBussines bussi = new TBussines();
			if (respons != null && respons.getCantidad() > 0) {
				bussi = mapper.convertValue(respons.getResultados().get(0), TBussines.class);								
			}
			TUserFilterGet filtroLP = new TUserFilterGet();
			filtroLP.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			if (bussi != null) {
				filtroLP.setBusiBident(bussi.getBusiBident());
			}
			if (frmUserFiltroUsuario != null && !frmUserFiltroUsuario.isEmpty()) {
			filtroLP.setUserVuser(frmUserFiltroUsuario);
		}
			if (frmUserFiltroNombre != null && !frmUserFiltroNombre.isEmpty()) {
				filtroLP.setNombres(frmUserFiltroNombre);
			}
		if (frmUserFiltroPerfil != null && !frmUserFiltroPerfil.isEmpty()) {
			filtroLP.setProfbident(new Long(frmUserFiltroPerfil));
			}
			if (frmUserFiltroEmpresa != null && !frmUserFiltroEmpresa.isEmpty()) {
				filtroLP.setLegaBusiname(frmUserFiltroEmpresa);
			}
			if (frmUserFiltroEstado != null && !frmUserFiltroEstado.isEmpty()) {
				Boolean estado = frmUserFiltroEstado.equals("1") ? true : false;
				filtroLP.setEstadoUsu(estado);
			}
			

			PaginaResultado<TUserFilter> response = UserRest.getUserFilter(filtroLP,beanDS);   

			List<TUserFilter> LstdoUser = null;
			if (response.getCantidad() > 0) {
				LstdoUser = response.getResultados();
			}
			List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
			
			HashMap<String, Object> obj = null;
			if (LstdoUser != null) {
				for (Object objs : LstdoUser) {
					TUserFilter vistaUser = mapper.convertValue(objs, TUserFilter.class);
					obj = new HashMap<String, Object>();
					obj.put("persBident", ObjectUtils.defaultIfNull(vistaUser.getPersBident(), ""));
					obj.put("userVuser", ObjectUtils.defaultIfNull(vistaUser.getUserVuser(), ""));
					obj.put("userNombres", ObjectUtils.defaultIfNull(vistaUser.getNombres(), ""));// aqui debe ir el
																									// nombre
																									// concatenado
					obj.put("userVdescription", ObjectUtils.defaultIfNull(vistaUser.getProfVname(), ""));
					obj.put("userTregistrationDate",
							ObjectUtils.defaultIfNull(vistaUser.getUserTregistrationDate(), ""));
					obj.put("userBusiname", ObjectUtils.defaultIfNull(vistaUser.getLegaBusiname(), ""));
					obj.put("userState", ObjectUtils.defaultIfNull(vistaUser.getEstado(), ""));
					// obj.put("employeeState",ObjectUtils.defaultIfNull (vistaUser.getEstado(),
					// ""));

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
	
	@RequestMapping(value = "/validarUsuario", method = RequestMethod.POST)
	@ResponseBody
	public String validarUsuario(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "usuario", required = false) String usuario
	) {
		JsonObject robject = new JsonObject();
		// JsonObject jReturn = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TUserGet filtroTUserGet=new TUserGet();
			filtroTUserGet.setUserVuser(usuario);
			filtroTUserGet.setPaginacion(new PaginacionFiltro(1, 1));
			PaginaResultado<TUser> rspTUser= UserRest.getUser(filtroTUserGet,beanDS);
			if(rspTUser.getCantidad()>0){
				robject.addProperty("msg", "1");
				return new Gson().toJson(robject);
			}else{
				robject.addProperty("msg", "0");
				return new Gson().toJson(robject);
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
	}


	@RequestMapping(value = "/insertarUsuario", method = RequestMethod.POST)
	@ResponseBody
	public String InsertarUsuario(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "perfil", required = false) String perfil,
			@RequestParam(value = "usuario", required = false) String usuario,
			@RequestParam(value = "contra", required = false) String contra,
			@RequestParam(value = "empreId", required = false) String empreId,
			@RequestParam(value = "sucuId", required = false) String sucuId,
			@RequestParam(value = "personId", required = false) String personId
	) {

		ObjectMapper mapper = new ObjectMapper();
		JsonObject robject = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		
		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		// JsonObject jReturn = new JsonObject();
		try {
			/** Insertar usuario **/
			List<TUserPost> lstTUserPersonPost = new ArrayList<TUserPost>();
			TUserPost TUserPerson = new TUserPost();
			TUserPerson.setProfBident(new Long(perfil));
			TUserPerson.setUserBstate(true);
			TUserPerson.setUserTregistrationDate(new Date());
			TUserPerson.setUserVpassword(Security.generateHash(contra));
			TUserPerson.setUserVuser(usuario);
			TUserPerson.setPersBident(new Long(personId));
			TUserPerson.setUserToken(Security.getSHA256(usuario));
			lstTUserPersonPost.add(TUserPerson);
			List<TUser> lstUserPerson = UserRest.postUser(lstTUserPersonPost,beanDS);
			TUser tUserPerson = mapper.convertValue(lstUserPerson.get(0), TUser.class);
//			if(perfil.equals("1")){
				List<TEmployeePost> lstTEmployeePost = new ArrayList<TEmployeePost>();
				TEmployeePost TEmployee = new TEmployeePost();
				TEmployee.setPersBident(new Long(personId));
				TEmployee.setEmplBstate(true);
				TEmployee.setEmplVposition("EMPLEADO");
				TEmployee.setBusiBident(new Long(empreId));
				TEmployee.setUserVuser(usuario);
				lstTEmployeePost.add(TEmployee);
				List<TEmployee> lstEmployee = BussinesRest.postEmployee(lstTEmployeePost,beanDS);
//			}
			
				List<TOfficeUserPost> lstTOfficeUserPost=new ArrayList<TOfficeUserPost>();
				TOfficeUserPost tOfficeUserPost=new TOfficeUserPost();
				if(perfil.equals(2)||perfil.equals(3)&&sucuId.equals(null)){
					tOfficeUserPost.setOffiBident(null);
				}
//					else if(sucuId!=""){
//					tOfficeUserPost.setOffiBident(new Long(sucuId));	
//				}
				tOfficeUserPost.setUser_vuser(usuario);
				tOfficeUserPost.setRepouserTregistrationDate(new Date());
				tOfficeUserPost.setRepouserTdateUpdate(null);
				tOfficeUserPost.setRepouserBuserRegister(tUserPerson.getUserVuser());
				tOfficeUserPost.setRepouserBuserModify(null);
				tOfficeUserPost.setRepouserBstate(Constantes.flagSucursalxUsuarioEstado.ACTIVO.getCode());
				lstTOfficeUserPost.add(tOfficeUserPost);
				List<TOfficeUserPost> lstTOfficeUserPosts=BussinesRest.postTOfficeUserFront(lstTOfficeUserPost,beanDS);				
				TOfficeUserPost tOfficeUserPostd=mapper.convertValue(lstTOfficeUserPost.get(0),TOfficeUserPost.class);
			
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
					+ "<div style=\"color: #2e6c80; text-align: center\"><img src=\"../resources/img/logoIconJB.jpg\"  width=\"286\" height=\"96\"></div>\n"
					+ "\n" + "  <br>\n"
					+ "<h1 style=\"color: #2e6c80; text-align: center;\">Bienvenido al sistema de busqueda JUNTOS BUSCANDOTE</h1>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: left;\">Srs. : <span style=\"color: #5e9ca0;\">"
					+ emp_nombre + "</span>.</h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">Es, para nosotros, muy grato dirigirnos a usted para hacerle llegar nuestro saludo y a la vez comunicarle que su  nuestro Sistema de busqueda de personas ha sido completada de manera exitosa.</h3>\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">A continuación le brindamos sus credenciales de acceso, las cuales están asociadas a los datos registrados, estas credenciales pueden ser usadas a partir de hoy:</h3>\n"
					+ " <h3 style=\"color: #2e6c80; text-align: center;\">"
					+ "Usuario: <span style=\"color: #5e9ca0;\">" + user_rl + "</span><br>\n"
					+ "  Contraseña: <span style=\"color: #5e9ca0;\">" + contra + "</span></h3>\n" + "\n"
					+ "<h3 style=\"color: #2e6c80; text-align: justify;\">Quedamos a su disposición, ante cualquier duda y/o consulta sírvase a escribir al siguiente correo: <span style=\"color: #5e9ca0;\">juntosbuscandote@gmail.com</span></h3>\n"
					+ "<p style=\"color: #2e6c80; text-align: center;\">Para ingresar al sistema haga click en el siguiente botón:</p>\n"
					+ "  <div style=\"color: #2e6c80; text-align: center\">"
					+ "<a href=\"https://juntosbuscandote.com\">"
					+ "<img src=\"http://www.vallenatofm.com/wp-content/uploads/2015/05/boton-ir.png\" ></a>"
					+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html> ";

			correoRptaSunat.setCuerpoMensaje(cuerpoMensaje);

			List<Archivo> files = new ArrayList<>();
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


	@RequestMapping(value = "/actualizarUsuario", method = RequestMethod.POST)
	@ResponseBody
	public String ActualizarUsuario(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "usuario", required = false) String usuario,
			@RequestParam(value = "contra", required = false) String contra,
			@RequestParam(value = "perfil", required = false) String perfil,
			@RequestParam(value = "personId", required = false) String personId) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TUserGet FiltroUserPersonGet = new TUserGet();
			FiltroUserPersonGet.setPaginacion(new PaginacionFiltro(1, 1));
			FiltroUserPersonGet.setPersBident(new Long(personId));
			PaginaResultado<TUser> responseTUserPerson = UserRest.getUser(FiltroUserPersonGet,beanDS);
			TUser tUsePerson = new TUser();
			if (responseTUserPerson != null && responseTUserPerson.getCantidad() > 0) {
				tUsePerson = mapper.convertValue(responseTUserPerson.getResultados().get(0), TUser.class);
			}
			List<TUserPut> lstTUserPersonPut = new ArrayList<TUserPut>();
			TUserPut TUserPerson = new TUserPut();
			BeanUtils.copyProperties(tUsePerson, TUserPerson);
			TUserPerson.setUserTdateUpdate(new Date());
			TUserPerson.setProfBident(new Long(perfil));
			lstTUserPersonPut.add(TUserPerson);
			UserRest.putUser(lstTUserPersonPut,beanDS);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	@RequestMapping(value = "/EditarUsuario", method = RequestMethod.GET)
	public ModelAndView EditarUsuario(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "usuario", required = true) String usuario,
			@RequestParam(value = "perfil", required = false) String perfil
	) throws IOException {
		
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		Long idRole = (Long) ses.getAttribute(Constantes.SESION_ROLE);
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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
		String NombreVentana="Editar Usuario";
		model.addObject("NombreVentana", NombreVentana);
		model.setViewName("/Usuario/AdministrarUsuario");
		model=personaService.cargarPersona(model,beanDS);
		try {
			TOfficeUserxSucursalGet tOfficeUser=new TOfficeUserxSucursalGet();
			tOfficeUser.setPaginacion(new PaginacionFiltro(1, 1));
			tOfficeUser.setUserVuser(usuario);
			PaginaResultado<TOfficeUserxSucursal>rspTUsers= BussinesRest.getOfficeUserxSucursal(tOfficeUser,beanDS);
			TOfficeUserxSucursal tUsers =mapper.convertValue(rspTUsers.getResultados().get(0), TOfficeUserxSucursal.class);
			TUserGet filtroUsuario=new TUserGet();
			filtroUsuario.setPaginacion(new PaginacionFiltro(1, 1));
			filtroUsuario.setUserVuser(usuario);
			PaginaResultado<TUser>rspTUser= UserRest.getUser(filtroUsuario,beanDS);
			TUser tUser =mapper.convertValue(rspTUser.getResultados().get(0), TUser.class);
			model=personaService.cargarPersonaEdit(model,tUser.getPersBident(),beanDS);
			model.addObject("userUser", tUser.getUserVuser());
			model.addObject("userPassw", tUser.getUserVpassword());
			model.addObject("perfil", tUser.getProfBident());
			if(tUsers.getOffiBident() == null){
				String sucursal="SIN SUCURSAL";
				model.addObject("lstsucursal", sucursal);
			}else{
				model.addObject("lstsucursal", tUsers.getOffiname());
			}

		

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
				if(!pro.getProfBident().toString().equals(Constantes.ID_PERSIL_SYS)  ) {
					lstProf.add(pro);
				}
				
			}
			model.addObject("listaProfile", lstProf);

			logger.info("Listando estado de sucursales");
			TBranchOfficeGet filtrosoffice = new TBranchOfficeGet();
			filtrosoffice.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
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

	@RequestMapping(value = "/detalleusuario", method = RequestMethod.POST)
	@ResponseBody
	public String listarEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "user", required = true) String user) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonObject robject = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TUserGet filtroU = new TUserGet();
			filtroU.setPaginacion(new PaginacionFiltro(1, 1));
			filtroU.setUserVuser(user);
			PaginaResultado<TUser> responseU = UserRest.getUser(filtroU,beanDS);
			TUser usuario = new TUser();
			if (responseU != null && responseU.getCantidad() > 0) {
				usuario = mapper.convertValue(responseU.getResultados().get(0), TUser.class);
			}
			robject=personaService.verPersona(usuario.getPersBident(),beanDS);
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		} catch (Exception e) {
			e.printStackTrace();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}

	@RequestMapping(value = "/EstadoUsuario", method = RequestMethod.POST)
	@ResponseBody
	public String EstadoEmpresa(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "user", required = true) String user
	// ,
	// @RequestParam(value = "emple", required = true) String emple
	) {
		TUser userL = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
//		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TPerson empreJuri= new TPerson();
			TUserGet filtroU = new TUserGet();
			filtroU.setPaginacion(new PaginacionFiltro(1, 1));
			filtroU.setPersBident(new Long(user));
			PaginaResultado<TUser> responseU = UserRest.getUser(filtroU,beanDS);
			TUser usuario = new TUser();
			if (responseU != null && responseU.getCantidad() > 0) {
				usuario = mapper.convertValue(responseU.getResultados().get(0), TUser.class);
			}
			TEmployeeGet EmpleFiltr = new TEmployeeGet();
			EmpleFiltr.setPaginacion(new PaginacionFiltro(1, 1));
			EmpleFiltr.setPersBident(usuario.getPersBident());
			PaginaResultado<TEmployee> responseTEmployeePerson = BussinesRest.getEmployee(EmpleFiltr,beanDS);
			TEmployee tEmploye = new TEmployee();
			if (responseTEmployeePerson != null && responseTEmployeePerson.getCantidad() > 0) {
				tEmploye = mapper.convertValue(responseTEmployeePerson.getResultados().get(0), TEmployee.class);
			}
			List<TUserPut> lstTUserPut = new ArrayList<TUserPut>();
			TUserPut TUser = new TUserPut();
			BeanUtils.copyProperties(usuario, TUser);
			TUser.setUserTdateUpdate(new Date());
			TUser.setUserBstate(false);
			TUser.setUserBuserModify(userL.getPersBident());
			// TUser.setUserVpassword(user);
			lstTUserPut.add(TUser);
			UserRest.putUser(lstTUserPut,beanDS);

			List<TEmployeePut> lstTEmployeePut = new ArrayList<TEmployeePut>();
			TEmployeePut TEmployee = new TEmployeePut();
			BeanUtils.copyProperties(tEmploye, TEmployee);
			TEmployee.setPersBident(TUser.getPersBident());
			TEmployee.setEmplBstate(false);
			TEmployee.setBusiBident(tEmploye.getBusiBident());
			lstTEmployeePut.add(TEmployee);
			BussinesRest.putEmployee(lstTEmployeePut,beanDS);

		} catch (Exception ex) {
//			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	///////////////////////////////////////////////////

	@RequestMapping(value = "/CreaUsuarioEmpresa", method = RequestMethod.GET)

	public ModelAndView CreaUsuarioEmpresa(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "nrodocumento", required = true) String nrodocumento
	// @RequestParam(value = "natu_bident", required = true) String natu_bident,
	// @RequestParam(value = "lega_bident", required = true) String lega_bident
	) throws IOException {
		model.setViewName("/Usuario/AdministrarUsuario");
		try {
			// TUser us= new TUser();
			TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
			if (null!=user) {
//				if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
//					logger.info("Si tiene Acceso a la pagina");
//				}else {
//					model.setViewName("/Permiso/PermidoDenegado");
//					return model;
//				}
			}else {
				model.setViewName("/homepost");
				return model;
			}
			TPerson empresa = new TPerson();
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			TPerson repLegal = new TPerson();
			TLegalPerson legalPerson = new TLegalPerson();
			PaginaResultado<TPerson> response = new PaginaResultado<>();
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			try {
				TPersonGet filtro = new TPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtro.setPaginacion(new PaginacionFiltro(1, 1));

				filtroscatalogo.setPaginacion(new PaginacionFiltro(1, 1));
				filtroscatalogo.setCataBident(new Long(4));
				// Se puede ingresar todas las variables que puedas consultar.
				// filtro.setPersBident(new Long(pers_bidentE));
				// filtro.setPersBident(empresa.getPersBident());
				// filtro.setNatuBident(new Long (natu_bident));
				// filtro.setLegaBident(new Long (lega_bident));
				// filtro.setPersVnumdoc(empresa.getPersVnumdoc());
				filtro.setPersVnumdoc(nrodocumento);
				filtro.setPersCperstype("N");
				// response = UserRest.getUser(filtro);
				response = PersonRest.getPerson(filtro,beanDS);

				if (!StringUtils.isEmpty(nrodocumento) && response.getCantidad() > 0) {
					// TBusiness empresa = new TBusiness();
					// Se tiene que mapear el resultado a la clase requerida que se obtiene porque
					// es un map

					// obteniendo la empresa
					ObjectMapper mapper = new ObjectMapper();
					// usuario = mapper.convertValue(response.getResultados().get(0), TUser.class);
					empresa = mapper.convertValue(response.getResultados().get(0), TPerson.class);
					// una vez obtenido la empresa setear todos los campos en variables diferentes
					// model.addObject("empPersBident", empresa.getPersBident());
					// model.addObject("Tipodocumento", empresa.getPersVdoctype());
					// model.addObject("userPersNumdocUser", empresa.getPersVnumdoc());
				} else {
					System.out.println("No encontro el usuario");
				}

				TLegalPersonGet filtroLP = new TLegalPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtroLP.setPaginacion(new PaginacionFiltro(1, 1));
				// Se puede ingresar todas las variables que puedas consultar.
				filtroLP.setLegaBident(empresa.getLegaBident());
				// filtroLP.set(empresa.getLegaBident());
				PaginaResultado<TLegalPerson> responseLP = legalPersonRest.getLegalPerson(filtroLP,beanDS);
				if (responseLP != null && response.getCantidad() > 0) {
					// obteniendo la empresa
					ObjectMapper mapper = new ObjectMapper();
					legalPerson = mapper.convertValue(responseLP.getResultados().get(0), TLegalPerson.class);
				} else {
					System.out.println("No encontro el usuario");
				}
				TEmailPersonGet filtroEP = new TEmailPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtroEP.setPaginacion(new PaginacionFiltro(1, 1));
				// Se puede ingresar todas las variables que puedas consultar.
				filtroEP.setPersBident(empresa.getPersBident());
				PaginaResultado<TEmailPerson> responseEP = EmailPersonRest.getEmailPerson(filtroEP,beanDS);
				if (responseEP != null && response.getCantidad() > 0) {
					// obteniendo la empresa
					ObjectMapper mapper = new ObjectMapper();
					TEmailPerson emailPerson = mapper.convertValue(responseEP.getResultados().get(0),
							TEmailPerson.class);
					// model.addObject("oDtoEmailPerson", emailPerson);
					// model.addObject("userPersemail", emailPerson.getMailVemail());

				} else {
					System.out.println("No encontro el usuario");
				}
				TPhonePersonGet filtroPP = new TPhonePersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtroPP.setPaginacion(new PaginacionFiltro(1, 1));
				// Se puede ingresar todas las variables que puedas consultar.
				filtroPP.setPersBident(empresa.getPersBident());
				PaginaResultado<TPhonePerson> responsePP = PhonePersonRest.getPhonePerson(filtroPP,beanDS);
				if (responsePP != null && response.getCantidad() > 0) {
					// obteniendo la empresa
					ObjectMapper mapper = new ObjectMapper();
					TPhonePerson phonePerson = mapper.convertValue(responsePP.getResultados().get(0),
							TPhonePerson.class);
					// model.addObject("oDtoPhonePerson", phonePerson);
					// model.addObject("userPersphone", phonePerson.getPhonVphone());

				} else {
					System.out.println("No encontro el usuario");
				}
				TPersonGet filtroN = new TPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtroN.setPaginacion(new PaginacionFiltro(1, 1));
				// Se puede ingresar todas las variables que puedas consultar.
				filtroN.setLegaBident(legalPerson.getLegaBident());
				filtroN.setNatuBident(empresa.getNatuBident());
				// filtroN.setPersVnumdoc(empresa.getPersVnumdoc());
				// filtroN.setPersBident(new Long(pers_bidentRL));
				filtroN.setPersCperstype("N");
				response = PersonRest.getPerson(filtroN,beanDS);

				if (response.getCantidad() > 0) {
					// TBusiness empresa = new TBusiness();
					// Se tiene que mapear el resultado a la clase requerida que se obtiene porque
					// es un map
					// obteniendo replegal
					ObjectMapper mapper = new ObjectMapper();
					repLegal = mapper.convertValue(response.getResultados().get(0), TPerson.class);
					// model.addObject("oDtoRepLegal", repLegal);
					// model.addObject("repLegalBident", repLegal.getPersBident());
					// model.addObject("repLegalBidentRL", repLegal.getNatuBident());
					model.addObject("userPersNumdoc", repLegal.getPersVnumdoc());
					// model.addObject("empPersVdateReg", empresa.getPersTregistrationDate());

					// obteniendo la persona legal
					/*
					 * System.out.println(legalperson.toString());
					 * System.out.println("Entro al Editar Empresa : "+ruc);
					 * model.addObject("oDtoEmpresa", legalperson);
					 */
				} else {
					System.out.println("no encontró representante");
				}

				TNaturalPersonGet filtroNP = new TNaturalPersonGet();
				// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
				// empresa.
				filtroNP.setPaginacion(new PaginacionFiltro(1, 1));
				// Se puede ingresar todas las variables que puedas consultar.
				// filtroNP.setNatuBident(repLegal.getNatuBident());
				filtroNP.setNatuBident(empresa.getNatuBident());
				PaginaResultado<TNaturalPerson> responseNP = NaturalPersonRest.getNaturalPerson(filtroNP,beanDS);
				if (responseNP != null && response.getCantidad() > 0) {
					// obteniendo la empresa
					ObjectMapper mapper = new ObjectMapper();
					TNaturalPerson NaturalPerson = mapper.convertValue(responseNP.getResultados().get(0),
							TNaturalPerson.class);
					// model.addObject("oDtoNaturalPerson", NaturalPerson);
					// model.addObject("natu_bident", NaturalPerson.getNatuBident());
					// model.addObject("userPersName", NaturalPerson.getNatuVname());
					// model.addObject("userPerslastfather",
					// NaturalPerson.getNatuVlastnamefather());
					// model.addObject("userPerslastmother",
					// NaturalPerson.getNatuVlastnamemother());

					TEmailPersonGet filtroNEP = new TEmailPersonGet();
					// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
					// empresa.
					filtroNEP.setPaginacion(new PaginacionFiltro(1, 1));
					// Se puede ingresar todas las variables que puedas consultar.
					filtroNEP.setPersBident(repLegal.getPersBident());
					PaginaResultado<TEmailPerson> responseNEP = EmailPersonRest.getEmailPerson(filtroNEP,beanDS);
					if (responseNEP != null && response.getCantidad() > 0) {
						// obteniendo la empresa
						mapper = new ObjectMapper();
						TEmailPerson emailPerson = mapper.convertValue(responseNEP.getResultados().get(0),
								TEmailPerson.class);
						// model.addObject("oDtoNEmailPerson", emailPerson);
						// model.addObject("repLegalEmail", emailPerson.getMailVemail());

					} else {
						System.out.println("No encontro el usuario");
					}

					// TCatalogueDetGet filtroscatalogos = new TCatalogueDetGet();
					// filtroscatalogo.setPaginacion(new PaginacionFiltro(1, 1));
					// filtroscatalogo.setCataBident(new Long(4));
					filtroscatalogo.setCatdCident(empresa.getPersVdoctype());
					PaginaResultado<TCatalogueDet> responsescat = CataRest.getCatalogueDet(filtroscatalogo,beanDS);
					TCatalogueDet procata = new TCatalogueDet();
					List<TCatalogueDet> lstCatDoc = new ArrayList<>();
					for (Object catdet : responsescat.getResultados()) {
						procata = mapper.convertValue(catdet, TCatalogueDet.class);
						lstCatDoc.add(procata);
					}
					// model.addObject("Tipodocumento", procata.getCatdVdescription());
					// model.addObject("listaCatDet", lstCatDoc);
					/*********************************************************************************************************/
					/*---------------------------      LISTA PERFIL      ----------------------------------------------------*/
					/*********************************************************************************************************/

					TProfileGet filtros = new TProfileGet();
					filtros.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtros.setProfBstate(Constantes.estadoPerfil.HABILITADO.getCode());
					PaginaResultado<TProfile> responses = UserRest.getProfile(filtros,beanDS);
					TProfile pro = new TProfile();
					List<TProfile> lstProf = new ArrayList<>();
					for (Object prof : responses.getResultados()) {
						pro = mapper.convertValue(prof, TProfile.class);
						//quitando el superadmin y el admin
						if(!pro.getProfBident().toString().equals(Constantes.ID_PERSIL_SYS)  ) {
							lstProf.add(pro);
						}
						
					}

					model.addObject("listaProfile", lstProf);

					/*********************************************************************************************************/
					/*---------------------------      LISTA DOCUMENTO         ----------------------------------------------*/
					/*********************************************************************************************************/

					TCatalogueDetGet filtroscatalogos = new TCatalogueDetGet();
					filtroscatalogos.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroscatalogos.setCataBident(new Long(4));
					PaginaResultado<TCatalogueDet> responsescats = CataRest.getCatalogueDet(filtroscatalogos,beanDS);
					TCatalogueDet procatas = new TCatalogueDet();
					List<TCatalogueDet> lstCatDocs = new ArrayList<>();
					for (Object catdet : responsescats.getResultados()) {
						procatas = mapper.convertValue(catdet, TCatalogueDet.class);
						lstCatDocs.add(procatas);
					}

					model.addObject("listaCatDet", lstCatDocs);

					TPhonePersonGet filtroNPP = new TPhonePersonGet();
					// Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1
					// empresa.
					filtroNPP.setPaginacion(new PaginacionFiltro(1, 1));
					// Se puede ingresar todas las variables que puedas consultar.
					filtroNPP.setPersBident(repLegal.getPersBident());
					PaginaResultado<TPhonePerson> responseNPP = PhonePersonRest.getPhonePerson(filtroNPP,beanDS);
					if (responseNPP != null && response.getCantidad() > 0) {
						// obteniendo la empresa
						mapper = new ObjectMapper();
						TPhonePerson phonePerson = mapper.convertValue(responseNPP.getResultados().get(0),
								TPhonePerson.class);
						// model.addObject("oDtoNPhonePerson", phonePerson);
						// model.addObject("repLegalPhone", phonePerson.getPhonVphone());

					} else {
						System.out.println("No encontro el usuario");
					}
				} else {
					System.out.println("No encontro datos");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}