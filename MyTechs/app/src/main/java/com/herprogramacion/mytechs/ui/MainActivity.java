package com.herprogramacion.mytechs.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herprogramacion.mytechs.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, MainFragment.class.getSimpleName())
                    .commit();

        }

    }
}
