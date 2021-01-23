package com.day16;

import java.io.FileInputStream;

public class BtyeTest02 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D:\\file\\a.txt");
        int read;
        while (true){
            if ((read = fis.read())!=-1){
                System.out.println((char)read);
            }else {
                break;
            }
        }
//        int len;
//        byte[] bytes = new byte[2];
//        while (true){
//            if ((len=fis.read(bytes))!=-1){
//                System.out.println(new String(bytes,0,len));
//            }else {
//                break;
//            }
//        }
        fis.close();
    }
}
