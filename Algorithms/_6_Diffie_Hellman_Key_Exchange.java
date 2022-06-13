package com.company.ISC;

import java.util.Scanner;

public class _6_Diffie_Hellman_Key_Exchange {

    private static int calculatePower(int p, int q, int r) {
        int s = (int) Math.pow(p, q);
        return (s % r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of prime number : ");
        int n = sc.nextInt();

        System.out.print("Enter the value of primitive root : ");
        int a = sc.nextInt();

        System.out.print("Enter the private key of user A : ");
        int Xa = sc.nextInt();

        System.out.print("Enter the private key of user B : ");
        int Xb = sc.nextInt();

        int Ya = calculatePower(a, Xa, n);
        int Yb = calculatePower(a, Xb, n);

        System.out.println("Public key of user A : " + Ya);
        System.out.println("Public key of user B : " + Yb);

        int Ka = calculatePower(Yb, Xa, n);
        int Kb = calculatePower(Ya, Xb, n);

        System.out.println((Ka == Kb) ? "Connection can be establish !!" : "Connection can not be establish !!");
        System.out.println(Ka);
        System.out.println(Kb);
    }
}
