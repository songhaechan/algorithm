package bj222;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class p15649 {
    static boolean[] isVisited;
    static List<Integer>[] matrix;
    static int M;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new List[N+1];
        isVisited = new boolean[N+1];
        ans = new int[N+1];
        for (int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList();
        }

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(i==j) continue;
                matrix[i].add(j);
            }
        }

        for (int i = 1; i <= N; i++) {
            dfs(i,0);
            Arrays.fill(isVisited,false);
            Arrays.fill(ans,0);
        }

    }
    static void dfs(int node, int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(ans[i]+" ");
                System.out.println();
            }
        }
        isVisited[node] = true;
        ans[depth] = node;
        for(Integer next : matrix[node]){
            if(!isVisited[next]){
                ans[depth++] = next;
                dfs(next,depth);
            }
        }
    }
}
