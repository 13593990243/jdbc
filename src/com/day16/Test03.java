package com.day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
             fis = new FileInputStream("D:\\1.jpg");
             String str = "D:\\"+System.currentTimeMillis()+".jpg";
             fos = new FileOutputStream(str);
            int len;
            byte[] bytes = new byte[64];
            while (true){
                len = fis.read(bytes);
                if (len!=-1){
                   new  String(bytes,0,len);
                }else {
                    break;
                }
                fos.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fos!=null){
                    fos.close();
                }
                if (fis!=null){
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
