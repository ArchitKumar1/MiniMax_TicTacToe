package TicTacToe;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Evaluation {
    public Position position;
    public int score;

    public Evaluation(Position position, int score) {
        this.position = position;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Chess.Move{" +
                "position=" + position +
                ", score=" + score +
                '}';
    }
}
