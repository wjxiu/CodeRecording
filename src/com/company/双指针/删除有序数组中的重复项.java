package company.双指针;

/**
 * @author xiu
 * @create 2023-07-12 14:47
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] ints = {1};
        System.out.println(new 删除有序数组中的重复项().removeDuplicates(ints));
    }
    public int removeDuplicates(int[] nums) {
        int slow=0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow]==nums[fast]){
                continue;
            }else{
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
