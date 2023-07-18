package company.回溯.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 19:45
 */
public class 组合总和2 {
    public static void main(String[] args) {
        new 组合总和2().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        back(candidates,target,0);
        return res;
    }
    void back(int[] candidates, int target,int index){
        if (sum>target)return;
        if (target==sum){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            path.add(candidates[i] );
            sum+=candidates[i];
            back(candidates, target, i+1);
            path.removeLast();
            sum-=candidates[i];
        }
    }
}
