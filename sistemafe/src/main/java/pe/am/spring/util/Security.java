/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.util;
  
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author azevallos
 */
public class Security {
    
        Map<String, String> DB = new HashMap<String, String>();
	public static final String SALT = "my-salt-text";
        
        public static void main(String args[]) {
		Security demo = new Security();
		demo.signup("john", "dummy123");

		// login should succeed.
		if (demo.validLogin("john", "dummy1234"))
			System.out.println("user login successfull.");

		// login should fail because of wrong password.
		if (demo.validLogin("john", "blahblah"))
			System.out.println("User login successfull.");
		else
			System.out.println("user login failed.");
	}
        
        public void signup(String username, String password) {
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		DB.put(username, hashedPassword);
	}
        public void validaruc(String username, String ruc) {
    		String saltedPassword = SALT + ruc;
    		String hashedPassword = saltedPassword;
    		DB.put(username, saltedPassword);
    	}
        
        public Boolean validLogin(String username, String password) {
		Boolean isAuthenticated = false;

		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);

		String storedPasswordHash = DB.get(username);
                //System.out.println("Pass BD : "+storedPasswordHash+" = "+hashedPassword);
		if(hashedPassword.equals(storedPasswordHash)){
			isAuthenticated = true;
		}else{
			isAuthenticated = false;
		}
		return isAuthenticated;
	}
        
        public static Boolean validarLogin(String passBD, String password) {
		Boolean isAuthenticated = false;
//        String saltedPassword = SALT + password; 
		String hashedPassword = generateHash(password);

                System.out.println("Pass BD : "+passBD+" = "+hashedPassword);
		if(hashedPassword.equals(passBD)){
			isAuthenticated = true;
		}else{
			isAuthenticated = false;
		}
		return isAuthenticated;
	}
        
        
        public static Boolean validarToken(String passUs, String usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    		Boolean isAuthenticated = false;

    		String hashedPassword = getSHA256(usuario);
            System.out.println("Usuario BD : "+passUs+" = "+hashedPassword);
    		if(hashedPassword.equals(passUs)){
    			isAuthenticated = true;
    		}else{
    			isAuthenticated = false;
    		}
    		return isAuthenticated;
    	}
        
        
        
        //GENERADOR DE TOKEN 
        public static String getSHA256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        	
        	System.out.println("El token input "+ input);
        	MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            byte[] mdbytes=md.digest();            
            for(int i =0; i < mdbytes.length;i++) {           
            	sb.append(Integer.toString((mdbytes[i] & 0xff)+0x100, 16).substring(1));            	
            }
    		return sb.toString();
    		
        }
        
        
        
        public static Boolean validarRuc(String rucBD, String ruc) {
    		Boolean isAuthenticated = false;
            String saltedPassword = ruc;
    		String hashruc = saltedPassword;

                    System.out.println("Ruc BD : "+rucBD+" = "+hashruc);
    		if(hashruc.equals(rucBD)){
    			isAuthenticated = true;
    		}else{
    			isAuthenticated = false;
    		}
    		return isAuthenticated;
    	}
        
        
        
        public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
        
}
