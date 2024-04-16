package four;

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class p1753 {
    static List<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 정점
        int v = Integer.parseInt(st.nextToken());
        // 엣지
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 출발 노드
        int k = Integer.parseInt(st.nextToken());

        list = new List[v+1];
        visited = new boolean[v+1];

        //인접리스트 초기화
        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v2, w));
        }

        // 최단거리 배열
        distance = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 출발 노드는 0으로 초기화
        distance[k] = 0;

        bfs(k);

        for (int i = 1; i < v + 1; i++) {
            if(visited[i]){
                sb.append(distance[i]).append("\n");
            }else{
                sb.append("INF").append("\n");
            }
        }

        bw.write(String.valueOf(sb));
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
