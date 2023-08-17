package com.manny.tictactoe;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Settings implements Parcelable {
    private boolean solo; // true is solo
    private int difficulty;

    public Settings(boolean solo, int difficulty) {
        this.solo = solo;
        this.difficulty = difficulty;
    }

    protected Settings(Parcel in) {
        solo = in.readByte() != 0;
        difficulty = in.readInt();
    }

    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };

    public boolean isSolo() {
        return solo;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public void setSolo(boolean solo) {
        this.solo = solo;
    }

    public int getPlayers(){
        if (solo)
            return 1;
        else
            return 2;
    }

    public String getDifficultyString() {
        if (!solo)
            return "N/A";
        else if (difficulty == 0)
            return "easy";
        else if (difficulty == 1)
            return "medium";
        else
            return "hard";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (solo ? 1 : 0));
        parcel.writeInt(difficulty);
    }
}
