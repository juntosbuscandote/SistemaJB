/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.entity;

/**
 *
 * @author User
 */
public class TBusinessPost extends TBusiness{
 
     /**
   * <strong>busi_bcod NOT NULL</strong><br>
   * Codigo autogenerado de empresa
   */
//  @ApiModelProperty(value = "Codigo de RUC de la empresa unico", required = true)
//  @Override
    
  public Long getBusiBcod() {// agregado 26/09/17 12:40 pm
    return super.getBusiBcod();
  }    

     /**
   * <strong>busi_iruc integer NOT NULL</strong><br>
   * Codigo de RUC de la empresa unico
   */
//  @ApiModelProperty(value = "Codigo de RUC de la empresa unico", required = true)
//  @Override
    
  public String getBusiVruc() {
    return super.getBusiVruc();
  }
}
