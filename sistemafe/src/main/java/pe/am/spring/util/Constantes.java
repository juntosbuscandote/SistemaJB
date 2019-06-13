/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.util;

/**
 *
 * @author azevallos
 */
public class Constantes {
    
    public static final String SESION_USUARIO     = "usuario";
    public static final String SESION_ROLE     = "role";
    public static final String SESION_EMPLEADO     = "empleado";
    public static final String SESION_USUARIO_FILTER     = "usuarioFilter";
    public static final String SESION_TIPO_CAMBIO     = "flag_tc";
    public static final String SESION_USUARIO_DETAIL  = "sesion_usuario_detail";
    public static final String SESION_EMPRESA  = "empresa";
    public static final String MENU_USUARIO  = "menu";
    public static final String MENU_PERMISOS  = "permisos";
    
    public static final String ID_PERSIL_SYS  = "4";
    public static final String ID_PERSIL_ADMIN  = "3";
    
    public static final String RUTA_FILES_SUNAT_EMPRESA_INI     = "D:/DocElectr/";
    public static final String RUTA_FILES_SUNAT_EMPRESA_FIN     = "docGenerados";
    
    public static final String RUTA_FILES_VENTA_EMPRESA_INI     = "D:/Voucher/";
    public static final String RUTA_FILES_VENTA_EMPRESA_FIN     = "generados";
    
    public static final String EMPLOYEE_VPOSITION_RL= "REPRESENTANTE LEGAL";
    
    
    public static final String COD_INV="INV";
    public static final String LOGO_EXCEL="LOGO_EXCEL";
    public static final String TEMP_EXCEL_VENTA="TEMP_EXCEL_VENTA";
    public static final String TEMP_EXCEL_COMPRAS="TEMP_EXCEL_COMPRAS";
    public static final String TEMP_EXCEL_CUENTAS="TEMP_EXCEL_CUENTAS";
    
    public enum tipoCE {
        NOTADEBITO  (3), 
        NOTACREDITO (2), 
        FACTURA   (1)  
        ; 
        private final int idCE;

        private tipoCE(int idCE) {
            this.idCE = idCE;
        }
    }
    
    public enum tipoRol {
        ADMIN  (3L), 
        USER_FINAL (2L), 
        USER_EMPRESA   (1L)  
        ; 
        private final Long idCE;

        private tipoRol(Long idCE) {
            this.idCE = idCE;
        }
        public Long getCode() {
			return idCE;
		}
    }
    
    public enum uris {
        COMPROBANTE  ("C"), 
        USUARIO ("U"), 
        EMPRESA   ("E")  
        ; 
        private final String idCE;

        private uris(String idCE) {
            this.idCE = idCE;
        }
        
        public String getCode() {
			return idCE;
		}
    }
    
    public enum TIPO_MONEDA {
    	DOLAR ("USD"),
    	SOL ("PEN"),
        EURO  ("EUR"), 
        YEN ("JPY");
    	
        private final String idTM;

        private TIPO_MONEDA(String idTM) {
            this.idTM = idTM;
        }
        
        public String getCode() {
			return idTM;
		}
    }

    
    //archivos para welcome pack SI HAY MAS AGREGAR AL ENUM
    public enum archivosWP {
    	CARTABIENVENIDA ("CartaDeBienvenida.pdf"),
    	MANUALACCESO ("manualDeAcceso.pdf"),
        MANUALPERFILUSUARIOEMPRESA  ("manualUuario_PerfilUsuarioEmp.pdf"), 
        MANUALPERFILUSUARIOFINAL ("manualUsuario_PerfilUsuarioFinal.pdf") 
          
        ; 
        private final String idWP;

        private archivosWP(String idWP) {
            this.idWP = idWP;
        }
        
        public String getCode() {
			return idWP;
		}
    }
    
    public enum ESTADO_VENTA {
        COTIZACION  ("C"), 
        ORDEN_PEDIDO ("OP"),
        VENTA ("V"),
        GUIA   ("G"); 
    	
