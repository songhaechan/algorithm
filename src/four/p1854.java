package four;

import java.io.*;
import java.util.*;

public class p1854 {
    static int k;
    static List<Node>[] list;
    // 최단 거리를 우선순위 큐로 저장
    static PriorityQueue<Integer>[] distanceQue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 도시
        int n = Integer.parseInt(st.nextToken());
        // 도로
        int m = Integer.parseInt(st.nextToken());
        // k번째 경로
        k = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        distanceQue = new PriorityQueue[n+1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            distanceQue[i] = new PriorityQueue<>(k, Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, t));
        }
        distanceQue[1].add(0);
        bfs(1);
        for (int i = 1; i < n + 1; i++) {
            if(distanceQue[i].size() == k){
                sb.append(distanceQue[i].peek()).append("\n");
            }else{
                sb.append("-1").append("\n");
            }
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    static void bfs(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        while(!q.isEmpty()){
            Node select = q.poll();
            int vertex = select.vertex;
            int weight = select.weight;

            for(Node elem : list[vertex]){
                // 큐가 k개보다 적게 들어있다면 그냥 넣기 (직전 노드의
                if(distanceQue[elem.vertex].size()<k){
                    distanceQue[elem.vertex].offer(weight+elem.weight);
                    q.offer(new Node(elem.vertex,weight+ elem.weight));
                }else if(distanceQue[elem.vertex].peek() > weight + elem.weight){
                    distanceQue[elem.vertex].poll();
                    distanceQue[elem.vertex].offer(weight+ elem.weight);
                    q.offer(new Node(elem.vertex,weight+ elem.weight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
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
