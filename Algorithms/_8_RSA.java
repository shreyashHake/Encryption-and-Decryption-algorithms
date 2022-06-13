package com.company.ISC;

import java.util.Scanner;

public class _8_RSA {

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private static int getPublic(int z) {
        int e = 0;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) break;
        }
        return e;
    }

    private static int getPrivate(int z, int e) {
        int d = 0;
        for (int i = 0; i < 9; i++) {
            int x = 1 + i * z;
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        return d;
    }

    private static int calculatePower(int base, int power, int mod) {
        int x = (int) Math.pow(base, power);
        x = x % mod;
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, z, p, q, e, d = 0, M, C;
        System.out.print("Enter the value of message : ");
        M = sc.nextInt();

        System.out.print("Enter the first prime number : ");
        p = sc.nextInt();

        System.out.print("Enter the second prime number : ");
        q = sc.nextInt();

        n = p * q;
        z = (p - 1) * (q - 1);

        e = getPublic(z);
        System.out.println("Value of public key : " + e);

        d = getPrivate(z, e);
        System.out.println("Value of private key : " + d);

        C = calculatePower(M, e, n);
        System.out.println("Encrypted value : " + Math.pow(M, e) % n);

        M = calculatePower(C, d, n);
        System.out.println("Decrypted value : " + M);
    }
}
