package TicTacToe;

import TicTacToe.Enums.Player;

public class Players {
    public Solver solverA;
    public Solver solverB;

    public Players(Solver solverA, Solver solverB) {
        this.solverA = solverA;
        this.solverB = solverB;
    }

    public Position solve(Board board) throws Exception {
        if( board.getPlayerToMove() == Player.A){
            return solverA.getPosition(board);
        }else{
            return solverB.getPosition(board);
        }
    }

}
