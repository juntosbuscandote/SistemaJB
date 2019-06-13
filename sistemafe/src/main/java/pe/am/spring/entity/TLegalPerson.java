package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


public class TLegalPerson {


  /**
   * <strong>lega_bident bigint NOT NULL</strong>
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
  Long legaBident;

  /**
   * <strong>lega_businame character varying</strong>
   */
//  @Size(max = 50)
  String legaBusiname;


  /**
   * <strong>lega_bident bigint NOT NULL</strong>
   */
  public void setLegaBident(Long legaBident) {
    this.legaBident = legaBident;
  }

  /**
   * <strong>lega_bident bigint NOT NULL</strong>
   */
  public Long getLegaBident() {
    return legaBident;
  }

  /**
   * <strong>lega_businame character varying</strong>
   */
  public void setLegaBusiname(String legaBusiname) {
    this.legaBusiname = legaBusiname;
  }

  /**
   * <strong>lega_businame character varying</strong>
   */
  public String getLegaBusiname() {
    return legaBusiname;
  }

@Override
public String toString() {
	return "TLegalPerson [legaBident=" + legaBident + ", legaBusiname=" + legaBusiname + "]";
}
  

}