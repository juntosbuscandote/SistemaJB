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
import pe.am.spring.entity.RequestGCMod;
import pe.am.spring.entity.RptaGenerica;
import pe.am.spring.entity.TBusinessGroup;
import pe.am.spring.entity.TBusinessGroupGet;
import pe.am.spring.entity.TBusinessGroupPost;
import pe.am.spring.entity.TBusinessGroupPut;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TGrupoComerFilter;
import pe.am.spring.entity.TGrupoComerFilterGet;
import pe.am.spring.entity.TModule;
import pe.am.spring.entity.TModuleGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.TUserRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/grupocomer")
public class GrupoComercialController {

	protected static Logger logger = Logger.getLogger(GrupoComercialController.class);

	@Autowired
	private TUserRest tUserRest;

	@Autowired
	CatalogueRest cataRest;
	
	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {

		model.setViewName("/Accesos/GrupoComercial");
		String NombreVentana = "Administrar Grupos Comerciales";
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
			logger.info("Listando estado de grupo comerciales");
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(36));
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
	
	@RequestMapping(value = "/EditarGrupoCom", method = RequestMethod.GET)
	public ModelAndView editarGrupoComer(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "idGC", required = true) String idGC) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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

		model.setViewName("/Accesos/crearGrupoCom");
		try {
			TBusinessGroupGet gc = new TBusinessGroupGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setBusgrBident(new Long(idGC));
			
			PaginaResultado<TBusinessGroup> response = new PaginaResultado<>();
			try {
				response = tUserRest.getGrupoComer(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					mapper = new ObjectMapper();
					TBusinessGroup bean= new TBusinessGroup();
					bean = mapper.convertValue(response.getResultados().get(0), TBusinessGroup.class);
					model.addObject("nombreGrupoCom", bean.getBusgrVname());
					model.addObject("descrGrupoCom", bean.getBusgrVdescription());
					model.addObject("fProcess", "update");
					model.addObject("idGrupoCom", bean.getBusgrBident());
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
	
	@RequestMapping(value = "/updateGC", method = RequestMethod.POST)
	@ResponseBody
	public String actualizarGrupoComer(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "grupocom_vname", required = false) String grupocom_vname,
			@RequestParam(value = "grupocom_vdescrip", required = false) String grupocom_vdescrip,
			@RequestParam(value = "grupoComer_id", required = false) String grupoComer_id,
			@RequestParam(value = "estado", required = false,defaultValue="") String estado) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {

			TBusinessGroupGet gc = new TBusinessGroupGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setBusgrBident(new Long(grupoComer_id));
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			PaginaResultado<TBusinessGroup> response = new PaginaResultado<>();
			try {
				response = tUserRest.getGrupoComer(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					logger.info("Se encontro el Grupo Comercial");
					mapper = new ObjectMapper();
					TBusinessGroup bean= new TBusinessGroup();
					bean = mapper.convertValue(response.getResultados().get(0), TBusinessGroup.class);
					List<TBusinessGroupPut> lGrupoComPut = new ArrayList<TBusinessGroupPut>();
					TBusinessGroupPut beanGCPut = new TBusinessGroupPut();
					BeanUtils.copyProperties(bean, beanGCPut);
					beanGCPut.setBusgrTupdateDate(new Date());
					//se validara si viene un update de estado desde la grilla o el editar de la pantalla
					if(estado.isEmpty()) {
						beanGCPut.setBusgrVname(grupocom_vname);
						beanGCPut.setBusgrVdescription(grupocom_vdescrip);
					}else {
						beanGCPut.setBusgrBstate(estado.equals(Constantes.estadoGC.HABILITADO.getCode())?Constantes.estadoGC.INHABILITADO.getCode():Constantes.estadoGC.HABILITADO.getCode());
					}
					
					
					lGrupoComPut.add(beanGCPut);
					tUserRest.putGrupoComer(lGrupoComPut,beanDS);
					
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

	
	@RequestMapping(value = "/lista_grupocomer", method = RequestMethod.POST)
	@ResponseBody
	public String getlistaEmpresa(HttpServletRequest rq, HttpSession ses,
			@RequestParam(value = "frmGCFiltroNombre", required = false) String fmrGCFiltroNombre,
			@RequestParam(value = "frmGCFiltroEstado", required = false) String fmrGCFiltroEstado) {

		String sStart = rq.getParameter("draw");
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

		try {

			String cantidad = rq.getParameter("length");
			String sEcho = rq.getParameter("start");
			int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			TGrupoComerFilterGet filtroGC = new TGrupoComerFilterGet();
			filtroGC.setPaginacion(new PaginacionFiltro(page, Integer.parseInt(cantidad)));
			if ( null!= fmrGCFiltroNombre && !fmrGCFiltroNombre.isEmpty()) {
				filtroGC.setNombreGC(fmrGCFiltroNombre);
			}
			if (null!= fmrGCFiltroEstado  && !fmrGCFiltroEstado.isEmpty()) {
				filtroGC.setIdEstado(fmrGCFiltroEstado);
			}


			// BussinesRest
			PaginaResultado<TGrupoComerFilter> responseLG = tUserRest.getGrupoComerFilter(filtroGC,beanDS);
			// .queryParam("idPlan", 1)

			List<TGrupoComerFilter> lstGC = null;
			if (null!= responseLG && responseLG.getCantidad() > 0) {
				lstGC = responseLG.getResultados();
			}
			List<HashMap<String, Object>> objListaLP = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapperLP = new ObjectMapper();
			HashMap<String, Object> objLP = null;
			int ind=1;
			if (null!=lstGC) {
				for (Object objsLP : lstGC) {
					TGrupoComerFilter vistaGC = mapperLP.convertValue(objsLP, TGrupoComerFilter.class);
					objLP = new HashMap<String, Object>();
					objLP.put("grupoCInd", ind);
					objLP.put("grupoCID", ObjectUtils.defaultIfNull(vistaGC.getGrIident(), ""));
					objLP.put("grupoCname", ObjectUtils.defaultIfNull(vistaGC.getNombreGC(), ""));
					objLP.put("grupoCdescr", ObjectUtils.defaultIfNull(vistaGC.getDescrGC(), ""));
					objLP.put("grupoCidEstado", ObjectUtils.defaultIfNull(vistaGC.getIdEstado().trim(), ""));
					objLP.put("grupoCdescrEstado", ObjectUtils.defaultIfNull(vistaGC.getDescEstado(), ""));
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
	
	@RequestMapping(value = "/crearGrupoCom")
	public ModelAndView listCrearSucursal(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		model.setViewName("/Accesos/crearGrupoCom");
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
		String NombreVentana = "Administrar Grupos Comerciales";
		model.addObject("fProcess", "save");
		model.addObject("NombreVentana", NombreVentana);
		return model;
	}

	@RequestMapping(value = "/crearGrupoCom", method = RequestMethod.POST)
	@ResponseBody
	public String inertGrupoCom(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "grupocom_vname", required = false) String grupocom_vname,
			@RequestParam(value = "grupocom_vdescrip", required = false) String grupocom_vdescrip) {
		JsonObject robject = new JsonObject();
		try {
			BeanDS beanDS = (BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);

			ObjectMapper mapper = new ObjectMapper();
			List<TBusinessGroupPost> lBusGroup = new ArrayList<TBusinessGroupPost>();
			TBusinessGroupPost bean = new TBusinessGroupPost();
			bean.setBusgrVname(grupocom_vname);
			bean.setBusgrVdescription(grupocom_vdescrip);
			bean.setBusgrBstate("1");
			bean.setBusgrBuserCreate(null);
			bean.setBusgrBuserModify(null);
			bean.setBusgrTregistrationDate(new Date());
			bean.setBusgrTupdateDate(null);
			lBusGroup.add(bean);
			tUserRest.postGrupoComercial(lBusGroup, beanDS);
			logger.info("Se registro correctamente el grupo comercial");
			robject.addProperty("obs", "Se registro correctamente el Grupo Comercial : "+grupocom_vname);

		} catch (Exception ex) {
			logger.error("Ocurrio un error en InsertarEmpresa");
			ex.printStackTrace();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}

		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}

	
	@RequestMapping(value = "/AsignarMod", method = RequestMethod.GET)
	public ModelAndView asignarModGrupoComer(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "idGC", required = true) String idGC) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
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

		model.setViewName("/Accesos/AsigModGrupoCom");
		try {
			TBusinessGroupGet gc = new TBusinessGroupGet();
			gc.setPaginacion(new PaginacionFiltro(1, 1));
			gc.setBusgrBident(new Long(idGC));
			
			PaginaResultado<TBusinessGroup> response = new PaginaResultado<>();
			try {
				response = tUserRest.getGrupoComer(gc, beanDS);
				if (null!=response && response.getCantidad()>0) {
					mapper = new ObjectMapper();
					TBusinessGroup bean= new TBusinessGroup();
					bean = mapper.convertValue(response.getResultados().get(0), TBusinessGroup.class);
					model.addObject("nombreGrupoCom", bean.getBusgrVname());
					model.addObject("descrGrupoCom", bean.getBusgrVdescription());
					model.addObject("fProcess", "update");
					model.addObject("idGrupoCom", bean.getBusgrBident());
					model.addObject("estado", bean.getBusgrBstate());
				} else {
					logger.info("No encontro el Grupo Comercial");
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
	
	@RequestMapping(value = "/obtenerModulos", method = RequestMethod.POST)
	@ResponseBody
	public String obtenerModulos(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "id", required = true) String id) {
		JsonObject robject = new JsonObject();
		try {
			BeanDS beanDS = (BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			JsonArray arbol=new JsonArray();
			RequestGCMod filtroMenu = new RequestGCMod();
			filtroMenu.setIdPerfil(new Long("4"));
			filtroMenu.setIdGC(new Long(id));
			RptaGenerica menu = tUserRest.obtenerMenuAsigMod(filtroMenu,beanDS);
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
	
	
	
	
	@RequestMapping(value = "/asigModGrupoCom", method = RequestMethod.POST)
	@ResponseBody
	public String asigModGrupoCom(HttpSession ses, HttpServletRequest rq,@RequestBody String datos) {
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		try {
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			try {
				JsonObject jsonbody = null;
				jsonbody = new JsonParser().parse(datos).getAsJsonObject();
				
				String id= jsonbody.get("idGC").getAsString();
				JsonArray listaIds=jsonbody.get("modAsig").getAsJsonArray();
				
				logger.info("json de modulos asignados: "+datos);
				RptaGenerica res=tUserRest.asigModGrupoComercial(datos, beanDS);
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
	
}
