package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class NetworkDelay {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = Arrays.stream(times).collect(Collectors.groupingBy(t->t[0]));
        int[] visited = new int[n+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        Queue<int[]> que = new PriorityQueue<>((e1,e2)-> e1[1]-e2[1]);
        que.add(new int[]{k,0});
        visited[k]= 0;

        int maxTime = 0;
        int nodeCount = 1;

        while(!que.isEmpty()){
            int[] cur = que.remove();
            int u = cur[0], time = cur[1];
            if(visited[u] < time) continue;
            maxTime = time;

            if(!edges.containsKey(u)) continue;
            for(int[] edge : edges.get(u)){
                int v = edge[1] , w = edge[2];
                if(visited[v] <= time+w) continue;
                if (visited[v] == Integer.MAX_VALUE) nodeCount++;
                visited[v] = time + w;
                que.add(new int[]{ v, time + w });
            }

        }
        return nodeCount == n ? maxTime : -1;
    }
}
