package two;

import java.io.*;
import java.util.StringTokenizer;

public class 퀵정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        quickSort(array,0,n-1,k-1);
        System.out.println(array[k-1]);
    }

    static void quickSort(int[] array, int start, int end, int k){
        if(start < end){
            int pivot = partition(array,start,end);
            if(pivot == k){
                return;
            } else if(k < pivot){
                quickSort(array,start,pivot-1,k);
            } else
                quickSort(array,pivot+1,end,k);
        }
    }

    static int partition(int[] array, int start, int end){
        if(start+1 == end){
            if(array[start] > array[end]){
                // start와 end가 만나면 그리고 정렬이 필요하다면
                swap(array,start,end);
            }
            return end;
        }
        int middle = (start + end) / 2;
        // start 와 end 의 움직임을 위해서 시작 인덱스와 자리바꿈
        swap(array,start,middle);
        int pivot = array[start];
        int i = start + 1;
        int j = end;
        // 두 포인터가 만나기 전까지 반복
        while(i<=j){
            // pivot 보다 작으면 계속 ++
            while(array[i] < pivot && i<array.length-1){
                i++;
            }

            // pivot 보다 크면 계속 --
            while(array[j] > pivot && j>0){
                j--;
            }

            if(i<=j){
                swap(array,i,j);
                // swap 하면 한 칸씩 이동하고 위 과정 반복
                i++; j--;
            }
        }
        // 인덱스는 i 든 j 든 상관없음 피봇과 교체할 뿐
        array[start] = array[j];
        array[j] = pivot;
        // 피봇의 인덱스 리턴
        return j;
    }

    static void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
