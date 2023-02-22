package strategy.GameWinningStrategy;

import model.Board;
import model.Cell;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements GameWinningStrategy{
    private List<HashMap<Character,Integer>>  rowSymbolCounts=new ArrayList();
    private List<HashMap<Character,Integer>>  colSymbolCounts=new ArrayList();
    private HashMap<Character,Integer> diag1=new HashMap<>();
    private HashMap<Character,Integer> diag2=new HashMap<>();

    public OrderOneWinningStrategy(int dimension) {
        for(int i=0;i<dimension;i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }
    public boolean isCellOnTopLeftDiag(int row, int col) {
        return row == col;
    }

    public boolean isCellOnTopRightDiag(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }

    @Override
    public boolean checkWinner(Board board, Player lastPlayer, Cell lastMoveCell) {
        int row=lastMoveCell.getRow();
        int col=lastMoveCell.getColumn();

        if(rowSymbolCounts.get(row).containsKey(lastPlayer.getSymbol())){
            rowSymbolCounts.get(row).put(lastPlayer.getSymbol(),rowSymbolCounts.get(row).get(lastPlayer.getSymbol())+1);
        }else{
            rowSymbolCounts.get(row).put(lastPlayer.getSymbol(),1);
        }
        if(colSymbolCounts.get(row).containsKey(lastPlayer.getSymbol())){
            colSymbolCounts.get(row).put(lastPlayer.getSymbol(),colSymbolCounts.get(row).get(lastPlayer.getSymbol())+1);
        }else{
            colSymbolCounts.get(row).put(lastPlayer.getSymbol(),1);
        }

        if(isCellOnTopLeftDiag(row,col)){
            if(diag1.containsKey(lastPlayer.getSymbol())){
                diag1.put(lastPlayer.getSymbol(),diag1.get(lastPlayer.getSymbol())+1);
            }else{
                diag1.put(lastPlayer.getSymbol(),1);
            }
        }

        if(isCellOnTopRightDiag(row,col,board.getBoard().size())){
            if(diag2.containsKey(lastPlayer.getSymbol())){
                diag2.put(lastPlayer.getSymbol(),diag2.get(lastPlayer.getSymbol())+1);
            }else{
                diag2.put(lastPlayer.getSymbol(),1);
            }
        }

        if(rowSymbolCounts.get(row).get(lastPlayer.getSymbol())==board.getBoard().size()){
            return true;
        }
        if(colSymbolCounts.get(row).get(lastPlayer.getSymbol())==board.getBoard().size()){
            return true;
        }
        if(isCellOnTopLeftDiag(row,col) && diag1.get(lastPlayer.getSymbol())==board.getBoard().size()){
            return true;
        }

        if(isCellOnTopRightDiag(row,col,board.getBoard().size()) && diag2.get(lastPlayer.getSymbol())==board.getBoard().size()){
            return true;
        }

        return false;
    }
}
