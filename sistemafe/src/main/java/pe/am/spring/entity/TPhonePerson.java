package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

public class TPhonePerson {


  /**
   * <strong>pers_bident bigint</strong>
   */
//  @Min(1)
  Long persBident;

  /**
   * <strong>phon_vphone character varying</strong>
   */
//  @Size(max = 15)
  String phonVphone;

  /**
   * <strong>phon_vmain character varying</strong>
   */
//  @Size(max = 15)
  String phonVmain;

  /**
   * <strong>phon_bstate boolean</strong>
   */
  Boolean phonBstate;

  /**
   * <strong>phon_vtype character varying</strong>
   */
//  @Size(max = 30)
  String phonVtype;


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
   * <strong>phon_vphone character varying</strong>
   */
  public void setPhonVphone(String phonVphone) {
    this.phonVphone = phonVphone;
  }

  /**
   * <strong>phon_vphone character varying</strong>
   */
  public String getPhonVphone() {
    return phonVphone;
  }

  /**
   * <strong>phon_vmain character varying</strong>
   */
  public void setPhonVmain(String phonVmain) {
    this.phonVmain = phonVmain;
  }

  /**
   * <strong>phon_vmain character varying</strong>
   */
  public String getPhonVmain() {
    return phonVmain;
  }

  /**
   * <strong>phon_bstate boolean</strong>
   */
  public void setPhonBstate(Boolean phonBstate) {
    this.phonBstate = phonBstate;
  }

  /**
   * <strong>phon_bstate boolean</strong>
   */
  public Boolean getPhonBstate() {
    return phonBstate;
  }

  /**
   * <strong>phon_vtype character varying</strong>
   */
  public void setPhonVtype(String phonVtype) {
    this.phonVtype = phonVtype;
  }

  /**
   * <strong>phon_vtype character varying</strong>
   */
  public String getPhonVtype() {
    return phonVtype;
  }

@Override
public String toString() {
	return "TPhonePerson [persBident=" + persBident + ", phonVphone=" + phonVphone + ", phonVmain=" + phonVmain
			+ ", phonBstate=" + phonBstate + ", phonVtype=" + phonVtype + "]";
}

 
}