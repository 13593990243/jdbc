package com.day20;

import org.junit.*;

public class Dome {
    @Test
    public void a() {
        System.out.println("你可真是个小可爱哦！");
    }

    public void b() {
        System.out.println("你可真是个小天才哦！");
    }

    @Before
    public void c() {
        System.out.println("方法前！");
    }

    @After
    public void d() {
        System.out.println("方法后！");
    }

    @BeforeClass
    public static void e() {
        System.out.println("开始");
    }

    @AfterClass
    public static void f() {
        System.out.println("开始");
    }

}
