package first;

import org.apache.commons.codec.binary.Base64;

public class Encrypt {
public static byte[] encryptPass(String s)
{
	
	
	   //encoding  byte array into base 64
    byte[] encoded = Base64.encodeBase64(s.getBytes());     
  
    System.out.println("Original String: " + s );
    System.out.println("Base64 Encoded String : " + new String(encoded));
	return encoded;
}

public static String decryptPass(String s)
{
	 //decoding byte array into base64
    byte[] decoded = Base64.decodeBase64(new String(s));     
    String pass=new String(decoded);
   
	return pass;	
}
public static void main(String[] args) {
	decryptPass("cGluQ29kZUAyNjEwMDE=");
}
}
