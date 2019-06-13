package pe.am.spring.entity;

import java.math.*;
import java.util.*;

//import javax.validation.*;
//import javax.validation.constraints.*;
//
//import org.framework.validation.*;
//
//import io.swagger.annotations.*;


public class TClientEndPersonGet extends TClientEndPerson {

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
