package pe.am.spring.entity;


/**
 * <strong>t_series</strong><br>
 * Tabla de serie de ventas
 */
public class TSeriesGet extends TSeries {

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
