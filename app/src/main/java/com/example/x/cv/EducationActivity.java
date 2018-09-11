package com.example.x.cv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class EducationActivity extends AppCompatActivity {

    String fromDataTextView[] ;
    String toDataTextView[] ;
    String specializationTextView[] ;
    String academicDegreeTextView[];
    String gradeTextView[];
    String donorTextView[];
    int logoForDegree[] = {R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo, R.drawable.zlogo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        fechArrays();
        ArrayList<CustomObjectForArrays> educationHistory = new ArrayList<CustomObjectForArrays>();
        int index = 0;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index++;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index++;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index++;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index++;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index++;
        educationHistory.add(new CustomObjectForArrays(fromDataTextView[index], toDataTextView[index], specializationTextView[index], academicDegreeTextView[index], gradeTextView[index], donorTextView[index], logoForDegree[index]));
        index=0;
        AdapterForCustomListViews adapter = new AdapterForCustomListViews(EducationActivity.this,R.layout.education_item_list,educationHistory);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
    public void fechArrays(){
        fromDataTextView = getResources().getStringArray(R.array.fromDataTextView);
        toDataTextView = getResources().getStringArray(R.array.toDataTextView);
         specializationTextView = getResources().getStringArray(R.array.specializationTextView);
        academicDegreeTextView = getResources().getStringArray(R.array.academicDegreeTextView);
         gradeTextView = getResources().getStringArray(R.array.gradeTextView);
         donorTextView = getResources().getStringArray(R.array.donorTextView);
    }
}
