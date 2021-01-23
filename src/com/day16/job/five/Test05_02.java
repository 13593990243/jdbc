package com.day16.job.five;

import java.io.*;

public class Test05_02 {
    public static void main(String[] args) {
        long satct2 = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream("D:\\file\\jquery-3.4.1.js");
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("D:\\test\\jquery-3.4.1.js");
            bos = new BufferedOutputStream(fos);
            int len;
            byte[] bytes = new byte[64];
            while (true) {
                len = bis.read(bytes);
                if (len == -1) {
                    break;
                }
                bos.write(bytes, 0, len);
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - satct2);
    }
}
