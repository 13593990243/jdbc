package com.day16;

import java.io.File;

public class Files {

    public static void main(String[] args) {
//        File file = new File("D:\\file\\a.txt");
////        System.out.println(file.getName());
////        System.out.println(file.length());
////        System.out.println(file.getAbsoluteFile());
////        System.out.println(file.getPath());
//        File file1 = new File("C:\\Users\\EDZ\\IdeaProjects\\jdbc\\src\\com\\day15\\Emp.java");
//
//        File file2 = new File("D:\\file\\a");
////        System.out.println(file2.mkdirs());
//        File file3= new File("D:\\file");
//        String[] name = file3.list();
////        for (String str:name){
////            System.out.println(str);
////        }
//        File[] files = file3.listFiles();
//        for (File file4:files){
//            if (file4.isFile()){
//                System.out.println("文件"+file4);
//            }
//            else {
//                System.out.println("文件jia"+file4);
//            }
//        }




        File file = new File("C:\\Users\\EDZ\\IdeaProjects\\jdbc");
        getFile(file);

    }

    public static void getFile(File file){
        File[] files = file.listFiles();
        for (File file1:files){
            if (file1.isFile() && file1.getName().endsWith(".java")){
                    System.out.println("文件 : "+ file1.getName());
            }else if(file1.isDirectory()){
                getFile(file1);
            }else{
                continue;
            }
        }

    }
}
