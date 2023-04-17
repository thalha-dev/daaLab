package college;

import java.util.Scanner;

public class Knapsack01 {

  public static int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= capacity; w++) {
        if (i == 0 || w == 0) {
          dp[i][w] = 0;
        } else if (weights[i - 1] <= w) {
          dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    return dp[n][capacity];
  }

  public static void main(String[] args) {
    System.out.println("Enter number of elements ");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] weights = new int[n];
    int[] values = new int[n];
    System.out.println("Enter weight for " + n + " elements");
    for (int i = 0; i < n; i++) weights[i] = scan.nextInt();
    System.out.println("Enter value for " + n + " elements");
    for (int i = 0; i < n; i++) values[i] = scan.nextInt();
    System.out.println("Enter knapsack weight ");
    int capacity = scan.nextInt();
    scan.close();
    int maxProfit = knapsack(weights, values, capacity);
    System.out.println("Maximum Profit: " + maxProfit);
  }
}
