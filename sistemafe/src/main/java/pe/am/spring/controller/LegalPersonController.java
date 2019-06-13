package pe.am.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.TBusiness;
import pe.am.spring.entity.TBusinessPost;
import pe.am.spring.entity.TLegalPerson;
import pe.am.spring.entity.TLegalPersonGet;
import pe.am.spring.entity.TLegalPersonPost;
import pe.am.spring.entity.TPerson;
import pe.am.spring.entity.TPersonGet;
import pe.am.spring.entity.TPersonPost;
import pe.am.spring.entity.TPersonPut;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.LegalPersonRest;
import pe.am.spring.rest.PersonRest;
import pe.am.spring.util.Constantes;
import pe.am.spring.util.Util;

public class LegalPersonController {
	@Autowired
	LegalPersonRest legalpersonrest;

	@RequestMapping(value = "/legalperson")
	public ModelAndView listContactGrilla(ModelAndView model

			) 
			throws IOException {
		
//		properties para microservicio de persona
		String util=Util.getHostPerson();
		System.out.println(util);
		
		model.setViewName("/");
		try {
			TLegalPersonGet filtro = new TLegalPersonGet();
//			filtro.setPersBident("pers_bident");
//			filtro.setLegaBident("lega_bident");
//			filtro.setNatuBident("natu_bident");
//			filtro.setPersVtradename("pers_vtradename");
//			filtro.setPersVdoctype("pers_vdoctype");
//			filtro.setPersVnumdoc("pers_vnumdoc");
//			filtro.setPersCperstype("pers_cperstype");
//			filtro.setPersVubigeo("pers_vubigeo");
//			filtro.setPersBcodcountry("pers_bcodcountry");
//			filtro.setPersTregistrationDate("");
//			filtro.setPersTdateUpdate("pers_tdate_Update");
//			filtro.setPersBuserModify(persBuserModify);
//			filtro.setPaginacion(new PaginacionFiltro(1, 1000));
//			PaginaResultado<TPerson> response = personrest.getPerson(filtro);
//			model.addObject("DtoPerson", response.getResultados());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/InsertarLegalPerson", method = RequestMethod.POST)
	@ResponseBody
	public String InsertarLegalPerson(
		HttpSession ses, HttpServletRequest rq) {
		//probando cambios
		String lega_businame=rq.getParameter("lega_businame");
		List<TLegalPersonPost> lstTLegalPersonPost = new ArrayList<>();
		TLegalPersonPost TLegalPerson = new TLegalPersonPost();
		TLegalPerson.setLegaBusiname(lega_businame);
		lstTLegalPersonPost.add(TLegalPerson);
		BeanDS beanDS=(BeanDS) ses.getAttribute(Constantes.SESION_USUARIO_DETAIL);
		try {
			List<TLegalPerson> lstLegalPerson = legalpersonrest.postLegalPerson(lstTLegalPersonPost,beanDS);
			System.out.println(lstLegalPerson.size());
		} catch (Exception ex) {
			Logger.getLogger(LegalPersonController.class.getName()).log(Level.SEVERE, null, ex);
			JsonObject robject = new JsonObject();
	  		robject.addProperty("msg", "error");
	      	return new Gson().toJson(robject);
		}
		JsonObject robject = new JsonObject();
  		robject.addProperty("msg", "ok");
      	return new Gson().toJson(robject);
	}
	
	

}
	



