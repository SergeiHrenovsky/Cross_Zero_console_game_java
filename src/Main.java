public class Main {
    public static void main(String args[]) {
        Field gameField = new Field();
        Player[] players = {new Player(1), new Player(2)};

        game:
        {
            while (true){
                for (Player currentPlayer : players) {
                    gameField.showField();
                    currentPlayer.showPlayer();
                    currentPlayer.makeStep(gameField);
                    if (gameField.winCheck()) {
                        gameField.showField();
                        break game;
                    }
                }
            }
        }
    }
}
