package ua.blowball_soft.labsinspector.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import ua.blowball_soft.labsinspector.R;

public class MainScreenActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    public Fragment allLabsFragment;
    public Fragment subjectsFragment;
    public Fragment searchFragment;
    public Fragment profileFragment;

    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        fragmentManager = getSupportFragmentManager();

        allLabsFragment = new AllLabsFragment();
        subjectsFragment = new SubjectsFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();

        bnv = findViewById(R.id.main_screen_btn_navigation_menu);
        bnv.setOnNavigationItemSelectedListener(getBottomNavigationListener());

        if (savedInstanceState == null) {
            allLabsFragment = new AllLabsFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.main_screen_container, allLabsFragment, AllLabsFragment.TAG)
                    .commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener getBottomNavigationListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_all_labs:
                        if (fragmentManager.findFragmentByTag(AllLabsFragment.TAG) == null) {
                            fragmentManager.beginTransaction()
                                    .replace(R.id.main_screen_container, allLabsFragment, AllLabsFragment.TAG)
                                    .commit();
                        }
                        break;
                    case R.id.action_subject:
                        if (fragmentManager.findFragmentByTag(SubjectsFragment.TAG) == null) {
                            fragmentManager.beginTransaction()
                                    .replace(R.id.main_screen_container, subjectsFragment, SubjectsFragment.TAG)
                                    .commit();
                        }
                        break;
                    case R.id.action_search:
                        if (fragmentManager.findFragmentByTag(SearchFragment.TAG) == null) {
                            fragmentManager.beginTransaction()
                                    .replace(R.id.main_screen_container, searchFragment, SearchFragment.TAG)
                                    .commit();
                        }
                        break;
                    case R.id.action_profile:
                        if (fragmentManager.findFragmentByTag(ProfileFragment.TAG) == null) {
                            fragmentManager.beginTransaction()
                                    .replace(R.id.main_screen_container, profileFragment, ProfileFragment.TAG)
                                    .commit();
                        }
                        break;
                }
                return true;
            }
        };
    }
}
