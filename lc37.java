class Solution {
    static char dot = '.';
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
    boolean helper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == dot) {
                    for(char c = "1".charAt(0); c <= "9".charAt(0); c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if(helper(board)) return true;

                            board[i][j] = ".".charAt(0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {        
        helper(board);
    }
}