package chessBoard.forming;

import figures.*;
import figures.forming.Figure;

import javax.swing.*;

/* Класс, реализующий клетку шахматной доски */
public class Cell {
    private final Column x;
    private final int y;
    /* Статус говорит, есть ли фигура на данной клетку
     * равен true, если клетка свободна и false, если занята */
    private boolean status;
    /* Фигура стоящая на данной клетке */
    private Figure fig;

    public Cell() {
        x = Column.C;
        y = 1;
    }

    public Cell(Column x, int y, Figure fig) {
        this.x = x;
        this.y = y;
        this.fig = fig;
        this.status = false;
    }

    public Cell(Column x, int y) {
        this.x = x;
        this.y = y;
        this.status = true;
    }

    public Cell(int x, int y) {
        super();
        this.x = Column.values()[x - 1];
        this.y = y;
        this.status = true;
    }

    /* Добавляет иконки на кнопку */
//    private void config() {
//        if (!getStatus() && getFig().nameColor().equals("B")) {
//            if (getFig().getClass().equals(new Pawn().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черная-пешка-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черная-пешка-контур.png")));
//            }
//            if (getFig().getClass().equals(new Bishop().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черный-слон-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черный-слон-контур.png")));
//            }
//            if (getFig().getClass().equals(new King().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черный-король-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черный-король-контур.png")));
//            }
//            if (getFig().getClass().equals(new Knight().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черный-конь-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черный-конь-контур.png")));
//            }
//            if (getFig().getClass().equals(new Queen().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черный-ферзь-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черный-ферзь-контур.png")));
//            }
//            if (getFig().getClass().equals(new Rook().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/черная-ладья-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/черная-ладья-контур.png")));
//            }
//        } else if (!getStatus() && getFig().nameColor().equals("W")) {
//            if (getFig().getClass().equals(new Pawn().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белая-пешка-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белая-пешка-контур.png")));
//            }
//            if (getFig().getClass().equals(new Bishop().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белый-слон-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белый-слон-контур.png")));
//            }
//            if (getFig().getClass().equals(new King().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белый-король-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белый-король-контур.png")));
//            }
//            if (getFig().getClass().equals(new Knight().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белый-конь-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белый-конь-контур.png")));
//            }
//            if (getFig().getClass().equals(new Queen().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белый-ферзь-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белый-ферзь-контур.png")));
//            }
//            if (getFig().getClass().equals(new Rook().getClass())) {
//                setIcon(new ImageIcon(getClass().getResource("resources/белая-ладья-с-заливкой.png")));
//                setRolloverIcon(new ImageIcon(getClass().getResource("resources/белая-ладья-контур.png")));
//            }
//        } else {
//            setIcon(null);
//            setRolloverIcon(null);
//            setBorderPainted(true);
//        }
//    }

    public String nameFigure() {
        if (fig != null) return fig.toString();

        return "_________";
    }

    public int getX() {
        return x.ordinal() + 1;
    }

    public int getY() {
        return y;
    }

    public boolean getStatus() {
        return status;
    }

    public Figure getFig() {
        return fig;
    }

    public void setFig(Figure fig) {
        if (fig != null) {
            this.fig = fig;
            setStatus(false);
        } else {
            this.fig = null;
            setStatus(true);
        }
    }

    private void setStatus(boolean status) {
        this.status = status;
    }
}
