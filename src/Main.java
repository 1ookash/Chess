import chessBoard.ChessBoard;
import chessBoard.forming.Column;

import javax.swing.*;
import java.util.Scanner;

/* Класс для тестов */
public class Main {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Scanner sc = new Scanner(System.in);
        String tmp;

        board.print();
        do {
            Column oldY, newY;
            int oldX, newX;

            System.out.print("Input initial and end positions separated by space or stop: ");
            tmp = sc.nextLine();
            try {
                oldY = Column.valueOf(tmp.substring(0, 1));
                oldX = Integer.parseInt(tmp.substring(1, 2));
                newY = Column.valueOf(tmp.substring(3, 4));
                newX = Integer.parseInt(tmp.substring(4, 5));
                board.moveFigure(oldY, oldX, newY, newX);
                board.print();
            } catch (Throwable t) {
                if (!tmp.equals("stop")) {
                    System.out.println("wrong data");
                }
            }

        }
        while (!tmp.equals("stop"));
    }
}
