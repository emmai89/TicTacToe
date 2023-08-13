package com.manny.tictactoe;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  This handles all the function=s the board needs
 */
public class Board {

    private LinkedList<Piece> x_pieces;
    private LinkedList<Piece> o_pieces;
    private boolean turn; // true is X, false is O

    public Board() {
        turn = true;
    }

    public boolean addPiece(int[] position){
        if (turn)
            x_pieces.add(new Piece(turn, position));
        else
            o_pieces.add(new Piece(turn, position));

        turn = !turn;

        return checkWin();
    }

    public boolean checkOccupied(int[] position) {
        for (Piece piece : x_pieces) {
            if(Arrays.equals(piece.getPosition(), position))
                return true;
        }
        for (Piece piece : o_pieces) {
            if(Arrays.equals(piece.getPosition(), position))
                return true;
        }
        return false;
    }

    public boolean checkWin(){
        LinkedList<Piece> pieces;
        boolean win;

        if (turn)
            pieces = x_pieces;
        else
            pieces = o_pieces;

        if (pieces.size() < 3)
            win = false;
        else
            win = checkLines(pieces);

        return win;
    }

    private boolean checkLines(LinkedList<Piece> pieces) {
        int[] counts;
        boolean win;

        win = diagonals(pieces);

        counts = straights(pieces, 0);
        if (counts[0] == 3 || counts[1] == 3 || counts[2] == 3)
            win = true;

        counts = straights(pieces, 1);
        if (counts[0] == 3 || counts[1] == 3 || counts[2] == 3)
            win = true;
        

        return win;
    }

    private int[] straights(LinkedList<Piece> pieces, int position){
        int[] counts = new int[3];
        Arrays.fill(counts, 0);
        for (Piece piece : pieces) {
            if (piece.getPosition()[position] == 0)
                counts[0]++;
            if (piece.getPosition()[position] == 1)
                counts[1]++;
            if (piece.getPosition()[position] == 2)
                counts[2]++;
        }

        return counts;
    }

    private boolean diagonals(LinkedList<Piece> pieces){
        boolean win = false;
        int count = 0;
        int count_2 = 0;
        int[][] diag = {{2,0},{1,1},{0,2}};

        for (Piece piece : pieces) {
            if (piece.getPosition()[0] == piece.getPosition()[1])
                count++;

            if (Arrays.equals(piece.getPosition(), diag[0]))
                count_2++;
            if (Arrays.equals(piece.getPosition(), diag[1]))
                count_2++;
            if (Arrays.equals(piece.getPosition(), diag[2]))
                count_2++;
        }

        if (count == 3 || count_2 == 3)
            win = true;

        return win;

    }

}
