package pe.am.spring.entity;

public class TBussinesFilter {
	String persVnumdoc;
	String legaBusiname;
	String addrVaddress;
	String mailVemail;
	String phonVphone;
	String estado;
	Long busibident; // mtoledo filtro id empresa

	public String getPersVnumdoc() {
		return persVnumdoc;
	}

	public void setPersVnumdoc(String persVnumdoc) {
		this.persVnumdoc = persVnumdoc;
	}

	public String getLegaBusiname() {
		return legaBusiname;
	}

	public void setLegaBusiname(String legaBusiname) {
		this.legaBusiname = legaBusiname;
	}

	public String getAddrVaddress() {
		return addrVaddress;
	}

	public void setAddrVaddress(String addrVaddress) {
		this.addrVaddress = addrVaddress;
	}

	public String getMailVemail() {
		return mailVemail;
	}

	public void setMailVemail(String mailVemail) {
		this.mailVemail = mailVemail;
	}

	public String getPhonVphone() {
		return phonVphone;
	}

	public void setPhonVphone(String phonVphone) {
		this.phonVphone = phonVphone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getBusibident() {
		return busibident;
	}

	public void setBusibident(Long busibident) {
		this.busibident = busibident;
	}

}
