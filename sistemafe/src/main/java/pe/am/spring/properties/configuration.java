package pe.am.spring.properties;

import java.io.IOException;
import java.util.Properties;

import com.microsoft.windowsazure.Configuration;

public class configuration {
	
	 Properties properties = null;
	 
	    /** Configuration nombre de archivo */
	    public final static String config_name_file = "Configuration.properties";
	 
	    /**driver de base de datos*/
	    public static String driver_database = "org.postgresql.Driver";
	   
	    /**ruta de base de datos*/
	    public static String basedatos = "uri";
	    
	    /** usuario de base de datos  */
	    public final static String userbasedatos = "db.username";
	    
	    /** Data base password */
	    public final static String pswdbasedatos = "db.password";
	    
	    /** micro servicio empresa */
	    public static String HostEmpresa = "EmpresaApp.java";
	 
	    /** microdervicio de comprobante de pago */
	    public static String HostVoucher = "ComprobanteelectronicoApp.java";
	 
	    
	    private configuration() {
	        this.properties = new Properties();
	        try {
	            properties.load(Configuration.class.getClassLoader().getResourceAsStream(config_name_file));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }//Configuration
	 
	    /**
	     * Implementando Singleton
	     *
	     * @return
	     */
	    public static Configuration getInstance() {
	        return ConfigurationHolder.INSTANCE;
	    }
	    private static class ConfigurationHolder {
	        private static final Configuration INSTANCE = new Configuration();
	    }
	 
	    /**
	     * Retorna la propiedad de configuración solicitada
	     *
	     * @param key
	     * @return
	     */
	    public String getProperty(String key) {
	        return this.properties.getProperty(key);
	    }//getProperty
	}
