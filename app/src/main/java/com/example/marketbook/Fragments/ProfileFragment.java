package com.example.marketbook.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketbook.Fragments.ContactsFragment;
import com.example.marketbook.Fragments.GroupsFragment;
import com.example.marketbook.Fragments.ListingsFragment;
import com.example.marketbook.Fragments.MapsFrag;
import com.example.marketbook.Fragments.TimeLineFragment;
import com.example.marketbook.R;
import com.google.android.gms.dynamic.SupportFragmentWrapper;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myFrag = inflater.inflate(R.layout.activity_profile, container, false);

        BottomNavigationView bottomNavigationView = myFrag.findViewById(R.id.bottom_profile_navigation);
        final FragmentManager fragmentManager = getFragmentManager();

        Fragment fragment = new ContactsFragment();
        fragmentManager.beginTransaction().replace(R.id.pFContainer, fragment).commit();

        //choosing on the fragment view depending on the icon id pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = new ListingsFragment();
                switch (menuItem.getItemId()) {
                    case R.id.action_contacts:
                        fragment = new ContactsFragment();
                        break;
                    case R.id.action_listings:
                        fragment = new ListingsFragment();
                        break;
                    default:
                        break;
                }
                //telling the manager what to replace the container with and commit immiediatly
                fragmentManager.beginTransaction().replace(R.id.pFContainer, fragment).commit();
                return true;
            }
        });

         return myFrag;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
