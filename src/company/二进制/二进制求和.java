package company.二进制;


/**
 * @author xiu
 * @create 2023-07-29 13:07
 */
public class 二进制求和 {
    public static void main(String[] args) {
        String s = new 二进制求和().addBinary("1010", "1011");

    }
//    输入:a = "11", b = "1"
//输出："100"
    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sdfd");
        char[] achars = new StringBuilder(a).reverse().toString().toCharArray();
        char[] bchars = new StringBuilder(b).reverse().toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        int minlength = Math.min(a.length(), b.length());
        int carry=0;
        int i=0;
        while (i< minlength){
            int temp = achars[i]-'0' + bchars[i]+carry-'0';
            if (temp>1) carry=1;
            else carry=0;
            sb.append(temp%2);
            i++;
        }
        if (i==a.length()&&i==b.length()){

        }else if (i==a.length()){
            while (i<b.length()){
                int temp = bchars[i]+carry-'0';
                if (temp>1) carry=1;
                else carry=0;
                sb.append(temp%2);
                i++;
            }
        }else{
            while (i<a.length()){
                int temp = achars[i]+carry-'0';
                if (temp>1) carry=1;
                else carry=0;
                sb.append(temp%2);
                i++;
            }
        }
        if (carry==1) sb.append('1');
        return sb.reverse().toString();
    }

}
