package com.manny.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.LinkedList;

public class BoardFragment extends Fragment {
    private Board board;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.activity_fragmnet_board, ui, false);

        board = getArguments().getParcelable("board");
        Button[] buttons = {view.findViewById(R.id.text_0_0), view.findViewById(R.id.text_0_1), view.findViewById(R.id.text_0_2),
                            view.findViewById(R.id.text_1_0), view.findViewById(R.id.text_1_1), view.findViewById(R.id.text_1_2),
                            view.findViewById(R.id.text_2_0), view.findViewById(R.id.text_2_1), view.findViewById(R.id.text_2_2)};

        for (Button button : buttons) {
            Piece piece = board.checkOccupied(getPosition(button));
            if ( piece != null)
            {
                if (piece.getShape())
                    button.setText("X");
                else
                    button.setText("Y");
            }
            else
                button.setText("Click");
        }

        for (Button button: buttons) {
            button.setOnClickListener(v -> {
                System.out.println("oi ");
                int[] temp = getPosition(button);
                Piece piece = board.checkOccupied(temp);
                System.out.println(temp[0] +"," +temp[1]);
                board.addPiece(temp);
                if (piece != null) {
                    if (piece.getShape())
                        button.setText("X");
                    else
                        button.setText("Y");

                }
            });
        }
        return view;
    }

    private int[] getPosition(Button button){
        String id = button.getResources().getResourceEntryName((button.getId()));
        String[] temp = id.split("_");
        int[] pos = {Integer.valueOf(temp[1]), Integer.valueOf(temp[2])};
        return pos;
    }

}
