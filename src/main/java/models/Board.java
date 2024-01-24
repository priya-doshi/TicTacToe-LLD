package models;

public class Board {
    private static final int DEFAULT_SIZE = 3;

    private int size;
    private Piece[][]board;
    public Board() {
        this(DEFAULT_SIZE);
    }
    public Board(int size){
        this.size = size;
        board =  new Piece[size][size];
    }

    public boolean addPiece(int row, int col, Piece piece){
        if(board[row][col] != null)
            return false;
        board[row][col] = piece;
        return true;
    }



    public boolean isBoardFilled(){
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null)
                    System.out.print("  ");
                else
                    System.out.print(board[i][j].name() + " ");

                System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean checkIndexHasPiece(int row, int col, Piece piece){
        if(board[row][col] == piece)
            return true;

        return false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
