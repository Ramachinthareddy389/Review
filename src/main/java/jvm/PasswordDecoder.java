package jvm;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;

public class PasswordDecoder {
    public PasswordDecoder() {

    }
    public static String passwordDecrypt(String encodedText) {
        String securityKey = "TheBestSecretKey";
        byte[] decValue = null;
        try {
            Key key = new SecretKeySpec(securityKey.getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(2, key);
            byte[] decodedValue = Base64.getDecoder().decode(encodedText);
            decValue = c.doFinal(decodedValue);
        } catch (InvalidKeyException var6) {
            System.out.println("Please Enter valid key of 16 bit length and Algorithm code of 3 bit length\n" + var6);
            var6.printStackTrace();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
        return new String(decValue);
    }
}


