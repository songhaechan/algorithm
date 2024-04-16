package four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] distance = new long[n+1];
        Edge[] edges = new Edge[m];

        // 거리배열 초기화
        Arrays.fill(distance,Integer.MAX_VALUE);
        // 시작점 0으로 초기화
        distance[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start,end,time);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                // INF는 distance[edge.start] + time 를 구할 수가 없으니까 걸러
                // 최악으로 시작노드1과 완전히 동떨어진 6부터 edge리스트를 주면 첫번째 조건에 다 걸려서 루프 한번만 돌아선 모든 노드의 최소
                // 를 구할 수가 없다.
                // 최악의 경우 모든 엣지를 돌았는데 distance배열 중 단 하나의 노드만 최솟값을 업데이트 할 수 있음
                // 진짜 최악의 경우 노드개수 - 1 번 돌아야 모든 최솟값들을 찾을 수 있음
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean mCycle = false;

        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time){
                mCycle = true;
            }
        }

        if(!mCycle){
            for (int i = 2; i <=n; i++) {
                if(distance[i] == Integer.MAX_VALUE)
                    sb.append("-1").append("\n");
                else
                    sb.append(distance[i]).append("\n");
            }
        }else{
            sb.append("-1").append("\n");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
    static class Edge{
        int start,end,time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
