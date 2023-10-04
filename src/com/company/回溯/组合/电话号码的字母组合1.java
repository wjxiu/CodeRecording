package com.company.回溯.组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiu
 * @create 2023-09-28 20:13
 */
public class 电话号码的字母组合1 {
    public static void main(String[] args) {
        new 电话号码的字母组合1().letterCombinations("23346");
    }
    HashMap<Character,String> map=new HashMap<Character,String>();
    ArrayList<Character> path=new ArrayList();
    ArrayList res=new ArrayList();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jik");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        back(digits,0);
        System.out.println(res);
        return res;
    }
    void back(String digits,int index){
        if (index==digits.length()){
            String s = new String();
            for(char c:path) s+=c;
            res.add(s);
            return;
        }
        char[] chars= digits.toCharArray();
        String s= map.get(chars[index]);
        char[] letters = s.toCharArray();
        for(int i=0;i<letters.length;i++){
            path.add(letters[i]);
            back(digits,index+1);
            path.remove(path.size()-1);
        }
    }
}
