package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Конь */
public class Knight extends Figure {
    public Knight() {
        super();
    }

    public Knight(FigureColor figureColor) {
        super(figureColor);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        int dx = Math.abs(oldCell.getX() - newCell.getX());
        int dy = Math.abs(oldCell.getY() - newCell.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String toString() {
        return nameColor() + "__конь__";
    }
}
