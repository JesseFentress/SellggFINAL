package com.example.sellgg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

/**
 * Functions as a home page/container for drawer object to navigate the app
 */


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    public User acc;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Creates a Toolbar object assigned to the view w/ id toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Assigns drawer to the XML drawer_layout
        drawer = findViewById(R.id.drawer_layout);

        // Creates a NavigationView object assigned to the view w/ id nav_view
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Sets a navigation listener to the NavigationView made above
        navigationView.setNavigationItemSelectedListener(this);

        //
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Uses a switch statement to decide which fragment to inflate
     * @param item
     * @return true
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            // Displays the fragment_account fragment when nav_account is selected
            case R.id.nav_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AccountFragment()).commit();
                break;

            // Displays the fragment_listings fragment when nav_listings is selected
            case R.id.nav_listings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ListingsFragment()).commit();
                break;

            // Displays the fragment_search fragment when nav_search is selected
            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SearchFragment()).commit();
                break;
            // Displays the fragment_search fragment when nav_settings is selected
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Closes drawer on back press
     */
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}
