package com.example.fragmentsinterface;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AFragment.FragmentAListener, BFragment.FragmentBListener {

    private AFragment aFragment;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aFragment = new AFragment();
        bFragment = new BFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, aFragment)
                .replace(R.id.container_b, bFragment)
                .commit();
    }

    @Override
    public void onInputASent(String input) {
        bFragment.updateEditText(input);
    }

    @Override
    public void onInputBSent(String input) {
        aFragment.updateEditText(input);
    }
}