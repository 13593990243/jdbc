package com.day17.test01;

public class Test01 {
    public static void main(String[] args) {
        MyThraed myThraed = new MyThraed("你是我患得患失的梦");
        myThraed.start();
        System.out.println("主线程名字:"+Thread.currentThread().getName());
        System.out.println("主线程id:"+Thread.currentThread().getId());
    }

}
