package com.courtney.nightmarket;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<MarketviewHolder> {

    List<Market> market;

    public MarketAdapter(List<Market> market) {
        this.market = market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    @NonNull
    @Override
    public MarketviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MarketviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_market, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MarketviewHolder holder, int position) {
        Market m = market.get(position);
        if (m != null) {
            holder.bindTo(m);
        }
    }

    @Override
    public int getItemCount() {
        return (market == null) ? 0 : market.size();
    }
}
