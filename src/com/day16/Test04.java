package com.day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test04 {
    public static void main(String[] args) {
        FileReader fr = null;

        try {
             fr = new FileReader("D:\\file\\a.txt");
            int len;
            while (true){
                len= fr.read();
                if (len!=-1){
                    System.out.println((char)len);
                }else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
