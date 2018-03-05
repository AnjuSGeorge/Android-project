package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginClick(View btn)
    {
        Intent it = new Intent(MainActivity.this,Login.class);
        startActivity(it);
    }
    public void registerClick(View btn)
    {
        Intent it = new Intent(MainActivity.this,Register.class);
        startActivity(it);
    }
}
