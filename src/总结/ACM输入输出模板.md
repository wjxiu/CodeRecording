```java
import java.util.*;
import java.io.*;
//读取数组信息生成int数组两种方法
//一种使用StreamTokenizer
//BufferedReader
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StreamTokenizer st = new StreamTokenizer(br);
        int[] arr;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int a = st.nval;
            arr = new int[a];
            for (int i = 0; i < a; i++) {
                st.nextToken();
                arr[i] = (int) st.nval;
            }
        }
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            int[] array = Arrays.stream(split).mapToInt(Integer::intValue).toArray();
        }
    }
}
```