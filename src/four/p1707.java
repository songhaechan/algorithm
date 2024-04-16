package four;

import java.io.*;
import java.util.*;

public class p1707 {
    static List<Integer>[] list;
    static boolean flag = true;
    static Queue<Integer> q = new LinkedList<>();
    // 1 -1 로 구분
    static int[] binaryGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            //정점
            int v = Integer.parseInt(st.nextToken());
            //엣지
            int e = Integer.parseInt(st.nextToken());
            list = new List[v+1];
            // 인접리스트 초기화
            for (int j = 1; j < v+1; j++) {
                list[j] = new ArrayList<>();
            }
            binaryGraph = new int[v+1];

            // 그래프
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            for (int j = 1; j < v + 1; j++) {
                if(!flag) break;
                if(binaryGraph[j] == 0){
                    bfs(j);
                    q.clear();
                }
            }
            if(!flag){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }
            Arrays.fill(binaryGraph,0);
            flag = true;
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    static void bfs(int start){
        q.offer(start);
        binaryGraph[start] = 1;
        int pre = 1;

        while(!q.isEmpty() && flag){
            Integer elem = q.poll();
            for(int next : list[elem]){
                if(binaryGraph[next] == 0){
                    q.offer(next);
                    binaryGraph[next] = binaryGraph[elem] * -1;
                }
                else if(binaryGraph[next] + binaryGraph[elem] != 0){
                    flag = false;
                    return;
                }
            }
        }
    }
}
