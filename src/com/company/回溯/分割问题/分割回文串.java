package com.company.回溯.分割问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiu
 * @create 2023-07-17 8:25
 */
public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition2("aab"));
    }

    public List<List<String>> partition(String s) {
        back1(s, 0);
        return res;
    }

    void back(String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            } else {
                path.add(substring);
            }
            back(s, i + 1);
            path.removeLast();
        }
    }


    void back1(String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
            } else continue;
            back1(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> partition2(String s) {
        back2(s, 0);
        return res;
    }

    void back2(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i+1);
            if (isPalindrome(substring)) {
                path.add(substring);
                back2(s,i+1);
                path.remove(path.size() - 1);
            }
        }
    }


    boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
