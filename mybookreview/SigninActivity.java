package com.example.owner.mybookreview;

import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Owner on 2018-02-23.
 */

public class SigninActivity extends AsyncTask<String,Integer,String> {
    private Context context;
    public  static StringBuilder newsb = new StringBuilder();
    public  static StringBuilder authsb = new StringBuilder();
    public  static StringBuilder booksb = new StringBuilder();
    public  static StringBuilder loginsb = new StringBuilder();
    public SigninActivity(Context context) {
        this.context = context;

    }

   // protected Object doInBackground(Object[] objects) {
     //   return null;
    //}
   @Override

   protected String doInBackground(String... arg0) {

            String method = (String) arg0[0];
            if (method.equals("Login")) {
                loginsb = new StringBuilder();
                try {
                    String emailid = (String) arg0[1];
                    String password = (String) arg0[2];
                    Log.d("entered", "entered background");
                    Log.d("emailid", emailid);
                    Log.d("password", password);
                    String link = "http://triosdevelopers.com/~A.George/LoginInfo.php";
                    String data = URLEncoder.encode("emailid", "UTF-8") + "=" +
                            URLEncoder.encode(emailid, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                            URLEncoder.encode(password, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                   // loginsb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        loginsb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", loginsb.toString());
                    Log.d("sbstring", "nothing to print");

                    return loginsb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
            else if (method.equals("AddBook")) {
                try {
                    String title = (String) arg0[1];
                    String author = (String) arg0[2];
                    String genre = (String) arg0[3];
                    String synopsis = (String) arg0[4];
                    String strrating = (String)arg0[5];
                    String strUser = Login.loginUserId;
                   //int rating = Integer.parseInt(strrating);
                    Log.d("entered", "entered background");
                    Log.d("title", title);
                    Log.d("author", author);
                    Log.d("genre", genre);
                    Log.d("synopsis", synopsis);

                    String link = "http://triosdevelopers.com/~A.George/AddBookToDatabase.php";
                    String data = URLEncoder.encode("title", "UTF-8") + "=" +
                            URLEncoder.encode(title, "UTF-8");
                    data += "&" + URLEncoder.encode("author", "UTF-8") + "=" +
                            URLEncoder.encode(author, "UTF-8");
                    data += "&" + URLEncoder.encode("genre", "UTF-8") + "=" +
                            URLEncoder.encode(genre, "UTF-8");
                    data += "&" + URLEncoder.encode("synopsis", "UTF-8") + "=" +
                            URLEncoder.encode(synopsis, "UTF-8");
                    data += "&" + URLEncoder.encode("rating", "UTF-8") + "=" +
                            URLEncoder.encode(strrating, "UTF-8");
                    data += "&" + URLEncoder.encode("User", "UTF-8") + "=" +
                            URLEncoder.encode(strUser, "UTF-8");

                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", sb.toString());
                    Log.d("sbstring", "nothing to print");

                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
            else if (method.equals("Register")) {
                try {
                    String email = (String) arg0[1];
                    String password = (String) arg0[2];
                    Log.d("entered", "entered background");
                    Log.d("title", email);
                    Log.d("author", password);

                    String link = "http://triosdevelopers.com/~A.George/Register.php";
                    String data = URLEncoder.encode("email", "UTF-8") + "=" +
                            URLEncoder.encode(email, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                            URLEncoder.encode(password, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", sb.toString());
                    Log.d("sbstring", "nothing to print");

                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
            else if (method.equals("AddAuthor")) {
                try {
                    String name = (String) arg0[1];
                    String details = (String) arg0[2];
                    Log.d("entered", "entered background");
                    Log.d("name", name);
                    Log.d("details", details);
                    String strUser = Login.loginUserId;

                    String link = "http://triosdevelopers.com/~A.George/AddAuthor.php";
                    String data = URLEncoder.encode("name", "UTF-8") + "=" +
                            URLEncoder.encode(name, "UTF-8");
                    data += "&" + URLEncoder.encode("details", "UTF-8") + "=" +
                            URLEncoder.encode(details, "UTF-8");
                    data += "&" + URLEncoder.encode("User", "UTF-8") + "=" +
                            URLEncoder.encode(strUser, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", sb.toString());
                    Log.d("sbstring", "nothing to print");

                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
            else if (method.equals("List")) {
                newsb = new StringBuilder();
                try {
                    String strAuthor = (String) arg0[1];
                    Log.d("entered", "entered background");
                    Log.d("AuthorinDoBackground", strAuthor);

                    String link = "http://triosdevelopers.com/~A.George/ListBooks.php";
                    String data = URLEncoder.encode("author", "UTF-8") + "=" +
                            URLEncoder.encode(strAuthor, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                     String line = null;

                   // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        newsb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", newsb.toString());
                    Log.d("sbstring", "nothing to print");

                    return newsb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }


            }
            else if (method.equals("ListAuthorInfo")) {
                authsb = new StringBuilder();
                try {
                    String strAuthor = (String) arg0[1];
                    Log.d("entered", "entered background");
                    Log.d("AuthorinDoBackground", strAuthor);

                    String link = "http://triosdevelopers.com/~A.George/SearchAuthorInfo.php";
                    String data = URLEncoder.encode("author", "UTF-8") + "=" +
                            URLEncoder.encode(strAuthor, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        authsb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", authsb.toString());
                    Log.d("sbstring", "nothing to print");

                    return authsb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }


            }

            else if (method.equals("BookInfo")) {
                booksb = new StringBuilder();
                try {
                    String strBook = (String) arg0[1];
                    Log.d("entered", "entered background");
                    Log.d("BookinDoBackground", strBook);

                    String link = "http://triosdevelopers.com/~A.George/SearchBookInfo.php";
                    String data = URLEncoder.encode("book", "UTF-8") + "=" +
                            URLEncoder.encode(strBook, "UTF-8");
                    Log.d("after getting link", "after string data");
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    Log.d("after getting link", "after output stream writer data");

                    wr.write(data);
                    wr.flush();
                    Log.d("after getting link", "after output stream writing and flushing data");

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        booksb.append(line);
                        break;
                    }
                    Log.d("after getting link", "before reurning string");
                    Log.d("sbstring", booksb.toString());
                    Log.d("sbstring", "nothing to print");

                    return booksb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }


            }       return null;
        }


    protected void onPreExecute(){
    }


    }


