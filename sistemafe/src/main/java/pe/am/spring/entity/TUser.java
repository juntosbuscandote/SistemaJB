package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

public class TUser {

	/**
	 * <strong>user_vuser character varying NOT NULL</strong><br>
	 * Usuario de acceso al sistema
	 */
	// @NotNull(groups = { OperacionPost.class, OperacionPut.class })
	// @Min(1)
	// @Size(max = 45)
	// @ApiModelProperty(value = "Usuario de acceso al sistema")
	String userVuser;

	/**
	 * <strong>user_vpassword character varying</strong><br>
	 * Contraseña de acceso al sistema
	 */
	// @Size(max = 45)
	// @ApiModelProperty(value = "Contraseña de acceso al sistema")
	String userVpassword;

	/**
	 * <strong>user_bstate boolean</strong><br>
	 * Estado de usurariol activo_inactivo
	 */
	// @ApiModelProperty(value = "Estado de usurariol activo_inactivo")
	Boolean userBstate;

	/**
	 * <strong>user_tregistration_date timestamp with time zone</strong><br>
	 * Fecha de registro de la tabla usuarios
	 */
	// @ApiModelProperty(value = "Fecha de registro de la tabla usuarios")
	Date userTregistrationDate;

	/**
	 * <strong>user_tdate_update timestamp with time zone</strong><br>
	 * Fecha de actualizacion de la tabla usuario
	 */
	// @ApiModelProperty(value = "Fecha de actualizacion de la tabla usuario")
	Date userTdateUpdate;

	/**
	 * <strong>user_buser_modify bigint</strong><br>
	 * Usuario que modifica la tabla de usuarios
	 */
	// @ApiModelProperty(value = "Usuario que modifica la tabla de usuarios")
	Long userBuserModify;

	/**
	 * <strong>prof_bident bigint</strong><br>
	 * Codigo foraneo de perfil
	 */
	// @Min(1)
	// @ApiModelProperty(value = "Codigo foraneo de perfil")
	public Long profBident;

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	// @Min(1)
	// @ApiModelProperty(value = "Codigo foraneo de persona")
	Long persBident;

	// @Size(max = 200)
	// @ApiModelProperty(value = "Token de usuario de acceso al sistema")
	String userToken;

	/**
	 * <strong>user_vuser character varying NOT NULL</strong><br>
	 * Usuario de acceso al sistema
	 */
	public void setUserVuser(String userVuser) {
		this.userVuser = userVuser;
	}

	/**
	 * <strong>user_vuser character varying NOT NULL</strong><br>
	 * Usuario de acceso al sistema
	 */
	public String getUserVuser() {
		return userVuser;
	}

	/**
	 * <strong>user_vpassword character varying</strong><br>
	 * Contraseña de acceso al sistema
	 */
	public void setUserVpassword(String userVpassword) {
		this.userVpassword = userVpassword;
	}

	/**
	 * <strong>user_vpassword character varying</strong><br>
	 * Contraseña de acceso al sistema
	 */
	public String getUserVpassword() {
		return userVpassword;
	}

	/**
	 * <strong>user_bstate boolean</strong><br>
	 * Estado de usurariol activo_inactivo
	 */
	public void setUserBstate(Boolean userBstate) {
		this.userBstate = userBstate;
	}

	/**
	 * <strong>user_bstate boolean</strong><br>
	 * Estado de usurariol activo_inactivo
	 */
	public Boolean getUserBstate() {
		return userBstate;
	}

	/**
	 * <strong>user_tregistration_date timestamp with time zone</strong><br>
	 * Fecha de registro de la tabla usuarios
	 */
	public void setUserTregistrationDate(Date userTregistrationDate) {
		this.userTregistrationDate = userTregistrationDate;
	}

	/**
	 * <strong>user_tregistration_date timestamp with time zone</strong><br>
	 * Fecha de registro de la tabla usuarios
	 */
	public Date getUserTregistrationDate() {
		return userTregistrationDate;
	}

	/**
	 * <strong>user_tdate_update timestamp with time zone</strong><br>
	 * Fecha de actualizacion de la tabla usuario
	 */
	public void setUserTdateUpdate(Date userTdateUpdate) {
		this.userTdateUpdate = userTdateUpdate;
	}

	/**
	 * <strong>user_tdate_update timestamp with time zone</strong><br>
	 * Fecha de actualizacion de la tabla usuario
	 */
	public Date getUserTdateUpdate() {
		return userTdateUpdate;
	}

	/**
	 * <strong>user_buser_modify bigint</strong><br>
	 * Usuario que modifica la tabla de usuarios
	 */
	public void setUserBuserModify(Long userBuserModify) {
		this.userBuserModify = userBuserModify;
	}

	/**
	 * <strong>user_buser_modify bigint</strong><br>
	 * Usuario que modifica la tabla de usuarios
	 */
	public Long getUserBuserModify() {
		return userBuserModify;
	}

	/**
	 * <strong>prof_bident bigint</strong><br>
	 * Codigo foraneo de perfil
	 */
	public void setProfBident(Long profBident) {
		this.profBident = profBident;
	}

	/**
	 * <strong>prof_bident bigint</strong><br>
	 * Codigo foraneo de perfil
	 */
	public Long getProfBident() {
		return profBident;
	}

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	public void setPersBident(Long persBident) {
		this.persBident = persBident;
	}

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	public Long getPersBident() {
		return persBident;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	@Override
	public String toString() {
		return "TUser [userVuser=" + userVuser + ", userVpassword=" + userVpassword + ", userBstate=" + userBstate
				+ ", userTregistrationDate=" + userTregistrationDate + ", userTdateUpdate=" + userTdateUpdate
				+ ", userBuserModify=" + userBuserModify + ", profBident=" + profBident + ", persBident=" + persBident
				+ ", userToken=" + userToken + "]";
	}

}