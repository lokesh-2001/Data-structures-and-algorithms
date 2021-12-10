public class nQueens {
    private static boolean isSafe(boolean[][] board, int row, int col){
        // vertically up
        int r = row-1;
        int c = col;
        while(r>=0){
            if(board[r][c])
                return false;
            r--;
        }
        r = row;
        c = col-1;
        while(c>=0){
            if(board[r][c])
                return false;
            c--;
        }
        // diagonally left
        r = row-1;
        c = col-1;
        while(c>=0 && r>=0){
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        // diagonally right
        r = row-1;
        c = col+1;
        while(c<board[0].length&& r>=0){
            if(board[r][c])
                return false;
            r--;c++;
        }
        
        return true;
    }
    private static void NQueen(boolean[][] board, int row, int col ,int tq ,int qpsf , String ans){
        
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }

        if(col == board[0].length){
            row++;
            col =0;
        }

        if(row == board.length){
            return;
        }
        

        if(isSafe(board,row,col)){
            board[row][col] = true;
            NQueen(board,row,col+1,tq,qpsf+1,ans+"[" + row + " "+ col + "]");
            board[row][col] = false;
        }
        // for not place
        NQueen(board,row,col+1,tq,qpsf,ans);

    }
    public static void main(String[] args){
        // matrix, row, col,total queens, currently placed queen , ans
        NQueen(new boolean[4][4],0,0,4,0,"");
    }
}
