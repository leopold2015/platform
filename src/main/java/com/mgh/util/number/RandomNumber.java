package com.mgh.util.number;

/**
 * Created by Asus on 2016/7/21.
 */
//生成随机数
public class RandomNumber {
    public static long createRandom(){
        long s1 = 100000;
        long s2 = 999999;
        long s = s1 + (long)(Math.random()*(s2-s1));
        return s;
    }

    public static int createNumber(int n){
        //int s1 = 0;
        int s = (int)(Math.random()*n);
        return s;
    }
}
