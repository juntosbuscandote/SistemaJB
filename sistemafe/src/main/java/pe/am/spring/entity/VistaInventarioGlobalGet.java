package pe.am.spring.entity;

import java.util.Date;

public class VistaInventarioGlobalGet extends VistaInventarioGlobal {

	PaginacionFiltro paginacion;
	private Date fechaMovimientoIni;
	private Date fechaMovimientoFin;

	public VistaInventarioGlobalGet() {
		super();
	}

	public PaginacionFiltro getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(PaginacionFiltro paginacion) {
		this.paginacion = paginacion;
	}

	public Date getFechaMovimientoIni() {
		return fechaMovimientoIni;
	}

	public void setFechaMovimientoIni(Date fechaMovimientoIni) {
		this.fechaMovimientoIni = fechaMovimientoIni;
	}

	public Date getFechaMovimientoFin() {
		return fechaMovimientoFin;
	}

	public void setFechaMovimientoFin(Date fechaMovimientoFin) {
		this.fechaMovimientoFin = fechaMovimientoFin;
	}
	
	

}
