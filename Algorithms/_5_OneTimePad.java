package com.company.ISC;

import java.util.Random;
import java.util.Scanner;

public class _5_OneTimePad {

    private static String encrypt(String plain, String key) {
        String cipherText = "";
        int[] cipher = new int[plain.length()];

        for (int i = 0; i < plain.length(); i++) {
            cipher[i] = ((plain.charAt(i) - 'a') + (key.charAt(i) - 'a')) % 26;
        }

        for (int i = 0; i < plain.length(); i++) {
            cipherText += (char) (cipher[i] + 'a');
        }

        return cipherText;
    }

    private static String decrypt(String cipher, String key) {
        String plainText = "";
        int[] plain = new int[cipher.length()];

        for (int i = 0; i < cipher.length(); i++) {
            int val = ((cipher.charAt(i) - 'a') - (key.charAt(i) - 'a'));
            if (val < 0) plain[i] = 26 + val;
            else plain[i] = val;
        }

        for (int i : plain) {
            plainText += (char) (i + 'a');
        }

        return plainText;
    }

    // Generating the key :
    private static String getKey(String pt) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        String key = "";

        for (int i = 0; i < pt.length(); i++) key += chars.charAt(rnd.nextInt(26));

        return key;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text : ");
        String pt = sc.nextLine();

        String key = getKey(pt);

        System.out.println("Randomly generated key is : " + key);

        String cipher = encrypt(pt, key);
        System.out.println("Encrypted text is : " + cipher);

        String plain = decrypt(cipher, key);
        System.out.println("Decrypted text is : " + plain);
    }
}
