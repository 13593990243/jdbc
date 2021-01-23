package com.day16.job.one;
//定义一个递归，求1-100的偶数和
public class Test01 {
    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(sum);
    }
    public static int sum(int i){
        if (i<=0){
            return 0;
        }
        int rt = i+sum(--i);
        return rt;
    }
}
