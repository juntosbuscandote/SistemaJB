package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;



public class TNaturalPerson {


  /**
   * <strong>natu_bident bigint NOT NULL</strong>
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
  Long natuBident;

  /**
   * <strong>natu_vname character varying</strong>
   */
//  @Size(max = 50)
  String natuVname;

  /**
   * <strong>natu_vlastnamefather character varying</strong>
   */
//  @Size(max = 50)
  String natuVlastnamefather;

  /**
   * <strong>natu_vlastnamemat character varying</strong>
   */
//  @Size(max = 50)
  String natuVlastnamemother;


  /**
   * <strong>natu_bident bigint NOT NULL</strong>
   */
  public void setNatuBident(Long natuBident) {
    this.natuBident = natuBident;
  }

  /**
   * <strong>natu_bident bigint NOT NULL</strong>
   */
  public Long getNatuBident() {
    return natuBident;
  }

  /**
   * <strong>natu_vname character varying</strong>
   */
  public void setNatuVname(String natuVname) {
    this.natuVname = natuVname;
  }

  /**
   * <strong>natu_vname character varying</strong>
   */
  public String getNatuVname() {
    return natuVname;
  }

  /**
   * <strong>natu_vlastnamefather character varying</strong>
   */
  public void setNatuVlastnamefather(String natuVlastnamefather) {
    this.natuVlastnamefather = natuVlastnamefather;
  }

  /**
   * <strong>natu_vlastnamepfather character varying</strong>
   */
  public String getNatuVlastnamefather() {
    return natuVlastnamefather;
  }

  /**
   * <strong>natu_vlastnamemother character varying</strong>
   */
  public void setNatuVlastnamemother(String natuVlastnamemother) {
    this.natuVlastnamemother= natuVlastnamemother;
  }

  /**
   * <strong>natu_vlastnamemother character varying</strong>
   */
  public String getNatuVlastnamemother() {
    return natuVlastnamemother;
  }

@Override
public String toString() {
	return "TNaturalPerson [natuBident=" + natuBident + ", natuVname=" + natuVname + ", natuVlastnamefather="
			+ natuVlastnamefather + ", natuVlastnamemother=" + natuVlastnamemother + "]";
}

  
}