package com.example.x.cv.education_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.x.cv.R;

import java.util.List;

public class AdapterForCustomListViews extends ArrayAdapter<CustomObjectForArrays> {


    public AdapterForCustomListViews(@NonNull Context context, int resource, @NonNull List<CustomObjectForArrays> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.education_item_list, parent, false);
        }
        CustomObjectForArrays current = getItem(position);
        TextView fromDateTextView = listItemView.findViewById(R.id.fromDateTextView);
        fromDateTextView.setText(current.getFromDataTextView());
        TextView toDateTextView = listItemView.findViewById(R.id.toDateTextView);
        toDateTextView.setText(current.getToDateTextView());
        TextView specializationTextView = listItemView.findViewById(R.id.specializationTextView);
        specializationTextView.setText(current.getSpecializationTextView());
        TextView academicDegreeTextView = listItemView.findViewById(R.id.academicDegreeTextView);
        academicDegreeTextView.setText(current.getAcademicDegreeTextView());
        TextView gradeTextView = listItemView.findViewById(R.id.gradeTextView);
        gradeTextView.setText(current.getGradeTextView());
        TextView donorTextView = listItemView.findViewById(R.id.donorTextView);
        donorTextView.setText(current.getDonorTextView());
        ImageView logoForDegree = listItemView.findViewById(R.id.logoForDegree);
        logoForDegree.setImageResource(current.logoForDegree);
        
        return listItemView;
    }


}




