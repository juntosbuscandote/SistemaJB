package pe.am.spring.entity;

public class Response {

	protected String codRpta;
	protected String msjRpta;

	public Response() {
		super();
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

}
