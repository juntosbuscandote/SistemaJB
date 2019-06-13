package pe.am.spring.entity;

import java.math.*;
import java.util.*;

/**
 * <strong>t_catalogue_det</strong><br>
 * Tabla 23 detalle de catalogo
 */
public class TCatalogueDetGet extends TCatalogueDet {

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
