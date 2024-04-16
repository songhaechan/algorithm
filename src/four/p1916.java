package four;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1916 {
    static List<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 도시
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 버스
        int m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        visited = new boolean[n+1];

        //인접리스트 초기화
        for (int i = 1; i <  n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 최단거리 배열
        distance = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,f));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        bfs(start);

        bw.write(String.valueOf(sb.append(distance[end]+"\n")));

        bw.flush();
        bw.close();
    }

    static void bfs(int k){
        // 우선순위 큐를 사용하는 이유 = 일단 방문체크를 해야하는데 방문체크하면 최단 경로가 안나올 수 있음 그런데 우선순위큐를 사용하면 그 예외를 잡아줌
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(k,0));
        while(!q.isEmpty()){
            Node elem = q.poll();
            if(visited[elem.vertex]){
                continue;
            }
            visited[elem.vertex] = true;
            for(Node next : list[elem.vertex]){
                // 업데이트 하는 경우
                //선택된 노드의 최단거리 + 다음 노드까지의 가중치 , 다음 노드의 최단 거리 중 최소
                if(distance[elem.vertex]+next.weight < distance[next.vertex]){
                    distance[next.vertex] = distance[elem.vertex]+next.weight;
                    // 왜 새로운 노드 ?? 업데이트 한 값을 기준으로 최소 경로를 찾아야하니까 next를 그대로 넣으면 업데이트가 안되잖아...
                    q.add(new Node(next.vertex,distance[next.vertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
