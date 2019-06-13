package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;




public class TBussines {


	  /**
	   * <strong>busi_bident bigint NOT NULL</strong>
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
	  Long busiBident;

	  /**
	   * <strong>pers_bident bigint</strong>
	   */
	  Long persBident;

	  /**
	   * <strong>cert_bident bigint</strong>
	   */
	  Long certBident;

	  /**
	   * <strong>sett_bident bigint</strong>
	   */
	  Long settBident;

	  /**
	   * <strong>busi_vlogourl character varying</strong>
	   */
//	  @Size(max = 100)
	  String busiLogourl;

	  /**
	   * <strong>busi_tstartvig timestamp without time zone</strong>
	   */
	  Date busiTstartvig;

	  /**
	   * <strong>busi_tendvig timestamp without time zone</strong>
	   */
	  Date busiTendvig;

	  /**
	   * <strong>busi_cstate char</strong>
	   */
//	  @Min(1)
	  String busiCstate;

	  /**
	   * <strong>busi_tregistration_date timestamp with time zone</strong>
	   */
	  Date busiTregistrationDate;

	  /**
	   * <strong>busi_tdate_update timestamp with time zone</strong>
	   */
	  Date busiTdateUpdate;

	  /**
	   * <strong>busi_buser_modify bigint</strong>
	   */
	  Long busiBuserModify;

	  Long busgrBident;

	  /**
	   * <strong>busi_bident bigint NOT NULL</strong>
	   */
	  public void setBusiBident(Long busiBident) {
	    this.busiBident = busiBident;
	  }

	  /**
	   * <strong>busi_bident bigint NOT NULL</strong>
	   */
	  public Long getBusiBident() {
	    return busiBident;
	  }

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
	   * <strong>cert_bident bigint</strong>
	   */
	  public void setCertBident(Long certBident) {
	    this.certBident = certBident;
	  }

	  /**
	   * <strong>cert_bident bigint</strong>
	   */
	  public Long getCertBident() {
	    return certBident;
	  }

	  /**
	   * <strong>sett_bident bigint</strong>
	   */
	  public void setSettBident(Long settBident) {
	    this.settBident = settBident;
	  }

	  /**
	   * <strong>sett_bident bigint</strong>
	   */
	  public Long getSettBident() {
	    return settBident;
	  }

	  /**
	   * <strong>busi_logourl character varying</strong>
	   */
	  public void setBusiVlogourl(String busiLogourl) {
	    this.busiLogourl = busiLogourl;
	  }

	  /**
	   * <strong>busi_logourl character varying</strong>
	   */
	  public String getBusiVlogourl() {
	    return busiLogourl;
	  }

	  /**
	   * <strong>busi_tstartvig timestamp without time zone</strong>
	   */
	  public void setBusiTstartvig(Date busiTstartvig) {
	    this.busiTstartvig = busiTstartvig;
	  }

	  /**
	   * <strong>busi_tstartvig timestamp without time zone</strong>
	   */
	  public Date getBusiTstartvig() {
	    return busiTstartvig;
	  }

	  /**
	   * <strong>busi_tendvig timestamp without time zone</strong>
	   */
	  public void setBusiTendvig(Date busiTendvig) {
	    this.busiTendvig = busiTendvig;
	  }

	  /**
	   * <strong>busi_tendvig timestamp without time zone</strong>
	   */
	  public Date getBusiTendvig() {
	    return busiTendvig;
	  }

	  /**
	   * <strong>busi_cstate string</strong>
	   */
	  public void setBusiCstate(String busiCstate) {
	    this.busiCstate = busiCstate;
	  }

	  /**
	   * <strong>busi_cstate string</strong>
	   */
	  public String getBusiCstate() {
	    return busiCstate;
	  }

	  
	  /**
	   * <strong>busi_tregistration_date timestamp with time zone</strong>
	   */
	  public void setBusiTregistrationDate(Date busiTregistrationDate) {
	    this.busiTregistrationDate = busiTregistrationDate;
	  }

	  /**
	   * <strong>busi_tregistration_date timestamp with time zone</strong>
	   */
	  public Date getBusiTregistrationDate() {
	    return busiTregistrationDate;
	  }

	  /**
	   * <strong>busi_tdate_update timestamp with time zone</strong>
	   */
	  public void setBusiTdateUpdate(Date busiTdateUpdate) {
	    this.busiTdateUpdate = busiTdateUpdate;
	  }

	  /**
	   * <strong>busi_tdate_update timestamp with time zone</strong>
	   */
	  public Date getBusiTdateUpdate() {
	    return busiTdateUpdate;
	  }

	  /**
	   * <strong>busi_buser_modify bigint</strong>
	   */
	  public void setBusiBuserModify(Long busiBuserModify) {
	    this.busiBuserModify = busiBuserModify;
	  }

	  /**
	   * <strong>busi_buser_modify bigint</strong>
	   */
	  public Long getBusiBuserModify() {
	    return busiBuserModify;
	  }

	  
	  
	public Long getBusgrBident() {
		return busgrBident;
	}

	public void setBusgrBident(Long busgrBident) {
		this.busgrBident = busgrBident;
	}

	@Override
	public String toString() {
		return "TBussines [busiBident=" + busiBident + ", persBident=" + persBident + ", certBident=" + certBident
				+ ", settBident=" + settBident + ", busiLogourl=" + busiLogourl + ", busiTstartvig=" + busiTstartvig
				+ ", busiTendvig=" + busiTendvig + ", busiCstate=" + busiCstate + ", busiTregistrationDate="
				+ busiTregistrationDate + ", busiTdateUpdate=" + busiTdateUpdate + ", busiBuserModify="
				+ busiBuserModify + "]";
	}

}