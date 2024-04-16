package ten;

import java.io.*;
import java.util.*;

public class p12757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());

            if (order == 1) {
                map.put(key, Integer.parseInt(st.nextToken()));
                continue;
            }
            if (order == 2) {
                int newItem = Integer.parseInt(st.nextToken());
                if (map.containsKey(key)) {
                    map.put(key, newItem);
                    break;
                } else {
                    Integer pre = map.floorKey(key);
                    Integer post = map.ceilingKey(key);
                    if (post == null) {
                        post = -k;
                    }
                    if (pre == null) {
                        pre = k;
                    }
                    int val1 = Math.abs(post - key);
                    int val2 = Math.abs(-pre + key);
                    if (val1 > k && val2 > k) {
                        continue;
                    } else if (val1 == val2) {
                        continue;
                    } else {
                        key = val1 < val2 ? pre : post;
                        map.put(key, newItem);
                    }
                }
                continue;
            }
            if (order == 3) {
                Integer pre = map.floorKey(key);
                Integer post = map.ceilingKey(key);
                if (post == null) {
                    post = -k;
                }
                if (pre == null) {
                    pre = k;
                }
                int val1 = Math.abs(post - key);
                int val2 = Math.abs(-pre + key);
                if (val1 > k && val2 > k) {
                    bw.write("-1");
                    bw.write('\n');
                } else if (val1 == val2) {
                    bw.write("?");
                    bw.write('\n');
                } else {
                    key = val1 < val2 ? pre : post;
                    bw.write(map.get(key).toString());
                    bw.write('\n');
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
