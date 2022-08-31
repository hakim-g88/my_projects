package crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Key {
    public static SecretKey getKeyGen() throws NoSuchAlgorithmException {
        return keyGen();
    }

    private static SecretKey keyGen() throws NoSuchAlgorithmException {
        KeyGenerator kGen = KeyGenerator.getInstance("AES");
        kGen.init(128);
        SecretKey key = kGen.generateKey();
        return key;
    }
}
