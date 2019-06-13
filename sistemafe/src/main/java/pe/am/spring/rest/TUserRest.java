package pe.am.spring.rest;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.RequestGCMod;
import pe.am.spring.entity.RequestMenu;
import pe.am.spring.entity.RequestMenuPerfil;
import pe.am.spring.entity.Response;
import pe.am.spring.entity.RptaGenerica;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TBusinessGroup;
import pe.am.spring.entity.TBusinessGroupGet;
import pe.am.spring.entity.TBusinessGroupPost;
import pe.am.spring.entity.TBusinessGroupPut;
import pe.am.spring.entity.TGrupoComerFilter;
import pe.am.spring.entity.TGrupoComerFilterGet;
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
import pe.am.spring.entity.TUserPost;
import pe.am.spring.entity.TUserPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component // <---es el estereotipo principal, indica que la clase anotada es un
			// component (o un Bean de Spring).
public class TUserRest extends AbstractRestClient {
	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 23 nov. 2017
	 * @time : 10:25:02
	 * @author : Ehilario
	 * @descripcion : Obtener lista de usuarios
	 */

	public String obtenerUsuario(String usuario, BeanDS beanDS) {
		/** CREAR NOM **/
		int x = 0;
		int i = 0;
		String user = usuario;
		while (x == 0) {
			String cadena = "";
			String[] abecedario = { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
					"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
			Random r2 = new Random();
			cadena = abecedario[r2.nextInt(26) + 1] + abecedario[r2.nextInt(26) + 1] + abecedario[r2.nextInt(26) + 1]
					+ abecedario[r2.nextInt(26) + 1];
			user = user + cadena;
			TUserGet filtro = new TUserGet();
			filtro.setUserVuser(user);
			filtro.setPaginacion(new PaginacionFiltro(1, 1));
			try {
				PaginaResultado<TUser> resultado = getUser(filtro, beanDS);
				if (resultado.getCantidad() > 0) {
					i++;
				} else {
					x = 1;
					break;
				}
			} catch (ServiceLogicException e) {
				e.printStackTrace();
				return null;
			}
		}
		return user;
	}

	public PaginaResultado<TUser> getUser(TUserGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tUser/";
		PaginaResultado<TUser> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}

	public List<TUser> postUser(List<TUserPost> tUserPost, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tUser/";
		return sendPost(hostUri, resourcePath, tUserPost, List.class, beanDS);
	}

	public void putUser(List<TUserPut> tUserPut, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tUser/";
		sendPut(hostUri, resourcePath, tUserPut, beanDS);
	}

	public PaginaResultado<TUserFilter> getUserFilter(TUserFilterGet filtro, BeanDS beanDS)
			throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tUserFilter/";
		PaginaResultado<TUserFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}

	/*********************************************************************************************************/
	/*---------------------------------   CRUD PERFILES   --------------------------------------------------*/
	/*********************************************************************************************************/

	

	public RptaGenerica obtenerMenu(RequestMenu filtroMenu, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/obtenerMenu";
		RptaGenerica response = sendGet(hostUri, resourcePath, filtroMenu, RptaGenerica.class,bean);
		return response;
	}
	
	
	
	/*
	 * test ds alonso
	 */

	public PaginaResultado<TUser> testDS(TUserGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tUserDS/";
		PaginaResultado<TUser> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}
	
	//accesos
	
	public List<TProfile> postGrupoComercial(List<TBusinessGroupPost> tBusinessGroupPost, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tBusinessGroup/";
		return sendPost(hostUri, resourcePath, tBusinessGroupPost, List.class, beanDS);
	}
	
	public PaginaResultado<TBusinessGroup> getGrupoComer(TBusinessGroupGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tBusinessGroup/";
		PaginaResultado<TBusinessGroup> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}
	public void putGrupoComer(List<TBusinessGroupPut> filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tBusinessGroup/";
		sendPut(hostUri, resourcePath, filtro, beanDS);
	}
	
	public PaginaResultado<TGrupoComerFilter> getGrupoComerFilter(TGrupoComerFilterGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tBusinessGroupFilter/";
		PaginaResultado<TGrupoComerFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}
	
	public RptaGenerica asigModGrupoComercial(String datos, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/asignarModGrupoCom/";
		return sendPost(hostUri, resourcePath, datos, 	RptaGenerica.class, beanDS);
	}
	
	public RptaGenerica obtenerMenuAsigMod(RequestGCMod filtroMenu, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/obtenerMenuAsigMod";
		RptaGenerica response = sendGet(hostUri, resourcePath, filtroMenu, RptaGenerica.class,bean);
		return response;
	}
	
	public PaginaResultado<TModuleGet> getModulo(TModuleGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tModule/";
		PaginaResultado<TModuleGet> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}
	
	
	public List<TProfile> postPerfiles(List<TProfilePost> tProfilePost, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tProfile/";
		return sendPost(hostUri, resourcePath, tProfilePost, List.class, beanDS);
	}
	
	public PaginaResultado<TPerfilFilter> getPerfilesFilter(TPerfilFilterGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tProfileFilter/";
		PaginaResultado<TPerfilFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}
	
	
	public PaginaResultado<TProfile> getProfile(TProfileGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tProfile/";
		PaginaResultado<TProfile> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, beanDS);
		return response;
	}

	public List<TProfile> postProfile(List<TProfilePost> tProfilePost, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tProfile/";
		return sendPost(hostUri, resourcePath, tProfilePost, List.class, beanDS);
	}

	public void putProfile(List<TProfilePut> tProfilePut, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/tProfile/";
		sendPut(hostUri, resourcePath, tProfilePut, beanDS);
	}
	
	public RptaGenerica obtenerMenuPerfil(RequestMenuPerfil filtroMenu, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/obtenerMenuPerfil";
		RptaGenerica response = sendGet(hostUri, resourcePath, filtroMenu, RptaGenerica.class,bean);
		return response;
	}
	
	public RptaGenerica asigModPerfil(String datos, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/asignarModPerfiles/";
		return sendPost(hostUri, resourcePath, datos, 	RptaGenerica.class, beanDS);
	}
	
	public RptaGenerica obtenerMenu2(RequestMenu filtroMenu, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostUser();
		String resourcePath = "api/v1/obtenerMenu2";
		RptaGenerica response = sendGet(hostUri, resourcePath, filtroMenu, RptaGenerica.class,bean);
		return response;
	}
}
