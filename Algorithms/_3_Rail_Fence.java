package com.company.ISC;

import java.util.Scanner;

public class _3_Rail_Fence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text : ");
        String pt = sc.nextLine();

        System.out.print("Enter the key : ");
        int key = sc.nextInt();

        String en = encryption(pt, key);
        System.out.println("Encrypted text is : " + en);

        String dn = decryption(en, key);
        System.out.println("Decrypted text is : " + dn);

    }

    private static String encryption(String plain, int key) {
        String encryptedText = "";
        int col = plain.length();
        int row = key;
        boolean check = false;
        int j = 0;
        char[][] rail = new char[row][col];

        //to fill the array:
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) rail[i][k] = '*';
        }

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) check = !check;
            rail[j][i] = plain.charAt(i);

            if (check) j++;
            else j--;
        }

        System.out.println("Rail of encryption : ");
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                char ch = rail[i][k];
                if (ch != '*') encryptedText += rail[i][k];
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        return encryptedText;
    }

    private static String decryption(String encrypted, int key) {
        String decryptedText = "";

        int col = encrypted.length();
        int row = key;
        boolean check = false;
        int j = 0;
        char[][] rail = new char[row][col];

        //to fill the array:
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) rail[i][k] = '*';
        }

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) check = !check;
            rail[j][i] = '#';

            if (check) j++;
            else j--;
        }

        System.out.println("Rails for decryption : ");
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                char ch = rail[i][k];
                if (ch == '#' && index < col) {
                    rail[i][k] = encrypted.charAt(index++);
                }
                System.out.print(ch + " ");
            }
            System.out.println();
        }

        j = 0;
        check = false;
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) check = !check;
            decryptedText += rail[j][i];

            if (check) j++;
            else j--;
        }

        return decryptedText;
    }

}
