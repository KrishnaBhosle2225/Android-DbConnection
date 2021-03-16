package com.krishna.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnCheck;
    final private String webUrl = "http://10.0.2.2/android_PHP/DatabaseConnection.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkConnection();
            }
        });

    }

    private void checkConnection() {

        StringRequest request = new StringRequest(Request.Method.POST, webUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(MainActivity.this, "Connection got success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Connection failed..", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }
}