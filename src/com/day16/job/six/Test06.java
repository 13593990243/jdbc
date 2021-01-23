package com.day16.job.six;

import java.io.BufferedReader;
import java.io.FileReader;
//请将其以下内容复制到b.txt文本文件中
//然后读取b.txt文本文件中的内容并在控制台打印输出。
//注意：蜀相 杜甫和丞相祠堂何处寻，锦官城外柏森森中间有空白行
public class Test06 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("D:\\test\\b.txt");
            BufferedReader bfr = new BufferedReader(fr);
            while (true) {
                if (bfr.readLine() == null) {
                    break;
                }
                System.out.println(bfr.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
