package com.example.x.cv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView welcome;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        calling();
        handling();
    }

    void calling() {

        welcome = findViewById(R.id.welcome_textView);
        webView = findViewById(R.id.webView);
    }

    void handling() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Welcome.this);

        String fullName = "";

        fullName = sharedPreferences.getString("first", "") + " " + sharedPreferences.getString("second", "");

        welcome.append(fullName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_facebook) {

            Uri facebook = Uri.parse("https://www.facebook.com");
            Intent faceIntent = new Intent(Intent.ACTION_VIEW, facebook);
            startActivity(faceIntent);
            return true;
        } else if (item.getItemId() == R.id.action_google) {

            webView.setWebViewClient(new webView());
            webView.loadUrl("https://www.google.com");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            return true;
        } else if (item.getItemId() == R.id.action_linkedIn) {


            webView.setWebViewClient(new webView());
            webView.loadUrl("https://www.linkedIn.com");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);


            return true;

        } else if (item.getItemId() == R.id.action_previous_education) {


            return true;

        } else if (item.getItemId() == R.id.action_previous_work) {


            return true;

        } else if (item.getItemId() == R.id.action_memories) {


            return true;

        } else if (item.getItemId() == R.id.action_logout) {
            sharedPreferences.edit().clear().commit();
            startActivity(new Intent(Welcome.this, MainActivity.class));
            Toast.makeText(Welcome.this , "you are logged out",Toast.LENGTH_LONG).show();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
