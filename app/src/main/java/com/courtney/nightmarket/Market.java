package com.courtney.nightmarket;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Market {
    @PrimaryKey
    @NonNull
    String name;
    @NonNull
    String location;
    @NonNull
    String date;

    public Market(@NonNull String name, @NonNull String location, @NonNull String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    public void setLocation(@NonNull String location) {
        this.location = location;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }
}
