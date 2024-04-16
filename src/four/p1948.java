package four;

import java.io.*;
import java.util.*;

public class p1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[n+1];
        List<Node>[] reverseList = new List[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            inDegree[e]++;
            list[s].add(new Node(e,c));
            reverseList[e].add(new Node(s,c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int[] result = new int[n+1];

        while (!q.isEmpty()) {
            int now = q.poll();
            for(Node elem : list[now]){
                inDegree[elem.targetNode]--;
                result[elem.targetNode] = Math.max(result[elem.targetNode],result[now]+ elem.weight);
                if(inDegree[elem.targetNode] == 0){
                    q.offer(elem.targetNode);
                }
            }
        }

        // 위상정렬 반대로
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        q = new LinkedList<>();
        q.offer(end);
        visited[end] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node elem : reverseList[now]){
                // 방문 여부를 검사하기 전에
                if(result[now] == result[elem.targetNode] + elem.weight){
                    cnt++;
                    // 이미 방문한 곳은 큐에 넣지 않음
                    if(visited[elem.targetNode] == false){
                        visited[elem.targetNode] = true;
                        q.offer(elem.targetNode);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(cnt);
    }

    static class Node{
        int targetNode;
        int weight;

        public Node(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }
}
