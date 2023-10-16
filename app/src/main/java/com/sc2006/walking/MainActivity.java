package com.sc2006.walking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    PostingFragment postingFragment = new PostingFragment();
    RouteSuggestorFragment routeSuggestorFragment = new RouteSuggestorFragment();
    RouteHistoryFragment routeHistoryFragment = new RouteHistoryFragment();
    ProfileFragment profileFragment= new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,postingFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                int id=item.getItemId();
                if(id ==R.id.posting){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,postingFragment).commit();
                    return true;
                }
                else if(id== R.id.route_sug){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,routeSuggestorFragment).commit();
                    return true;
                }
                else if(id== R.id.route_hist){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,routeHistoryFragment).commit();
                    return true;
                }
                else if(id== R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                    return true;
                }

                return false;
            }
        });
    }
}