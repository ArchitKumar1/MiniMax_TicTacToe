package Chess;

public class Piece {
    public final static int None = 0;
    public final static int Bishop = 1;
    public final static int Rook = 2;
    public final static int King = 3;
    public final static int Knight = 4;
    public final static int Pawn = 5;
    public final static int Queen = 6;
    public final static int White = 8;
    public final static int Black = 16;


    int[] slidingOffsets = {8, -8, -1, 1, 7, -7, 8, 9, -9};

    public static boolean color(int piece, int color) {
        return (piece & color) == color;
    }

    public static boolean isPiece(int square, int piece) {
        return (square & piece) == Piece.Queen;
    }

    public static boolean onBoard(int position) {
        return position >= 0 && position <= 63;
    }

    public static boolean empty(int square) {
        return (square & 7) == 0;
    }



    public static boolean isSlidingPiece(int piece, Board board) {
        if ((piece & Piece.Rook) == Piece.Rook) {
            return true;
        }
        if ((piece & Piece.Bishop) == Piece.Bishop) {
            return true;
        }
        return (piece & Piece.Queen) == Piece.Queen;
    }
}

