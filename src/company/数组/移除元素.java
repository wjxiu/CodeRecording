package company.数组;

/**
 * @author xiu
 * @create 2023-07-09 15:43
 */
public class 移除元素 {
    public static void main(String[] args) {
        System.out.println(new 移除元素().removeElement(new int[]{0, 1, 2, 3, 4, 5, 2, 4}, 2));
    }
//    快慢指针
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
