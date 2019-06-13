package pe.am.spring.entity;

import java.math.BigDecimal;
import java.util.Date;

public class VistaHistorialPres {

	Long idPresentacion;
	Long idProd;
	Long idMarca;
	Long idHistorialInv;
	String codMov;
	Date fechaMov;
	String codComercial;
	String nombreProducto;
	String nombreComercial;
	String descrProducto;
	String presentacion;
	String descAlterUM;
	String marca;
	String nroDocProveedor;
	String rsProveedor;
	String codDocIO;
	String docIO;
	String nombreCortoCompr;
	String serieCompr;
	String nroCompr;
	String indicIO;
	BigDecimal cantEntrada;
	BigDecimal costoUnitEntrada;
	BigDecimal costoTotalEntrada;
	BigDecimal cantSalida;
	BigDecimal costoUnitSalida;
	BigDecimal costoTotalSalida;
	BigDecimal cantStock;
	BigDecimal costoProm;
	BigDecimal costoTotal;
	Date fechaRegistro;
	String userCreateMov;
	
	String user;
	String sucursal;
	
	String codSucursal;
	String nomSucursal;
	String codAlmacen;
	String ejercicio;
	String meses;
	String estado;
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public VistaHistorialPres() {
		super();
	}

	public Long getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(Long idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public Long getIdHistorialInv() {
		return idHistorialInv;
	}

	public void setIdHistorialInv(Long idHistorialInv) {
		this.idHistorialInv = idHistorialInv;
	}

	public String getCodMov() {
		return codMov;
	}

	public void setCodMov(String codMov) {
		this.codMov = codMov;
	}

	public Date getFechaMov() {
		return fechaMov;
	}

	public void setFechaMov(Date fechaMov) {
		this.fechaMov = fechaMov;
	}

	public String getCodComercial() {
		return codComercial;
	}

	public void setCodComercial(String codComercial) {
		this.codComercial = codComercial;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getDescrProducto() {
		return descrProducto;
	}

	public void setDescrProducto(String descrProducto) {
		this.descrProducto = descrProducto;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getDescAlterUM() {
		return descAlterUM;
	}

	public void setDescAlterUM(String descAlterUM) {
		this.descAlterUM = descAlterUM;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNroDocProveedor() {
		return nroDocProveedor;
	}

	public void setNroDocProveedor(String nroDocProveedor) {
		this.nroDocProveedor = nroDocProveedor;
	}

	public String getRsProveedor() {
		return rsProveedor;
	}

	public void setRsProveedor(String rsProveedor) {
		this.rsProveedor = rsProveedor;
	}

	public String getCodDocIO() {
		return codDocIO;
	}

	public void setCodDocIO(String codDocIO) {
		this.codDocIO = codDocIO;
	}

	public String getDocIO() {
		return docIO;
	}

	public void setDocIO(String docIO) {
		this.docIO = docIO;
	}

	public String getNombreCortoCompr() {
		return nombreCortoCompr;
	}

	public void setNombreCortoCompr(String nombreCortoCompr) {
		this.nombreCortoCompr = nombreCortoCompr;
	}

	public String getSerieCompr() {
		return serieCompr;
	}

	public void setSerieCompr(String serieCompr) {
		this.serieCompr = serieCompr;
	}

	public String getNroCompr() {
		return nroCompr;
	}

	public void setNroCompr(String nroCompr) {
		this.nroCompr = nroCompr;
	}

	public String getIndicIO() {
		return indicIO;
	}

	public void setIndicIO(String indicIO) {
		this.indicIO = indicIO;
	}

	public BigDecimal getCantEntrada() {
		return cantEntrada;
	}

	public void setCantEntrada(BigDecimal cantEntrada) {
		this.cantEntrada = cantEntrada;
	}

	public BigDecimal getCostoUnitEntrada() {
		return costoUnitEntrada;
	}

	public void setCostoUnitEntrada(BigDecimal costoUnitEntrada) {
		this.costoUnitEntrada = costoUnitEntrada;
	}

	public BigDecimal getCostoTotalEntrada() {
		return costoTotalEntrada;
	}

	public void setCostoTotalEntrada(BigDecimal costoTotalEntrada) {
		this.costoTotalEntrada = costoTotalEntrada;
	}

	public BigDecimal getCantSalida() {
		return cantSalida;
	}

	public void setCantSalida(BigDecimal cantSalida) {
		this.cantSalida = cantSalida;
	}

	public BigDecimal getCostoUnitSalida() {
		return costoUnitSalida;
	}

	public void setCostoUnitSalida(BigDecimal costoUnitSalida) {
		this.costoUnitSalida = costoUnitSalida;
	}

	public BigDecimal getCostoTotalSalida() {
		return costoTotalSalida;
	}

	public void setCostoTotalSalida(BigDecimal costoTotalSalida) {
		this.costoTotalSalida = costoTotalSalida;
	}

	public BigDecimal getCantStock() {
		return cantStock;
	}

	public void setCantStock(BigDecimal cantStock) {
		this.cantStock = cantStock;
	}

	public BigDecimal getCostoProm() {
		return costoProm;
	}

	public void setCostoProm(BigDecimal costoProm) {
		this.costoProm = costoProm;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUserCreateMov() {
		return userCreateMov;
	}

	public void setUserCreateMov(String userCreateMov) {
		this.userCreateMov = userCreateMov;
	}
	
}
