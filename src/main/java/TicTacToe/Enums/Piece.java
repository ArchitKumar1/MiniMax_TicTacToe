package TicTacToe.Enums;

public enum Piece {
    X("X"),
    O("O"),
    E("-");

    public final String pieceName;

    Piece(String pieceName) {
        this.pieceName = pieceName;
    }

    Piece getPieceFromName(String name) {
        for (Piece piece : Piece.values()) {
            if (piece.pieceName.equalsIgnoreCase(name)) {
                return Piece.E;
            }
        }
        throw new RuntimeException("Invalid Chess.Piece entered");
    }

}
