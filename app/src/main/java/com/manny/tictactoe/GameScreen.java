package com.manny.tictactoe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Settings settings = Objects.requireNonNull(getIntent().getBundleExtra("bundle")).getParcelable("settings");
        Board board = new Board(settings);


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
