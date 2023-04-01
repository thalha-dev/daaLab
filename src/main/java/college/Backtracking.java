package college;

class Backtracking {
  public static boolean isAttack(int i, int j, int board[][], int N) {
    int k, l;
    // checking for column j
    for (k = 1; k <= i - 1; k++) {
      if (board[k][j] == 1) return true;
    }
    // checking upper right diagonal
    k = i - 1;
    l = j + 1;
    while (k >= 1 && l <= N) {
      if (board[k][l] == 1) return true;
      k = k + 1;
      l = l + 1;
    }
    // checking upper left diagonal
    k = i - 1;
    l = j - 1;
    while (k >= 1 && l >= 1) {
      if (board[k][l] == 1) return true;
      k = k - 1;
      l = l - 1;
    }
    return false;
  }

  public static boolean nQueen(int row, int n, int N, int board[][]) {
    if (n == 0) return true;
    for (int j = 1; j <= N; j++) {
      if (!isAttack(row, j, board, N)) {
        board[row][j] = 1;
        if (nQueen(row + 1, n - 1, N, board)) return true;
        board[row][j] = 0; // backtracking
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] board = new int[5][5];
    for (int i = 0; i <= 4; i++) {
      for (int j = 0; j <= 4; j++) board[i][j] = 0;
    }
    nQueen(1, 4, 4, board);
    // printing the matix
    for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) System.out.print(board[i][j] + "\t");
      System.out.println("");
    }
  }
}
