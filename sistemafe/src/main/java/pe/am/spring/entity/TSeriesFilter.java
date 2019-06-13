package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

//import javax.validation.*;
//import javax.validation.constraints.*;
//
//import org.framework.entity.*;
//import org.framework.validation.*;

import com.fasterxml.jackson.annotation.*;

//import io.swagger.annotations.*;


/**
 * <strong>t_series</strong><br>
 * Tabla de serie de ventas
 */
//@JsonInclude(NON_NULL)
public class TSeriesFilter {


  /**
   * <strong>seri_bident bigint NOT NULL</strong><br>
   * Clave primaria de tabla serie
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Clave primaria de tabla serie")
  Long seriBident;

  /**
   * <strong>seri_cdoc_electronic character</strong><br>
   * Documento electronico
   */
//  @Size(max = 2)
//  @ApiModelProperty(value = "Documento electronico")
  String seriCdocElectronic;

  /**
   * <strong>seri_vtype_doc character varying</strong><br>
   * Tipo de documento
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "Tipo de documento")
  String seriVtypeDoc;

  /**
   * <strong>seri_vnumber_series character varying</strong><br>
   * Numero de serie
   */
//  @Size(max = 10)
//  @ApiModelProperty(value = "Numero de serie")
  String seriVnumberSeries;

  /**
   * <strong>seri_vhomologated_serial_numb character varying</strong><br>
   * Numero de serie holomologado
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "Numero de serie holomologado")
  String seriVhomologatedSerialNumb;

  /**
   * <strong>seri_tregistraton_date timestamp without time zone</strong><br>
   * Fecha de registro de serie
   */
//  @ApiModelProperty(value = "Fecha de registro de serie")
  Date seriTregistratonDate;

  /**
   * <strong>seri_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion
   */
//  @ApiModelProperty(value = "Fecha de actualizacion")
  Date seriTdateUpdate;

  /**
   * <strong>seri_buser_create bigint</strong><br>
   * Codigo de usuaru que crea serie
   */
//  @ApiModelProperty(value = "Codigo de usuaru que crea serie")
  Long seriBuserCreate;

  /**
   * <strong>seri_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica las series
   */
//  @ApiModelProperty(value = "Codigo de usuario que modifica las series")
  Long seriBuserModify;

  /**
   * <strong>busi_bident bigint</strong>
   */
//  @Min(1)
  Long busiBident;

//@Min(1)
Long offiBident;

/**
 * <strong>sucursal character varying</strong><br>
 * Nombre de sucursal
 */
//@Size(max = 100)
//@ApiModelProperty(value = "Nombre de sucursal")
String sucursal;

/**
 * <strong>seri_cstate character</strong><br>
 * Estado de serie
 */
//@Size(max = 2)
//@ApiModelProperty(value = "estado de serie")
String seriCstate;





  public Long getOffiBident() {
	return offiBident;
}

public void setOffiBident(Long offiBident) {
	this.offiBident = offiBident;
}

public String getSucursal() {
	return sucursal;
}

public void setSucursal(String sucursal) {
	this.sucursal = sucursal;
}

public String getSeriCstate() {
	return seriCstate;
}

public void setSeriCstate(String seriCstate) {
	this.seriCstate = seriCstate;
}

/**
   * <strong>seri_bident bigint NOT NULL</strong><br>
   * Clave primaria de tabla serie
   */
  public void setSeriBident(Long seriBident) {
    this.seriBident = seriBident;
  }

  /**
   * <strong>seri_bident bigint NOT NULL</strong><br>
   * Clave primaria de tabla serie
   */
  public Long getSeriBident() {
    return seriBident;
  }

  /**
   * <strong>seri_cdoc_electronic character</strong><br>
   * Documento electronico
   */
  public void setSeriCdocElectronic(String seriCdocElectronic) {
    this.seriCdocElectronic = seriCdocElectronic;
  }

  /**
   * <strong>seri_cdoc_electronic character</strong><br>
   * Documento electronico
   */
  public String getSeriCdocElectronic() {
    return seriCdocElectronic;
  }

  /**
   * <strong>seri_vtype_doc character varying</strong><br>
   * Tipo de documento
   */
  public void setSeriVtypeDoc(String seriVtypeDoc) {
    this.seriVtypeDoc = seriVtypeDoc;
  }

  /**
   * <strong>seri_vtype_doc character varying</strong><br>
   * Tipo de documento
   */
  public String getSeriVtypeDoc() {
    return seriVtypeDoc;
  }

  /**
   * <strong>seri_vnumber_series character varying</strong><br>
   * Numero de serie
   */
  public void setSeriVnumberSeries(String seriVnumberSeries) {
    this.seriVnumberSeries = seriVnumberSeries;
  }

  /**
   * <strong>seri_vnumber_series character varying</strong><br>
   * Numero de serie
   */
  public String getSeriVnumberSeries() {
    return seriVnumberSeries;
  }

  /**
   * <strong>seri_vhomologated_serial_numb character varying</strong><br>
   * Numero de serie holomologado
   */
  public void setSeriVhomologatedSerialNumb(String seriVhomologatedSerialNumb) {
    this.seriVhomologatedSerialNumb = seriVhomologatedSerialNumb;
  }

  /**
   * <strong>seri_vhomologated_serial_numb character varying</strong><br>
   * Numero de serie holomologado
   */
  public String getSeriVhomologatedSerialNumb() {
    return seriVhomologatedSerialNumb;
  }

  /**
   * <strong>seri_tregistraton_date timestamp without time zone</strong><br>
   * Fecha de registro de serie
   */
  public void setSeriTregistratonDate(Date seriTregistratonDate) {
    this.seriTregistratonDate = seriTregistratonDate;
  }

  /**
   * <strong>seri_tregistraton_date timestamp without time zone</strong><br>
   * Fecha de registro de serie
   */
  public Date getSeriTregistratonDate() {
    return seriTregistratonDate;
  }

  /**
   * <strong>seri_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion
   */
  public void setSeriTdateUpdate(Date seriTdateUpdate) {
    this.seriTdateUpdate = seriTdateUpdate;
  }

  /**
   * <strong>seri_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion
   */
  public Date getSeriTdateUpdate() {
    return seriTdateUpdate;
  }

  /**
   * <strong>seri_buser_create bigint</strong><br>
   * Codigo de usuaru que crea serie
   */
  public void setSeriBuserCreate(Long seriBuserCreate) {
    this.seriBuserCreate = seriBuserCreate;
  }

  /**
   * <strong>seri_buser_create bigint</strong><br>
   * Codigo de usuaru que crea serie
   */
  public Long getSeriBuserCreate() {
    return seriBuserCreate;
  }

  /**
   * <strong>seri_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica las series
   */
  public void setSeriBuserModify(Long seriBuserModify) {
    this.seriBuserModify = seriBuserModify;
  }

  /**
   * <strong>seri_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica las series
   */
  public Long getSeriBuserModify() {
    return seriBuserModify;
  }

  /**
   * <strong>busi_bident bigint</strong>
   */
  public void setBusiBident(Long busiBident) {
    this.busiBident = busiBident;
  }

  /**
   * <strong>busi_bident bigint</strong>
   */
  public Long getBusiBident() {
    return busiBident;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}