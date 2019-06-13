package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TClient;
import pe.am.spring.entity.TClientEndFilterPerson;
import pe.am.spring.entity.TClientEndFilterPersonGet;
import pe.am.spring.entity.TClientEndPerson;
import pe.am.spring.entity.TClientEndPersonGet;
import pe.am.spring.entity.TClientEndPersonPost;
import pe.am.spring.entity.TClientEndPersonPut;
import pe.am.spring.entity.TClientGet;
import pe.am.spring.entity.TClientPost;
import pe.am.spring.entity.TClientPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class ClientRest extends AbstractRestClient {
	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 02 oct. 2017
	 * @time : 12:54:55
	 * @author : EHilario
	 * @descripcion : Obtener lista de cli
	 */

//	public PaginaResultado<TClientEndPerson> getClientEnd(TClientEndPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tClientEndPerson/";
//		PaginaResultado<TClientEndPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//
//	public List<TClientEndPerson> postClientEnd(List<TClientEndPersonPost> tClientEndPost)
//			throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tClientEndPerson/";
//		return sendPost(hostUri, resourcePath, tClientEndPost, List.class);
//	}
//
//	public void putClientEnd(List<TClientEndPersonPut> tClientEndPut) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tClientEndPerson/";
//		sendPut(hostUri, resourcePath, tClientEndPut);
//	}
//
//	/*******************************************************************************/
//	/***************************
//	 * CLIENTE FINAL GRILLA
//	 ********************************/
//	/*******************************************************************************/
//
//	public PaginaResultado<TClientEndFilterPerson> getClientEndFilterRest(TClientEndFilterPersonGet filtro)
//			throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tClientEndFilterPerson/";
//		PaginaResultado<TClientEndFilterPerson> response = sendGet(hostUri, resourcePath, filtro,
//				PaginaResultado.class);
//		return response;
//	}
	
	public PaginaResultado<TClientEndPerson> getClientEnd(TClientEndPersonGet filtro , BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tClientEndPerson/";
		PaginaResultado<TClientEndPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public List<TClientEndPerson> postClientEnd(List<TClientEndPersonPost> tClientEndPost, BeanDS beanDS)
			throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tClientEndPerson/";
		return sendPost(hostUri, resourcePath, tClientEndPost, List.class,beanDS);
	}

	public void putClientEnd(List<TClientEndPersonPut> tClientEndPut, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tClientEndPerson/";
		sendPut(hostUri, resourcePath, tClientEndPut,beanDS);
	}

	/*******************************************************************************/
	/***************************
	 * CLIENTE FINAL GRILLA
	 ********************************/
	/*******************************************************************************/

	public PaginaResultado<TClientEndFilterPerson> getClientEndFilterRest(TClientEndFilterPersonGet filtro, BeanDS beanDS)
			throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tClientEndFilterPerson/";
		PaginaResultado<TClientEndFilterPerson> response = sendGet(hostUri, resourcePath, filtro,
				PaginaResultado.class,beanDS);
		return response;
	}

}
