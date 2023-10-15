package com.company.图.最短路径;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-14 19:07
 */
public class DijkstraAlgorithm {
    public static void dijkstra(int[][] graph, int start,int end) {
        int length=graph.length;
//        记录各个点到start的最短距离
        int[] distance=new int[length];
//        访问数组
        boolean[] visited=new boolean[length];
//     i表示节点,   pre[i]表示最短路径的上一个节点
        int[] pre=new int[length];
        Arrays.fill(distance,Integer.MAX_VALUE);distance[start]=0;
        for (int i = 0; i <length-1; i++) {
//            从所有未遍历的边中寻找最短的边
          int node=  minDistance(distance,visited);
          visited[node]=true;
            for (int j = 0; j < graph[node].length; j++) {
//                graph[node][j]!=0&&graph[node][j]!=Integer.MAX_VALUE 都是为了跳过不允许访问的边
                if (!visited[j]&&graph[node][j]!=0&&graph[node][j]!=Integer.MAX_VALUE
                        &&distance[node]+graph[node][j]<distance[j]){
                    distance[j]=distance[node]+graph[node][j];
                    pre[j]=node;
                }
            }
        }
        int tempnode=end;
        StringBuilder builder=new StringBuilder();
        builder.append("-");
        builder.append(end);
        for (int i = 0; i < length; i++) {
            if (tempnode!=start){
                builder.append("-");
                builder.append(pre[tempnode]);
                tempnode=pre[tempnode];
            }
        }
        System.out.println("最短路径长度 "+distance[end]);
        System.out.println(builder.reverse().substring(0,builder.length()-1));
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min=Integer.MAX_VALUE;
        int node =-1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i]&&distance[i]<min){
                min=distance[i];
                node =i;
            }
        }
        return node;
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int startVertex = 0;
        int end=5;
        dijkstra(graph, startVertex,end);
    }

}