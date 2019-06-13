package pe.am.spring.dao;

import java.util.List;

import pe.am.spring.model.Contact;

public interface ContactDAO {
	
	public void saveOrUpdate(Contact contact);
	
	public void delete(int contactId);
	
	public Contact get(int contactId);
	
	public List<Contact> list();
        
        public Contact validarOperador(String email,String password);
}
