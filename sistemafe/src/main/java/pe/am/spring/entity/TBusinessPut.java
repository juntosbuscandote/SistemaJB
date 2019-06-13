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
public class TBusinessPut extends TBusiness {

    /**
     * <strong>busi_iruc integer NOT NULL</strong><br>
     * Codigo de RUC de la empresa unico
     */
//    @ApiModelProperty(value = "Codigo de RUC de la empresa unico", required = true)
//    @Override
    public String getBusiVruc() {
        return super.getBusiVruc();
    }

    /**
     * <strong>busi_vname character varying NOT NULL</strong><br>
     * Razon social de la empresa
     */
//    @ApiModelProperty(value = "Razon social de la empresa", required = true)
//    @Override
    public String getBusiVbusiname() {
        return super.getBusiVbusiname();
    }

}
