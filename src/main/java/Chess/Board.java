package Chess;

public class Board {
    public int[] Square;
    public int colorToMove;

    public Board() {
        Square = new int[64];
        colorToMove = Piece.White;
        Square[0] = Piece.White | Piece.Rook;
        Square[1] = Piece.Black | Piece.Rook;
    }

    public void boardStart() {
        Square = new int[64];
        Square[0] = Piece.White | Piece.Rook;
        Square[1] = Piece.White | Piece.Knight;
        Square[2] = Piece.White | Piece.Bishop;
        Square[3] = Piece.White | Piece.Queen;
        Square[4] = Piece.White | Piece.King;
        Square[5] = Piece.White | Piece.Bishop;
        Square[6] = Piece.White | Piece.Knight;
        Square[7] = Piece.White | Piece.Rook;

        Square[8] = Piece.White | Piece.Pawn;
        Square[9] = Piece.White | Piece.Pawn;
        Square[10] = Piece.White | Piece.Pawn;
        Square[11] = Piece.White | Piece.Pawn;
        Square[12] = Piece.White | Piece.Pawn;
        Square[13] = Piece.White | Piece.Pawn;
        Square[14] = Piece.White | Piece.Pawn;
        Square[15] = Piece.White | Piece.Pawn;

        Square[48] = Piece.Black | Piece.Rook;
        Square[49] = Piece.Black | Piece.Knight;
        Square[50] = Piece.Black | Piece.Bishop;
        Square[51] = Piece.Black | Piece.Queen;
        Square[52] = Piece.Black | Piece.King;
        Square[53] = Piece.Black | Piece.Bishop;
        Square[54] = Piece.Black | Piece.Knight;
        Square[55] = Piece.Black | Piece.Rook;

        Square[56] = Piece.Black | Piece.Pawn;
        Square[57] = Piece.Black | Piece.Pawn;
        Square[58] = Piece.Black | Piece.Pawn;
        Square[59] = Piece.Black | Piece.Pawn;
        Square[60] = Piece.Black | Piece.Pawn;
        Square[61] = Piece.Black | Piece.Pawn;
        Square[62] = Piece.Black | Piece.Pawn;
        Square[63] = Piece.Black | Piece.Pawn;
    }
}



