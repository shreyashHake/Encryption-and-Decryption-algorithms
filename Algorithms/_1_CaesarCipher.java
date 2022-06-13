package com.company.ISC;

import java.util.Scanner;

public class _1_CaesarCipher2 {

    private static String encryption(String pt, int key) {
        String cipher = "";

        for (int i = 0; i < pt.length(); i++) {
            char ch = pt.charAt(i);
            if (Character.isUpperCase(ch)) {
                cipher += (char) ((ch + key - 65) % 26 + 65);
            } else {
                cipher += (char) ((ch + key - 97) % 26 + 97);
            }
        }

        return cipher;
    }

    private static String decryption(String ct, int key) {
        String plainText = "";

        for (int i = 0; i < ct.length(); i++) {
            char ch = ct.charAt(i);
            if (Character.isUpperCase(ch)) {
                plainText += (char) ((ch - key - 65) % 26 + 65);
            } else {
                plainText += (char) ((ch - key - 97) % 26 + 97);
            }
        }

        return plainText;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text : ");
        String pt = sc.nextLine();

        System.out.print("Enter the key : ");
        int key = sc.nextInt();

        String cipher = encryption(pt, key);
        System.out.println("Cipher text is : " + cipher);

        String plainText = decryption(cipher, key);
        System.out.println("Plain text is : " + plainText);
    }
}
