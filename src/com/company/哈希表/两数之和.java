package company.哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-07-11 10:13
 */
public class 两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 两数之和().twoSum1(new int[]{3,2,4}, 6)));
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target-num)){
                return new int[]{i,map.get(target-num)};
            }else{
                map.put(num,i);
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.containsKey(target-num)) return new int[]{i,set.get(target-num)};
            set.put(num,i);
        }
        return new int[]{};
    }
}
