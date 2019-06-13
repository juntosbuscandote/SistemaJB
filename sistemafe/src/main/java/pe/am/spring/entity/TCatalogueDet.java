package pe.am.spring.entity;

/**
 * <strong>t_catalogue_det</strong><br>
 * Tabla 23 detalle de catalogo
 */
//@JsonInclude(NON_NULL)
public class TCatalogueDet {


  /**
   * <strong>catd_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de detalle de catalogo
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Codigo autogenerado de detalle de catalogo")
  Long catdBident;

  /**
   * <strong>catd_cident character</strong><br>
   * Identidad de relacion de las tablas
   */
//  @Size(max = 10)
//  @ApiModelProperty(value = "Identidad de relacion de las tablas")
  String catdCident;

  /**
   * <strong>catd_vdescription character varying NOT NULL</strong><br>
   * Descripción de detalle de catalogo
   */
//  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//  @Size(max = 200)
//  @ApiModelProperty(value = "Descripción de detalle de catalogo")
  String catdVdescription;

  /**
   * <strong>catd_vshortname character varying</strong><br>
   * Nombre corto de detalle de catalogo
   */
//  @Size(max = 50)
//  @ApiModelProperty(value = "Nombre corto de detalle de catalogo")
  String catdVshortname;

  /**
   * <strong>catd_vsymbol character varying</strong><br>
   * Simbolo de detalle de catalogo
   */
//  @Size(max = 30)
//  @ApiModelProperty(value = "Simbolo de detalle de catalogo")
  String catdVsymbol;

  /**
   * <strong>catd_bstate boolean</strong><br>
   * Estado de detalle de catalogo
   */
//  @ApiModelProperty(value = "Estado de detalle de catalogo")
  Boolean catdBstate;

  /**
   * <strong>cata_bident bigint</strong><br>
   * Codigo foraneo de catalogo
   */
//  @Min(1)
//  @ApiModelProperty(value = "Codigo foraneo de catalogo")
  Long cataBident;

  /**
   * <strong>catd_vrelation character varying</strong><br>
   * Relacion de datos de I.A y  T.I.A
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "Relacion de datos de I.A y T.I.A")
  String catdVrelation;
  
  /**
   * <strong>catd_vkey1 character varying</strong><br>
   * COLUMNA  OPCIONAL 1
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "COLUMNA  OPCIONAL 1")
  String catdVkey1;
  
  /**
   * <strong>catd_vkey2 character varying</strong><br>
   * COLUMNA  OPCIONAL 2
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "COLUMNA  OPCIONAL 2")
  String catdVkey2;
  
  /**
   * <strong>catd_vkey3 character varying</strong><br>
   * COLUMNA  OPCIONAL 3
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "COLUMNA  OPCIONAL 3")
  String catdVkey3;
  
  /**
   * <strong>catd_vkey4 character varying</strong><br>
   * COLUMNA  OPCIONAL 4
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "COLUMNA  OPCIONAL 4")
  String catdVkey4;
  
  /**
   * <strong>catd_vkey5 character varying</strong><br>
   * COLUMNA  OPCIONAL 5
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "COLUMNA  OPCIONAL 5")
  String catdVkey5;
  
  
  /**
   * <strong>catd_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de detalle de catalogo
   */
  public void setCatdBident(Long catdBident) {
    this.catdBident = catdBident;
  }

  /**
   * <strong>catd_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de detalle de catalogo
   */
  public Long getCatdBident() {
    return catdBident;
  }

  /**
   * <strong>catd_cident character</strong><br>
   * Identidad de relacion de las tablas
   */
  public void setCatdCident(String catdCident) {
    this.catdCident = catdCident;
  }

  /**
   * <strong>catd_cident character</strong><br>
   * Identidad de relacion de las tablas
   */
  public String getCatdCident() {
    return catdCident;
  }

  /**
   * <strong>catd_vdescription character varying NOT NULL</strong><br>
   * Descripción de detalle de catalogo
   */
  public void setCatdVdescription(String catdVdescription) {
    this.catdVdescription = catdVdescription;
  }

  /**
   * <strong>catd_vdescription character varying NOT NULL</strong><br>
   * Descripción de detalle de catalogo
   */
  public String getCatdVdescription() {
    return catdVdescription;
  }

  /**
   * <strong>catd_vshortname character varying</strong><br>
   * Nombre corto de detalle de catalogo
   */
  public void setCatdVshortname(String catdVshortname) {
    this.catdVshortname = catdVshortname;
  }

  /**
   * <strong>catd_vshortname character varying</strong><br>
   * Nombre corto de detalle de catalogo
   */
  public String getCatdVshortname() {
    return catdVshortname;
  }

