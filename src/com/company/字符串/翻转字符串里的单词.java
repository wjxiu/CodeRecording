package company.字符串;


/**
 * @author xiu
 * @create 2023-07-27 10:35
 */
public class 翻转字符串里的单词 {
    public static void main(String[] args) {
        String s="lrloseumgh";
        char[] chars = s.toCharArray();
        System.out.println(new 翻转字符串里的单词().reverse(chars, 0, 6));
        System.out.println(new 翻转字符串里的单词().reverse(chars, 7, chars.length-1));
        System.out.println(new 翻转字符串里的单词().reverse(chars, 0, chars.length - 1));
//        System.out.println(new 翻转字符串里的单词().reverseWords("    sdf      dfsd sdf f3424"));
    }
    public String reverseWords(String s) {
        char[] chars = removeSpace(s);
        reverse(chars,0, chars.length-1);
        reverseeach(chars);
        return new String(chars);
    }
    public char[] removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        StringBuilder sb = new StringBuilder();
        while (s.charAt(start)==' ') start++;
        while (s.charAt(end)==' ') end--;
        while (start<=end){
            if (s.charAt(start)!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(s.charAt(start));
            }
            start++;
        }
        return sb.toString().toCharArray();
    }
    public char[] reverse(char[] s,int start,int end){
        while (start<=end){
            char temp= s[start];
            s[start]= s[end];
            s[end]=temp;
            start++;
            end--;
        }
        return s;
    }
    public char[] reverseeach(char[] chars){
        int start=0;
        int end=0;
        while (end< chars.length){
            while (end< chars.length&&chars[end]!=' ')end++;
            reverse(chars,start,end-1);
            start=end+1;
            end++;
        }
        return chars;
    }

}
