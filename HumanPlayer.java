import java.util.*;  

public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    //Below class allows the human player to input the column number
    // they wish to put their symbol at and if that particular column 
    // is not empty the it prompts the user to input again.

    public void makeMove(Board board) {
        int x = board.getColumns();
        for (int i = 0; i < x ; i++){
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter a column (1-7)");
            int column = input.nextInt();
            if (board.isEmpty(column) == true){
                board.drop(column, symbol);
                break;
            }
            else {
                System.out.println("Column is Full, please choose a different one");
                continue;
            }
        }
    }
}
    


    

