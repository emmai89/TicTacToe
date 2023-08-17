package com.manny.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SettingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Settings settings = Objects.requireNonNull(getIntent().getBundleExtra("bundle")).getParcelable("settings");

        Button save, cancel;
        Switch solo;
        SeekBar difficulty;
        TextView difficultyText, difficultyLevel;

        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);
        solo = findViewById(R.id.soloSwitch);
        difficulty = findViewById(R.id.difficultySeekBar);
        difficultyText = findViewById(R.id.difficultyText);
        difficultyLevel = findViewById(R.id.difficultyReadout);

        assert settings != null;
        solo.setChecked(settings.isSolo());
        difficulty.setProgress(settings.getDifficulty());
        toggle(difficultyText, difficulty, settings.isSolo(), difficultyLevel, settings);

        solo.setOnCheckedChangeListener(((compoundButton, b) -> {
            if (b) {
                settings.setSolo(b);
                toggle(difficultyText, difficulty, b, difficultyLevel, settings);
            } else {
                settings.setSolo(false);
                toggle(difficultyText, difficulty, b, difficultyLevel, settings);
            }
        }));

        cancel.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsScreen.this, TitleScreen.class);
            startActivity(intent);
        });

        save.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsScreen.this, TitleScreen.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("settings", settings);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        });

        difficulty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                settings.setDifficulty(i);
                difficultyLevel.setText(settings.getDifficultyString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void toggle(TextView difficultyText, SeekBar difficulty, Boolean solo, TextView difficultyLevel, Settings settings)
    {
        if (!solo) {
            difficultyText.setTextColor(Color.GRAY);
            difficulty.setEnabled(false);
            difficultyLevel.setVisibility(View.INVISIBLE);
        }
        else{
            difficultyText.setTextColor(Color.BLACK);
            difficulty.setEnabled(true);
            difficultyLevel.setVisibility(View.VISIBLE);
            difficultyLevel.setText(settings.getDifficultyString());
        }
    }


}