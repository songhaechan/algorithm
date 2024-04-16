package four;

import java.io.*;
import java.util.*;

public class p1325 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        int[] result = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            count=0;
            bfs(i);
            result[i] = count;
            max = Math.max(count,max);
        }

        for (int i= 1;  i<n+1 ; i++) {
            if(result[i] == max){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
    public static void bfs(int start) {
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int elem = q.poll();
            for (int com : list.get(elem)) {
                if(!visited[com]){
                    q.add(com);
                    visited[com] = true;
                    count++;
                }
            }
        }
    }
}
