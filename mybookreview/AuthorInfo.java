package com.example.owner.mybookreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_info);
    }
    public void onClickSearch(View btn)
    {
        EditText edAuthor = (EditText) findViewById(R.id.edAuthName);
        String strAuthor = edAuthor.getText().toString();
        String method = "ListAuthorInfo";
        String authDispInfo = "";
        new SigninActivity(this).execute(method,strAuthor);
        EditText edInfo = (EditText)findViewById(R.id.edAuthorInfo);
        String myResultStr = SigninActivity.authsb.toString();
        try {
            JSONArray jsonArray = new JSONArray(myResultStr);
            for (int i = 0; i < (jsonArray.length()); i++) {
                JSONObject row = jsonArray.getJSONObject(i);
                authDispInfo = row.getString("Details");
            }

        }
        catch(JSONException e)
        {
            Log.d("excep@@@@",e.toString());

        }
        edInfo.setText(authDispInfo);

    }
}
