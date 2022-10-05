package graph.shortestpath.weighted;

import java.util.Arrays;

public class Dijkstra1_Revised {
    public static void main(String[] args) {
        int n = 7;
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        
        graph[0][1] = 1;
        graph[0][2] = 2;
        graph[0][3] = 4;
        graph[1][0] = 1;
        graph[1][3] = 3;
        graph[4][5] = 5;
        graph[4][6] = 2;
        graph[4][3] = 3;
        graph[3][4] = 1;

//        0,1,2,4,-1,-1,-1,
//        1,0,-1,3,-1,-1,-1,
//        -1,-1,0,-1,-1,-1,-1,
//        -1,-1,-1,0,1,-1,-1,
//        -1,-1,-1,3,0,5,2,
//        -1,-1,-1,-1,-1,0,-1,
//        -1,-1,-1,-1,-1,-1,0,


        int[] dist = new int[n];
        dijkstra1(5, dist, graph);
        System.out.println(Arrays.toString(dist));
    }
    
    public static void dijkstra1(int cur, int[] dist, int[][] graph) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[cur] = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == Integer.MAX_VALUE || dist[i] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[j] > dist[i] + graph[i][j]) {
                    dist[j] = dist[i] + graph[i][j];
                }
            }
        }
    }
}
