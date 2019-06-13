package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TCatalogue;
import pe.am.spring.entity.TCatalogueGet;
import pe.am.spring.entity.TCataloguePost;
import pe.am.spring.entity.TCataloguePut;
import pe.am.spring.entity.TCountry;
import pe.am.spring.entity.TCountryGet;
import pe.am.spring.entity.TUbigeo;
import pe.am.spring.entity.TUbigeoGet;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TCatalogueDetPut;
import pe.am.spring.entity.TCatalogueDetPost;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component // <---es el estereotipo principal, indica que la clase anotada es un
			// component (o un Bean de Spring).
public class CatalogueRest extends AbstractRestClient {

	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 28 dic. 2017
	 * @time : 15:12:02
	 * @author : Ehilario
	 * @descripcion : Obtener lista de catalogo y detalle de de catalogo
	 */

//	public PaginaResultado<TCatalogue> getCatalogue(TCatalogueGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogue/";
//		PaginaResultado<TCatalogue> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//
//	public List<TCatalogue> postCatalogue(List<TCataloguePost> tCataloguePost) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogue/";
//		return sendPost(hostUri, resourcePath, tCataloguePost, List.class);
//	}
//
//	public void putCatalogue(List<TCataloguePut> tCataloguePut) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogue/";
//		sendPut(hostUri, resourcePath, tCataloguePut);
//	}
//
//	/*********************************************************************************************************/
//	/*---------------------------------  detalle de catalogo  --------------------------------------------------*/
//	/*********************************************************************************************************/
//
//	public PaginaResultado<TCatalogueDet> getCatalogueDet(TCatalogueDetGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogueDet/";
//		PaginaResultado<TCatalogueDet> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//
//	public List<TCatalogueDet> postCatalogueDet(List<TCatalogueDetPost> tCatalogueDetPost)
//			throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogueDet/";
//		return sendPost(hostUri, resourcePath, tCatalogueDetPost, List.class);
//	}
//
//	public void putCatalogueDet(List<TCatalogueDetPut> tCatalogueDetPut) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCatalogueDet/";
//		sendPut(hostUri, resourcePath, tCatalogueDetPut);
//	}
//
//	/*********************************************************************************************************/
//	/*---------------------------------  detalle de Pais  --------------------------------------------------*/
//	/*********************************************************************************************************/
//
//	public PaginaResultado<TCountry> getCountry(TCountryGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tCountry/";
//		PaginaResultado<TCountry> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//
//	/*********************************************************************************************************/
//	/*---------------------------------  detalle de Ubigeo  --------------------------------------------------*/
//	/*********************************************************************************************************/
//
//	public PaginaResultado<TUbigeo> getUbigeo(TUbigeoGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostCatalogue();
//		String resourcePath = "api/v1/tUbigeo/";
//		PaginaResultado<TUbigeo> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
	
	
	public PaginaResultado<TCatalogue> getCatalogue(TCatalogueGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogue/";
		PaginaResultado<TCatalogue> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public List<TCatalogue> postCatalogue(List<TCataloguePost> tCataloguePost,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogue/";
		return sendPost(hostUri, resourcePath, tCataloguePost, List.class,beanDS);
	}

	public void putCatalogue(List<TCataloguePut> tCataloguePut,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogue/";
		sendPut(hostUri, resourcePath, tCataloguePut,beanDS);
	}

	/*********************************************************************************************************/
	/*---------------------------------  detalle de catalogo  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TCatalogueDet> getCatalogueDet(TCatalogueDetGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogueDet/";
		PaginaResultado<TCatalogueDet> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public List<TCatalogueDet> postCatalogueDet(List<TCatalogueDetPost> tCatalogueDetPost,BeanDS beanDS)
			throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogueDet/";
		return sendPost(hostUri, resourcePath, tCatalogueDetPost, List.class,beanDS);
	}

	public void putCatalogueDet(List<TCatalogueDetPut> tCatalogueDetPut,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCatalogueDet/";
		sendPut(hostUri, resourcePath, tCatalogueDetPut,beanDS);
	}

	/*********************************************************************************************************/
	/*---------------------------------  detalle de Pais  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TCountry> getCountry(TCountryGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tCountry/";
		PaginaResultado<TCountry> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	/*********************************************************************************************************/
	/*---------------------------------  detalle de Ubigeo  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TUbigeo> getUbigeo(TUbigeoGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostCatalogue();
		String resourcePath = "api/v1/tUbigeo/";
		PaginaResultado<TUbigeo> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
}
