package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Шашка */
public class Checker extends Figure {
    public Checker() {
        super();
    }

    public Checker(FigureColor figureColor) {
        super(figureColor);
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        return false;
    }

    @Override
    public String toString() {
        return nameColor() + " шашка";
    }
}
