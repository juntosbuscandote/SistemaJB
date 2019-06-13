package pe.am.spring.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.FilterPersona;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TCatalogueDet;
import pe.am.spring.entity.TCatalogueDetGet;
import pe.am.spring.entity.TCountry;
import pe.am.spring.entity.TCountryGet;
import pe.am.spring.entity.TDni;
import pe.am.spring.entity.TSunat;
import pe.am.spring.entity.TUbigeo;
import pe.am.spring.entity.TUbigeoGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.CatalogueRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.rest.SunatRest;

@Service
public class PersonaService {
	protected static Logger logger = Logger.getLogger(PersonaService.class);
	@Autowired
	CatalogueRest catalogueRest;
	
	@Autowired
	PersonRest personrest;
	
	@Autowired
	SunatRest sunatRest;

	public ModelAndView cargarPersona(ModelAndView model,BeanDS beanDS) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// obtener ubigeo
			TUbigeoGet filtroUbigeo = new TUbigeoGet();
			filtroUbigeo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			PaginaResultado<TUbigeo> respUbigeo = catalogueRest.getUbigeo(filtroUbigeo,beanDS);
			List<TUbigeo> lstUbigeo = new ArrayList<TUbigeo>();
			for (Object tUbigeo : respUbigeo.getResultados()) {
				TUbigeo ubigeo = mapper.convertValue(tUbigeo, TUbigeo.class);
				lstUbigeo.add(ubigeo);
			}
			model.addObject("lstUbigeo", lstUbigeo);
			// obtener pais
			TCountryGet filtroCountry = new TCountryGet();
			filtroCountry.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroCountry.setCounBstate(true);
			PaginaResultado<TCountry> respCountry = catalogueRest.getCountry(filtroCountry,beanDS);
			List<TCountry> lstCountry = new ArrayList<TCountry>();
			for (Object tCountry : respCountry.getResultados()) {
				TCountry country = mapper.convertValue(tCountry, TCountry.class);
				lstCountry.add(country);
			}
			model.addObject("lstCountry", lstCountry);
			// obtener tipo de documento
			TCatalogueDetGet filtroscatalogo = new TCatalogueDetGet();
			filtroscatalogo.setPaginacion(new PaginacionFiltro(1, Integer.MAX_VALUE));
			filtroscatalogo.setCataBident(new Long(4));
			PaginaResultado<TCatalogueDet> responsescat = catalogueRest.getCatalogueDet(filtroscatalogo,beanDS);
			TCatalogueDet procata = new TCatalogueDet();
			List<TCatalogueDet> lstCatDoc = new ArrayList<>();
			for (Object catdet : responsescat.getResultados()) {
				procata = mapper.convertValue(catdet, TCatalogueDet.class);
				lstCatDoc.add(procata);
			}
			model.addObject("listaCatDet", lstCatDoc);

		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
		}
		return model;
	}

	public TDni consultarDni(String dni,BeanDS beanDS) {
		ObjectMapper mapper = new ObjectMapper();
		TDni tDni=new TDni();
		tDni.setDni(dni);
		try {
			tDni=mapper.convertValue(sunatRest.getDni(tDni,beanDS), TDni.class);
			if(tDni.getNombre()==null){
				tDni=null;
			}
		} catch (Exception e) {
			tDni=null;
			e.printStackTrace();
		} 
		return tDni;
	}
	
	public TSunat consultarsunat(String ruc,BeanDS beanDS) {
		ObjectMapper mapper = new ObjectMapper();
		TSunat tSunat=new TSunat();
		tSunat.setRuc(ruc);
		try {
			tSunat=mapper.convertValue(sunatRest.getUser(tSunat,beanDS), TSunat.class);
			if(tSunat.getNombre()==null){
				tSunat=null;
			}
		} catch (Exception e) {
			tSunat=null;
			e.printStackTrace();
		} 
		return tSunat;
	}
	
	public JsonObject verPersona(Long idPerson,BeanDS beanDS) {
		JsonObject robject = new JsonObject();
		ObjectMapper mapper = new ObjectMapper();
		try {
			FilterPersona filtro=new FilterPersona();
			filtro.setPersBident(idPerson);
			PaginaResultado<FilterPersona> lstFilterPersona= personrest.getPerson(filtro,beanDS);
			FilterPersona filterPersona=mapper.convertValue(lstFilterPersona.getResultados().get(0), FilterPersona.class);
			String tipoPersonDomiciliado="";
			if(filterPersona.getTipopersona().equals("N")){
				robject.addProperty("naturalName", filterPersona.getNombre());
				robject.addProperty("naturalLastnamefather", filterPersona.getApetpat());
				robject.addProperty("naturalLastnameMother", filterPersona.getApetmat());
				robject.addProperty("naturalTradename", filterPersona.getNomcomercial());
				if(filterPersona.getDomiciled()!=null) {
					tipoPersonDomiciliado=filterPersona.getDomiciled().equals("D")?"Domiciliado":"No Domiciliado";
				}
				robject.addProperty("naturalTipoPerson", tipoPersonDomiciliado);
				robject.addProperty("naturalMail", filterPersona.getEmail());
				robject.addProperty("naturalPhone", filterPersona.getTelefono());
				robject.addProperty("naturalPais", filterPersona.getDescrpais());
				robject.addProperty("naturalLocalidad", filterPersona.getLocalidad());
				robject.addProperty("naturalAddress", filterPersona.getDireccion());
			}else if(filterPersona.getTipopersona().equals("L")){
				if(filterPersona.getDomiciled()!=null) {
					tipoPersonDomiciliado=filterPersona.getDomiciled().equals("D")?"Domiciliado":"No Domiciliado";
				}
				robject.addProperty("legalBusiname", filterPersona.getRazonsocial());
				robject.addProperty("legalTradename", filterPersona.getNomcomercial());
				robject.addProperty("legalPhone", filterPersona.getTelefono());
				robject.addProperty("legalPais", filterPersona.getDescrpais());
				robject.addProperty("legalLocalidad", filterPersona.getLocalidad());
				robject.addProperty("legalEmail", filterPersona.getEmail());
				robject.addProperty("legalAddress", filterPersona.getDireccion());
				robject.addProperty("legalTipoPerson", tipoPersonDomiciliado);
			}
			robject.addProperty("persDoctype",filterPersona.getTipodoc());
			robject.addProperty("persNumdoc",filterPersona.getNumdoc());
			robject.addProperty("tipoPerson",filterPersona.getTipopersona());
		}catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
		}
		return robject;
	}
	
	public ModelAndView cargarPersonaEdit(ModelAndView model,Long idPerson,BeanDS beanDS) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			FilterPersona filtro=new FilterPersona();
			filtro.setPersBident(idPerson);
			PaginaResultado<FilterPersona> lstFilterPersona= personrest.getPerson(filtro,beanDS);
			if(lstFilterPersona.getCantidad()>0){
				FilterPersona filterPersona=mapper.convertValue(lstFilterPersona.getResultados().get(0), FilterPersona.class);
				if(filterPersona.getTipopersona().equals("N")){
					model.addObject("naturalName", filterPersona.getNombre());
					model.addObject("naturalLastnamefather", filterPersona.getApetpat());
					model.addObject("naturalLastnameMother", filterPersona.getApetmat());
					model.addObject("naturalTradename", filterPersona.getNomcomercial());
					model.addObject("naturalMail", filterPersona.getEmail());
					model.addObject("naturalPhone", filterPersona.getTelefono());
					model.addObject("naturalAddress", filterPersona.getDireccion());
				}else if(filterPersona.getTipopersona().equals("L")){
					model.addObject("legalBusiname", filterPersona.getRazonsocial());
					model.addObject("legalTradename", filterPersona.getNomcomercial());
					model.addObject("legalEmail", filterPersona.getEmail());
					model.addObject("legalPhone", filterPersona.getTelefono());
					model.addObject("legalAddress", filterPersona.getDireccion());
				}
				model.addObject("numdoc",filterPersona.getNumdoc());
				model.addObject("idpais",filterPersona.getIdpais().toString());
				model.addObject("idubigeo", filterPersona.getIdubigeo());
				model.addObject("tipoPerson", filterPersona.getTipopersona());
				model.addObject("idPerson", filterPersona.getPersBident());
				model.addObject("idtipodoc", filterPersona.getIdtipodoc());
				model.addObject("domiciled", filterPersona.getDomiciled());
				model.addObject("proccess","modif");
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			e.printStackTrace();
		}
		return model;
	}

}
