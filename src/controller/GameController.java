package controller;

import model.Board;
import model.Game;
import model.GameState;
import model.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        Game game=Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .Build();

        return game;
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void makeNextMove(Game game){
        game.makeNextMove();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game){
        game.undo();
    }
}
