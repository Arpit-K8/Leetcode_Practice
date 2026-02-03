class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueens(board, 0, n, ans);
        return ans;
    }
    private void nQueens(char[][] board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';   // place queen
                nQueens(board, row + 1, n, ans);
                board[row][col] = '.';   // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}

/*

```
. Q . .
. . . Q
Q . . .
. . Q .
```

Internally, your `char[][] board` looks like:

```java
[
  ['.', 'Q', '.', '.'],
  ['.', '.', '.', 'Q'],
  ['Q', '.', '.', '.'],
  ['.', '.', 'Q', '.']
]
```

But the required output format is:

```java
[
  ".Q..",
  "...Q",
  "Q...",
  "..Q."
]
```
 */