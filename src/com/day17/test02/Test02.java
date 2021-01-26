package com.day17.test02;

public class Test02 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"线程1");
        thread.start();
    }
}
