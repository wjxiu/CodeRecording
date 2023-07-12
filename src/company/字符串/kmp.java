package company.字符串;

/**
 * @author xiu
 * @create 2023-07-12 13:41
 */
public class kmp {
    public static void main(String[] args) {
        String s="abab";
        String s1=(s+s);
        String s2 = s1.substring(1, s1.length() - 1);
        System.out.println((s2.indexOf(s) != -1));
        System.out.println(new kmp().strStr("butsad", "d"));
    }
    public int strStr(String haystack, String needle) {
        int[] next = getnext(needle);
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int j=0;
        for (int i = 0; i < h.length; i++) {
                while(j>0&&h[i]!=n[j]){
                    j=next[j-1];
                }
                if (h[i]==n[j]){
                    j++;
                }
                if (j==n.length){
                    return i-(n.length-1);
                }
        }
        return -1;
    }
    //    生成kmp的next数组
    int[] getnext(String s){
        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];
//        i:后缀的开头
//        j:前缀的末尾
        int j=0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0&&chars[i]!=chars[j]){
                j=next[j-1];
            }
            if (chars[i]==chars[j]){
                j++;
                next[i]=j;
            }
        }
        return next;
    }
}
