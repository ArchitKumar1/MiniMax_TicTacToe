package TicTacToe;

import TicTacToe.Enums.Piece;
import TicTacToe.Enums.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static TicTacToe.Constants.DIM;

@Data
public class Board {
    Piece[][] board;
    Player playerToMove;

    public Board() {
        board = new Piece[DIM][DIM];
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nChess.Board\n");
        for (int row = 0; row < DIM; row++) {
            for (int col = 0; col < DIM; col++) {
                stringBuilder.append(board[row][col].pieceName).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setToDefault() {
        for (int row = 0; row < DIM; row++) {
            for (int col = 0; col < DIM; col++) {
                board[row][col] = Piece.E;
            }
        }
        playerToMove = Player.A;
    }

    public boolean makeMove(Position position) throws Exception {

        int row = position.X;
        int col = position.Y;
        if (!validatePosition(row, col)) {
            throw new Exception("Position Entered is not a valid position ");
        }
        if (board[row][col] != Piece.E) {
            throw new RuntimeException("Square not empty for row " + row + " and col  "+ col);
        }
        board[row][col] = playerToMove.getPieceForPlayer();
        boolean win = checkWin(row, col);
        playerToMove = playerToMove.getOppositePlayer();
        return win;
    }

    public void unMakeMove(Position position) throws Exception {

        int row = position.X;
        int col = position.Y;
        if (!validatePosition(row, col)) {
            throw new Exception("Position Entered is not a valid position ");
        }
        if (board[row][col] == Piece.E) {
            throw new RuntimeException("Position is Already Empty");
        }
        board[row][col] = Piece.E;
        playerToMove = playerToMove.getOppositePlayer();
    }

    private boolean validatePosition(int row, int col) {
        if (row < 0 || row > (DIM - 1)) {
            return false;
        }
        return col >= 0 && col <= (DIM - 1);
    }

    public boolean checkWin(int row, int col) {

        Piece piece = playerToMove.getPieceForPlayer();
        // check row is the same
        boolean fullRow = true;
        for (int j = 0; j < DIM; j++) {
            if (board[row][j] != piece) {
                fullRow = false;
                break;
            }
        }
        if (fullRow) {
            return true;
        }

        // check col is the same
        boolean fullColumn = true;
        for (int i = 0; i < DIM; i++) {
            if (board[i][col] != piece) {
                fullColumn = false;
                break;
            }
        }
        if (fullColumn) {
            return true;
        }

        boolean downRightFull = true;
        for (int i = 0, j = 0; i < DIM && j < DIM; i++, j++) {
            if (board[i][j] != piece) {
                downRightFull = false;
                break;
            }
        }

        if (downRightFull) {
            return true;
        }

        boolean leftUpFull = true;
        for (int i = DIM - 1, j = 0; i >= 0 && j < DIM; i--, j++) {
            if (board[i][j] != piece) {
                leftUpFull = false;
                break;
            }
        }

        return leftUpFull;
    }

    public List<Position> getAllAvailableMovesForPlayer() {
        List<Position> positions = new ArrayList<>();
        for (int row = 0; row < DIM; row++) {
            for (int col = 0; col < DIM; col++) {
                if (board[row][col] == Piece.E) {
                    positions.add(new Position(row, col));
                }
            }
        }
        return positions;
    }
}