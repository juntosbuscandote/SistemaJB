package pe.am.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.Email;
import pe.am.spring.entity.EmailGet;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class EmailRest  extends AbstractRestClient {

	
	
//	public PaginaResultado<Email> getVoucher(EmailGet filtro) throws ServiceLogicException {
//		String resourcePath = "api/v1/envioMail/";
//		PaginaResultado<Email> response = sendPost(Util.getUrlMC(), resourcePath, filtro, PaginaResultado.class);
//		return response;
//	}
	
	public PaginaResultado<Email> getVoucher(EmailGet filtro,BeanDS beanDS) throws ServiceLogicException {
		String resourcePath = "api/v1/envioMail/";
		PaginaResultado<Email> response = sendPost(Util.getUrlMC(), resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
	
}