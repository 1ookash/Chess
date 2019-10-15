package chessBoard;

import chessBoard.forming.Cell;
import chessBoard.forming.Column;
import figures.*;
import figures.forming.Color;
import figures.forming.Figure;

import java.util.LinkedList;
import java.util.List;

/* Шахматная доска */
public class ChessBoard {
    /* Двумерный массив, содержащий 64 клетки шахматной доски.
     * boar[y][x] x - порядковый номер столбца, y - порядковый
     * номер строки  */
    private final Cell[][] board = new Cell[8][8];
    /* Хранят съеденныее фигуры */
    private List<Figure> eatBlack = new LinkedList<>();
    private List<Figure> eatWhite = new LinkedList<>();
    private final static Figure[] START_BLACK_EIGHTH_LINE = {new Rook(Color.BLACK),
            new Knight(Color.BLACK), new Bishop(Color.BLACK), new King(Color.BLACK),
            new Queen(Color.BLACK), new Bishop(Color.BLACK), new Knight(Color.BLACK),
            new Rook(Color.BLACK)};
    private final static Figure[] START_WHITE_FIRST_LINE = {new Rook(Color.WHITE),
            new Knight(Color.WHITE), new Bishop(Color.WHITE), new King(Color.WHITE),
            new Queen(Color.WHITE), new Bishop(Color.WHITE), new Knight(Color.WHITE),
            new Rook(Color.WHITE)};

