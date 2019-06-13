package pe.am.spring.rest;

import java.util.List;
import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TAsignarUserxSucursal;
import pe.am.spring.entity.TAsignarUserxSucursalGet;
import pe.am.spring.entity.TBranchOffice;
import pe.am.spring.entity.TBranchOfficeGet;
import pe.am.spring.entity.TBranchOfficePost;
import pe.am.spring.entity.TBranchOfficePut;
import pe.am.spring.entity.TBusinessBDFilter;
import pe.am.spring.entity.TBusinessBDFilterGet;
import pe.am.spring.entity.TBussines;
import pe.am.spring.entity.TBussinesFilter;
import pe.am.spring.entity.TBussinesFilterGet;
import pe.am.spring.entity.TBussinesGet;
import pe.am.spring.entity.TBussinesPost;
import pe.am.spring.entity.TBussinesPut;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TEmployeeGet;
import pe.am.spring.entity.TEmployeePost;
import pe.am.spring.entity.TEmployeePut;
import pe.am.spring.entity.TOfficeUser;
import pe.am.spring.entity.TOfficeUserGet;
import pe.am.spring.entity.TOfficeUserPost;
import pe.am.spring.entity.TOfficeUserPut;
import pe.am.spring.entity.TOfficeUserxSucursal;
import pe.am.spring.entity.TOfficeUserxSucursalGet;
import pe.am.spring.entity.TParamBranchOffice;
import pe.am.spring.entity.TParamBranchOfficeGet;
import pe.am.spring.entity.TParamBranchOfficePost;
import pe.am.spring.entity.TParamBranchOfficePut;
import pe.am.spring.entity.TParamBussines;
import pe.am.spring.entity.TParamBussinesGet;
import pe.am.spring.entity.TParamBussinesPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class BussinesRest extends AbstractRestClient {

	/*********************************************************************************************************/
	/*---------------------------------   CRUD EMPRESA   ----------------------------------------------------*/
	/*********************************************************************************************************/
	
	public PaginaResultado<TBussines> getBussines(TBussinesGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBussines/";
		PaginaResultado<TBussines> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TBussines> postBussines(List<TBussinesPost> tBussinesPost, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBussines/";
		return sendPost(hostUri, resourcePath, tBussinesPost, List.class,bean);
	}

	public void putBussines(List<TBussinesPut> tBussinesPut, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBussines/";
		sendPut(hostUri, resourcePath, tBussinesPut,bean);
	}

	public PaginaResultado<TBussinesFilter> getBussinesFilter(TBussinesFilterGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBussinesFilter/";
		PaginaResultado<TBussinesFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	/*********************************************************************************************************/
	/*---------------------------------   CRUD EMPLEADOS   --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TEmployee> getEmployee(TEmployeeGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tEmployee/";
		PaginaResultado<TEmployee> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TEmployee> postEmployee(List<TEmployeePost> tEmployeePost, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tEmployee/";
		return sendPost(hostUri, resourcePath, tEmployeePost, List.class,  bean);
	}

	public void putEmployee(List<TEmployeePut> tEmployeePut, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tEmployee/";
		sendPut(hostUri, resourcePath, tEmployeePut,bean);
	}
	

	
	//parametros por empresa
	public PaginaResultado<TParamBussines> getParamBussines(TParamBussinesGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tParamBussines/";
		PaginaResultado<TParamBussines> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public void putParamBussines(List<TParamBussinesPut> tBussinesPut, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tParamBussines/";
		sendPut(hostUri, resourcePath, tBussinesPut,bean);
	}
	
	public PaginaResultado<TBranchOffice> getSucursal(TBranchOfficeGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBranchOffice/";
		PaginaResultado<TBranchOffice> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	public List<TBranchOfficePost> postTBranchOffice(List<TBranchOfficePost> tBranchOfficePost, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBranchOffice/";
		return sendPost(hostUri, resourcePath, tBranchOfficePost, List.class,bean);
	}
	
	
	public void putTBranchOffice(List<TBranchOfficePut> tBranchOfficeLista, BeanDS bean) throws ServiceLogicException{
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tBranchOffice/";
		sendPut(hostUri, resourcePath, tBranchOfficeLista,bean);
	}
	
	
	public List<TOfficeUserPost> postTOfficeUser(List<TOfficeUserPost> tOfficeUserPost, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tOfficeUser/";
		return sendPost(hostUri, resourcePath, tOfficeUserPost, List.class,bean);
	}
	
	public List<TOfficeUserPost> postTOfficeUserFront(List<TOfficeUserPost> tOfficeUserPost, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tOfficeUserFront/";
		return sendPost(hostUri, resourcePath, tOfficeUserPost, List.class,bean);
	}
	
	
	
	public void putTOfficePut(List<TOfficeUserPut> tOfficeUserPut, BeanDS bean) throws ServiceLogicException{
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tOfficeUser/";
		sendPut(hostUri, resourcePath, tOfficeUserPut,bean);
	}
	
	public PaginaResultado<TOfficeUser> getTOfficeUser(TOfficeUserGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tOfficeUser/";
		PaginaResultado<TOfficeUser> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	
	public PaginaResultado<TOfficeUserxSucursal> getOfficeUserxSucursal(TOfficeUserxSucursalGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tOfficeUserxSucursal/";
		PaginaResultado<TOfficeUserxSucursal> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	public PaginaResultado<TAsignarUserxSucursal> getAsignarUserxSucursal(TAsignarUserxSucursalGet filtro, BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostEmpresa();
		String resourcePath = "api/v1/tAsignarUserxSucursal/";
		PaginaResultado<TAsignarUserxSucursal> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	//parametros por empresa
		public PaginaResultado<TParamBranchOffice> getParamBranchOffice(TParamBranchOfficeGet filtro, BeanDS bean) throws ServiceLogicException {
			String hostUri = Util.getHostEmpresa();
			String resourcePath = "api/v1/tParamBranchOffice/";
			PaginaResultado<TParamBranchOffice> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
			return response;
		}
		
		public List<TParamBranchOffice> postParamBranchOffice(List<TParamBranchOfficePost> tParamBranchOfficePost, BeanDS bean) throws ServiceLogicException {
			String hostUri = Util.getHostEmpresa();
			String resourcePath = "api/v1/tParamBranchOffice/";
			return sendPost(hostUri, resourcePath, tParamBranchOfficePost, List.class,  bean);
		}

		public void putParamBranchOffice(List<TParamBranchOfficePut> tParamBranchOfficePut, BeanDS bean) throws ServiceLogicException {
			String hostUri = Util.getHostEmpresa();
			String resourcePath = "api/v1/tParamBranchOffice/";
			sendPut(hostUri, resourcePath, tParamBranchOfficePut,bean);
		}
		
		public PaginaResultado<TBusinessBDFilter> getTBusinessBDFilter(TBusinessBDFilterGet filtro, BeanDS bean) throws ServiceLogicException {
			String hostUri = Util.getHostEmpresa();
			String resourcePath = "api/v1/tBusinessBDFilter/";
			PaginaResultado<TBusinessBDFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
			return response;
		}
	
}


