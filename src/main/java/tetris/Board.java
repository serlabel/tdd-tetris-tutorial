// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private char[][] s;
    private boolean falling = false;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.s = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s[row][col] = '.';
            }
        }
    }

    public String toString() {
        String s1 = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s1 += s[row][col];
            }
            s1 += '\n';
        }
        return s1;
    }

    public boolean hasFalling() {
        return falling;
    }

    public void drop(Block b) {
        s[0][1] = b.block;
        falling = true;
    }

    public void tick() {
        for (int row = this.rows - 1; row >= 0; row--) {
            for (int col = 0; col < this.columns; col++) {
                if (row == 0)
                    s[row][col] = '.';
                else
                    s[row][col] = s[row - 1][col];
            }
        }
    }
}
