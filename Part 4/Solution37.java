public class Solution37 {
    public void solveSudoku(char[][] board) {
        if (backtrace(board, 0, 0)) {
            return;
        }
    }
    private boolean backtrace(char[][] board, int r, int c) {
        int m = 9, n = 9;
        // base case
        if (r == m) {
            return true;
        }
        // 当前行已经遍历结束
        if (c == n) {
            return backtrace(board, r + 1, 0);
        }
        // 当前位置有数字
        if (board[r][c] != '.') {
            return backtrace(board, r, c + 1);
        }
        // 试着在当前位置放入“合适”的数字
        for (char ch = '1'; ch <= '9'; ch++) {
            // 当前放的数字不合法
            if (!isVaild(board, r, c, ch)) {
                continue;
            }
            // 当前位置放数字
            board[r][c] = ch;
            // 下一个位置
            if(backtrace(board, r, c + 1)){
                return true;
            }
            // 撤销选择
            board[r][c] = '.';
        }
        return false;
    }

    /* 判断当前位置的数字是否合法 */
    private boolean isVaild(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // 当前行是否有重复数字
            if (board[r][i] == ch) {
                return false;
            }
            // 当前列是否有重复数字
            if (board[i][c] == ch) {
                return false;
            }
            // 当前的9格里是否有重复数字
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}
