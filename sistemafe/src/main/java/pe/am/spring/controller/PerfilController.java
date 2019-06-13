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

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ModuloMenu;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.RequestMenuPerfil;
import pe.am.spring.entity.RptaGenerica;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TModule;
import pe.am.spring.entity.TModuleGet;
import pe.am.spring.entity.TPerfilFilter;
import pe.am.spring.entity.TPerfilFilterGet;
import pe.am.spring.entity.TProfile;
import pe.am.spring.entity.TProfileGet;
import pe.am.spring.entity.TProfilePost;
import pe.am.spring.entity.TProfilePut;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;
import pe.am.spring.entity.TUserFilterGet;
import pe.am.spring.entity.TUserGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Constantes.estadoEmpresa;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {

	protected static Logger logger = Logger.getLogger(PerfilController.class);

	@Autowired
	private TUserRest tUserRest;

	@Autowired
	CatalogueRest cataRest;
	
	@Autowired
	private BussinesRest businessRest;
	
	@RequestMapping(value = "/")
	public ModelAndView listPerfilGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {

		model.setViewName("/Accesos/Perfiles");
		String NombreVentana = "Administrar Perfiles";
		model.addObject("NombreVentana", NombreVentana);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		ObjectMapper mapper = new ObjectMapper();
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
			

		try {
			logger.info("Listando los perfiles");
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(37));
			// filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responsescat = cataRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet procata = new TCatalogueDet();
			List<TCatalogueDet> lstCatDoc = new ArrayList<>();
			for (Object catdet : responsescat.getResultados()) {
				procata = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatDoc.add(procata);
			}
			model.addObject("listaCatDetEstado", lstCatDoc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<ModuloMenu> lModulos = (List<ModuloMenu>) ses.getAttribute(Constantes.MENU_USUARIO);
		model.addObject("menu", lModulos);
		return model;
	}
	
	@RequestMapping(value = "/crearPerfil")
	public ModelAndView crearPerfil(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		model.setViewName("/Accesos/crearPerfil");
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
		// ObjectMapper mapper = new ObjectMapper();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		String NombreVentana = "Administrar Perfiles";
		model.addObject("fProcess", "save");
		model.addObject("NombreVentana", NombreVentana);
		return model;
	}
	
	@RequestMapping(value = "/crearPerfil", method = RequestMethod.POST)
	@ResponseBody
	public String crearPerfil(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "perfil_vname", required = false) String grupocom_vname,
			@RequestParam(value = "perfil_vdescrip", required = false) String grupocom_vdescrip) {
		JsonObject robject = new JsonObject();
		try {
			BeanDS beanDS = (BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

			ObjectMapper mapper = new ObjectMapper();
			List<TProfilePost> lProf = new ArrayList<TProfilePost>();
			TProfilePost bean = new TProfilePost();
			bean.setProfVname(grupocom_vname);
			bean.setProfVdescription(grupocom_vdescrip);
			bean.setProfBstate("1");
			bean.setProfBuserCreate(null);
			bean.setProfBuserModify(null);
			bean.setProfTregistrationDate(new Date());
			bean.setProfTupdateDate(null);
			lProf.add(bean);
			tUserRest.postPerfiles(lProf, beanDS);
			logger.info("Se registro correctamente el perfil");
			robject.addProperty("obs", "Se registro correctamente el Perfil : "+grupocom_vname);

		} catch (Exception ex) {
			logger.error("Ocurrio un error en InsertarEmpresa");
			ex.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}

		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}
	
	@RequestMapping(value = "/lista_perfiles", method = RequestMethod.POST)
	@ResponseBody
	public String getlistaPerfil(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmPerfilFiltroNombre", required = false) String fmrGCFiltroNombre,
			@RequestParam(value = "frmPerfilFiltroEstado", required = false) String fmrGCFiltroEstado) {

		String sStart = rq.getParameter("draw");
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

		try {

			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TPerfilFilterGet filtroP = new TPerfilFilterGet();
			filtroP.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			if ( null!= fmrGCFiltroNombre && !fmrGCFiltroNombre.isEmpty()) {
				filtroP.setNombrePerfil(fmrGCFiltroNombre);
			}
			if (null!= fmrGCFiltroEstado  && !fmrGCFiltroEstado.isEmpty()) {
				filtroP.setIdEstado(fmrGCFiltroEstado);
			}


			// BussinesRest
			PaginaResultado<TPerfilFilter> responseLG = tUserRest.getPerfilesFilter(filtroP,beanDS);
			// .queryParam("idPlan", 1)

			List<TPerfilFilter> lstGC = null;
			if (null!= responseLG && responseLG.getCantidad() > 0) {
				lstGC = responseLG.getResultados();
			}
			List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapperLP = new ObjectMapper();
			HashMap<String, Object> objLP = null;
			int ind=1;
			if (null!=lstGC) {
				for (Object objsLP : lstGC) {
					TPerfilFilter vistaGC = mapperLP.convertValue(objsLP, TPerfilFilter.class);
					objLP = new HashMap<String, Object>();
					objLP.put("perfilInd", ind);
					objLP.put("perfilID", ObjectUtils.defaultIfNull(vistaGC.getProfIident(), ""));
					objLP.put("perfilName", ObjectUtils.defaultIfNull(vistaGC.getNombrePerfil(), ""));
					objLP.put("perfilDescr", ObjectUtils.defaultIfNull(vistaGC.getDescrPerfil(), ""));
					objLP.put("perfilIdEstado", ObjectUtils.defaultIfNull(vistaGC.getIdEstado().trim(), ""));
					objLP.put("perfilDescrEstado", ObjectUtils.defaultIfNull(vistaGC.getDescEstado(), ""));
					ind++;
					objListaLP.add(objLP);
				}
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
	
	@RequestMapping(value = "/EditarPerfil", method = RequestMethod.GET)
	public ModelAndView editarPerfil(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "idPerfil", required = true) String idPerfil) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
			if(Util.validAcceso(ses, "/perfiles/")) {
				logger.info("Si tiene Acceso a la pagina");
			}else {
				model.setViewName("/Permiso/PermidoDenegado");
				return model;
			}
		}else {
			model.setViewName("/homepost");
			return model;
		}

		model.setViewName("/Accesos/crearPerfil");
		try {
			TProfileGet gc = new TProfileGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setProfBident(new Long(idPerfil));
			
			PaginaResultado<TProfile> response = new PaginaResultado<>();
			try {
				response = tUserRest.getProfile(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					mapper = new ObjectMapper();
					TProfile bean= new TProfile();
					bean = mapper.convertValue(response.getResultados().get(0), TProfile.class);
					model.addObject("nombrePerfil", bean.getProfVname());
					model.addObject("descrPerfil", bean.getProfVdescription());
					model.addObject("fProcess", "update");
					model.addObject("perfilId", bean.getProfBident());
				} else {
					logger.info("No encontro el Grupo Comercial");
				}

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
	
	@RequestMapping(value = "/updatePerfil", method = RequestMethod.POST)
	@ResponseBody
	public String updatePerfil(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "perfil_vname", required = false) String grupocom_vname,
			@RequestParam(value = "perfil_vdescrip", required = false) String grupocom_vdescrip,
			@RequestParam(value = "perfil_id", required = false) String grupoComer_id,
			@RequestParam(value = "estado", required = false,defaultValue="") String estado) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {

			TProfileGet gc = new TProfileGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setProfBident(new Long(grupoComer_id));
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			PaginaResultado<TProfile> response = new PaginaResultado<>();
			try {
				response = tUserRest.getProfile(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					logger.info("Se encontro el Perfil");
					mapper = new ObjectMapper();
					TProfile bean= new TProfile();
					bean = mapper.convertValue(response.getResultados().get(0), TProfile.class);
					List<TProfilePut> lProfilePut = new ArrayList<TProfilePut>();
					TProfilePut beanGCPut = new TProfilePut();
					BeanUtils.copyProperties(bean, beanGCPut);
					//se validara si viene un update de estado desde la grilla o el editar de la pantalla
					if(estado.isEmpty()) {
						beanGCPut.setProfVname(grupocom_vname);
						beanGCPut.setProfVdescription(grupocom_vdescrip);
						beanGCPut.setProfTupdateDate(new Date());
					}else {
						beanGCPut.setProfBstate(estado.equals(Constantes.estadoGC.HABILITADO.getCode())?Constantes.estadoGC.INHABILITADO.getCode():Constantes.estadoGC.HABILITADO.getCode());
					}
					
					
					lProfilePut.add(beanGCPut);
					tUserRest.putProfile(lProfilePut,beanDS);
					
				} else {
					logger.info("No se encontro el Grupo Comercial");
				}

			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				return new Gson().toJson(robject);
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

	
	@RequestMapping(value = "/AsignarPermisos", method = RequestMethod.GET)
	public ModelAndView asignarPermisos(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "idPerfil", required = true) String idGC) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
			if(Util.validAcceso(ses, "/perfiles/")) {
				logger.info("Si tiene Acceso a la pagina");
			}else {
				model.setViewName("/Permiso/PermidoDenegado");
				return model;
			}
		}else {
			model.setViewName("/homepost");
			return model;
		}

		model.setViewName("/Accesos/AsigPermisos");
		try {
			TProfileGet gc = new TProfileGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setProfBident(new Long(idGC));
			
			PaginaResultado<TProfile> response = new PaginaResultado<>();
			try {
				response = tUserRest.getProfile(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					mapper = new ObjectMapper();
					TProfile bean= new TProfile();
					bean = mapper.convertValue(response.getResultados().get(0), TProfile.class);
					model.addObject("nombrePerfil", bean.getProfVname());
					model.addObject("descrPerfil", bean.getProfVdescription());
					model.addObject("fProcess", "update");
					model.addObject("idPerfil", bean.getProfBident());
					model.addObject("estado", bean.getProfBstate());
				} else {
					logger.info("No encontro el Perfil");
				}
				
				logger.info("Listando los modulos");
				TModuleGet filtroModulo = new TModuleGet();
				filtroModulo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				// filtroscatalogo.setCataBident(new Long(4));
				PaginaResultado<TModuleGet> responsescat = tUserRest.getModulo(filtroModulo,beanDS);
				TModule procata = new TModule();
				List<TModule> lstCatDoc = new ArrayList<>();
				for (Object catdet : responsescat.getResultados()) {
					procata = mapper.convertValue(catdet, TModuleGet.class);
					lstCatDoc.add(procata);
				}
				model.addObject("listaModulos", lstCatDoc);

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
		String NombreVentana = "Administrar Accesos";
		model.addObject("fProcess", "save");
		model.addObject("NombreVentana", NombreVentana);
		return model;
	}
	
	@RequestMapping(value = "/obtenerPerfiles", method = RequestMethod.POST)
	@ResponseBody
	public String obtenerPerfiles(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "id", required = true) String id) {
		JsonObject robject = new JsonObject();
		try {
			BeanDS beanDS = (BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			JsonArray arbol=new JsonArray();
			RequestMenuPerfil filtroMenu = new RequestMenuPerfil();
			filtroMenu.setIdPerfilAdmin(new Long("4"));
			filtroMenu.setIdPerfil(new Long(id));
			ObjectMapper mapper = new ObjectMapper();
			TBussinesFilterGet empresa = new TBussinesFilterGet();
			empresa.setPaginacion(new PaginacionFiltro(1, 1));
			empresa.setEstado(estadoEmpresa.ACTIVO.getCode());
			PaginaResultado<TBussinesFilter> resul= businessRest.getBussinesFilter(empresa, beanDS);
			if(null!=resul && resul.getCantidad()>0) {
				TBussinesFilter beanE = mapper.convertValue(resul.getResultados().get(0), TBussinesFilter.class);
				filtroMenu.setIdEmpresa(beanE.getBusibident());				
			}else {
				logger.info("No se obtuvo la empresa");
			}
			
			
			RptaGenerica menu = tUserRest.obtenerMenuPerfil(filtroMenu,beanDS);
			if(null!= menu && "1".equals(menu.getCodOper())) {
				String menuJson= menu.getMsjOper();
				JsonObject menuAdmin = new JsonParser().parse(menuJson).getAsJsonObject();
				JsonArray modulos = menuAdmin.get("modulos").getAsJsonArray();
				for(JsonElement mod: modulos) {
					JsonObject modJ = mod.getAsJsonObject();
					JsonObject arbolS1 = new JsonObject();
					arbolS1.addProperty("id", modJ.get("id").getAsString());
					arbolS1.addProperty("text", modJ.get("etiqueta").getAsString());
					//arbolS1.addProperty("icon", modJ.get("icono").getAsString());
					JsonArray cabSubMenu = modJ.get("cab_menu").getAsJsonArray();
					JsonArray arbolSM1=new JsonArray();
					for(JsonElement modcS: cabSubMenu) {
						JsonObject modc = modcS.getAsJsonObject();
						JsonObject arbolS2 = new JsonObject();
						arbolS2.addProperty("id", modc.get("nrodet_cab_menu").getAsString());
						arbolS2.addProperty("text", modc.get("label_cab_menu").getAsString());
						arbolS2.addProperty("icon", modc.get("icono_cab_menu").getAsString());
						
						JsonArray detSubMenu = modc.get("detalle_menu").getAsJsonArray();
						JsonArray arbolSM2=new JsonArray();
						for(JsonElement modsD: detSubMenu) {
							JsonObject mods = modsD.getAsJsonObject();
							JsonObject arbolS3 = new JsonObject();
							arbolS3.addProperty("id", mods.get("nrodet_detalle_menu").getAsString());
							arbolS3.addProperty("text", mods.get("label_detalle_menu").getAsString());
							
							JsonObject estado = new JsonObject();
							estado.addProperty("opened", true);
							if(null!=mods.get("estado_detalle_menu") && !mods.get("estado_detalle_menu").isJsonNull() && mods.get("estado_detalle_menu").getAsString().trim().equals(Constantes.estadoModulos.HABILITADO.getCode())) {
								//estado.addProperty("selected", true);
								estado.addProperty("checked", true);
							}else {
								//estado.addProperty("selected", false);
								estado.addProperty("checked", false);
							}
							arbolS3.add("state", estado);
							//arbolS1.addProperty("icon", modJ.get("icono").getAsString());
							
							arbolSM2.add(arbolS3);
						}
						arbolS2.add("children",arbolSM2);
						
						arbolSM1.add(arbolS2);
					}
					arbolS1.add("children",arbolSM1);
					
					arbol.add(arbolS1);
				}
				
				//System.out.println("ver: "+menuAdmin);
				System.out.println("arbol: "+arbol);
				/*
				JsonObject hijo= new JsonObject();
				hijo.addProperty("text", "Root node 2");
				JsonArray lista = new JsonArray();
				JsonObject hijopost= new JsonObject();
				hijopost.addProperty("text", "pppppppp");
				lista.add(hijopost);
				hijo.add("children", lista);
				arbol.add(hijo);*/
				//se construra el menu
				
			}else {
				System.out.println("Ocurrio un error al obtener el menu de la persona");
			}
			robject.add("json", arbol);

		} catch (Exception ex) {
			logger.error("Ocurrio un error en InsertarEmpresa");
			ex.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}

		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}
	
	
	
	
	@RequestMapping(value = "/asigModPerfiles", method = RequestMethod.POST)
	@ResponseBody
	public String asigModPerfiles(HttpSession ses, HttpServletRequest rq,@RequestBody String datos) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			try {
				JsonObject jsonbody = null;
				jsonbody = new JsonParser().parse(datos).getAsJsonObject();
				
				String id= jsonbody.get("idPerfil").getAsString();
				JsonArray listaIds=jsonbody.get("modAsig").getAsJsonArray();
				
				logger.info("json de modulos asignados: "+datos);
				RptaGenerica res=tUserRest.asigModPerfil(datos, beanDS);
				if(null!= res && res.getCodOper().equals("1")) {
					
				}else {
					JsonObject robject = new JsonObject();
					robject.addProperty("msg", "error");
					return new Gson().toJson(robject);
				}
				
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				return new Gson().toJson(robject);
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
	

	@RequestMapping(value = "/UserPerfil", method = RequestMethod.GET)
	public ModelAndView userPerfil(ModelAndView model, HttpSession ses, HttpServletRequest rq) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
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

		model.setViewName("/Accesos/UserPerfil");
		try {
			TProfileGet gc = new TProfileGet();
			gc.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			gc.setProfBstate(Constantes.estadoPerfil.HABILITADO.getCode());
			//gc.setProfBident(new Long(idGC));
			
			PaginaResultado<TProfile> response = new PaginaResultado<>();
			List<TProfile> lPerfil = new ArrayList<>();
			try {
				response = tUserRest.getProfile(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					for(Object o : response.getResultados()) {
						TProfile bean = mapper.convertValue(o, TProfile.class); 
						lPerfil.add(bean);
					}
					model.addObject("lPerfil", lPerfil);
				} else {
					logger.info("No encontro el Perfil");
				}
				

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
		String NombreVentana = "Administrar Accesos";
		model.addObject("fProcess", "save");
		model.addObject("NombreVentana", NombreVentana);
		return model;
	}

	
	@RequestMapping(value = "/buscarUsers", method = RequestMethod.POST)
	@ResponseBody
	public String buscarUsers(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "perfil_id", required = false) String perfil_id) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			try {
				TUserFilterGet filter=new TUserFilterGet();
				filter.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
				if(null!=perfil_id && !perfil_id.isEmpty()) {
					filter.setProfbident(new Long(perfil_id));
				}
				
				PaginaResultado<TUserFilter> responseTUserPerson=tUserRest.getUserFilter(filter,beanDS);
				TUserFilter tUsePerson =new TUserFilter();
				String texto="";
				
				JsonArray array= new JsonArray();
				JsonObject jReturn;
				Gson gson = new Gson();
				
				
				if(null!=responseTUserPerson && responseTUserPerson.getCantidad()>0) {
					for(Object o: responseTUserPerson.getResultados()) {
						tUsePerson = mapper.convertValue(o, TUserFilter.class);
						jReturn = new JsonObject();
						jReturn.addProperty("user", tUsePerson.getUserVuser());
						jReturn.addProperty("nombres", tUsePerson.getNombres());
						jReturn.addProperty("perfil", tUsePerson.getProfVdescription());
						array.add(jReturn);
					}
					
					JsonObject robject = new JsonObject();
					robject.addProperty("msg", "ok");
					robject.add("usuarios", array);
					return new Gson().toJson(robject);
				}
				
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				logger.error(errors.toString());
				e.printStackTrace();
				JsonObject robject = new JsonObject();
				robject.addProperty("msg", "error");
				return new Gson().toJson(robject);
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
	
}
