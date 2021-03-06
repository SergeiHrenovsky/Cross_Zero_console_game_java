package game;

import output.PropertiesMessage;

class Field {
    private int[][] field = new int[3][3];

    void showField() {
        System.out.println(PropertiesMessage.getMessage("border"));
        for(int row = 0; row < 3; row++) {
            for(int item: field[row]) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println(PropertiesMessage.getMessage("border"));
    }

    boolean playerStep(int row, int column, int symbol) {
        if (row < 4 && column < 4) {
            if (field[row - 1][column - 1] == 0) {
                field[row - 1][column - 1] = symbol;
                return true;
            } else {
                System.out.println(PropertiesMessage.getMessage("placeTaken"));
                return false;
            }
        } else {
            System.out.println(PropertiesMessage.getMessage("invalidDataField"));
            return false;
        }
    }

    boolean winCheck() {
        if (winCheckRow())
            return true;
        else if (winCheckCol())
            return true;
        else if (winCheckDiagonal())
            return true;
        else if (standOff())
            return true;
        return false;
    }

    private boolean winCheckRow() {
        for (int[] row: field) {
            if (row[0] != 0 && row[0] == row[1] && row[0] == row[2]) {
                System.out.println(PropertiesMessage.getMessage("win") + row[0]);
                return true;
            }
        }
        return false;
    }

    private boolean winCheckCol() {
        for (int i = 0; i < 3; i++) {
            if (field[0][i] != 0 && field[0][i] == field[1][i] && field[0][i] == field[2][i]) {
                System.out.println(PropertiesMessage.getMessage("win") + field[0][i]);
                return true;
            }
        }
        return false;
    }

    private boolean winCheckDiagonal() {
        if (field[0][0] != 0 && field[0][0] == field[1][1] && field[0][0] == field[2][2]) {
            System.out.println(PropertiesMessage.getMessage("win") + field[0][0]);
            return true;
        }
        else if (field[0][2] != 0 && field[0][2] == field[1][1] && field[0][2] == field[2][0]) {
            System.out.println(PropertiesMessage.getMessage("win") + field[0][2]);
            return true;
        }
        return false;
    }

    private boolean standOff() {
        for (int[] row: field) {
            for (int cell: row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        System.out.println(PropertiesMessage.getMessage("deadHeat"));
        return true;
    }
}
