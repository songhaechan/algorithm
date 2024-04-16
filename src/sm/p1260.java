package sm;

import java.io.*;
import java.util.*;

public class p1260 {
    static List<Integer>[] list;
    static int N,M,V;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end); list[end].add(start);
        }
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited,false);
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
            Integer now = que.poll();
            sb.append(now).append(" ");
            Collections.sort(list[now]);
            for(Integer next : list[now]){
                if(!visited[next]){
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
    static void dfs(int start){
        sb.append(start).append(" ");
        visited[start] = true;
        Collections.sort(list[start]);
        for(Integer next : list[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