        private final String idCE;

        private ESTADO_VENTA(String idCE) {
            this.idCE = idCE;
        }
        
        public String getCode() {
			return idCE;
		}
    }
    
    public enum indicador_ia {
    	GRAVADA ("10"),
    	EXONERADO ("20"),
        INAFECTO  ("30"), 
        EXPORTACION ("40") ,
        GRATUITAS ("50")           
        ; 
        private final String idIA;

        private indicador_ia(String idIA) {
            this.idIA = idIA;
        }
        
        public String getCode() {
			return idIA;
		}
    }
    
    public enum tiposGravada {
    	GRAVADA_OPERACION_ONEROSA ("10"),
    	GRAVADA_RETIRO_POR_PREMIO ("11"),
    	GRAVADA_RETIRO_POR_DONACION  ("12"), 
        GRAVADA_RETIRO ("13") ,
        GRAVADA_RETIRO_POR_PUBLICIDAD ("14"),
        GRAVADA_BONIFICACIONES ("15"),
        GRAVADA_RETIRO_POR_ENTREGA_A_TRABAJADORES ("16");
    	
        private final String idTIA;

        private tiposGravada(String idTIA) {
            this.idTIA = idTIA;
        }
        
        public String getCode() {
			return idTIA;
		}
    }
    
    public enum tiposExonerada {
    	EXONERADA_OPERACION_ONEROSA ("20");

        private final String idTE;

        private tiposExonerada(String idTE) {
            this.idTE = idTE;
        }
        
        public String getCode() {
			return idTE;
		}
    }
    
    public enum tiposInafecto {
    	INAFECTO_OPERACION_ONEROSA ("30"),
    	INAFECTO_RETIRO_POR_BONIFICACION ("31"),
    	INAFECTO_RETIRO ("32"),
    	INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS ("33"),
    	INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO ("34"),
    	INAFECTO_RETIRO_POR_PREMIO ("35"),
    	INAFECTO_RETIRO_POR_PUBLICIDAD ("36"),;

        private final String idTInaf;

