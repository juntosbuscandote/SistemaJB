package pe.am.spring.entity;

public class PersonaUpd {
	TNaturalPersonPut tNaturalPersonPut;
	TLegalPersonPut tLegalPersonPut;
	TPersonPut tPersonPut;
	TEmailPersonPut TEmailPersonPutLista;
	TAddressPersonPut tAddressPersonLista;
	TPhonePersonPut tPhonePersonLista;

	public TNaturalPersonPut gettNaturalPersonPut() {
		return tNaturalPersonPut;
	}

	public void settNaturalPersonPut(TNaturalPersonPut tNaturalPersonPut) {
		this.tNaturalPersonPut = tNaturalPersonPut;
	}

	public TLegalPersonPut gettLegalPersonPut() {
		return tLegalPersonPut;
	}

	public void settLegalPersonPut(TLegalPersonPut tLegalPersonPut) {
		this.tLegalPersonPut = tLegalPersonPut;
	}

	public TPersonPut gettPersonPut() {
		return tPersonPut;
	}

	public void settPersonPut(TPersonPut tPersonPut) {
		this.tPersonPut = tPersonPut;
	}

	public TEmailPersonPut getTEmailPersonPutLista() {
		return TEmailPersonPutLista;
	}

	public void setTEmailPersonPutLista(TEmailPersonPut tEmailPersonPutLista) {
		TEmailPersonPutLista = tEmailPersonPutLista;
	}

	public TAddressPersonPut gettAddressPersonLista() {
		return tAddressPersonLista;
	}

	public void settAddressPersonLista(TAddressPersonPut tAddressPersonLista) {
		this.tAddressPersonLista = tAddressPersonLista;
	}

	public TPhonePersonPut gettPhonePersonLista() {
		return tPhonePersonLista;
	}

	public void settPhonePersonLista(TPhonePersonPut tPhonePersonLista) {
		this.tPhonePersonLista = tPhonePersonLista;
	}
}
