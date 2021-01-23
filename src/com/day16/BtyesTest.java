package com.day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BtyesTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\file\\a.txt");
//        fos.write('hellow');
        fos.write("hello".getBytes());
//        fos.write("\r\n".getBytes());
//        fos.write("world".getBytes());
        fos.close();
    }
}
