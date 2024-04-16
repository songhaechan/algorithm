package three;

import java.io.*;
import java.util.*;

public class 중량제한 {
    static ArrayList<City>[] graph;
    // max 는 찾고자하는 중량의 최대값 maxHigh 는 다리 중 최대 중량
    static int maxHigh, max;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<City>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new City(to, weight));
            graph[to].add(new City(from, weight));
            maxHigh = Math.max(maxHigh, weight);
        }

        // 공장 찾기
        st = new StringTokenizer(br.readLine());
        int factoryA = Integer.parseInt(st.nextToken());
        int factoryB = Integer.parseInt(st.nextToken());

        binarySearch(n, factoryA, factoryB);
        System.out.println(max);
    }

    static void binarySearch(int n, int factoryA, int factoryB) {
        int low = 1;
        int high = maxHigh;
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[n + 1];

        while(low <= high) {
            int mid = (low + high) / 2;
            // 출발 공장 큐에 삽입
            q.add(factoryA);
            // 출발 공장 방문 체크
            checked[factoryA] = true;

            boolean existed = bfs(q, checked, mid, factoryB);
            // 해당 중량을 옮길 수 있음
            if(existed) {
                max = Math.max(max, mid);
                low = mid + 1;
            }
            else {	// 해당 중량을 옮길 수 없음
                high = mid - 1;
            }

            // 초기화
            q.clear();
            Arrays.fill(checked, false);
        }
    }

    // 중량에 맞는 경로 존재하는지 찾기
    static boolean bfs(Queue<Integer> q, boolean[] checked, int mid, int end) {
        while(!q.isEmpty()) {
            int from = q.poll();

            for(City c : graph[from]) {
                // 다음 노드와의 다리가 mid(이진 탐색의 현재 최대 중량)보다 높으면 통과 낮으면 갈 수 없음
                if(c.weight >= mid) {
                    // 목표 공장까지 도달한 경우만 true
                    if(from == end) {
                        return true;
                    }
                    //방문 검사
                    if(!checked[c.end]) {
                        checked[c.end] = true;
                        q.add(c.end);
                    }
                }
            }
        }

        return false;
    }
}

class City {
    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

