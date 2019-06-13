package pe.am.spring.entity;


/**
 * <strong>t_branch_office</strong><br>
 * Tabla sucursal
 */
public class TBranchOfficeGet extends TBranchOffice {

  PaginacionFiltro paginacion;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
}
