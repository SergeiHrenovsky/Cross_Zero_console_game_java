import java.util.Scanner;

public class Player {
    private int symbol;
    private Scanner step = new Scanner(System.in);

    Player(int symbol) {
        this.symbol = symbol;
    }

    protected void showPlayer() {
        System.out.println("Ходит игрок " + symbol);
    }

    void makeStep(Field gameField) {
        System.out.println("Введите номер ряда:");
        int row = step.nextInt();
        System.out.println("Введите номер столбца:");
        int col = step.nextInt();
        if (!gameField.playerStep(row, col, symbol)) {
            makeStep(gameField);
        }
    }
}
