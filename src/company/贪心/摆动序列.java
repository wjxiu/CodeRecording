package company.贪心;

/**
 * @author xiu
 * @create 2023-07-17 22:44
 */
public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        int sum=1;
        int predif=0;
        int curdiff=0;
        for (int i = 0; i < nums.length; i++) {
            curdiff=nums[i+1]-nums[i];
            if (predif<=0&&curdiff>0||predif>=0&&curdiff<0){
                sum++;
                predif=curdiff;
            }
        }
        return sum;
    }
}
