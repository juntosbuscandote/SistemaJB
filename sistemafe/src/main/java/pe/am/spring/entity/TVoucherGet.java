package pe.am.spring.entity;

import java.math.*;
import java.util.*;



public class TVoucherGet extends TVoucher {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
