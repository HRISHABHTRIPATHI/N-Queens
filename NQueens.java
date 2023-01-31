import java.util.ArrayList;
import java.util.List;
public class NQueens {
    public static boolean isSafe(int row, int col, char board [][]){
        //HORIZONTAL
        for(int j=0; j<board.length; j++){
            if(board[row][j]== 'Q'){
                return false;
            }
        }

        //VERTICAL
        for(int i=0; i<board.length; i++){
            if(board[i][col]== 'Q'){
                return false;
            }
        }

        //UPPER LEFT
        int r=row;
        for(int c=col; c>=0 && r>=0; r--, c--){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        //UPPER RIGHT
        r=row;
        for(int c=col; c<board.length && r>=0; c++, r--){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        //LOWER LEFT
        r=row;
        for(int c=col; r<board.length && c>=0; r++, c--){
            if(board[r][c]== 0){
                return false;
            }
        }

        //LOWER RIGHT
        r=row;
        for(int c=col; r<board.length && c<board.length; r++, c++){
            if(board[r][c]== 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void saveBoard(char board [][], List<List<String>> allBoards){
        String row= "";
        List <String> newBoard = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            row= "";
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'Q')
                row += 'Q';
                else
                row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public static void helper (char board [][], List<List<String>> allBoards, int col){
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }
        for(int row= 0; row<board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> allboards = new ArrayList<>();
        char [][] board = new char [n][n];
        helper (board, allboards, 0);
        return allboards;
    }
public static void main(String[] args) {
    List<List<String>> sol = new ArrayList<>();
    sol = solveNQueens(4);
    System.out.println(sol);
    }
}
