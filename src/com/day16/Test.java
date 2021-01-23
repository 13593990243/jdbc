package com.day16;

public class Test {
    public static void main(String[] args) {
        int jiechen = jiechen(5);
        System.out.println(jiechen);


    }

    public static int jiechen(int i) {
        if (i <= 0) {
            return 1;
        }

        int a = i * jiechen(i - 1);
        i--;
        jiechen(i);
        return a;
    }
}
