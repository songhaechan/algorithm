package sort;

/**
 * 시간복잡도 빅세타(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        for(int i=0; i<arr.length; i++){
            int tmp = i;
            for (int j = i+1; j <arr.length; j++) {
                if(arr[j]<arr[tmp]){
                    tmp = j;
                }
            }
            int c = arr[tmp];
            arr[tmp] = arr[i];
            arr[i] = c;
        }

        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
