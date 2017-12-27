package com.supergeekdeveloper.idioms;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void openAlphabets(View view){
        Intent intent=new Intent(this,AlphabetActivity.class);
        startActivity(intent);
    }
    public void openCategories(View view){
        Intent intent=new Intent(this,CategoryActivity.class);
        startActivity(intent);
    }
    public void openCards(View view){
        Intent intent=new Intent(this,AlphabetActivity.class);

    }
}
