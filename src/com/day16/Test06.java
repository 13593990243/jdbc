package com.day16;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test06 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
             fr = new FileReader("D:\\jquery-1.6.1.js");
             String str = "D:\\file\\"+System.currentTimeMillis()+".js";
             fw = new FileWriter(str);
             int len;
             char[] chars = new char[64];
             while (true){
                 len = fr.read(chars);
                 if (len!=-1){

                 }else {
                     break;
                 }
                 fw.write(chars,0,len);
                 fw.flush();
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr!=null){
                    fr.close();
                }
                if (fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
