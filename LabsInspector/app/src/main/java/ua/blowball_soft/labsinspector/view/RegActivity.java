package ua.blowball_soft.labsinspector.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ua.blowball_soft.labsinspector.R;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Intent intent = new Intent(RegActivity.this, MainScreenActivity.class);
        startActivity(intent);
        finish();
    }
}
