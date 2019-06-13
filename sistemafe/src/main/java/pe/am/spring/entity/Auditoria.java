package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonInclude;

public class Auditoria {

	/**
	 * audit_vreason character varying,
	 */
	String motivoTransaccion;

	/**
	 * audit_vipad character varying NOT NULL,
	 */
	String ipCliente;

	/**
	 * audit_vtymo character varying NOT NULL,
	 */
	String tipoMovimiento;

	/**
	 * audit_dfecre timestamp without time zone NOT NULL,
	 */
	Date fechaRegistro;

	/**
	 * audit_dfecope timestamp without time zone,
	 */
	Date fechaAnulacion;

	/**
	 * audit_vuser character varying NOT NULL,
	 */
	String usuario;

	/**
	 * audit_vobs character varying,
	 */
	String observacion;

	/**
	 * audit_vreason character varying,
	 */
	public String getMotivoTransaccion() {
		return motivoTransaccion;
	}

	/**
	 * audit_vreason character varying,
	 */
	public void setMotivoTransaccion(String motivoTransaccion) {
		this.motivoTransaccion = motivoTransaccion;
	}

	/**
	 * audit_vipad character varying NOT NULL,
	 */
	public String getIpCliente() {
		return ipCliente;
	}

	/**
	 * audit_vipad character varying NOT NULL,
	 */
	public void setIpCliente(String ipcliente) {
		this.ipCliente = ipcliente;
	}

	/**
	 * audit_vtymo character varying NOT NULL,
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * audit_vtymo character varying NOT NULL,
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * audit_dfecre timestamp without time zone NOT NULL,
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * audit_dfecre timestamp without time zone NOT NULL,
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * audit_dfecope timestamp without time zone,
	 */
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	/**
	 * audit_dfecope timestamp without time zone,
	 */
	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	/**
	 * audit_vuser character varying NOT NULL,
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * audit_vuser character varying NOT NULL,
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * audit_vobs character varying,
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * audit_vobs character varying,
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return reflectionToString(this, SHORT_PREFIX_STYLE);
	}
}
