package com.example.x.cv.previous_work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.x.cv.R;
import com.example.x.cv.database.AppDatabase;
import com.example.x.cv.database.AppExecutors;
import com.example.x.cv.previous_work.data.PreviousWork;

public class AddPreviousWorkActivity extends AppCompatActivity {

    private EditText companyEditText;
    private EditText roleEditText;
    private EditText fromEditText;
    private EditText toEditText;
    private Button saveButton;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_previous_work);

        init();

    }

    private void init() {

        companyEditText = (EditText) findViewById(R.id.company_editText);
        roleEditText = (EditText) findViewById(R.id.role_editText);
        fromEditText = (EditText) findViewById(R.id.from_editText);
        toEditText = (EditText) findViewById(R.id.to_editText);
        saveButton = (Button) findViewById(R.id.save_button);

        database = AppDatabase.getInstance(getApplicationContext());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreviousWork previousWork = new PreviousWork(companyEditText.getText().toString(),
                        roleEditText.getText().toString(),
                        fromEditText.getText().toString(),
                        toEditText.getText().toString());

                saveNewPreviouswork(previousWork);

                finish();
            }
        });
    }

    private void saveNewPreviouswork(final PreviousWork previousWork) {

        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {

                database.previousWorkDao().insertPreviousWork(previousWork);
            }
        });
    }
}
