
/**
 * Write a description of class TTT here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT // Tic Tac Toe
{
    private int[][] board;

    public TTT() {
        board = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j  = 0; j < 3; j++)
                board[i][j] = 0;
    }

    public TTT(int r, int c) {
        board = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j  = 0; j < c; j++)
                board[i][j] = 0;
    }

    public void setBoard(int r, int c, int v) {
        board[r][c] = v;
    }
    
    public void setBoard(int[][] b){
        board = b;
    }

    public int[][] getBoard() {
        return board;
    }
    
    public int getBoard(int r, int c){
        return board[r][c];
    }
}
