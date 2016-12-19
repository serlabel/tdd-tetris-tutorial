// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public final static Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n", 4);
    public final static Tetromino I_SHAPE = new Tetromino("" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n", 2);

    private Piece[] shapes;
    private int actual_rotation;
    private int num_rotations;

    public Tetromino(String shape, int n_rotations) {
        this.actual_rotation = 0;
        this.num_rotations = n_rotations;
        shapes = new Piece[n_rotations];
        this.shapes[0] = new Piece(shape);
        for(int i=1; i < n_rotations; i++) {
            this.shapes[i] = this.shapes[i-1].rotateRight();
        }
    }

    private Tetromino(Piece[] rotations, int actual_rotation) {
        this.shapes = rotations;
        this.actual_rotation = actual_rotation;
        this.num_rotations = rotations.length;
    }

    public String toString() {
        return shapes[actual_rotation].toString();
    }

    public Tetromino rotateRight() {
        return new Tetromino(this.shapes,
                (this.actual_rotation + 1) % this.num_rotations);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(this.shapes,
                (this.actual_rotation + this.num_rotations - 1) % this.num_rotations);
    }

}
