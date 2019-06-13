package pe.am.spring.entity;

import java.util.Date;

public class TUbigeo {

	/**
	 * <strong>ubig_iident bigint NOT NULL</strong>
	 */
	Long ubigIident;

	/**
	 * <strong>ubig_inei character varying NOT NULL</strong>
	 */
	String ubigInei;

	/**
	 * <strong>ubig_depart character varying</strong>
	 */
	String ubigDepart;

	/**
	 * <strong>ubig_provinc character varying</strong>
	 */
	String ubigProvinc;

	/**
	 * <strong>ubig_distrit character varying</strong>
	 */
	String ubigDistrit;

	/**
	 * <strong>audit_vuser character varying NOT NULL</strong>
	 */
	String auditVuser;

	/**
	 * <strong>audit_vobs character varying</strong>
	 */
	String auditVobs;

	/**
	 * <strong>audit_dfecre timestamp without time zone NOT NULL</strong>
	 */
	Date auditDfecre;

	/**
	 * <strong>audit_vipad character varying NOT NULL</strong>
	 */
	String auditVipad;

	/**
	 * <strong>audit_dfecope timestamp without time zone</strong>
	 */
	Date auditDfecope;

	/**
	 * <strong>ubig_iident bigint NOT NULL</strong>
	 */
	public void setUbigIident(Long ubigIident) {
		this.ubigIident = ubigIident;
	}

	/**
	 * <strong>ubig_iident bigint NOT NULL</strong>
	 */
	public Long getUbigIident() {
		return ubigIident;
	}

	/**
	 * <strong>ubig_inei character varying NOT NULL</strong>
	 */
	public void setUbigInei(String ubigInei) {
		this.ubigInei = ubigInei;
	}

	/**
	 * <strong>ubig_inei character varying NOT NULL</strong>
	 */
	public String getUbigInei() {
		return ubigInei;
	}

	/**
	 * <strong>ubig_depart character varying</strong>
	 */
	public void setUbigDepart(String ubigDepart) {
		this.ubigDepart = ubigDepart;
	}

	/**
	 * <strong>ubig_depart character varying</strong>
	 */
	public String getUbigDepart() {
		return ubigDepart;
	}

	/**
	 * <strong>ubig_provinc character varying</strong>
	 */
	public void setUbigProvinc(String ubigProvinc) {
		this.ubigProvinc = ubigProvinc;
	}

	/**
	 * <strong>ubig_provinc character varying</strong>
	 */
	public String getUbigProvinc() {
		return ubigProvinc;
	}

	/**
	 * <strong>ubig_distrit character varying</strong>
	 */
	public void setUbigDistrit(String ubigDistrit) {
		this.ubigDistrit = ubigDistrit;
	}

	/**
	 * <strong>ubig_distrit character varying</strong>
	 */
	public String getUbigDistrit() {
		return ubigDistrit;
	}

	/**
	 * <strong>audit_vuser character varying NOT NULL</strong>
	 */
	public void setAuditVuser(String auditVuser) {
		this.auditVuser = auditVuser;
	}

	/**
	 * <strong>audit_vuser character varying NOT NULL</strong>
	 */
	public String getAuditVuser() {
		return auditVuser;
	}

	/**
	 * <strong>audit_vobs character varying</strong>
	 */
	public void setAuditVobs(String auditVobs) {
		this.auditVobs = auditVobs;
	}

	/**
	 * <strong>audit_vobs character varying</strong>
	 */
	public String getAuditVobs() {
		return auditVobs;
	}

	/**
	 * <strong>audit_dfecre timestamp without time zone NOT NULL</strong>
	 */
	public void setAuditDfecre(Date auditDfecre) {
		this.auditDfecre = auditDfecre;
	}

	/**
	 * <strong>audit_dfecre timestamp without time zone NOT NULL</strong>
	 */
	public Date getAuditDfecre() {
		return auditDfecre;
	}

	/**
	 * <strong>audit_vipad character varying NOT NULL</strong>
	 */
	public void setAuditVipad(String auditVipad) {
		this.auditVipad = auditVipad;
	}

	/**
	 * <strong>audit_vipad character varying NOT NULL</strong>
	 */
	public String getAuditVipad() {
		return auditVipad;
	}

	/**
	 * <strong>audit_dfecope timestamp without time zone</strong>
	 */
	public void setAuditDfecope(Date auditDfecope) {
		this.auditDfecope = auditDfecope;
	}

	/**
	 * <strong>audit_dfecope timestamp without time zone</strong>
	 */
	public Date getAuditDfecope() {
		return auditDfecope;
	}
}