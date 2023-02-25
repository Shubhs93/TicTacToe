import controller.GameController;
import enums.BotDifficultyLevel;
import enums.GameState;
import enums.PlayerType;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("What shuld be dimension of the game");
        int dimension=sc.nextInt();

        System.out.println("Will there be any bot: y/n");
        String isBotString=sc.next();

        int totalPlyer=dimension-1;
        List<Player> playerList=new ArrayList<>();

        if(isBotString.equals('y')){
            System.out.println("What is the name of Bot player " );
            String playerName = sc.next();

            System.out.println("What is the symbol of Bot player " );
            char playerSymbol = sc.next().charAt(0);
            playerList.add(new Bot(playerSymbol,playerName, BotDifficultyLevel.EASY));

            totalPlyer=dimension-2;
        }


        for(int i=0;i<totalPlyer;i++){
            System.out.println("What is the name of player " + i);
            String playerName = sc.next();

            System.out.println("What is the symbol of player " + i);
            char playerSymbol = sc.next().charAt(0);
            playerList.add(new Player(playerSymbol,playerName, PlayerType.HUMAN));
        }

        GameController gameController = new GameController();
        Game game=gameController.createGame(dimension,playerList);

        while(gameController.getGameState(game).equals(GameState.IN_PROCESS)){
            System.out.println("This is current Board");

            gameController.displayBoard(game);

            System.out.println("Does anyone want to undo? y/n");

            String input = sc.next();

            if (input.equals("y")) {
                gameController.undo(game);
            } else {
                gameController.makeNextMove(game);
            }

        }

        if(gameController.getGameState(game).equals(GameState.WIN)){
            System.out.println("Winner is "+ gameController.getWinner(game).getName());
            gameController.displayBoard(game);

        }else{
            System.out.println("Game is draw");
        }

    }
}
