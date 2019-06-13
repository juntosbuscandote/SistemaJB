/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.am.spring.controller.HomeController;
import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.PaginacionFiltro;
import pe.am.spring.entity.ServiceLogicException;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserGet;
import pe.am.spring.model.PaginaResultado;
import pe.am.spring.rest.TUserRest;

/**
 *
 * @author User
 */
public class Util {
	
	protected static Logger logger = Logger.getLogger(Util.class);
	
    public static String getHostEmpresa() { 
        return getConfiguration("host.empresa");
    }
    public static String getHostVoucher() {
    	return getConfiguration("host.voucher");
    }
    
    public static String getHostPerson() {
    	return getConfiguration("host.persona");
    }
    
    public static String getHostUser() {
    	return getConfiguration("host.usuario");
    }
    
    public static String getHostCatalogue() {
    	return getConfiguration("host.catalgue");
    }
    
    public static String getHostStore() {
    	return getConfiguration("host.store");
    }
    
    public static String getHostVentas() {
    	return getConfiguration("host.ventas");
    }
    
    // ruta de la configuracion del facturador 
    public static String getHostFacturadorElec() { 
        return getConfiguration("host.facturador");
    }
    
    public static String getconsultarSunat() { 
        return getConfiguration("host.sunat");
    }
    
    public static String getconsultarEmpresas() { 
        return getConfiguration("empresas");
    }
    
    public static String getconsultarDni() { 
        return getConfiguration("consultarDni");
    }
    
    public static  BeanDS getcadenaConexion2() { 
    	String user=getConfiguration("dabatase_user");
    	String pass=getConfiguration("dabatase_pass");
    	String url=getConfiguration("database_url");
    	String id=getConfiguration("id");
    	if(user==null && pass==null && url==null){
    		return null;
    	}
    	BeanDS beanDS =new BeanDS();
    	beanDS.setUser(user);
    	beanDS.setPass(pass);
    	beanDS.setUrl(url);
    	beanDS.setId(id);
        return beanDS;
    }
    
    public static  BeanDS getcadenaConexion(String empresa) { 
    	String id=getConfiguration("id."+empresa);
    	String user=getConfiguration("usuario."+empresa);
    	String pass=getConfiguration("pass."+empresa);
    	String url=getConfiguration("url."+empresa);
    	if(user==null && pass==null && url==null){
    		return null;
    	}
    	BeanDS beanDS =new BeanDS();
    	beanDS.setId(id);
    	beanDS.setUser(user);
    	beanDS.setPass(pass);
    	beanDS.setUrl(url);
        return beanDS;
    }
    
