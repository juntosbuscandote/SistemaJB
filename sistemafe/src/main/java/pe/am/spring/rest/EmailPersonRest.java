package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TEmailPerson;
import pe.am.spring.entity.TEmailPersonGet;
import pe.am.spring.entity.TEmailPersonPost;
import pe.am.spring.entity.TEmailPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class EmailPersonRest extends AbstractRestClient {
	/**
     * @param filtro
     * @return 
     * @throws pe.am.spring.entity.ServiceLogicException
     * @method : getliquidationList
     * @date : 21 nov. 2017
     * @time : 10:49:11
     * @author : Ehilario
     * @descripcion : Obtener lista de correo de persona
     */
	
//	public PaginaResultado<TEmailPerson> getEmailPerson(TEmailPersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tEmailPerson/";
//		PaginaResultado<TEmailPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//        
//        public List<TEmailPerson> postEmailPerson(List<TEmailPersonPost> tEmailPersonPost) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tEmailPerson/";
//        return sendPost(hostUri, resourcePath, tEmailPersonPost, List.class);
//    }
//        
//        public void putEmailPerson(List<TEmailPersonPut> tEmailPersonPut) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tEmailPerson/";
//        sendPut(hostUri, resourcePath,tEmailPersonPut);
//    }
	
	public PaginaResultado<TEmailPerson> getEmailPerson(TEmailPersonGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tEmailPerson/";
		PaginaResultado<TEmailPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
        
        public List<TEmailPerson> postEmailPerson(List<TEmailPersonPost> tEmailPersonPost,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tEmailPerson/";
        return sendPost(hostUri, resourcePath, tEmailPersonPost, List.class,beanDS);
    }
        
        public void putEmailPerson(List<TEmailPersonPut> tEmailPersonPut,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tEmailPerson/";
        sendPut(hostUri, resourcePath,tEmailPersonPut,beanDS);
    }

}
