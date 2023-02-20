package model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayer;

    private Game(Builder b) {
        this.board = b.board;
        this.players = b.players;
        this.moves = b.moves;
        this.gameState = b.gameState;
        this.nextPlayer = b.nextPlayer;
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private List<Move> moves;
        private GameState gameState;
        private int nextPlayer;

        public Board getBoard() {
            return board;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<Move> getMoves() {
            return moves;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public GameState getGameState() {
            return gameState;
        }

        public Builder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public int getNextPlayer() {
            return nextPlayer;
        }

        public Builder setNextPlayer(int nextPlayer) {
            this.nextPlayer = nextPlayer;
            return this;
        }
    }
}
