package service;

import models.Board;
import models.Piece;
import models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameService {
    private Board board;
    private Queue<Player>players;

    public GameService(Board board, List<Player> playersList){
        this.board = board;
        this.players = new LinkedList<>();
        players.addAll(playersList);
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        while(!board.isBoardFilled()){
            board.printBoard();
            Player player = players.peek();
            System.out.println("Player " + player.getName() + ", its your turn");
            String input = sc.nextLine();
            String[] s = input.split(" ");
            if("EXIT".equalsIgnoreCase(s[0]))
                break;
            int row = Integer.parseInt(s[0]);
            int col = Integer.parseInt(s[1]);

            if(board.addPiece(row, col, player.getPiece())){
                players.remove();
                boolean playerWon = checkIfPlayerWon(player.getPiece(), row, col);

                if(playerWon){
                    board.printBoard();
                    System.out.println("Player " + player.getName() + ", won the game!!");
                    break;
                }
                else{
                    players.add(player);
                }
            }
            else{
                System.out.println("Invalid move");
            }
        }

        if(board.isBoardFilled())
            System.out.println("Game Over");
    }

    private boolean checkIfPlayerWon(Piece piece, int row, int col){
        int size = board.getSize();
        boolean rowCheck = true;
        boolean colCheck = true;
        boolean diagonalOneCheck = true;
        boolean diagonalTwoCheck = true;

        for(int c=0; c<size; c++){
            if(!board.checkIndexHasPiece(row, c, piece))
                rowCheck = false;
        }

        for(int r=0; r<size; r++){
            if(!board.checkIndexHasPiece(r, col, piece))
                colCheck = false;
        }

        for(int r=0, c=0; r<size; r++, c++){
            if(!board.checkIndexHasPiece(r, c, piece))
                diagonalOneCheck = false;
        }

        for(int r=0, c=size-1; r<size; r++, c--){
            if(!board.checkIndexHasPiece(r, c, piece))
                diagonalTwoCheck = false;
        }

        return rowCheck || colCheck || diagonalOneCheck || diagonalTwoCheck;
    }

}
