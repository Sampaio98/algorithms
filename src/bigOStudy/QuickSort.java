package bigOStudy;

import java.util.Arrays;

public class QuickSort {

    void main() {
        int[] arr = new int[]{0, 3, 6, 7, 8, 4, 2, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        IO.println("RESULT QUICKSORT -> " + Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
