package pe.am.spring.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.ModuloMenu;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TEmployee;
import pe.am.spring.entity.TSalesDashboard;
import pe.am.spring.entity.TSalesDashboardGet;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TVoucherDashboard;
import pe.am.spring.entity.TVoucherDashboardGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.BussinesRest;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.VentasRest;
import pe.am.spring.rest.VoucherRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	protected static Logger logger = Logger.getLogger(DashboardController.class);
	
	@Autowired
	PersonRest PersonRest;
	
	@Autowired
	BussinesRest BussinesRest;

	@Autowired
	VoucherRest voucherrest;
	
	@Autowired
	VentasRest ventasrest;
	
	@Autowired
	CatalogueRest CatalogueRest;
	
	@RequestMapping(value = "/")
	public ModelAndView listContactGrilla(ModelAndView model, HttpSession ses,HttpServletRequest rq) throws IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			TUser user = (TUser) ses.getAttribute(Constantes.SESION_USUARIO);
			if (null!=user) {
				if(Util.validAcceso(ses, rq.getRequestURI().substring(rq.getContextPath().length()))) {
					logger.info("Si tiene Acceso a la pagina");
					
					model.setViewName("/Persona/modalPersona");
				model.setViewName("/Cliente/Cliente");
				}else {
					
					
					
					model.setViewName("/Permiso/PermidoDenegado");
					
					
					return model;
					
					
					
				}
			}else {
				model.setViewName("/homepost");
				return model;
			}
			TEmployee tEmployee = (TEmployee) ses.getAttribute(Constantes.SESION_EMPLEADO);
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			List<ModuloMenu> lModulos = (List<ModuloMenu>) ses.getAttribute(Constantes.MENU_USUARIO);
			model.addObject("menu", lModulos);
			
			
			//azevallos inicio
			//validar si pedira el tipo de cambio
			try {
				
				test1();
				
			Integer flagTC = (Integer) ses.getAttribute(Constantes.SESION_TIPO_CAMBIO);
				if(null!=flagTC) {
					model.addObject("flagTC", flagTC);
					
					model.addObject("fechaActual", Util.datetoStringGlobal(new Date(), "dd/MM/yyyy"));
				}
			}catch(Exception e) {
				
			}
			//azevallos fin
			
			model.setViewName("/Dashboard/Dashboard");
			HashMap<String, Object> ListFigComprTotal = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprTotal = new HashMap<String, Object>();
			int totalcpe=0;
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.##", simbolos);
			double notvPorc=0;
			double factPorc=0;
			double bolPorc=0;
			double notcPorc=0;
			double notdPorc=0;
			double notrPorc=0;
			String NombreVentana="Panel de control";
			
