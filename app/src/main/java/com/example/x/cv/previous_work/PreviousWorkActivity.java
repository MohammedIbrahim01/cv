package com.example.x.cv.previous_work;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.x.cv.R;

import java.util.ArrayList;
import java.util.List;

public class PreviousWorkActivity extends AppCompatActivity {

    private RecyclerView previousWorkRecyclerView;
    private PreviousWorkAdapter previousWorkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_work);

        previousWorkRecyclerView = findViewById(R.id.previous_work_recyclerView);

        previousWorkAdapter = new PreviousWorkAdapter();
        previousWorkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        previousWorkRecyclerView.setHasFixedSize(true);
        previousWorkRecyclerView.setAdapter(previousWorkAdapter);

        setupPreviousWorkViewModel();
    }

    private void setupPreviousWorkViewModel() {

        PreviousWorkViewModel previousWorkViewModel = ViewModelProviders.of(this).get(PreviousWorkViewModel.class);
        previousWorkViewModel.getPreviousWorkList().observe(this, new Observer<List<PreviousWork>>() {
            @Override
            public void onChanged(@Nullable List<PreviousWork> previousWorks) {

                previousWorkAdapter.setPreviousWorkList(previousWorks);
                previousWorkAdapter.notifyDataSetChanged();
            }
        });
    }
}
