package pe.am.spring.entity;

import java.math.*;
import java.util.*;

//import javax.validation.*;
//import javax.validation.constraints.*;
//
//import org.framework.entity.*;
//import org.framework.validation.*;
//
//import io.swagger.annotations.*;

/**
 * <strong>t_series</strong><br>
 * Tabla de serie de ventas
 */
public class TSeriesFilterGet extends TSeriesFilter {

//  @NotNull
//  @Valid
  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
