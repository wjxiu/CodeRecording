package com.company.哈希表;

/**
 * @author xiu
 * @create 2023-07-11 10:30
 */
public class 赎金信 {
    public static void main(String[] args) {
        System.out.println(new 赎金信().canConstruct1("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        char[] chars = magazine.toCharArray();
        for(char c:chars){
            dict[c-'a']+=1;
        }
        for(char c:ransomNote.toCharArray()){
            dict[c-'a']-=1;
        }
        for(int i:dict){
            if (i<0){
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine){
        int[] dict = new int[26];
        for(char c:ransomNote.toCharArray()){
            dict[c-'a']-=1;
        }
        for(char c:magazine.toCharArray()){
            dict[c-'a']+=1;
        }
        for(int i:dict){
            if (i<0) return false;
        }
        return true;
    }
}
