package com.company.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiu
 * @create 2023-09-22 10:45
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        System.out.println(13%8);
        System.out.println(13&(8-1));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(5,6);
        map.put(3,4);
        map.put(null,1);
        map.put(null,2);
        System.out.println(map);
        Set<Integer> keySet = map.keySet();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
//        iterator遍历
//        Iterator<Integer> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            Integer value = map.get(next);
//            System.out.println(String.format("key:%s,value:%s",next,value));
//        }
//        foreach遍历
//        map.forEach((a,b)->{
//            System.out.println(a+""+b);
//        });
//        stream
//        entrySet.stream().forEach(e->{
//            System.out.println(e.getKey()+""+e.getValue());
//        });
////
//        keySet.forEach(e->{
//            System.out.println(e+""+map.get(e));
//        });
    }
}
