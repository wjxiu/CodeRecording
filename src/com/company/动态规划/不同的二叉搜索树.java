package company.动态规划;

/**
 * @author xiu
 * @create 2023-07-19 21:34
 */
public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(new 不同的二叉搜索树().numTrees(18));
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
