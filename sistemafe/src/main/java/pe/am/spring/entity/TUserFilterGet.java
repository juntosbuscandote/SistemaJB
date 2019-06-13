package pe.am.spring.entity;

public class TUserFilterGet extends TUserFilter {
	// @NotNull
	// @Valid
	PaginacionFiltro paginacion;
	Long profbident;
	Boolean estadoUsu;

	public PaginacionFiltro getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(PaginacionFiltro paginacion) {
		this.paginacion = paginacion;
	}

	public Long getProfbident() {
		return profbident;
	}

	public void setProfbident(Long profbident) {
		this.profbident = profbident;
	}

	public Boolean getEstadoUsu() {
		return estadoUsu;
	}

	public void setEstadoUsu(Boolean estadoUsu) {
		this.estadoUsu = estadoUsu;
	}

}