//			TBussinesGet filtroEmpresa = new TBussinesGet();
//			filtroEmpresa.setPaginacion(new PaginacionFiltro(1, 1));
//			filtroEmpresa.setPersBident(tEmployee.getBusiBident());
//			PaginaResultado<TBussines> responseE = BussinesRest.getBussines(filtroEmpresa);
//			TBussines empresa = new TBussines();
//			if(responseE!=null && responseE.getCantidad()>0) {
//				empresa = mapper.convertValue(responseE.getResultados().get(0),TBussines.class);
//			}
//			
//			TPersonGet filtroV = new TPersonGet();
//			filtroV.setPaginacion(new PaginacionFiltro(1, 1));
//			filtroV.setPersBident(empresa.getPersBident());
//			PaginaResultado<TPerson> responseV = PersonRest.getPerson(filtroV);
//			TPerson vend= new TPerson();
//			if(responseV!=null && responseV.getCantidad()>0) {
//				vend = mapper.convertValue(responseV.getResultados().get(0),TPerson.class);
//			}
			
			Long totalFactura=0l;
			Long totalBoleta=0l;
			Long totalNotaCredito=0l;
			Long totalNotaDebito=0l;
			Long totalRetencion=0l;
			
			/*********************************************************************************************************/
			/*-------------------------------   FIGURA TOTAL DE COMPROBANTES  VOUCHER --------------------------------------*/
			/*********************************************************************************************************/
			TVoucherDashboardGet filtroFacturaTotal = new TVoucherDashboardGet();
			if(tEmployee!=null ) {
				filtroFacturaTotal.setBusiBident(tEmployee.getBusiBident());
			}
			PaginaResultado<TVoucherDashboard> respFacturaTotal = voucherrest.getVoucherDashboard(filtroFacturaTotal,beanDS);
			for (Object objs : respFacturaTotal.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				if(VoucherDashboard.getTipoDoc().equals("01")){
					datoFigComprTotal.put("factura", VoucherDashboard.getTotalComprobantes());	
					model.addObject("totalFactura", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
					totalFactura=VoucherDashboard.getTotalComprobantes();
				}else if(VoucherDashboard.getTipoDoc().equals("03")){
					datoFigComprTotal.put("boleta", VoucherDashboard.getTotalComprobantes());
					model.addObject("totalboleta", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
					totalBoleta=VoucherDashboard.getTotalComprobantes();
//					bolPorc=((VoucherDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);//%
				}else if(VoucherDashboard.getTipoDoc().equals("07")){
					datoFigComprTotal.put("notaCredito", VoucherDashboard.getTotalComprobantes());
					model.addObject("totalnotaCredito", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
					totalNotaCredito=VoucherDashboard.getTotalComprobantes();
//					notcPorc=((VoucherDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);//%
				}else if(VoucherDashboard.getTipoDoc().equals("08")){
					datoFigComprTotal.put("notaDebito", VoucherDashboard.getTotalComprobantes());
					model.addObject("totalnotaDebito", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
					totalNotaDebito=VoucherDashboard.getTotalComprobantes();
//					notdPorc=((VoucherDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);//%
				}else if(VoucherDashboard.getTipoDoc().equals("20")){
					datoFigComprTotal.put("comprobanteRentencion", VoucherDashboard.getTotalComprobantes());
					model.addObject("totalcomprobanteRentencion", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
					totalRetencion=VoucherDashboard.getTotalComprobantes();
//					notrPorc=((VoucherDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);//%
				}else if(VoucherDashboard.getTipoDoc().equals("99")){
					datoFigComprTotal.put("notaVenta", VoucherDashboard.getTotalComprobantes());
					model.addObject("totalnotaVentaV", VoucherDashboard.getTotalComprobantes());
					totalcpe=totalcpe+VoucherDashboard.getTotalComprobantes().intValue();
//					notvPorc=((VoucherDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);//%
				}
			}

			model.addObject("totalcpe", totalcpe);
			model.addObject("NombreVentana", NombreVentana);
			ListFigComprTotal.put("data", datoFigComprTotal);
			Gson gsonLP = new Gson();
			String dataLP = gsonLP.toJson(ListFigComprTotal);
			model.addObject("json", dataLP);
			
			/*********************************************************************************************************/
			/*-------------------------------   FIGURA TOTAL DE COMPROBANTES VENTAS --------------------------------------*/
			/*********************************************************************************************************/
			TSalesDashboardGet filtroNotVentTotal = new TSalesDashboardGet();
			if(tEmployee!=null ) {
				filtroNotVentTotal.setBusiBident(tEmployee.getBusiBident());
			}
			PaginaResultado<TSalesDashboard> respNotVentTotal = ventasrest.getSalesDashboard(filtroNotVentTotal,beanDS);
			for (Object objs : respNotVentTotal.getResultados()) {
				TSalesDashboard SalesDashboard = mapper.convertValue(objs, TSalesDashboard.class);
				if(SalesDashboard.getTipoDoc().equals("99")){
					datoFigComprTotal.put("notaVentaV", SalesDashboard.getTotalComprobantes());
					model.addObject("totalnotaVentaV", SalesDashboard.getTotalComprobantes());
					totalcpe=totalcpe+SalesDashboard.getTotalComprobantes().intValue();
					notvPorc=((SalesDashboard.getTotalComprobantes().doubleValue()/totalcpe)*100);
				}
			}
					

			model.addObject("totalcpe", totalcpe);
			factPorc=((totalFactura.doubleValue()/totalcpe)*100);	
			bolPorc=((totalBoleta.doubleValue()/totalcpe)*100);	
			notcPorc=((totalNotaCredito.doubleValue()/totalcpe)*100);	
			notdPorc=((totalNotaDebito.doubleValue()/totalcpe)*100);	
			notrPorc=((totalRetencion.doubleValue()/totalcpe)*100);	
			model.addObject("factPorc", df.format(factPorc));
			model.addObject("bolPorc", df.format(bolPorc));
			model.addObject("notcPorc", df.format(notcPorc));
			model.addObject("notdPorc", df.format(notdPorc));
			model.addObject("notrPorc", df.format(notrPorc));
			model.addObject("notvPorc", df.format(notvPorc));
		
			ListFigComprTotal.put("data", datoFigComprTotal);
			Gson gsonLV = new Gson();
			String dataLV = gsonLV.toJson(ListFigComprTotal);
			model.addObject("json", dataLV);
			
			/*********************************************************************************************************/
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES ACEPTADOS  -----------------------------------*/
			/*********************************************************************************************************/
			HashMap<String, Object> ListFigComprAcep = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprAcep = new HashMap<String, Object>();
			// factura Acep
			TVoucherDashboardGet filtroCPEAcep = new TVoucherDashboardGet();
			if(tEmployee!=null ) {
				filtroCPEAcep.setBusiBident(tEmployee.getBusiBident());
			}
			filtroCPEAcep.setVoucEstadoCdr("0");
			PaginaResultado<TVoucherDashboard> respCPEAcep = voucherrest.getVoucherDashboard(filtroCPEAcep,beanDS);
			for (Object objs : respCPEAcep.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				if(VoucherDashboard.getTipoDoc().equals("01")){
					datoFigComprAcep.put("factura", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("03")){
					datoFigComprAcep.put("boleta", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("07")){
					datoFigComprAcep.put("notaCredito", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("08")){
					datoFigComprAcep.put("notaDebito", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("20")){
					datoFigComprAcep.put("comprobanteRentencion", VoucherDashboard.getTotalComprobantes());
				}
			}
			ListFigComprAcep.put("data", datoFigComprAcep);
			Gson gsonLPAcep = new Gson();
			String dataLPAcep = gsonLPAcep.toJson(ListFigComprAcep);
			model.addObject("jsonAcep", dataLPAcep);
			
			/*********************************************************************************************************/
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES RECHAZADOS  ----------------------------------*/
			/*********************************************************************************************************/
			HashMap<String, Object> ListFigComprRechaz = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprRechaz = new HashMap<String, Object>();
			// factura Rechaz
			TVoucherDashboardGet filtroCPERechaz = new TVoucherDashboardGet();
			if(tEmployee!=null ) {
				filtroCPERechaz.setBusiBident(tEmployee.getBusiBident());
			}
			filtroCPERechaz.setVoucEstadoCdr("-1");
			PaginaResultado<TVoucherDashboard> respCPERechaz = voucherrest.getVoucherDashboard(filtroCPERechaz,beanDS);
			for (Object objs : respCPERechaz.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				if(VoucherDashboard.getTipoDoc().equals("01")){
					datoFigComprRechaz.put("factura", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("03")){
					datoFigComprRechaz.put("boleta", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("07")){
					datoFigComprRechaz.put("notaCredito", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("08")){
					datoFigComprRechaz.put("notaDebito", VoucherDashboard.getTotalComprobantes());
				}else if(VoucherDashboard.getTipoDoc().equals("20")){
					datoFigComprRechaz.put("comprobanteRentencion", VoucherDashboard.getTotalComprobantes());
				}
			}
			ListFigComprRechaz.put("data", datoFigComprRechaz);
			Gson gsonLPRechaz = new Gson();
			String dataLPRechaz = gsonLPRechaz.toJson(ListFigComprRechaz);
			model.addObject("jsonRechaz", dataLPRechaz);
			
			/*********************************************************************************************************/
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES VOUCHER -----------------------------------*/
			/*********************************************************************************************************/
			TVoucherDashboardGet filtroCPEMeses = new TVoucherDashboardGet();
			Calendar now = Calendar.getInstance();
			int anio=now.get(Calendar.YEAR);
			filtroCPEMeses.setVoucYear(String.valueOf(anio));
			PaginaResultado<TVoucherDashboard> respCPEMeses = voucherrest.getVoucherDashboardMeses(filtroCPEMeses,beanDS);
			/** -- FACTURA --**/
			HashMap<String, Object> ListFigComprFactxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprFactxMes = new HashMap<String, Object>();
			/** --- BOLETA --**/
			HashMap<String, Object> ListFigComprBolxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprBolxMes = new HashMap<String, Object>();
			/** --- NOTA DEBITO --**/
			HashMap<String, Object> ListFigComprNDebxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNDebxMes = new HashMap<String, Object>();
			/** --- NOTA CREDITO --**/
			HashMap<String, Object> ListFigComprNCredxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNCredxMes = new HashMap<String, Object>();
			/** --- COMPROBANTE RETENCION --**/
			HashMap<String, Object> ListFigComprCRetxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprCRetxMes = new HashMap<String, Object>();
			/** --- BUSCA LOS MESES --**/
			/*********************************************************************************************************/
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES VENTAS -----------------------------------*/
			/*********************************************************************************************************/
			TSalesDashboardGet filtroCPEVMeses = new TSalesDashboardGet();
			Calendar now1 = Calendar.getInstance();
			int anio1=now1.get(Calendar.YEAR);
			filtroCPEVMeses.setSaleYear(String.valueOf(anio1));
			PaginaResultado<TSalesDashboard> respCPEVMeses = ventasrest.getSalesDashboardMeses(filtroCPEVMeses,beanDS);
			/** -- NOTA DE VENTA --**/
			HashMap<String, Object> ListFigComprNotVentxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNotVentxMes = new HashMap<String, Object>();
			
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
	
			/*********************************************************************************************************/
			/*----------------------   FIGURA MONTO TOTAL DE COMPROBANTES POR MESES  --------------------------------*/
			/*********************************************************************************************************/
			/** -- NOTA DE VENTAS --**/
			HashMap<String, Object> ListFigComprNotVentMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNotVentMontoxMes = new HashMap<String, Object>();
			/** -- FACTURA --**/
			HashMap<String, Object> ListFigComprFactMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprFactMontoxMes = new HashMap<String, Object>();
			/** --- BOLETA --**/
			HashMap<String, Object> ListFigComprBolMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprBolMontoxMes = new HashMap<String, Object>();
			/** --- NOTA DEBITO --**/
			HashMap<String, Object> ListFigComprNDebMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNDebMontoxMes = new HashMap<String, Object>();
			/** --- NOTA CREDITO --**/
			HashMap<String, Object> ListFigComprNCredMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNCredMontoxMes = new HashMap<String, Object>();
			/** --- COMPROBANTE RETENCION --**/
			HashMap<String, Object> ListFigComprCRetMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprCRetMontoxMes = new HashMap<String, Object>();
			
			for (Object objs : respCPEMeses.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				for (Object catdet : responsescat.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapper.convertValue(catdet, TCatalogueDet.class);
					if(VoucherDashboard.getMeses().equals(procata.getCatdCident())){
						if(VoucherDashboard.getTipoDoc().equals("01")){
							datoFigComprFactxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
							datoFigComprFactMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("03")){
							datoFigComprBolxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
							datoFigComprBolMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("07")){
							datoFigComprNCredxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
							datoFigComprNDebMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("08")){
							datoFigComprNDebxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
							datoFigComprNCredMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("20")){
							datoFigComprCRetxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
							datoFigComprCRetMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
					}
				}
			}
			
			for (Object objsV : respCPEVMeses.getResultados()) {
				TSalesDashboard SalesDashboard = mapper.convertValue(objsV, TSalesDashboard.class);
				for (Object catdet : responsescat.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapper.convertValue(catdet, TCatalogueDet.class);
					if(SalesDashboard.getMeses().equals(procata.getCatdCident())){
						if(SalesDashboard.getTipoDoc().equals("99")){
							datoFigComprNotVentxMes.put(procata.getCatdVdescription().toLowerCase(), SalesDashboard.getTotalComprobantes());
							datoFigComprNotVentMontoxMes.put(procata.getCatdVdescription().toLowerCase(), SalesDashboard.getMontoTotal()==null?0:SalesDashboard.getMontoTotal());
						}
					}
				}
			}
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/
			/** -- NOTA DE VENTA --**/
			ListFigComprNotVentxMes.put("data", datoFigComprNotVentxMes);
			Gson gsonLPNotVentxMes = new Gson();
			String dataLPNotVentxMes = gsonLPNotVentxMes.toJson(ListFigComprNotVentxMes);
			model.addObject("jsonNotVentxMes", dataLPNotVentxMes);
			/** -- FACTURA --**/
			ListFigComprFactxMes.put("data", datoFigComprFactxMes);
			Gson gsonLPFactxMes = new Gson();
			String dataLPFactxMes = gsonLPFactxMes.toJson(ListFigComprFactxMes);
			model.addObject("jsonFactxMes", dataLPFactxMes);
			/** --- BOLETA --**/
			ListFigComprBolxMes.put("data", datoFigComprBolxMes);
			Gson gsonLPBolxMes = new Gson();
			String dataLPBolxMes = gsonLPBolxMes.toJson(ListFigComprBolxMes);
			model.addObject("jsonBolxMes", dataLPBolxMes);
			/** --- NOTA DEBITO --**/
			ListFigComprNDebxMes.put("data", datoFigComprNDebxMes);
			Gson gsonLPNDebxMes = new Gson();
			String dataLPNDebxMes = gsonLPNDebxMes.toJson(ListFigComprNDebxMes);
			model.addObject("jsonNDebxMes", dataLPNDebxMes);
			/** --- NOTA CREDITO --**/
			ListFigComprNCredxMes.put("data", datoFigComprNCredxMes);
			Gson gsonLPNCredxMes = new Gson();
			String dataLPNCredxMes = gsonLPNCredxMes.toJson(ListFigComprNCredxMes);
			model.addObject("jsonNCredxMes", dataLPNCredxMes);
			/** --- COMPROBANTE RETENCION --**/
			ListFigComprCRetxMes.put("data", datoFigComprCRetxMes);
			Gson gsonLPCRetxMes = new Gson();
			String dataLPCRetxMes = gsonLPCRetxMes.toJson(ListFigComprCRetxMes);
			model.addObject("jsonCRetxMes", dataLPCRetxMes);
			/*----------------------   FIGURA MONTO TOTAL DE COMPROBANTES POR MESES  --------------------------------*/
			/** -- NOTA DE VENTA --**/
			ListFigComprNotVentMontoxMes.put("data", datoFigComprNotVentMontoxMes);
			Gson gsonLPNotVentMontoxMes = new Gson();
			String dataLPNotVentMontoxMes = gsonLPNotVentMontoxMes.toJson(ListFigComprNotVentMontoxMes);
			model.addObject("jsonNotVentMontoxMes", dataLPNotVentMontoxMes);
			/** -- FACTURA --**/
			ListFigComprFactMontoxMes.put("data", datoFigComprFactMontoxMes);
			Gson gsonLPFactMontoxMes = new Gson();
			String dataLPFactMontoxMes = gsonLPFactMontoxMes.toJson(ListFigComprFactMontoxMes);
			model.addObject("jsonFactMontoxMes", dataLPFactMontoxMes);
			/** --- BOLETA --**/
			ListFigComprBolMontoxMes.put("data", datoFigComprBolMontoxMes);
			Gson gsonLPBolMontoxMes = new Gson();
			String dataLPBolMontoxMes = gsonLPBolMontoxMes.toJson(ListFigComprBolMontoxMes);
			model.addObject("jsonBolMontoxMes", dataLPBolMontoxMes);
			/** --- NOTA DEBITO --**/
			ListFigComprNDebMontoxMes.put("data", datoFigComprNDebMontoxMes);
			Gson gsonLPNDebMontoxMes = new Gson();
			String dataLPNDebMontoxMes = gsonLPNDebMontoxMes.toJson(ListFigComprNDebMontoxMes);
			model.addObject("jsonNDebMontoxMes", dataLPNDebMontoxMes);
			/** --- NOTA CREDITO --**/
			ListFigComprNCredMontoxMes.put("data", datoFigComprNCredMontoxMes);
			Gson gsonLPNCredMontoxMes = new Gson();
			String dataLPNCredMontoxMes = gsonLPNCredMontoxMes.toJson(ListFigComprNCredMontoxMes);
			model.addObject("jsonNCredMontoxMes", dataLPNCredMontoxMes);
			/** --- COMPROBANTE RETENCION --**/
			ListFigComprCRetMontoxMes.put("data", datoFigComprCRetMontoxMes);
			Gson gsonLPCRetMontoxMes = new Gson();
			String dataLPCRetMontoxMes = gsonLPCRetMontoxMes.toJson(ListFigComprCRetMontoxMes);
			model.addObject("jsonCRetMontoxMes", dataLPCRetMontoxMes);
			
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	public String test1() {
		try {

			//String resultado = facturadorElecRest.enviarFBNCND(docBean);
			//System.out.println("ver Resultado: "+resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	@RequestMapping(value = "/reloadTotalMeses", method = RequestMethod.POST)
	@ResponseBody
	public String reloadTotalMeses(@RequestParam("moneda") String moneda,@RequestParam("anio") String anio, HttpServletRequest request, ModelAndView model,HttpSession ses) {
		JsonObject jReturn = new JsonObject();
		String dataLPFactxMes="";
		String dataLPBolxMes="";
		String dataLPNDebxMes="";
		String dataLPNCredxMes="";
		String dataLPCRetxMes="";  
		try {
			TVoucherDashboardGet filtroCPEMeses = new TVoucherDashboardGet();
			ObjectMapper mapper = new ObjectMapper();
			Calendar now = Calendar.getInstance();
			filtroCPEMeses.setVoucVmoneda(moneda);
			filtroCPEMeses.setVoucYear(anio);
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			PaginaResultado<TVoucherDashboard> respCPEMeses = voucherrest.getVoucherDashboardMeses(filtroCPEMeses,beanDS);
			/** -- FACTURA --**/
			HashMap<String, Object> ListFigComprFactxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprFactxMes = new HashMap<String, Object>();
			/** --- BOLETA --**/
			HashMap<String, Object> ListFigComprBolxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprBolxMes = new HashMap<String, Object>();
			/** --- NOTA DEBITO --**/
			HashMap<String, Object> ListFigComprNDebxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNDebxMes = new HashMap<String, Object>();
			/** --- NOTA CREDITO --**/
			HashMap<String, Object> ListFigComprNCredxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNCredxMes = new HashMap<String, Object>();
			/** --- COMPROBANTE RETENCION --**/
			HashMap<String, Object> ListFigComprCRetxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprCRetxMes = new HashMap<String, Object>();
			/** --- BUSCA LOS MESES --**/
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			for (Object objs : respCPEMeses.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				for (Object catdet : responsescat.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapper.convertValue(catdet, TCatalogueDet.class);
					if(VoucherDashboard.getMeses().equals(procata.getCatdCident())){
						if(VoucherDashboard.getTipoDoc().equals("01")){
							datoFigComprFactxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
						}else if(VoucherDashboard.getTipoDoc().equals("03")){
							datoFigComprBolxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
						}else if(VoucherDashboard.getTipoDoc().equals("07")){
							datoFigComprNCredxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
						}else if(VoucherDashboard.getTipoDoc().equals("08")){
							datoFigComprNDebxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
						}else if(VoucherDashboard.getTipoDoc().equals("20")){
							datoFigComprCRetxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getTotalComprobantes());
						}
					}
				}
			}
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/	
			/** -- FACTURA --**/
			ListFigComprFactxMes.put("data", datoFigComprFactxMes);
			Gson gsonLPFactxMes = new Gson();
			dataLPFactxMes = gsonLPFactxMes.toJson(ListFigComprFactxMes);
			/** --- BOLETA --**/
			ListFigComprBolxMes.put("data", datoFigComprBolxMes);
			Gson gsonLPBolxMes = new Gson();
			dataLPBolxMes = gsonLPBolxMes.toJson(ListFigComprBolxMes);
			/** --- NOTA DEBITO --**/
			ListFigComprNDebxMes.put("data", datoFigComprNDebxMes);
			Gson gsonLPNDebxMes = new Gson();
			dataLPNDebxMes = gsonLPNDebxMes.toJson(ListFigComprNDebxMes);
			/** --- NOTA CREDITO --**/
			ListFigComprNCredxMes.put("data", datoFigComprNCredxMes);
			Gson gsonLPNCredxMes = new Gson();
			dataLPNCredxMes = gsonLPNCredxMes.toJson(ListFigComprNCredxMes);
			/** --- COMPROBANTE RETENCION --**/
			ListFigComprCRetxMes.put("data", datoFigComprCRetxMes);
			Gson gsonLPCRetxMes = new Gson();
			dataLPCRetxMes = gsonLPCRetxMes.toJson(ListFigComprCRetxMes);
		} catch (Exception e) {
			jReturn.addProperty("estado", "2");
			jReturn.addProperty("msg", "Se produjo un error interno en los servicios");
			e.printStackTrace();
		}
		jReturn.addProperty("estado", "1");
		jReturn.addProperty("dataLPFactxMes", dataLPFactxMes);
		jReturn.addProperty("dataLPBolxMes", dataLPBolxMes);
		jReturn.addProperty("dataLPNDebxMes", dataLPNDebxMes);
		jReturn.addProperty("dataLPNCredxMes", dataLPNCredxMes);
		jReturn.addProperty("dataLPCRetxMes", dataLPCRetxMes);
		return new Gson().toJson(jReturn);

	}
	
	@RequestMapping(value = "/reloadTotalMesesV", method = RequestMethod.POST)
	@ResponseBody
	public String reloadTotalMesesV(@RequestParam("moneda") String moneda,@RequestParam("anio") String anio, HttpServletRequest request, ModelAndView model,HttpSession ses) {
		JsonObject jReturn = new JsonObject();
		String dataLPNVentxMes="";   
		try {		
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			TSalesDashboardGet filtroCPEVMeses = new TSalesDashboardGet();
			ObjectMapper mapperV = new ObjectMapper();
			Calendar nowv = Calendar.getInstance();
			filtroCPEVMeses.setsaleTmoneda(moneda);
			filtroCPEVMeses.setSaleYear(anio);
			
			PaginaResultado<TSalesDashboard> respCPEVMeses = ventasrest.getSalesDashboardMeses(filtroCPEVMeses,beanDS);
			/** -- NOTA DE VENTA --**/
			HashMap<String, Object> ListFigComprNotVentxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNotVentxMes = new HashMap<String, Object>();
			/** --- BUSCA LOS MESES --**/
			TCatalogueDetGet filtroscatalogoV = new TCatalogueDetGet();
			filtroscatalogoV.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoV.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescatV = CatalogueRest.getCatalogueDet(filtroscatalogoV,beanDS);
			for (Object objs : respCPEVMeses.getResultados()) {
				TSalesDashboard SalesDashboard = mapperV.convertValue(objs, TSalesDashboard.class);
				for (Object catdet : responsescatV.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapperV.convertValue(catdet, TCatalogueDet.class);
					if(SalesDashboard.getMeses().equals(procata.getCatdCident())){
						if(SalesDashboard.getTipoDoc().equals("99")){
							datoFigComprNotVentxMes.put(procata.getCatdVdescription().toLowerCase(), SalesDashboard.getTotalComprobantes());
					}
				}
			}
		}
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/
			/** -- NOTA DE VENTA --**/
		ListFigComprNotVentxMes.put("data", datoFigComprNotVentxMes);
		Gson gsonLPNotVentxMes = new Gson();
			dataLPNVentxMes = gsonLPNotVentxMes.toJson(ListFigComprNotVentxMes);			
			} catch (Exception e) {
			jReturn.addProperty("estado", "2");
			jReturn.addProperty("msg", "Se produjo un error interno en los servicios");
			e.printStackTrace();
		}
		jReturn.addProperty("estado", "1");
		jReturn.addProperty("dataLPNVentxMes", dataLPNVentxMes);
		return new Gson().toJson(jReturn);

	}
	@RequestMapping(value = "/reloadMontolMeses", method = RequestMethod.POST)
	@ResponseBody
	public String reloadMontolMeses(@RequestParam("moneda") String moneda,@RequestParam("anio") String anio, HttpServletRequest request, ModelAndView model,HttpSession ses) {
		JsonObject jReturn = new JsonObject();
		String dataLPFactMontoxMes="";
		String dataLPBolMontoxMes="";
		String dataLPNDebMontoxMes="";
		String dataLPNCredMontoxMes="";
		String dataLPCRetMontoxMes="";
		String dataLPNVentMontoxMes="";   
		try {
			TVoucherDashboardGet filtroCPEMeses = new TVoucherDashboardGet();
			ObjectMapper mapper = new ObjectMapper();
			Calendar now = Calendar.getInstance();
			filtroCPEMeses.setVoucVmoneda(moneda);
			filtroCPEMeses.setVoucYear(anio);
			
			BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
			
			PaginaResultado<TVoucherDashboard> respCPEMeses = voucherrest.getVoucherDashboardMeses(filtroCPEMeses,beanDS);
			/** -- FACTURA --**/
			HashMap<String, Object> ListFigComprFactMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprFactMontoxMes = new HashMap<String, Object>();
			/** --- BOLETA --**/
			HashMap<String, Object> ListFigComprBolMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprBolMontoxMes = new HashMap<String, Object>();
			/** --- NOTA DEBITO --**/
			HashMap<String, Object> ListFigComprNDebMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNDebMontoxMes = new HashMap<String, Object>();
			/** --- NOTA CREDITO --**/
			HashMap<String, Object> ListFigComprNCredMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNCredMontoxMes = new HashMap<String, Object>();
			/** --- COMPROBANTE RETENCION --**/
			HashMap<String, Object> ListFigComprCRetMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprCRetMontoxMes = new HashMap<String, Object>();
			/** --- BUSCA LOS MESES --**/
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescat = CatalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			for (Object objs : respCPEMeses.getResultados()) {
				TVoucherDashboard VoucherDashboard = mapper.convertValue(objs, TVoucherDashboard.class);
				for (Object catdet : responsescat.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapper.convertValue(catdet, TCatalogueDet.class);
					if(VoucherDashboard.getMeses().equals(procata.getCatdCident())){
						if(VoucherDashboard.getTipoDoc().equals("01")){
							datoFigComprFactMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("03")){
							datoFigComprBolMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("07")){
							datoFigComprNDebMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("08")){
							datoFigComprNCredMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}else if(VoucherDashboard.getTipoDoc().equals("20")){
							datoFigComprCRetMontoxMes.put(procata.getCatdVdescription().toLowerCase(), VoucherDashboard.getMontoTotal()==null?0:VoucherDashboard.getMontoTotal());
						}
					}
				}
			}			
			TSalesDashboardGet filtroCPEVMeses = new TSalesDashboardGet();
			ObjectMapper mapperV = new ObjectMapper();
			Calendar nowV = Calendar.getInstance();
			String monedav;
			 if(moneda.equals("USD")){
				 monedav="2";
				 filtroCPEVMeses.setsaleTmoneda(monedav);
			 }else if(moneda.equals("PEN")){
				 monedav="1";	
				 filtroCPEVMeses.setsaleTmoneda(monedav);
			 }
			filtroCPEVMeses.setSaleYear(anio);		
			PaginaResultado<TSalesDashboard> respCPEVMeses = ventasrest.getSalesDashboardMeses(filtroCPEVMeses,beanDS);
			/** -- NOTA DE VENTA --**/
			HashMap<String, Object> ListFigComprNotVentMontoxMes = new HashMap<String, Object>();
			HashMap<String, Object> datoFigComprNotVentMontoxMes = new HashMap<String, Object>();			
			/** --- BUSCA LOS MESES --**/
			TCatalogueDetGet filtroscatalogoV = new TCatalogueDetGet();
			filtroscatalogoV.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogoV.setCataBident(new Long(19));
			PaginaResultado<TCatalogueDet> responsescatV = CatalogueRest.getCatalogueDet(filtroscatalogoV,beanDS);
			for (Object objs : respCPEVMeses.getResultados()) {
				TSalesDashboard SalesDashboard = mapperV.convertValue(objs, TSalesDashboard.class);
				for (Object catdet : responsescatV.getResultados()) {
					TCatalogueDet procata = new TCatalogueDet();
					procata = mapperV.convertValue(catdet, TCatalogueDet.class);
					if(SalesDashboard.getMeses().equals(procata.getCatdCident())){
						if(SalesDashboard.getTipoDoc().equals("99")){
							datoFigComprNotVentMontoxMes.put(procata.getCatdVdescription().toLowerCase(), SalesDashboard.getMontoTotal()==null?0:SalesDashboard.getMontoTotal());					
					}
				}
			}
			}
			/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/
			/** -- FACTURA --**/
			ListFigComprNotVentMontoxMes.put("data", datoFigComprNotVentMontoxMes);
			Gson gsonLPNotVentMontoxMes = new Gson();
			dataLPNVentMontoxMes = gsonLPNotVentMontoxMes.toJson(ListFigComprNotVentMontoxMes);			
			/** -- FACTURA --**/
			ListFigComprFactMontoxMes.put("data", datoFigComprFactMontoxMes);
			Gson gsonLPFactMontoxMes = new Gson();
			dataLPFactMontoxMes = gsonLPFactMontoxMes.toJson(ListFigComprFactMontoxMes);
			/** --- BOLETA --**/
			ListFigComprBolMontoxMes.put("data", datoFigComprBolMontoxMes);
			Gson gsonLPBolMontoxMes = new Gson();
			dataLPBolMontoxMes = gsonLPBolMontoxMes.toJson(ListFigComprBolMontoxMes);
			/** --- NOTA DEBITO --**/
			ListFigComprNDebMontoxMes.put("data", datoFigComprNDebMontoxMes);
			Gson gsonLPNDebMontoxMes = new Gson();
			dataLPNDebMontoxMes = gsonLPNDebMontoxMes.toJson(ListFigComprNDebMontoxMes);
			/** --- NOTA CREDITO --**/
			ListFigComprNCredMontoxMes.put("data", datoFigComprNCredMontoxMes);
			Gson gsonLPNCredMontoxMes = new Gson();
			dataLPNCredMontoxMes = gsonLPNCredMontoxMes.toJson(ListFigComprNCredMontoxMes);
			/** --- COMPROBANTE RETENCION --**/
			ListFigComprCRetMontoxMes.put("data", datoFigComprCRetMontoxMes);
			Gson gsonLPCRetMontoxMes = new Gson();
			dataLPCRetMontoxMes = gsonLPCRetMontoxMes.toJson(ListFigComprCRetMontoxMes);
		} catch (Exception e) {
			jReturn.addProperty("estado", "2");
			jReturn.addProperty("msg", "Se produjo un error interno en los servicios");
			e.printStackTrace();
		}
		jReturn.addProperty("estado", "1");
		jReturn.addProperty("dataLPNVentMontoxMes", dataLPNVentMontoxMes);
		jReturn.addProperty("dataLPFactMontoxMes", dataLPFactMontoxMes);
		jReturn.addProperty("dataLPBolMontoxMes", dataLPBolMontoxMes);
		jReturn.addProperty("dataLPNDebMontoxMes", dataLPNDebMontoxMes);
		jReturn.addProperty("dataLPNCredMontoxMes", dataLPNCredMontoxMes);
		jReturn.addProperty("dataLPCRetMontoxMes", dataLPCRetMontoxMes);
		return new Gson().toJson(jReturn);

	}

}
