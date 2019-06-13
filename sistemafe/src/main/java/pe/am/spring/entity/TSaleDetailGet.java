package pe.am.spring.entity;


/**
 * <strong>t_sale_detail</strong><br>
 * Tabla de detalle de ventas
 */
public class TSaleDetailGet extends TSaleDetail {

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
