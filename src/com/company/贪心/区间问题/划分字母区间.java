package company.贪心.区间问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-19 12:07
 */
public class 划分字母区间 {
    public static void main(String[] args) {
        System.out.println(new 划分字母区间().partitionLabels1("eaaaabaaec"));
    }
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> res=new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            map[c-'a']=i;
        }
        int end=0;
        int start=0;
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            end=Math.max(map[c-'a'],end);
            if (i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }


    public List<Integer> partitionLabels1(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],i);
        }
        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();
        int temp=map.get(chars[0]);
        int left=0;
        for (int i = 0; i < chars.length; i++) {
            temp=Math.max(temp,map.get(chars[i]));
            if (i==temp){
                list.add(i-left+1);
                left=i+1;
            }

        }
        return list;
    }

}