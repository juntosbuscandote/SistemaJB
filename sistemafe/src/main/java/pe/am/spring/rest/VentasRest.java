package pe.am.spring.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.RegistroVenta;
import pe.am.spring.entity.RptaOperPDF;
import pe.am.spring.entity.RptaRegistroVenta;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TNoteCredDeb;
import pe.am.spring.entity.TNoteCredDebPost;
import pe.am.spring.entity.TSaleDetail;
import pe.am.spring.entity.TSaleDetailGet;
import pe.am.spring.entity.TSaleDetailPost;
import pe.am.spring.entity.TSaleDetailPut;
import pe.am.spring.entity.TSales;
import pe.am.spring.entity.TSalesDashboard;
import pe.am.spring.entity.TSalesDashboardGet;
import pe.am.spring.entity.TSalesDetailFilter;
import pe.am.spring.entity.TSalesDetailFilterGet;
import pe.am.spring.entity.TSalesFilter;
import pe.am.spring.entity.TSalesFilterGet;
import pe.am.spring.entity.TSalesGet;
import pe.am.spring.entity.TSalesPost;
import pe.am.spring.entity.TSalesPut;
import pe.am.spring.entity.TSalesSearch;
import pe.am.spring.entity.TSalesSearchGet;
import pe.am.spring.entity.TSeries;
import pe.am.spring.entity.TSeriesFilter;
import pe.am.spring.entity.TSeriesFilterGet;
import pe.am.spring.entity.TSeriesFilterPost;
import pe.am.spring.entity.TSeriesFilterPut;
import pe.am.spring.entity.TSeriesGet;
import pe.am.spring.entity.TSeriesPost;
import pe.am.spring.entity.TSeriesPut;
import pe.am.spring.entity.TVoucherDashboard;
import pe.am.spring.entity.TVoucherDashboardGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.util.Util;

@Component
public class VentasRest extends AbstractRestClient {

	/*********************************************************************************************************/
	/*---------------------------------   CRUD DETALLE DE VENTA  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSaleDetail> getSaleDetail(TSaleDetailGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSaleDetail/";
		PaginaResultado<TSaleDetail> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TSaleDetail> postSaleDetail(List<TSaleDetailPost> tSaleDetailPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSaleDetail/";
		return sendPost(hostUri, resourcePath, tSaleDetailPost, List.class,bean);
	}

	public void putSaleDetail(List<TSaleDetailPut> tSaleDetailPut,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSaleDetail/";
		sendPut(hostUri, resourcePath, tSaleDetailPut,bean);
	}
	
	
	/*********************************************************************************************************/
	/*---------------------------------   CRUD DE VENTA  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSales> getSale(TSalesGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSales/";
		PaginaResultado<TSales> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TSales> postSales(List<TSalesPost> tSalesPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSales/";
		return sendPost(hostUri, resourcePath, tSalesPost, List.class,bean);
	}

	public void putSales(List<TSalesPut> tSalesPut,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSales/";
		sendPut(hostUri, resourcePath, tSalesPut,bean);
	}
	
	public List<RptaRegistroVenta> guardarVenta(List<RegistroVenta> tSalesPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/RegistroVenta/";
		return sendPost(hostUri, resourcePath, tSalesPost, List.class,bean);
	}
	
	public List<RptaOperPDF> generarPDFs(List<RegistroVenta> tSalesPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/generarPDF/";
		return sendPost(hostUri, resourcePath, tSalesPost, List.class,bean);
	}
	
	/*********************************************************************************************************/
	/*---------------------------------   CRUD DE SERIES  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSeries> getSeries(TSeriesGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeries/";
		PaginaResultado<TSeries> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	public PaginaResultado<TSeries> getNextSeries(TSeriesGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tNextSeries/";
		PaginaResultado<TSeries> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TSeriesPost> postSeries(List<TSeriesPost> tSeriesPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeries/";
		return sendPost(hostUri, resourcePath, tSeriesPost, List.class,bean);
	}

	public void putSeries(List<TSeriesPut> tSeriesPut,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeries/";
		sendPut(hostUri, resourcePath, tSeriesPut,bean);
	}
	
	
	
	
	
	public PaginaResultado<TSeriesFilter> getSeriesFilter(TSeriesFilterGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeriesFilter/";
		PaginaResultado<TSeriesFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TSeriesFilterPost> postSeriesFilter(List<TSeriesFilterPost> tSeriesPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeriesFilter/";
		return sendPost(hostUri, resourcePath, tSeriesPost, List.class,bean);
	}

	public void putSeriesFilter(List<TSeriesFilterPut> tSeriesFilterPut,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSeriesFilter/";
		sendPut(hostUri, resourcePath, tSeriesFilterPut,bean);
	}
	
	
	
	/*********************************************************************************************************/
	/*---------------------------------   CRUD DE TIPO DE CAMBIO  --------------------------------------------------*/
	/*********************************************************************************************************/
	
	public List<TNoteCredDeb> postTNoteCredDeb(List<TNoteCredDebPost> tNoteCredDebPost,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tNoteCredDeb/";
		return sendPost(hostUri, resourcePath, tNoteCredDebPost, List.class,bean);
	}
	

	
	/*********************************************************************************************************/
	/*---------------------------------   FILTRO DE VENTA  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSalesFilter> getSaleFilter(TSalesFilterGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tFilterSales/";
		PaginaResultado<TSalesFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	/*********************************************************************************************************/
	/*---------------------------------   FILTRO DE VENTA DETALLE --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSalesDetailFilter> getSaleDetalleFilter(TSalesDetailFilterGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tFilterSalesDetail/";
		PaginaResultado<TSalesDetailFilter> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}

	public List<TSeriesFilter> generarSerieyNro(TSeriesFilterGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/generarNroSerie/";
		List<TSeriesFilter> response = sendGet(hostUri, resourcePath, filtro, List.class,bean);
		return response;
	}

	/*********************************************************************************************************/
	/*---------------------------------   DASHBOARD DE VENTAS  --------------------------------------------------*/
	/*********************************************************************************************************/

	public PaginaResultado<TSalesDashboard> getSalesDashboard(TSalesDashboardGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSalesDashboard/";
		PaginaResultado<TSalesDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	public PaginaResultado<TSalesDashboard> getSalesDashboardMeses(TSalesDashboardGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSalesDashboardMeses/";
		PaginaResultado<TSalesDashboard> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	public PaginaResultado<TSalesSearch> getSearchSale(TSalesSearchGet filtro,BeanDS bean) throws ServiceLogicException {
		String hostUri = Util.getHostVentas();
		String resourcePath = "api/v1/tSearchSales/";
		PaginaResultado<TSalesSearch> response = sendGet(hostUri, resourcePath, filtro, PaginaResultado.class,bean);
		return response;
	}
	
	/**
	 * @descripcion: Invoca al microservicio para calcular los montos generales del CPE
	 * @param bean con los datos necesarios para los calculos
	 * @return this UriComponentsBuilder
	 */
	/**
	 * @param oDetailProcessWrapper
	 * @return
	 * @throws ProcessException : ProcessResultWrapper
	 * @date : 11 abr. 2018
	 * @time : 15:22:47
	 * @author : Arly Fernandez
	 * @descripcion : Homologar campos del archivo
	 */
	
	
}
