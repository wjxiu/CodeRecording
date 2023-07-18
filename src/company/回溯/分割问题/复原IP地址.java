package company.回溯.分割问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-17 8:51
 */
public class 复原IP地址 {
    public static void main(String[] args) {
        System.out.println(new 复原IP地址().restoreIpAddresses("101023"));
    }
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        back(s,0);
        return res;
    }
    void back(String s,int index){
        if (path.size()==4&&index==s.length()){
            String join = String.join(".", path);
            res.add(join);
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (!isvaild(substring)){
                continue;
            }else{
                path.add(substring);
            }
            back(s,i+1);
            path.removeLast();
        }
    }
    boolean isvaild(String s){
        if (s.length()>3||s.length()==0) return false;
        if (s.length()==1&& s.equals("0")) return true;
        if (s.charAt(0)=='0') return false;
        int i = Integer.parseInt(s);
        return i<=255&&i>0;
    }
}
