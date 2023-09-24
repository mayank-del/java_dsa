#   step1
##     basic structure for backtracking

        public class NQueens {
            public static void main(String[] args) {
                //passing boolean,current row no, current col no,total queens ,no of queen placed, anser
                NQueen(new boolean[4][4],0,0,4,0,"");
            }
            private static void NQueen(boolean[][] board,int row,int col,int tot_queen,int queen_placed,String string){
                //Do
                board[row][col]=true;
                //Recur
                NQueen(board, row, col+1, tot_queen, queen_placed+1, string+"["+row+"-"+col+"]");
                //Undo
                
            }
        }
## IsItSafeToPlaced fxn

    we just have to check for upper portions because lower oprtions had already checked

    jis point par rakhna hai waaha se upaar ke saare postion ko check kar lete hain.
