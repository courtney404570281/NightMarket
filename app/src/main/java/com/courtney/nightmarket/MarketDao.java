package com.courtney.nightmarket;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MarketDao {
    @Query("SELECT * FROM market")
    LiveData<List<Market>> getMarket();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Market market);

    @Delete
    void delete(Market market);
}
