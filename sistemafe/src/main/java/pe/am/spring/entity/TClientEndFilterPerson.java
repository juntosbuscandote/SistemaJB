package pe.am.spring.entity;
//import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

public class TClientEndFilterPerson {
	
//	@Min(1)
	Long persBident;

//	@Min(1)
	Long lega_bident;
	
//	@Min(1)
	Long natu_bident;
	
//	@Min(1)
	String persVdoctype;

//	@Size(max = 5)
	String catd_vshortname;

//	@Size(max = 15)
	String pers_vnumdoc;
	
//	@Min(1)
	String perstype;
	
//	@Size(max = 200)
	String nombre;
	
//	@Size(max = 15)
	String phonVphone;
	
//	@Min(1)
	Long persBcodcountry;

//	@Size(max = 6)
	String persVubigeo;
//
//	@Size(max = 250)
	String direccionUbigeoPais;

//	@Size(max = 50)
	String mailVmail;

//	@Min(1)
	Long clieBident;

//	@Size(max = 1)
	String estado;

//	@Size(max = 2)C
	String vretencion;

//	@Size(max = 2)
	String vpercepcion;

//	@Size(max = 2)
	String vcountribuyente;

//	@Size(max = 2)
	String vconsufinal;

//	@Size(max = 2)
	String vextranjero;
	
//	@Min(1)
	Long busiBident;
    
   
	
	  public Long getPersBident() {
		return persBident;
	}



	public void setPersBident(Long persBident) {
		this.persBident = persBident;
	}



	public Long getLega_bident() {
		return lega_bident;
	}



	public void setLega_bident(Long lega_bident) {
		this.lega_bident = lega_bident;
	}



	public Long getNatu_bident() {
		return natu_bident;
	}



	public void setNatu_bident(Long natu_bident) {
		this.natu_bident = natu_bident;
	}



	public String getPersVdoctype() {
		return persVdoctype;
	}



	public void setPersVdoctype(String persVdoctype) {
		this.persVdoctype = persVdoctype;
	}



	public String getCatd_vshortname() {
		return catd_vshortname;
	}



	public void setCatd_vshortname(String catd_vshortname) {
		this.catd_vshortname = catd_vshortname;
	}



	public String getPers_vnumdoc() {
		return pers_vnumdoc;
	}



	public void setPers_vnumdoc(String pers_vnumdoc) {
		this.pers_vnumdoc = pers_vnumdoc;
	}



	public String getPerstype() {
		return perstype;
	}



	public void setPerstype(String perstype) {
		this.perstype = perstype;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPhonVphone() {
		return phonVphone;
	}



	public void setPhonVphone(String phonVphone) {
		this.phonVphone = phonVphone;
	}



	public Long getPersBcodcountry() {
		return persBcodcountry;
	}



	public void setPersBcodcountry(Long persBcodcountry) {
		this.persBcodcountry = persBcodcountry;
	}



	public String getPersVubigeo() {
		return persVubigeo;
	}



	public void setPersVubigeo(String persVubigeo) {
		this.persVubigeo = persVubigeo;
	}



	public String getDireccionUbigeoPais() {
		return direccionUbigeoPais;
	}



	public void setDireccionUbigeoPais(String direccionUbigeoPais) {
		this.direccionUbigeoPais = direccionUbigeoPais;
	}



	public String getMailVmail() {
		return mailVmail;
	}



	public void setMailVmail(String mailVmail) {
		this.mailVmail = mailVmail;
	}



	public Long getClieBident() {
		return clieBident;
	}



	public void setClieBident(Long clieBident) {
		this.clieBident = clieBident;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getVretencion() {
		return vretencion;
	}



	public void setVretencion(String vretencion) {
		this.vretencion = vretencion;
	}



	public String getVpercepcion() {
		return vpercepcion;
	}



	public void setVpercepcion(String vpercepcion) {
		this.vpercepcion = vpercepcion;
	}



	public String getVcountribuyente() {
		return vcountribuyente;
	}



	public void setVcountribuyente(String vcountribuyente) {
		this.vcountribuyente = vcountribuyente;
	}



	public String getVconsufinal() {
		return vconsufinal;
	}



	public void setVconsufinal(String vconsufinal) {
		this.vconsufinal = vconsufinal;
	}



	public String getVextranjero() {
		return vextranjero;
	}



	public void setVextranjero(String vextranjero) {
		this.vextranjero = vextranjero;
	}



	public Long getBusiBident() {
		return busiBident;
	}



	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}



	@Override
		public String toString() {
			return "TClientEndFilter [pers_vnumdoc=" + pers_vnumdoc + ", busiBident=" + busiBident + ", nombre=" + nombre
					+ ", phonVphone=" + phonVphone + ", estado=" + estado  + "]";
		}


	
}
