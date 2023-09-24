public class NQueens {
    public static void main(String[] args) {
        //passing boolean,current row no, current col no,total queens ,no of queen placed, anser
        NQueen(new boolean[4][4],0,0,4,0,"");
    }
    private static void NQueen(boolean[][] board,int row,int col,int tot_queen,int queen_placed,String ans){
        //For Successfully placed every queen
        if(queen_placed==tot_queen){
            System.out.println(ans);
            return;
        }
        //For reaching at end of one row
        if(col==board[0].length){
            row+=1;
            col=0;
        }
        //entire board finished
        if(row==board.length){
            return;
        }

        //if we can place aa queen
        if(isItSafeToPlaced(board,row,col)){
            //Do
            board[row][col]=true;
            //Recur
            NQueen(board, row, col+1, tot_queen, queen_placed+1, ans+"["+row+","+col+"]");
            //Undo
            board[row][col]=false; 
        }

        //Not place
        NQueen(board, row, col+1, tot_queen, queen_placed, ans);
    }
    private static boolean isItSafeToPlaced(boolean[][] board,int row,int col){
        
        //For checking vertically up

        int r=row-1;
        int c=col;

        while(r>=0){
            if(board[r][c]){
                //if any true is present in that row,then return false
                return false;
            }
            r--;//since we are going up,So, row --
        }

        //Similarly ,For horizontally left

        r=row;
        c=col-1;

        while(c>=0){
            if(board[r][c]){
                return false;
            }
            c--;
        }

        //upper Diagonally left

        r=row-1;
        c=col-1;

        while(c>=0 && r>= 0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }

        //upper Diagonally right
        r=row-1;
        c=col+1;

        while(c<board[0].length && r>= 0){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
}
