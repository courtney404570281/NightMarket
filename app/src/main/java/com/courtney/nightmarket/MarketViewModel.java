package com.courtney.nightmarket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MarketViewModel extends AndroidViewModel {
    LiveData<List<Market>> market;
    private MarketDao marketDao;

    public MarketViewModel(@NonNull Application application) {
        super(application);
        marketDao = MarketDatabase.getInstance(application.getApplicationContext())
                .marketDao();
        market = marketDao.getMarket();
    }

    public LiveData<List<Market>> getMarket() {
        return market;
    }
}
