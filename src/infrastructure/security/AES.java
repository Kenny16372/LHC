package infrastructure.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AES implements IEncryption {
    public String encrypt(String data, String key) {
        String res;
        try {
            Cipher cipher2 = Cipher.getInstance("AES");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            cipher2.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher2.doFinal(data.getBytes());
            res = new String(encrypted);
        }
        catch (Exception e){
            System.out.println("Error encrypting data: ");
            e.printStackTrace();
            return null;
        }
        return res;
    }

    public String decrypt(String data, String key){
        String res;

        try {
            Cipher cipher2 = Cipher.getInstance("AES");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            cipher2.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] cipherData2 = cipher2.doFinal(data.getBytes());
            res = new String(cipherData2);
        }
        catch (Exception e){
            System.out.println("Error decrypting data: " + e);
            return null;
        }
        return res;
    }
}
