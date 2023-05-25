package encryption;

import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EncryptionUtil {

	private static String key = "Jar12345Jar12345";

	public static EncryptedData encrypt(String value) {
	    try {
	        SecureRandom random = new SecureRandom();
	        byte[] ivBytes = new byte[16];
	        random.nextBytes(ivBytes);
	        String ivString = Base64.getEncoder().encodeToString(ivBytes);

	        IvParameterSpec iv = new IvParameterSpec(ivBytes);
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	        byte[] encrypted = cipher.doFinal(value.getBytes());

	        EncryptedData encryptedData = new EncryptedData();
	        encryptedData.setEncryptedValue(Base64.getEncoder().encodeToString(encrypted));
	      
	        encryptedData.setInitializationVector(ivString);

	        return encryptedData;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}


	public static String decrypt(String encryptedDataString, String key) {
	    try {
	        String combinedData = encryptedDataString;
	        String[] parts = combinedData.split("==");
	        System.out.println("combinedData: " + combinedData);
	        byte[] iv = Base64.getDecoder().decode(parts[0] + "==");
	        byte[] encryptedValue = Base64.getDecoder().decode(parts[1]);
	        System.out.println("iv: " + Arrays.toString(iv));
	        System.out.println("encryptedValue: " + Arrays.toString(encryptedValue));

	        if (iv.length < 16) {
	            byte[] paddedIV = new byte[16];
	            System.arraycopy(iv, 0, paddedIV, 0, iv.length);
	            iv = paddedIV;
	            System.out.println("IVPadded: " + Arrays.toString(iv));
	        }

	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	        System.out.println("Key: " + skeySpec);
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));

	        byte[] original = cipher.doFinal(encryptedValue);

	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}


    public static class EncryptedData {
        private String encryptedValue;
        private String initializationVector;

        public String getEncryptedValue() {
            return encryptedValue;
        }

        public void setEncryptedValue(String encryptedValue) {
            this.encryptedValue = encryptedValue;
        }

        public String getInitializationVector() {
            return initializationVector;
        }

        public void setInitializationVector(String initializationVector) {
            this.initializationVector = initializationVector;
        }
        
    }
}
