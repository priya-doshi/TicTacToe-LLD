import models.Board;
import models.Piece;
import models.Player;
import service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class driver {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();


        System.out.println("Enter the name of first player ");
        String input = sc.nextLine();
        playerList.add(new Player(input, Piece.X));

        System.out.println("Enter the name of second player ");
        input = sc.nextLine();
        playerList.add(new Player(input, Piece.O));

        Board board = new Board();
        GameService gameService = new GameService(board, playerList);
        gameService.startGame();

    }
}
