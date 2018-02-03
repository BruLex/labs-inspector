package ua.blowball_soft.labsinspector.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ua.blowball_soft.labsinspector.R;

public class MainScreenActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        fragmentManager = getSupportFragmentManager();

        Fragment fragmentSubjects = fragmentManager.findFragmentById(R.id.main_screen_container);
        if (fragmentSubjects == null) {
            fragmentSubjects = new SubjectsFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.main_screen_container, fragmentSubjects)
                    .commit();
        }
    }
}
