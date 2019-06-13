package pe.am.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ObjectUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TAddressPerson;
import pe.am.spring.entity.TAddressPersonGet;
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
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPhonePerson;
import pe.am.spring.entity.TPhonePersonGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;
import pe.am.spring.entity.TUserFilterGet;
import pe.am.spring.entity.TUserGet;
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
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/guiaremision")
public class GuiaRemisionController {
	
	
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
//
	@Autowired 
	CatalogueRest CataRest;
	@Autowired
	NaturalPersonRest NaturalPersonRest;
	
	@Autowired
	EmailRest emailRest;
	

	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		model.setViewName("/GuiaRemision/GuiaRemision");
		// validar sesion
				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
				if (null!=user) {
					if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
						//logger.info("Si tiene Acceso a la pagina");
					}else {
						model.setViewName("/Permiso/PermidoDenegado");
						return model;
					}
				}else {
					model.setViewName("/homepost");
					return model;
				}
				model.addObject("fProcess", "save");
				ObjectMapper mapper = new ObjectMapper();
				try {

					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO MONEDA ----------------------------------------------*/
					/*********************************************************************************************************/
					
					TCatalogueDetGet filtroscatalogomoneda = new TCatalogueDetGet();
					filtroscatalogomoneda.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroscatalogomoneda.setCataBident(new Long(2));
					PaginaResultado<TCatalogueDet> responsescatmoneda = CataRest.getCatalogueDet(filtroscatalogomoneda,beanDS);
					TCatalogueDet procatamoneda = new TCatalogueDet();
					List<TCatalogueDet> lstCatDocMoneda = new ArrayList<>();
					for(Object catdetmoneda: responsescatmoneda.getResultados() ) {
						procatamoneda = mapper.convertValue(catdetmoneda,TCatalogueDet.class);
						lstCatDocMoneda.add(procatamoneda);
					}
		  
					model.addObject("listaCatDetMoneda", lstCatDocMoneda);

					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO FORMA DE PAGO------------------------------------------*/
					/*********************************************************************************************************/
					
					TCatalogueDetGet filtroscatalogoformadepa = new TCatalogueDetGet();
					filtroscatalogoformadepa.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroscatalogoformadepa.setCataBident(new Long(21));
					PaginaResultado<TCatalogueDet> responsescatformadepa = CataRest.getCatalogueDet(filtroscatalogoformadepa,beanDS);
					TCatalogueDet procataformadepa = new TCatalogueDet();
					List<TCatalogueDet> lstCatDocformadepa = new ArrayList<>();
					for(Object catdetformadepa: responsescatformadepa.getResultados() ) {
						procataformadepa = mapper.convertValue(catdetformadepa,TCatalogueDet.class);
						lstCatDocformadepa.add(procataformadepa);
					}
		  
					model.addObject("listaCatDetFormadepa", lstCatDocformadepa);
					
					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO SUCURSAL ----------------------------------------------*/
					/*********************************************************************************************************/
					
					TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
					filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroscatalogo.setCataBident(new Long(1));
//					filtroscatalogo.setCataBident(new Long(4));
					PaginaResultado<TCatalogueDet> responsescat = CataRest.getCatalogueDet(filtroscatalogo,beanDS);
					TCatalogueDet procata = new TCatalogueDet();
					List<TCatalogueDet> lstCatDoc = new ArrayList<>();
					for(Object catdet: responsescat.getResultados() ) {
						
							
						
						procata = mapper.convertValue(catdet,TCatalogueDet.class);
						lstCatDoc.add(procata);
						
					}
		  
					model.addObject("listaCatDetComp", lstCatDoc);
//					
					
					
					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO Cliente ----------------------------------------------*/
					/*********************************************************************************************************/
					
//					TUserFilter filtrosUsuarios = new TUserFilter();
//					 TBussinesFilterGet filtrosUsuarios = new TBussinesFilterGet();
//					filtrosUsuarios.setPaginacion(new PaginacionFiltro(1, 1000000));
//					PaginaResultado<TBussinesFilter> responsesuser = BussinesRest.getBussinesFilter(filtrosUsuarios);
//					TBussinesFilter prouser = new TBussinesFilter();
//					List<TBussinesFilter> lstUser = new ArrayList<>();
//					for(Object catdetuser: responsesuser.getResultados() ) {
//						
//							
//						
//						prouser = mapper.convertValue(catdetuser,TBussinesFilter.class);
//						lstUser.add(prouser);
//						
//					}
//		 
//					model.addObject("filtrarClienteNroC", lstUser);
//					
					
					
//					
//                    TUserFilter filtrosUsuarios = new TUserFilter();
                    TBussinesFilterGet filtrosUsuarios = new TBussinesFilterGet();
                    filtrosUsuarios.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
//                  filtrosUsuarios.setProfVdescription("Usuario Final");
                    filtrosUsuarios.setEstado("1");
//                  filtrosUsuarios.set
//                  filtroscatalogo.setCataBident(new Long(4));
//                  PaginaResultado<TUserFilter> response = UserRest.getUserFilter(filtroLP);
                    PaginaResultado<TBussinesFilter> responsesuser = BussinesRest.getBussinesFilter(filtrosUsuarios,beanDS);
                    TBussinesFilter prouser = new TBussinesFilter();
                    List<TBussinesFilter> lstUser = new ArrayList<>();
                    for(Object catdetuser: responsesuser.getResultados() ) {
                            prouser = mapper.convertValue(catdetuser,TBussinesFilter.class);
                            lstUser.add(prouser);
                            
                    }

                    model.addObject("filtrarClienteNroC", lstUser);

					
					
					
					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO VENDEDOR ----------------------------------------------*/
					/*********************************************************************************************************/
					
//					TUserFilter filtrosUsuarios = new TUserFilter();
					 TUserFilterGet filtrosUsuariosVendedor = new TUserFilterGet();
					 filtrosUsuariosVendedor.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					 filtrosUsuariosVendedor.setProfVdescription("Usuario Empresa");
					 filtrosUsuariosVendedor.setEstado("1");
//					filtrosUsuarios.set
//					filtroscatalogo.setCataBident(new Long(4));
//					 PaginaResultado<TUserFilter> response = UserRest.getUserFilter(filtroLP);
					PaginaResultado<TUserFilter> responsesuservendedor = UserRest.getUserFilter(filtrosUsuariosVendedor,beanDS);
					TUserFilterGet prouservendedor = new TUserFilterGet();
					List<TUserFilterGet> lstUservendedor = new ArrayList<>();
					for(Object catdetuservendedor: responsesuservendedor.getResultados() ) {
						
							
						
						prouservendedor = mapper.convertValue(catdetuservendedor,TUserFilterGet.class);
						lstUservendedor.add(prouservendedor);
						
					}
		  
					model.addObject("filtrarVendedorNroV", lstUservendedor);
					
					
					/*********************************************************************************************************/
					/*---------------------------     LISTA DE PERIODO----------------------------------------------*/
					/*********************************************************************************************************/
							
					TCatalogueDetGet filtroscatalogoperiodos = new TCatalogueDetGet();
					filtroscatalogoperiodos.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
					filtroscatalogoperiodos.setCataBident(new Long(19));
					PaginaResultado<TCatalogueDet> responsescatperiod = CataRest.getCatalogueDet(filtroscatalogoperiodos,beanDS);
					TCatalogueDet procataperiodo = new TCatalogueDet();
					List<TCatalogueDet> lstCatPeriodo = new ArrayList<>();
					for(Object catdetperiod: responsescatperiod.getResultados() ) {
						procataperiodo = mapper.convertValue(catdetperiod,TCatalogueDet.class);
						lstCatPeriodo.add(procataperiodo);
					}
		  
					model.addObject("listaCatDetPeriod", lstCatPeriodo);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return model;
			}
			
			@RequestMapping(value = "/lista_Cotizacion", method = RequestMethod.POST)
		    @ResponseBody
		    public String getFiltroDocumentos(HttpServletRequest rq, HttpSession ses,
		   		@RequestParam(value = "frmUserFiltroCodigoComercial", required = false) String frmUserFiltroCodigoComercial
//		   		,
//		   		@RequestParam(value = "frmUserFiltroNombre", required = false) String frmUserFiltroNombre
//		   		,
//				@RequestParam(value = "frmUserFiltroMarca", required = false) String frmUserFiltroMarca
//					,@RequestParam(value = "frmUserFiltroEmpresa", required = false) String frmUserFiltroEmpresa,
//					@RequestParam(value = "frmUserFiltroEstado", required = false) String frmUserFiltroEstado
		    ) {
		        System.out.println("===========Inicio-> cotizacion/lista_Cotizacion ");

		        String sStart = rq.getParameter("draw");
		        BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		        
		        try {
		        	TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
//		            String cantidad = rq.getParameter("length");  
//		            String sEcho = rq.getParameter("start");
//		            int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

		            TUserFilterGet filtroLP = new TUserFilterGet();
//		            filtroLP.setPaginacion(new PaginacionFiltro(page,Integer.parseInt(cantidad)));
		            if(tEmployee!=null ) {
		            	filtroLP.setBusiBident(tEmployee.getBusiBident());
		            }
//		            if(frmUserFiltroCodigoComercial!=null && !frmUserFiltroCodigoComercial.isEmpty()) {
//		        	filtroLP.setUserVuser(frmUserFiltroCodigoComercial);
//		            }
//		            if(frmUserFiltroNombre!=null && !frmUserFiltroNombre.isEmpty()) {
//		            filtroLP.setNombres(frmUserFiltroNombre);
//		            }
		            if(frmUserFiltroCodigoComercial!=null && !frmUserFiltroCodigoComercial.isEmpty()) {
		            filtroLP.setProfbident(new Long(frmUserFiltroCodigoComercial));
		            }
//		            if(frmUserFiltroEmpresa!=null && !frmUserFiltroEmpresa.isEmpty()) {
//		      	    filtroLP.setLegaBusiname(frmUserFiltroEmpresa);
//		            }
//		            if(frmUserFiltroEstado!=null && !frmUserFiltroEstado.isEmpty()) {
//		            	 Boolean estado= frmUserFiltroEstado.equals("1")?true:false;
//		           	    filtroLP.setEstadoUsu(estado);
//		            }
		            //UserRest
		            PaginaResultado<TUserFilter> response = UserRest.getUserFilter(filtroLP,beanDS);
		            //.queryParam("idPlan", 1)
		          
		            
		            List<TUserFilter> LstdoUser = null;
		            if(response.getCantidad()>0){
		            	LstdoUser = response.getResultados();
		            }
		            List<HashMap<String, Object>> objLista = new ArrayList<HashMap<String, Object>>();
		            ObjectMapper mapper=new ObjectMapper();
		            HashMap<String, Object> obj = null;
		            if(LstdoUser!=null){
		            for (Object objs: LstdoUser) {
		            	TUserFilter vistaUser = mapper.convertValue(objs, TUserFilter.class);
//		            	TUserFilter vistaEmploye = mapper.convertValue(objs, TUserFilter.class);
		                obj = new HashMap<String, Object>();
//		                obj.put("userVuser",ObjectUtils.defaultIfNull(vistaUser.getUserVuser(), ""));
		                obj.put("userNumdoc",ObjectUtils.defaultIfNull(vistaUser.getNombres(), ""));// aqui debe ir el nombre concatenado
//		                obj.put("userVdescription",ObjectUtils.defaultIfNull(vistaUser.getProfVdescription(), ""));
//		                obj.put("userTregistrationDate", ObjectUtils.defaultIfNull(vistaUser.getUserTregistrationDate(), ""));
//		                obj.put("userBusiname",ObjectUtils.defaultIfNull(vistaUser.getLegaBusiname(), ""));
//		                obj.put("userState",ObjectUtils.defaultIfNull (vistaUser.getEstado(), ""));
//		              obj.put("employeeState",ObjectUtils.defaultIfNull (vistaUser.getEstado(), ""));
		                
		               
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
//		            data = gson.toJson(tLegalPerson);
					robject.addProperty("usuarioPer_legal", data);
		            robject.add("data", jsonArray);
		            robject.addProperty("objLista", data);
//		            Gson gson = new Gson();
//					String data = gson.toJson(usuario);
//					JsonObject robject = new JsonObject();
//					robject.addProperty("msg", "ok");
//					robject.addProperty("usuario", data);
		            
		            
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
			public ModelAndView listExploradorCotizacion(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
				model.setViewName("/Venta/ExploradorCotizacion");
				// validar sesion
				TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
				if (null!=user) {
					if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
						//logger.info("Si tiene Acceso a la pagina");
					}else {
						model.setViewName("/Permiso/PermidoDenegado");
						return model;
					}
				}else {
					model.setViewName("/homepost");
					return model;
				}
//				ObjectMapper mapper = new ObjectMapper();
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return model;
			}
			
			
			@RequestMapping(value = "/detalleguiaremision", method=RequestMethod.POST)
			@ResponseBody
			public String listarCotizacion(HttpSession ses, HttpServletRequest rq,			
					@RequestParam(value = "user", required = true) String user
					) throws IOException {
					
				ObjectMapper mapper = new ObjectMapper();
				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
					try{
						
					
					// legal_person
					TPersonGet filtro = new TPersonGet();
					// Se coloca 1,1 por que solo te trae una solo empresa, todo el
					// array de solo 1 empresa.
					filtro.setPaginacion(new PaginacionFiltro(1, 1));
					// Se puede ingresar todas las variables que puedas consultar.
					filtro.setPersVnumdoc(user);
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

					Gson gson = new Gson();
		
					JsonObject robject = new JsonObject();
					robject.addProperty("msg", "ok");
					
					String data = gson.toJson(tLegalPerson);
					robject.addProperty("empresa_legal", data);
					data = gson.toJson(tAddressPerson);
					robject.addProperty("empresa_address", data);
					
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

