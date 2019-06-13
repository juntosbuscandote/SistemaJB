/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.util;

/**
 *
 * @author USUARIO
 */
public class probar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte aa[]={1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0};
        PasswordHash a= new PasswordHash(aa);
        System.out.println(a.isHasError()+" - "+a.getSalt()+" - "+a.getHash());
        
        String aaa="1";
        boolean a1=(aaa.equals("1")) ?  true : false ;
        System.out.println(a1+"");
        
    }
    
}
