package com.example.x.cv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText first, second, email, pass;
    private Button submit;
    private CheckBox rem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        if (sharedPreferences.getString("data", "").equals("done")) {

            startActivity(new Intent(MainActivity.this, Welcome.class));
            finish();
        }


        calling();
        handling();
    }

    private void calling() {

        first = (EditText) findViewById(R.id.first_name_editText);
        second = (EditText) findViewById(R.id.last_name_editText);
        email = (EditText) findViewById(R.id.email_editText);
        pass = (EditText) findViewById(R.id.password_editText);

        submit = (Button) findViewById(R.id.submit_button);

        rem = (CheckBox) findViewById(R.id.rem_check);
    }

    void handling() {


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sharedPreferences.edit().putString("first", first.getText().toString()).commit();
                sharedPreferences.edit().putString("second", second.getText().toString()).commit();
                sharedPreferences.edit().putString("email", email.getText().toString()).commit();
                sharedPreferences.edit().putString("pass", pass.getText().toString()).commit();
                sharedPreferences.edit().putString("data", "done").commit();

                Intent i = new Intent(MainActivity.this, Welcome.class);
                startActivity(i);
            }
        });

    }
}
