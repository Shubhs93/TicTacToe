package model;

public class Move {
    private Player player;
    private cell cell;

    public Move(Player player, model.cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public model.cell getCell() {
        return cell;
    }

    public void setCell(model.cell cell) {
        this.cell = cell;
    }
}
