package app;

import crypto.Decoder;
import crypto.Encoder;
import crypto.Key;
import javax.crypto.SecretKey;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение.");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        SecretKey key = Key.getKeyGen();
        byte[] encoded = Encoder.getToEncoder(text, key);
        String x = encoded.toString();
        System.out.println("Зашифрованный текст: " + x);
        System.out.println("Расшифрованный текст: " + Decoder.getToDecoder(encoded, key));
    }
}