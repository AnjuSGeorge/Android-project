package com.example.owner.mybookreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);
        Log.d("From the search page","##########from the search page");
        String method= "List";
        List BookList = new ArrayList();
      //  String myResultStr="";
        Bundle data = getIntent().getExtras();
        String strAuthor = data.getString("MyAuthor");
        TextView tvAuth = (TextView) findViewById(R.id.txtAuth);
        tvAuth.setText(strAuthor);
        Log.d("########Author",strAuthor);
        new SigninActivity(this).execute(method,strAuthor);
        ListView lv = (ListView) findViewById(R.id.lstBookView);

        TextView tview = (TextView)findViewById(R.id.txtTest);
        String myResultStr = SigninActivity.newsb.toString();
        String strMyTitle = "";
            ArrayAdapter<String> myarrayAdapter ;
        try
        {
        JSONArray jsonArray = new JSONArray(myResultStr);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

         for (int i = 0; i < (jsonArray.length()); i++) {
                JSONObject row = jsonArray.getJSONObject(i);
                strMyTitle = row.getString("Title");
              //  strMyAuthor = row.getString("Author");
                BookList.add(strMyTitle);
         }
          tview.setText(jsonObject.getString("Title"));

          /*  if (jsonArray.length()>0) {
                myarrayAdapter = new ArrayAdapter<String>(this, R.layout.rowlayout,
                        R.id.edTitle, BookList);
                lv.setAdapter(myarrayAdapter);
            }
            else {
                String myEmpty = "Nothing to display";
                BookList.add(myEmpty);
                myarrayAdapter = new ArrayAdapter<String>(this, R.layout.rowlayout,
                        R.id.edTitle,BookList );
                lv.setAdapter(myarrayAdapter);

            }*/

        }
        catch(JSONException e)
        {
            Log.d("excep@@@@",e.toString());
            tview.setText(e.toString());
        }

        myarrayAdapter = new ArrayAdapter<String>(this, R.layout.rowlayout,
                R.id.edTitle, BookList);
        lv.setAdapter(myarrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_LONG).show();
                //  Log.d("InListener","inlistener");
                String str =  parent.getAdapter().getItem(position).toString();
                //        dbHelper.deleteNote();
                Log.d("InListenerItem",str);
                //Toast.makeText(ListTask.this,"Deleted successfully, Go back and list to view",Toast.LENGTH_LONG).show();
                Intent it = new Intent(ListBooks.this,BookInfo.class);
                it.putExtra("MyBook",str);
                startActivity(it);

            }
        });




    }
}
