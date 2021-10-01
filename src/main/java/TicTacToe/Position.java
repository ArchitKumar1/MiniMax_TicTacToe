package TicTacToe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    int X;
    int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }
}
