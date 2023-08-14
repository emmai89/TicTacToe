package com.manny.tictactoe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.manny.tictactoe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TitleScreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startButton);
        TextView seed_text, goal_text;
        int seed, goal;
        Random rand = new Random();

        goal = rand.nextInt(2000) + 1; //random goal between 1 and 2000 points
        seed = rand.nextInt(goal); // the amount of points the user starts with, will be below the goal by at least 1


        start.setOnClickListener(v -> {
            Intent intent = new Intent(TitleScreen.this, GameScreen.class);
            startActivity(intent);
        });
    }
}