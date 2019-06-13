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
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmployee;
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

@Controller
@RequestMapping("/ordenpedido")
public class OrdenPedidoController {
	
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
	public ModelAndView listOrdenPedido(ModelAndView model, HttpSession ses) throws IOException {
		model.setViewName("/OrdenPedido/OrdenPedido");
		// validar sesion
				TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
				BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
				if (user == null) {
					model.setViewName("/homepost");
					return model;
					// new ModelAndView("redirect:/SistemaFE/");
				}
//				else {
//					//validar el rol
//					Long idRole=(Long)ses.getAttribute(Constantes.SESION_ROLE);
//					if(null!=idRole) {
//						boolean permiso=Util.tienePermiso(idRole, Constantes.uris.USUARIO.getCode());
//						if(	!permiso) {
//							System.out.println("-----------------NO TIENE PERMISO PARA LA PAGINA");
//							model.setViewName("/Permiso/PermidoDenegado");
//							return model;
//						}
//					}
//				}
//				model.addObject("fProcess", "save");
//				model.setViewName("/OrdenPedido/OrdenPedido");
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
					filtroscatalogo.setCataBident(new Long(20));
//					filtroscatalogo.setCataBident(new Long(4));
					PaginaResultado<TCatalogueDet> responsescat = CataRest.getCatalogueDet(filtroscatalogo,beanDS);
					TCatalogueDet procata = new TCatalogueDet();
					List<TCatalogueDet> lstCatDoc = new ArrayList<>();
					for(Object catdet: responsescat.getResultados() ) {
						
							
						
						procata = mapper.convertValue(catdet,TCatalogueDet.class);
						lstCatDoc.add(procata);
						
					}
		  
					model.addObject("listaCatDetSucursal", lstCatDoc);
//					
//					System.out.println("ver : "+ lstProf);
					
					
					/*********************************************************************************************************/
					/*---------------------------     LISTA DOCUMENTO Cliente ----------------------------------------------*/
					/*********************************************************************************************************/
					
//					TUserFilter filtrosUsuarios = new TUserFilter();
					 TBussinesFilterGet filtrosUsuarios = new TBussinesFilterGet();
					filtrosUsuarios.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
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
	
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
				

				@RequestMapping(value = "/lista_Cotizacion", method = RequestMethod.POST)
			    @ResponseBody
			    public String getFiltroDocumentos(HttpServletRequest rq, HttpSession ses,
			   		@RequestParam(value = "frmUserFiltroCodigoComercial", required = false) String frmUserFiltroCodigoComercial
//			   		,
//			   		@RequestParam(value = "frmUserFiltroNombre", required = false) String frmUserFiltroNombre
//			   		,
//					@RequestParam(value = "frmUserFiltroMarca", required = false) String frmUserFiltroMarca
//						,@RequestParam(value = "frmUserFiltroEmpresa", required = false) String frmUserFiltroEmpresa,
//						@RequestParam(value = "frmUserFiltroEstado", required = false) String frmUserFiltroEstado
			    ) {
			        System.out.println("===========Inicio-> ordenpedido/lista_OrdenPedido ");

			        String sStart = rq.getParameter("draw");
			        BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			        try {
			        	TEmployee tEmployee =  (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
//			            String cantidad = rq.getParameter("length");  
//			            String sEcho = rq.getParameter("start");
//			            int page = (Integer.parseInt(sEcho) / Integer.parseInt(cantidad)) + 1;

			            TUserFilterGet filtroLP = new TUserFilterGet();
//			            filtroLP.setPaginacion(new PaginacionFiltro(page,Integer.parseInt(cantidad)));
			            if(tEmployee!=null ) {
			            	filtroLP.setBusiBident(tEmployee.getBusiBident());
			            }
//			            if(frmUserFiltroCodigoComercial!=null && !frmUserFiltroCodigoComercial.isEmpty()) {
//			        	filtroLP.setUserVuser(frmUserFiltroCodigoComercial);
//			            }
//			            if(frmUserFiltroNombre!=null && !frmUserFiltroNombre.isEmpty()) {
//			            filtroLP.setNombres(frmUserFiltroNombre);
//			            }
			            if(frmUserFiltroCodigoComercial!=null && !frmUserFiltroCodigoComercial.isEmpty()) {
			            filtroLP.setProfbident(new Long(frmUserFiltroCodigoComercial));
			            }
//			            if(frmUserFiltroEmpresa!=null && !frmUserFiltroEmpresa.isEmpty()) {
//			      	    filtroLP.setLegaBusiname(frmUserFiltroEmpresa);
//			            }
//			            if(frmUserFiltroEstado!=null && !frmUserFiltroEstado.isEmpty()) {
//			            	 Boolean estado= frmUserFiltroEstado.equals("1")?true:false;
//			           	    filtroLP.setEstadoUsu(estado);
//			            }
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
//			            	TUserFilter vistaEmploye = mapper.convertValue(objs, TUserFilter.class);
			                obj = new HashMap<String, Object>();
//			                obj.put("userVuser",ObjectUtils.defaultIfNull(vistaUser.getUserVuser(), ""));
			                obj.put("userNumdoc",ObjectUtils.defaultIfNull(vistaUser.getNombres(), ""));// aqui debe ir el nombre concatenado
//			                obj.put("userVdescription",ObjectUtils.defaultIfNull(vistaUser.getProfVdescription(), ""));
//			                obj.put("userTregistrationDate", ObjectUtils.defaultIfNull(vistaUser.getUserTregistrationDate(), ""));
//			                obj.put("userBusiname",ObjectUtils.defaultIfNull(vistaUser.getLegaBusiname(), ""));
//			                obj.put("userState",ObjectUtils.defaultIfNull (vistaUser.getEstado(), ""));
//			              obj.put("employeeState",ObjectUtils.defaultIfNull (vistaUser.getEstado(), ""));
			                
			               
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
//			            data = gson.toJson(tLegalPerson);
						robject.addProperty("usuarioPer_legal", data);
			            robject.add("data", jsonArray);
			            robject.addProperty("objLista", data);
//			            Gson gson = new Gson();
//						String data = gson.toJson(usuario);
//						JsonObject robject = new JsonObject();
//						robject.addProperty("msg", "ok");
//						robject.addProperty("usuario", data);
			            
			            
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
					// validar sesion
							TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
							if (user == null) {
								model.setViewName("/homepost");
								return model;
								// new ModelAndView("redirect:/SistemaFE/");
							}
//							else {
//								//validar el rol
//								Long idRole=(Long)ses.getAttribute(Constantes.SESION_ROLE);
//								if(null!=idRole) {
//									boolean permiso=Util.tienePermiso(idRole, Constantes.uris.USUARIO.getCode());
//									if(	!permiso) {
//										System.out.println("-----------------NO TIENE PERMISO PARA LA PAGINA");
//										model.setViewName("/Permiso/PermidoDenegado");
//										return model;
//									}
//								}
//							}
//					ObjectMapper mapper = new ObjectMapper();
					try {
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return model;
				}
				
				
				@RequestMapping(value = "/detalleordenpedido", method=RequestMethod.POST)
				@ResponseBody
				public String listarCotizacion(HttpSession ses, HttpServletRequest rq,			
						@RequestParam(value = "user", required = true) String user
						) throws IOException {
						
					ObjectMapper mapper = new ObjectMapper();
					BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
						try {

							TUserGet filtroU = new TUserGet();
							filtroU.setPaginacion(new PaginacionFiltro(1, 1));
							filtroU.setUserVuser(user);
//							filtro.setPersCperstype("L");
							PaginaResultado<TUser> responseU = UserRest.getUser(filtroU,beanDS);
							TUser usuario= new TUser();
							if(responseU!=null && responseU.getCantidad()>0) {
								usuario = mapper.convertValue(responseU.getResultados().get(0), TUser.class);
							}
								TPersonGet filtro = new TPersonGet();
								//Se coloca 1,1 por que solo te trae una solo empresa, todo el array de solo 1 empresa.
								filtro.setPaginacion(new PaginacionFiltro(1, 1));
								//Se puede ingresar todas las variables que puedas consultar.
								filtro.setPersBident(usuario.getPersBident());
								PaginaResultado<TPerson> response = PersonRest.getPerson(filtro,beanDS);
								TPerson perUser= new TPerson();
								if(response!=null && response.getCantidad()>0) {
									perUser = mapper.convertValue(response.getResultados().get(0), TPerson.class);
								}
							
								 TNaturalPersonGet FiltroNaturalPersonGetRL=new TNaturalPersonGet();
								 FiltroNaturalPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
								 FiltroNaturalPersonGetRL.setNatuBident(perUser.getNatuBident());
								 PaginaResultado<TNaturalPerson> responseTNaturalPersonRL=NaturalPersonRest.getNaturalPerson(FiltroNaturalPersonGetRL,beanDS);
								 TNaturalPerson tNaturalPerson =new TNaturalPerson();
								 if(responseTNaturalPersonRL!=null && responseTNaturalPersonRL.getCantidad()>0) {
									tNaturalPerson = mapper.convertValue(responseTNaturalPersonRL.getResultados().get(0), TNaturalPerson.class);
								 }

								 TEmailPersonGet FiltroEmailPersonGetRL=new TEmailPersonGet();
								 FiltroEmailPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
								 FiltroEmailPersonGetRL.setPersBident(perUser.getPersBident());
								 PaginaResultado<TEmailPerson> responseTEmailPersonRL=EmailPersonRest.getEmailPerson(FiltroEmailPersonGetRL,beanDS);
								 TEmailPerson tEmailPersonRL =new TEmailPerson();
								 if(responseTEmailPersonRL!=null && responseTEmailPersonRL.getCantidad()>0) {
									tEmailPersonRL = mapper.convertValue(responseTEmailPersonRL.getResultados().get(0), TEmailPerson.class);
								 }
						     
									TAddressPersonGet FiltroAddresPersonGetRL=new TAddressPersonGet();
									 FiltroAddresPersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
									 FiltroAddresPersonGetRL.setPersBident(perUser.getPersBident());
									 System.out.println("Esto "+perUser.getPersBident());
									 PaginaResultado<TAddressPerson> responseTAdresPersonRL=AddressPersonRest.getAddressPerson(FiltroAddresPersonGetRL,beanDS);
									 TAddressPerson tAddresPersonRL =new TAddressPerson();
									 if(responseTAdresPersonRL!=null && responseTAdresPersonRL.getCantidad()>0) {
										 tAddresPersonRL = mapper.convertValue(responseTAdresPersonRL.getResultados().get(0), TAddressPerson.class);
									 }
									 
								 TPhonePersonGet FiltroPhonePersonGetRL=new TPhonePersonGet();
								 FiltroPhonePersonGetRL.setPaginacion(new PaginacionFiltro(1, 1));
								 FiltroPhonePersonGetRL.setPersBident(perUser.getPersBident());
								 PaginaResultado<TPhonePerson> responseTPhonePersonRL=PhonePersonRest.getPhonePerson(FiltroPhonePersonGetRL,beanDS);
								 TPhonePerson tPhonePersonRL =new TPhonePerson();
								 if(responseTPhonePersonRL!=null && responseTPhonePersonRL.getCantidad()>0) {
									tPhonePersonRL = mapper.convertValue(responseTPhonePersonRL.getResultados().get(0), TPhonePerson.class);
								 } 
								 
								 TLegalPersonGet filtroLegalPerson = new TLegalPersonGet();
									filtroLegalPerson.setPaginacion(new PaginacionFiltro(1, 1));
									filtroLegalPerson.setLegaBident(perUser.getLegaBident());
									PaginaResultado<TLegalPerson>responseLegalPerson= legalPersonRest.getLegalPerson(filtroLegalPerson,beanDS);
									TLegalPerson tLegalPerson =new TLegalPerson();
									if(responseLegalPerson!=null && responseLegalPerson.getCantidad()>0) {
										tLegalPerson = mapper.convertValue(responseLegalPerson.getResultados().get(0), TLegalPerson.class);
									}		
									
									Gson gson = new Gson();
									String data = gson.toJson(tLegalPerson);
									JsonObject robject = new JsonObject();
									robject.addProperty("msg", "ok");
									robject.addProperty("usuarioPer_legal", data);
									data = gson.toJson(tAddresPersonRL);
									robject.addProperty("usuarioDirec", data);				
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


