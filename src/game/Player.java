package game;

import java.util.Scanner;
import output.PropertiesMessage;

class Player {
    private int symbol;
    private Scanner step = new Scanner(System.in);

    Player(int symbol) {
        this.symbol = symbol;
    }

    void showPlayer() {
        System.out.println(PropertiesMessage.getMessage("stepPlayer") + symbol);
    }

    void makeStep(Field gameField) {
            if (!gameField.playerStep(setRowStep(), setColStep(), symbol)) {
                makeStep(gameField);
            }
    }

    private int setRowStep() {
        System.out.println(PropertiesMessage.getMessage("row"));
        Scanner row = new Scanner(System.in);
        try {
            return row.nextInt();
        }
        catch(Exception ex) {
            System.out.println(PropertiesMessage.getMessage("invalidDataRow") +
                    PropertiesMessage.getMessage("inputNewNumber"));
            return setRowStep();
        }
    }

    private int setColStep() {
        System.out.println(PropertiesMessage.getMessage("col"));
        Scanner col = new Scanner(System.in);
        try {
            return col.nextInt();
        }
        catch(Exception ex) {
            System.out.println(PropertiesMessage.getMessage("invalidDataCol") +
                    PropertiesMessage.getMessage("inputNewNumber"));
            return setColStep();
        }
    }
}
