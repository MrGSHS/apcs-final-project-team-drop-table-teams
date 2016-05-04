 

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
	}

	public TTT(int r, int c) {
		board = new int[r][c];
	}

	public void changeBoard(int r, int c, int v) {
		board[r][c] = v;
	}

	public int getBoard(int r, int c) {
		return board[r][c];
	}
}
