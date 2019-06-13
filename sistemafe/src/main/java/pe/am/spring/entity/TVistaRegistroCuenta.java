package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

//import javax.validation.*;
//import javax.validation.constraints.*;

//import org.framework.entity.*;
//import org.framework.validation.*;

import com.fasterxml.jackson.annotation.*;

//import io.swagger.annotations.*;


/**
 * <strong>t_sales</strong><br>
 * Tabla de ventas
 */
//@JsonInclude(NON_NULL)
public class TVistaRegistroCuenta {


  /**
   * <strong>sale_bident bigint NOT NULL</strong><br>
   * Clave primaria de ventas
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Conteo  de registros")
  Long countBident;

  /**
   * <strong>office_bident character varying</strong><br>
   * Descripcion de sucursal
   */
//  @Size(max = 20)
//  @ApiModelProperty(value = "Descripcion de forma de pago")
  String waypayDescription;

//  @ApiModelProperty(value = "Fecha de MOVIMIENTO DE Registro")
  Date movdateregister;
  

//  @ApiModelProperty(value = "Suma Importe")
  BigDecimal SumImporte;

//  @Size(max = 2)
//  @ApiModelProperty(value = "Bident de cuenta corriente")
  String countCorrienteBident;
  
  
  String waypayBident;
  
  String camsState;
  
  Long cashbident;
  
  


public Long getCashbident() {
	return cashbident;
}





public void setCashbident(Long cashbident) {
	this.cashbident = cashbident;
}





public String getCamsState() {
	return camsState;
}





public void setCamsState(String camsState) {
	this.camsState = camsState;
}





public String getWaypayBident() {
	return waypayBident;
}





public void setWaypayBident(String waypayBident) {
	this.waypayBident = waypayBident;
}





public Long getCountBident() {
	return countBident;
}





public void setCountBident(Long countBident) {
	this.countBident = countBident;
}





public String getWaypayDescription() {
	return waypayDescription;
}





public void setWaypayDescription(String waypayDescription) {
	this.waypayDescription = waypayDescription;
}





public Date getMovdateregister() {
	return movdateregister;
}





public void setMovdateregister(Date movdateregister) {
	this.movdateregister = movdateregister;
}





public BigDecimal getSumImporte() {
	return SumImporte;
}





public void setSumImporte(BigDecimal sumImporte) {
	SumImporte = sumImporte;
}





public String getCountCorrienteBident() {
	return countCorrienteBident;
}





public void setCountCorrienteBident(String countCorrienteBident) {
	this.countCorrienteBident = countCorrienteBident;
}





@Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}