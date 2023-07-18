package company.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-18 15:54
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] ints = {
                {0, 5},
                {5, 0},
                {4, 0},
                {3, 2},
                {2, 2},
                {1, 4},
        };
        new 根据身高重建队列().reconstructQueue(ints);
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]) return o1[1]-o2[1];
               return o2[0]-o1[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for(int[] arr:people){
            res.add(arr[1],arr);
        }
        return res.toArray(new int[][]{});
    }
}
