package com.manny.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {
    private Board board;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle){
        View view = inflater.inflate(R.layout.activity_fragment_info, ui, false);

        board = getArguments().getParcelable("board");

        TextView turn = view.findViewById(R.id.turn);

        if (board.getTurn())
            turn.setText("X's Turn");
        else
            turn.setText("Y's Turn");

        return view;
    }

    private void displayTurn() {

    }
}
