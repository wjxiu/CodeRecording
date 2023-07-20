package company.贪心.区间问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-19 12:07
 */
public class 划分字母区间 {
    public static void main(String[] args) {
        System.out.println(new 划分字母区间().partitionLabels("eccbbbbdec"));
    }
    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
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

}