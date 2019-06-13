package pe.am.spring.entity;


/**
 * <strong>t_catalogue</strong><br>
 * Tabla 24 catalogo
 */
public class TCatalogueGet extends TCatalogue {

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
