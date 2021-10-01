package TicTacToe.Enums;

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
}
