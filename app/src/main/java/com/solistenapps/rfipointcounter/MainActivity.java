package com.solistenapps.rfipointcounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;


public class MainActivity extends ActionBarActivity implements LogoFragment.ResetButtonListener{

    CounterFragment redCounter;
    CounterFragment blueCounter;
    CounterFragment purpleCounter;
    CounterFragment yellowCounter;

    LogoFragment logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redCounter = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.redFragment);
        blueCounter = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.blueFragment);
        purpleCounter = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.purpleFragment);
        yellowCounter = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.yellowFragment);

        logo = (LogoFragment) getSupportFragmentManager().findFragmentById(R.id.logoFragment);

        redCounter.setPlayerColor("#ff4444");
        blueCounter.setPlayerColor("#7fffd4");
        purpleCounter.setPlayerColor("#8a2be2");
        yellowCounter.setPlayerColor("#ffff66");

    }

    @Override
    public void resetCounters(int zero) {
        redCounter.resetPlayerCounter(zero);
        blueCounter.resetPlayerCounter(zero);
        purpleCounter.resetPlayerCounter(zero);
        yellowCounter.resetPlayerCounter(zero);
    }
}
