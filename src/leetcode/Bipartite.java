package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Deque<Integer> que = new ArrayDeque();
        for (int i = 0; i < graph.length; i++) {
            color[i] = 1;
            que.add(i);
            while (!que.isEmpty()) {
                int cur = que.poll();
                int newColor = 0;
                if (color[cur]==1) {
                    newColor = 2;
                } else if (color[cur]==2) {
                    newColor = 1;
                }
                for (int next : graph[cur]) {
                    if (color[cur]==color[next]) {
                        System.out.println(cur);
                        System.out.println(color[cur]);
                        System.out.println(next);
                        System.out.println(color[next]);
                        System.out.println(newColor);
                        return false;
                    }
                    if (color[next]==0) {
                        que.add(next);
                        color[next] = newColor;
                    }
                }
            }
            Arrays.fill(color, 0);
        }
        return true;
    }
}
