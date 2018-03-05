package com.example.owner.mybookreview;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Owner on 2018-02-26.
 */

public class AddBookReview extends AsyncTask<String,Integer,String> {
    private Context context;
    public AddBookReview(Context context) {
        this.context = context;

    }
    @Override
    protected String doInBackground(String... arg0) {
        try{
            String title = (String)arg0[0];
            String author = (String)arg0[1];
            String genre = (String)arg0[2];
            String synopsis = (String)arg0[3];
            Log.d("entered", "entered background");
            Log.d("title",title);
            Log.d("author",author);
            Log.d("genre",genre);
            Log.d("synopsis",synopsis);

            String link="http://triosdevelopers.com/~A.George/AddBookToDatabase.php";
            String data  = URLEncoder.encode("title", "UTF-8") + "=" +
                    URLEncoder.encode(title, "UTF-8");
            data += "&" + URLEncoder.encode("author", "UTF-8") + "=" +
                    URLEncoder.encode(author, "UTF-8");
            data += "&" + URLEncoder.encode("genre", "UTF-8") + "=" +
                    URLEncoder.encode(genre, "UTF-8");
            data += "&" + URLEncoder.encode("synopsis", "UTF-8") + "=" +
                    URLEncoder.encode(synopsis, "UTF-8");
            Log.d("after getting link","after string data");
            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            Log.d("after getting link","after output stream writer data");

            wr.write( data );
            wr.flush();
            Log.d("after getting link","after output stream writing and flushing data");

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            Log.d("after getting link","before reurning string");
            Log.d("sbstring",sb.toString());
            Log.d("sbstring","nothing to print");

            return sb.toString();
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }


  /*  @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }*/
}
