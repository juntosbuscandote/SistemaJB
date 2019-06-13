package pe.am.spring.entity;

/**
 * <strong>t_profile</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TProfileGet extends TProfile {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
