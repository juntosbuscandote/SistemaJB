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
public class TOfficeUserxSucursal {


	String userVuser;
	String nombres;
//	String profVdescription;
//	Date userTregistrationDate;
	String estado;	
//	Long persBident;
	Long busiBident;
	String offubstate;
	Long offiBident;
	String offiname;
	Long offiuserBident;


	
	
	
  public String getOffiname() {
		return offiname;
	}

	public void setOffiname(String offiname) {
		this.offiname = offiname;
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




  public String getUserVuser() {
	return userVuser;
}

public void setUserVuser(String userVuser) {
	this.userVuser = userVuser;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

//public String getProfVdescription() {
//	return profVdescription;
//}
//
//public void setProfVdescription(String profVdescription) {
//	this.profVdescription = profVdescription;
//}
//
//public Date getUserTregistrationDate() {
//	return userTregistrationDate;
//}
//
//public void setUserTregistrationDate(Date userTregistrationDate) {
//	this.userTregistrationDate = userTregistrationDate;
//}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}




public Long getBusiBident() {
	return busiBident;
}

public void setBusiBident(Long busiBident) {
	this.busiBident = busiBident;
}

//public Long getPersBident() {
//	return persBident;
//}
//
//public void setPersBident(Long persBident) {
//	this.persBident = persBident;
//}

public String getOffubstate() {
	return offubstate;
}

public void setOffubstate(String offubstate) {
	this.offubstate = offubstate;
}



public Long getOffiuserBident() {
	return offiuserBident;
}

public void setOffiuserBident(Long offiuserBident) {
	this.offiuserBident = offiuserBident;
}

@Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}