// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {

    private int rows;
    private int columns;
    private char[][] piece;

    public Piece(String piece) {
        String[] str_rows = piece.split("\n");
        this.rows = str_rows.length;
        this.columns = str_rows[0].length();
        this.piece = new char[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.piece[i][j] = str_rows[i].charAt(j);
            }
        }
    }

    public String toString() {
        String ps = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                ps += this.piece[i][j];
            }
            ps += "\n";
        }
        return ps;
    }

    public Piece rotateRight() {
        for (int i = 0; i < this.rows/2 ; i++) {
            for (int j = i; j < this.columns - i - 1; j++) {
                char top_left = this.piece[i][j];
                this.piece[i][j] = this.piece[this.rows - j - 1][i];
                this.piece[this.rows - j - 1][i] = this.piece[this.rows - i - 1][this.columns - j - 1];
                this.piece[this.rows - i - 1][this.columns - j - 1] = this.piece[j][this.columns - i - 1];
                this.piece[j][this.columns - i - 1] = top_left;
            }
        }
        return this;
    }

    public Piece rotateLeft() {
        for (int i = 0; i < this.rows/2 ; i++) {
            for (int j = this.columns -i - 1; j > i; j--) {
                char top_right = this.piece[i][j];
                this.piece[i][j] = this.piece[j][this.columns - i - 1];
                this.piece[j][this.columns - i - 1] = this.piece[this.rows - i - 1][this.columns - j - 1];
                this.piece[this.rows - i - 1][this.columns - j - 1] = this.piece[this.rows - j - 1][i];
                this.piece[this.rows - j - 1][i] = top_right;
            }
        }
        return this;
    }
}
