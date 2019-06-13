package pe.am.spring.entity;



//import javax.validation.*;
//import javax.validation.constraints.*;



public class TOfficeUserxSucursalGet extends TOfficeUserxSucursal {
//
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
