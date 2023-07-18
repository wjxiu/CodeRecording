package company.回溯.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 18:54
 */
public class 组合总和 {
    List<List<Integer>>  res = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer>  path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        back(candidates,target,0);
        return res;
    }
    void back(int [] candidates,int target,int index){
        //if (sum>target)return;
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum+=candidates[i];
            back(candidates,target,index+1);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
