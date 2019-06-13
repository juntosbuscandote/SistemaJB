package pe.am.spring.rest;

import java.util.List;
import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TVoucher;
import pe.am.spring.entity.TVoucherDashboard;
import pe.am.spring.entity.TVoucherDashboardGet;
import pe.am.spring.entity.TVoucherFilter;
import pe.am.spring.entity.TVoucherFilterGet;
import pe.am.spring.entity.TVoucherGet;
import pe.am.spring.entity.TVoucherPost;
import pe.am.spring.entity.TVoucherPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

/**
 *
 * @author ehr
 */
@Component
public class VoucherRest extends AbstractRestClient {
	/**
	 * @param filtro
	 * @return
	 * @throws pe.am.spring.entity.ServiceLogicException
	 * @method : getliquidationList
	 * @date : 17 oct. 2017
	 * @time : 11:19:08
	 * @author : ehr
	 * @descripcion : Obtener lista de Voucher
	 */
/*
	public PaginaResultado<TVoucher> getVoucher(TVoucherGet filtro) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		PaginaResultado<TVoucher> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
		return response;
	}

	public PaginaResultado<TVoucherFilter> getVoucherFilter(TVoucherFilterGet filtro) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "/api/v1/tVoucherFilter2/";
		PaginaResultado<TVoucherFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
		return response;
	}
	
	public PaginaResultado<TVoucher> getVoucherFilter(TVoucherGet filtro) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "/api/v1/tVoucher/";
		PaginaResultado<TVoucher> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
		return response;
	}

	public List<TVoucher> postVoucher(List<TVoucherPost> tVoucherPost) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		return sendPost(hostUri, resourcePath, tVoucherPost, List.class);
	}

	public void putVoucher(List<TVoucherPut> tVoucherPut) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		sendPut(hostUri, resourcePath, tVoucherPut);
	}

	public PaginaResultado<TVoucherDashboard> getVoucherDashboard(TVoucherDashboardGet filtro) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucherDashboard/";
		PaginaResultado<TVoucherDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
		return response;
	}
	
	public PaginaResultado<TVoucherDashboard> getVoucherDashboardMeses(TVoucherDashboardGet filtro) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucherDashboardMeses/";
		PaginaResultado<TVoucherDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class);
		return response;
	}*/
	
	
	//azevallos - modificacion llamadas al servicio 
	public PaginaResultado<TVoucher> getVoucher(TVoucherGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		PaginaResultado<TVoucher> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public PaginaResultado<TVoucherFilter> getVoucherFilter(TVoucherFilterGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "/api/v1/tVoucherFilter2/";
		PaginaResultado<TVoucherFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
	
	public PaginaResultado<TVoucher> getVoucherFilter(TVoucherGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "/api/v1/tVoucher/";
		PaginaResultado<TVoucher> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

	public List<TVoucher> postVoucher(List<TVoucherPost> tVoucherPost, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		return sendPost(hostUri, resourcePath, tVoucherPost, List.class,beanDS);
	}

	public void putVoucher(List<TVoucherPut> tVoucherPut, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucher/";
		sendPut(hostUri, resourcePath, tVoucherPut,beanDS);
	}

	public PaginaResultado<TVoucherDashboard> getVoucherDashboard(TVoucherDashboardGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucherDashboard/";
		PaginaResultado<TVoucherDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}
	
	public PaginaResultado<TVoucherDashboard> getVoucherDashboardMeses(TVoucherDashboardGet filtro, BeanDS beanDS) throws ServiceLogicException {
		String hostUri = Util.getHostVoucher();
		String resourcePath = "api/v1/tVoucherDashboardMeses/";
		PaginaResultado<TVoucherDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,beanDS);
		return response;
	}

}
