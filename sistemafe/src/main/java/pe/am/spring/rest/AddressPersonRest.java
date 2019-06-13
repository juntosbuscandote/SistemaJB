package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TAddressPerson;
import pe.am.spring.entity.TAddressPersonGet;
import pe.am.spring.entity.TAddressPersonPost;
import pe.am.spring.entity.TAddressPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class AddressPersonRest extends AbstractRestClient {
	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 21 nov. 2017
	 * @time : 10:49:11
	 * @author : Ehilario
	 * @descripcion : Obtener lista de direccion de persona
	 */

//	public PaginaResultado<TAddressPerson> getAddressPerson(TAddressPersonGet filtro, BeanDS bean) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		PaginaResultado<TAddressPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, bean);
//		return response;
//	}
//
//	public List<TAddressPerson> postAddressPerson(List<TAddressPersonPost> tAddressPersonPost, BeanDS bean)
//			throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		return sendPost(hostUri, resourcePath, tAddressPersonPost, List.class, bean);
//	}
//
//	public void putAddressPerson(List<TAddressPersonPut> tAddressPersonPut, BeanDS bean) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		sendPut(hostUri, resourcePath, tAddressPersonPut, bean);
//	}
//
//	// Método auxiliares
//	public PaginaResultado<TAddressPerson> getAddressPerson(TAddressPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		PaginaResultado<TAddressPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//	
//	public void putAddressPerson(List<TAddressPersonPut> tAddressPersonPut) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		sendPut(hostUri, resourcePath, tAddressPersonPut);
//	}
	
	public PaginaResultado<TAddressPerson> getAddressPerson(TAddressPersonGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tAddressPerson/";
		PaginaResultado<TAddressPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class, bean);
		return response;
	}

	public List<TAddressPerson> postAddressPerson(List<TAddressPersonPost> tAddressPersonPost, BeanDS bean)
			throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tAddressPerson/";
		return sendPost(hostUri, resourcePath, tAddressPersonPost, List.class, bean);
	}

	public void putAddressPerson(List<TAddressPersonPut> tAddressPersonPut, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tAddressPerson/";
		sendPut(hostUri, resourcePath, tAddressPersonPut, bean);
	}

	// Método auxiliares
//	public PaginaResultado<TAddressPerson> getAddressPerson(TAddressPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		PaginaResultado<TAddressPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//	
//	public void putAddressPerson(List<TAddressPersonPut> tAddressPersonPut) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tAddressPerson/";
//		sendPut(hostUri, resourcePath, tAddressPersonPut);
//	}
}
