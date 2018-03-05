package com.example.owner.mybookreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Bookentry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookentry);
    }
    public void addClick(View btn)
    {
        String method = "AddBook";
        EditText edTitle  = (EditText) findViewById(R.id.edTitle);
        String strTitle = edTitle.getText().toString();
        EditText edAuthor  = (EditText) findViewById(R.id.edAuthor);
        String strAuthor = edAuthor.getText().toString();
        EditText edGenre  = (EditText) findViewById(R.id.edGenre);
        String strGenre = edGenre.getText().toString();
        EditText edRating  = (EditText) findViewById(R.id.edRating);
        String strRating = edRating.getText().toString();
        int rating = Integer.parseInt(strRating);
        EditText edSynopsis  = (EditText) findViewById(R.id.edSynopsis);
        String strSynopsis = edSynopsis.getText().toString();
        new SigninActivity(this).execute(method,strTitle,strAuthor,strGenre,strSynopsis,strRating);
        Log.d("sfter signin","after signing activity");

    }
}
