package com.kellydouglass.venmocloneproject1;

import android.content.Context;
import android.os.Bundle;


import com.google.android.material.navigation.NavigationView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        navController = Navigation.findNavController(this, R.id.fragment_container);

       NavigationView navView = findViewById(R.id.nav_view);

       NavigationUI.setupWithNavController(navView, navController);
       navView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen((GravityCompat.START))) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        navController.navigate(R.id.socialSlider);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
