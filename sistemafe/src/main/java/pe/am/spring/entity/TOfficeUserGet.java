package pe.am.spring.entity;


//import javax.validation.*;
//import javax.validation.constraints.*;



public class TOfficeUserGet extends TOfficeUser {

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
