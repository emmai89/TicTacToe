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
        Bundle data = getIntent().getBundleExtra("Bundle");

        FragmentManager fm = getSupportFragmentManager();
        InfoFragment infoFragment = (InfoFragment) fm.findFragmentById(R.id.SecondFragment);


    }

}
