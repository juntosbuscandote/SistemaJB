package pe.am.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TClientEndFilterPerson;
import pe.am.spring.entity.TClientEndFilterPersonGet;
import pe.am.spring.entity.TClientEndPerson;
import pe.am.spring.entity.TClientEndPersonGet;
import pe.am.spring.entity.TClientEndPersonPost;
import pe.am.spring.entity.TClientEndPersonPut;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TUser;
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
import pe.am.spring.service.PersonaService;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	protected static Logger logger = Logger.getLogger(ClienteController.class);
	
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
	ClientRest clientendRest;
	
	@Autowired
	PersonaService personaService;
	
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
		
		// properties para microservicio de almacen
		String util = Util.getHostStore();
		System.out.println(util);
		model.setViewName("/Cliente/Cliente");
		String NombreVentana="Persona Desaparecida";
		model.addObject("NombreVentana", NombreVentana);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		ObjectMapper mapper = new ObjectMapper();
		try {
			/*********************************************************************************************************/
			/*---------------------------     LISTA ESTADO DE CLIENTE ----------------------------------------------*/
			/*********************************************************************************************************/
			logger.info("Listar estado de cliente de catalogue");
			TCatalogueDetGet filtrosestadocliente = new TCatalogueDetGet();
			filtrosestadocliente.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtrosestadocliente.setCataBident(new Long(44));
			filtrosestadocliente.setCatdBstate(true);
			PaginaResultado<TCatalogueDet> responsescatestado = CataRest.getCatalogueDet(filtrosestadocliente,beanDS);
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
	
	
	@RequestMapping(value = "/crearcliente")
	public ModelAndView listCrearCliente(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		
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
		ObjectMapper mapper = new ObjectMapper();
		model.addObject("fProcessCliente", "save");
		model.setViewName("/Cliente/CrearCliente");
		String NombreVentana="Crear Cliente";
		model.addObject("NombreVentana", NombreVentana);
		model = personaService.cargarPersona(model,beanDS);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	

	@RequestMapping(value = "/lista_cliente", method = RequestMethod.POST)
    @ResponseBody
    public String getlistaCliente(HttpServletRequest rq, HttpSession ses,
   		@RequestParam(value = "frmUserFiltroRasSocial", required = false) String frmUserFiltroRasSocial,
   		@RequestParam(value = "frmUserFiltroNroDoc", required = false) String frmUserFiltroNroDoc,
		@RequestParam(value = "frmUserFiltroNomCompleto", required = false) String frmUserFiltroNomCompleto,
		@RequestParam(value = "frmUserFiltroEstado", required = false) String frmUserFiltroEstado
    ) {
        System.out.println("===========Inicio-> cliente/lista_cliente ");

        String sStart = rq.getParameter("draw");
        ObjectMapper mapper = new ObjectMapper();
        try {
        	TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
        	TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
        	BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
        	
            String cantidad = rq.getParameter("length");  
            String sEcho = rq.getParameter("start");
            int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

            TClientEndFilterPersonGet filtroLP = new TClientEndFilterPersonGet();
            filtroLP.setPaginacion(new PaginacionFiltro(page,Integer.parseInt(cantidad)));

//            if(tEmployee!=null) {            	
//            	filtroLP.setBusiBident(tEmployee.getBusiBident());
//            }
            if(frmUserFiltroRasSocial!=null && !frmUserFiltroRasSocial.isEmpty()) {
        	filtroLP.setNombre(frmUserFiltroRasSocial);
            }

            if(frmUserFiltroNroDoc!=null && !frmUserFiltroNroDoc.isEmpty()) {
            filtroLP.setPers_vnumdoc(frmUserFiltroNroDoc);
            }
            if(frmUserFiltroEstado!=null && !frmUserFiltroEstado.isEmpty()) {
           	    filtroLP.setEstado(frmUserFiltroEstado);
            }
            PaginaResultado<TClientEndFilterPerson> response = clientendRest.getClientEndFilterRest(filtroLP,beanDS);
            List<TClientEndFilterPerson> LstdoUser = null;
            if(response.getCantidad()>0){
            	LstdoUser = response.getResultados();
            }
            List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
            HashMap<String, Object> obj = null;
            if(LstdoUser!=null){
	            for (Object objs: LstdoUser) {
	            	TClientEndFilterPerson vistaUser = mapper.convertValue(objs, TClientEndFilterPerson.class);
	                obj = new HashMap<String, Object>();
	                obj.put("persBident",ObjectUtils.defaultIfNull(vistaUser.getPersBident(), ""));
	                obj.put("legaBusiname",ObjectUtils.defaultIfNull(vistaUser.getLega_bident(), ""));
	                obj.put("busiBident",ObjectUtils.defaultIfNull(vistaUser.getBusiBident(), ""));
	                obj.put("natuBident",ObjectUtils.defaultIfNull(vistaUser.getNatu_bident(), ""));
	                obj.put("clieBident",ObjectUtils.defaultIfNull(vistaUser.getClieBident(), ""));
	                obj.put("catd_vshortname",ObjectUtils.defaultIfNull(vistaUser.getCatd_vshortname(), ""));
	                obj.put("pers_vnumdoc",ObjectUtils.defaultIfNull(vistaUser.getPers_vnumdoc(), ""));
	                obj.put("nombre",ObjectUtils.defaultIfNull(vistaUser.getNombre(), ""));
	                obj.put("mailVmail", ObjectUtils.defaultIfNull(vistaUser.getMailVmail(), ""));
	                obj.put("phonVphone",ObjectUtils.defaultIfNull(vistaUser.getPhonVphone(), ""));
	                obj.put("State",ObjectUtils.defaultIfNull(vistaUser.getEstado(), ""));
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

	@RequestMapping(value = "/validRuCliente", method = RequestMethod.POST)
	@ResponseBody
	public String validRuCliente(@RequestParam("ruc") String ruc,
			// @RequestParam("pers_vlega") String pers_vlega,
			HttpServletRequest request, ModelAndView model, HttpSession ses) {
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		String url = "";
		JsonObject jReturn = new JsonObject();
		ObjectMapper mapper = new ObjectMapper();
		TPerson bTUser = new TPerson();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {

			TClientEndFilterPersonGet filtroNroDoc = new TClientEndFilterPersonGet();
			filtroNroDoc.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroNroDoc.setBusiBident(tEmployee.getBusiBident());
			filtroNroDoc.setPers_vnumdoc(ruc);
			PaginaResultado<TClientEndFilterPerson> responseTClientNroDoc = clientendRest.getClientEndFilterRest(filtroNroDoc,beanDS);
			TClientEndFilterPerson tClientNroDoc = new TClientEndFilterPerson();
			if (responseTClientNroDoc != null && responseTClientNroDoc.getCantidad() > 0) {
				tClientNroDoc = mapper.convertValue(responseTClientNroDoc.getResultados().get(0),TClientEndFilterPerson.class);
				jReturn.addProperty("estado", "0");
				jReturn.addProperty("msg", "Existe vendedor registrado con el mismo NRO ");
			} else {
				// logger.info("Persona a buscar ");
				jReturn.addProperty("estado", "1");
			}

		} catch (Exception e) {
			jReturn.addProperty("estado", "2");
			jReturn.addProperty("msg", "Se produjo un error interno en los servicios");
			e.printStackTrace();
		}
		jReturn.addProperty("url", url);
		return new Gson().toJson(jReturn);

	}
    
	@RequestMapping(value = "/InsertarCliente", method = RequestMethod.POST)
	@ResponseBody
	public String InsertarCliente(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "personId", required = false) String personId) {
		JsonObject robject = new JsonObject();
		ObjectMapper mapper = new ObjectMapper();
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		System.out.println("inserta cliente");
		try {
			/** Validar si existe cliente */
			TClientEndPersonGet filtroclient=new TClientEndPersonGet();
			filtroclient.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroclient.setPersBident(new Long(personId));
			PaginaResultado<TClientEndPerson> rspTClientEndPerson=clientendRest.getClientEnd(filtroclient,beanDS);
			if(rspTClientEndPerson.getCantidad()>0) {
				robject.addProperty("msg", "2");
				return new Gson().toJson(robject);
			}
			List<TClientEndPersonPost> lstNClientEndPost = new ArrayList<TClientEndPersonPost>();
			TClientEndPersonPost TClientEnd = new TClientEndPersonPost();
			TClientEnd.setClieBstate(true);
			TClientEnd.setPersBident(new Long(personId));
			lstNClientEndPost.add(TClientEnd);
			List<TClientEndPerson> lstNClientEnd = clientendRest.postClientEnd(lstNClientEndPost,beanDS);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);
	}
    



	@RequestMapping(value = "/EditarCliente", method = RequestMethod.GET)
	public ModelAndView EditarCliente(ModelAndView model, HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "idPerson", required = true) String idPerson
	) throws IOException {
		TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
		if (null!=user) {
			if(Util.validAcceso(ses,"/cliente/")) {
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
		String NombreVentana="Editar Cliente";
		model.addObject("NombreVentana", NombreVentana);
		model.setViewName("/Cliente/CrearCliente");
		try {
			model=personaService.cargarPersona(model,beanDS);
			model=personaService.cargarPersonaEdit(model,new Long(idPerson),beanDS);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
		}
		return model;
	}

	
	
	@RequestMapping(value = "/detallecliente", method = RequestMethod.POST)
	@ResponseBody
	public String listarCliente(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "emple", required = true) String emple) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonObject robject = new JsonObject();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TClientEndFilterPersonGet filtroU = new TClientEndFilterPersonGet();
			filtroU.setPaginacion(new PaginacionFiltro(1, 1));
			filtroU.setClieBident(new Long(emple));
			PaginaResultado<TClientEndFilterPerson> responseU = clientendRest.getClientEndFilterRest(filtroU,beanDS);
			TClientEndFilterPerson clienteFinal = new TClientEndFilterPerson();
			if (responseU != null && responseU.getCantidad() > 0) {
				clienteFinal = mapper.convertValue(responseU.getResultados().get(0), TClientEndFilterPerson.class);
			}
			robject=personaService.verPersona(clienteFinal.getPersBident(),beanDS);
			robject.addProperty("msg", "ok");
			return new Gson().toJson(robject);
		} catch (Exception e) {
			e.printStackTrace();
			robject.addProperty("msg", "error");
			robject.addProperty("respuesta", "Error al Conectar con el microservicio");
			return new Gson().toJson(robject);

		}

	}
	
	@RequestMapping(value = "/EstadoCliente", method = RequestMethod.POST)
	@ResponseBody
	public String EstadoCliente(HttpSession ses, HttpServletRequest rq,
			@RequestParam(value = "emple", required = true) String emple
	) {
		ObjectMapper mapper = new ObjectMapper();
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			TClientEndPersonGet filtroU = new TClientEndPersonGet();
			filtroU.setPaginacion(new PaginacionFiltro(1, 1));
			filtroU.setClieBident(new Long (emple));
			PaginaResultado<TClientEndPerson> responseU = clientendRest.getClientEnd(filtroU,beanDS);
			TClientEndPerson clien = new TClientEndPerson();
			if (responseU != null && responseU.getCantidad() > 0) {
				clien = mapper.convertValue(responseU.getResultados().get(0), TClientEndPerson.class);
			}

			List<TClientEndPersonPut> lstTEmployeePut = new ArrayList<TClientEndPersonPut>();
			TClientEndPersonPut TEmployee = new TClientEndPersonPut();
			BeanUtils.copyProperties(clien, TEmployee);
			TEmployee.setClieBstate(false);
			lstTEmployeePut.add(TEmployee);
			clientendRest.putClientEnd(lstTEmployeePut,beanDS);

		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			JsonObject robject = new JsonObject();
			robject.addProperty("msg", "error");
			return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
		robject.addProperty("msg", "ok");
		return new Gson().toJson(robject);

	}
	
    
}
