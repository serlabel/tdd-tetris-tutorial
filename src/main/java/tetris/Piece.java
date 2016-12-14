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

    private Piece(char[][] piece) {
        this.piece = piece;
        this.rows = piece.length;
        this.columns = piece[0].length;
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
        char[][] rotated = new char[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                rotated[j][this.columns - i - 1] = this.piece[i][j];
            }
        }
        return new Piece(rotated);
    }

    public Piece rotateLeft() {
        char[][] rotated = new char[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                rotated[this.columns - j - 1][i] = this.piece[i][j];
            }
        }
        return new Piece(rotated);
    }
}
