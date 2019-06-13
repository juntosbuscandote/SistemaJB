 package pe.am.spring.entity;

import java.math.*;
import java.util.*;

public class TBusinessBDFilterGet extends TBusinessBDFilter {

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
