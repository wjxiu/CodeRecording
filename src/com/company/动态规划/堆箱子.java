package com.company.动态规划;

import com.company.公共类.TreeNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-10-27 19:52
 */
public class 堆箱子 {
    static int pileBox(int[][] box) {
        Arrays.sort(box, (a, b) -> {
            return a[0] - b[0];
        });
        int res = 0;
        int[] dp = new int[box.length];
        dp[0] = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
//            不理解  dp[i]=Math.max(dp[i],dp[j]+box[i][2])为什么错
            dp[i] += box[i][2];
            res = Math.max(dp[i], res);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }


    static void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1;
        int pb = n - 1;
        int tail = m + n - 1;
        while (pa >= 0 || pb >= 0) {
            if (pa >= 0 && pb >= 0) {
                if (A[pa] > B[pb]) {
                    A[tail] = A[pa];
                    tail--;
                    pa--;
                } else {
                    A[tail] = B[pb];
                    tail--;
                    pb--;
                }
            } else if (pa == -1) {
                A[tail] = B[pb];
                tail--;
                pb--;
            } else {
                A[tail] = A[pa];
                tail--;
                pa--;
            }
        }
        System.out.println(Arrays.toString(A));
    }


    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> pre = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = pre.getOrDefault(key, new ArrayList<>());
            list.add(str);
            pre.put(key, list);
        }
        return new ArrayList<List<String>>(pre.values());
    }

    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[right];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] m : matrix) {
            if (search(m, target) > 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 堆箱子().searchMatrix(LeetCodeUtils.parseToIntArray("[\n" +
                "  [1]" +
                "]"), 1));
    }

    int search(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid] == target) return mid;
            if (target > matrix[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class StreamRank {

    HashMap<Integer, Integer> map = new HashMap<>();

    public StreamRank() {

    }

    public void track(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public int getRankOfNumber(int x) {
        Set<Integer> integers = map.keySet();
        int count = 0;
        for (Integer i : integers) {
            if (i <= x) {
                count += map.get(i);
            }
        }
        return count;
    }
    
}


