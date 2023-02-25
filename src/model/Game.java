package model;

import enums.CellState;
import enums.GameState;
import strategy.GameWinningStrategy.GameWinningStrategy;
import strategy.GameWinningStrategy.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayer;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    private List<Board> boards;
    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }
    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }
    public void makeNextMove(){
        Player currentPlayer=players.get(nextPlayer);
        System.out.println(currentPlayer.getName() +" turn");
        Move currMove=currentPlayer.decideMove(this.board);

        int row=currMove.getCell().getRow();
        int col=currMove.getCell().getColumn();


        System.out.println("Move happening at " + row + ", " + col);

        board.getBoard().get(row).get(col).setCellState(CellState.BLOCKED);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);

        Move move=new Move(currentPlayer, board.getBoard().get(row).get(col));

        moves.add(move);

        //on the fly check if curr move by curr player is making him win the game or not

        if(gameWinningStrategy.checkWinner(board,currentPlayer,board.getBoard().get(row).get(col))){
            //this.gameState=GameState.WIN;
            this.gameState=GameState.WIN;
            this.winner=currentPlayer;
        }
        nextPlayer+=1;
        nextPlayer %= players.size();
    }
    public void displayBoard() {
        this.board.display();
    }

    public void undo(){
        moves.remove(moves.size()-1);
        boards.remove(boards.size()-1);
        this.nextPlayer-=1;
    }

    private Game(Builder b) {
        this.board = new Board(b.dimension);
        this.players = b.players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROCESS;
        this.nextPlayer = 0;
        this.gameWinningStrategy=new OrderOneWinningStrategy(b.dimension);;
    }

    public static Builder getBuilder(){
        Builder builder=new Builder();
        return builder;
    }


    public static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean valid(){
            //check all the things before starting game i.e returning new game obj
            return true;
        }

        public Game Build(){
            if(valid()){
                Game game=new Game(this);
                return game;
            }
            return null;
        }
    }
}
