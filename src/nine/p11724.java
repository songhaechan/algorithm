package nine;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p11724 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 방문배열 초기화
        visited = new boolean[v+1];
        // 인접리스트 추가
        for (int i = 0; i < v+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        int resCount = 0;

        for (int i = 1; i < v+1; i++) {
            if(!visited[i]){
                resCount++;
                dfs(i);
            }
        }

        System.out.println(resCount);
    }
    static void dfs(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int next : list.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
