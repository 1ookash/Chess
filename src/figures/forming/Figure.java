package figures.forming;

import chessBoard.forming.Cell;

/* Задает основную сущность фигур */
public abstract class Figure {
    private final FigureColor figureColor;

    public Figure() {
        figureColor = null;
    }

    public Figure(FigureColor figureColor) {
        this.figureColor = figureColor;
    }

    public FigureColor getFigureColor() {
        return figureColor;
    }

    public String nameColor() {
        if (figureColor == FigureColor.BLACK) {
            return "B";
        } else {
            return "W";
        }
    }

    public int getColorOrdinal() {
        return figureColor.ordinal();
    }

    /* Проверяет возможность перемещения фигуры по ее правилам на новую чужую клетку
     * со старой, без учета перешагиваемых фигур */
    protected abstract boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell);

    /* Проверяет возможность перемещения фигуры по ее правилам на новую клетку,
     * без учета перешагиваемых фигур */
    public boolean ifCanMove(Cell oldCell, Cell newCell) {
        if (newCell.getStatus()) {
            return ifCanMoveToAlienCell(oldCell, newCell);
        } else {
            return ifCanMoveToAlienCell(oldCell, newCell) && newCell.getFig().getFigureColor() != figureColor;
        }
    }
}
