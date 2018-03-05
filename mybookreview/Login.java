package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    public  static String loginUserId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUserId = "";
    }

    public void loginClick(View btn) {
        EditText edEmail = (EditText) findViewById(R.id.edEmail);
        String strUserName = edEmail.getText().toString();
        EditText edPassword = (EditText) findViewById(R.id.edPassword);
        String strPassword = edPassword.getText().toString();
        String method = "Login";
        String UserId = "";
        String emailid = "";
        new SigninActivity(this).execute(method, strUserName, strPassword);
        Log.d("sfter signin", "after signing activity");
        String myResultStr = SigninActivity.loginsb.toString();
        //System.out.println("FGGHFSGFGFSGS"+myResultStr);
       // Toast.makeText(Login.this, myResultStr, Toast.LENGTH_LONG).show();
        try {
            JSONArray jsonArray = new JSONArray(myResultStr);
            for (int i = 0; i < (jsonArray.length()); i++) {
                JSONObject row = jsonArray.getJSONObject(i);
                UserId = row.getString("UserId");
                Log.d("USERID%%%%%%","Inside for loop");
                emailid = row.getString("EmailId");

            }

        } catch (JSONException e) {
            Log.d("excep@@@@", e.toString());

        }
        Log.d("USERID%%%%%%",UserId);
        if (UserId == "") {
            Toast.makeText(Login.this, "The userId doesnt exist", Toast.LENGTH_LONG).show();
        } else {
            loginUserId = UserId;
            Intent it = new Intent(Login.this, SelectForReview.class);
            startActivity(it);
        }
    }
}
