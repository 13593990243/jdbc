package com.day17.test01;

public class MyThraed extends Thread {
    public MyThraed(String name) {
        super(name);
    }

    public void run(){
        System.out.println("hello");
        System.out.println("线程名："+ getName());
        System.out.println("id："+getId());
    }
}
