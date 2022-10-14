public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private final static char BLANK = ' ' ;
	private char[][] board ;
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	
	//Below method initialize the board with black spaces

	public Board() {
	    board = new char[NUM_OF_COLUMNS][NUM_OF_ROW];
	    for(int row = 0; row < NUM_OF_ROW; row++){
	        for(int col = 0; col < NUM_OF_COLUMNS; col++){
	            board[col][row] = BLANK;
	        }
		}
	}
	
	//Below method prints the board

	public void printBoard() {
		for(int row = 0; row < NUM_OF_ROW; row++){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
			    System.out.print("|");
				System.out.print(board[col][row]);
				}
			System.out.println("|");
		}
	}
	
	//Below class checks that whether there's any possible winning comdition 
	//If yes then returns true

	public boolean containsWin() {
	    if (diagonal_downCheck() == true || diagonal_upCheck() == true || verticalCheck() == true || horizontalCheck() == true ){
	        return true;
	    }
		return false;
	}
	
	//Below class checks that whether 4 same symbols are in one diagonal line 
	//If yes then returns true

	private boolean diagonal_downCheck() {
	    for(int row = 0; row <NUM_OF_ROW-3; row++){
			for(int col = 0; col < NUM_OF_COLUMNS-3; col++){
			    char comp_pos = board[col][row];
				if(comp_pos != BLANK && comp_pos == board[col+1][row+1] && comp_pos == board[col+2][row+2] && comp_pos == board[col+3][row+3]){
					return true;
				}
			}
		}
		return false;
	}
	
	//Below class checks that whether 4 same symbols are in one diagonal line 
	//If yes then returns true

	private boolean diagonal_upCheck() {
	    for(int row = 0; row < NUM_OF_ROW-3; row++){
			for(int col = 3; col < NUM_OF_COLUMNS; col++){
			    char comp_neg = board[col][row];
				if(comp_neg != BLANK && comp_neg == board[col-1][row+1] && comp_neg == board[col-2][row+2] && comp_neg == board[col-3][row+3]){
					return true;
				}
			}
		}
		return false;
	}
	
	//Below class checks that whether 4 same symbols are in one single column 
	//If yes then returns true

	private boolean verticalCheck() {
	    for(int row = 0; row < NUM_OF_ROW; row++){
			for(int col = 0; col < NUM_OF_COLUMNS-3; col++){
			    char comp_col = board[col][row];
				if(comp_col != BLANK && comp_col == board[col+1][row] && comp_col == board[col+2][row] && comp_col == board[col+3][row]){
					return true;
				}
			}
		}
		return false;
	}
	
	//Below class checks that whether 4 same symbols are in one single row
	//If yes then returns true

	private boolean horizontalCheck() {
	    for(int row = 0; row < NUM_OF_ROW-3; row++){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
			    char comp_row = board[col][row];
				if(comp_row != BLANK && comp_row == board[col][row+1] && comp_row == board[col][row+2] && comp_row == board[col][row+3]){
					return true;
				}
			}
		}
		return false;
	}
	
	//Below class checks that whether all postions are full or not
	//If all positions are full then returns true

	public boolean isTie() {
		for(int row = 0; row < NUM_OF_ROW; row++){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
				if(board[col][row] == BLANK){
					return false;
				}
			}
		}
		return true;	
	}

	//Below class clear up the board for a new game/Set the board to it's initial stage
	
	public void reset() {
		for(int row = 0; row < NUM_OF_ROW; row++){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
				board[col][row] = BLANK;
			}
		}	
	}

	//Below class is used to get number of columns 

	public int getColumns(){
		return NUM_OF_COLUMNS;
	}

	//Below class is used to get number of rows 
	
	public int getRows(){
		return NUM_OF_ROW;
	}

	//Below class checks that whether that position is empty or not(valid)
	// for the player to drop it's symbol

	public boolean isEmpty(int col) {
		if (board[col-1][0] == BLANK){
			return true;
		}
		return false;
	}

	//Below class places the symbol of the player at the position
	//by replacing the blank space with player's symbol

	public void drop(int col, char symbol){
	    int row;
		for(row = 0; row < NUM_OF_ROW-1 && board[col-1][row+1] == BLANK ;row++);
		board[col-1][row]=symbol;
		
	}

	//Below class clones the game board and then it is used in other classes
	//to check the winning/losing conditions for the AI Player

	public Board AIBoard()
	{
		Board AIBoard = new Board();
		for(int row = 0; row < NUM_OF_ROW; row++)
		{
			for(int col = 0; col < NUM_OF_COLUMNS; col++)
			{
				AIBoard.board[col][row] = board[col][row];
			}
		}
		return AIBoard;
	}

	//Below class is used to get the human player symbol

	public char humanSymbol(char symbol){
		for(int row = NUM_OF_ROW-1; row >= 0; row--){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
				if(board[col][row]!=symbol){
					return board[col][row];
				}
			}
		}
		return symbol;
	}
}

