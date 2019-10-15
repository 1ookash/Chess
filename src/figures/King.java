package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Король */
public class King extends Figure {
    public King() {
        super();
    }

    public King(Color color) {
        super(color);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        return Math.abs(oldCell.getX() - newCell.getX()) <= 1 && Math.abs(oldCell.getY() - newCell.getY()) <= 1;
    }

    @Override
    public String toString() {
        return nameColor() + "__король";
    }
}
