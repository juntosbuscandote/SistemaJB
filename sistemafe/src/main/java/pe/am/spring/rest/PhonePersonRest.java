package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TPhonePerson;
import pe.am.spring.entity.TPhonePersonGet;
import pe.am.spring.entity.TPhonePersonPost;
import pe.am.spring.entity.TPhonePersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class PhonePersonRest extends AbstractRestClient {
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
	
//	public PaginaResultado<TPhonePerson> getPhonePerson(TPhonePersonGet filtro) throws ServiceLogicException {
//		String hostUri = Util.getHostPerson();
//		String resourcePath = "api/v1/tPhonePerson/";
//		PaginaResultado<TPhonePerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
//        
//        public List<TPhonePerson> postPhonePerson(List<TPhonePersonPost> tPhonePersonPost) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tPhonePerson/";
//        return sendPost(hostUri, resourcePath, tPhonePersonPost, List.class);
//    }
//        
//        public void putPhonePerson(List<TPhonePersonPut> tPhonePersonPut) 
//            throws ServiceLogicException {
//        String hostUri = Util.getHostPerson();
//        String resourcePath = "api/v1/tPhonePerson/";
//        sendPut(hostUri, resourcePath,tPhonePersonPut);
//    }
	
	public PaginaResultado<TPhonePerson> getPhonePerson(TPhonePersonGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostPerson();
		String resourcePath = "api/v1/tPhonePerson/";
		PaginaResultado<TPhonePerson> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
        
        public List<TPhonePerson> postPhonePerson(List<TPhonePersonPost> tPhonePersonPost,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tPhonePerson/";
        return sendPost(hostUri, resourcePath, tPhonePersonPost, List.class,beanDS);
    }
        
        public void putPhonePerson(List<TPhonePersonPut> tPhonePersonPut,BeanDS beanDS) 
            throws ServiceLogicException {
        String hostUri = Util.getHostPerson();
        String resourcePath = "api/v1/tPhonePerson/";
        sendPut(hostUri, resourcePath,tPhonePersonPut,beanDS);
    }

}
