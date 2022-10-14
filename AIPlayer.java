//import java.util.Random;  

public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

	//Below class allows the computer to make it's move.
	//First it checks using AIWin/AILose class otherwise a random number 
	// is generated using math module and if the column is empty it drops 
	// the AI's symbol

    public void makeMove(Board board) {
		if (AIWin () != 0){
			board.drop(AIWin(), symbol);
		}
		else if (AILose()!=0){
			board.drop(AILose(), symbol);
		}
		else {
			int x = (int)(Math.random() * 7);
			int col = x + 1;
			System.out.println(name + " , please input your move: " + col);
			int i;
			int y = board.getColumns();
			for(i= 0; i < y && (!board.isEmpty(col)); i++){
				x = (col) % y;
			}
			if(i==7){
				while(!board.isEmpty(x+1)){
					x = (col) % y;
				}
			}
			board.drop(col, symbol);
		}
	}

	//Below class checks that whether there's move available that can
	//make AI player win the game by cloning the current game board and 
	//trying the symbols at different position and then checking that whether
	//it is creating winning move or not using containsWin.
	//If yes then it returns that particular column for 
	//dropping AI symbol on the original game board, otherwise returns 0.

	public int AIWin(){
		int y = board.getColumns();
		for(int col = 1; col <= y; col++){
			Board AIBoard = board.AIBoard();
			if(AIBoard.isEmpty(col)){
				AIBoard.drop(col, symbol);
				if(AIBoard.containsWin()){
					return col;
				}
			}
		}
		return 0;
	}

	//Below class checks that whether there's move available that can
	//make human player win the game in it's next turn by cloning the current game board and 
	//getting the human player symbol using humansymbol.
	//Then it tries humansymbol at different position and then check that whether
	//it is creating winning move or not using containsWin.
	//If yes then it returns that particular column so that  
	//AI can drop it's symbol at that particular place for blocking human player
	//on the original game board, otherwise returns 0.

	public int AILose(){
		int y = board.getColumns();
		char other=board.humanSymbol(symbol);
		if(other==symbol){
			return 0;
		}
		for(int col = 1; col <= y; col++){
			Board AIBoard = board.AIBoard();
			if(AIBoard.isEmpty(col)){
				AIBoard.drop(col, other);
				if(AIBoard.containsWin()){
					return col;
				}
			}
		}
		return 0;
	}
}
    



