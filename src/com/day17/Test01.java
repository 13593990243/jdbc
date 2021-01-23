package com.day17;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws  Exception {
//        a();
        b();
    }
    public  static void a() throws  Exception{
        Student student = new Student(1,"张三",20);
        FileOutputStream fos = new FileOutputStream("d:\\file\\a.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(student);
        os.flush();
        os.close();
    }
    public static  void b() throws Exception{
        FileInputStream fis = new FileInputStream("d:\\file\\a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student =(Student) ois.readObject();
        System.out.println(student);
        ois.close();
    }
}
