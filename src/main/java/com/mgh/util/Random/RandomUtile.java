package com.mgh.util.Random;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LJ on 2017/3/20.
 */
public class RandomUtile {

    /**
     * 根据范围range生成count个不同的随机数
     * @author LJ
     * @param range
     * @param count
     * @return
     */
    public static List<Integer> createRandomCountOfSlidePicture(int range,int count){
        List<Integer> list = new LinkedList<>();
        int group = range/count;   //每组范围
        int remain = range%count;  //分组后的余数
        for(int i=0;i<count;i++){
            if(i == (count-1)){   //最后一组找随机数
                list.add((int)(i*group+1+Math.random()*(group+remain-1)));
            }else{
                list.add((int)(i*group+1+Math.random()*(group-1)));
            }
        }
        return list;
    }
}
