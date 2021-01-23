package com.day16.job.five;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//将d盘下的xxx.jar(200M左右)文件复制到e盘下
//1 利用输入输出流完成文件的复制
//2 利用缓冲输入输出流完成文件的复制
//3 对比速度
public class Test05 {
    public static void main(String[] args) {
        long satct = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\file\\jquery-3.4.1.js");
            fos = new FileOutputStream("D:\\jquery-3.4.1.js");
            int len;
            byte[] bytes = new byte[64];
            while (true) {
                len = fis.read(bytes);
                if (len == -1) {
                    break;
                }
                fos.write(bytes,0,len);
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-satct);

    }
}
