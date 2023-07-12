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
        System.out.println(Arrays.toString(new 两数之和().twoSum(new int[]{2, 7, 11, 34}, 9)));
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
}
