package crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Decoder {
    public static String getToDecoder(byte[] encoded, SecretKey key) throws Exception {
        return toDecoder(encoded, key);
    }

    static String toDecoder(byte[] encoded, SecretKey key) throws Exception {
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decryptCipher.doFinal(encoded);
        StringBuilder str = new StringBuilder();
        for (byte b : decryptedBytes) {
            str.append((char) b);
        }
        return str.toString();
    }
}
