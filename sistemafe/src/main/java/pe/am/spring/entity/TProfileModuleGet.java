package pe.am.spring.entity;

/**
 * <strong>t_profile_module</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TProfileModuleGet extends TProfileModule {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
