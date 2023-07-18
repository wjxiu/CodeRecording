package company.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-18 10:49
 */
public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        System.out.println(new K次取反后最大化的数组和().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));

    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums= IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length&&k>0; i++) {
            if (nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        while (k>0){
            nums[nums.length-1]=-nums[nums.length-1];
            k--;
        }
        return Arrays.stream(nums).sum();
    }
}
