package com.courtney.nightmarket;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = Market.class, version = 1)
public abstract class MarketDatabase extends RoomDatabase {
    public abstract MarketDao marketDao();
    public static MarketDatabase instance = null;

    public static MarketDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MarketDatabase.class, "market-database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .build();
            fillDataFromJson(instance.marketDao(), context);
        }
        return instance;
    }

    private static void fillDataFromJson(MarketDao marketDao, Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.market);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONArray array = new JSONArray(builder.toString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject m = array.getJSONObject(i);
                Market market = new Market(m.getString("NightMarketName"),
                        m.getString("Location"),
                        m.getString("Time"));
                new Thread(() -> marketDao.insert(market)).start();
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }
}
