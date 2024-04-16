import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1058 {

    static List<Integer> opens;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        opens= new ArrayList<>();
        for(int i=0; i<line.length; i++) {
            opens.add(Integer.parseInt(line[i]));
        }

        int test = Integer.parseInt(br.readLine());

        target = new int[test];
        for(int i=0; i<test; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solve(0,opens.get(0),opens.get(1)));

    }

    static int solve(int cnt, int a, int b) {

        if(cnt == target.length) return 0;

        int tmp1 = Math.abs(a-target[cnt]);
        int tmp2 = Math.abs(b-target[cnt]);

        return Math.min(tmp1 + solve(cnt+1,b,target[cnt]),
                tmp2 + solve(cnt+1, a, target[cnt]));

    }
}