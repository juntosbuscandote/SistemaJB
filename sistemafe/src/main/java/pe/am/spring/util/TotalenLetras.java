package pe.am.spring.util;

import java.security.Key;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author USUARIO
 */
public class TotalenLetras {

	  private final static String[] Unidades = {
		        "","","DOS ","TRES ","CUATRO ","CINCO ","SEIS ","SIETE ","OCHO ","NUEVE "
		    };
		    private final static String[] Decenas = {
		        "DIEZ ","ONCE ","DOCE ","TRECE","CATORCE","QUINCE","DIECISEIS","DIECISIETE ","DIECIOCHO ","DIECINUEVE ",
		        "VEINTE ","TREINTA ","CUARENTA ","CINCUENTA ","SESENTA ","SETENTA ","OCHENTA ","NOVENTA "
		    };
		    private final static String[] Centenas ={
		        "","CIENTO ","DOSCIENTOS ","TRESCIENTOS ","CUATROCIENTOS ","QUINIENTOS ","SEISCIENTOS ","SETECIENTOS ",
		        "OCHOCIENTOS ","NOVECIENTOS "
		    };
		    
		    public TotalenLetras(){
		        
		    }
		    
		    
		    public static String Convertir(String numero,boolean mayusculas){
		        String literal="";
		        String parte_decimal;
		        numero = numero.replace(".",",");
		        if (numero.indexOf(",")==-1) {
		            numero = numero + ",00";
		        }
		        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
		           String Num[] = numero.split(",");
		           parte_decimal = Num[1]+"/100"
		                   + "";
		            if (Integer.parseInt(Num[0])==0) {
		                literal = "CERO ";
		            }else if (Integer.parseInt(Num[0])>999999){
		                literal = getMillones(Num[0]);
		            }else if (Integer.parseInt(Num[0])>999){
		                literal=getMiles(Num[0]);
		            }else if (Integer.parseInt(Num[0])>99){
		                literal = getCentenas(Num[0]);
		            }else if (Integer.parseInt(Num[0])>9){
		                literal = getDecenas(Num[0]);
		            }else {
		                literal = getUnidades(Num[0]);
		            }
		            if(mayusculas){
		                return (literal + parte_decimal).toUpperCase();
		            }else{
		                return (literal + parte_decimal);
		            }
		        }else{
		            return literal= null;
		        }
		    }
		    
		    private static String getUnidades(String numero){
		        String num = numero.substring(numero.length()-1);
		        return Unidades[Integer.parseInt(num)];
		    }
		    private static String getDecenas(String num){
		        int n = Integer.parseInt(num);
		        if(n<10){
		            return getUnidades(num);
		        }else if (n> 19){
		            String u= getUnidades(num);
		        if(u.equals("")){
		            return Decenas[Integer.parseInt(num.substring(0,1))+8];
		        }else {
		            return Decenas[Integer.parseInt(num.substring(0,1))+ 8] + "y "+ u;
		        }
		        
		        }
		        else {
		            return Decenas [n - 10];
		        }
		    }
		    
		    private static String getCentenas(String num){
		        if(Integer.parseInt(num)>99){
		            if(Integer.parseInt(num)==100){
		                return " CIEN ";
		            }else{
		                return Centenas[Integer.parseInt(num.substring(0,1))]+getDecenas(num.substring(1));
		            }
		        } else {
		            return getDecenas(Integer.parseInt(num)+"");
		        }
		    }
		    
		   private static String getMiles(String numero){
		       String c = numero.substring(numero.length() - 3 );
		       String m = numero.substring(0, numero.length() - 3);
		       String n="";
		       if(Integer.parseInt(m)> 0){
		           n = getCentenas(m);
		           return n + "MIL "+ getCentenas(c);
		       }else{
		           return "" + getCentenas(c);
		       }
		               
		   }
		    
		   private static String getMillones(String numero){
		       String miles = numero.substring(numero.length() - 6);
		       String millon = numero.substring(0, numero.length() - 6);
		       String n ="";
		       if(millon.length()>1){
		           n = getCentenas(millon)+ "MILLONES ";
		       }else {
		           n = getUnidades(millon) + "MILLON ";
		       }
		       return n + getMiles(miles);
		   }

}
