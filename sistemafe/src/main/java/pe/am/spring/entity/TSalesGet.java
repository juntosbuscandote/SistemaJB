package pe.am.spring.entity;

import java.math.*;
import java.util.*;


/**
 * <strong>t_sales</strong><br>
 * Tabla de ventas
 */
public class TSalesGet extends TSales {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
