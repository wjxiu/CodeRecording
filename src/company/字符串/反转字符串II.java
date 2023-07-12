package company.字符串;

/**
 * @author xiu
 * @create 2023-07-12 10:22
 */
public class 反转字符串II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            int start=i;
            int end=Math.min(s.length()-1,start+k-1);
            for (int j = start; j < end; j++) {
                char temp='-';
                temp=chars[j];
                chars[j]=chars[end];
                chars[end]=temp;
                end--;
            }
        }
        return new String(chars);
    }
}
