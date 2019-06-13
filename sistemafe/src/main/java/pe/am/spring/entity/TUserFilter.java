package pe.am.spring.entity;

import java.sql.Date;

public class TUserFilter {
	
	String userVuser;
	String nombres;
	String profVdescription;
	String legaBusiname;
	Date userTregistrationDate;
	String estado;
	Long busiBident;
	Long legaBident;
	Long persBident;
	String profVname;
	
	public String getProfVname() {
		return profVname;
	}
	public void setProfVname(String profVname) {
		this.profVname = profVname;
	}
	public Long getPersBident() {
		return persBident;
	}
	public void setPersBident(Long persBident) {
		this.persBident = persBident;
	}
	public String getUserVuser() {
		return userVuser;
	}
	public void setUserVuser(String userVuser) {
		this.userVuser = userVuser;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getProfVdescription() {
		return profVdescription;
	}
	public void setProfVdescription(String profVdescription) {
		this.profVdescription = profVdescription;
	}
	public String getLegaBusiname() {
		return legaBusiname;
	}
	public void setLegaBusiname(String legaBusiname) {
		this.legaBusiname = legaBusiname;
	}
	public Date getUserTregistrationDate() {
		return userTregistrationDate;
	}
	public void setUserTregistrationDate(Date userTregistrationDate) {
		this.userTregistrationDate = userTregistrationDate;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getBusiBident() {
		return busiBident;
	}
	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}
	
	
	public Long getLegaBident() {
		return legaBident;
	}
	public void setLegaBident(Long legaBident) {
		this.legaBident = legaBident;
	}
	@Override
	public String toString() {
		return "TUserFilter [userVuser=" + userVuser + ", nombres=" + nombres + ", profVdescription=" + profVdescription
				+ ", legaBusiname=" + legaBusiname + ", userTregistrationDate=" + userTregistrationDate + ", estado="
				+ estado + ", busiBident=" + busiBident +", legaBident=" + legaBident + "]";
	}
	
	

}
