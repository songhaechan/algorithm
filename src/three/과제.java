package three;

import java.io.*;
import java.util.*;

public class 과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Assignment> q = new PriorityQueue<>();
        Assignment[] works = new Assignment[n];
        int lastDay = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            works[i] = new Assignment(deadline,score);
            // 마감기한이 가장 긴 날
            lastDay = Math.max(lastDay, deadline);
        }

        Arrays.sort(works,(o1, o2) -> o2.deadLine - o1.deadLine);

        int result = 0;
        int worksIndex = 0;

        for (int i = lastDay; i >0; i--) {
            // 리스트를 순회하며 마지막날부터 풀수있는 문제를 큐에 삽입 / 큐는 점수를 내림차순으로 정렬 중
            while(worksIndex < n && works[worksIndex].deadLine >= i){
                q.offer(works[worksIndex++]);
            }
            if(!q.isEmpty()) result += q.poll().score;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
    static class Assignment implements Comparable<Assignment>{
        int deadLine;
        int score;

        public Assignment(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            return o.score - this.score;
        }
    }
}
