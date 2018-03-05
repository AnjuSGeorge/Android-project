package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SelectForReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_for_review);
    }
    public void onClickAddBook(View btn)
    {
        Intent it = new Intent(SelectForReview.this,Bookentry.class);
        startActivity(it);
    }
    public void onClickAuthorInfo(View btn)
    {
        Intent it = new Intent(SelectForReview.this,AddAuthor.class);
        startActivity(it);
    }
    public void onClicksearch(View btn)
    {
        Intent it = new Intent(SelectForReview.this,ListBooks.class);
        EditText edAuthor  = (EditText) findViewById(R.id.edAuthor);
        String strAuthor = edAuthor.getText().toString();
        Log.d("inclick@@@@@@@",strAuthor);
        it.putExtra("MyAuthor",strAuthor);
        startActivity(it);
    }
    public void onClickSearchAuthInfo(View btn)
    {
        Intent it = new Intent(SelectForReview.this,AuthorInfo.class);
        startActivity(it);

    }
}
