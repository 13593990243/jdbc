package com.day17.test03;

import java.util.concurrent.FutureTask;

public class Tset03 {
    public static void main(String[] args) throws Exception {
        Collable collable =  new Collable();
        FutureTask futureTask = new FutureTask(collable);
        Thread thread = new Thread(futureTask,"毕竟这穿越山河的箭");
        thread.start();
        System.out.println(futureTask.get());
    }
}
