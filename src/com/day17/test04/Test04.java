package com.day17.test04;

import java.util.concurrent.FutureTask;

public class Test04 {
    public static void main(String[] args) {
//     new Thread(()->{
//        System.out.println("你好啊");
//        System.out.println(Thread.currentThread().getName());
//    }).start();


          FutureTask task =  new FutureTask<String>(()->{
            System.out.println(123);
            return "我是你爸爸";
        });
          Thread thread = new Thread(task);
          thread.start();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//        Thread thread = new Thread(runnable,"永久的疼");
//        thread.start();

//        Thread thread = new Thread("偏偏注定"){
//            @Override
//            public void run() {
//                System.out.println("你说你想要逃");
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//        thread.start();
//
//        Callable callable = new Callable() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("world");
//                System.out.println(Thread.currentThread().getName());
//                return "我的妈呀";
//            }
//        };
//        FutureTask task = new FutureTask(callable);
//        Thread thread  = new Thread(task,"你好啊");
//        thread.start();




    }
}
