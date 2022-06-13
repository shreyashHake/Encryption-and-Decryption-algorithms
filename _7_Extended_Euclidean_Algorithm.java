package com.company.ISC;

import java.util.Scanner;

public class _7_Extended_Euclidean_Algorithm {

    private static int extended_gcd(int a, int b, Integer x, Integer y) {
        if (a == 0) {
            x.set(0);
            y.set(1);
            return b;
        }

        Integer X = new Integer(),
                Y = new Integer();

        int gcd = extended_gcd(b % a, a, X, Y);

        x.set(Y.get() - (b / a) * X.get());
        y.set(X.get());

        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of 'a' : ");
        int a = sc.nextInt();

        System.out.print("Enter the value of 'b' : ");
        int b = sc.nextInt();

        Integer x = new Integer(),
                y = new Integer();

        System.out.println("GCD of two given numbers are : " + extended_gcd(a, b, x, y));
        System.out.println("Coefficient of x : " + x.get() + " and Coefficient of y : " + y.get());
    }

    private static class Integer {
        int x;

        public int get() {
            return x;
        }

        public void set(int x) {
            this.x = x;
        }
    }
}
