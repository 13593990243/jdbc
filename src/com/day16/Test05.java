package com.day16;

import java.io.FileWriter;
import java.io.IOException;

public class Test05 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("D:\\file\\b.txt");
            fw.write("你可真是个小可爱");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
