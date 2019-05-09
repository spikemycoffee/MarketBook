package com.example.marketbook.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marketbook.AddListing;

import com.example.marketbook.R;

public class ProfileFragment extends Fragment {
    //TODO: This is going to need a inner fragment for the listings and contacts


    private final String TAG = "ProfileFragment";

    Button btnAddListing;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View profileView = inflater.inflate(R.layout.activity_profile, container, false);
        btnAddListing = profileView.findViewById(R.id.btnAddListing);

        btnAddListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddListing();
            }
        });

        return profileView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    private void goAddListing() {
        Log.d(TAG,"Navigating to MainActivity");
        Intent i = new Intent(getActivity(), AddListing.class);
        startActivity(i);

    }
}
