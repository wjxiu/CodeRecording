package company.贪心;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xiu
 * @create 2023-07-17 22:11
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gindex = 0;
//        这里小饼干优先供给小胃口，不能for遍历g数组
        for (int i = 0; i < s.length; i++) {
            if (gindex<g.length&&g[gindex]<=s[i]){
                gindex++;
            }
        }
        return gindex;
    }
}
