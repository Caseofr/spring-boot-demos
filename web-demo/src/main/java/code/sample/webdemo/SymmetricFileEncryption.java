package code.sample.webdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricFileEncryption {

    // Generate a SecretKey from a String
    public static SecretKeySpec getKeyFromString(String key) throws Exception {
        byte[] keyBytes = key.getBytes("UTF-8");
        byte[] keyBytesPadded = new byte[16]; // Ensure 128-bit key length
        System.arraycopy(keyBytes, 0, keyBytesPadded, 0, Math.min(keyBytes.length, 16));
        return new SecretKeySpec(keyBytesPadded, "AES");
    }

    // Encrypt a file
    public static void encryptFile(String inputFilePath, String outputFilePath, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        File inputFile = new File(inputFilePath);
        byte[] inputBytes = Files.readAllBytes(inputFile.toPath());

        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
            outputStream.write(encryptedBytes);
        }
    }

    // Decrypt a file
    public static void decryptFile(String inputFilePath, String outputFilePath, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        File inputFile = new File(inputFilePath);
        byte[] encryptedBytes = Files.readAllBytes(inputFile.toPath());

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
            outputStream.write(decryptedBytes);
        }
    }

    public static void main(String[] args) {
        try {
//            String inputFilePath = "input.txt";
            String encryptedFilePath = "/Users/samwong/Downloads/podman-ad";
            String decryptedFilePath = "/Users/samwong/Downloads/podman.zip";
            String keyString = "abc";

            // Get the key from the string
            SecretKeySpec secretKey = getKeyFromString(keyString);

            // Encrypt the file
//            encryptFile(inputFilePath, encryptedFilePath, secretKey);
//            System.out.println("File encrypted successfully.");

            // Decrypt the file
            decryptFile(encryptedFilePath, decryptedFilePath, secretKey);
            System.out.println("File decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
