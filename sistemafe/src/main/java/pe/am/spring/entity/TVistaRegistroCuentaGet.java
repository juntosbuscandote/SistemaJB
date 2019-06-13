package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

//import javax.validation.*;
//import javax.validation.constraints.*;

//import org.framework.entity.*;
//import org.framework.validation.*;

import com.fasterxml.jackson.annotation.*;

//import io.swagger.annotations.*;


/**
 * <strong>t_sales</strong><br>
 * Tabla de ventas
 */

public class TVistaRegistroCuentaGet extends TVistaRegistroCuenta {

//	  @NotNull
//	  @Valid
	  PaginacionFiltro paginacion;

	  public PaginacionFiltro getPaginacion() {
	    return paginacion;
	  }

	  public void setPaginacion(PaginacionFiltro paginacion) {
	    this.paginacion = paginacion;
	  }
}