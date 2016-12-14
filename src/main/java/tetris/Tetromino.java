// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public final static Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n");

    private String shape;

    public Tetromino(String shape) {
        this.shape = shape;
    }

    public String toString() {
        return shape;
    }

    public void rotateRight() {

    }

    public void rotateLeft() {
        
    }

}
