package pe.am.spring.model;

import java.util.List;

public class PaginaResultado<T>
{
  Long cantidad;
  List<T> resultados;
  
  public List<T> getResultados()
  {
    return this.resultados;
  }
  
  public void setResultados(List<T> resultados)
  {
    this.resultados = resultados;
  }
  
  public Long getCantidad()
  {
    return this.cantidad;
  }
  
  public void setCantidad(Long cantidad)
  {
    this.cantidad = cantidad;
  }
}
