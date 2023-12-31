package com.manny.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class BoardFragment extends Fragment {
    private Board board;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.activity_fragmnet_board, ui, false);

        assert getArguments() != null;
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
                button.setText("");
        }

        for (Button button: buttons) {
            button.setOnClickListener(v -> {
                int[] temp = getPosition(button);

                if (!board.checkWin()) {
                    if (board.checkOccupied(temp) == null) {
                        board.addPiece(temp);
                        updateInfo();
                        if (!board.getTurn())
                            button.setText("X");
                        else
                            button.setText("O");
                    }
                }
            });
        }
        return view;
    }

    private int[] getPosition(Button button){
        String id = button.getResources().getResourceEntryName((button.getId()));
        String[] temp = id.split("_");
        return new int[]{Integer.parseInt(temp[1]), Integer.parseInt(temp[2])};
    }

    private void updateInfo()
    {
        FragmentManager fm = getParentFragmentManager();
        InfoFragment infoFragment = new InfoFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable("board", board);
        infoFragment.setArguments(bundle);

        fm.beginTransaction().replace(R.id.infoFragment, infoFragment).commit();
    }
}
