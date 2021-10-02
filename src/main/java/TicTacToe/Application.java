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
        assert winner != null;
        Result result = winner.getResultFromPlayer();
        if (result == Result.Draw) {
            System.out.println("Game's a Draw");
        } else {
            System.out.println("Player " + winner.toString() + " has won");
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
