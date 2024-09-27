package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
        for (final int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void mergeSort(int[] arr,int left, int right, int[] tmp){
        //base case
        if(right==left){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid, tmp);
        mergeSort(arr,mid+1,right,tmp);
        merge(arr,left,mid,right,tmp);
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] tmp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j])
                tmp[t++] = arr[i++];
            else
                tmp[t++] = arr[j++];
        }
        while(i<=mid){
            tmp[t++] = arr[i++];
        }
        while(j<=right){
            tmp[t++] = arr[j++];
        }
        t = 0;
        i=left;
        while(i<=right){
            arr[i++] = tmp[t++];
        }
    }
}
