package com.company.数组;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-30 15:38
 */
public class 最小差 {
    //两个数组
    static int smallestmutilDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long sub = Long.MAX_VALUE;
        int pa = 0;
        int pb = 0;
        while (pa < a.length && pb < b.length) {
            sub = Math.min(sub, (long) a[pa] - b[pb]);
            if (a[pa] < b[pb]) {
                pa++;
            } else {
                pb++;
            }
        }
        return (int) sub;
    }

    //    多个数组
    static int smallestmutilDifference(int[][] arrays) {
        for (int[] arr : arrays) {
            Arrays.sort(arr);
        }
        int[] parr = new int[arrays.length];
        long sub = Long.MAX_VALUE;
        boolean flag = true;
        while (flag) {
            flag = true;
            if (sub == 0) return 0;
            int[] temp = new int[parr.length];
            for (int i = 0; i < parr.length; i++) temp[i] = arrays[i][parr[i]];
            int min = Arrays.stream(temp).min().getAsInt();
            sub = Math.min(sub, minsubarr(temp));
            for (int i = 0; i < parr.length; i++) {
                flag |= parr[i] != arrays.length - 1;
                if (arrays[i][parr[i]] == min) {
                    parr[i]++;
                    break;
                }
            }
        }
        return (int) sub;
    }

    //求出数组的元素之间的最小差值
    static int minsubarr(int[] arr) {
        if (arr.length == 1) return arr[0];
        Arrays.sort(arr);
        int i = 1;
        long sub = Long.MAX_VALUE;
        while (i < arr.length) {
            sub = Math.min(sub, (long) arr[i] - arr[i - 1]);
            i++;
        }
        return (int) sub;
    }


    //多个数组合成两个数组
    static int smallestmutilDifference1(int[][] arrays) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) list.add(arrays[i][j]);
        }
        int[] b = list.stream().mapToInt(Integer::intValue).toArray();
        int[] a = arrays[0];
        return smallestmutilDifference(a, b);
    }

    static int findmax(int a, int b) {
        long c = (long) a - (long) b;
        long k = ((c >> 63) & 0x1); // 获取符号位
        long max = a - c * k; // 如果符号位为0，返回a，否则返回b
        return (int) max;
    }


    static int maxAliveYear(int[] birth, int[] death) {
        int[] live = new int[102];
        for (int i = 0; i < birth.length; i++) {
            int b = birth[i] - 1900;
            int d = death[i] - 1900;
            live[b]++;
            live[d + 1]--;
        }
        int max = 0, sum = 0, idx = 0;
        for (int i = 0; i < live.length; i++) {
            sum += live[i];
            if (sum > max) {
                max = sum;
                idx = i;
            }
        }
        return idx + 1900;
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{k * shorter};
        int[] arr = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            arr[i] = longer * i + shorter * (k - i);
        }
        return arr;
    }


    static int[] masterMind(String solution, String guess) {
        HashMap<Character, Integer> somap = new HashMap<>();
        HashMap<Character, Integer> gumap = new HashMap<>();
        somap.put('R', 0);
        somap.put('Y', 0);
        somap.put('G', 0);
        somap.put('B', 0);
        gumap.put('R', 0);
        gumap.put('Y', 0);
        gumap.put('G', 0);
        gumap.put('B', 0);
        int[] res = new int[2];
        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                res[0]++;
            } else {
                somap.put(s, somap.getOrDefault(s, 0) + 1);
                gumap.put(g, gumap.getOrDefault(g, 0) + 1);
            }
        }
        for (Character character : solution.toCharArray()) {
            res[1] += Math.min(somap.get(character), gumap.get(character));
        }
        return res;
    }

    static int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};
        int[] arr = Arrays.copyOf(array, array.length);
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == array[left]) {
                left++;
                i++;
            } else
                break;
        }
        for (int i = arr.length - 1; i >= 0; ) {
            if (arr[i] == array[right]) {
                right--;
                i--;
            } else
                break;
        }
        if (left == arr.length && right == -1) return new int[]{-1, -1};
        return new int[]{left, right};
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}