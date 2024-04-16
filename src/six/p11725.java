package six;

import java.io.*;
import java.util.*;

public class p11725 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        visited = new boolean[n+1];
        answer = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1);
        }
        dfs(1);

        for (int i = 2; i <n+1 ; i++) {
            System.out.println(answer[i]);
        }
    }
    static void dfs(int s){
        visited[s] = true;
        for(Integer elem : list[s]){
            if(!visited[elem]){
                answer[elem] = s;
                dfs(elem);
            }
        }
    }
}
