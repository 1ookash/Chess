package chessBoard.forming;

import figures.forming.Figure;

/* Класс, реализующий клетку шахматной доски */
public class Cell {
    private final Column x;
    private final int y;
    /* Статус говорит, есть ли фигура на данной клетку
     * равен true, если клетка свободна и false, если занята */
    private boolean status;
    /* Фигура стоящая на данной клетке */
    private Figure fig;

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
        this.x = Column.values()[x - 1];
        this.y = y;
        this.status = true;
    }

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
