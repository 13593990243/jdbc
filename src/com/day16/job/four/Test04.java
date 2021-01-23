package com.day16.job.four;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//题目：
//分析以下需求，并用代码实现
//实现一个验证码小程序，要求如下：
//1. 在项目根目录下新建一个文件：data.txt，键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占 一行；
//2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存 在控制台提示验证失败
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三个字符串验证码：");
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\file\\date.txt");
            fos.write(s.getBytes());
            fos.write("\r\n".getBytes());
            fos.write(s1.getBytes());
            fos.write("\r\n".getBytes());
            fos.write(s2.getBytes());
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
        }
        System.out.println("请输入验证码");
        String s3 = scanner.nextLine();
        if (list.contains(s3)) {
            System.out.println("登录成功");
        } else {
            System.out.println("验证码错误");
        }
    }
}
