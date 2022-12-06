import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class prob4 {

    public static void main(String[] args) {
        
        // for every number 1 to high number
        for (int i = 0; i < 1630573; i++)
        {
            // if the input + bgvyzdsv gives ahash with 5 zeros at the start, retirn i 
            String hash = getMd5("bgvyzdsv" + Integer.toString(i));

            if (hash.substring(0,6).equals("000000"))
                System.out.println(i);
        }

        
    }
    
    
    public static String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
}
