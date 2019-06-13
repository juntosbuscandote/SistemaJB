package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


public class TAddressPerson {


  /**
   * <strong>pers_bident bigint</strong>
   */
//  @Min(1)
  Long persBident;

  /**
   * <strong>addr_vaddress character varying</strong>
   */
//  @Size(max = 250)
  String addrVaddress;

  /**
   * <strong>addr_vmain character varying</strong>
   */
//  @Size(max = 50)
  String addrVmain;

  /**
   * <strong>addr_bstate boolean</strong>
   */
  Boolean addrBstate;

  /**
   * <strong>addr_vtype character varying</strong>
   */
//  @Size(max = 50)
  String addrVtype;


  /**
   * <strong>pers_bident bigint</strong>
   */
  public void setPersBident(Long persBident) {
    this.persBident = persBident;
  }

  /**
   * <strong>pers_bident bigint</strong>
   */
  public Long getPersBident() {
    return persBident;
  }

  /**
   * <strong>addr_vaddress character varying</strong>
   */
  public void setAddrVaddress(String addrVaddress) {
    this.addrVaddress = addrVaddress;
  }

  /**
   * <strong>addr_vaddress character varying</strong>
   */
  public String getAddrVaddress() {
    return addrVaddress;
  }

  /**
   * <strong>addr_vmain character varying</strong>
   */
  public void setAddrVmain(String addrVmain) {
    this.addrVmain = addrVmain;
  }

  /**
   * <strong>addr_vmain character varying</strong>
   */
  public String getAddrVmain() {
    return addrVmain;
  }

  /**
   * <strong>addr_bstate boolean</strong>
   */
  public void setAddrBstate(Boolean addrBstate) {
    this.addrBstate = addrBstate;
  }

  /**
   * <strong>addr_bstate boolean</strong>
   */
  public Boolean getAddrBstate() {
    return addrBstate;
  }

  /**
   * <strong>addr_vtype character varying</strong>
   */
  public void setAddrVtype(String addrVtype) {
    this.addrVtype = addrVtype;
  }

  /**
   * <strong>addr_vtype character varying</strong>
   */
  public String getAddrVtype() {
    return addrVtype;
  }

@Override
public String toString() {
	return "TAddressPerson [persBident=" + persBident + ", addrVaddress=" + addrVaddress + ", addrVmain=" + addrVmain
			+ ", addrBstate=" + addrBstate + ", addrVtype=" + addrVtype + "]";
}

  
}