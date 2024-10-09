package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start<end){
            int pivot = partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }
    public static int partition(int[] arr, int start, int end){
        int x = arr[end];
        int i = start - 1;
        for(int j=start; j<end; j++){
            if(arr[j]<x)
                swap(arr,++i,j);
        }
        swap(arr,i+1,end);
        return i+1;
    }
    public static void swap(int[] arr, int targetIdx, int sourceIdx){
        int tmp = arr[targetIdx];
        arr[targetIdx] = arr[sourceIdx];
        arr[sourceIdx] = tmp;
    }
}
