package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Ферзь */
public class Queen extends Figure {
    public Queen() {
        super();
    }

    public Queen(Color color) {
        super(color);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        return (Math.abs(oldCell.getX() - newCell.getX()) == Math.abs(oldCell.getY() - newCell.getY()))
                || ( newCell.getX() == oldCell.getX() || newCell.getY() == oldCell.getY());
    }

    @Override
    public String toString() {
        return nameColor() + "__ферзь_";
    }
}