        private tiposInafecto(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum tiposExportacion {
    	EXPORTACION ("40");

        private final String idTEX;

        private tiposExportacion(String idTEX) {
            this.idTEX = idTEX;
        }
        
        public String getCode() {
			return idTEX;
		}
    }
 
    
    public enum flagInventarioIO {
    	ENTRADA ("1"),
    	SALIDA ("0");

        private final String idTInaf;

        private flagInventarioIO(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagInventarioEstado {
    	ACTIVO ("1"),
    	INACTIVO ("0");

        private final String idTInaf;

        private flagInventarioEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    
    public enum flagCierreCajaEstado {
    	ACTIVO ("1"),
    	INACTIVO ("0");

        private final String idTInaf;

        private flagCierreCajaEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum CATAMONEDA {

    	SOLES ("1"),
    	DOLARES ("0");


        private final String id;

        private CATAMONEDA(String id) {
            this.id = id;

        }
        
        public String getCode() {
			return id;
		}
    }
    
    public enum flagVentaEstado {
    	ACTIVO ("0"),
    	ANULADO ("1"),
    	BAJA ("2");

        private final String idTInaf;

        private flagVentaEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagCompraEstado {
    	ACTIVO ("0"),
    	INACTIVO ("1");

        private final String idTInaf;

        private flagCompraEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagDetalleEstado {
    	ACTIVO ("0"),
    	INACTIVO ("1");

        private final String idTInaf;

        private flagDetalleEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagNotaEstado {
    	ACTIVO ("0"),
    	INACTIVO ("1");

        private final String idTInaf;

        private flagNotaEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum tipoRegistro {
    	VENTA ("0"),
    	COMPRA ("1");

        private final String idTInaf;

        private tipoRegistro(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public static enum TIPO_CELDA_POI{
    	TEXTO("TEXTO"),
    	NUMERICO("NUMERICO"),
    	DECIMAL("DECIMAL"),
    	FECHA("FECHA"),
        FORMULA("FORMULA");
        
        private String texto;
        
        private TIPO_CELDA_POI(String texto){
            this.texto = texto;
        }

		public String getTexto(){
        	return this.texto;
        }
        
    }
    

    public enum estadoGC {
        HABILITADO  ("1"), 
        INHABILITADO ("0")
        ; 
        private final String idEGC;

        private estadoGC(String idEGC) {
            this.idEGC = idEGC;
        }
        
        public String getCode() {
			return idEGC;
		}
    }
    
    public enum estadoModulos {
        HABILITADO  ("1"), 
        INHABILITADO ("0")
        ; 
        private final String idEGC;

        private estadoModulos(String idEGC) {
            this.idEGC = idEGC;
        }
        
        public String getCode() {
			return idEGC;
		}
    }
    
    public enum estadoEmpresa {
        ACTIVO  ("1"), 
        INACTIVO ("2")
        ; 
        private final String idEE;

        private estadoEmpresa(String idEE) {
            this.idEE = idEE;
        }
        
        public String getCode() {
			return idEE;
		}
    }
    
    public enum estadoPerfil {
        HABILITADO  ("1"), 
        INHABILITADO ("0")
        ; 
        private final String idEP;

        private estadoPerfil(String idEP) {
            this.idEP = idEP;
        }
        
        public String getCode() {
			return idEP;
		}
    }
    
    public enum estadoSucursales {
        HABILITADO  ("1"), 
        INHABILITADO ("2")
        ; 
        private final String idEGC;

        private estadoSucursales(String idEGC) {
            this.idEGC = idEGC;
        }
        
        public String getCode() {
			return idEGC;
		}
    }
    
    public enum estadoSerie {
        ACTIVO  ("1"), 
        INACTIVO ("2"); 
        private final String idSer;

        private estadoSerie(String idSer) {
            this.idSer = idSer;
        }
        
        public String getCode() {
			return idSer;
		}
    }

 public enum estadoCaja {
        ACTIVO  ("1"), 
        INACTIVO ("0"); 
        private final String idCaj;

        private estadoCaja(String idCaj) {
            this.idCaj = idCaj;
        }
        
        public String getCode() {
			return idCaj;
		}
    }
    
    public enum flagSucursalxUsuarioEstado {
    	ACTIVO ("1"),
    	INACTIVO ("0");

        private final String idTInaf;

        private flagSucursalxUsuarioEstado(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    
    public enum flagInventarioTrx {
    	AFECTA ("1"),
    	APILA ("0");

        private final String idTInaf;

        private flagInventarioTrx(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagMovimiento {
    	ACTIVO ("1"),
    	INACTIVO ("0");

        private final String idTInaf;

        private flagMovimiento(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagItem {
    	SERVICIO ("1"),
    	PRODUCTO ("0");

        private final String idTInaf;

        private flagItem(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagCuentasPagar {
    	ACTIVO ("0"),
    	INACTIVO ("1");

        private final String idTInaf;

        private flagCuentasPagar(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    public enum flagCuentasCobrar {
    	ACTIVO ("0"),
    	INACTIVO ("1");

        private final String idTInaf;

        private flagCuentasCobrar(String idTInaf) {
            this.idTInaf = idTInaf;
        }
        
        public String getCode() {
			return idTInaf;
		}
    }
    
    
    public enum RPTA_PROCESO_SUNAT {
    	OK_SUNAT ("0");
        private final String idProc;

        private RPTA_PROCESO_SUNAT(String idProc) {
            this.idProc = idProc;
        }
        
        public String getCode() {
			return idProc;
		}
    }
    
    
    public enum RPTA_SUNAT {
    	ACEPTADO ("0"),
    	RECHAZADO ("-1"),
    	NOENVIADO ("3");
    	
        private final String estadoSunat;

        private RPTA_SUNAT(String estadoSunat) {
            this.estadoSunat = estadoSunat;
        }
        
        public String getCode() {
			return estadoSunat;
		}
    }
    
}
    



