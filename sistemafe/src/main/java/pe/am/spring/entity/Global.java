package pe.am.spring.entity;

public class Global {
    private static String cadenaConexion = "";
    private static String idEmpresa = "";

    public static String getCadenaConexion() {
        return cadenaConexion;
    }

    public static void setCadenaConexion(String cadenaConexion) {
        Global.cadenaConexion = cadenaConexion;
    }

	public static String getIdEmpresa() {
		return idEmpresa;
	}

	public static void setIdEmpresa(String idEmpresa) {
		Global.idEmpresa = idEmpresa;
	}

    
    
}