package pe.am.spring.entity;

import java.util.List;

public class PersonaIns {
	TNaturalPersonPost tNaturalPerson;
	TLegalPersonPost tLegalPerson;
	TPersonPost tPerson;
	List<TEmailPersonPost> tEmailPersonLista;
	List<TAddressPersonPost> tAddressPersonLista;
	List<TPhonePersonPost> tPhonePersonLista;

	public TNaturalPersonPost gettNaturalPerson() {
		return tNaturalPerson;
	}

	public void settNaturalPerson(TNaturalPersonPost tNaturalPerson) {
		this.tNaturalPerson = tNaturalPerson;
	}

	public TLegalPersonPost gettLegalPerson() {
		return tLegalPerson;
	}

	public void settLegalPerson(TLegalPersonPost tLegalPerson) {
		this.tLegalPerson = tLegalPerson;
	}

	public TPersonPost gettPerson() {
		return tPerson;
	}

	public void settPerson(TPersonPost tPerson) {
		this.tPerson = tPerson;
	}

	public List<TEmailPersonPost> gettEmailPersonLista() {
		return tEmailPersonLista;
	}

	public void settEmailPersonLista(List<TEmailPersonPost> tEmailPersonLista) {
		this.tEmailPersonLista = tEmailPersonLista;
	}

	public List<TAddressPersonPost> gettAddressPersonLista() {
		return tAddressPersonLista;
	}

	public void settAddressPersonLista(List<TAddressPersonPost> tAddressPersonLista) {
		this.tAddressPersonLista = tAddressPersonLista;
	}

	public List<TPhonePersonPost> gettPhonePersonLista() {
		return tPhonePersonLista;
	}

	public void settPhonePersonLista(List<TPhonePersonPost> tPhonePersonLista) {
		this.tPhonePersonLista = tPhonePersonLista;
	}
}
