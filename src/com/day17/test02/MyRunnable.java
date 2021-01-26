package com.day17.test02;

public class MyRunnable  implements Runnable{
    @Override
    public void run() {
        System.out.println("world");
        System.out.println("线程名:"+Thread.currentThread().getName());
        System.out.println("线程id:"+Thread.currentThread().getId());
    }
}
