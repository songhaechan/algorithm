package two;

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class 트리지름 {
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;
    static Deque<Integer> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 노드 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());

        A = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <n+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(stringTokenizer.nextToken());
            while(true){
                int e = Integer.parseInt(stringTokenizer.nextToken());
                // -1 이 되면 다음 줄 파싱
                if(e == -1){
                    break;
                }
                int v = Integer.parseInt(stringTokenizer.nextToken());
                A[node].add(new Node(e,v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        que = new LinkedList<>();

        // 임의의 노드에서 시작해 거리가 가장 긴 끝 노드는 트리 지름의 양 노드 중 하나이다.
        // 이걸 어떻게 생각하는데;;
        BFS(1);
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i <n+1; i++) {
            if(distance[i] > max){
                max = distance[i];
                maxIndex = i;
            }
        }
        for (int i = 1; i <n+1 ; i++) {
            distance[i] = 0;
        }
        for (int i = 1; i <n+1; i++) {
            visited[i] = false;
        }
        // 이미 위에서 트리 지름의 양 끝 노드 중 하나를 구했기 때문에 그 노드에서 마지막으로 BFS 탐색
        BFS(maxIndex);
        int result = Arrays.stream(distance).max().getAsInt();
        bufferedWriter.write(result+"\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    static class Node{
        int num;
        int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }

    private static void BFS(int number){
        que.add(number);
        visited[number] = true;

        while(!que.isEmpty()){
            Integer removed = que.remove();
            for(Node elem : A[removed]){
                if(!visited[elem.num]){
                    visited[elem.num] = true;
                    que.add(elem.num);
                    distance[elem.num] = elem.length + distance[removed];
                }
            }
        }
    }
}
