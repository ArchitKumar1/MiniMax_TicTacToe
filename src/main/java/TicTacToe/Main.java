package TicTacToe;

public class Main {

    private static final int DIM = 3;

    public static void main(String[] args) throws Exception {


        Players players = new Players(new Computer(),new Computer());

        Application application = new Application(players);
        application.runNewGame();
    }
}
