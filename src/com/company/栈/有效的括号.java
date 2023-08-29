package company.栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-27 22:51
 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(new 有效的括号().isValid("([}}])"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
//                  第二种情况，括号没有多余，但是 括号的类型没有匹配上。 括号匹配2
//                  第三种情况，字符串里右方向的括号多余了，所以不匹配。
                if (stack.isEmpty() || stack.peek() != c) return false;
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            }
        }
//        第一种情况，字符串里左方向的括号多余了 ，所以不匹配。
        return stack.isEmpty();
    }
}
