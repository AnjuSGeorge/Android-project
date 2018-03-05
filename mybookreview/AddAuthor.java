package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddAuthor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_author);
    }
    public void btnAddClick(View btn) {
        String method = "AddAuthor";
        EditText edName  = (EditText) findViewById(R.id.edName);
        String strName = edName.getText().toString();
        EditText edDetails  = (EditText) findViewById(R.id.edDetails);
        String strDetails = edDetails.getText().toString();
        new SigninActivity(this).execute(method,strName,strDetails);
        Log.d("sfter signin","after signing activity");
        Intent it = new Intent(AddAuthor.this,SelectForReview.class);
        startActivity(it);
    }

}
