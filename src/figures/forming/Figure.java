package figures.forming;

import chessBoard.forming.Cell;

/* Задает основную сущность фигур */
public abstract class Figure {
    private final Color color;

    public Figure() {
        color = null;
    }

    public Figure(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String nameColor() {
        if (color == Color.BLACK) {
            return "Ч";
        } else {
            return "Б";
        }
    }

    public int getColorOrdinal() {
        return color.ordinal();
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
            return ifCanMoveToAlienCell(oldCell, newCell) && newCell.getFig().getColor() != color;
        }
    }
}
