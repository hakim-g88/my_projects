package crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Encoder {
    public static byte[] getToEncoder(String text, SecretKey key) throws Exception {
        return toEncoder(text, key);
    }

    static byte[] toEncoder(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(text.getBytes());
        return bytes;
    }
}
