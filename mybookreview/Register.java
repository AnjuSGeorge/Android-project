package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void RegisterClick(View btn)
    {
        String method="Register";
         EditText edEmail  = (EditText) findViewById(R.id.edEmailId);
        String strEmail = edEmail.getText().toString();
        EditText edPassword  = (EditText) findViewById(R.id.edPassword);
        String strPassword = edPassword.getText().toString();
        EditText edConfPassword  = (EditText) findViewById(R.id.edConfPassword);
        String strConfPassword = edConfPassword.getText().toString();
        if (!(strPassword.equals(strConfPassword))) {
            Toast.makeText(Register.this, "The passwords do not match", Toast.LENGTH_LONG).show();
        }
        else {
            new SigninActivity(this).execute(method,strEmail,strPassword);
            Intent it = new Intent(Register.this,Login.class);
            startActivity(it);

        }

    }
}
