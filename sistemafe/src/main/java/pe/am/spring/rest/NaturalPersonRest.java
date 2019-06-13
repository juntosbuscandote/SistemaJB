package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TNaturalPerson;
import pe.am.spring.entity.TNaturalPersonGet;
import pe.am.spring.entity.TNaturalPersonPost;
import pe.am.spring.entity.TNaturalPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class NaturalPersonRest extends AbstractRestClient {
	/**
     * @param filtro
     * @return 
     * @throws pe.am.spring.entity.ServiceLogicException
     * @method : getliquidationList
     * @date : 21 nov. 2017
     * @time : 10:49:11
     * @author : Ehilario
     * @descripcion : Obtener lista de persona natural
     */
	
//	public PaginaResultado<TNaturalPerson> getNaturalPerson(TNaturalPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tNaturalPerson/";
//		PaginaResultado<TNaturalPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//        
//        public List<TNaturalPerson> postNaturalPerson(List<TNaturalPersonPost> tNaturalPersonPost) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tNaturalPerson/";
//        return sendPost(hostUri, resourcePath, tNaturalPersonPost, List.class);
//    }
//        
//        public void putNaturalPerson(List<TNaturalPersonPut> tNaturalPersonPut) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tNaturalPerson/";
//        sendPut(hostUri, resourcePath,tNaturalPersonPut);
//    }

	public PaginaResultado<TNaturalPerson> getNaturalPerson(TNaturalPersonGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tNaturalPerson/";
		PaginaResultado<TNaturalPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
        
        public List<TNaturalPerson> postNaturalPerson(List<TNaturalPersonPost> tNaturalPersonPost,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tNaturalPerson/";
        return sendPost(hostUri, resourcePath, tNaturalPersonPost, List.class,beanDS);
    }
        
        public void putNaturalPerson(List<TNaturalPersonPut> tNaturalPersonPut,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tNaturalPerson/";
        sendPut(hostUri, resourcePath,tNaturalPersonPut,beanDS);
    }
	
	
}
