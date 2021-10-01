package TicTacToe;

import java.util.Scanner;

public class Human implements Solver {
    Scanner scanner;

    public Human() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position getPosition(Board board) {
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        row -= 1;
        col -= 1;
        return Position.builder().X(row).Y(col).build();
    }
}
