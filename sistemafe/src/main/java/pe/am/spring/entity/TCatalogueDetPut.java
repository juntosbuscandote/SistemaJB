package pe.am.spring.entity;


/**
 * <strong>t_catalogue_det</strong><br>
 * Tabla 23 detalle de catalogo
 */
public class TCatalogueDetPut extends TCatalogueDet {

  /**
   * <strong>catd_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de detalle de catalogo
   */
//  @ApiModelProperty(value = "Codigo autogenerado de detalle de catalogo", required = true)
  @Override
  public Long getCatdBident() {
    return super.getCatdBident();
  }



  /**
   * <strong>catd_vdescription character varying NOT NULL</strong><br>
   * Descripción de detalle de catalogo
   */
//  @ApiModelProperty(value = "Descripción de detalle de catalogo", required = true)
  @Override
  public String getCatdVdescription() {
    return super.getCatdVdescription();
  }








}