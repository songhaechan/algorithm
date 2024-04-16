package ten;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        List<Integer> endTime = new ArrayList<>();
        PriorityQueue<Node> que = new PriorityQueue<>();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            que.offer(new Node(start,end));
        }
        Node first = que.poll();
        endTime.add(first.end);
        boolean flag = false;
        while(!que.isEmpty()){
            flag = false;
            Node now = que.poll();
            for (int i = 0; i < endTime.size(); i++) {
                if(now.start >= endTime.get(i)){
                    endTime.remove(i);
                    endTime.add(now.end);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                endTime.add(now.end);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static class Node implements Comparable<Node>{
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        int start;
        int end;
        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }
}
