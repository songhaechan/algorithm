package sm;

import java.io.*;
import java.util.*;

public class p11724 {
    static int N;
    static int M;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2); list[node2].add(node1);
        }
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
//                dfs(i);
                bfs(i);
                result++;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dfs(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int next : list[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visited[node] = true;
        while(!que.isEmpty()){
            Integer now = que.poll();
            for(Integer next : list[now]){
                if(!visited[next]){
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
