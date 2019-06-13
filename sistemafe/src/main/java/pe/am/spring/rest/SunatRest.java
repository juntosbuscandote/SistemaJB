package pe.am.spring.rest;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TDni;
import pe.am.spring.entity.TSunat;
import pe.am.spring.util.Util;

@Component
public class SunatRest extends AbstractRestClient {
	
	/*public TSunat getUser(TSunat filtro) throws ServiceLogicException {
		String hostUri = Util.getconsultarSunat();
		String resourcePath = "api/v1/tSunat/";
		TSunat response = sendGet(hostUri, resourcePath, filtro, TSunat.class);
		return response;
	}*/
	
	public TSunat getUser(TSunat filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getconsultarSunat();
		String resourcePath = "api/v1/tSunat/";
		TSunat response = sendGet(hostUri, resourcePath, filtro, TSunat.class,beanDS);
		return response;
	}
	
	public TDni getDni(TDni filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getconsultarSunat();
		String resourcePath = "api/v1/tDni/";
		TDni response = sendGet(hostUri, resourcePath, filtro, TDni.class,beanDS);
		return response;
	}
}
