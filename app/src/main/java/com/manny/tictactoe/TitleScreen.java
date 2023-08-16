package com.manny.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startButton);

        start.setOnClickListener(v -> {
            Intent intent = new Intent(TitleScreen.this, GameScreen.class);
            startActivity(intent);
        });
    }
}