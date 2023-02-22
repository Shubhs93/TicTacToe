package strategy.GameWinningStrategy;

import model.Board;
import model.Cell;
import model.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player lastPlayer, Cell lastMoveCell);
}
