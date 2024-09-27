package sort;

/**
 * 시간 복잡도 Worst Case 빅세타(n^2) Best case 빅세타(n)
 * Best case 경우 모든 원소가 정렬된 case
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        boolean swapped;
        for (int i = arr.length-1; i >0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        for (final int j : arr) {
            System.out.println(j);
        }
    }
}
