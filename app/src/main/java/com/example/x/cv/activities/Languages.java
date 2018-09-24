package com.example.x.cv.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.x.cv.R;


public class Languages extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_languages, container, false);

        FloatingActionButton Fab = (FloatingActionButton)view.findViewById(R.id.fab_icon);

       Fab.setOnClickListener(addLanguage_popup());


        return view;

    }

    private View.OnClickListener addLanguage_popup() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog Add_language = new Dialog(getActivity());
                Add_language.requestWindowFeature(Window.FEATURE_NO_TITLE);
                //Add_language.addContentView(View view,R.layout.languages_popup);
                //Add_language.addContentView(R.layout.languages_popup);
                Add_language.show();

                TextView title = (TextView)Add_language.findViewById(R.id.Lang_title);
                EditText Language = (EditText)Add_language.findViewById(R.id.add_text);
                EditText Level = (EditText)Add_language.findViewById(R.id.level);

                Button Add = (Button)Add_language.findViewById(R.id.add_btn);
                Button Cancel = (Button)Add_language.findViewById(R.id.cancel_btn);

            }
        };
    }


}

