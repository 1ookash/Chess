import chessBoard.ChessBoard;
import chessBoard.forming.Column;

/* Класс для тестов */
public class Test {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.moveFigure(Column.A, 7, Column.A, 5);
        board.moveFigure(Column.A, 5, Column.A, 4);
        board.moveFigure(Column.A, 4, Column.A, 3);
        board.moveFigure(Column.A, 3, Column.B, 2);
        board.print();
//        board.print();

    }
}
