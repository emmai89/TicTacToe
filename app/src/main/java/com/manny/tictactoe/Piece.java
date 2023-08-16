package com.manny.tictactoe;

public class Piece {

    private final boolean shape;
    private final int[] position;

    public Piece(boolean shape, int[] position){
        this.shape = shape;
        this.position = position;
    }

    public boolean getShape(){
        return shape;
    }

    public int[] getPosition() {
        return position;
    }
}
