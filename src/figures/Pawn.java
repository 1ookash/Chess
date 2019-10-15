package figures;

import chessBoard.forming.Cell;
import figures.forming.*;

/* Пешка */
public class Pawn extends Figure {
    /* Маркер. True, если пешка только создана и еще не передвигалась,
     * и false, если передвигалась */
    private boolean unUsed;

    public Pawn() {
        super();
    }

    public Pawn(Color color) {
        super(color);
        unUsed = true;
    }

    @Override
    protected boolean ifCanMoveToAlienCell(Cell oldCell, Cell newCell) {
        int dy = newCell.getY() - oldCell.getY();
        int dx = Math.abs(newCell.getX() - oldCell.getX());

        if (dx == 0 && newCell.getStatus()) {
            return ifCanMoveStraight(oldCell, newCell, dy);
        } else if (dx == 1) {
            return ifCanMoveAngle(oldCell, newCell, dy);
        }

        return false;
    }

    /* Проверяет возможность перемещения пешки вдоль стобца */
    private boolean ifCanMoveStraight(Cell oldCell, Cell newCell, int dy) {
        if (oldCell.getX() != newCell.getX()) return false;

        if (unUsed) {
            if (this.getColor() == Color.BLACK) {
                return -2 <= dy && dy <= 0;
            } else {
                return 0 <= dy && dy <= 2;
            }
        } else {
            if (this.getColor() == Color.BLACK) {
                return -1 <= dy && dy <= 0;
            } else {
                return 0 <= dy && dy <= 1;
            }
        }
    }

    /* Проверяет возможность перемещения пешки под углом */
    private boolean ifCanMoveAngle(Cell oldCell, Cell newCell, int dy) {
        if (newCell.getStatus()) return false;

        if (this.getColor() == Color.WHITE) {
            return 0 <= dy && dy <= 1;
        } else {
            return -1 <= dy && dy <= 0;
        }
    }

    public void changeUnUsed() {
        unUsed = !unUsed;
    }

    @Override
    public String toString() {
        return nameColor() + "__пешка_";
    }
}
