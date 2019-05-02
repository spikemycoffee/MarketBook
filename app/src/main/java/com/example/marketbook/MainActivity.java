package com.example.marketbook;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.marketbook.Fragments.GroupsFragment;
import com.example.marketbook.Fragments.MapsFrag;
import com.example.marketbook.Fragments.ProfileFragment;
import com.example.marketbook.Fragments.TimeLineFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView.setSelectedItemId(R.id.action_map);

        //choosing on the fragment view depending on the icon id pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = new MapsFrag();
                switch (menuItem.getItemId()) {
                    case R.id.action_map:
                        fragment = new MapsFrag();
                        break;
                    case R.id.action_news_feed:
                        fragment = new TimeLineFragment();
                        break;
                    case R.id.action_group:
                        fragment = new GroupsFragment();
                        break;
                    case R.id.action_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.action_settings:
                        break;
                    default:
                        break;
                }
                //telling the manager what to replace the container with and commit immiediatly
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
    }
}
