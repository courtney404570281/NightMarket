package com.courtney.nightmarket;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarketviewHolder extends RecyclerView.ViewHolder {

    private final TextView nameText;
    private final TextView locationText;
    private final TextView timeText;

    public MarketviewHolder(@NonNull View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.txt_name);
        locationText = itemView.findViewById(R.id.txt_location);
        timeText = itemView.findViewById(R.id.txt_date);
    }

    public void bindTo(Market market) {
        nameText.setText(market.name);
        locationText.setText(market.location);
        timeText.setText(market.date);
    }
}
