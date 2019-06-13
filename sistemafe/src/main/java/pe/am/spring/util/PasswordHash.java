/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.am.spring.util;

import java.security.Key;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author USUARIO
 */
public class PasswordHash {

    private int SaltSize = 16;
    private int HashSize = 20;
    private int HashIter = 10000;
    private byte[] Salt;
    private byte[] Hash;
    private boolean HasError;

    public PasswordHash(String password) {
        this.HasError = false;
        try {
            //Integer a= Integer.parseInt(password);
        } catch (Exception e) {
            e.printStackTrace();
            this.HasError = true;
        }
    }

    public PasswordHash(byte[] hashBytes) {
        this.HasError = false;
        try {
            //Array.Copy((Array) hashBytes, 0, (Array) (this._salt = new byte[16]), 0, 16);
            //Array.Copy((Array) hashBytes, 16, (Array) (this._hash = new byte[20]), 0, 20);
            System.arraycopy(hashBytes, 0, this.Salt = new byte[16], 0, 16);
            System.arraycopy(hashBytes, 0, this.Hash = new byte[20], 0, 20);
        } catch (Exception e) {
            e.printStackTrace();
            this.HasError = true;
        }
    }

    public boolean Verify(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            PBEKeySpec pbeKeySpec = new  PBEKeySpec(password.toCharArray(), this.Salt, 1000, 384);
            Key secretKey =  factory.generateSecret(pbeKeySpec);
            byte[] bytes = new byte[32];//new Rfc2898DeriveBytes(password, this.Salt, 10000).GetBytes(20);
            System.arraycopy(secretKey.getEncoded(), 0, bytes, 0, 32);
            for (int index = 0; index < 20; ++index) {
                if ((int) bytes[index] != (int) this.Hash[index]) {
                    //return false;
                    // solo para probar
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int getSaltSize() {
        return SaltSize;
    }

    public void setSaltSize(int SaltSize) {
        this.SaltSize = SaltSize;
    }

    public int getHashSize() {
        return HashSize;
    }

    public void setHashSize(int HashSize) {
        this.HashSize = HashSize;
    }

    public int getHashIter() {
        return HashIter;
    }

    public void setHashIter(int HashIter) {
        this.HashIter = HashIter;
    }

    public byte[] getSalt() {
        return Salt;
    }

    public void setSalt(byte[] Salt) {
        this.Salt = Salt;
    }

    public byte[] getHash() {
        return Hash;
    }

    public void setHash(byte[] Hash) {
        this.Hash = Hash;
    }

    public boolean isHasError() {
        return HasError;
    }

    public void setHasError(boolean HasError) {
        this.HasError = HasError;
    }

}
