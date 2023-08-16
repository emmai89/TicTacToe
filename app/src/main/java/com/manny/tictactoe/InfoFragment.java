package com.manny.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle){
        View view = inflater.inflate(R.layout.activity_fragment_info, ui, false);

        assert getArguments() != null;
        Board board = getArguments().getParcelable("board");

        TextView turn = view.findViewById(R.id.turn);

        if (board.checkWin()) {
            if (board.getTurn())
                turn.setText("O wins");
            else
                turn.setText("X wins");
        }
        else{
            if (board.getTurn())
                turn.setText("X's Turn");
            else
                turn.setText("O's Turn");
        }
        return view;
    }
}
