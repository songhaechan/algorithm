package three;

import java.io.*;
import java.util.*;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        List<Meeting> meet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meet.add(new Meeting(start, end, end-start));
        }
        meet.sort((Meeting o1, Meeting o2)-> {
            if(o1.end < o2.end) return -1;
            else if(o1.end.equals(o2.end)){
                return o1.start - o2.start;
            }else{
                return 1;
            }
        });

        int index = 0;
        int cnt = 0;
        int start = 0;
        int end = 0;

        while(index < n){
            if(meet.get(index).start < end){
                index++;
            } else if(meet.get(index).start == end){
                end = meet.get(index).end;
                cnt++;
                index++;
            }else{
                end = meet.get(index).end;
                index++;
                cnt++;
            }
        }

        bw.write(cnt+"\n");

        bw.flush();
        bw.close();
    }

    static class Meeting{
        Integer start;
        Integer end;
        Integer duration;

        public Meeting(Integer start, Integer end, Integer duration) {
            this.start = start;
            this.end = end;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    ", duration=" + duration +
                    '}';
        }
    }
}
