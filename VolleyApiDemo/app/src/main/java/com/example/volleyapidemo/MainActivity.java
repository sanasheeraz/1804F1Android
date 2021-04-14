package com.example.volleyapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText edName;
    Button btnDisplay;
    TextView txtTitle,txtYear;
    ImageView imgPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        edName = findViewById(R.id.edName);
        txtTitle = findViewById(R.id.title);
        txtYear = findViewById(R.id.year);
        imgPoster = findViewById(R.id.poster);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                //String url = "http://www.omdbapi.com/?apikey=10300b14&t=" + edName.getText().toString();
                String url = "http://10.0.2.2:82/ajaxcrud/ajax.php";

                JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String result="";
                        try {
                        for (int i=0;i<=response.length();i++) {
                            Log.d("Data "+i,response.toString());
                            JSONObject json= response.getJSONObject(i);
                            result+=json.getString("Name");
                        }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        txtTitle.setText(result);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

//                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("Response Data ",response.toString());
//                            txtTitle.setText(response.getString("Title"));
//                            txtYear.setText(response.getString("Year"));
//
//                            URL urlConnection = new URL(response.getString("Poster"));
//                            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
//                            connection.setDoInput(true);
//                            connection.connect();
//                            InputStream input = connection.getInputStream();
//                            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//
//                            imgPoster.setImageBitmap(myBitmap);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_SHORT).show();
//                    }
//                });
                queue.add(request);
            }

        });

    }
}