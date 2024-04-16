    package sm;

    import java.io.*;
    import java.util.StringTokenizer;

    public class p2003 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] sum = new int[N+1];
            sum[0]=0;
            for (int i = 0; i< N; i++) {
                sum[i+1] = sum[i] + arr[i];
            }
            int start = 0;
            int end = 0;
            int count = 0;
            int target = 0;
            while(end<=N){
                if(target == M){
                    count++;
                    end++;
                }else if(target < M){
                    end++;
                }else{
                    start++;
                }
                if(end>N) break;
                target = sum[end] - sum[start];
            }
            System.out.println(count);
        }
    }
