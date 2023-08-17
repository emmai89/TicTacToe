package com.manny.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start, options;
        TextView settingtext;

        start = findViewById(R.id.startButton);
        options = findViewById(R.id.optionsButton);
        settingtext = findViewById(R.id.optionsText);

        Settings settings;
        Bundle data;

        data = getIntent().getBundleExtra("bundle");
        if (data == null)
            settings = new Settings(false, 0);
        else
            settings = data.getParcelable("settings");


        assert settings != null;
        settingtext.setText("Player(s): " +settings.getPlayers() +"\nDifficulty: " +settings.getDifficultyString());

        start.setOnClickListener(v -> {
            Intent intent = new Intent(TitleScreen.this, GameScreen.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("settings", settings);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        });

        options.setOnClickListener(v -> {
            Intent intent = new Intent(TitleScreen.this, SettingsScreen.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("settings", settings);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        });
    }
}