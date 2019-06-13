/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.service;

import pe.am.spring.dao.ContactDAO;
import pe.am.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactDAO contactDAO;
    
    public Contact validarOperador(String usuario,String clave){
		Contact contact=null;
		contact= contactDAO.validarOperador(usuario,clave);
		if(contact==null){
			throw new RuntimeException("Usuario y/o clave son incorrectos.");
		}
		
		return contact;
	}

}
