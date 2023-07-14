package company.栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-13 11:03
 */
public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        System.out.println(new 删除字符串中的所有相邻重复项().removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            }else{
                if (stack.peek() == c) {
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
