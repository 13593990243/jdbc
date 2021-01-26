package com.day17.test03;

import java.util.concurrent.Callable;

public class Collable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("线程名:"+Thread.currentThread().getName());
        System.out.println("线程id:"+Thread.currentThread().getId());
        return "我是你可有可无的人";
    }
}
