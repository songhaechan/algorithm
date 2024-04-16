    package nine;

    import java.io.*;
    import java.util.StringTokenizer;

    public class p1493 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] cube = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            long before = 0;
            long ans = 0;
            for (int i = N-1; i >=0 ; i--) {
                before <<= 3;
                long divideCube = (long) (L >> i)*(W >> i)*(H>>i) - before;
                ans += Math.min(cube[i],divideCube);
                before += Math.min((long)cube[i],divideCube);
            }

            if (before == (long) L * W * H) { // 위에서 계산한 before가 실제 박스의 부피와 같아야 함.
                System.out.println(ans);
            } else { // 같지 않으면, 주어진 큐브로는 박스를 구성할 수 없다.
                System.out.println(-1);
            }
        }
    }
