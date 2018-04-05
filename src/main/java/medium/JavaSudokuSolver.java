package medium;

/**
 * 37. sudoku solver
 * https://leetcode.com/problems/sudoku-solver/description/
 * backtracking solution proposed by https://github.com/CyC2018/Interview-Notebook/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3.md#backtracking
 */
public class JavaSudokuSolver {
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] cubes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++)
            for(int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    cubes[cubeId(i, j)][num] = true;
                }
            }

        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++)
                backtracking(board, i, j);
    }

    private boolean backtracking(char[][] board, int r, int c) {
        while (r < 9 && board[r][c] != '.') {
            r = c == 8 ? r + 1 : r;
            c = c == 8 ? 0 : c + 1;
        }

        if (r > 8)
            return true;
        for (int num = 1; num <= 9; num ++) {
            if (rows[r][num] || cols[c][num] || cubes[cubeId(r, c)][num])
                continue;
            rows[r][num] = cols[c][num] = cubes[cubeId(r, c)][num] = true;
            board[r][c] = (char) (num + '0');
            if (backtracking(board, r, c))
                return true;
            board[r][c] = '.';
            rows[r][num] = cols[c][num] = cubes[cubeId(r, c)][num] = false;
        }
        return false;
    }

    private int cubeId(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

    public static void main(String[] args) {
        JavaSudokuSolver test = new JavaSudokuSolver();
        char[][] board = {
                {'9' ,'.', '.', '5', '.', '.', '.', '.', '8'},
                {'.' ,'.', '.', '.', '.', '.', '7', '.', '.'},
                {'.' ,'.', '.', '8', '.', '.', '.', '.', '.'},
                {'.' ,'.', '.', '1', '.', '6', '.', '.', '.'},
                {'3' ,'4', '7', '.', '.', '.', '.', '.', '.'},
                {'.' ,'.', '2', '.', '.', '.', '.', '.', '.'},
                {'.' ,'.', '.', '.', '4', '7', '2', '.', '.'},
                {'.' ,'.', '.', '.', '.', '.', '.', '.', '3'},
                {'8' ,'.', '.', '.', '.', '.', '.', '.', '9'}};
        test.solveSudoku(board);
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
