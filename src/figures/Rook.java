package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Ладья */
public class Rook extends Figure {
    public Rook() {
        super();
    }

    public Rook(FigureColor figureColor) {
        super(figureColor);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        return newCell.getX() == oldCell.getX() || newCell.getY() == oldCell.getY();
    }

    @Override
    public String toString() {
        return nameColor() + "__ладья_";
    }
}