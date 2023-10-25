package com.company.数组;

import java.util.*;

/**
 * @author xiu
 * @create 2023-11-02 11:53
 */
public class 字母与数字 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLongestSubarray1(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"})));
    }

    static String[] findLongestSubarray(String[] array) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int digitcount = 0;
            int lettercount = 0;
            for (int j = i; j < array.length; j++) {
                int i1 = array[j].charAt(0);
                list.add(array[j]);
                if (Character.isDigit(i1)) {
                    digitcount++;
                } else {
                    lettercount++;
                }
            }
            while (digitcount != lettercount) {
                String remove = list.remove(list.size() - 1);
                if (Character.isDigit(remove.charAt(0))) digitcount--;
                else lettercount--;
            }
            if (list.size() > res.size()) {
                res.clear();
                res.addAll(list);
            }
            list.clear();
        }
        String[] res1 = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            String s = res.get(i);
            res1[i] = s;
        }
        return res1;
    }

    static String[] findLongestSubarray1(String[] array) {
//        前缀和->第一次的下标
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int maxlength=0;
        int startindex=-1;
        for (int i = 0; i <array.length; i++) {
            if (Character.isDigit(array[i].toCharArray()[0])){
                sum+=1;
            }else{
                sum--;
            }
            Integer i1 = map.get(sum);
            if (i1!=null){
                if (i-i1>maxlength){
                    maxlength= i-i1;
                    startindex=i1+1;
                }
            }else{
                map.put(sum,i);
            }
        }
        if (maxlength==0)return new String[0];

        String[] ans = new String[maxlength];
        System.arraycopy(array,startindex,ans,0,ans.length);
        return ans;
    }
}