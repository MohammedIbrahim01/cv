package com.example.x.cv.previous_work.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.x.cv.database.AppDatabase;
import com.example.x.cv.previous_work.data.PreviousWork;

import java.util.List;

public class PreviousWorkViewModel extends AndroidViewModel {

    private LiveData<List<PreviousWork>> previousWorkList;

    public PreviousWorkViewModel(@NonNull Application application) {
        super(application);

        AppDatabase database = AppDatabase.getInstance(application);
        previousWorkList = database.previousWorkDao().loadAllPreviousWorks();
    }

    public LiveData<List<PreviousWork>> getPreviousWorkList() {
        return previousWorkList;
    }
}
