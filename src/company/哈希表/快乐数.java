package company.哈希表;

import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-07-10 15:12
 */
public class 快乐数 {
    public static void main(String[] args) {
        System.out.println(new 快乐数().isHappy(19));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n = getnum(n);
        }
        return n==1;
    }

    int getnum(int n){
        int sum=0;
        int temp= 0;
        while (n>0){
             temp= n%10;
             sum+=temp*temp;
            n/=10;
        }
        return sum;
    }
}
