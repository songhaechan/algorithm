package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p24060 {
    static int[] ans;
    static int count = 0;
    static int K;
    static int N;
    static int saved = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        ans = new int[N];

        merge_sort(list,0,list.length-1);
        if(count<K){
            System.out.println(saved);
        }else{
            System.out.println(saved);
        }
        bw.flush();
        bw.close();
    }
    static void merge_sort(int[] list, int l, int r){
        int q = (l+r)/2;
        if(l==r){
            return;
        }
        if(l<r){
            merge_sort(list,l,q);
            merge_sort(list,q+1,r);
            merge(list,l,q,r);
        }
    }
    static void merge(int[] list,int left,int mid, int right){
        int l = left;
        int r = mid + 1;
        int index = left;
        while(l<=mid && r<=right){
            if(list[l]<=list[r]){
                ans[index] = list[l];
                index++;
                l++;
            }else{
                ans[index] = list[r];
                index++;
                r++;
            }
        }
        if(l>mid){
            while(r<=right){
                ans[index] = list[r];
                index++;
                r++;
            }
        }else{
            while(l<=mid){
                ans[index] = list[l];
                index++;
                l++;
            }
        }
        for (int i = left; i <=right; i++) {
            count++;
            if(count==K){
                saved = ans[i];
            }
            list[i] = ans[i];
        }
    }
}
