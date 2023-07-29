package company.栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-14 13:40
 */
public class 逆波兰式 {
    public static void main(String[] args) {
        System.out.println(new 逆波兰式().evalRPN1(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                Long pop = stack.pop();
                Long pop1 = stack.pop();
                stack.push(pop1 - pop);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                Long pop = stack.pop();
                Long pop1 = stack.pop();
                stack.push(pop1 / pop);
            } else {
                stack.push(Long.parseLong(c));
            }
        }
        return stack.pop().intValue();
    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    Integer l = stack.pop() + stack.pop();
                    stack.push(l);
                    break;
                case "-":
                    Integer l1 = stack.pop();
                    Integer l2 = stack.pop();
                    stack.push(l2-l1);
                    break;
                case "*":
                   Integer l3 = stack.pop();
                   Integer l4 = stack.pop();
                    stack.push (l3*l4);
                    break;
                case "/":
                    Integer l5 =stack.pop();
                    Integer l6 =stack.pop();
                    stack.push(l6/l5);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
