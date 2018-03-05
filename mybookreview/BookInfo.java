package com.example.owner.mybookreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        String method= "BookInfo";
        Bundle data = getIntent().getExtras();
        String strBook = data.getString("MyBook");
        String Title ="";
        String Authorst ="";
        String Rating = "";
        String Synopsis = "";
        new SigninActivity(this).execute(method,strBook);
        EditText edAuthor = (EditText)findViewById(R.id.edAuthor);
        EditText edRating = (EditText)findViewById(R.id.edRating);
        EditText edSynopsis = (EditText)findViewById(R.id.edSynopsis);
        TextView txtTitle = (TextView)findViewById(R.id.txtTitle);
        String myResultStr = SigninActivity.booksb.toString();
        try {
            JSONArray jsonArray = new JSONArray(myResultStr);
            for (int i = 0; i < (jsonArray.length()); i++) {
                JSONObject row = jsonArray.getJSONObject(i);
                Title = row.getString("Title");
                Authorst = row.getString("Author");
                Rating = row.getString("Rating");
                Synopsis = row.getString("Synopsis");
            }

        }
        catch(JSONException e)
        {
            Log.d("excep@@@@",e.toString());

        }
        edAuthor.setText(Authorst);
        edRating.setText(Rating);
        edSynopsis.setText(Synopsis);
        txtTitle.setText(Title);

    }
}
