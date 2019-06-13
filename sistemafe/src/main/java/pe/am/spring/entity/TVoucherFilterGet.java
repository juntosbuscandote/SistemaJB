package pe.am.spring.entity;

import java.util.Date;

public class TVoucherFilterGet extends TVoucherFilter {

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
