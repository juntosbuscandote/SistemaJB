package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class ResponseFE extends Response{

	private String tipocompr;
	private String serieCompr;
	private String nroCompr;
	private String urlCompr;
	private String estadoSunat;
	private String descrSunat;
	

	public ResponseFE() {
		super();
	}

	public String getTipocompr() {
		return tipocompr;
	}

	public void setTipocompr(String tipocompr) {
		this.tipocompr = tipocompr;
	}

	public String getSerieCompr() {
		return serieCompr;
	}

	public void setSerieCompr(String serieCompr) {
		this.serieCompr = serieCompr;
	}

	public String getNroCompr() {
		return nroCompr;
	}

	public void setNroCompr(String nroCompr) {
		this.nroCompr = nroCompr;
	}

	public String getUrlCompr() {
		return urlCompr;
	}

	public void setUrlCompr(String urlCompr) {
		this.urlCompr = urlCompr;
	}

	public String getEstadoSunat() {
		return estadoSunat;
	}

	public void setEstadoSunat(String estadoSunat) {
		this.estadoSunat = estadoSunat;
	}

	public String getDescrSunat() {
		return descrSunat;
	}

	public void setDescrSunat(String descrSunat) {
		this.descrSunat = descrSunat;
	}

	public String getCodRpta() {
		return codRpta;
	}

	public void setCodRpta(String codRpta) {
		this.codRpta = codRpta;
	}

	public String getMsjRpta() {
		return msjRpta;
	}

	public void setMsjRpta(String msjRpta) {
		this.msjRpta = msjRpta;
	}

	@Override
	public String toString() {
		return reflectionToString(this, SHORT_PREFIX_STYLE);
	}

}
