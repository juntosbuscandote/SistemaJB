/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author User
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceLogicException extends Exception {
    private static final long serialVersionUID = 4687051713595568575L;
    
    String codigoError;

    List<ErrorObject> errores;

    @Override
    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public List<ErrorObject> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorObject> errores) {
        this.errores = errores;
    }
}
