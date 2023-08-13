package com.manny.tictactoe;

public class Piece {

    private boolean shape;
    private int[] position;

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
