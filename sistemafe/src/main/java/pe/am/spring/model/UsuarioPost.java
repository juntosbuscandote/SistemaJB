/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.model;

/**
 *
 * @author User
 */
public class UsuarioPost extends Usuario{

    private String nomUsuCrea;
    
    public UsuarioPost() {
    }

    public String getNomUsuCrea() {
        return nomUsuCrea;
    }

    public void setNomUsuCrea(String nomUsuCrea) {
        this.nomUsuCrea = nomUsuCrea;
    }
    
}
