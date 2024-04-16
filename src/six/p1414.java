package six;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1414 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 컴퓨터의 수
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>();
        parent = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        int totalSum = 0;

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j <n; j++) {
                int c = line.charAt(j);
                int tmp = 0;
                if(c == 48){
                    continue;
                }
                // 소문자
                if(97<= c && c<= 122){
                    tmp = c - 97 + 1;
                    totalSum += tmp;
                }else {
                    tmp = c - 65 + 27;
                    totalSum += tmp;
                }
                if(i!=j) q.offer(new Node(i+1,j+1,tmp));
            }
        }


        int result = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Node elem = q.poll();
            if(find(elem.s) != find(elem.e)){
                union(elem.s,elem.e);
                result += elem.w;
                cnt++;
            }
        }

        if(cnt == n-1){
            System.out.println(totalSum-result);
        }else{
            System.out.println(-1);
        }

    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        int i = find(a);
        int j = find(b);
        if(i<j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }
    }
    static class Node implements Comparable<Node>{
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
