/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.entity;

/**
 *
 * @author User
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorObject {
    final String tipoObjecto;
    final String valor;

    public ErrorObject(String tipoObjecto, String valor) {
        this.tipoObjecto = tipoObjecto;
        this.valor = valor;
    }

    public String getTipoObjecto() {
        return tipoObjecto;
    }

    public String getValor() {
        return valor;
    }
}
