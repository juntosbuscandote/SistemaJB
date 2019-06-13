package pe.am.spring.entity;

public class TNoteCredDeb {
	
	Long noteBident;
	Long tBvoucOrigin;
	Long tBvoucDestiny;
	String tCtypePurchaseSale;
	
	
	public Long getNoteBident() {
		return noteBident;
	}
	public void setNoteBident(Long noteBident) {
		this.noteBident = noteBident;
	}
	public Long gettBvoucOrigin() {
		return tBvoucOrigin;
	}
	public void settBvoucOrigin(Long tBvoucOrigin) {
		this.tBvoucOrigin = tBvoucOrigin;
	}
	public Long gettBvoucDestiny() {
		return tBvoucDestiny;
	}
	public void settBvoucDestiny(Long tBvoucDestiny) {
		this.tBvoucDestiny = tBvoucDestiny;
	}
	public String gettCtypePurchaseSale() {
		return tCtypePurchaseSale;
	}
	public void settCtypePurchaseSale(String tCtypePurchaseSale) {
		this.tCtypePurchaseSale = tCtypePurchaseSale;
	}
	
	

}
