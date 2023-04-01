package college;

import java.util.Scanner;

public class ksack1 {
  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  static int ksack(int W, int wt[], int val[], int n) {
    int i, w;
    int[][] k = new int[n + 1][W + 1];
    for (i = 0; i <= n; i++) {
      for (w = 0; w <= W; w++) {
        if (i == 0 || w == 0) k[i][w] = 0;
        else if (wt[i - 1] <= w) k[i][w] = max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
        else k[i][w] = k[i - 1][w];
      }
    }
    return k[n][W];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of items: ");
    int n = sc.nextInt();
    System.out.println("Enter the items weights: ");
    int[] wt = new int[n];
    for (int i = 0; i < n; i++) wt[i] = sc.nextInt();
    System.out.println("Enter the the values");
    int val[] = new int[n];
    for (int i = 0; i < n; i++) val[i] = sc.nextInt();
    System.out.println("Enter the maximum capacity: ");
    int W = sc.nextInt();
    System.out.println(
        "The maximum value that can be put in a knapsack of capacity W is:  "
            + ksack(W, wt, val, n));
    sc.close();
  }
}
