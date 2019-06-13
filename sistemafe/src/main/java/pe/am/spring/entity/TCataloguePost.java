package pe.am.spring.entity;

import java.math.*;
import java.util.*;
/**
 * <strong>t_catalogue</strong><br>
 * Tabla 24 catalogo
 */
public class TCataloguePost extends TCatalogue {


  /**
   * <strong>cata_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de catalogo
   */
//  @ApiModelProperty(value = "Codigo autogenerado de catalogo", required = true)
  @Override
  public Long getCataBident() {
    return super.getCataBident();
  }


}