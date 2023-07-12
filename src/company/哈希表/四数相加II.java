package company.哈希表;

import java.util.HashMap;

/**
 * @author xiu
 * @create 2023-07-11 10:25
 */
public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        k:sum,v:出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        int res=0;
        for(int i:nums3){
            for(int j:nums4){
               res+=map.getOrDefault(0-(i+j),0);
            }
        }
        return res;
    }
}