    public ChessBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                board[y][x] = new Cell(x + 1, y + 1);
            }
        }

        for (int x = 0; x < 8; x++) {
            board[0][x].setFig(START_WHITE_FIRST_LINE[x]);
            board[1][x].setFig(new Pawn(Color.WHITE));
            board[6][x].setFig(new Pawn(Color.BLACK));
            board[7][x].setFig(START_BLACK_EIGHTH_LINE[x]);
        }
    }

    /* Перемещает фигуру на новую клетку, освобождая старую */
    public boolean moveFigure(Column oldX, int oldY, Column newX, int newY) {
        Cell oldCell = board[oldY - 1][oldX.ordinal()];
        Cell newCell = board[newY - 1][newX.ordinal()];

        if (oldCell.getStatus()) return false;
        if (!ifCanMove(oldCell.getFig(), oldCell, newCell)) return false;

        if (!newCell.getStatus()) {
            if (newCell.getFig().getColor() == Color.BLACK) {
                eatBlack.add(newCell.getFig());
            } else {
                eatWhite.add(newCell.getFig());
            }
        }

        newCell.setFig(oldCell.getFig());
        oldCell.setFig(null);
        if (newCell.getFig().getClass().equals(new Pawn().getClass())) {
            Pawn tmp = (Pawn) newCell.getFig();
            tmp.changeUnUsed();
        }

        return true;
    }

    /* Определяет может ли фигура переместиться на новую клетку, с учётом всех условий */
    private boolean ifCanMove(Figure fig, Cell oldCell, Cell newCell) {
        if (fig == null) {
            return false;
        }
        if (fig.getClass().equals(START_BLACK_EIGHTH_LINE[0].getClass())) {
            return fig.ifCanMove(oldCell, newCell) && ifFigNotOnWayStraight(oldCell, newCell);
        }
        if (fig.getClass().equals(START_BLACK_EIGHTH_LINE[2].getClass())) {
            return fig.ifCanMove(oldCell, newCell) && ifFidNotOnWayDiagonal(oldCell, newCell);
        }
        if (fig.getClass().equals(START_BLACK_EIGHTH_LINE[3].getClass()) ||
                fig.getClass().equals(START_BLACK_EIGHTH_LINE[4].getClass())) {
            if (oldCell.getX() == newCell.getY() || oldCell.getY() == newCell.getY()) {
                return fig.ifCanMove(oldCell, newCell) && ifFigNotOnWayStraight(oldCell, newCell);
            } else {
                return fig.ifCanMove(oldCell, newCell) && ifFidNotOnWayDiagonal(oldCell, newCell);
            }
        } else {
            return fig.ifCanMove(oldCell, newCell);
        }
    }

    /* Определяет есть ли фигуры на пути по диагонали между
     * начальной и конечной клеткой без учета их самих.
     * Возвращает true ,если свободен, и false ,если занят */
    private boolean ifFidNotOnWayDiagonal(Cell oldCell, Cell newCell) {
        boolean flag = true;

        if (newCell.getY() > oldCell.getY()) {
            if (newCell.getX() > oldCell.getX()) {
                for (int y = oldCell.getY(); y < newCell.getY() - 1; y++) {
                    flag = cycle(oldCell, newCell, y, true);
                }
            } else if (newCell.getX() < oldCell.getX()) {
                for (int y = oldCell.getY(); y < newCell.getY() - 1; y++) {
                    flag = cycle(oldCell, newCell, y, false);
                }
            }
        }

        if (newCell.getY() < oldCell.getY()) {
            if (newCell.getX() > oldCell.getX()) {
                for (int y = oldCell.getY() - 2; y >= newCell.getY(); y--) {
                    flag = cycle(oldCell, newCell, y, true);
                }
            } else if (newCell.getX() < oldCell.getX()) {
                for (int y = oldCell.getY() - 2; y >= newCell.getY(); y--) {
                    flag = cycle(oldCell, newCell, y, false);
                }
            }
        }

        return flag;
    }

    /* Внутренный цикл вынесенныый из ifFidNotOnWayDiagonal */
    private boolean cycle(Cell oldCell, Cell newCell, int y, boolean flag) {
        if (flag) {
            for (int x = oldCell.getX(); x < newCell.getX() - 1; x++) {
                if (x == y && board[y][x].getFig() != null) {
                    return false;
                }
            }
        } else {
            for (int x = oldCell.getX() - 2; x >= newCell.getX(); x--) {
                if (x == 7 - y && board[y][x].getFig() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /* Определяет есть ли фигуры на пути по прямой между
     * начальной и конечной клеткой без учета их самих.
     * Возвращает true ,если свободен, и false ,если занят */
    private boolean ifFigNotOnWayStraight(Cell oldCell, Cell newCell) {
        /* Проверка вдоль столбца */
        if (newCell.getX() > oldCell.getX()) {
            for (int x = oldCell.getX(); x < newCell.getX() - 1; x++) {
                if (board[oldCell.getY() - 1][x].getFig() != null) {
                    return false;
                }
            }
        } else if (newCell.getX() < oldCell.getX()) {
            for (int x = oldCell.getX() - 2; x >= newCell.getX(); x--) {
                if (board[oldCell.getY() - 1][x].getFig() != null) {
                    return false;
                }
            }
        }

        /* Проверка вдоль строки */
        if (newCell.getY() > oldCell.getY()) {
            for (int y = oldCell.getY(); y < newCell.getY() - 1; y++) {
                if (board[y][oldCell.getX() - 1].getFig() != null) {
                    return false;
                }
            }
        } else if (newCell.getY() < oldCell.getY()) {
            for (int y = oldCell.getY() - 2; y >= newCell.getY(); y--) {
                if (board[y][oldCell.getX() - 1].getFig() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void print() {
        System.out.println("  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |  " +
                "\n  +---------+---------+---------+---------+---------+---------+---------+---------+");
        for (int y = 7; y >= 0; y--) {
            System.out.print((y + 1) + ":|");
            for (int x = 0; x < 8; x++) {
                System.out.print(board[y][x].nameFigure() + "|");
            }
            System.out.println(":" + (y + 1) + "\n  +---------+---------+---------+---------" +
                    "+---------+---------+---------+---------+");
        }
        System.out.println("  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |  ");

        System.out.println("Съеденные черные фигуры:" + eatBlack);
        System.out.println("Съеденные белые фигуры:" + eatWhite);
    }
}