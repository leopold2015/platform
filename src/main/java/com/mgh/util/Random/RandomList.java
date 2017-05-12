//package com.mgh.util.Random;;
////
////import java.util.*;
////
////
//*
//// * Created by hao on 2017/3/11.
//// *
//// * @author yhh
//// * 生成随机数组
////
//
////public class RandomList {
////
////    private Set<Integer> getRandomArrays(int bound, int number) {
////        Set<Integer> set = new HashSet<>(number);
////        Random random = new Random();//种子
////        while (set.size() < number) {//有效率问题
////            set.add(random.nextInt(bound));
////        }
////        return set;
////    }
////
////    public  static  int[] getNewIdList(List<Integer> allIdList,int n) {
////        Object[] idArrays = allIdList.toArray();
////        Set<Integer> result = new RandomList().getRandomArrays(idArrays.length, n);
////        int[] ids = new int[n];
////        int index = 0;
////        for (Integer integer : result) {
////            ids[index++] = (int) idArrays[integer];
////        }
////        return ids;
////    }
////}
