package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


public class TEmailPerson {


  /**
   * <strong>pers_bident bigint</strong>
   */
//  @Min(1)
  Long persBident;

  /**
   * <strong>mail_vemail character varying</strong>
   */
//  @Size(max = 50)
  String mailVemail;

  /**
   * <strong>mail_vmain character varying</strong>
   */
//  @Size(max = 50)
  String mailVmain;

  /**
   * <strong>mail_bstate boolean</strong>
   */
  Boolean mailBstate;

  /**
   * <strong>mail_vtype character varying</strong>
   */
  String mailVtype;


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
   * <strong>mail_vemail character varying</strong>
   */
  public void setMailVemail(String mailVemail) {
    this.mailVemail = mailVemail;
  }

  /**
   * <strong>mail_vemail character varying</strong>
   */
  public String getMailVemail() {
    return mailVemail;
  }

  /**
   * <strong>mail_vmain character varying</strong>
   */
  public void setMailVmain(String mailVmain) {
    this.mailVmain = mailVmain;
  }

  /**
   * <strong>mail_vmain character varying</strong>
   */
  public String getMailVmain() {
    return mailVmain;
  }

  /**
   * <strong>mail_bstate boolean</strong>
   */
  public void setMailBstate(Boolean mailBstate) {
    this.mailBstate = mailBstate;
  }

  /**
   * <strong>mail_bstate boolean</strong>
   */
  public Boolean getMailBstate() {
    return mailBstate;
  }

  /**
   * <strong>mail_vtype character varying</strong>
   */
  public void setMailVtype(String mailVtype) {
    this.mailVtype = mailVtype;
  }

  /**
   * <strong>mail_vtype character varying</strong>
   */
  public String getMailVtype() {
    return mailVtype;
  }

@Override
public String toString() {
	return "TEmailPerson [persBident=" + persBident + ", mailVemail=" + mailVemail + ", mailVmain=" + mailVmain
			+ ", mailBstate=" + mailBstate + ", mailVtype=" + mailVtype + "]";
}


}