package pe.am.spring.rest;

import java.util.List;
import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.FilterPersona;
import pe.am.spring.entity.InsertBussines;
import pe.am.spring.entity.InsertRepresentLegal;
import pe.am.spring.entity.PersonaIns;
import pe.am.spring.entity.PersonaUpd;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPersonPost;
import pe.am.spring.entity.TPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class PersonRest extends AbstractRestClient {
	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 20 nov. 2017
	 * @time : 14:29:18
	 * @author : Ehilario
	 * @descripcion : Obtener lista de persona
	 */

//	public PaginaResultado<TPerson> getPerson(TPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tPerson/";
//		PaginaResultado<TPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//
//	public List<TPerson> postPerson(List<TPersonPost> tPersonPost) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tPerson/";
//		return sendPost(hostUri, resourcePath, tPersonPost, List.class);
//	}
//
//	public void putPerson(List<TPersonPut> tPersonPut) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tPerson/";
//		sendPut(hostUri, resourcePath, tPersonPut);
//	}
//
//	public List<InsertBussines> postCrearEmpresa(List<InsertBussines> InsertBussines) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/crearEmpresa/";
//		return sendPost(hostUri, resourcePath, InsertBussines, List.class);
//	}
//	
//	public InsertRepresentLegal postInsertRepresentanteLegal(InsertRepresentLegal insertRepresentLegal) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/crearRepresentanteLegal/";
//		return sendPost(hostUri, resourcePath, insertRepresentLegal, InsertRepresentLegal.class);
//	}
//	
//	public PaginaResultado<FilterPersona> getPerson(FilterPersona filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tPersonFilter/";
//		PaginaResultado<FilterPersona> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//	
//	public List<PersonaIns> postInsertPersona(List<PersonaIns> filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/crearPersona/";
//		List<PersonaIns> response = sendPost(hostUri, resourcePath, filtro, List.class);
//		return response;
//	}
//	public void postUpdatePersona(List<PersonaUpd> filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/actualizarPersona/";
//		sendPut(hostUri, resourcePath, filtro);
//	}
	
	public PaginaResultado<TPerson> getPerson(TPersonGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tPerson/";
		PaginaResultado<TPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public List<TPerson> postPerson(List<TPersonPost> tPersonPost,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tPerson/";
		return sendPost(hostUri, resourcePath, tPersonPost, List.class,beanDS);
	}

	public void putPerson(List<TPersonPut> tPersonPut,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tPerson/";
		sendPut(hostUri, resourcePath, tPersonPut,beanDS);
	}

	public List<InsertBussines> postCrearEmpresa(List<InsertBussines> InsertBussines,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/crearEmpresa/";
		return sendPost(hostUri, resourcePath, InsertBussines, List.class,beanDS);
	}
	
	public InsertRepresentLegal postInsertRepresentanteLegal(InsertRepresentLegal insertRepresentLegal,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/crearRepresentanteLegal/";
		return sendPost(hostUri, resourcePath, insertRepresentLegal, InsertRepresentLegal.class,beanDS);
	}
	
	public PaginaResultado<FilterPersona> getPerson(FilterPersona filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tPersonFilter/";
		PaginaResultado<FilterPersona> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
	
	public List<PersonaIns> postInsertPersona(List<PersonaIns> filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/crearPersona/";
		List<PersonaIns> response = sendPost(hostUri, resourcePath, filtro, List.class,beanDS);
		return response;
	}
	public void postUpdatePersona(List<PersonaUpd> filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/actualizarPersona/";
		sendPut(hostUri, resourcePath, filtro,beanDS);
	}
	
	
}
