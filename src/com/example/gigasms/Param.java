package com.example.gigasms;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Param extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_param, menu);
        return true;
    }
}
