package college;

class SumOfSubsets {
  // function to check whether the subset of given sum is present or not
  static int subsetSum(int a[], int n, int sum) {
    // Initializing matrix as -1.
    int arr[][] = new int[n + 1][sum + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        arr[i][j] = -1;
      }
    }
    if (sum == 0) return 1;
    if (n <= 0) return 0;
    if (arr[n - 1][sum] != -1) return arr[n - 1][sum];
    if (a[n - 1] > sum) return arr[n - 1][sum] = subsetSum(a, n - 1, sum);
    else {
      if (subsetSum(a, n - 1, sum) != 0 || subsetSum(a, n - 1, sum - a[n - 1]) != 0) {
        return arr[n - 1][sum] = 1;
      } else return arr[n - 1][sum] = 0;
    }
  }

  public static void main(String[] args) {
    int n = 5;
    int a[] = {1, 5, 3, 7, 4};
    int value = 12;
    if (subsetSum(a, n, value) != 0) {
      System.out.println("YES");
    } else System.out.println("NO");
  }
}
