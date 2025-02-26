package programers;

import java.util.*;

class Wires {
    public int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;

        // 그래프 구성
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] wire : wires) {
            map.putIfAbsent(wire[0], new ArrayList<>());
            map.putIfAbsent(wire[1], new ArrayList<>());
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        // 전선을 하나씩 끊어보면서 최소 차이 구하기
        for (int[] wire : wires) {
            // 간선 제거
            map.get(wire[0]).remove(Integer.valueOf(wire[1]));
            map.get(wire[1]).remove(Integer.valueOf(wire[0]));

            // DFS 탐색을 통해 한쪽 네트워크의 송전탑 개수 계산
            boolean[] visited = new boolean[n + 1];
            int size = dfs(wire[0], map, visited);

            // 두 전력망 개수 차이 계산
            int diff = Math.abs((n - size) - size);
            result = Math.min(result, diff);

            // 간선 복구
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        return result;
    }

    private int dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : map.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, map, visited);
            }
        }

        return count;
    }
}

