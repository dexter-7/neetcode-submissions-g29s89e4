class Solution {
    private int ROWS, COLS;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) return false;
        if (board[r][c] != word.charAt(index)) return false;
        if (visited[r][c]) return false;

        if (index == word.length() - 1) return true;

        visited[r][c] = true;
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        visited[r][c] = false; // backtrack

        return found;
    }

    /*
    Complexity
    TimeO(m · 4ⁿ) — m cells × 4 choices per step for n characters
    SpaceO(n) — recursion depth + visited set, both bounded by word length
    */
}
