package company.单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-24 21:13
 */
public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        System.out.println(new 柱状图中最大的矩形().largestRectangleArea(new int[]{1,1}));
    }
//    单调栈 栈顶到栈底是单调递减的，保存索引
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] ints = new int[heights.length + 2];
//        首尾部加0，防止全是递增或者全是递减
        System.arraycopy(heights, 0, ints, 1, heights.length);
        heights=ints;
        int res=0;
        for (int i = 1; i < heights.length; i++) {
            int rightval =heights[i];
            while (!stack.isEmpty()&&rightval <heights[stack.peek()]){
                Integer midIndex = stack.pop();
                if (!stack.isEmpty()){
                    int h=heights[midIndex];
                    Integer leftindex = stack.peek();
                    int w=i-leftindex-1;
                    res=Math.max(res,h*w);
                }
            }
            res=Math.max(res,rightval);
            stack.push(i);
        }
        return res;
    }
}
