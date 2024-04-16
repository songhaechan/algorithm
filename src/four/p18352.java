package four;

import java.io.*;
import java.util.*;

public class p18352 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] distance;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // K 이하로 도착하는 모든 노드는 방문처리
        visited = new boolean[n + 1];
        // x 부터 모든 노드까지의 거리
        distance = new int[n + 1];

        list = new List[n + 1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }
        visited[x] = true;
        bfs(x,k);
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if(distance[i] == k){
                count++;
                sb.append(i).append("\n");
            }
        }
        if(count == 0){
            System.out.println(-1);
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    static void bfs(int start,int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Integer elem = q.poll();
            for (Integer city : list[elem]) {
                if(distance[elem] > target){
                    continue;
                }
                if(!visited[city]){
                    distance[city] = distance[elem] + 1;
                    visited[city] = true;
                    q.add(city);
                }
            }
        }
    }
}
