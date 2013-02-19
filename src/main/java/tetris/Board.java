package tetris;

import java.util.Arrays;

public class Board implements Grid {

    private final int rows;
    private final int columns;
    private final char[][] stationary;

    private Grid falling;
    private int fallingRow;
    private int fallingCol = 1;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stationary = createEmptyBoard(rows, columns);
    }

    private static char[][] createEmptyBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, Grid.EMPTY);
        }
        return board;
    }

    public String toString() {
        return Grids.format(this);
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }

    public char colorAt(int row, int col) {
        if (hasFallingAt(row, col)) {
            return falling.colorAt(0, 0);
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        return hasFalling() && row == fallingRow && col == fallingCol;
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Grid block) {
        if (hasFalling()) {
            throw new IllegalStateException("The board has an already falling block");
        }
        this.falling = block;
        this.fallingRow = 0;
    }

    public void tick() {
        int nextRow = fallingRow + 1;
        int nextCol = fallingCol;
        if (isInsideBoard(nextRow) && isEmpty(nextRow, nextCol)) {
            fallingRow = nextRow;
        } else {
            stopFalling();
        }
    }

    private boolean isInsideBoard(int row) {
        return row < rows;
    }

    private boolean isEmpty(int row, int col) {
        return colorAt(row, col) == Grid.EMPTY;
    }

    private void stopFalling() {
        stationary[fallingRow][fallingCol] = falling.colorAt(0, 0);
        falling = null;
    }
}
