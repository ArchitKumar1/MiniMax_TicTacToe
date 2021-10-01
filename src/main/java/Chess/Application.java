package Chess;

import java.util.ArrayList;
import java.util.List;

public class Application {



    public static void main(String[] args) {


        Board board = new Board();
        board.boardStart();



    }


    public List<Move> findMoves(Board board){

        List<Move> moves = new ArrayList<>();
        for(int startSquare = 0; startSquare < 64;startSquare++){
            int square = board.Square[startSquare];
            if(Piece.color(square,board.colorToMove)){
                if(Piece.isSlidingPiece(square,board)) {
                    generateSlidingMoves(square, moves,board);
                }else if(Piece.isPiece(square,Piece.Bishop)){
                    generateBishopMoves(square,moves,board);
                }else if(Piece.isPiece(square,Piece.King)){
                    generateKingMoves(square,moves,board);
                }else if(Piece.isPiece(square,Piece.Pawn)){
                    generatePawnMoves(square,moves,board);
                }
            }

        }
        return moves;
    }

    private void generatePawnMoves(int currentSquare, List<Move> moves, Board board) {

        int targetSquare = currentSquare + 8;
        if (Piece.onBoard(targetSquare) && Piece.empty(currentSquare)){
            Move move = new Move(currentSquare,targetSquare);
            moves.add(move);
        }
        // 2 Square first Chess.Move
        targetSquare = currentSquare + 16;
        if (Piece.onBoard(targetSquare) && Piece.empty(currentSquare)){
            Move move = new Move(currentSquare,targetSquare);
            moves.add(move);
        }
    }

    private void generateKingMoves(int currentSquare, List<Move> moves, Board board) {
    }

    private void generateBishopMoves(int currentSquare, List<Move> moves, Board board) {
    }

    private void generateSlidingMoves(int currentSquare, List<Move> moves, Board board) {

        for(int dir = 0;dir < 8; dir++ ){

        }
    }
}
