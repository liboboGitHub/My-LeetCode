import java.util.ArrayList;
import java.util.List;

public class Solution52 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
    
        return res;
        
    }

    private void backtrack(List<String> board, int row) {

        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            StringBuilder s = new StringBuilder(board.get(row));
            s.setCharAt(col, 'Q');
            board.set(row, s.toString());

            backtrack(board, row + 1);

            // 撤销选择
            s.setCharAt(col, '.');
            board.set(row, s.toString());
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 判断该列是否重复
        for (String s : board) {
            if (s.charAt(col) == 'Q') {
                return false;
            }
        }
        // 判断右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 判断左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }
    
}
