import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化字符数组
        char[][] board = new char[n][n];
        for (char[] c : board) {
            // 对一维数组进行填充
            Arrays.fill(c, '.');
        }
        backtrack(0, board);
        return res;
    }

    // 需要维护走过的「路径」和当前可以做的「选择列表」，当触发「结束条件」时，将「路径」记入结果集。
    private void backtrack(int row, char[][] board) {
        // 递归结束的条件
        if (row == board.length) {
            // Java 8 的API
            res.add(Arrays.stream(board).map(String::valueOf).collect(Collectors.toList()));
            return;
        }
        // 遍历每一行可以放的位置
        for (int col = 0; col < board[row].length; col++) {
            // 检查当前位置是否可放
            if (!isVaild(row, col, board)) {
                continue;
            }
            // 允许放置
            board[row][col] = 'Q';
            // 继续遍历下一行
            backtrack(row + 1, board);
            // 真正的回溯，维护前一个状态，
            // 什么时候执行？一种状态全过一遍的时候，也就是每行都尝试了一遍，不管是否是合适的，都恢复到前一种状态。
            board[row][col] = '.';

        }
    }

    private boolean isVaild(int row, int col, char[][] board) {
        // 检查正上方
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[row].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution51_2().solveNQueens(4);
    }
}
