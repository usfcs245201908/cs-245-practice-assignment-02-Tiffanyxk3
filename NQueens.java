public class NQueens
{
	int size;
	int[][] board;
	public NQueens(int n) {
		size = n;
		
	}

	public boolean canPlaceQueen(int row, int col) {
		boolean up = true;
		boolean down = true;
		boolean left = true;
		boolean right = true;
		boolean leftUp = true;
		boolean leftDown = true;
		boolean rightUp = true;
		boolean rightDown = true;
		for (int i=row-1; i>=0; i--) {
			if (board[i][col] == 1) {
				up = false;
			}
		}
		for (int i=row+1; i<size; i++) {
			if (board[i][col] == 1) {
				down = false;
			}
		}
		for (int i=col-1; i>=0; i--) {
			if (board[row][i] == 1) {
				left = false;
			}
		}
		for (int i=col+1; i<size; i++) {
			if (board[row][i] == 1) {
				right = false;
			}
		}
		int lui = row-1;
		int luj = col-1;
		while (lui>=0 && luj>=0) {
			if (board[lui][luj] == 1) {
				leftUp = false;
			}
			lui--;
			luj--;
		}
		int ldi = row+1;
		int ldj = col-1;
		while (ldi<size && ldj>=0) {
			if (board[ldi][ldj] == 1) {
				leftDown = false;
			}
			ldi++;
			ldj--;
		}
		int rui = row-1;
		int ruj = col+1;
		while (rui>=0 && ruj<size) {
			if (board[rui][ruj] == 1) {
				rightUp = false;
			}
			rui--;
			ruj++;
		}
		int rdi = row+1;
		int rdj = row+1;
		while (rdi<size && rdj<size) {
			if (board[rdi][rdj] == 1) {
				rightDown = false;
			}
			rdi++;
			rdj++;
		}

		if (up && down && left && right && leftUp && leftDown && rightUp && rightDown) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean placeQueen(int row) {
		if (row == size) {
			return true;
		}
		for (int col=0; col<size; col++) {
			if (canPlaceQueen(row, col)) {
				board[row][col] = 1;
				if (placeQueen(row+1)) {
					return true;
				}
				else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public boolean placeNQueens() throws IllegalArgumentException {
		if (size < 1) {
			throw new IllegalArgumentException();
		}
		else {
			board = new int[size][size];
		}

		if (placeQueen(0)) {
			printToConsole();
			return true;
		}
		else {
			System.out.println("Failed to place queens.");
			return false; 
		}
	}

	public void printToConsole() {
		System.out.print("\n");
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (board[i][j] == 0) {
					System.out.print("_ ");
				}
				else {
					System.out.print("Q ");
				}
				
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}