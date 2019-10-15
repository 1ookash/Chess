package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Слон */
public class Bishop extends Figure {
    public Bishop() {
        super();
    }

    public Bishop(Color color) {
        super(color);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        return Math.abs(oldCell.getX() - newCell.getX()) == Math.abs(oldCell.getY() - newCell.getY());
    }

    @Override
    public String toString() {
        return nameColor() + "__слон__";
    }
}
