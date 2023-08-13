package com.manny.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle){
        View view = inflater.inflate(R.layout.activity_fragment_info, ui, false);


        return view;
    }

}
