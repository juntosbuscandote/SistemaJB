package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

//import javax.validation.constraints.Min;

//import javax.validation.constraints.Size;


//@JsonInclude(NON_NULL)
public class TClientEndPerson {


  /**
   * <strong>clie_bident bigint</strong>
   */
//  @Min(1)
  Long clieBident;

  /**
   * <strong>clie_bstate boolean</strong>
   */
  
  Boolean clieBstate;

  /**
   * <strong>pers_bident character varying</strong>
   */
//  @Min(1)
  Long persBident;

  /**
   * <strong>legaBident character varying</strong>
   */
//  @Min(1)
  Long busiBident;
  




public Long getBusiBident() {
	return busiBident;
}

public void setBusiBident(Long busiBident) {
	this.busiBident = busiBident;
}


/**
   * <strong>clie_Cagenret boolean</strong>
   */
//  @Size(max = 1)
  String clieCagenret;

  /**
   * <strong>clie_Cagenperc character </strong>
   */
//  @Size(max = 1)
  String clieCagenperc;


  /**
   * <strong>clie_Cbuencontri character </strong>
   */
//  @Size(max = 1)
  String clieCbuencontri;
  
  /**
   * <strong>clie_Cconsufin character </strong>
   */
//  @Size(max = 1)
  String clieCconsufin;

  /**
   * <strong>clieVextranjero character </strong>
   */
//  @Size(max = 1)
  String clieVextranjero;
  
  
  public String getClieVextranjero() {
		return clieVextranjero;
	}

	public void setClieVextranjero(String clieVextranjero) {
		this.clieVextranjero = clieVextranjero;
	}
  
public Long getClieBident() {
	return clieBident;
}

public void setClieBident(Long clieBident) {
	this.clieBident = clieBident;
}

public Boolean getClieBstate() {
	return clieBstate;
}

public void setClieBstate(Boolean clieBstate) {
	this.clieBstate = clieBstate;
}

public Long getPersBident() {
	return persBident;
}

public void setPersBident(Long persBident) {
	this.persBident = persBident;
}

public String getClieCagenret() {
	return clieCagenret;
}

public void setClieCagenret(String clieCagenret) {
	this.clieCagenret = clieCagenret;
}

public String getClieCagenperc() {
	return clieCagenperc;
}

public void setClieCagenperc(String clieCagenperc) {
	this.clieCagenperc = clieCagenperc;
}

public String getClieCbuencontri() {
	return clieCbuencontri;
}

public void setClieCbuencontri(String clieCbuencontri) {
	this.clieCbuencontri = clieCbuencontri;
}

public String getClieCconsufin() {
	return clieCconsufin;
}

public void setClieCconsufin(String clieCconsufin) {
	this.clieCconsufin = clieCconsufin;
}


@Override
public String toString() {
	return "TClientEndPerson [clieBident=" + clieBident + ", clieBstate=" + clieBstate + ",persBident="+persBident+"]";
}



}