package six;

import java.io.*;
import java.util.*;

public class p1197 {
    static PriorityQueue<Edge> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // init
        list = new PriorityQueue<>();
        parent = new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            parent[i] = i;
        }

        // input
        for (int i =0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.offer(new Edge(start,end,weight));
        }

        int result = 0;
        int cnt = 0;
        while(cnt < n-1){
            Edge edge = list.poll();
            if(find(edge.start) != find(edge.end)) {
                result += edge.weight;
                union(edge.start, edge.end);
                cnt++;
            }
        }

        bw.write(String.valueOf(sb.append(result)));

        bw.flush();
        bw.close();
    }
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    static int find(int target){
        if(target == parent[target]){
            return target;
        }

        return parent[target] = find(parent[target]);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x<y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
}
