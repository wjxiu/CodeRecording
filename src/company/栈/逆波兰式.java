package company.栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-14 13:40
 */
public class 逆波兰式 {
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (c.equals("-")) {
                Long pop = stack.pop();
                Long pop1 = stack.pop();
                stack.push(pop1-pop);
            } else if (c.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (c.equals("/")) {
                Long pop = stack.pop();
                Long pop1 = stack.pop();
                stack.push(pop1/pop);
            }else{
                stack.push(Long.parseLong(c));
            }
        }
        return stack.pop().intValue();
    }
}
