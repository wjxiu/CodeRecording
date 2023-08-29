package company.哈希表;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-10 14:50
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        char[] b = s.toCharArray();
        Arrays.sort(b);
        char[] a = t.toCharArray();
        Arrays.sort(a);
       return  Arrays.equals(a, b);
    }

    public boolean isAnagram1(String s, String t) {
        int[] alpha=new int[26];
        for(char c:s.toCharArray()){
            alpha[c-'a']+=1;
        }
        for(char c:t.toCharArray()){
            alpha[c-'a']-=1;
        }
        for(int i:alpha){
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t){
        int[] map=new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']+=1;
        }
        for(char c:t.toCharArray()){
            map[c-'a']-=1;
        }
        for(int i:map){
            if (i!=0) return false;
        }
        return true;
    }
}
