package pe.am.spring.entity;

/**
 * <strong>t_profile_module</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TProfileModulePut extends TProfileModule {

	/**
	 * <strong>profmod_bident bigint NOT NULL</strong><br>
	 * Id de la tabla
	 */
	@Override
	public Long getProfmodBident() {
		return super.getProfmodBident();
	}

	/**
	 * <strong>prof_bident bigint NOT NULL</strong><br>
	 * Id de la tabla de perfiles
	 */
	@Override
	public Long getProfBident() {
		return super.getProfBident();
	}

	/**
	 * <strong>moddet_bident bigint NOT NULL</strong><br>
	 * Id de la tabla de detalle del modulo
	 */
	@Override
	public Long getModdetBident() {
		return super.getModdetBident();
	}

}