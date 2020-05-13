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
            if (!gameField.playerStep(setRowStep(), setColStep(), symbol)) {
                makeStep(gameField);
            }
    }

    private int setRowStep() {
        System.out.println("Введите номер ряда:");
        Scanner row = new Scanner(System.in);
        try {
            return row.nextInt();
        }
        catch(Exception ex) {
            System.out.println("ОШИБКА! Введенные данные не соответствуют номеру ряда.");
            System.out.println("Введите, пожалуйста, цифру от 1 до 3:");
            return setRowStep();
        }
    }

    private int setColStep() {
        System.out.println("Введите номер столбца:");
        Scanner col = new Scanner(System.in);
        try {
            return col.nextInt();
        }
        catch(Exception ex) {
            System.out.println("ОШИБКА! Введенные данные не соответствуют номеру столбца.");
            System.out.println("Введите, пожалуйста, цифру от 1 до 3:");
            return setColStep();
        }
    }
}
