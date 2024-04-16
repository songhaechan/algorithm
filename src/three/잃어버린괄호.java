package three;

import java.io.*;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine(),"-");
        StringBuilder sb = new StringBuilder();

        // 초기상태 체크
        int result= Integer.MAX_VALUE;
        while(st1.hasMoreTokens()){
            int tmp = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }
            if(result == Integer.MAX_VALUE){
                result = tmp;
            }else{
                result -= tmp;
            }
        }

        bw.write(result+"\n");

        bw.flush();
        bw.close();
    }
}
