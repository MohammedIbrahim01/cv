package com.example.x.cv.previous_work;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.x.cv.R;
import com.example.x.cv.previous_work.data.PreviousWork;
import com.example.x.cv.previous_work.data.PreviousWorkViewModel;

import java.util.List;

public class PreviousWorkActivity extends AppCompatActivity {

    private RecyclerView previousWorkRecyclerView;
    private FloatingActionButton addFab;
    private PreviousWorkAdapter previousWorkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_work);

        previousWorkRecyclerView = (RecyclerView) findViewById(R.id.previous_work_recyclerView);
        addFab = (FloatingActionButton) findViewById(R.id.add_fab);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PreviousWorkActivity.this, AddPreviousWorkActivity.class));
            }
        });

        previousWorkAdapter = new PreviousWorkAdapter();
        previousWorkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        previousWorkRecyclerView.setHasFixedSize(true);
        previousWorkRecyclerView.setAdapter(previousWorkAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.previous_work_devider));
        previousWorkRecyclerView.addItemDecoration(dividerItemDecoration);

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
