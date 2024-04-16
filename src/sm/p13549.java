package sm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p13549 {
    static boolean[] visited;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[200001];
        int res = bfs(N);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int bfs(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start,0));
        visited[start] = true;
        int res = 0;
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.number == K){
                res = now.time;
                break;
            }
            if(now.number*2 > 200000){
                continue;
            }
            if(!visited[now.number*2]){
                que.add(new Node(now.number*2,now.time));
                visited[now.number*2] = true;
            }
            if(now.number-1 < 0){
                continue;
            }
            if(!visited[now.number-1]){
                que.add(new Node(now.number-1,now.time+1));
                visited[now.number-1] = true;
            }
            if(!visited[now.number+1]){
                que.add(new Node(now.number+1,now.time+1));
                visited[now.number+1] = true;
            }
        }
        return res;
    }
    static class Node implements Comparable<Node> {
        int number;
        int time;

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", time=" + time +
                    '}';
        }

        public Node(int number, int time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time == o.time){
                return this.number - o.number;
            }else{
                return this.time - o.time;
            }
        }
    }
}
