package com.company;

public class Reinas {

    public int[] movX = {1, 1, 1, -1, -1, -1, 0, 0};
    public int[] movY = {0, 1, -1, 1, -1, 0, 1, -1};
    public int cant = 1;

    public boolean check(int[][] board, int x, int y) {
        for (int i = 0; i < 8; i++) {
            int x1 = x;
            int y1 = y;
            while (x1 >= 0 && y1 >= 0 && x1 < 8 && y1 < 8) {
                if (board[x1][y1] == 1) {
                    return false;
                }
                x1 += movX[i];
                y1 += movY[i];
            }
        }
        return true;
    }

    public void print(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Refill(int[][] board, int queens, int x, int y) {
        if (queens == 8) {
            print(board);
            System.out.println("tablero => " + cant);
            cant++;
        }

        while (x < 8) {
            while (y < 8) {
                if (check(board, x, y)) {
                    board[x][y] = 1;
                    Rellenar(board, queens + 1, x, y + 1);
                    board[x][y] = 0;
                }
                y++;
            }
            x++;
            y = 0;
        }

    }
}
