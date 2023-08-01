package company.回溯.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 19:45
 */
public class 组合总和2 {
    public static void main(String[] args) {
        new 组合总和2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        new 组合总和2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    boolean used[];

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        back1(candidates, target, 0);
        System.out.println(res);
        return res;
    }

    void back1(int[] candidates, int target, int index) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
//             关键是排序+ !used[i-1]&&candidates[i]==candidates[i-1]
//            排序之后前面的元素在前一次遍历中肯定用过了，后来又恢复为false了
//            如果是used[i-1]就会去重path的元素
            if (i > 0 && !used[i - 1] && candidates[i] == candidates[i - 1]) continue;
            int candidate = candidates[i];
            used[i] = true;
            path.add(candidate);
            sum += candidate;
            back1(candidates, target, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
            sum -= candidate;
        }
    }
}
