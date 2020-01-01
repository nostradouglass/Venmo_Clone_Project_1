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
import androidx.core.view.MenuCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.util.AttributeSet;
import android.view.Menu;
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


        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(drawer)
                        .build();


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

        NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.socialSlider, true).build();

        switch (menuItem.getItemId()) {
            case R.id.nav_search:
                navController.navigate(R.id.searchPeople);
                break;

            case R.id.nav_venmo_card:
                navController.navigate(R.id.venmoCard);
                break;

            case R.id.nav_scan_code:
                navController.navigate(R.id.scanCode);
                break;

            case R.id.nav_payment_methods:
                navController.navigate(R.id.paymentMethods);
                break;

            case R.id.nav_incomplete:
                navController.navigate(R.id.incomplete);
                break;

            case R.id.nav_purchases:
                navController.navigate(R.id.purchases);
                break;

            case R.id.nav_get_help:
                navController.navigate(R.id.getHelp);
                break;

            case R.id.nav_settings:
                navController.navigate(R.id.action_global_settings, null, navOptions);
                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);

        MenuCompat.setGroupDividerEnabled(menu, true);

        return true;
    }
}
