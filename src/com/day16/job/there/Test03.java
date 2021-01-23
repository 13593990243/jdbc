package com.day16.job.there;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//在d盘下有一个文本文件test.txt(里面的内容由数字和字母组成)
//定义一个方法统计test.txt文件中指定字符出现的次数。
// 比如a字符在文件中出现了10次则调用方法传入a后，方法内部输出：a出现10次
public class Test03 {
    public static void main(String[] args)throws Exception {
        FileInputStream fis = new FileInputStream("D:\\file\\test.txt");
        count(fis);
    }

    public static void count(FileInputStream fis) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        try {
            byte[] bytes = new byte[1];
            int len;
            while (true) {
                len = fis.read(bytes);
                if (len != -1) {
                    list.add(new String(bytes,0,len));
                } else {
                   break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            if (map.containsKey(list.get(i))) {
                int sum= map.get(list.get(i));
                map.put(list.get(i),++sum);
            } else {
                map.put(list.get(i),1);
            }
        }
        System.out.println(list);
        Set<String> str = map.keySet();
        for (String s:str){
            System.out.println(s+"出现"+map.get(s)+"次");
        }
    }
}
