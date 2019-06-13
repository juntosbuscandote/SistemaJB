package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TLegalPersonPost;
import pe.am.spring.entity.TLegalPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class LegalPersonRest extends AbstractRestClient {


	public PaginaResultado<TLegalPerson> getLegalPerson(TLegalPersonGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tLegalPerson/";
		PaginaResultado<TLegalPerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
        
        public List<TLegalPerson> postLegalPerson(List<TLegalPersonPost> tLegalPersonPost,BeanDS beanDS) 
            throws ServiceLogicException {
	        String hostUri = Util.getHostPerson();
	        String resourcePath = "api/v1/tLegalPerson/";
	        return sendPost(hostUri, resourcePath, tLegalPersonPost, List.class,beanDS);
    }
        
        public void putLegalPerson(List<TLegalPersonPut> tLegalPersonPut,BeanDS beanDS) 
            throws ServiceLogicException {
	        String hostUri = Util.getHostPerson();
	        String resourcePath = "api/v1/tLegalPerson/";
	        sendPut(hostUri, resourcePath,tLegalPersonPut,beanDS);
    }

}
