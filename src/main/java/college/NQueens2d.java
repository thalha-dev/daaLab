package college;

public class NQueens2d {
  private int n;
  private int[][] board;

  public NQueens2d(int n) {
    this.n = n;
    board = new int[n][n];
  }

  public void solve() {
    if (backtrack(0)) {
      printSolution();
    } else {
      System.out.println("No solution found.");
    }
  }

  private boolean backtrack(int row) {
    if (row == n) {
      return true;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(row, col)) {
        board[row][col] = 1;
        if (backtrack(row + 1)) {
          return true;
        }
        board[row][col] = 0;
      }
    }

    return false;
  }

  private boolean isSafe(int row, int col) {
    // Check column
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false;
      }
    }

    // Check diagonal (top-left to bottom-right)
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    // Check diagonal (top-right to bottom-left)
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  private void printSolution() {
    System.out.println("Solution:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = 4; // Change the value of n for different board sizes
    NQueens2d nQueens = new NQueens2d(n);
    nQueens.solve();
  }
}
