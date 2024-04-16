package sm;

import java.io.*;
import java.util.*;

public class p1753 {
    static List<Node>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        list = new List[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            list[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
        }

        bfs(K);

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
        bw.flush();
        bw.close();
    }
    static void bfs(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start,0));
        distance[start] = 0;
        while(!que.isEmpty()){
            Node now = que.poll();
            if(visited[now.vertex]) continue;
            visited[now.vertex] = true;
            for(Node next : list[now.vertex]){
                if(distance[next.vertex] > distance[now.vertex] + next.weight){
                    distance[next.vertex] = distance[now.vertex] + next.weight;
                    que.add(new Node(next.vertex,distance[next.vertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
