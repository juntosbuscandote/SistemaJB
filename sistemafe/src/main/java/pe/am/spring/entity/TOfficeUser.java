package pe.am.spring.entity;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

//import javax.validation.constraints.*;
//
//import org.framework.validation.*;

import com.fasterxml.jackson.annotation.*;

//import io.swagger.annotations.*;



//@JsonInclude(NON_NULL)
public class TOfficeUser {


  /**
   * <strong>repo_bident bigint NOT NULL</strong><br>
   * Codigo identificador de almacen
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Codigo identificador de sucursal por almacen")
  Long offiuserBident;

  /**
   * <strong>offi_bident bigint</strong><br>
   * Codigo identificador de sucursal
   */
//  @Min(1)
//  @ApiModelProperty(value = "Codigo identificador de sucursal")
  Long offiBident;

  /**
   * <strong>repo_vcode character varying</strong><br>
   * Codigo de almacen
   */
//  @Size(max = 45)
//  @ApiModelProperty(value = "Usuario")
  String user_vuser;

  /**
   * <strong>repo_tregistration_date timestamp with time zone</strong><br>
   * Fecha de registro
   */
//  @ApiModelProperty(value = "Fecha de registro")
  Date repouserTregistrationDate;

  /**
   * <strong>repo_tdate_update timestamp with time zone</strong><br>
   * Fecha de ultima actualización
   */
//  @ApiModelProperty(value = "Fecha de ultima actualización")
  Date repouserTdateUpdate;

  /**
   * <strong>repo_buser_register character varying</strong><br>
   * Usuario que registro el almacen
   */
//  @Size(max = 45)
//  @ApiModelProperty(value = "Usuario que registro el almacen")
  String repouserBuserRegister;

  /**
   * <strong>repo_buser_modify character varying</strong><br>
   * Ultimo usuario que modifico el almacen
   */
//  @Size(max = 45)
//  @ApiModelProperty(value = "Ultimo usuario que modifico el almacen")
  String repouserBuserModify;
  
  
//  @Size(max = 2)
//  @ApiModelProperty(value = "Estado almacen")
  String repouserBstate;


  
  
  
  public Date getRepouserTregistrationDate() {
	return repouserTregistrationDate;
}

public void setRepouserTregistrationDate(Date repouserTregistrationDate) {
	this.repouserTregistrationDate = repouserTregistrationDate;
}

public Date getRepouserTdateUpdate() {
	return repouserTdateUpdate;
}

public void setRepouserTdateUpdate(Date repouserTdateUpdate) {
	this.repouserTdateUpdate = repouserTdateUpdate;
}

public String getRepouserBuserRegister() {
	return repouserBuserRegister;
}

public void setRepouserBuserRegister(String repouserBuserRegister) {
	this.repouserBuserRegister = repouserBuserRegister;
}

public String getRepouserBuserModify() {
	return repouserBuserModify;
}

public void setRepouserBuserModify(String repouserBuserModify) {
	this.repouserBuserModify = repouserBuserModify;
}

public String getRepouserBstate() {
	return repouserBstate;
}

public void setRepouserBstate(String repouserBstate) {
	this.repouserBstate = repouserBstate;
}

public Long getOffiuserBident() {
	return offiuserBident;
}

public void setOffiuserBident(Long offiuserBident) {
	this.offiuserBident = offiuserBident;
}

public String getUser_vuser() {
	return user_vuser;
}

public void setUser_vuser(String user_vuser) {
	this.user_vuser = user_vuser;
}

  /**
   * <strong>offi_bident bigint</strong><br>
   * Codigo identificador de sucursal
   */
  public void setOffiBident(Long offiBident) {
    this.offiBident = offiBident;
  }

  /**
   * <strong>offi_bident bigint</strong><br>
   * Codigo identificador de sucursal
   */
  public Long getOffiBident() {
    return offiBident;
  }


  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}