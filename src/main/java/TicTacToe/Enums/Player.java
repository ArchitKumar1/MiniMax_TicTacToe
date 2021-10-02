package TicTacToe.Enums;

import TicTacToe.Result;

public enum Player {
    A,
    B,
    C;

    public Piece getPieceForPlayer() {
        if (this == Player.A) {
            return Piece.X;
        } else {
            return Piece.O;
        }
    }

    public Player getOppositePlayer() {
        return (this == Player.A ? Player.B : Player.A);
    }


    public Result getResultFromPlayer() {
        if (this == Player.A) {
            return Result.PlayerA;
        }
        if (this == Player.B) {
            return Result.PlayerB;
        } else {
            return Result.Draw;
        }
    }
}
