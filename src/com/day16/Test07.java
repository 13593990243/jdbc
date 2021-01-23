package com.day16;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Test07 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\file\\c.txt");
            BufferedReader br = new BufferedReader(fr);
            String len = null;
            while (true){
                len= br.readLine();
                if (len==null){
                    break;
                }
                String[] split =len.split("\\.");
                System.out.println(Arrays.toString(split));
                map.put(Integer.valueOf(split[0]),split[1]);
            }
            Set<Integer> set = map.keySet();
            for(Integer s:set){
                list.add(s);
            }
            Collections.sort(list);
            for (int i = 0; i <list.size() ; i++) {
                System.out.println( list.get(i)+" "+map.get(list.get(i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
