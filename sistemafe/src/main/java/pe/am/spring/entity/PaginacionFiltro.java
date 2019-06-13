package pe.am.spring.entity;


public class PaginacionFiltro
{
  Integer pagina;
  Integer cantidad;
  
  public PaginacionFiltro(Integer pagina, Integer cantidad)
  {
    this.pagina = pagina;
    this.cantidad = cantidad;
  }
  
  public PaginacionFiltro() {}
  
  public Integer getPagina()
  {
    return this.pagina;
  }
  
  public void setPagina(Integer pagina)
  {
    this.pagina = pagina;
  }
  
  public Integer getCantidad()
  {
    return this.cantidad;
  }
  
  public void setCantidad(Integer cantidad)
  {
    this.cantidad = cantidad;
  }
}
