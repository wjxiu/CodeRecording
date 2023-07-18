package company.回溯.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 16:37
 */
public class 组合 {
    public static void main(String[] args) {
        String s="abcdef";
        System.out.println(s.substring(0, 1));
        System.out.println(new 组合().combine(4, 2));
    }
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(n,k,0);
        return res;
    }
    void back(int n,int k,int index){
        if (path.size()>=k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            back(n,k,i+1);
            if (!path.isEmpty()){
                path.remove(path.size()-1);
            }
        }
    }
}
