package pe.am.spring.entity;

import java.util.List;

public class AlmacenBeanBD {

	private List<PrecioBeanBD> arrayPrecios;
	private String uniMedMax;
	private String uniMedMarca;
	private String uniMedUnidadMedida;
	private String idAlmacen;
	private String uniMedStock;
	private String uniMedDescrip;
	private String uniMedPeso;
	private boolean uniMedPrincipal;
	private String uniMedEstandarUBL;
	private String uniMedMin;
	private String new_front;

	public AlmacenBeanBD() {
		super();
	}

	public List<PrecioBeanBD> getArrayPrecios() {
		return arrayPrecios;
	}

	public void setArrayPrecios(List<PrecioBeanBD> arrayPrecios) {
		this.arrayPrecios = arrayPrecios;
	}

	public String getUniMedMax() {
		return uniMedMax;
	}

	public void setUniMedMax(String uniMedMax) {
		this.uniMedMax = uniMedMax;
	}

	public String getUniMedMarca() {
		return uniMedMarca;
	}

	public void setUniMedMarca(String uniMedMarca) {
		this.uniMedMarca = uniMedMarca;
	}

	public String getUniMedUnidadMedida() {
		return uniMedUnidadMedida;
	}

	public void setUniMedUnidadMedida(String uniMedUnidadMedida) {
		this.uniMedUnidadMedida = uniMedUnidadMedida;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getUniMedStock() {
		return uniMedStock;
	}

	public void setUniMedStock(String uniMedStock) {
		this.uniMedStock = uniMedStock;
	}

	public String getUniMedDescrip() {
		return uniMedDescrip;
	}

	public void setUniMedDescrip(String uniMedDescrip) {
		this.uniMedDescrip = uniMedDescrip;
	}

	public String getUniMedPeso() {
		return uniMedPeso;
	}

	public void setUniMedPeso(String uniMedPeso) {
		this.uniMedPeso = uniMedPeso;
	}

	public boolean isUniMedPrincipal() {
		return uniMedPrincipal;
	}

	public void setUniMedPrincipal(boolean uniMedPrincipal) {
		this.uniMedPrincipal = uniMedPrincipal;
	}

	public String getUniMedEstandarUBL() {
		return uniMedEstandarUBL;
	}

	public void setUniMedEstandarUBL(String uniMedEstandarUBL) {
		this.uniMedEstandarUBL = uniMedEstandarUBL;
	}

	public String getUniMedMin() {
		return uniMedMin;
	}

	public void setUniMedMin(String uniMedMin) {
		this.uniMedMin = uniMedMin;
	}

	public String getNew_front() {
		return new_front;
	}

	public void setNew_front(String new_front) {
		this.new_front = new_front;
	}

}
