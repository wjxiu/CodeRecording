package com.company.数组;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-11-01 15:56
 */
public class 计算器 {
    static int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char pre = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
//                防止多位数字识别不到
                num = num * 10 + c - '0';
            }
//            这里的c!=' '不能单独出来,因为如果最后一个是空格会直接退出,前面的数字可还没有计算,最后一个位置将之前结果保存到栈中
            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                switch (pre) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                pre = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println(calculate("3/2"));
    }

    static int calculate(String s) {
        Stack<Integer> numstack = new Stack<>();
        HashMap<Character, Integer> levels = new HashMap<>();
        levels.put('+', 1);
        levels.put('-', 1);
        levels.put('*', 2);
        levels.put('/', 2);
        Stack<Character> opstack = new Stack<>();
        numstack.push(0);
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int res = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    res = res * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                numstack.push(res);

            } else {
                while (!opstack.empty()) {
                    Character top = opstack.peek();
                    if (levels.get(top) >= levels.get(c)) {
                        cacl(numstack, opstack);
                    } else {
                        break;
                    }
                }
                opstack.push(c);
            }
        }
        while (!opstack.isEmpty()) {
            cacl(numstack, opstack);
        }
        return numstack.pop();
    }

    static void cacl(Stack<Integer> numstack, Stack<Character> opstack) {
        if (numstack == null || opstack == null || opstack.isEmpty() || numstack.size() < 2) return;
        Integer b = numstack.pop();
        Integer a = numstack.pop();
        Character op = opstack.pop();
        int res = 0;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        numstack.push(res);
    }
}