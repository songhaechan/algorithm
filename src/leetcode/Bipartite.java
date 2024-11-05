package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Deque<Integer> que = new ArrayDeque();
        for (int i = 0; i < graph.length; i++) {
            if (color[i]==1 || color[i]==2) {
                continue;
            }
            color[i] = 1;
            que.add(i);
            while (!que.isEmpty()) {
                int cur = que.poll();
                for (int next : graph[cur]) {
                    if (color[cur]==color[next]) {
                        return false;
                    }
                    if (color[next]==0) {
                        que.add(next);
                        color[next] = 3 - color[cur];
                    }
                }
            }
            Arrays.fill(color, 0);
        }
        return true;
    }
}
