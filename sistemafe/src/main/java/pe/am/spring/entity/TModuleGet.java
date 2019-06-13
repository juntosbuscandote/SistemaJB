package pe.am.spring.entity;

/**
 * <strong>t_module</strong><br>
 * Tabla de los modulos de la Web ContaNet
 */
public class TModuleGet extends TModule {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
