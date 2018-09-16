package com.example.x.cv.education_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.x.cv.R;

import java.util.ArrayList;

public class EducationActivity extends AppCompatActivity {

    String fromDataTextView[];
    String toDataTextView[];
    String specializationTextView[];
    String academicDegreeTextView[];
    String gradeTextView[];
    String donorTextView[];

    int logoForDegree[] = {R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        fetchArrays();

        final ArrayList<CustomObjectForArrays> educationHistory = new ArrayList<CustomObjectForArrays>();
        for (int index = 0; index < getResources().getStringArray(R.array.fromDateTextView).length; index++) {

            educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        }
        AdapterForCustomListViews adapter = new AdapterForCustomListViews(EducationActivity.this, R.layout.education_item_list, educationHistory);
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                startActivity(new Intent(EducationActivity.this, CertificateActivity.class).putExtra("fetchedImage", logoForDegree[position]));

            }
        });
        listView.setAdapter(adapter);
    }

    public void fetchArrays() {

        fromDataTextView = getResources().getStringArray(R.array.fromDateTextView);
        toDataTextView = getResources().getStringArray(R.array.toDateTextView);
        specializationTextView = getResources().getStringArray(R.array.specializationTextView);
        academicDegreeTextView = getResources().getStringArray(R.array.academicDegreeTextView);
        gradeTextView = getResources().getStringArray(R.array.gradeTextView);
        donorTextView = getResources().getStringArray(R.array.donorTextView);
    }

}
