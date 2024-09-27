package sort;

/**
 * 시간복잡도 빅세타(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        for(int i=arr.length-1; i>0; i--){
            int idx = i;
            for (int j = 0; j <=i; j++) {
                if(arr[j]>arr[idx]){
                    idx = j;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for (final int j : arr) {
            System.out.print(j + " ");
        }
    }
}
