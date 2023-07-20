package company.贪心;

/**
 * @author xiu
 * @create 2023-07-19 18:05
 */
public class 单调递增的数字 {
    public static void main(String[] args) {
        System.out.println(new 单调递增的数字().monotoneIncreasingDigits(709219028));
    }
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start=0;
        for (int i = chars.length-1; i >=1; i--) {
            if (chars[i-1]>chars[i]){
                chars[i-1]--;
                start=i;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i]='9';
        }
        return Integer.parseInt(new String(chars));
    }
}
