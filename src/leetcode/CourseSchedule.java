package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<int[]>> edges = Arrays.stream(prerequisites).collect(Collectors.groupingBy(p -> p[1]));
        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> que = new ArrayDeque<>();
        int count = 0;
        for (int[] i : prerequisites) {
            indegree[i[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                visited[i] = true;
                que.add(i);
                count++;
            }
        }

        if (que.isEmpty()) {
            return false;
        }
        while (!que.isEmpty()) {
            int c = que.remove();

            for (int[] i : prerequisites) {
                if (i[1] == c) {
                    indegree[i[0]]--;
                }
            }

            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                    count++;
                }
            }

        }
        return count == numCourses ? true : false;
    }

}
