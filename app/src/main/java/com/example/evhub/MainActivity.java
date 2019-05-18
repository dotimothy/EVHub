package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Class which initates the whole app
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    /**
     * Method which creates the main fragments which is the home app
     * @param savedInstanceState the current state of which fragment it is in
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new Home());
        final BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    /**
     * Method which determines which fragment the bottom nav will go to.
     * @param item the fragment to switch to
     */
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new Home();
                break;

            case R.id.navigation_social:
                fragment = new Social();
                break;

            case R.id.navigation_schoolloop:
                fragment = new Schoolloop();
                break;

            case R.id.navigation_notifications:
                fragment = new Notifications();
                break;
        }
        return loadFragment(fragment);
    }

    /**
     * Method which loads the fragment in the app
     * @param fragment the fragment to be loaded
     * @return if the fragment should be loaded or not
     */
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    /**
     * Method which allows for the back button to be pressed in the app.
     */
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}


