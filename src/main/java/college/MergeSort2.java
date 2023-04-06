package college;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size :-");
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();

    mergesort(arr, 0, arr.length - 1);
    // merging in range
    // mergesort(arr, 0, 3);

    System.out.println(Arrays.toString(arr));
  }

  static void mergesort(int[] arr, int start, int end) {
    if (start == end) {
      return;
    }

    int mid = start + (end - start) / 2;

    mergesort(arr, start, mid);
    mergesort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }

  private static void merge(int[] arr, int start, int mid, int end) {
    int[] mix = new int[end - start + 1];
    int i = start;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= end) {
      if (arr[i] < arr[j]) {
        mix[k] = arr[i];
        i++;
      } else {
        mix[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      mix[k] = arr[i];
      i++;
      k++;
    }

    while (j <= end) {
      mix[k] = arr[j];
      j++;
      k++;
    }

    for (int l = 0; l < mix.length; l++) {
      arr[start + l] = mix[l];
    }
  }
}
