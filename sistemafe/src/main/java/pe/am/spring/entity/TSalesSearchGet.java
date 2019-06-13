package pe.am.spring.entity;

import java.math.*;
import java.util.*;
import java.util.Date;
//import javax.validation.*;
//import javax.validation.constraints.*;
//
//import org.framework.entity.*;
//import org.framework.validation.*;
//
//import io.swagger.annotations.*;

public class TSalesSearchGet extends TSalesFilter {

  PaginacionFiltro paginacion;
	private Date fechaEmisionIni;
	private Date fechaEmisionFin;

  public PaginacionFiltro getPaginacion() {
    return paginacion;
  }

  public void setPaginacion(PaginacionFiltro paginacion) {
    this.paginacion = paginacion;
  }
	public Date getFechaEmisionIni() {
		return fechaEmisionIni;
	}

	public void setFechaEmisionIni(Date fechaEmisionIni) {
		this.fechaEmisionIni = fechaEmisionIni;
	}

	public Date getFechaEmisionFin() {
		return fechaEmisionFin;
	}

	public void setFechaEmisionFin(Date fechaEmisionFin) {
		this.fechaEmisionFin = fechaEmisionFin;
	}
}