  /**
   * <strong>catd_vsymbol character varying</strong><br>
   * Simbolo de detalle de catalogo
   */
  public void setCatdVsymbol(String catdVsymbol) {
    this.catdVsymbol = catdVsymbol;
  }

  /**
   * <strong>catd_vsymbol character varying</strong><br>
   * Simbolo de detalle de catalogo
   */
  public String getCatdVsymbol() {
    return catdVsymbol;
  }

  /**
   * <strong>catd_bstate boolean</strong><br>
   * Estado de detalle de catalogo
   */
  public void setCatdBstate(Boolean catdBstate) {
    this.catdBstate = catdBstate;
  }

  /**
   * <strong>catd_bstate boolean</strong><br>
   * Estado de detalle de catalogo
   */
  public Boolean getCatdBstate() {
    return catdBstate;
  }

  /**
   * <strong>cata_bident bigint</strong><br>
   * Codigo foraneo de catalogo
   */
  public void setCataBident(Long cataBident) {
    this.cataBident = cataBident;
  }

  /**
   * <strong>cata_bident bigint</strong><br>
   * Codigo foraneo de catalogo
   */
  public Long getCataBident() {
    return cataBident;
  }
  
  
  /**
   * <strong>catd_vrelation character varying</strong><br>
   * Relacion de datos de I.A y  T.I.A
   */
  public void setCatdVrelation(String catdVrelation) {
		this.catdVrelation = catdVrelation;
	}

  /**
   * <strong>catd_vrelation character varying</strong><br>
   * Relacion de datos de I.A y  T.I.A
   */
  public String getCatdVrelation() {
	return catdVrelation;
}
  
  /**
   * <strong>catd_vkey1 character varying</strong><br>
   * COLUMNA  OPCIONAL 1
   */
  public String getCatdVkey1() {
	return catdVkey1;
  }
  
  /**
   * <strong>catd_vkey1 character varying</strong><br>
   * COLUMNA  OPCIONAL 1
   */
	public void setCatdVkey1(String catdVkey1) {
		this.catdVkey1 = catdVkey1;
	}
	
	 /**
	   * <strong>catd_vkey2 character varying</strong><br>
	   * COLUMNA  OPCIONAL 2
	   */
	public String getCatdVkey2() {
		return catdVkey2;
	}
	
	 /**
	   * <strong>catd_vkey2 character varying</strong><br>
	   * COLUMNA  OPCIONAL 2
	   */
	public void setCatdVkey2(String catdVkey2) {
		this.catdVkey2 = catdVkey2;
	}
	
	 /**
	   * <strong>catd_vkey3 character varying</strong><br>
	   * COLUMNA  OPCIONAL 3
	   */
	public String getCatdVkey3() {
		return catdVkey3;
	}
	
	 /**
	   * <strong>catd_vkey3 character varying</strong><br>
	   * COLUMNA  OPCIONAL 3
	   */
	public void setCatdVkey3(String catdVkey3) {
		this.catdVkey3 = catdVkey3;
	}
	
	 /**
	   * <strong>catd_vkey4 character varying</strong><br>
	   * COLUMNA  OPCIONAL 4
	   */
	public String getCatdVkey4() {
		return catdVkey4;
	}
	
	 /**
	   * <strong>catd_vkey4 character varying</strong><br>
	   * COLUMNA  OPCIONAL 4
	   */
	public void setCatdVkey4(String catdVkey4) {
		this.catdVkey4 = catdVkey4;
	}
	
	 /**
	   * <strong>catd_vkey5 character varying</strong><br>
	   * COLUMNA  OPCIONAL 5
	   */
	public String getCatdVkey5() {
		return catdVkey5;
	}
	
	 /**
	   * <strong>catd_vkey5 character varying</strong><br>
	   * COLUMNA  OPCIONAL 5
	   */
	public void setCatdVkey5(String catdVkey5) {
		this.catdVkey5 = catdVkey5;
	}

	@Override
	public String toString() {
		return "TCatalogueDet [catdBident=" + catdBident + ", catdCident=" + catdCident + ", catdVdescription="
				+ catdVdescription + ", catdVshortname=" + catdVshortname + ", catdVsymbol=" + catdVsymbol
				+ ", catdBstate=" + catdBstate + ", cataBident=" + cataBident + ", catdVrelation=" + catdVrelation
				+ ", catdVkey1=" + catdVkey1 + ", catdVkey2=" + catdVkey2 + ", catdVkey3=" + catdVkey3 + ", catdVkey4="
				+ catdVkey4 + ", catdVkey5=" + catdVkey5 + "]";
	}

}