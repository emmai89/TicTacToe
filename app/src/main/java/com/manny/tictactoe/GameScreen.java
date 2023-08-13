package com.manny.tictactoe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Board board = new Board();

        FragmentManager fm = getSupportFragmentManager();
        InfoFragment infoFragment = (InfoFragment) fm.findFragmentById(R.id.infoFragment);
        BoardFragment boardFragment = (BoardFragment) fm.findFragmentById(R.id.boardFragment);

        if (infoFragment == null)
        {
            infoFragment = new InfoFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("board", board);
            infoFragment.setArguments(bundle);
            fm.beginTransaction().add(R.id.infoFragment, infoFragment).commit();
        }

        if (boardFragment == null)
        {
            boardFragment = new BoardFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("board", board);
            boardFragment.setArguments(bundle);
            fm.beginTransaction().add(R.id.boardFragment, boardFragment).commit();
        }
    }

}
