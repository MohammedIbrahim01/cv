package com.example.x.cv.previous_work.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.x.cv.previous_work.data.PreviousWork;

import java.util.List;

@Dao
public interface PreviousWorkDao {

    @Query("SELECT * FROM `previous-work-table`")
    LiveData<List<PreviousWork>> loadAllPreviousWorks();

    @Query("SELECT * From `previous-work-table` WHERE id = :id")
    PreviousWork getPreviousWorkById(int id);

    @Insert
    void insertPreviousWork(PreviousWork previousWork);

    @Delete
    void deletePreviousWork(PreviousWork previousWork);

    @Update
    void updatePreviousWork(PreviousWork previousWork);
}
