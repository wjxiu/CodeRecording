package com.company.数组;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-11-02 14:21
 */
public class 婴儿名字 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Set<String> set = new HashSet<String>();
        Pattern compile = Pattern.compile("[a-zA-Z]");
        ArrayList<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < synonyms.length; i++) {
            Matcher matcher = compile.matcher(synonyms[i]);
            String group = matcher.group();
            if (!group.isBlank()) {

            }
        }
        return new String[0];
    }
}

class UnionFind {
    int[] fa;
    int n;

    UnionFind(int n) {
        fa = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    int find(int x) {
        if (fa[x] == x) return x;
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    int union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        fa[fx] = fy;
        return fy;
    }
    void isrelative(int[][] arr,int[][] relative){
        for (int i = 0; i < arr.length; i++) {
            union(arr[i][0],arr[i][1]);
        }
        for (int i = 0; i < relative.length; i++) {
            int i1 = find(relative[i][0]);
            int i2 = find(relative[i][1]);
            System.out.println(i1==i2);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        String[] split = br.readLine().split("[^\\d+]");
        System.out.println(Arrays.toString(split));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        UnionFind unionFind = new UnionFind((int) st.nval);
        st.nextToken();int length=(int)st.nval;
        int[][] arr=new int[length-1][2];
        length--;
        while (length>=0){
            st.nextToken();int x=(int)st.nval;
            st.nextToken();int y=(int)st.nval;
            arr[length]=new int[]{x,y};
            length--;
        }
        st.nextToken();int m=(int)st.nval;
        int[][] relative=new int[m-1][2];
        m--;
        while (m>0){
            st.nextToken();int x=(int)st.nval;
            st.nextToken();int y=(int)st.nval;
            arr[m]=new int[]{x,y};
            m--;
        }
        unionFind.isrelative(arr,relative);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StreamTokenizer st = new StreamTokenizer(br);
        String s = br.readLine();
        String[] a1 = s.split("[^a-zA-Z]+");
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));
        int[] arr;
        while (st.nextToken()!= StreamTokenizer.TT_EOF) {
            int length=(int)st.nval;
            if (length==0)return;
            arr=new int[length];
            for (int i = 0; i < arr.length; i++) {
                st.nextToken();
                arr[i]=(int)st.nval;
            }
            int sum1 = Arrays.stream(arr).sum();
            pw.println(sum1);
            pw.flush();
        }
        pw.close();br.close();
    }
}
class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern compile = Pattern.compile("\\([^()]\\)");
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            Matcher matcher = compile.matcher(a);
            while (matcher.find()){
                System.out.println(matcher.group());
                System.out.println(matcher.group());
            }
//            String[] a2=a.split("[^(.*)]+");
//            String[] array = Arrays.stream(a2).filter(s -> !s.isEmpty()).toArray(String[]::new);
//            System.out.println(Arrays.toString(array));
        }
    }
}