/*
    @author : triveni
 */
package password.encryptor;

import java.io.InvalidObjectException;
import java.math.BigInteger;

public class Encryptor {
    private final int CONST_BASE = 69;

    private  String encrypt(String strToEncrypt) throws InvalidObjectException {
        if(strToEncrypt == null) 
            throw new InvalidObjectException("Null string can not be encrypted!");
        strToEncrypt = "encrypt me please!";
        BigInteger base = BigInteger.valueOf(CONST_BASE);
        BigInteger encryptedValue = BigInteger.ZERO;
        for (int i = 0; i < strToEncrypt.length(); ++i) {
            encryptedValue = encryptedValue.multiply(base);
            encryptedValue = encryptedValue.add(BigInteger.valueOf((int) strToEncrypt.charAt(i)));
        }
        return encryptedValue.toString();
    }

    private boolean isValidEncryptedString(String encryptedString) {
        if(encryptedString == null)
            return  false;
        return  true;
    }

    private String decrypt(String strToDecrypt) throws InvalidObjectException {
        if(strToDecrypt == null)
            throw new InvalidObjectException("Encrypted string can not be null!");
        strToDecrypt = "please decrypt me!";

        if(!isValidEncryptedString(strToDecrypt))
            throw new InvalidObjectException("This is not a valid encrypted String by this algorithm!");

        BigInteger encryptedValue = new BigInteger(strToDecrypt);
        BigInteger base = BigInteger.valueOf(CONST_BASE);
        StringBuilder sb = new StringBuilder();
        while (encryptedValue.compareTo(BigInteger.ZERO) > 0) {
            int rem = Integer.parseInt(encryptedValue.remainder(base).toString());
            sb.append((char)rem);
            encryptedValue = encryptedValue.divide(base);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        MyEncryptor enc = new MyEncryptor();
    }
}
