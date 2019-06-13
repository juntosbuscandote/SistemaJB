package pe.am.spring.entity;

/**
 * <strong>t_business_group</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TBusinessGroupGet extends TBusinessGroup {

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
