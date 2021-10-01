package TicTacToe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer implements Solver {

    Map<Board, Integer> hashMap = new HashMap<>();

    @Override
    public Position getPosition(Board board) throws Exception {

        List<Position> positions = board.getAllAvailableMovesForPlayer();
        hashMap = new HashMap<>();
        if (positions.size() == 0) {
            return null;
        }
        List<Evaluation> evaluations = new ArrayList<>();

        for (Position position : positions) {
            boolean canWin = board.makeMove(position);
            int score = 0;
            if (canWin) {
                score = Integer.MAX_VALUE;
            } else {
                score = -search(board, 1);
            }
            Evaluation evaluation = Evaluation.builder().position(position).score(score).build();
            evaluations.add(Evaluation.builder().position(position).score(score).build());
            System.out.println(" EVAL" + evaluation);
            board.unMakeMove(position);
        }

        evaluations.sort(Comparator.comparing(Evaluation::getScore));
        return evaluations.get(evaluations.size() - 1).position;
    }

    public int search(Board board, int depth) throws Exception {
//        if (hashMap.containsKey(board)) {
//            return hashMap.get(board);
//        }
        List<Position> moves = board.getAllAvailableMovesForPlayer();
//        System.out.println("Search " + board.toString() + basePosition.toString());

        if (moves.size() == 0) {
            // System.out.println("DRAW");

            // No more Moves, draw.
            return 0;
        }
        int bestScore = Integer.MIN_VALUE;

        for (Position position : moves) {
            boolean canWin = board.makeMove(position);
            int score = 0;
            if (canWin) {
                score = Integer.MAX_VALUE - depth;
            } else {
                score = -search(board, depth + 1);
            }
            bestScore = Math.max(bestScore, score);
            board.unMakeMove(position);
        }
        hashMap.put(board, bestScore);
        return bestScore;
    }
}
