package com.juaracoding.CobaSiloam.core;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class AESGeneratedKey {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Tambahkan Bouncy Castle Provider
        Security.addProvider(new BouncyCastleProvider());
//        java -DDB_USR=fb197a1427f46c1e47b3e890659709b3 -DDB_PWD=d5a93ddf6190563dee463f94f268bbbf
//        -DDB_URL=jdbc:h2:C:/data/sqa -DSERVER_PORT=8095 -jar ujian-selenium.jar

        try {
            // Inisialisasi generator kunci AES dengan Bouncy Castle
            KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");

            // Atur panjang kunci (misalnya: 128, 192, atau 256 bit)
            keyGen.init(256);

            // Generate kunci AES
            SecretKey aesKey = keyGen.generateKey();
            System.out.println(aesKey);
            // Tampilkan kunci AES
            System.out.println("AES Key: " + bytesToHex(aesKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method untuk mengubah byte array menjadi string heksadesimal
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
// basic auth
// username : automation
// passowrd : Auto@4321

// basic auth
// username : auto2000
// passowrd : Mation@4321

    //user-db : root1 -> 098uhgiouehtroij
    //pwd-db : root2

    //Algorithm Encryption Standard
//    proses enkripsi
// root1 -> a3dd1c82e80130029846965f98cb0a6a6c0d3b675625ef134c6c3b459616ee3c -> 98ry9h345uijhoij1o3ji
// 98ry9h345uijhoij1o3ji -> a3dd1c82e80130029846965f98cb0a6a6c0d3b675625ef134c6c3b459616ee3c -> root1
}