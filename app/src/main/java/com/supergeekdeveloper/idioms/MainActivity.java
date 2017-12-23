package com.supergeekdeveloper.idioms;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar a=getActionBar();
        if(a==null)
            Log.e("abc","dfdf00");
        else Log.e("fdf0","fddf");

    }
}
