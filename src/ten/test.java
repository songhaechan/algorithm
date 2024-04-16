package ten;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
    static class Node implements Comparable<Node>{
        int start, end;
        Node(int start,int end){
            this.start=start;this.end=end;
        }
        @Override
        public int compareTo(Node o) {
            if(end==o.end) {
                return Integer.compare(start, o.start);
            }
            return Integer.compare(end, o.end);
        }
    }

    static Node[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N=Integer.parseInt(br.readLine());
        arr=new Node[N];
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            arr[i]=new Node(s, e);
        }

        Arrays.sort(arr);


        int count =1;
        int curEnd=arr[0].end;

        for(int i=1;i<N;i++) {
            if(arr[i].start>=curEnd) {
                count+=1;
                curEnd=arr[i].end;
            }
        }

        System.out.println(count);
    }

}
