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
        actual_rotation = 0;
        shapes = new Piece[4];
        this.shapes[0] = new Piece(shape);
        for(int i=1; i < 4; i++) {
            this.shapes[i] = this.shapes[i-1].rotateRight();
        }
    }

    public String toString() {
        return shapes[0].toString();
    }

    public Tetromino rotateRight() {
        actual_rotation = (actual_rotation + 1) % 4;
        return new Tetromino(shapes[actual_rotation].toString());
    }

    public void rotateLeft() {
        
    }

}
