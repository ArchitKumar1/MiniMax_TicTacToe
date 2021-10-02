package TicTacToe;

import TicTacToe.Enums.Player;

public class Application {


    Players players;

    public Application(Players players) {
        this.players = players;
    }

    public void runNewGame() throws Exception {
        Board board = new Board();
        board.setToDefault();

        Player winner = run(board);
        if (winner != null) {
            System.out.println("Player " + winner.getResultFromPlayer().toString() + " has won");
        } else {
            System.out.println("Game's a Draw");
        }
    }

    private Player run(Board board) throws Exception {

        Position position = players.solve(board);
        if (position == null) {
            return null;
        }
        boolean didWin = board.makeMove(position);
        System.out.println(board);
        if (didWin) {
            return board.getPlayerToMove().getOppositePlayer();
        } else {
            return run(board);
        }
    }

}