    public static String getConfiguration(String property) {
        Properties prop = new Properties();
        InputStream input = null;
        String path = "";
        File child = new File(System.getProperty("catalina.home")+"/configuration.properties");
        String resultPath = "";
        try {
            path = child.getCanonicalPath();
            input = new FileInputStream(path);
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            resultPath = prop.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultPath;
    }  
    
    public static String getRutaMasiva() {
        String resultPath="";
        resultPath=System.getProperty("catalina.home")+"/webapps/";
        return resultPath;
    }  
    
    public static Date stringtoDate(String fecha) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = fecha;

		try {

			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
    
    public static Date stringtoDate2(String fecha) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = fecha;

		try {

			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

    
    public static String  datetoString(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoString2(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoString3(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("MM-dd-yyyy");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoString4(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("dd-MM-yyyy");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoString5(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoStringSoloanio(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("yyyy");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static String  datetoStringGlobal(Date fecha,String formato) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat(formato);
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    public static Date StringtoDate(String Fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dfecha = null;
		try {
			dfecha = sdf.parse(Fecha);
		} catch (ParseException e) {
			dfecha = null;
		}
		return dfecha;
	}
    
    public static Date StringtoDateDMA(String Fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dfecha = null;
		try {
			dfecha = sdf.parse(Fecha);
		} catch (ParseException e) {
			dfecha = null;
		}
		return dfecha;
	}
    
    public static Date StringtoDateFrom(String Fecha) {
 		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
 		Date dfecha = null;
 		try {
 			dfecha = sdf.parse(Fecha);
 		} catch (ParseException e) {
 			dfecha = null;
 		}
 		return dfecha;
 	}
    
    public static Date  datetoString6(String fecha) {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Date dfecha = null;
 		 
 		try {
 			dfecha = formatter.parse(fecha);
 		} catch (ParseException e) {
 			dfecha = null;
 		}
 		return dfecha;
    }
    
    
    
    public static String  datetoString7(Date fecha) {
    	String s="";
    	try {
    	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	s = formatter.format(fecha);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    	return s;
    }
    
    
    public static Date  datetoString8(String fecha) {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy,HH:mm:ss");
 		Date dfecha = null;
// 		DD-MM-YYYY,h:mm
 		  try {

 			 dfecha = formatter.parse(fecha);
 	            System.out.println(dfecha);
 	            System.out.println(formatter.format(dfecha));

 	        } catch (ParseException e) {
 	            e.printStackTrace();
 	        }
 		return dfecha;
    }
    
    public static String  StrDecStr(String nro) {
    	String numero="";
    	double nroaux;
    	try {
    		if (nro!=null&&!nro.equals("0")&&!nro.equals("0.0")&&!nro.equals("0.00")) {
    			
    			nroaux = Double.parseDouble(nro);
        		
        		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    			simbolos.setDecimalSeparator('.');
    			DecimalFormat df = new DecimalFormat("#.00", simbolos);
    			numero = String.valueOf(df.format(nroaux));
    			
    		} else {
    			
    			numero = "0";
    			
    		}
    		
    	
    	}catch(Exception e){
     		e.printStackTrace();
    		return "";
    	}
    	return numero;
    }
    
    public static String  DecStr(BigDecimal nro) {
    	String numero="";
    	try {
    		
    		if (nro!=null && !nro.equals(BigDecimal.ZERO)) {
    		    		
    		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.00", simbolos);
			numero = String.valueOf(df.format(nro));
			
    		} else {
    			
    			numero = "0";
    			
    		}
    	
    	}catch(Exception e){
     		e.printStackTrace();
    		return "";
    	}
    	return numero;
    }
    
    public static String  DecStrGrilla(BigDecimal nro) {
    	String numero="";
    	try {
    		
    		if (nro.compareTo(BigDecimal.ZERO)== 0) {
    			
    			numero = "0.00";

    		} else {
    			
    			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    			simbolos.setDecimalSeparator('.');
    			simbolos.setGroupingSeparator(',');
    			DecimalFormat df = new DecimalFormat("###,###.00", simbolos);
    			numero = String.valueOf(df.format(nro));
    			
    		}
    	
    	}catch(Exception e){
     		e.printStackTrace();
    		return "";
    	}
    	return numero;
    }
    
    public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
    
 
    public static String generarBodyCorreo(String ClienteNombre,
								    		String docuFecha,
								    		String emprNombre,
								    		String nroRucEmisor,
								    		String tipoDocEl,
								    		String nroDoc,
								    		String total,String texto) {
		String html = texto;

		try {

			html=html.replaceAll("<VAR_NOMBRE_CLIENTE>", ClienteNombre)
					.replaceAll("<VAR_FECHA_EMISION>", docuFecha)
					.replaceAll("<VAR_EMPR_RUC>", nroRucEmisor)
					.replaceAll("<VAR_NOMBRE_COMERCIAL>",  emprNombre)
					.replaceAll("<VAR_TIPO_DOC>", tipoDocEl)
					.replaceAll("<VAR_SERIE_DOC>-<VAR_NRO_DOC>", nroDoc)
					.replaceAll("<VAR_TOTAL_DOC>",total);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return html;
	}
    
    
	public static String getRutaInicial() {
		return "D:/DocElectr";
	}

	public static String getRutaFinal() {
		return "";
	}
	
	public static String encode(String nombreFile) throws IOException {
		File file = new File(nombreFile);
		byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		String a = new String(encoded, StandardCharsets.US_ASCII);
		return a;
	}
	public static String  getUrlMC() {
		return getConfiguration("host.util");
	}
    
	public static boolean tienePermiso(Long idRol,String uri) {
		boolean permiso=false;
		if(idRol.equals(1L)) {
			//solo puede ver usuario y comprobante
			if(uri.equals(Constantes.uris.USUARIO.getCode()) || uri.equals(Constantes.uris.COMPROBANTE.getCode())) {
				permiso=true;
			}else {
				permiso=false;
			}
		}else if(idRol.equals(2L)) {
			//solo puede ver comprobante
			if(uri.equals(Constantes.uris.COMPROBANTE.getCode())) {
				permiso=true;
			}else {
				permiso=false;
			}
		}else if(idRol.equals(3L)) {
			//es admin
			permiso=true;
		}else {
			permiso=false;
		}
		return permiso;
	}
	
	//ruta para los pdf que se adjunatarn
	public static String getRutaWelcomePack() {
		return "D:/WelcomePack/";
	}
	
	public static String dateToString(Date Fecha) {
		String result = "";
		if (Fecha != null) {
			DateFormat fechaHora = new SimpleDateFormat("dd/MM/yyyy");
			result = fechaHora.format(Fecha);
		}
		return result;
	}
	
	public static String TimeToString(Date Fecha) {
		String result = "";
		if (Fecha != null) {
			DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss");
			result = fechaHora.format(Fecha);
		}
		return result;
	}
	
	public static String dateToStringFormarReport() {
		String result = "";
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd_hh_mm");
		result = fechaHora.format(new Date());
		return result;
	}

	public static String formatMoney(BigDecimal num) {

		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		dfs.setDecimalSeparator('.');
		
		if(null!=num && num.doubleValue()>0){
			num = num.setScale(2, BigDecimal.ROUND_HALF_UP);
			DecimalFormat df = new DecimalFormat("###,##0.00");
			df.setDecimalFormatSymbols(dfs);
			return df.format(num);
		}else{
			return "0.00";
		}

	}
	
	public static BigDecimal roundMoney(BigDecimal num) {
		if(null!=num){
			num = num.setScale(2, BigDecimal.ROUND_HALF_UP);
			return num;
		}else{
			return new BigDecimal(0.00);
		}

	}
	
	public static String formatoMoneda(BigDecimal monto) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.##", simbolos);
		return df.format(monto);
	}
	
	public static boolean validAcceso(HttpSession ses,String url) {
		
		List<String> permisos=(List<String>) ses.getAttribute(Constantes.MENU_PERMISOS);
		boolean rpta= false;
		try {
			if(null!=permisos) {
				for(String perm : permisos) {
					perm=perm.replace("..", "");
					logger.info("menu: "+perm);
					System.out.println("menu: "+perm);
					if(url.equals(perm)) {
						return true;
					}
				}
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		return rpta;
	}
	
}