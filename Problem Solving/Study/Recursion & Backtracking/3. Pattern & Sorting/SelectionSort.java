import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        selectionSort(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int row, int col, int maxIndex){
        if (row == 0) return;  // Base case

        if (col <= row) {  // Traverse current "row" to find max
            if (arr[col] > arr[maxIndex]) {
                maxIndex = col;
            }
            selectionSort(arr, row, col + 1, maxIndex);
        } else {
            // Swap max element with the last element of this "row"
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[row];
            arr[row] = temp;

            // Recurse for remaining array
            selectionSort(arr, row - 1, 0, 0);
        }
    }
}
