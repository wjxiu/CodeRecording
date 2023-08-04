package company.贪心;

import company.工具.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-18 15:54
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] ints = LeetCodeUtils.parseToIntArray("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]");
        System.out.println(Arrays.deepToString(new 根据身高重建队列().reconstructQueue1(ints)));
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


    public int[][] reconstructQueue1(int[][] people){
//        先按照身高大到小，再按照比自己高的人小到大
        Arrays.sort(people,(p1,p2)->{
            if (p1[0]==p2[0]){
                return p1[1]-p2[1];
            }else{
                return p2[0]-p1[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] ints : people) {
            res.add(ints[1], ints);
        }
        return res.toArray(new int[people.length][2]);
    }
}
