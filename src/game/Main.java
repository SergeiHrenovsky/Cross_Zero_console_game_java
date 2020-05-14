package game;

public class Main {
    public static void main(String args[]) {
        Field gameField = new Field();
        Player[] players = {new Player(1), new Player(2)};
        boolean game = true;

        while (game){
            for (Player currentPlayer : players) {
                gameField.showField();
                currentPlayer.showPlayer();
                currentPlayer.makeStep(gameField);
                if (gameField.winCheck()) {
                    gameField.showField();
                    game = false;
                    break;
                }
            }
        }
    }
}
