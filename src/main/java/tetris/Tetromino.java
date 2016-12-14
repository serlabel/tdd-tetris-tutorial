// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public final static Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n");

    private Piece[] shapes;
    private int actual_rotation;

    public Tetromino(String shape) {
        this.actual_rotation = 0;
        shapes = new Piece[4];
        this.shapes[0] = new Piece(shape);
        for(int i=1; i < 4; i++) {
            this.shapes[i] = this.shapes[i-1].rotateRight();
        }
    }

    private Tetromino(Piece[] rotations, int actual_rotation) {
        this.shapes = rotations;
        this.actual_rotation = actual_rotation;
    }

    public String toString() {
        return shapes[actual_rotation].toString();
    }

    public Tetromino rotateRight() {
        return new Tetromino(this.shapes, (this.actual_rotation + 1) % 4);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(this.shapes, (this.actual_rotation + 3) % 4);
    }

}
