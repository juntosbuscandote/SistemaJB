package pe.am.spring.entity;


import java.math.*;
import java.util.*;


/**
 * <strong>t_catalogue</strong><br>
 * Tabla 24 catalogo
 */
//@JsonInclude(NON_NULL)
public class TCatalogue {


  /**
   * <strong>cata_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de catalogo
   */
//  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//  @Min(1)
//  @ApiModelProperty(value = "Codigo autogenerado de catalogo")
  Long cataBident;

  /**
   * <strong>cata_vdescription character varying</strong><br>
   * Descripcion de catalogo
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "Descripcion de catalogo")
  String cataVdescription;


  /**
   * <strong>cata_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de catalogo
   */
  public void setCataBident(Long cataBident) {
    this.cataBident = cataBident;
  }

  /**
   * <strong>cata_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de catalogo
   */
  public Long getCataBident() {
    return cataBident;
  }

  /**
   * <strong>cata_vdescription character varying</strong><br>
   * Descripcion de catalogo
   */
  public void setCataVdescription(String cataVdescription) {
    this.cataVdescription = cataVdescription;
  }

  /**
   * <strong>cata_vdescription character varying</strong><br>
   * Descripcion de catalogo
   */
  public String getCataVdescription() {
    return cataVdescription;
  }

@Override
public String toString() {
	return "TCatalogue [cataBident=" + cataBident + ", cataVdescription=" + cataVdescription + "]";
}

 
}