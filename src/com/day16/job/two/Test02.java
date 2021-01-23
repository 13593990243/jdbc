package com.day16.job.two;

import java.io.File;
import java.util.*;

//键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
// 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
// 用个数作为value,放入到map集合中,并用两种方式遍历map集合（iterator和entry）
// 例如：
// doc 的类型的文件有 3 个
// java 的类型的文件有 5 个
// txt 的类型的文件有 7 个
public class Test02 {
    static int countJava = 0;
    static int countTxt = 0;
    static int countJar = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        File file = new File(s);
        HashMap<String, Integer> list = getCount(file);
        Set<Map.Entry<String, Integer>> es = list.entrySet();
//        for (Map.Entry<String, Integer> str:es){
//            System.out.print(str.getKey());
//            System.out.println(str.getValue());
//        }
        Set set = list.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object name = iterator.next();
            System.out.println(name + ":" + list.get(name));
        }
//        for (Object str:set ){
//            System.out.println(str+":"+list.get(str));
//        }
    }

    public static HashMap getCount(File file) {
        HashMap<String, Integer> list = new HashMap<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                if (file1.getName().endsWith(".java")) {
                    countJava++;
                } else if (file1.getName().endsWith(".txt")) {
                    countTxt++;
                } else if (file1.getName().endsWith(".jar")) {
                    countJar++;
                } else {
                    count++;
                }
            } else if (file1.isDirectory()) {
                getCount(file1);
            }
        }
        list.put("java", countJava);
        list.put("txt", countTxt);
        list.put("jar", countJar);
        list.put("其他", count);
        return list;
    }
}
